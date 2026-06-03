package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ai implements ah, InvocationHandler {
    private static final String[][] a;

    /* renamed from: a, reason: collision with other field name */
    private Context f106a;

    /* renamed from: a, reason: collision with other field name */
    private Class f108a = null;
    private Class b = null;

    /* renamed from: a, reason: collision with other field name */
    private Method f110a = null;

    /* renamed from: b, reason: collision with other field name */
    private Method f111b = null;
    private Method c = null;
    private Method d = null;
    private Method e = null;
    private Method f = null;
    private Method g = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f109a = new Object();

    /* renamed from: a, reason: collision with other field name */
    private volatile int f104a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile long f105a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile a f107a = null;

    private static Object com_xiaomi_push_ai_java_lang_reflect_Method_invoke(Method method, Object obj, Object[] objArr) {
        Result preInvoke = new HeliosApiHook().preInvoke(110000, "java/lang/reflect/Method", "invoke", method, new Object[]{obj, objArr}, "java.lang.Object", new ExtraInfo(true, "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;"));
        return preInvoke.isIntercept() ? preInvoke.getReturnValue() : method.invoke(obj, objArr);
    }

    private class a {

        /* renamed from: a, reason: collision with other field name */
        Boolean f112a;

        /* renamed from: a, reason: collision with other field name */
        String f113a;
        String b;
        String c;
        String d;

        static {
            Covode.recordClassIndex(655342);
        }

        boolean a() {
            if (!TextUtils.isEmpty(this.f113a) || !TextUtils.isEmpty(this.b) || !TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d)) {
                this.f112a = Boolean.TRUE;
            }
            if (this.f112a != null) {
                return true;
            }
            return false;
        }

        private a() {
            this.f112a = null;
            this.f113a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    static {
        Covode.recordClassIndex(655341);
        a = new String[][]{new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};
    }

    private void a() {
        synchronized (this.f109a) {
            try {
                this.f109a.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public String mo140a() {
        a("getOAID");
        if (this.f107a == null) {
            return null;
        }
        return this.f107a.b;
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public boolean mo141a() {
        a("isSupported");
        if (this.f107a != null && Boolean.TRUE.equals(this.f107a.f112a)) {
            return true;
        }
        return false;
    }

    private static void b(String str) {
        com.xiaomi.channel.commonutils.logger.b.m54a("mdid:" + str);
    }

    public ai(Context context) {
        this.f106a = context.getApplicationContext();
        a(context);
        b(context);
    }

    private void a(Context context) {
        Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i = 0;
        while (true) {
            String[][] strArr = a;
            if (i >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i];
            Class<?> a3 = a(context, strArr2[0]);
            Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index " + i);
                cls2 = a4;
                cls = a3;
                break;
            }
            i++;
            cls2 = a4;
            cls = a3;
        }
        this.f108a = a2;
        this.f110a = a(a2, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.b = cls;
        this.c = a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f = a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.g = a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    private void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f110a, this.f108a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
            }
            this.f105a = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.f105a = elapsedRealtime;
    }

    private void a(String str) {
        if (this.f107a != null) {
            return;
        }
        long j = this.f105a;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i = this.f104a;
        if (elapsedRealtime > 3000 && i < 3) {
            synchronized (this.f109a) {
                if (this.f105a == j && this.f104a == i) {
                    b("retry, current count is " + i);
                    this.f104a = this.f104a + 1;
                    b(this.f106a);
                    j = this.f105a;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                }
            }
        }
        if (this.f107a == null && j >= 0 && elapsedRealtime <= 3000 && Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (this.f109a) {
                if (this.f107a == null) {
                    try {
                        b(str + " wait...");
                        this.f109a.wait(3000L);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    private static boolean a(Object obj) {
        if (!(obj instanceof Boolean) && !(obj instanceof Character) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Double)) {
            return false;
        }
        return true;
    }

    private static Class<?> a(Context context, String str) {
        try {
            return q.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static <T> T a(Method method, Object obj, Object... objArr) {
        if (method != null) {
            try {
                T t = (T) com_xiaomi_push_ai_java_lang_reflect_Method_invoke(method, obj, objArr);
                if (t != null) {
                    return t;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.f105a = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 != null && !a(obj2)) {
                    aVar.b = (String) a(this.c, obj2, new Object[0]);
                    aVar.f112a = (Boolean) a(this.f, obj2, new Object[0]);
                    a(this.g, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        if (this.f107a != null) {
                            z = true;
                        }
                        sb.append(z);
                        b(sb.toString());
                        synchronized (ai.class) {
                            if (this.f107a == null) {
                                this.f107a = aVar;
                            }
                        }
                    }
                }
                i++;
            }
        }
        a();
        return null;
    }
}
