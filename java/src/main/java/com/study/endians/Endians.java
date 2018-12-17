package com.study.endians;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 *
 * 1、什么是大端和小端
 *
 * 1) Little-Endian就是低位字节排放在内存的低地址端，高位字节排放在内存的高地址端。
 * 2) Big-Endian就是高位字节排放在内存的低地址端，低位字节排放在内存的高地址端。
 *
 * 举例说明：例如数字0x12345678在内存中表现形式为：
 *
 * 1）大端模式：
 *
 * 低地址 -----------------> 高地址
 * 0x12  |  0x34  |  0x56  |  0x78
 *
 * 2）小端模式：
 *
 * 低地址 ------------------> 高地址
 * 0x78  |  0x56  |  0x34  |  0x1
 * ---------------------
 * 作者：Y-CAT
 * 来源：CSDN
 * 原文：https://blog.csdn.net/hfmbook/article/details/70209184
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 *
 * @author tb
 * @date 2018/12/17 17:42
 */
public class Endians {

    public static void main(String[] args) {
        // 创建12个字节的字节缓冲区
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        String str = "abdcef";
        int num = 305419896; //32
        // 存入字符串
        bb.asCharBuffer().put(str);
        System.out.println(Arrays.toString(bb.array()));

        // 反转缓冲区
        bb.rewind();
        // 设置字节存储次序 大端存储
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put(str);
        System.out.println(Arrays.toString(bb.array()));

        // 反转缓冲区
        bb.rewind();
        // 设置字节存储次序
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put(str);
        System.out.println(Arrays.toString(bb.array()));


        bb.asIntBuffer().put(num);
        System.out.println(Arrays.toString(bb.array()));

        // 反转缓冲区
        bb.rewind();
        // 设置字节存储次序 大端存储
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asIntBuffer().put(num);
        System.out.println(Arrays.toString(bb.array()));

        // 反转缓冲区
        bb.rewind();
        // 设置字节存储次序
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asIntBuffer().put(num);
        System.out.println(Arrays.toString(bb.array()));
    }

    public static int toLittleEndian(int a) {
        return (((a & 0xFF) << 24) | (((a >> 8) & 0xFF) << 16) | (((a >> 16) & 0xFF) << 8) | ((a >> 24) & 0xFF));
    }
}
