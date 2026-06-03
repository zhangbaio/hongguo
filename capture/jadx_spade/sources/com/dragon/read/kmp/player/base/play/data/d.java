package com.dragon.read.kmp.player.base.play.data;

import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final int d;
    public a a;
    public String b = "unKnow";
    public Map<String, String> c = new HashMap();

    static {
        Covode.recordClassIndex(607944);
        d = 8;
    }

    public final void a(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.c = map;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }
}
