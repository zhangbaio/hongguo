package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.base.r;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class p implements Application.ActivityLifecycleCallbacks {
    private static boolean d;
    private static final String e;
    private static r f;
    private int a;
    public c b;
    private Runnable c = new b();

    class a implements r.a {
        a() {
        }

        @Override // com.ttnet.org.chromium.base.r.a
        public void handleMsg(Message message) {
        }
    }

    public interface c {
        void a();

        void b();

        void c();

        void d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (!p.d) {
                return;
            }
            boolean unused = p.d = false;
            if (p.this.b != null) {
                p.this.b.a();
            }
        }

        b() {
        }
    }

    static {
        Covode.recordClassIndex(654261);
        e = p.class.getSimpleName();
        f = new r(Looper.getMainLooper(), new a());
    }

    public p() {
        if (getActivity() != null) {
            d = true;
        }
        this.a = 0;
        List<Activity> d2 = d();
        if (d2 != null) {
            this.a = d2.size();
        }
    }

    private static List<Activity> d() {
        ArrayList arrayList = new ArrayList();
        try {
            Class q = l3.a.q("android.app.ActivityThread");
            Method declaredMethod = q.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = q.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map == null) {
                return null;
            }
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Object value = ((Map.Entry) it2.next()).getValue();
                Field declaredField2 = value.getClass().getDeclaredField("activity");
                declaredField2.setAccessible(true);
                arrayList.add((Activity) declaredField2.get(value));
            }
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Activity getActivity() {
        try {
            Class q = l3.a.q("android.app.ActivityThread");
            Object invoke = q.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = q.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map == null) {
                return null;
            }
            for (Object obj : map.values()) {
                Class<?> cls = obj.getClass();
                Field declaredField2 = cls.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (d) {
            f.postDelayed(this.c, 30000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        c cVar;
        int i = this.a - 1;
        this.a = i;
        if (i == 0 && (cVar = this.b) != null) {
            cVar.d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (!d) {
            d = true;
            c cVar = this.b;
            if (cVar != null) {
                cVar.b();
            }
        }
        f.removeCallbacks(this.c);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        c cVar;
        if (this.a == 0 && (cVar = this.b) != null) {
            cVar.c();
        }
        this.a++;
    }
}
