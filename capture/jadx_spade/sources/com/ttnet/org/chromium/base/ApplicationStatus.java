package com.ttnet.org.chromium.base;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JNINamespace("base::android")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ApplicationStatus {
    private static final Map<Activity, Object> a;
    private static int b;
    private static Activity c;
    private static b d;
    private static k<b> e;

    public interface b {
    }

    private ApplicationStatus() {
    }

    public static Activity c() {
        return c;
    }

    public static boolean e() {
        boolean z;
        synchronized (a) {
            if (b != 0) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static int getStateForApplication() {
        int i;
        synchronized (a) {
            i = b;
        }
        return i;
    }

    public static boolean hasVisibleActivities() {
        int stateForApplication = getStateForApplication();
        if (stateForApplication == 1 || stateForApplication == 2) {
            return true;
        }
        return false;
    }

    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.h(new a());
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApplicationStatus.d != null) {
                return;
            }
            b unused = ApplicationStatus.d = new C0117a();
            ApplicationStatus.f(ApplicationStatus.d);
        }

        /* renamed from: com.ttnet.org.chromium.base.ApplicationStatus$a$a, reason: collision with other inner class name */
        class C0117a implements b {
            C0117a() {
            }
        }
    }

    static {
        Covode.recordClassIndex(654143);
        a = Collections.synchronizedMap(new HashMap());
        b = 0;
    }

    public static List<Activity> d() {
        ArrayList arrayList;
        Map<Activity, Object> map = a;
        synchronized (map) {
            arrayList = new ArrayList(map.keySet());
        }
        return arrayList;
    }

    public static void g(b bVar) {
        k<b> kVar = e;
        if (kVar == null) {
            return;
        }
        kVar.w(bVar);
    }

    public static void f(b bVar) {
        if (e == null) {
            e = new k<>();
        }
        e.o(bVar);
    }
}
