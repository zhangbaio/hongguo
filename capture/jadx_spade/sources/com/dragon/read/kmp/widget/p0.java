package com.dragon.read.kmp.widget;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p0 {
    static {
        Covode.recordClassIndex(609648);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(androidx.compose.foundation.layout.v vVar, BookType bookType, float f, float f2, float f3, boolean z, Function1 function1, int i, int i2, Composer composer, int i3) {
        f(vVar, bookType, f, f2, f3, z, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(androidx.compose.foundation.layout.v vVar, boolean z, float f, float f2, float f3, String str, boolean z2, BookType bookType, com.bytedance.kmp.image.options.i iVar, int i, int i2, Composer composer, int i3) {
        i(vVar, z, f, f2, f3, str, z2, bookType, iVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String str, BookType bookType, float f, boolean z, boolean z2, float f2, float f3, float f4, float f5, float f6, boolean z3, Modifier modifier, Function1 function1, com.bytedance.kmp.image.options.i iVar, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        k(str, bookType, f, z, z2, f2, f3, f4, f5, f6, z3, modifier, function1, iVar, function3, composer, x2.a(i | 1), x2.a(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(androidx.compose.foundation.layout.v vVar, BookType bookType, int i, Composer composer, int i2) {
        m(vVar, bookType, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final float r(float f) {
        if (f < 73.0f) {
            return x0.i.g(4);
        }
        if (f < 120.0f) {
            return x0.i.g(6);
        }
        if (f < 160.0f) {
            return x0.i.g(8);
        }
        return x0.i.g(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    static final class a implements Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;
        final /* synthetic */ String e;
        final /* synthetic */ boolean f;
        final /* synthetic */ BookType g;
        final /* synthetic */ com.bytedance.kmp.image.options.i h;
        final /* synthetic */ Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> i;
        final /* synthetic */ float j;
        final /* synthetic */ float k;
        final /* synthetic */ float l;
        final /* synthetic */ boolean m;
        final /* synthetic */ Function1<Boolean, Unit> n;

        /* JADX WARN: Multi-variable type inference failed */
        a(boolean z, float f, float f2, float f3, String str, boolean z2, BookType bookType, com.bytedance.kmp.image.options.i iVar, Function3<? super androidx.compose.foundation.layout.v, ? super Composer, ? super Integer, Unit> function3, float f4, float f5, float f6, boolean z3, Function1<? super Boolean, Unit> function1) {
            this.a = z;
            this.b = f;
            this.c = f2;
            this.d = f3;
            this.e = str;
            this.f = z2;
            this.g = bookType;
            this.h = iVar;
            this.i = function3;
            this.j = f4;
            this.k = f5;
            this.l = f6;
            this.m = z3;
            this.n = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.v vVar, Composer composer, Integer num) {
            a(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.v BoxWithConstraints, Composer composer, int i) {
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
                    ComposerKt.traceEventStart(906389865, i2, -1, "com.dragon.read.kmp.widget.CoverView.<anonymous> (CoverView.kt:80)");
                }
                int i4 = i2 & 14;
                p0.i(BoxWithConstraints, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, composer, i4, 0);
                composer.startReplaceGroup(-837692209);
                Function3<androidx.compose.foundation.layout.v, Composer, Integer, Unit> function3 = this.i;
                if (function3 != null) {
                    function3.invoke(BoxWithConstraints, composer, Integer.valueOf(i4));
                }
                composer.endReplaceGroup();
                p0.f(BoxWithConstraints, this.g, this.j, this.k, this.l, this.m, this.n, composer, i4, 0);
                p0.m(BoxWithConstraints, this.g, composer, i4);
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
    public static final void m(final androidx.compose.foundation.layout.v vVar, final BookType bookType, Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-686675780);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(vVar)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(bookType.ordinal())) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-686675780, i2, -1, "com.dragon.read.kmp.widget.SeriesContainer (CoverView.kt:134)");
            }
            if (bookType == BookType.SHORT_SERIES) {
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(iy2.c0.s(iy2.e0.a), startRestartGroup, 0), (String) null, SizeKt.s(vVar.b(Modifier.Companion, androidx.compose.ui.e.a.e()), x0.i.g(vVar.g() / 4)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (androidx.compose.ui.graphics.m0) null, 0, startRestartGroup, 48, 248);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit n;
                    n = p0.n(vVar, bookType, i, (Composer) obj, ((Integer) obj2).intValue());
                    return n;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final androidx.compose.foundation.layout.v r32, final com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType r33, final float r34, final float r35, final float r36, final boolean r37, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.p0.f(androidx.compose.foundation.layout.v, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType, float, float, float, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final androidx.compose.foundation.layout.v r28, final boolean r29, final float r30, final float r31, final float r32, final java.lang.String r33, final boolean r34, final com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType r35, com.bytedance.kmp.image.options.i r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.p0.i(androidx.compose.foundation.layout.v, boolean, float, float, float, java.lang.String, boolean, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType, com.bytedance.kmp.image.options.i, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k(final java.lang.String r31, final com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType r32, final float r33, boolean r34, final boolean r35, final float r36, final float r37, final float r38, final float r39, final float r40, final boolean r41, androidx.compose.ui.Modifier r42, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r43, com.bytedance.kmp.image.options.i r44, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.v, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 715
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.p0.k(java.lang.String, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType, float, boolean, boolean, float, float, float, float, float, boolean, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, com.bytedance.kmp.image.options.i, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
