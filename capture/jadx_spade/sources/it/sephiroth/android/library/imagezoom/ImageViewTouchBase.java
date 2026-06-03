package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ImageViewTouchBase extends ImageView {
    protected om6.b a;
    protected Matrix b;
    protected Matrix c;
    protected Matrix d;
    protected Handler e;
    protected Runnable f;
    protected boolean g;
    private float h;
    private float i;
    private boolean j;
    private boolean k;
    protected final Matrix l;
    protected final float[] m;
    private int n;
    private int o;
    private PointF p;
    protected DisplayType q;
    private boolean r;
    private boolean s;
    protected final int t;
    protected RectF u;
    protected RectF v;
    protected RectF w;

    public interface d {
    }

    public interface e {
    }

    static {
        Covode.recordClassIndex(657859);
    }

    protected void e(Drawable drawable) {
    }

    protected void f(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public float getRotation() {
        return 0.0f;
    }

    protected void p() {
    }

    protected void r(float f) {
    }

    protected void s(float f) {
    }

    public void setOnDrawableChangedListener(d dVar) {
    }

    public void setOnLayoutChangeListener(e eVar) {
    }

    protected PointF getCenter() {
        return this.p;
    }

    public DisplayType getDisplayType() {
        return this.q;
    }

    public float getBaseScale() {
        return l(this.b);
    }

    public RectF getBitmapRect() {
        return g(this.c);
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.c);
    }

    public Matrix getImageViewMatrix() {
        return j(this.c);
    }

    public float getScale() {
        return l(this.c);
    }

    class a implements Runnable {
        final /* synthetic */ Drawable a;
        final /* synthetic */ Matrix b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;

        @Override // java.lang.Runnable
        public void run() {
            ImageViewTouchBase.this.A(this.a, this.b, this.c, this.d);
        }

        a(Drawable drawable, Matrix matrix, float f, float f2) {
            this.a = drawable;
            this.b = matrix;
            this.c = f;
            this.d = f2;
        }
    }

    protected float d() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.min(1.0f, 1.0f / l(this.b));
    }

    public float getMaxScale() {
        if (this.h == -1.0f) {
            this.h = c();
        }
        return this.h;
    }

    public float getMinScale() {
        if (this.i == -1.0f) {
            this.i = d();
        }
        return this.i;
    }

    public enum DisplayType {
        NONE,
        FIT_TO_SCREEN,
        FIT_IF_BIGGER;

        static {
            Covode.recordClassIndex(657860);
        }
    }

    protected float c() {
        if (getDrawable() == null) {
            return 1.0f;
        }
        return Math.max(r0.getIntrinsicWidth() / this.n, r0.getIntrinsicHeight() / this.o) * 8.0f;
    }

    public void w() {
        this.c = new Matrix();
        float i = i(this.q);
        setImageMatrix(getImageViewMatrix());
        if (i != getScale()) {
            C(i);
        }
        postInvalidate();
    }

    class b implements Runnable {
        double a = 0.0d;
        double b = 0.0d;
        final /* synthetic */ double c;
        final /* synthetic */ long d;
        final /* synthetic */ double e;
        final /* synthetic */ double f;

        @Override // java.lang.Runnable
        public void run() {
            double min = Math.min(this.c, System.currentTimeMillis() - this.d);
            double a = ImageViewTouchBase.this.a.a(min, 0.0d, this.e, this.c);
            double a2 = ImageViewTouchBase.this.a.a(min, 0.0d, this.f, this.c);
            ImageViewTouchBase.this.t(a - this.a, a2 - this.b);
            this.a = a;
            this.b = a2;
            if (min < this.c) {
                ImageViewTouchBase.this.e.post(this);
                return;
            }
            ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
            RectF h = imageViewTouchBase.h(imageViewTouchBase.c, true, true);
            float f = h.left;
            if (f != 0.0f || h.top != 0.0f) {
                ImageViewTouchBase.this.x(f, h.top);
            }
        }

        b(double d, long j, double d2, double d3) {
            this.c = d;
            this.d = j;
            this.e = d2;
            this.f = d3;
        }
    }

    class c implements Runnable {
        final /* synthetic */ float a;
        final /* synthetic */ long b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;
        final /* synthetic */ float e;
        final /* synthetic */ float f;

        @Override // java.lang.Runnable
        public void run() {
            float min = Math.min(this.a, System.currentTimeMillis() - this.b);
            ImageViewTouchBase.this.E(this.d + ((float) ImageViewTouchBase.this.a.b(min, 0.0d, this.c, this.a)), this.e, this.f);
            if (min < this.a) {
                ImageViewTouchBase.this.e.post(this);
                return;
            }
            ImageViewTouchBase imageViewTouchBase = ImageViewTouchBase.this;
            imageViewTouchBase.s(imageViewTouchBase.getScale());
            ImageViewTouchBase.this.b(true, true);
        }

        c(float f, long j, float f2, float f3, float f4, float f5) {
            this.a = f;
            this.b = j;
            this.c = f2;
            this.d = f3;
            this.e = f4;
            this.f = f5;
        }
    }

    protected void o(Drawable drawable) {
        e(drawable);
    }

    protected void setMaxScale(float f) {
        this.h = f;
    }

    protected void setMinScale(float f) {
        this.i = f;
    }

    protected float l(Matrix matrix) {
        return m(matrix, 0);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        z(bitmap, null, -1.0f, -1.0f);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        A(drawable, null, -1.0f, -1.0f);
    }

    public Matrix j(Matrix matrix) {
        this.l.set(this.b);
        this.l.postConcat(matrix);
        return this.l;
    }

    public void setDisplayType(DisplayType displayType) {
        if (displayType != this.q) {
            this.g = false;
            this.q = displayType;
            this.r = true;
            requestLayout();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w("ImageViewTouchBase", "Unsupported scaletype. Only MATRIX can be used");
        }
    }

    protected float i(DisplayType displayType) {
        if (displayType == DisplayType.FIT_TO_SCREEN) {
            return 1.0f;
        }
        if (displayType == DisplayType.FIT_IF_BIGGER) {
            return Math.min(1.0f, 1.0f / l(this.b));
        }
        return 1.0f / l(this.b);
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        boolean z;
        Matrix imageMatrix = getImageMatrix();
        if ((matrix == null && !imageMatrix.isIdentity()) || (matrix != null && !imageMatrix.equals(matrix))) {
            z = true;
        } else {
            z = false;
        }
        super.setImageMatrix(matrix);
        if (z) {
            p();
        }
    }

    protected void C(float f) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        if (f < getMinScale()) {
            f = getMinScale();
        }
        PointF center = getCenter();
        E(f, center.x, center.y);
    }

    protected RectF g(Matrix matrix) {
        if (getDrawable() == null) {
            return null;
        }
        Matrix j = j(matrix);
        this.u.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        j.mapRect(this.u);
        return this.u;
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void x(float f, float f2) {
        t(f, f2);
    }

    public void D(float f, float f2) {
        PointF center = getCenter();
        F(f, center.x, center.y, f2);
    }

    protected float m(Matrix matrix, int i) {
        matrix.getValues(this.m);
        return this.m[i];
    }

    protected void b(boolean z, boolean z2) {
        if (getDrawable() == null) {
            return;
        }
        RectF h = h(this.c, z, z2);
        float f = h.left;
        if (f != 0.0f || h.top != 0.0f) {
            v(f, h.top);
        }
    }

    protected void t(double d2, double d3) {
        RectF bitmapRect = getBitmapRect();
        this.w.set((float) d2, (float) d3, 0.0f, 0.0f);
        B(bitmapRect, this.w);
        RectF rectF = this.w;
        v(rectF.left, rectF.top);
        b(true, true);
    }

    protected void v(float f, float f2) {
        if (f != 0.0f || f2 != 0.0f) {
            this.c.postTranslate(f, f2);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected void B(RectF rectF, RectF rectF2) {
        if (rectF == null) {
            return;
        }
        if (rectF.top >= 0.0f && rectF.bottom <= this.o) {
            rectF2.top = 0.0f;
        }
        if (rectF.left >= 0.0f && rectF.right <= this.n) {
            rectF2.left = 0.0f;
        }
        if (rectF2.top + rectF.top >= 0.0f && rectF.bottom > this.o) {
            rectF2.top = (int) (0.0f - r0);
        }
        float f = rectF2.top + rectF.bottom;
        int i = this.o;
        if (f <= i + 0 && rectF.top < 0.0f) {
            rectF2.top = (int) ((i + 0) - r0);
        }
        if (rectF2.left + rectF.left >= 0.0f) {
            rectF2.left = (int) (0.0f - r0);
        }
        float f2 = rectF2.left + rectF.right;
        int i2 = this.n;
        if (f2 <= i2 + 0) {
            rectF2.left = (int) ((i2 + 0) - r6);
        }
    }

    protected void k(Drawable drawable, Matrix matrix) {
        float f = this.n;
        float f2 = this.o;
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        matrix.reset();
        if (intrinsicWidth <= f && intrinsicHeight <= f2) {
            float min = Math.min(f / intrinsicWidth, f2 / intrinsicHeight);
            matrix.postScale(min, min);
            matrix.postTranslate((f - (intrinsicWidth * min)) / 2.0f, (f2 - (intrinsicHeight * min)) / 2.0f);
        } else {
            float min2 = Math.min(f / intrinsicWidth, f2 / intrinsicHeight);
            matrix.postScale(min2, min2);
            matrix.postTranslate((f - (intrinsicWidth * min2)) / 2.0f, (f2 - (intrinsicHeight * min2)) / 2.0f);
        }
    }

    protected void n(Context context, AttributeSet attributeSet, int i) {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    protected void u(float f, float f2, float f3) {
        this.c.postScale(f, f, f2, f3);
        setImageMatrix(getImageViewMatrix());
    }

    protected void E(float f, float f2, float f3) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        u(f / getScale(), f2, f3);
        r(getScale());
        b(true, true);
    }

    protected void y(float f, float f2, double d2) {
        this.e.post(new b(d2, System.currentTimeMillis(), f, f2));
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new om6.a();
        this.b = new Matrix();
        this.c = new Matrix();
        this.e = new HandlerDelegate();
        this.f = null;
        this.g = false;
        this.h = -1.0f;
        this.i = -1.0f;
        this.l = new Matrix();
        this.m = new float[9];
        this.n = -1;
        this.o = -1;
        this.p = new PointF();
        this.q = DisplayType.NONE;
        this.t = 200;
        this.u = new RectF();
        this.v = new RectF();
        this.w = new RectF();
        n(context, attributeSet, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        if (r7 < r8) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.graphics.RectF h(android.graphics.Matrix r7, boolean r8, boolean r9) {
        /*
            r6 = this;
            android.graphics.drawable.Drawable r0 = r6.getDrawable()
            r1 = 0
            if (r0 != 0) goto Ld
            android.graphics.RectF r7 = new android.graphics.RectF
            r7.<init>(r1, r1, r1, r1)
            return r7
        Ld:
            android.graphics.RectF r0 = r6.v
            r0.set(r1, r1, r1, r1)
            android.graphics.RectF r7 = r6.g(r7)
            float r0 = r7.height()
            float r2 = r7.width()
            r3 = 1073741824(0x40000000, float:2.0)
            if (r9 == 0) goto L41
            int r9 = r6.o
            float r4 = (float) r9
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 >= 0) goto L2f
            float r4 = r4 - r0
            float r4 = r4 / r3
            float r9 = r7.top
            float r4 = r4 - r9
            goto L42
        L2f:
            float r0 = r7.top
            int r5 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r5 <= 0) goto L37
            float r4 = -r0
            goto L42
        L37:
            float r0 = r7.bottom
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 >= 0) goto L41
            float r9 = (float) r9
            float r4 = r9 - r0
            goto L42
        L41:
            r4 = 0
        L42:
            if (r8 == 0) goto L60
            int r8 = r6.n
            float r8 = (float) r8
            int r9 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r9 >= 0) goto L51
            float r8 = r8 - r2
            float r8 = r8 / r3
            float r7 = r7.left
        L4f:
            float r8 = r8 - r7
            goto L61
        L51:
            float r9 = r7.left
            int r0 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r0 <= 0) goto L59
            float r8 = -r9
            goto L61
        L59:
            float r7 = r7.right
            int r9 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r9 >= 0) goto L60
            goto L4f
        L60:
            r8 = 0
        L61:
            android.graphics.RectF r7 = r6.v
            r7.set(r8, r4, r1, r1)
            android.graphics.RectF r7 = r6.v
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.imagezoom.ImageViewTouchBase.h(android.graphics.Matrix, boolean, boolean):android.graphics.RectF");
    }

    protected void q(int i, int i2, int i3, int i4) {
        f(i, i2, i3, i4);
    }

    public void z(Bitmap bitmap, Matrix matrix, float f, float f2) {
        if (bitmap != null) {
            A(new pm6.a(bitmap), matrix, f, f2);
        } else {
            A(null, matrix, f, f2);
        }
    }

    public void A(Drawable drawable, Matrix matrix, float f, float f2) {
        if (getWidth() <= 0) {
            this.f = new a(drawable, matrix, f, f2);
        } else {
            a(drawable, matrix, f, f2);
        }
    }

    protected void F(float f, float f2, float f3, float f4) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        long currentTimeMillis = System.currentTimeMillis();
        float scale = getScale();
        Matrix matrix = new Matrix(this.c);
        matrix.postScale(f, f, f2, f3);
        RectF h = h(matrix, true, true);
        this.e.post(new c(f4, currentTimeMillis, f - scale, scale, f2 + (h.left * f), f3 + (h.top * f)));
    }

    protected void a(Drawable drawable, Matrix matrix, float f, float f2) {
        if (drawable != null) {
            super.setImageDrawable(drawable);
        } else {
            this.b.reset();
            super.setImageDrawable(null);
        }
        if (f != -1.0f && f2 != -1.0f) {
            float min = Math.min(f, f2);
            float max = Math.max(min, f2);
            this.i = min;
            this.h = max;
            this.k = true;
            this.j = true;
            DisplayType displayType = this.q;
            if (displayType == DisplayType.FIT_TO_SCREEN || displayType == DisplayType.FIT_IF_BIGGER) {
                if (min >= 1.0f) {
                    this.k = false;
                    this.i = -1.0f;
                }
                if (max <= 1.0f) {
                    this.j = true;
                    this.h = -1.0f;
                }
            }
        } else {
            this.i = -1.0f;
            this.h = -1.0f;
            this.k = false;
            this.j = false;
        }
        if (matrix != null) {
            this.d = new Matrix(matrix);
        }
        this.s = true;
        requestLayout();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        float i7;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int i8 = this.n;
            int i9 = this.o;
            int i10 = i3 - i;
            this.n = i10;
            int i11 = i4 - i2;
            this.o = i11;
            i5 = i10 - i8;
            i6 = i11 - i9;
            PointF pointF = this.p;
            pointF.x = i10 / 2.0f;
            pointF.y = i11 / 2.0f;
        } else {
            i5 = 0;
            i6 = 0;
        }
        Runnable runnable = this.f;
        if (runnable != null) {
            this.f = null;
            runnable.run();
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            if (z || this.r || this.s) {
                i(this.q);
                float l = l(this.b);
                float scale = getScale();
                float f = 1.0f;
                float min = Math.min(1.0f, 1.0f / l);
                k(drawable, this.b);
                float l2 = l(this.b);
                if (!this.s && !this.r) {
                    if (z) {
                        if (!this.k) {
                            this.i = -1.0f;
                        }
                        if (!this.j) {
                            this.h = -1.0f;
                        }
                        setImageMatrix(getImageViewMatrix());
                        v(-i5, -i6);
                        if (!this.g) {
                            f = i(this.q);
                            C(f);
                        } else {
                            if (Math.abs(scale - min) > 0.001d) {
                                f = (l / l2) * scale;
                            }
                            C(f);
                        }
                    }
                } else {
                    Matrix matrix = this.d;
                    if (matrix != null) {
                        this.c.set(matrix);
                        this.d = null;
                        i7 = getScale();
                    } else {
                        this.c.reset();
                        i7 = i(this.q);
                    }
                    f = i7;
                    setImageMatrix(getImageViewMatrix());
                    if (f != getScale()) {
                        C(f);
                    }
                }
                this.g = false;
                if (f > getMaxScale() || f < getMinScale()) {
                    C(f);
                }
                b(true, true);
                if (this.s) {
                    o(drawable);
                }
                if (z || this.s || this.r) {
                    q(i, i2, i3, i4);
                }
                if (this.r) {
                    this.r = false;
                }
                if (this.s) {
                    this.s = false;
                    return;
                }
                return;
            }
            return;
        }
        if (this.s) {
            o(drawable);
        }
        if (z || this.s || this.r) {
            q(i, i2, i3, i4);
        }
        if (this.s) {
            this.s = false;
        }
        if (this.r) {
            this.r = false;
        }
    }
}
