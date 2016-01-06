package com.makk.assist;

import java.io.Closeable;
import java.io.IOException;

/**
 * ProjectName：CommonUtils
 * PackageName：com.makk.utils
 * Author: makk
 * Time:2016年01月05日20时02分
 *
 */
public class StreamUtil {
    /**
     * 关闭实现Closeable接口的类
     * @param closeable java.io.Closeable
     */
    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
