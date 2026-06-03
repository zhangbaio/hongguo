package com.dragon.read.openanim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.kotlin.UIKt;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e0 extends b {
    public static final a l;
    public static final int m;
    private final WeakReference<View> i;
    private final WeakReference<SimpleDraweeView> j;
    public float k;

    static {
        Covode.recordClassIndex(612653);
        l = new a(null);
        m = 8;
    }

    public static final e0 k(SimpleDraweeView simpleDraweeView) {
        return l.a(simpleDraweeView);
    }

    public static final e0 l(SimpleDraweeView simpleDraweeView, View view) {
        return l.b(simpleDraweeView, view);
    }

    @Override // com.dragon.read.openanim.b
    protected o g() {
        View view = this.i.get();
        SimpleDraweeView simpleDraweeView = this.j.get();
        if (view != null && simpleDraweeView != null) {
            return new p(m(view, simpleDraweeView, this.k));
        }
        return null;
    }

    @Override // com.dragon.read.openanim.b
    protected o h() {
        View view = this.i.get();
        SimpleDraweeView simpleDraweeView = this.j.get();
        if (view != null && simpleDraweeView != null) {
            return new p(m(view, simpleDraweeView, this.k));
        }
        return null;
    }

    public e0(WeakReference<View> drawView, WeakReference<SimpleDraweeView> boundView) {
        Intrinsics.checkNotNullParameter(drawView, "drawView");
        Intrinsics.checkNotNullParameter(boundView, "boundView");
        this.i = drawView;
        this.j = boundView;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(612654);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final e0 a(SimpleDraweeView boundView) {
            Intrinsics.checkNotNullParameter(boundView, "boundView");
            return c(this, boundView, null, 2, null);
        }

        public final e0 b(SimpleDraweeView boundView, View view) {
            Intrinsics.checkNotNullParameter(boundView, "boundView");
            if (view == null) {
                Object parent = boundView.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                } else {
                    view = null;
                }
                if (view == null) {
                    return null;
                }
            }
            if (boundView.getWidth() <= 0 || boundView.getHeight() <= 0) {
                return null;
            }
            return new e0(new WeakReference(view), new WeakReference(boundView));
        }

        public static /* synthetic */ e0 c(a aVar, SimpleDraweeView simpleDraweeView, View view, int i, Object obj) {
            if ((i & 2) != 0) {
                view = null;
            }
            return aVar.b(simpleDraweeView, view);
        }
    }

    private final RoundedBitmapDrawable m(View view, SimpleDraweeView simpleDraweeView, float f) {
        float[] fArr;
        int width = simpleDraweeView.getWidth();
        int height = simpleDraweeView.getHeight();
        boolean z = true;
        if (width <= 0 || height <= 0) {
            LogWrapper.error("Drawable", "width and height must be > 0" + simpleDraweeView, new Object[0]);
            width = 1;
            height = 1;
        }
        RoundingParams roundingParams = simpleDraweeView.getHierarchy().getRoundingParams();
        simpleDraweeView.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(0.0f));
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        view.draw(canvas);
        View s = com.dragon.read.base.depend.f0.b.s(view.getRootView());
        if (s != null && UIKt.isVisible(s) && s.getWidth() > 0 && s.getHeight() > 0) {
            s.draw(canvas);
        }
        simpleDraweeView.getHierarchy().setRoundingParams(roundingParams);
        RoundedBitmapDrawable roundedBitmapDrawable = new RoundedBitmapDrawable(view.getResources(), createBitmap);
        roundedBitmapDrawable.setBounds(0, 0, width, height);
        if (f != 0.0f) {
            z = false;
        }
        if (!z) {
            fArr = RoundingParams.fromCornersRadius(f).getCornersRadii();
        } else if (roundingParams != null) {
            fArr = roundingParams.getCornersRadii();
        } else {
            fArr = null;
        }
        roundedBitmapDrawable.setRadii(fArr);
        return roundedBitmapDrawable;
    }
}
