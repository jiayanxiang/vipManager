package com.jyx.vip.common;

/**
 * 验证类
 */
public class AssertThrowUtils {

    //验证是否为空
    public static String thorwIfBlank(String message,String target){
        if (target == null || (target = target.trim()).length() == 0){
            throw new ThisSystemException(message);
        }

        return target;
    }

    //是否空
    public static void assertNotNull(String message,Object o){
        if (o==null){
            throw new ThisSystemException(message);
        }
    }

    public static void assertEquals(String message,Object o,Object o1){
        if (o == null ? o != o1:!o.equals(o1)){
            throw new ThisSystemException(message);
        }
    }

    public static void assertNotEquals(String message,Object o,Object o1){
        if (o == null ? o == o1:o.equals(o1)){
            throw new ThisSystemException(message);
        }
    }
}
