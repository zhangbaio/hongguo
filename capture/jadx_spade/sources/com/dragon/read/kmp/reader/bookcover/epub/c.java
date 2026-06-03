package com.dragon.read.kmp.reader.bookcover.epub;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(608266);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Modifier modifier, String str, String str2, boolean z, Function4 function4, int i, int i2, Composer composer, int i3) {
        c(modifier, str, str2, z, function4, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function4 function4, androidx.compose.ui.layout.w coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        long a = coords.a();
        long f = androidx.compose.ui.layout.x.f(coords);
        if (function4 != null) {
            function4.invoke(Float.valueOf(Float.intBitsToFloat((int) (f >> 32))), Float.valueOf(Float.intBitsToFloat((int) (f & 4294967295L))), Float.valueOf((int) (a >> 32)), Float.valueOf((int) (a & 4294967295L)));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(androidx.compose.ui.Modifier r37, final java.lang.String r38, final java.lang.String r39, boolean r40, kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 801
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.bookcover.epub.c.c(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
