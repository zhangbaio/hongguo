package com.dragon.read.kmp.shortvideo.distribution.page.view;

import androidx.compose.foundation.layout.v;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.a3;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import w0.s;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(609084);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(String str, Modifier modifier, long j, long j2, y yVar, c0 c0Var, j jVar, long j3, w0.i iVar, w0.h hVar, long j4, g3 g3Var, int i, int i2, int i3, Composer composer, int i4) {
        b(str, modifier, j, j2, yVar, c0Var, jVar, j3, iVar, hVar, j4, g3Var, composer, x2.a(i | 1), x2.a(i2), i3);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<v, Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ g3 b;
        final /* synthetic */ w0.h c;
        final /* synthetic */ a3 d;

        a(String str, g3 g3Var, w0.h hVar, a3 a3Var) {
            this.a = str;
            this.b = g3Var;
            this.c = hVar;
            this.d = a3Var;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            int i3;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-847647924, i2, -1, "com.dragon.read.kmp.shortvideo.distribution.page.view.BracketEllipsizeText.<anonymous> (BracketEllipsizeText.kt:87)");
                }
                int l = x0.b.l(BoxWithConstraints.e());
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(this.a) | composer.changed(this.b) | composer.changed(l);
                String str = this.a;
                g3 g3Var = this.b;
                a3 a3Var = this.d;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = b.e(str, g3Var, l, a3Var);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                a6.j((String) rememberedValue, (Modifier) null, 0L, 0L, (y) null, (c0) null, (j) null, 0L, (w0.i) null, this.c, 0L, s.b.e(), false, 1, 0, (Function1) null, this.b, composer, 0, 3504, 50686);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r8v7 */
    public static final String e(String str, g3 g3Var, int i, a3 a3Var) {
        boolean z;
        String str2;
        String str3 = "";
        if (i <= 0) {
            return "";
        }
        if (((int) (a3.d(a3Var, new androidx.compose.ui.text.e(str, (List) null, 2, (DefaultConstructorMarker) null), g3Var, 0, false, 1, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2028, (Object) null).c >> 32)) <= i) {
            return str;
        }
        Regex regex = new Regex("《[^》]*》");
        ArrayList<String> arrayList = new ArrayList();
        boolean z2 = false;
        int i2 = 2;
        ?? r8 = 0;
        int i3 = 0;
        for (MatchResult matchResult : Regex.findAll$default(regex, str, 0, 2, null)) {
            if (matchResult.getRange().getFirst() > i3) {
                String substring = str.substring(i3, matchResult.getRange().getFirst());
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                arrayList.add(substring);
            }
            arrayList.add(matchResult.getValue());
            i3 = matchResult.getRange().getLast() + 1;
        }
        if (i3 < str.length()) {
            String substring2 = str.substring(i3);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            arrayList.add(substring2);
        }
        String str4 = "";
        int i4 = 0;
        for (String str5 : arrayList) {
            if (StringsKt__StringsJVMKt.startsWith$default(str5, "《", z2, i2, null) && StringsKt__StringsJVMKt.endsWith$default(str5, "》", z2, i2, null)) {
                z = true;
            } else {
                z = false;
            }
            int i5 = i4 + ((int) (a3.d(a3Var, new androidx.compose.ui.text.e(str5, (List) null, i2, (DefaultConstructorMarker) null), g3Var, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2044, (Object) null).c >> 32));
            if (i5 <= i) {
                str4 = str4 + str5;
                i4 = i5;
                z2 = false;
                i2 = 2;
            } else {
                int i6 = i - i4;
                if (z) {
                    if (i6 >= ((int) (a3.d(a3Var, new androidx.compose.ui.text.e("《…》", (List) null, 2, (DefaultConstructorMarker) null), g3Var, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2044, (Object) null).c >> 32))) {
                        if (str5.length() < 2) {
                            str2 = "";
                        } else {
                            str2 = str5.substring(1, str5.length() - 1);
                            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                        }
                        int i7 = i6 - ((int) (a3.d(a3Var, new androidx.compose.ui.text.e("《》", (List) null, 2, (DefaultConstructorMarker) null), g3Var, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2044, (Object) null).c >> 32));
                        if (i7 > 0) {
                            int length = str2.length();
                            int i8 = 0;
                            while (i8 <= length) {
                                int i9 = (i8 + length) / 2;
                                String substring3 = str2.substring(0, i9);
                                Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                                String str6 = substring3 + "…";
                                if (((int) (a3.d(a3Var, new androidx.compose.ui.text.e(str6, (List) r8, 2, (DefaultConstructorMarker) r8), g3Var, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2044, (Object) null).c >> 32)) <= i7) {
                                    i8 = i9 + 1;
                                    str3 = str6;
                                } else {
                                    length = i9 - 1;
                                }
                                r8 = 0;
                            }
                            if (!Intrinsics.areEqual(str3, "…")) {
                                return str4 + "《" + str3 + "》";
                            }
                            return str4;
                        }
                        return str4;
                    }
                    return str4;
                }
                int i10 = (int) (a3.d(a3Var, new androidx.compose.ui.text.e("…", (List) null, 2, (DefaultConstructorMarker) null), g3Var, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2044, (Object) null).c >> 32);
                int i11 = i6 - i10;
                if (i11 <= 0) {
                    if (i6 >= i10) {
                        return str4 + "…";
                    }
                    return str4;
                }
                int length2 = str5.length();
                int i12 = 0;
                while (i12 <= length2) {
                    int i13 = (i12 + length2) / 2;
                    String substring4 = str5.substring(0, i13);
                    Intrinsics.checkNotNullExpressionValue(substring4, "substring(...)");
                    if (((int) (a3.d(a3Var, new androidx.compose.ui.text.e(substring4, (List) null, 2, (DefaultConstructorMarker) null), g3Var, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 2044, (Object) null).c >> 32)) <= i11) {
                        i12 = i13 + 1;
                        str3 = substring4;
                    } else {
                        length2 = i13 - 1;
                    }
                }
                return str4 + str3 + "…";
            }
        }
        return str4;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final java.lang.String r72, androidx.compose.ui.Modifier r73, long r74, long r76, androidx.compose.ui.text.font.y r78, androidx.compose.ui.text.font.c0 r79, androidx.compose.ui.text.font.j r80, long r81, w0.i r83, w0.h r84, long r85, androidx.compose.ui.text.g3 r87, androidx.compose.runtime.Composer r88, final int r89, final int r90, final int r91) {
        /*
            Method dump skipped, instructions count: 1012
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.page.view.b.b(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.y, androidx.compose.ui.text.font.c0, androidx.compose.ui.text.font.j, long, w0.i, w0.h, long, androidx.compose.ui.text.g3, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
