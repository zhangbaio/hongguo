package com.dragon.read.lib.community.inner;

import com.bytedance.covode.number.Covode;
import com.dragon.read.saas.ugc.model.UgcUserSticker;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;
    private static final HashSet<vw1.a> b;
    public static final int c;

    private a() {
    }

    static {
        Covode.recordClassIndex(611452);
        a = new a();
        b = new HashSet<>();
        c = 8;
    }

    public final void b() {
        Iterator<T> it2 = b.iterator();
        while (it2.hasNext()) {
            ((vw1.a) it2.next()).f();
        }
    }

    public final void c() {
        Iterator<T> it2 = b.iterator();
        while (it2.hasNext()) {
            ((vw1.a) it2.next()).b();
        }
    }

    public final void a(vw1.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.add(listener);
    }

    public final void e(vw1.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.remove(listener);
    }

    public final void d(UgcUserSticker ugcUserSticker) {
        Iterator<T> it2 = b.iterator();
        while (it2.hasNext()) {
            ((vw1.a) it2.next()).e(ugcUserSticker);
        }
    }
}
