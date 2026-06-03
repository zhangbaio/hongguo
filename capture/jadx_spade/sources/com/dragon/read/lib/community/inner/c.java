package com.dragon.read.lib.community.inner;

import com.bytedance.covode.number.Covode;
import com.dragon.read.saas.ugc.model.UgcUserSticker;
import com.ss.android.messagebus.BusProvider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;
    public static oq4.a b;
    public static yq4.a c;
    public static final int d;

    static {
        Covode.recordClassIndex(611454);
        a = new c();
        d = 8;
    }

    private c() {
    }

    public final void i() {
        b.a.b();
    }

    public final oq4.a a() {
        oq4.a aVar = b;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }

    public final yq4.a b() {
        yq4.a aVar = c;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("depend");
        return null;
    }

    public final void e() {
        a.a.b();
        BusProvider.post(new ry1.b());
    }

    public final void f() {
        a.a.c();
        BusProvider.post(new ry1.b());
    }

    public final void h(UgcUserSticker ugcUserSticker) {
        a.a.d(ugcUserSticker);
    }

    public final void j(oq4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        b = aVar;
    }

    public final void k(yq4.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        c = aVar;
    }

    public final void d(boolean z) {
        BusProvider.post(new ry1.a(z));
    }

    public final void g(yy1.b basicUserInfo) {
        Intrinsics.checkNotNullParameter(basicUserInfo, "basicUserInfo");
        BusProvider.post(new ry1.c(basicUserInfo));
    }

    public final void c(oq4.a config, yq4.a depend) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(depend, "depend");
        j(config);
        k(depend);
        com.dragon.community.saas.utils.a.b(depend.a.c().getAppContext());
        t92.c.d().c(com.dragon.community.saas.utils.a.a());
    }
}
