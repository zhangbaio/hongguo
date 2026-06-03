package com.dragon.read.openanim;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.openanim.d0;
import com.dragon.read.openanim.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d0 extends g {
    public static final int l;

    static {
        Covode.recordClassIndex(612650);
        l = 8;
    }

    public static final class a implements v.a {
        final /* synthetic */ Function0<Unit> b;

        @Override // com.dragon.read.openanim.v.a
        public /* synthetic */ void b(v vVar) {
            u.a(this, vVar);
        }

        @Override // com.dragon.read.openanim.v.a
        public void a(v animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            final d0 d0Var = d0.this;
            final Function0<Unit> function0 = this.b;
            ThreadUtils.postInForeground(new Runnable() { // from class: com.dragon.read.openanim.c0
                @Override // java.lang.Runnable
                public final void run() {
                    d0.a.d(d0.this, function0);
                }
            });
        }

        a(Function0<Unit> function0) {
            this.b = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(d0 d0Var, Function0 function0) {
            d0Var.h = false;
            function0.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(BookOpenAnimTask bookOpenAnimTask, Function0<Unit> onDestroyAction) {
        super(bookOpenAnimTask, onDestroyAction);
        Intrinsics.checkNotNullParameter(bookOpenAnimTask, "bookOpenAnimTask");
        Intrinsics.checkNotNullParameter(onDestroyAction, "onDestroyAction");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(d0 d0Var, TypeEvaluator typeEvaluator, v vVar, v vVar2) {
        d0Var.g = (c) typeEvaluator.evaluate(vVar.c(), null, null);
    }

    @Override // com.dragon.read.openanim.g
    protected v m(boolean z, final Drawable drawable, Rect cardRect, final Rect cardInPicTextDetailRect, final Matrix matrix, Matrix matrix2, final Rect rect, Function0<Unit> endAction) {
        final float f;
        final float f2;
        float f3;
        Intrinsics.checkNotNullParameter(cardRect, "cardRect");
        Intrinsics.checkNotNullParameter(cardInPicTextDetailRect, "cardInPicTextDetailRect");
        Intrinsics.checkNotNullParameter(endAction, "endAction");
        final float width = cardRect.width();
        final float height = cardRect.height();
        final float width2 = cardInPicTextDetailRect.width();
        final float height2 = cardInPicTextDetailRect.height();
        if (rect != null) {
            f = rect.width();
        } else {
            f = width2;
        }
        if (rect != null) {
            f2 = rect.height();
        } else {
            f2 = height2;
        }
        final float f4 = cardRect.left;
        final float f5 = cardRect.top;
        final TypeEvaluator typeEvaluator = new TypeEvaluator() { // from class: com.dragon.read.openanim.a0
            @Override // android.animation.TypeEvaluator
            public final Object evaluate(float f6, Object obj, Object obj2) {
                c r;
                r = d0.r(width, width2, height, height2, cardInPicTextDetailRect, f4, f5, this, matrix, f, f2, rect, drawable, f6, (c) obj, (c) obj2);
                return r;
            }
        };
        this.h = true;
        final v vVar = new v();
        this.f = vVar;
        if (z) {
            vVar.m(this.a.a.c);
            vVar.i = this.a.a.e;
        } else {
            vVar.m(this.a.a.b);
            vVar.i = this.a.a.d;
        }
        vVar.a(new a(endAction));
        if (z) {
            f3 = 1.0f;
        } else {
            f3 = 0.0f;
        }
        this.g = (c) typeEvaluator.evaluate(f3, null, null);
        vVar.b(new v.b() { // from class: com.dragon.read.openanim.b0
            @Override // com.dragon.read.openanim.v.b
            public final void a(v vVar2) {
                d0.s(d0.this, typeEvaluator, vVar, vVar2);
            }
        });
        vVar.p(z);
        LogWrapper.info("BookOpenAnimExecutor", "start, reverse: " + z, new Object[0]);
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c r(float f, float f2, float f3, float f4, Rect rect, float f5, float f6, d0 d0Var, Matrix matrix, float f7, float f8, Rect rect2, Drawable drawable, float f9, c cVar, c cVar2) {
        Matrix matrix2;
        float f10;
        float f11;
        int i;
        float f12 = (((f2 - f) * f9) + f) / f;
        float f13 = (((f4 - f3) * f9) + f3) / f3;
        float f14 = 1 - f9;
        float f15 = f5 * f14;
        float f16 = (rect.left * f9) + f15;
        float f17 = f6 * f14;
        float f18 = (rect.top * f9) + f17;
        if (d0Var.g()) {
            matrix2 = d0Var.d;
            matrix2.reset();
            matrix2.preScale(f12, f13);
            matrix2.postTranslate(f16, f18);
        } else {
            matrix2 = null;
        }
        if (matrix != null && matrix2 != null) {
            matrix2.preConcat(matrix);
        }
        float f19 = f + ((f7 - f) * f9);
        float f20 = f3 + ((f8 - f3) * f9);
        if (rect2 != null) {
            f10 = rect2.width();
        } else {
            f10 = f19;
        }
        float f21 = f19 / f10;
        if (rect2 != null) {
            f11 = rect2.height();
        } else {
            f11 = f20;
        }
        float f22 = f20 / f11;
        int i2 = 0;
        if (rect2 != null) {
            i = rect2.left;
        } else {
            i = 0;
        }
        float f23 = (i * f9) + f15;
        if (rect2 != null) {
            i2 = rect2.top;
        }
        Matrix matrix3 = d0Var.e;
        matrix3.reset();
        matrix3.postScale(f21, f22);
        matrix3.postTranslate(f23, (i2 * f9) + f17);
        return new c(f9, drawable, matrix3, matrix2);
    }
}
