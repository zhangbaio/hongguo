package com.dragon.read.kmp.reader.detail.platform;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookDetailNoAudioSourceException extends Exception {
    public static final int $stable;

    static {
        Covode.recordClassIndex(608387);
        $stable = 8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BookDetailNoAudioSourceException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
