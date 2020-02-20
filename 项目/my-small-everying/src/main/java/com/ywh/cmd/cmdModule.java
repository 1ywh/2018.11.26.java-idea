package com.ywh.cmd;

import com.ywh.core.model.FileCondition;
import com.ywh.core.model.FileThing;
import com.ywh.core.search.EveryThingManger;

import java.util.List;
import java.util.Scanner;


/**
 * @author ywh
 * @date 2019/11/23 18:23
 * @description
 */
public class cmdModule {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        welcome();
        EveryThingManger everyThingManger = EveryThingManger.getInstance();
        //交互式
        interactive(everyThingManger);
    }

    private static void interactive(EveryThingManger everyThingManger) {
        while (true) {
            System.out.print("my_small_everything>>");
            String input = scan.nextLine();
            //优先处理search
            if (input.startsWith("search")) {
                String[] values = input.split(" ");
                if (values.length >= 2) {
                    if (!values[0].equals("search")) {
                        help();
                        continue;
                    }
                    FileCondition fileCondition = new FileCondition();
                    String name = values[1];
                    fileCondition.setName(name);
                    if (values.length >= 3) {
                        String file = values[2];
                        fileCondition.setFileType(file.toUpperCase());
                    }
                    search(everyThingManger, fileCondition);
                    continue;
                } else {
                    help();
                    continue;
                }
            }
            switch (input) {
                case "help":
                    help();
                    break;
                case "quit":
                    quit();
                    break;
                case "scan":
                    index(everyThingManger);
                    break;
                default:
                    help();
            }
        }
    }
    private static void quit() {
        System.out.println("欢迎使用my_small_everything，再见！");
        System.exit(0);
    }
    private static void index(EveryThingManger everyThingManger) {
        new Thread(() -> everyThingManger.buildIndex()).start();
    }
    private static void search(EveryThingManger everyThingManger, FileCondition fileCondition) {
        System.out.println("检索功能");
        List<FileThing> l = everyThingManger.search(fileCondition);
        for (FileThing thing : l) {
            System.out.println(thing.getFile_path());
        }
    }
    private static void help() {
        System.out.println("命令列表：");
        System.out.println("退出：quit");
        System.out.println("帮助：help");
        System.out.println("索引：scan");
        System.out.println("搜索：search<name> [<file-Type> img | doc | bin | archive | other]");
    }

    private static void welcome() {
        System.out.println("welcome you");
    }

}
