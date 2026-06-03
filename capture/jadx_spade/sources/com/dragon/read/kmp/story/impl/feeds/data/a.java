package com.dragon.read.kmp.story.impl.feeds.data;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int e;
    public final String a;
    public int b;
    public String c;
    public String d;

    static {
        Covode.recordClassIndex(609265);
        e = 8;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public a(String chapterId) {
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        this.a = chapterId;
        this.c = "";
        this.d = "";
    }
}
