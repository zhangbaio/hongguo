package com.dragon.read.lib.community.inner;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final b a;
    private static final Set<vw1.b> b;
    public static final int c;

    private b() {
    }

    static {
        Covode.recordClassIndex(611453);
        a = new b();
        b = new LinkedHashSet();
        c = 8;
    }

    public final void b() {
        int appTheme = c.a.b().a.c().getAppTheme();
        Iterator<vw1.b> it2 = b.iterator();
        while (it2.hasNext()) {
            it2.next().onThemeUpdate(appTheme);
        }
    }

    public final void a(vw1.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.add(listener);
    }

    public final void c(vw1.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.remove(listener);
    }
}
