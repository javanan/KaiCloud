package cloud.kai.com.kaicloud.com.kaicloud.utils;

import android.util.Log;

/**
 * Log统一管理类
 *
 *日志工具类L.java
 *
 */
public class L
{

    private L()
    {

        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    /** 当前运行的 Java 虚拟机是否是在安卓环境 */
    public static final boolean isAndroid;
    static {
        boolean flag = false;
        try {
            Class.forName("android.Manifest");
            flag = true;
        }
        catch (Throwable e) {}
        isAndroid = flag;
    }
    public static String getCallClassName(){
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if(isAndroid){
            for (int i = 0; i < sts.length; i++) {
                if (sts[i].getClassName().equals(L.class.getName())) {
                    return sts[i+2].getClassName();
                }
            }
        }

        return L.class.getName();
    }

    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static  String TAG =getCallClassName();

    // 下面四个是默认tag的函数
    public static void i(String msg)
    {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg)
    {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg)
    {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg)
    {
        if (isDebug)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void v(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }
}