package com.dragon.read.kmp.widget;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.c0;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            Covode.recordClassIndex(609633);
            int[] iArr = new int[BrandBgType.values().length];
            try {
                iArr[BrandBgType.Fanqie.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BrandBgType.Hongguo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BrandBgType.FanqieWithDark.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[BrandBtnBgStyle.values().length];
            try {
                iArr2[BrandBtnBgStyle.BRAND_GRADIENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[BrandBtnBgStyle.BRAND_FORCE_GRADIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    static {
        Covode.recordClassIndex(609632);
    }

    public static final Modifier b(Modifier brandRadiusBg, float f, BrandBtnBgStyle brandStyle, BrandBgType brandBgType, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(brandRadiusBg, "$this$brandRadiusBg");
        Intrinsics.checkNotNullParameter(brandStyle, "brandStyle");
        Intrinsics.checkNotNullParameter(brandBgType, "brandBgType");
        composer.startReplaceGroup(1008820601);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1008820601, i, -1, "com.dragon.read.kmp.widget.brandRadiusBg (BrandBtnBg.kt:36)");
        }
        Modifier a2 = a(brandRadiusBg, k.g.c(f), brandStyle, brandBgType, composer, (i & 14) | (i & 896) | (i & 7168));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return a2;
    }

    private static final Modifier a(Modifier modifier, androidx.compose.ui.graphics.f2 f2Var, BrandBtnBgStyle brandBtnBgStyle, BrandBgType brandBgType, Composer composer, int i) {
        List listOf;
        composer.startReplaceGroup(1773940170);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1773940170, i, -1, "com.dragon.read.kmp.widget.brandRadiusBg (BrandBtnBg.kt:43)");
        }
        int i2 = a.b[brandBtnBgStyle.ordinal()];
        if (i2 != 1 && i2 != 2) {
            composer.startReplaceGroup(-345492622);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(androidx.compose.ui.graphics.l0.j(og4.a.a.h(composer, 6).f()));
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-2120712315);
            int i3 = a.a[brandBgType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        composer.startReplaceGroup(-345494564);
                        listOf = og4.a.a.h(composer, 6).d3();
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(-345504315);
                        composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    composer.startReplaceGroup(-345499052);
                    og4.a aVar = og4.a.a;
                    listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(aVar.h(composer, 6).e()), androidx.compose.ui.graphics.l0.j(aVar.h(composer, 6).a())});
                    composer.endReplaceGroup();
                }
            } else {
                composer.startReplaceGroup(-345502700);
                og4.a aVar2 = og4.a.a;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(aVar2.h(composer, 6).L()), androidx.compose.ui.graphics.l0.j(aVar2.h(composer, 6).c())});
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
        }
        Modifier b = BackgroundKt.b(modifier, c0.a.h(androidx.compose.ui.graphics.c0.b, listOf, a0.f.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), a0.f.e((Float.floatToRawIntBits(100.0f) & 4294967295L) | (Float.floatToRawIntBits(100.0f) << 32)), 0, 8, (Object) null), f2Var, 0.0f, 4, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return b;
    }
}
