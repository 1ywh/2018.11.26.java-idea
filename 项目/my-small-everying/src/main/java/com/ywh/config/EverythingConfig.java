package com.ywh.config;



import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;


/**
 * @author ywh
 * @date 2019/11/26 19:26
 * @description   单例的模式
 */
public class EverythingConfig {

    // 建立索引的路径
    private Set<String> includePath=new HashSet<>();

     // 排除索引的路径
    private Set<String> excludePath=new HashSet<>();

    private static volatile EverythingConfig config;

    public Set<String> getIncludePath() {
        return includePath;
    }

    public Set<String> getExcludePath() {
        return excludePath;
    }
    //H2数据库的路径
    private String h2IndexPath=System.getProperty("user.dir")+ File.separator+"my_small_everything";

    public String getH2IndexPath() {
        return h2IndexPath;
    }

    private static void initDefaultPathsConfig(){
        //遍历的目录
        //1.获得文件系统
        FileSystem fileSystem = FileSystems.getDefault();
        Iterable<Path> iterable = fileSystem.getRootDirectories();
        iterable.forEach(path -> config.includePath.add(path.toString()));
        //排除的目录
        //获取os的类型
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            config.getExcludePath()
                    .add("C:\\Program Files");
            config.getExcludePath()
                    .add(" C:\\ProgramData");
        } else {
            config.getExcludePath().add("/tmp");
            config.getExcludePath().add("/etc");
        }
    }
    public static EverythingConfig getInstance() {
        if (config == null) {
            synchronized (EverythingConfig.class) {
                if (config == null) {
                    config = new EverythingConfig();
                   config.initDefaultPathsConfig();
                }
            }
        }
        return config;
    }
}
