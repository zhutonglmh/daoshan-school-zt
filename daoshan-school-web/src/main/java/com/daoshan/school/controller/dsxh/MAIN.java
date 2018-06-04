package com.daoshan.school.controller.dsxh;

import com.daoshan.school.utils.md5.Md5;
import com.daoshan.school.utils.uuid.UUIDUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MAIN {

    public static void main(String[] args) {
        byte[] hash;
        byte[] hash2;
        String string = "朱同";
        {
            try {
                try {
                    hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
                    hash2 = MessageDigest.getInstance("MD5").digest(string.getBytes("GBK"));


                    String hexString = "";
                    for (byte b : hash) {
                        // 第一步，将数据全部转换成正数：
                        // 解释：为什么采用b&255
                        /*
                         * b:它本来是一个byte类型的数据(1个字节) 255：是一个int类型的数据(4个字节)
                         * byte类型的数据与int类型的数据进行运算，会自动类型提升为int类型 eg: b: 1001 1100(原始数据)
                         * 运算时： b: 0000 0000 0000 0000 0000 0000 1001 1100 255: 0000
                         * 0000 0000 0000 0000 0000 1111 1111 结果：0000 0000 0000 0000
                         * 0000 0000 1001 1100 此时的temp是一个int类型的整数
                         */
                        int temp = b & 255;
                        // 第二步，将所有的数据转换成16进制的形式
                        // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                        // 因此，需要对temp进行判断
                        if (temp < 16 && temp >= 0) {
                            // 手动补上一个“0”
                            hexString = hexString + "0" + Integer.toHexString(temp);
                        } else {
                            hexString = hexString + Integer.toHexString(temp);
                        }
                    }
                    System.out.println(hexString);

                    String hexString2 = "";
                    for (byte b : hash2) {
                        // 第一步，将数据全部转换成正数：
                        // 解释：为什么采用b&255
                        /*
                         * b:它本来是一个byte类型的数据(1个字节) 255：是一个int类型的数据(4个字节)
                         * byte类型的数据与int类型的数据进行运算，会自动类型提升为int类型 eg: b: 1001 1100(原始数据)
                         * 运算时： b: 0000 0000 0000 0000 0000 0000 1001 1100 255: 0000
                         * 0000 0000 0000 0000 0000 1111 1111 结果：0000 0000 0000 0000
                         * 0000 0000 1001 1100 此时的temp是一个int类型的整数
                         */
                        int temp = b & 255;
                        // 第二步，将所有的数据转换成16进制的形式
                        // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                        // 因此，需要对temp进行判断
                        if (temp < 16 && temp >= 0) {
                            // 手动补上一个“0”
                            hexString2 = hexString2 + "0" + Integer.toHexString(temp);
                        } else {
                            hexString2 = hexString2 + Integer.toHexString(temp);
                        }
                    }
                    System.out.println(hexString2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
