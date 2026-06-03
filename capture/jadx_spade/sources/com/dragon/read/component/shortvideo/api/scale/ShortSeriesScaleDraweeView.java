package com.dragon.read.component.shortvideo.api.scale;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import xr3.a;
import xr3.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortSeriesScaleDraweeView extends SimpleDraweeView implements a {
    private float a;
    private float b;
    private boolean c;
    private boolean d;

    static {
        Covode.recordClassIndex(598840);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortSeriesScaleDraweeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public float getCurrentScale() {
        return this.a;
    }

    protected void onDetachedFromWindow() {
        super/*com.facebook.drawee.view.DraweeView*/.onDetachedFromWindow();
        setCurrentScale(1.0f);
        this.a = 1.0f;
        this.b = 1.0f;
    }

    protected void onAttachedToWindow() {
        boolean z;
        super/*com.facebook.drawee.view.DraweeView*/.onAttachedToWindow();
        float a = ShortSeriesApi.Companion.c().getCurrentShortSeriesScaleConfig().a();
        if (this.a == a) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            setCurrentScale(a);
        }
    }

    @Override // xr3.a
    public void setCurrentScale(float f) {
        if (this.c && f > 0.0f) {
            a(f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(float f) {
        boolean z;
        int roundToInt;
        int roundToInt2;
        float f2 = this.a;
        if (f == f2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        this.b = f;
        float f3 = f / f2;
        this.d = true;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(layoutParams.width * f3);
            layoutParams.width = roundToInt;
            roundToInt2 = MathKt__MathJVMKt.roundToInt(layoutParams.height * f3);
            layoutParams.height = roundToInt2;
        } else {
            layoutParams = null;
        }
        setLayoutParams(layoutParams);
        this.d = false;
        this.a = this.b;
    }

    public final void setEnableScale(boolean z) {
        boolean z2 = false;
        if (z) {
            if (!this.c) {
                this.c = true;
                float a = ShortSeriesApi.Companion.c().getCurrentShortSeriesScaleConfig().a();
                if (this.a == a) {
                    z2 = true;
                }
                if (!z2) {
                    setCurrentScale(a);
                    return;
                }
                return;
            }
            return;
        }
        setCurrentScale(1.0f);
        this.c = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        int roundToInt;
        int roundToInt2;
        if (this.d) {
            super/*android.widget.ImageView*/.setLayoutParams(layoutParams);
            return;
        }
        if (layoutParams != null && b.a(layoutParams)) {
            roundToInt = MathKt__MathJVMKt.roundToInt(layoutParams.width * this.a);
            layoutParams.width = roundToInt;
            roundToInt2 = MathKt__MathJVMKt.roundToInt(layoutParams.height * this.a);
            layoutParams.height = roundToInt2;
        }
        super/*android.widget.ImageView*/.setLayoutParams(layoutParams);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortSeriesScaleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = 1.0f;
        this.b = 1.0f;
        this.c = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{2130773410});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.c = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ ShortSeriesScaleDraweeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? -1 : i);
    }
}
