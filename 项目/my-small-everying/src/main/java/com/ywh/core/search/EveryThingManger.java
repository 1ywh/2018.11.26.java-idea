package com.ywh.core.search;

import com.ywh.config.EverythingConfig;
import com.ywh.core.dao.DataBaseFactory;
import com.ywh.core.dao.NoLimitDaoImpl;
import com.ywh.core.interceptor.FileScanInterceptorImpl;
import com.ywh.core.model.FileCondition;
import com.ywh.core.model.FileThing;
import com.ywh.core.scan.FileScanAll;
import com.ywh.core.scan.FileScanAllImpl;

import javax.sql.DataSource;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author ywh
 * @date 2019/11/28 19:45
 * @description 调度，管理者
 * 用到了线程池
 */
public class EveryThingManger {
    private FileSearch fileSearch;
    private FileScanAll fileScanAll;
    //线程池
    private ExecutorService executorService;

    private static volatile EveryThingManger everyThingManger;

    private EveryThingManger() {
        this.initComponent();
    }

    private void initComponent() {
        //数据源对象
        DataSource dataSource = DataBaseFactory.dataSource();
        //检查数据库
        checkDatabase();
        //业务层对象
        NoLimitDaoImpl fileDao = new NoLimitDaoImpl(dataSource);

        this.fileSearch = new FileSearchImpl(fileDao);
        this.fileScanAll = new FileScanAllImpl();
        this.fileScanAll.interceptor(new FileScanInterceptorImpl(fileDao));
    }

    private void checkDatabase() {
        String fileName = EverythingConfig.getInstance().getH2IndexPath() + ".mv.db";
        File dbFile = new File(fileName);
        if (dbFile.isFile() && !dbFile.exists()) {
            DataBaseFactory.initDataBase();
        }
    }


    public static EveryThingManger getInstance() {
        if (everyThingManger == null) {
            synchronized (EveryThingManger.class) {
                if (everyThingManger == null) {
                    everyThingManger = new EveryThingManger();
                }
            }
        }
        return everyThingManger;
    }


    //检索
    public List<FileThing> search(FileCondition condition) {
        //使用Stream流
        return this.fileSearch.search(condition);
    }

    // 索引
    public void buildIndex() {
        Set<String> dir = EverythingConfig.getInstance().getIncludePath();
        if (this.executorService == null) {
            //固定线程数量，目录的数量,给线程起个名字
            this.executorService = Executors.newFixedThreadPool(dir.size(), new ThreadFactory() {
                private final AtomicInteger threadId = new AtomicInteger(0);
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setName("Thread-scan" + threadId.getAndIncrement());
                    return thread;
                }
            });
        }
        final CountDownLatch countDownLatch = new CountDownLatch(dir.size());
        System.out.println("begin");
        for (String includePath : dir) {
            this.executorService.submit(() -> {
                EveryThingManger.this.fileScanAll.fileScan(includePath);
                countDownLatch.countDown();//当前任务完成，-1
            });
        }
        /**
         * 直到任务完成
         */
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("complete");
    }
}
