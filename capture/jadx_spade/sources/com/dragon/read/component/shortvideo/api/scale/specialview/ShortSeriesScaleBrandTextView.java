package com.dragon.read.component.shortvideo.api.scale.specialview;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.widget.brandbutton.BrandTextButton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xr3.a;
import xr3.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortSeriesScaleBrandTextView extends BrandTextButton implements a {
    private float l;

    static {
        Covode.recordClassIndex(598845);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortSeriesScaleBrandTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public float getCurrentScale() {
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        boolean z;
        super/*android.widget.TextView*/.onAttachedToWindow();
        c currentShortSeriesScaleConfig = ShortSeriesApi.Companion.c().getCurrentShortSeriesScaleConfig();
        if (this.l == currentShortSeriesScaleConfig.b()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            setCurrentScale(currentShortSeriesScaleConfig.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xr3.a
    public void setCurrentScale(float f) {
        super/*com.dragon.read.base.basescale.ScaleTextView*/.setTextSize(0, (getTextSize() * f) / this.l);
        this.l = f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortSeriesScaleBrandTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.l = 1.0f;
        revertScaleSize();
    }

    public /* synthetic */ ShortSeriesScaleBrandTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
