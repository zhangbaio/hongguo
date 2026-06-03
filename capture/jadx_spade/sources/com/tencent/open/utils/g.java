package com.tencent.open.utils;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.io.File;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g {
    private static Context a;

    static {
        Covode.recordClassIndex(653560);
    }

    public static final Context a() {
        Context context = a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final File d() {
        Context a2 = a();
        if (a2 != null) {
            return a2.getCacheDir();
        }
        return null;
    }

    public static final String b() {
        if (a() == null) {
            return "";
        }
        return a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final void a(Context context) {
        a = context;
    }

    public static final File a(String str) {
        return m.h(a(), str);
    }
}
