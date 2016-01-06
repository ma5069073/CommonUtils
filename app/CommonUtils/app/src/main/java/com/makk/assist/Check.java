package com.makk.assist;

import java.util.Collection;
import java.util.Map;

/**
 * ProjectName：CommonUtils
 * PackageName：com.makk.assist
 * Author: makk
 * Time:2016年01月06日21时53分
 */
public class Check {
    /**
     * 检查CharSequence是否为空
     *
     * @param str CharSequence
     * @return boolean
     */
    public static boolean isEmpty(CharSequence str) {
        return isNull(str) || str.length() == 0;
    }

    /**
     * 检查Object[]是否为空
     *
     * @param os Object[]
     * @return boolean
     */
    public static boolean isEmpty(Object[] os) {
        return isNull(os) || os.length == 0;
    }

    /**
     * 检查Collection是否为空
     *
     * @param l Collection
     * @return boolean
     */
    public static boolean isEmpty(Collection<?> l) {
        return isNull(l) || l.isEmpty();
    }

    /**
     * 检查Map是否为空
     *
     * @param m Map
     * @return boolean
     */
    public static boolean isEmpty(Map<?, ?> m) {
        return isNull(m) || m.isEmpty();
    }

    /**
     * 检查Object是否为空
     *
     * @param o Object
     * @return boolean
     */
    public static boolean isNull(Object o) {
        return o == null;
    }
}
