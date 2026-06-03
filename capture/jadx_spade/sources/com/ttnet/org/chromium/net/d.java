package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.c;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class d {
    private static final String b;
    protected final Context a;

    public abstract c.a b(boolean z);

    public abstract String d();

    public abstract String e();

    public abstract boolean f();

    static {
        Covode.recordClassIndex(654449);
        b = d.class.getSimpleName();
    }

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + d() + ", version=" + e() + ", enabled=" + f() + "]";
    }

    protected d(Context context) {
        if (context != null) {
            this.a = context;
            return;
        }
        throw new IllegalArgumentException("Context must not be null");
    }

    public static List<d> c(Context context) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(context, "com.ttnet.org.chromium.net.impl.NativeCronetProvider", linkedHashSet, false);
        return Collections.unmodifiableList(new ArrayList(linkedHashSet));
    }

    private static void g(String str, boolean z, Exception exc) {
        if (z) {
            Log.e(b, "Unable to load provider class: " + str, exc);
            return;
        }
        String str2 = b;
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Tried to load " + str + " provider class but it wasn't included in the app classpath");
        }
    }

    private static boolean a(Context context, String str, Set<d> set, boolean z) {
        try {
            set.add((d) context.getClassLoader().loadClass(str).asSubclass(d.class).getConstructor(Context.class).newInstance(context));
            return true;
        } catch (ClassNotFoundException e) {
            g(str, z, e);
            return false;
        } catch (IllegalAccessException e2) {
            g(str, z, e2);
            return false;
        } catch (InstantiationException e3) {
            g(str, z, e3);
            return false;
        } catch (NoSuchMethodException e4) {
            g(str, z, e4);
            return false;
        } catch (InvocationTargetException e5) {
            g(str, z, e5);
            return false;
        }
    }
}
