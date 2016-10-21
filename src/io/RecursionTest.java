package io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by yuandl on 2016-10-14.
 * 递归练习
 */
public class RecursionTest {
    public static void main(String args[]) {
//        List<File> l = listFiles(new File("E:\\kejiang\\IdeaProjects\\JavaProjectTest\\src"));
//        System.out.println("共" + l.size() + "个文件");
//        for (File f : l) {
//            System.out.println(f.getName());
//        }
        System.out.println(getSum(100));
    }

    /**
     * 找出指定目录下的所有文件
     * 递归
     *
     * @param files
     * @return
     */
    public static List<File> listFiles(File files) {
        List<File> fileList = new ArrayList<>();
        if (files.isDirectory()) {
            for (File file : files.listFiles()) {
                fileList.addAll(listFiles(file));
            }
        } else {
            fileList.add(files);
        }
        return fileList;
    }

    /**
     * 找出指定目录下的所有文件
     * 递归
     *
     * @param dir
     * @return
     */
    public static List<File> listFiles2(File dir) {
        System.out.println(dir);
        List<File> fileList = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                fileList.addAll(listFiles2(file));
            } else {
                System.out.println(file);
                fileList.add(file);
            }
        }
        return fileList;
    }

    /**
     * 获取从1+到N的和
     *
     * @param num
     * @return
     */
    public static int getSum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + getSum(num - 1);
    }
}
