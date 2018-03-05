package com.daoshan.school.demo.io;

import java.io.*;

/**
 * java面试题
 * 给定一个txt文件，如何得到某字符串出现的次数
 */
public class IODemo {


    public static void main(String[] args) {

        //创建文件对象
        File file = new File("D://demo.txt");
        //获取输出流   备注：从系统写入文件
        //OutputStream outputStream = null;
        //获取输入流   备注：从文件读入系统
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte b[] = new byte[1024];
            int a = inputStream.read(b);
            String str = new String(b,0,a);
            String strArr[] = str.split("");
            int count = 0;
            for (int i = 0;i < strArr.length;i++){
                if("a".equals(strArr[i])){
                    count++;
                }
            }
            System.out.println("此文档中包含a的数量为："+count);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                //关闭流
                inputStream.close();
            }catch (IOException e){
                e.getStackTrace();
            }

        }


    }
}
