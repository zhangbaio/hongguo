package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j0 {
    public static final j0 a;

    static {
        Covode.recordClassIndex(608874);
        a = new j0();
    }

    private j0() {
    }

    public final void e() {
        o oVar = (o) eo0.c.a.a(Reflection.getOrCreateKotlinClass(o.class));
        if (oVar != null) {
            oVar.stopPlayer();
        }
    }

    public final boolean a(String str) {
        o oVar = (o) eo0.c.a.a(Reflection.getOrCreateKotlinClass(o.class));
        if (oVar != null) {
            return oVar.isAudioPlaying(str);
        }
        return false;
    }

    public final void d(c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        o oVar = (o) eo0.c.a.a(Reflection.getOrCreateKotlinClass(o.class));
        if (oVar != null) {
            oVar.j3(listener);
        }
    }

    public final void f(c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        o oVar = (o) eo0.c.a.a(Reflection.getOrCreateKotlinClass(o.class));
        if (oVar != null) {
            oVar.X8(listener);
        }
    }

    public final void b(String bookId, String coverUrl, String bookName, String playScene, ym4.k pageRecorder, String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(bookName, "bookName");
        Intrinsics.checkNotNullParameter(playScene, "playScene");
        Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
        o oVar = (o) eo0.c.a.a(Reflection.getOrCreateKotlinClass(o.class));
        if (oVar != null) {
            oVar.N7(bookId, coverUrl, bookName, playScene, pageRecorder, str, map);
        }
    }

    public static /* synthetic */ void c(j0 j0Var, String str, String str2, String str3, String str4, ym4.k kVar, String str5, Map map, int i, Object obj) {
        String str6;
        Map map2;
        if ((i & 32) != 0) {
            str6 = null;
        } else {
            str6 = str5;
        }
        if ((i & 64) != 0) {
            map2 = null;
        } else {
            map2 = map;
        }
        j0Var.b(str, str2, str3, str4, kVar, str6, map2);
    }
}
