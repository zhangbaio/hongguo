package com.dragon.read.openanim;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PicTextDetailTransitionRootView extends TransitionRootView {
    public static final a i;
    public static final int j;

    public static final class a {
        static {
            Covode.recordClassIndex(612652);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(612651);
        i = new a(null);
        j = 8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PicTextDetailTransitionRootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int z(float f) {
        if (f < 0.8f) {
            return 255;
        }
        float f2 = 5;
        return (int) (255 * (f2 - (f * f2)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dragon.read.openanim.TransitionRootView
    protected void l(Canvas canvas, c animValue) {
        int width;
        Integer num;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(animValue, "animValue");
        g bookOpenAnimExecutor = getBookOpenAnimExecutor();
        boolean z = false;
        if (bookOpenAnimExecutor != null && bookOpenAnimExecutor.g()) {
            z = true;
        }
        if (z) {
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), 255);
            canvas.setMatrix(animValue.c);
            float width2 = getWidth();
            Drawable drawable = animValue.b;
            if (drawable != null) {
                width = drawable.getIntrinsicWidth();
            } else {
                width = getWidth();
            }
            float f = width2 / width;
            g bookOpenAnimExecutor2 = getBookOpenAnimExecutor();
            if (bookOpenAnimExecutor2 != null) {
                num = Integer.valueOf(bookOpenAnimExecutor2.d());
            } else {
                num = null;
            }
            if (num != null && num.intValue() > 0) {
                getClipPath().reset();
                float f2 = f - 1.0f;
                getClipPath().addRoundRect(0.0f, 0.0f, getWidth(), getHeight(), num.intValue() + (num.intValue() * f2 * animValue.a), (num.intValue() * f2 * animValue.a) + num.intValue(), Path.Direction.CW);
                canvas.clipPath(getClipPath());
            }
            super.y(canvas);
            canvas.restore();
            canvas.save();
            Matrix matrix = animValue.d;
            if (matrix != null) {
                canvas.setMatrix(matrix);
            }
            int z2 = z(animValue.a);
            Drawable drawable2 = animValue.b;
            if (drawable2 != null) {
                drawable2.setAlpha(z2);
            }
            Drawable drawable3 = animValue.b;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
            canvas.restore();
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicTextDetailTransitionRootView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PicTextDetailTransitionRootView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
