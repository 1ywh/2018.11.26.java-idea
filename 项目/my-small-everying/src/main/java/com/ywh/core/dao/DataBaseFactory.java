package com.ywh.core.dao;


import com.alibaba.druid.pool.DruidDataSource;
import com.ywh.config.EverythingConfig;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ywh
 * @date 2019/11/25 13:01
 * @description
 */
public class DataBaseFactory {
    /**
     * 单例，数据源
     * DruidDataSource 实现 DataSource ,主要做获取数据库源、初始化数据库源
     */
    private static volatile DruidDataSource dataSource;

    private DataBaseFactory() {
    }

    //数据库连接，数据源
    public static DataSource dataSource() {
        if (dataSource == null) {
            synchronized (DataBaseFactory.class) {
                if (dataSource == null) {
                    //实例化
                    dataSource = new DruidDataSource();
                    //通过反射的方式获取Driver对象
                    dataSource.setDriverClassName("org.h2.Driver");
                    //获取当前工作路径
                    //String path = System.getProperty("user.dir");
                    //jdbc:mysql//ip:port/databaseName
                    //jdbc:h2:filePath
                    //只需要修改url，不需要修改password
                    dataSource.setUrl("jdbc:h2:" + EverythingConfig.getInstance().getH2IndexPath());
                    dataSource.setValidationQuery("select now()");
                }
            }
        }
        return dataSource;
    }

    public static void initDataBase() {
        //1.获取数据源
        DataSource dataSource = DataBaseFactory.dataSource();
        //2.获取sql语句,采取classPath路径下的文件
        try (InputStream in = DataBaseFactory.class.getClassLoader()
                .getResourceAsStream("my_small_everything.sql");) {
            if (in == null) {
                throw new RuntimeException("please check it!!");
            }
            StringBuilder sqlBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))) {
                String line = null;
                //没有读到末尾
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.startsWith("--")) {
                        sqlBuilder.append(line);
                    }
                }
            }
            //3.获取数据库连接和名称执行sql
            String sql = sqlBuilder.toString();
            //jdbc操作
            //获取连接
            Connection connection = dataSource.getConnection();
            //创建命令
            PreparedStatement statement = connection.prepareStatement(sql);
            //执行sql语句
            statement.execute();
            connection.close();
            statement.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        DataSource d = DataBaseFactory.dataSource();
        DataBaseFactory.initDataBase();
        System.out.println(d);
    }
}
