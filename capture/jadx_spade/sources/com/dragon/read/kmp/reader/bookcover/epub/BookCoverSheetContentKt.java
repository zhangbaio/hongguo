package com.dragon.read.kmp.reader.bookcover.epub;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.k3;
import androidx.compose.foundation.layout.s3;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookCoverSheetContentKt {
    static {
        Covode.recordClassIndex(608270);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Modifier modifier, Function0 function0, long j, long j2, Function3 function3, int i, int i2, Composer composer, int i3) {
        b(modifier, function0, j, j2, function3, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.b0, Composer, Integer, Unit> {
        final /* synthetic */ Modifier a;
        final /* synthetic */ Function3<androidx.compose.foundation.layout.b0, Composer, Integer, Unit> b;

        a(Modifier modifier, Function3<? super androidx.compose.foundation.layout.b0, ? super Composer, ? super Integer, Unit> function3) {
            this.a = modifier;
            this.b = function3;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.b0 b0Var, Composer composer, Integer num) {
            a(b0Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.b0 ModalBottomSheetLayout, Composer composer, int i) {
            boolean z;
            int i2;
            Intrinsics.checkNotNullParameter(ModalBottomSheetLayout, "$this$ModalBottomSheetLayout");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1526593980, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContent.<anonymous>.<anonymous> (BookCoverSheetContent.kt:83)");
                }
                float f = 16;
                Modifier e = WindowInsetsPaddingKt.e(f2.v(this.a, x0.i.g(f), x0.i.g(8), x0.i.g(f), 0.0f, 8, (Object) null), s3.b(k3.a, composer, 6));
                Function3<androidx.compose.foundation.layout.b0, Composer, Integer, Unit> function3 = this.b;
                e.m i3 = androidx.compose.foundation.layout.e.a.i();
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.layout.p0 a = androidx.compose.foundation.layout.x.a(i3, aVar.k(), composer, 0);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(composer, e);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a3 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a3);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, a, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e2, companion.d());
                androidx.compose.foundation.layout.c0 c0Var = androidx.compose.foundation.layout.c0.b;
                if (pm4.r.a(zl4.s.a.c(composer, zl4.s.b))) {
                    i2 = 452984831;
                } else {
                    i2 = 436207616;
                }
                androidx.compose.foundation.layout.m.b(BackgroundKt.c(SizeKt.i(SizeKt.x(c0Var.b(Modifier.Companion, aVar.g()), x0.i.g(36)), x0.i.g(4)), androidx.compose.ui.graphics.n0.b(i2), k.g.c(x0.i.g(2))), composer, 0);
                function3.invoke(c0Var, composer, 6);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(androidx.compose.ui.Modifier r29, final kotlin.jvm.functions.Function0<kotlin.Unit> r30, long r31, long r33, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.b0, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.bookcover.epub.BookCoverSheetContentKt.b(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
