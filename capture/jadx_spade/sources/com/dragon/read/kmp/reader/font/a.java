package com.dragon.read.kmp.reader.font;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a implements x0 {
    static {
        Covode.recordClassIndex(608424);
    }

    @Override // com.dragon.read.kmp.reader.font.x0
    public void a(String str, double d, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    @Override // com.dragon.read.kmp.reader.font.x0
    public void onFailed(String str, String e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    @Override // com.dragon.read.kmp.reader.font.x0
    public void onStart(String str) {
    }
}
