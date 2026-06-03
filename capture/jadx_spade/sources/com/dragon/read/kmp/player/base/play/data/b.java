package com.dragon.read.kmp.player.base.play.data;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public static final int b;
    public final PlayEngineInfo a;

    static {
        Covode.recordClassIndex(607931);
        b = 8;
    }

    public b(PlayEngineInfo origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.a = origin;
    }
}
