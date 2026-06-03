package com.vivo.push.util;

import android.os.UserHandle;
import com.bytedance.covode.number.Covode;
import java.lang.reflect.Method;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class v {
    private static int a;

    static {
        Covode.recordClassIndex(655207);
        a = -1;
    }

    public static int a() {
        int i = a;
        if (i != -1) {
            return i;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            a = ((Integer) declaredMethod.invoke(null, null)).intValue();
            t.d("MultiUserManager", "getMyUserId = " + a);
            return a;
        } catch (Exception e) {
            t.a("MultiUserManager", "getMyUserId error " + e.getMessage());
            return 0;
        }
    }
}
