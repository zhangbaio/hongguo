package jq4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.text.y2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.utils.StringUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    static {
        Covode.recordClassIndex(609698);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(a aVar, g gVar, int i, int i2, Composer composer, int i3) {
        e(aVar, gVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(a aVar, g gVar, int i, Composer composer, int i2) {
        g(aVar, gVar, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(String str, g gVar, Function1 function1, int i, int i2, Composer composer, int i3) {
        l(str, gVar, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final String h(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void i(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(a aVar, MutableState mutableState, y2 it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        int k = it2.k();
        j jVar = j.a;
        StringBuilder sb = new StringBuilder();
        sb.append("buildClipContent ");
        int i = k - 1;
        sb.append(it2.x(i));
        sb.append(" lineCount:");
        sb.append(k);
        jVar.d("BookTitleText", sb.toString());
        if (it2.x(i)) {
            int l = ((it2.l(it2.k() - 1, true) - 1) - aVar.c.length()) + 1;
            if (l <= 0) {
                return Unit.INSTANCE;
            }
            String str = StringUtilsKt.c(h(mutableState), 0, l) + "…" + aVar.c;
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            i(mutableState, str);
        }
        return Unit.INSTANCE;
    }

    private static final void g(final a aVar, final g gVar, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(159185106);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(aVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(gVar)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        boolean z2 = false;
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(159185106, i2, -1, "com.dragon.read.kmp.widget.tag.buildClipContent (BookTitleText.kt:45)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(aVar.a, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            String h = h(mutableState);
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i2 & 14) == 4) {
                z2 = true;
            }
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: jq4.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit j;
                        j = f.j(a.this, mutableState, (y2) obj);
                        return j;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            l(h, gVar, (Function1) rememberedValue2, startRestartGroup, i2 & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: jq4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit k;
                    k = f.k(a.this, gVar, i, (Composer) obj, ((Integer) obj2).intValue());
                    return k;
                }
            });
        }
    }

    public static final void e(final a bookTextParams, final g gVar, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(bookTextParams, "bookTextParams");
        Composer startRestartGroup = composer.startRestartGroup(-1632768745);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            if (startRestartGroup.changed(bookTextParams)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changed(gVar)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        boolean z5 = false;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i6 != 0) {
                gVar = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1632768745, i3, -1, "com.dragon.read.kmp.widget.tag.BookTitleText (BookTitleText.kt:28)");
            }
            if (bookTextParams.b.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && !StringsKt__StringsJVMKt.startsWith$default(bookTextParams.a, bookTextParams.b, false, 2, null)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (bookTextParams.c.length() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4 && StringsKt__StringsJVMKt.endsWith$default(bookTextParams.a, bookTextParams.c, false, 2, null)) {
                z5 = true;
            }
            if (z3 && z5) {
                startRestartGroup.startReplaceGroup(-1308543438);
                g(bookTextParams, gVar, startRestartGroup, (i3 & 14) | (i3 & 112));
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1308671313);
                l(bookTextParams.a, gVar, null, startRestartGroup, i3 & 112, 4);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: jq4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = f.f(a.this, gVar, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void l(final java.lang.String r35, final jq4.g r36, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.y2, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jq4.f.l(java.lang.String, jq4.g, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
