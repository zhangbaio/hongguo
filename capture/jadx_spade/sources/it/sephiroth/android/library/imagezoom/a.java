package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends ImageViewTouchBase {
    protected float A;
    protected int B;
    protected GestureDetector.OnGestureListener C;
    protected ScaleGestureDetector.OnScaleGestureListener D;
    protected boolean E;
    protected boolean F;
    protected boolean G;
    private c H;
    protected ScaleGestureDetector x;
    protected GestureDetector y;
    protected int z;

    public interface b {
    }

    public interface c {
        void a();
    }

    static {
        Covode.recordClassIndex(657854);
    }

    public boolean K(MotionEvent motionEvent) {
        return true;
    }

    public boolean N(MotionEvent motionEvent) {
        return true;
    }

    public boolean O(MotionEvent motionEvent) {
        return true;
    }

    public void setDoubleTapListener(b bVar) {
    }

    public boolean getDoubleTapEnabled() {
        return this.E;
    }

    protected GestureDetector.OnGestureListener getGestureListener() {
        return new C0194a();
    }

    protected ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new d();
    }

    public void setDoubleTapEnabled(boolean z) {
        this.E = z;
    }

    public void setScaleEnabled(boolean z) {
        this.F = z;
    }

    public void setScrollEnabled(boolean z) {
        this.G = z;
    }

    public void setSingleTapListener(c cVar) {
        this.H = cVar;
    }

    /* renamed from: it.sephiroth.android.library.imagezoom.a$a, reason: collision with other inner class name */
    public class C0194a extends GestureDetector.SimpleOnGestureListener {
        static {
            Covode.recordClassIndex(657855);
        }

        public C0194a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return a.this.K(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return a.this.O(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (a.this.isLongClickable() && !a.this.x.isInProgress()) {
                a.this.setPressed(true);
                a.this.performLongClick();
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (a.this.H != null) {
                a.this.H.a();
            }
            return a.this.N(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Log.i("ImageViewTouchBase", "onDoubleTap. double tap enabled? " + a.this.E);
            a aVar = a.this;
            if (aVar.E) {
                aVar.g = true;
                float scale = aVar.getScale();
                a aVar2 = a.this;
                a.this.F(Math.min(a.this.getMaxScale(), Math.max(aVar2.J(scale, aVar2.getMaxScale()), a.this.getMinScale())), motionEvent.getX(), motionEvent.getY(), 200.0f);
                a.this.invalidate();
            }
            a.H(a.this);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!a.this.G || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1 || a.this.x.isInProgress() || a.this.getScale() == 1.0f) {
                return false;
            }
            return a.this.L(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!a.this.G || motionEvent == null || motionEvent2 == null || motionEvent.getPointerCount() > 1 || motionEvent2.getPointerCount() > 1 || a.this.x.isInProgress()) {
                return false;
            }
            return a.this.M(motionEvent, motionEvent2, f, f2);
        }
    }

    static /* synthetic */ b H(a aVar) {
        aVar.getClass();
        return null;
    }

    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        protected boolean a = false;

        static {
            Covode.recordClassIndex(657858);
        }

        public d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float currentSpan = scaleGestureDetector.getCurrentSpan() - scaleGestureDetector.getPreviousSpan();
            float scale = a.this.getScale() * scaleGestureDetector.getScaleFactor();
            a aVar = a.this;
            if (aVar.F) {
                boolean z = this.a;
                if (z && currentSpan != 0.0f) {
                    aVar.g = true;
                    a.this.E(Math.min(aVar.getMaxScale(), Math.max(scale, a.this.getMinScale() - 0.1f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    a aVar2 = a.this;
                    aVar2.B = 1;
                    aVar2.invalidate();
                    return true;
                }
                if (!z) {
                    this.a = true;
                }
            }
            return true;
        }
    }

    public boolean P(MotionEvent motionEvent) {
        if (getScale() < getMinScale()) {
            D(getMinScale(), 50.0f);
            return true;
        }
        return true;
    }

    @Override // it.sephiroth.android.library.imagezoom.ImageViewTouchBase
    protected void s(float f) {
        if (f < getMinScale()) {
            D(getMinScale(), 50.0f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x.onTouchEvent(motionEvent);
        if (!this.x.isInProgress()) {
            this.y.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() & 255) != 1) {
            return true;
        }
        return P(motionEvent);
    }

    public boolean I(int i) {
        RectF bitmapRect = getBitmapRect();
        B(bitmapRect, this.w);
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (bitmapRect == null) {
            return false;
        }
        float f = bitmapRect.right;
        int i2 = rect.right;
        if (f >= i2 && i < 0) {
            if (Math.abs(f - i2) <= 1.0f) {
                return false;
            }
            return true;
        }
        if (Math.abs(bitmapRect.left - this.w.left) <= 1.0d) {
            return false;
        }
        return true;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected float J(float f, float f2) {
        if (this.B == 1) {
            float f3 = this.A;
            if ((2.0f * f3) + f <= f2) {
                return f + f3;
            }
            this.B = -1;
            return f2;
        }
        this.B = 1;
        return 1.0f;
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.E = true;
        this.F = true;
        this.G = true;
    }

    @Override // it.sephiroth.android.library.imagezoom.ImageViewTouchBase
    protected void n(Context context, AttributeSet attributeSet, int i) {
        super.n(context, attributeSet, i);
        this.z = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.C = getGestureListener();
        this.D = getScaleListener();
        this.x = new ScaleGestureDetector(getContext(), this.D);
        this.y = new GestureDetector(getContext(), this.C, null, true);
        this.B = 1;
    }

    @Override // it.sephiroth.android.library.imagezoom.ImageViewTouchBase
    protected void a(Drawable drawable, Matrix matrix, float f, float f2) {
        super.a(drawable, matrix, f, f2);
        this.A = getMaxScale() / 3.0f;
    }

    public boolean M(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (getScale() == 1.0f) {
            return false;
        }
        this.g = true;
        x(-f, -f2);
        invalidate();
        return true;
    }

    public boolean L(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x = motionEvent2.getX() - motionEvent.getX();
        float y = motionEvent2.getY() - motionEvent.getY();
        if (Math.abs(f) <= 800.0f && Math.abs(f2) <= 800.0f) {
            return false;
        }
        this.g = true;
        y(x / 2.0f, y / 2.0f, 300.0d);
        invalidate();
        return true;
    }
}
