package com.dragon.read.kmp.player.base.play.data;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.data.AbsPlayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a {
    public static final int b;
    public final AbsPlayList a;

    static {
        Covode.recordClassIndex(607928);
        b = 8;
    }

    public int b() {
        throw null;
    }

    public String c() {
        throw null;
    }

    public final JsonElement a() {
        return tk4.a.a.d(this.a.extras);
    }

    public a(AbsPlayList origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.a = origin;
    }
}
