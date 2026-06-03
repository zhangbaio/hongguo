package com.dragon.read.component.shortvideo.api.scale;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.basescale.AppScaleManager;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xr3.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortSeriesScaleTextView extends AppCompatTextView implements a {
    private float a;
    private boolean b;

    static {
        Covode.recordClassIndex(598844);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortSeriesScaleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public float getCurrentScale() {
        return this.a;
    }

    public final void Y() {
        setCurrentScale(AppScaleManager.inst().getScaleTimes());
        this.b = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        setCurrentScale(1.0f);
        this.a = 1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        boolean z;
        float fontScale = ShortSeriesApi.Companion.c().getCurrentShortSeriesScaleConfig().getFontScale();
        if (this.a == fontScale) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            setCurrentScale(fontScale);
        }
        super/*android.widget.TextView*/.onAttachedToWindow();
    }

    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xr3.a
    public void setCurrentScale(float f) {
        if (this.b && f >= 0.0f) {
            Z(getTextSize(), this.a, f);
            this.a = f;
        }
    }

    public final void setEnableScale(boolean z) {
        boolean z2;
        this.b = z;
        float fontScale = ShortSeriesApi.Companion.c().getCurrentShortSeriesScaleConfig().getFontScale();
        if (this.b) {
            if (fontScale == this.a) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                setCurrentScale(fontScale);
                return;
            }
            return;
        }
        setCurrentScale(1.0f);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f * this.a);
    }

    private final void Z(float f, float f2, float f3) {
        super.setTextSize(0, (f * f3) / f2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortSeriesScaleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{2130773419});
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.b = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        this.a = 1.0f;
    }

    public /* synthetic */ ShortSeriesScaleTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
