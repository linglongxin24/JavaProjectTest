package io;

import java.io.*;

/**
 * Created by yuandl on 2016-10-14.
 * Java字节流和字符流之间的转换
 */
public class SystemIOTest {
    public static void main(String args[]) {
        test3();
    }

    /**
     * 通过键盘录入文字输出大写
     */
    public static void test1() {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        try {
            while ((s = bufferedReader.readLine()) != null) {
                if ("over".equals(s)) {
                    break;
                }
                bufferedWriter.write(s.toUpperCase());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过指定文件字输出到控制台
     */
    public static void test2() {
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;

        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(
                    "E:\\kejiang\\IdeaProjects\\JavaProjectTest\\src\\io\\SystemIOTest.java")));
            String s = "";
            while ((s = bufferedReader.readLine()) != null) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过键盘录入文字输出到文件
     */
    public static void test3() {
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;

        try {
            bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(
                                    "E:\\kejiang\\IdeaProjects\\JavaProjectTest\\src\\io\\SystemOut.txt"),"UTF-8"));
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s = "";
            while ((s = bufferedReader.readLine()) != null) {
                if ("over".equals(s)) {
                    break;
                }
                bufferedWriter.write(s.toUpperCase());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



