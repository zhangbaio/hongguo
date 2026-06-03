package com.ss.videoarch.liveplayer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class h {
    static Method c;
    static Method d;
    static Method e;
    static Method f;
    static Method g;
    static Method h;
    static Method i;
    static Method j;
    static Method k;
    static Method l;
    static Method m;
    static Method n;
    static Method o;
    static Method p;
    static boolean q;
    private Object a;
    private a b;

    public interface a {
        void onPreloadEvent(int i, Bundle bundle);
    }

    private static Object e(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    static {
        Covode.recordClassIndex(652933);
        q = false;
        j();
    }

    public int d() {
        int i2 = -5;
        try {
            if (this.a == null) {
                return -5;
            }
            n.setAccessible(true);
            Object e2 = e(n, this.a, new Object[0]);
            if (e2 == null) {
                return -5;
            }
            i2 = ((Integer) e2).intValue();
            Log.d("tt_preload", "proxy invoke cancelAll success : " + i2);
            return i2;
        } catch (Exception e3) {
            Log.w("tt_preload", "proxy invoke cancelAll fail : " + e3);
            return i2;
        }
    }

    public int g() {
        int i2 = -5;
        try {
            if (this.a == null) {
                return -5;
            }
            o.setAccessible(true);
            Object e2 = e(o, this.a, new Object[0]);
            if (e2 == null) {
                return -5;
            }
            i2 = ((Integer) e2).intValue();
            Log.d("tt_preload", "proxy invoke getCurrentTaskState success : " + i2);
            return i2;
        } catch (Exception e3) {
            Log.w("tt_preload", "proxy invoke getCurrentTaskState fail : " + e3);
            return i2;
        }
    }

    private static void j() {
        try {
            Class q2 = l3.a.q("com.ss.videoarch.live.ttquic.PreloadManager");
            c = q2.getMethod("getInstance", new Class[0]);
            d = q2.getMethod("init", Context.class, String.class);
            e = q2.getMethod("destroy", new Class[0]);
            Class<?> cls = Integer.TYPE;
            f = q2.getMethod("attachPlayer", cls);
            g = q2.getMethod("detachPlayer", cls);
            h = q2.getMethod("getActivePlayer", new Class[0]);
            i = q2.getMethod("addListener", cls, Object.class);
            j = q2.getMethod("removeListener", cls);
            k = q2.getMethod("recordResource", String.class);
            l = q2.getMethod("preload", cls, String.class, String.class, Bundle.class);
            m = q2.getMethod("cancel", cls, String.class);
            n = q2.getMethod("cancelAll", new Class[0]);
            o = q2.getMethod("getCurrentTaskState", new Class[0]);
            p = q2.getMethod("getPreloadInfo", String.class, cls);
            q = true;
            Log.d("tt_preload", "load preload success");
        } catch (Exception e2) {
            Log.w("tt_preload", "load preload fail : " + e2);
        }
    }

    private static class b implements InvocationHandler {
        private final a a;

        static {
            Covode.recordClassIndex(652935);
        }

        public b(a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            a aVar;
            if (TextUtils.equals("onPreloadEvent", method.getName()) && objArr.length >= 2 && (aVar = this.a) != null) {
                aVar.onPreloadEvent(((Integer) objArr[0]).intValue(), (Bundle) objArr[1]);
                return null;
            }
            return null;
        }
    }

    public h(a aVar) {
        if (q) {
            try {
                c.setAccessible(true);
                this.a = e(c, null, new Object[0]);
                this.b = aVar;
                Log.d("tt_preload", "get preload proxy success");
            } catch (Exception e2) {
                Log.d("tt_preload", "get preload proxy fail : " + e2);
            }
        }
    }

    public int a(int i2) {
        int i3 = -5;
        try {
            Class q2 = l3.a.q("com.ss.videoarch.live.ttquic.PreloadListener");
            if (q2 == null) {
                return -5;
            }
            Object newProxyInstance = Proxy.newProxyInstance(q2.getClassLoader(), new Class[]{q2}, new b(this.b));
            i.setAccessible(true);
            e(i, this.a, new Object[]{Integer.valueOf(i2), newProxyInstance});
            try {
                Log.d("tt_preload", "proxy invoke addListener success : 0");
                return 0;
            } catch (Exception e2) {
                e = e2;
                i3 = 0;
                Log.w("tt_preload", "proxy invoke addListener fail : " + e);
                return i3;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public int b(int i2) {
        int i3 = -5;
        try {
            if (this.a == null) {
                return -5;
            }
            f.setAccessible(true);
            e(f, this.a, new Object[]{Integer.valueOf(i2)});
            try {
                Log.d("tt_preload", "proxy invoke attachPlayer success : 0");
                return 0;
            } catch (Exception e2) {
                e = e2;
                i3 = 0;
                Log.w("tt_preload", "proxy invoke attachPlayer fail : " + e);
                return i3;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public int f(int i2) {
        int i3 = -5;
        try {
            if (this.a == null) {
                return -5;
            }
            g.setAccessible(true);
            e(g, this.a, new Object[]{Integer.valueOf(i2)});
            try {
                Log.d("tt_preload", "proxy invoke detachPlayer success : 0");
                return 0;
            } catch (Exception e2) {
                e = e2;
                i3 = 0;
                Log.w("tt_preload", "proxy invoke detachPlayer fail : " + e);
                return i3;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public int l(String str) {
        int i2 = -5;
        try {
            if (this.a == null) {
                return -5;
            }
            k.setAccessible(true);
            e(k, this.a, new Object[]{str});
            try {
                Log.d("tt_preload", "proxy invoke recordResource success : 0");
                return 0;
            } catch (Exception e2) {
                e = e2;
                i2 = 0;
                Log.w("tt_preload", "proxy invoke recordResource fail : " + e);
                return i2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public int m(int i2) {
        int i3 = -5;
        try {
            if (this.a == null) {
                return -5;
            }
            j.setAccessible(true);
            e(j, this.a, new Object[]{Integer.valueOf(i2)});
            try {
                Log.d("tt_preload", "proxy invoke removeListener success : 0");
                return 0;
            } catch (Exception e2) {
                e = e2;
                i3 = 0;
                Log.w("tt_preload", "proxy invoke removeListener fail : " + e);
                return i3;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public int c(int i2, String str) {
        int i3 = -5;
        try {
            if (this.a == null) {
                return -5;
            }
            m.setAccessible(true);
            Object e2 = e(m, this.a, new Object[]{Integer.valueOf(i2), str});
            if (e2 == null) {
                return -5;
            }
            i3 = ((Integer) e2).intValue();
            Log.d("tt_preload", "proxy invoke cancel success : " + i3);
            return i3;
        } catch (Exception e3) {
            Log.w("tt_preload", "proxy invoke cancel fail : " + e3);
            return i3;
        }
    }

    public Bundle h(String str, int i2) {
        Bundle bundle = null;
        try {
            if (this.a == null) {
                return null;
            }
            p.setAccessible(true);
            Object e2 = e(p, this.a, new Object[]{str, Integer.valueOf(i2)});
            if (e2 == null) {
                return null;
            }
            Bundle bundle2 = (Bundle) e2;
            try {
                Log.d("tt_preload", "proxy invoke getPreloadInfo success : " + bundle2);
                return bundle2;
            } catch (Exception e3) {
                e = e3;
                bundle = bundle2;
                Log.w("tt_preload", "proxy invoke getPreloadInfo fail : " + e);
                return bundle;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public int i(Context context, String str) {
        int i2 = -5;
        try {
            if (this.a == null) {
                return -5;
            }
            d.setAccessible(true);
            Object e2 = e(d, this.a, new Object[]{context, str});
            if (e2 == null) {
                return -5;
            }
            i2 = ((Integer) e2).intValue();
            Log.d("tt_preload", "proxy invoke init success : " + i2);
            return i2;
        } catch (Exception e3) {
            Log.w("tt_preload", "proxy invoke init fail : " + e3);
            return i2;
        }
    }

    public int k(int i2, String str, String str2, Bundle bundle) {
        int i3 = -5;
        try {
            if (this.a == null) {
                return -5;
            }
            l.setAccessible(true);
            Object e2 = e(l, this.a, new Object[]{Integer.valueOf(i2), str, str2, bundle});
            if (e2 == null) {
                return -5;
            }
            i3 = ((Integer) e2).intValue();
            Log.d("tt_preload", "proxy invoke preload success : " + i3);
            return i3;
        } catch (Exception e3) {
            Log.w("tt_preload", "proxy invoke preload fail : " + e3);
            return i3;
        }
    }
}
