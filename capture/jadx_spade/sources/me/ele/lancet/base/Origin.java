package me.ele.lancet.base;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class Origin {
    public static final String CLASS_NAME;

    public static void callVoid() {
    }

    public static <U extends Throwable> void callVoidThrowOne() throws Throwable {
    }

    public static <U extends Throwable, V extends Throwable, W extends Throwable> void callVoidThrowThree() throws Throwable, Throwable, Throwable {
    }

    public static <U extends Throwable, V extends Throwable> void callVoidThrowTwo() throws Throwable, Throwable {
    }

    public static Object call() {
        return new Object();
    }

    public static <V extends Throwable> Object callThrowOne() throws Throwable {
        return new Object();
    }

    public static <V extends Throwable, U extends Throwable, W extends Throwable> Object callThrowThree() throws Throwable, Throwable, Throwable {
        return new Object();
    }

    public static <V extends Throwable, U extends Throwable> Object callThrowTwo() throws Throwable, Throwable {
        return new Object();
    }

    private Origin() {
        throw new AssertionError();
    }

    static {
        Covode.recordClassIndex(660156);
        CLASS_NAME = Origin.class.getName().replace('.', '/');
    }
}
