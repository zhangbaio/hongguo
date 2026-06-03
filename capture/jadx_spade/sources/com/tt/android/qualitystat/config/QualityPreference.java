package com.tt.android.qualitystat.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AndroidRuntimeException;
import android.util.Base64;
import com.bytedance.covode.number.Covode;
import com.tt.android.qualitystat.UserStatAgent;
import com.tt.android.qualitystat.base.QualityStatLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class QualityPreference<T> {
    private static boolean c;
    private static final ConcurrentHashMap<String, SoftReference<? extends Object>> d;
    private static final Lazy e;
    public static final a f;
    public final String a;
    public final T b;

    static {
        Lazy lazy;
        Covode.recordClassIndex(654034);
        f = new a(null);
        d = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SharedPreferences>() { // from class: com.tt.android.qualitystat.config.QualityPreference$Companion$prefs$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                Context context = com.tt.android.qualitystat.base.a.b.getContext();
                if (context == null) {
                    Intrinsics.throwNpe();
                }
                return context.getSharedPreferences("qualitystat_sp", 0);
            }
        });
        e = lazy;
    }

    public static final class a {
        static final /* synthetic */ KProperty[] a;

        static {
            Covode.recordClassIndex(654035);
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(a.class), "prefs", "getPrefs()Landroid/content/SharedPreferences;"))};
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final SharedPreferences g() {
            Lazy lazy = QualityPreference.e;
            KProperty kProperty = a[0];
            return (SharedPreferences) lazy.getValue();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean e(String str) {
            if (com.tt.android.qualitystat.base.a.b.getContext() != null) {
                return g().contains(str);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> T f(String str) {
            boolean z;
            if (str != null && !StringsKt__StringsKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    try {
                        T t = (T) objectInputStream.readObject();
                        if (!(t instanceof Object)) {
                            t = null;
                        }
                        CloseableKt.closeFinally(objectInputStream, null);
                        CloseableKt.closeFinally(byteArrayInputStream, null);
                        return t;
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> String i(T t) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeObject(t);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(objectOutputStream, null);
                        byte[] encode = Base64.encode(byteArrayOutputStream.toByteArray(), 0);
                        Intrinsics.checkExpressionValueIsNotNull(encode, "Base64.encode(it.toByteArray(), Base64.DEFAULT)");
                        String str = new String(encode, Charsets.UTF_8);
                        CloseableKt.closeFinally(byteArrayOutputStream, null);
                        return str;
                    } finally {
                    }
                } finally {
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public final void d(String str) {
            synchronized (g()) {
                if (str == null) {
                    QualityPreference.d.clear();
                    if (com.tt.android.qualitystat.base.a.b.getContext() != null) {
                        QualityPreference.f.g().edit().clear().apply();
                    }
                } else {
                    SoftReference softReference = (SoftReference) QualityPreference.d.get(str);
                    if (softReference != null) {
                        softReference.clear();
                    }
                    QualityPreference.d.remove(str);
                    if (com.tt.android.qualitystat.base.a.b.getContext() != null) {
                        QualityPreference.f.g().edit().remove(str).apply();
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public final <T> QualityPreference<T> h(String str, T t) {
            return new QualityPreference<>(str, t);
        }
    }

    private final T c(String str) {
        Object f2;
        boolean z;
        if (com.tt.android.qualitystat.base.a.b.getContext() == null) {
            if (!c && !UserStatAgent.g.d()) {
                QualityStatLog.c.c("AppContextHolder has NOT init, CANNOT USE getSharedPreferences !");
                return null;
            }
            throw new AndroidRuntimeException("AppContextHolder has NOT init, CANNOT USE getSharedPreferences !");
        }
        a aVar = f;
        if (aVar.g().contains(str)) {
            SharedPreferences g = aVar.g();
            T t = this.b;
            if (t instanceof Integer) {
                f2 = Integer.valueOf(g.getInt(str, ((Number) t).intValue()));
            } else if (t instanceof Float) {
                f2 = Float.valueOf(g.getFloat(str, ((Number) t).floatValue()));
            } else if (t instanceof Long) {
                f2 = Long.valueOf(g.getLong(str, ((Number) t).longValue()));
            } else if (t instanceof Boolean) {
                f2 = Boolean.valueOf(g.getBoolean(str, ((Boolean) t).booleanValue()));
            } else if (t instanceof String) {
                f2 = g.getString(str, (String) t);
            } else if (t instanceof JSONObject) {
                String string = g.getString(str, null);
                if (string != null) {
                    if (string.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        f2 = new JSONObject(string);
                    }
                }
                f2 = null;
            } else {
                QualityStatLog.c.a("此处调用了反序列化进行读取，name=" + str + ", default=" + this.b);
                f2 = aVar.f(g.getString(str, null));
            }
            if (c) {
                QualityStatLog.c.a("getSharedPreferences, name= " + str + ", value= " + f2);
            }
            if (!(f2 instanceof Object)) {
                return null;
            }
            return (T) f2;
        }
        return null;
    }

    public QualityPreference(String str, T t) {
        this.a = str;
        this.b = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T d(Object obj, KProperty<?> kProperty) {
        T t;
        T t2;
        synchronized (f.g()) {
            SoftReference<? extends Object> softReference = d.get(this.a);
            t = null;
            if (softReference != null) {
                t2 = softReference.get();
            } else {
                t2 = null;
            }
            if (t2 instanceof Object) {
                t = t2;
            }
            if (t == null) {
                try {
                    t = c(this.a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                QualityStatLog.c.a("getValue from SP: name=" + this.a + ", value=" + t);
                if (t != null) {
                    d.put(this.a, new SoftReference<>(t));
                } else {
                    f.d(this.a);
                    d.remove(this.a);
                }
            }
            if (t == null) {
                t = this.b;
            }
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e(String str, T t) {
        SharedPreferences.Editor putString;
        if (com.tt.android.qualitystat.base.a.b.getContext() == null) {
            if (!c && !UserStatAgent.g.d()) {
                QualityStatLog.c.c("AppContextHolder has NOT init, CANNOT USE putSharedPreferences !");
                return;
            }
            throw new AndroidRuntimeException("AppContextHolder has NOT init, CANNOT USE putSharedPreferences !");
        }
        if (c) {
            QualityStatLog.c.a("putSharedPreferences, name= " + str + ", value= " + t);
        }
        a aVar = f;
        SharedPreferences.Editor edit = aVar.g().edit();
        if (t instanceof Integer) {
            putString = edit.putInt(str, ((Number) t).intValue());
        } else if (t instanceof Float) {
            putString = edit.putFloat(str, ((Number) t).floatValue());
        } else if (t instanceof Long) {
            putString = edit.putLong(str, ((Number) t).longValue());
        } else if (t instanceof Boolean) {
            putString = edit.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof String) {
            putString = edit.putString(str, (String) t);
        } else if (t instanceof JSONObject) {
            putString = edit.putString(str, t.toString());
        } else {
            QualityStatLog.c.a("此处调用了序列化进行存储，name=" + str + ", value=" + t);
            putString = edit.putString(str, aVar.i(t));
        }
        putString.apply();
    }

    public final void f(Object obj, KProperty<?> kProperty, T t) {
        synchronized (f.g()) {
            ConcurrentHashMap<String, SoftReference<? extends Object>> concurrentHashMap = d;
            concurrentHashMap.remove(this.a);
            concurrentHashMap.put(this.a, new SoftReference<>(t));
            e(this.a, t);
            Unit unit = Unit.INSTANCE;
        }
    }
}
