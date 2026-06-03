package com.ss.ugc.clientai.common;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class UtilsKt$toHex$1 extends Lambda implements Function1<Byte, CharSequence> {
    public static final UtilsKt$toHex$1 INSTANCE = new UtilsKt$toHex$1();

    UtilsKt$toHex$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
        return invoke(b.byteValue());
    }

    public final CharSequence invoke(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(this, *args)");
        return format;
    }
}
