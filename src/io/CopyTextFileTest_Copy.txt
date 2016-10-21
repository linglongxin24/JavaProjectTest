package io;

import java.io.*;

/**
 * Created by yuandl on 2016-10-13.
 * Java拷贝文件
 */
public class CopyTextFileTest {

    public static void main(String args[]) {
        String src = "E:\\kejiang\\IdeaProjects\\JavaProjectTest\\src\\io\\CopyTextFileTest.java";
        String out = "E:\\kejiang\\IdeaProjects\\JavaProjectTest\\src\\io\\CopyTextFileTest_Copy.txt";
        //  FileReaderFileWriter(src, out);
        //  BufferReaderBufferWriter(src, out);
        //  InputStreamOutputStream(src, out);
        BufferInputStreamBufferOutputStream(src, out);
    }

    /**
     * 字符流读写复制文件
     *
     * @param src 源文件
     * @param out 目标文件
     */
    public static void FileReaderFileWriter(String src, String out) {
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        try {
            //创建一个可以往文件中写入字符数据的字符输出流对象。
                /*
                * 既然是往一个文件中写入文字数据，那么在创建对象时，就必须明确该文件(用于存储数据的目的
                * 地)。
                *
                * 如果文件不存在，则会自动创建。
                * 如果文件存在，则会被覆盖。
                *
                * 如果构造函数中加入true，可以实现对文件进行续写！
                */
            fileWriter = new FileWriter(out);
            //1,创建读取字符数据的流对象。
                /*
                * 在创建读取流对象时，必须要明确被读取的文件。一定要确定该文件是存在的。
                *
                * 用一个读取流关联一个已存在文件。
                */
            fileReader = new FileReader(src);

            //创建一个临时容器，用于缓存读取到的字符。
            char[] chars = new char[1024];
            //定义一个变量记录读取到的字符数，(其实就是往数组里装的字符个数 )
            int num = 0;
            while ((num = fileReader.read(chars)) != -1) {
                fileWriter.write(chars, 0, num);
                fileWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 字符流缓冲区读写文件
     * 效率比较高
     *
     * @param src 源文件
     * @param out 目标文件
     */
    public static void BufferReaderBufferWriter(String src, String out) {
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(out));
            bufferedReader = new BufferedReader(new FileReader(src));

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
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
     * 字节流读写复制文件
     *
     * @param src 源文件
     * @param out 目标文件
     */
    public static void InputStreamOutputStream(String src, String out) {
        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            outputStream = new FileOutputStream(out);
            inputStream = new FileInputStream(src);
            byte[] bytes = new byte[1024];
            int num = 0;
            while ((num = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, num);
                outputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 字节缓冲流读写复制文件
     *
     * @param src 源文件
     * @param out 目标文件
     */
    public static void BufferInputStreamBufferOutputStream(String src, String out) {
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(out));
            bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
            byte[] bytes = new byte[1024];
            int num = 0;
            while ((num = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, num);
                bufferedOutputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedOutputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
