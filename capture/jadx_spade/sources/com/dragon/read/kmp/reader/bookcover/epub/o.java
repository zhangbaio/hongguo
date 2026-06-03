package com.dragon.read.kmp.reader.bookcover.epub;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    static {
        Covode.recordClassIndex(608272);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(boolean z, Function0 function0, Function0 function02, Function0 function03, e eVar, int i, int i2, Composer composer, int i3) {
        e(z, function0, function02, function03, eVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(boolean z, Function0 function0, Function0 function02, Function0 function03, e eVar, int i, int i2, Composer composer, int i3) {
        e(z, function0, function02, function03, eVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function0<Unit> a;
        final /* synthetic */ Function0<Unit> b;
        final /* synthetic */ Function0<Unit> c;

        a(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
            this.a = function0;
            this.b = function02;
            this.c = function03;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            long i2;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1042222492, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.ShowCopyrightInfoDialog.<anonymous> (CopyrightInfoDialogHelper.android.kt:23)");
                }
                if (pm4.r.a(zl4.s.a.c(composer, zl4.s.b))) {
                    i2 = androidx.compose.ui.graphics.n0.d(4280821800L);
                } else {
                    i2 = androidx.compose.ui.graphics.l0.b.i();
                }
                BookCoverSheetContentKt.b(SizeKt.c(Modifier.Companion, 0.85f), this.a, i2, 0L, androidx.compose.runtime.internal.t.e(-219250245, true, new C0042a(this.b, this.c), composer, 54), composer, 24582, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* renamed from: com.dragon.read.kmp.reader.bookcover.epub.o$a$a, reason: collision with other inner class name */
        static final class C0042a implements Function3<androidx.compose.foundation.layout.b0, Composer, Integer, Unit> {
            final /* synthetic */ Function0<Unit> a;
            final /* synthetic */ Function0<Unit> b;

            C0042a(Function0<Unit> function0, Function0<Unit> function02) {
                this.a = function0;
                this.b = function02;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.b0 b0Var, Composer composer, Integer num) {
                a(b0Var, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void a(androidx.compose.foundation.layout.b0 BookCoverSheetContent, Composer composer, int i) {
                boolean z;
                Intrinsics.checkNotNullParameter(BookCoverSheetContent, "$this$BookCoverSheetContent");
                if ((i & 17) != 16) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-219250245, i, -1, "com.dragon.read.kmp.reader.bookcover.epub.ShowCopyrightInfoDialog.<anonymous>.<anonymous> (CopyrightInfoDialogHelper.android.kt:29)");
                    }
                    bm4.e0.j(this.a, this.b, composer, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final boolean r16, final kotlin.jvm.functions.Function0<kotlin.Unit> r17, kotlin.jvm.functions.Function0<kotlin.Unit> r18, kotlin.jvm.functions.Function0<kotlin.Unit> r19, final com.dragon.read.kmp.reader.bookcover.epub.e r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.bookcover.epub.o.e(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, com.dragon.read.kmp.reader.bookcover.epub.e, androidx.compose.runtime.Composer, int, int):void");
    }
}
