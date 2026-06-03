package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class x0 implements w {
    public static final x0 a;

    static {
        Covode.recordClassIndex(608886);
        a = new x0();
    }

    private x0() {
    }

    @Override // com.dragon.read.kmp.service.w
    public void U(String seriesId, Object anchorInfo) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        w wVar = (w) eo0.c.a.a(Reflection.getOrCreateKotlinClass(w.class));
        if (wVar != null) {
            wVar.U(seriesId, anchorInfo);
        }
    }

    @Override // com.dragon.read.kmp.service.w
    public Object x0(String seriesId, String vid) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(vid, "vid");
        w wVar = (w) eo0.c.a.a(Reflection.getOrCreateKotlinClass(w.class));
        if (wVar != null) {
            return wVar.x0(seriesId, vid);
        }
        return null;
    }
}
