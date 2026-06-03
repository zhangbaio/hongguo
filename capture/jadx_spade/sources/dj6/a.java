package dj6;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static Class<?> a;

    static {
        Covode.recordClassIndex(653035);
    }

    private static Class<?> b() throws ClassNotFoundException {
        Class<?> cls;
        synchronized (a.class) {
            if (a == null) {
                a = l3.a.q("com.pandora.ttlicense2.LicenseManager");
            }
            cls = a;
        }
        return cls;
    }

    public static int a(String str) {
        try {
            Class<?> b = b();
            Method declaredMethod = b.getDeclaredMethod("getInstance", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = b.getDeclaredMethod("checkFeatureAuth", String.class, String.class);
            declaredMethod2.setAccessible(true);
            return ((Integer) declaredMethod2.invoke(invoke, "live_pull", str)).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return 0;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return 0;
        }
    }
}
