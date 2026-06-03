package aq4;

import a0.l;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.b1;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.x0;
import androidx.compose.ui.graphics.y;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.ui.GradientOrientation;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609414);
            int[] iArr = new int[GradientOrientation.values().length];
            try {
                iArr[GradientOrientation.LEFT_TO_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GradientOrientation.TOP_TO_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GradientOrientation.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GradientOrientation.BOTTOM_TO_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(609413);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(c1 graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.H(x0.a.c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, androidx.compose.ui.graphics.drawscope.c drawWithContent) {
        List listOf;
        c0 d;
        g gVar;
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.E1();
        float intBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.e() >> 32));
        long j = 4294967295L;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (drawWithContent.e() & 4294967295L));
        if (intBitsToFloat > 0.0f && intBitsToFloat2 > 0.0f) {
            g W0 = k.b.W0(new e((int) intBitsToFloat, (int) intBitsToFloat2, drawWithContent.M0(f), drawWithContent.M0(f2), drawWithContent.M0(f3), drawWithContent.M0(f4), drawWithContent.M0(f5), drawWithContent.M0(f6), drawWithContent.M0(f7), drawWithContent.M0(f8)));
            for (h hVar : W0.c) {
                float f9 = hVar.c - hVar.a;
                float f10 = hVar.d - hVar.b;
                if (f9 > 0.0f && f10 > 0.0f) {
                    gVar = W0;
                    DrawScope.-CC.p(drawWithContent, l0.b.a(), a0.f.e((Float.floatToRawIntBits(hVar.a) << 32) | (Float.floatToRawIntBits(hVar.b) & j)), l.d((Float.floatToRawIntBits(f9) << 32) | (Float.floatToRawIntBits(f10) & j)), 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (m0) null, y.a.j(), 56, (Object) null);
                } else {
                    gVar = W0;
                }
                W0 = gVar;
                j = 4294967295L;
            }
            for (i iVar : W0.d) {
                h hVar2 = iVar.a;
                float f11 = hVar2.c - hVar2.a;
                float f12 = hVar2.d - hVar2.b;
                if (f11 > 0.0f && f12 > 0.0f) {
                    GradientOrientation gradientOrientation = iVar.b;
                    int[] iArr = a.a;
                    int i = iArr[gradientOrientation.ordinal()];
                    if (i != 1 && i != 2) {
                        if (i != 3 && i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        l0.a aVar = l0.b;
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(aVar.g()), l0.j(aVar.a())});
                    } else {
                        l0.a aVar2 = l0.b;
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new l0[]{l0.j(aVar2.a()), l0.j(aVar2.g())});
                    }
                    int i2 = iArr[iVar.b.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        }
                        d = c0.a.p(c0.b, listOf, hVar2.b, hVar2.d, 0, 8, (Object) null);
                        c0 c0Var = d;
                        float f13 = hVar2.a;
                        DrawScope.-CC.o(drawWithContent, c0Var, a0.f.e((Float.floatToRawIntBits(hVar2.b) & 4294967295L) | (Float.floatToRawIntBits(f13) << 32)), l.d((Float.floatToRawIntBits(f11) << 32) | (Float.floatToRawIntBits(f12) & 4294967295L)), 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (m0) null, y.a.j(), 56, (Object) null);
                    }
                    d = c0.a.d(c0.b, listOf, hVar2.a, hVar2.c, 0, 8, (Object) null);
                    c0 c0Var2 = d;
                    float f132 = hVar2.a;
                    DrawScope.-CC.o(drawWithContent, c0Var2, a0.f.e((Float.floatToRawIntBits(hVar2.b) & 4294967295L) | (Float.floatToRawIntBits(f132) << 32)), l.d((Float.floatToRawIntBits(f11) << 32) | (Float.floatToRawIntBits(f12) & 4294967295L)), 0.0f, (androidx.compose.ui.graphics.drawscope.g) null, (m0) null, y.a.j(), 56, (Object) null);
                }
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public static final Modifier c(Modifier kmpGradientBlendMask, boolean z, final float f, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7, final float f8) {
        boolean z2;
        Intrinsics.checkNotNullParameter(kmpGradientBlendMask, "$this$kmpGradientBlendMask");
        if (!z) {
            return kmpGradientBlendMask;
        }
        if (f <= 0.0f && f2 <= 0.0f && f3 <= 0.0f && f4 <= 0.0f && f5 <= 0.0f && f6 <= 0.0f && f7 <= 0.0f && f8 <= 0.0f) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return kmpGradientBlendMask;
        }
        return androidx.compose.ui.draw.i.d(b1.a(kmpGradientBlendMask, new Function1() { // from class: aq4.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e;
                e = d.e((c1) obj);
                return e;
            }
        }), new Function1() { // from class: aq4.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f9;
                f9 = d.f(f, f2, f3, f4, f5, f6, f7, f8, (androidx.compose.ui.graphics.drawscope.c) obj);
                return f9;
            }
        });
    }

    public static /* synthetic */ Modifier d(Modifier modifier, boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i, Object obj) {
        boolean z2;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        if ((i & 1) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i & 2) != 0) {
            f9 = x0.i.g(0);
        } else {
            f9 = f;
        }
        if ((i & 4) != 0) {
            f10 = x0.i.g(0);
        } else {
            f10 = f2;
        }
        if ((i & 8) != 0) {
            f11 = x0.i.g(0);
        } else {
            f11 = f3;
        }
        if ((i & 16) != 0) {
            f12 = x0.i.g(0);
        } else {
            f12 = f4;
        }
        if ((i & 32) != 0) {
            f13 = x0.i.g(0);
        } else {
            f13 = f5;
        }
        if ((i & 64) != 0) {
            f14 = x0.i.g(0);
        } else {
            f14 = f6;
        }
        if ((i & 128) != 0) {
            f15 = x0.i.g(0);
        } else {
            f15 = f7;
        }
        if ((i & 256) != 0) {
            f16 = x0.i.g(0);
        } else {
            f16 = f8;
        }
        return c(modifier, z2, f9, f10, f11, f12, f13, f14, f15, f16);
    }
}
