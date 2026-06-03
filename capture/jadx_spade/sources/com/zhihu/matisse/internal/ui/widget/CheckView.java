package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CheckView extends View {
    public static final a n;
    private boolean a;
    public boolean b;
    private int c;
    private boolean d;
    private Paint e;
    private Paint f;
    private Paint g;
    private Paint h;
    private TextPaint i;
    private Drawable j;
    private float k;
    private Rect l;
    private boolean m;

    static {
        Covode.recordClassIndex(656149);
        n = new a(null);
    }

    private final void b() {
        if (this.g == null) {
            Paint paint = new Paint();
            this.g = paint;
            Intrinsics.checkNotNull(paint);
            paint.setAntiAlias(true);
            Paint paint2 = this.g;
            Intrinsics.checkNotNull(paint2);
            paint2.setStyle(Paint.Style.FILL);
            int parseColor = Color.parseColor("#4D000000");
            Paint paint3 = this.g;
            Intrinsics.checkNotNull(paint3);
            paint3.setColor(parseColor);
        }
    }

    private final void c() {
        if (this.h == null) {
            Paint paint = new Paint();
            this.h = paint;
            Intrinsics.checkNotNull(paint);
            paint.setAntiAlias(true);
            Paint paint2 = this.h;
            Intrinsics.checkNotNull(paint2);
            paint2.setStyle(Paint.Style.FILL);
            int parseColor = Color.parseColor("#FA6725");
            Paint paint3 = this.h;
            Intrinsics.checkNotNull(paint3);
            paint3.setColor(parseColor);
        }
    }

    private final void e() {
        if (this.i == null) {
            TextPaint textPaint = new TextPaint();
            this.i = textPaint;
            Intrinsics.checkNotNull(textPaint);
            textPaint.setAntiAlias(true);
            TextPaint textPaint2 = this.i;
            Intrinsics.checkNotNull(textPaint2);
            textPaint2.setColor(-1);
            TextPaint textPaint3 = this.i;
            Intrinsics.checkNotNull(textPaint3);
            textPaint3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
            TextPaint textPaint4 = this.i;
            Intrinsics.checkNotNull(textPaint4);
            textPaint4.setTextSize(this.k * 12.0f);
        }
    }

    private final Rect getCheckRect() {
        if (this.l == null) {
            float f = 20;
            float f2 = this.k;
            float f3 = 2;
            int i = (int) (((f * f2) / f3) - ((15 * f2) / f3));
            float f4 = this.k;
            float f5 = i;
            this.l = new Rect(i, i, (int) ((f * f4) - f5), (int) ((f * f4) - f5));
        }
        Rect rect = this.l;
        Intrinsics.checkNotNull(rect);
        return rect;
    }

    private final void d() {
        if (this.f == null) {
            Paint paint = new Paint();
            this.f = paint;
            Intrinsics.checkNotNull(paint);
            paint.setAntiAlias(true);
            Paint paint2 = this.f;
            Intrinsics.checkNotNull(paint2);
            paint2.setStyle(Paint.Style.STROKE);
            Paint paint3 = this.f;
            Intrinsics.checkNotNull(paint3);
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            Paint paint4 = this.f;
            Intrinsics.checkNotNull(paint4);
            paint4.setStrokeWidth(this.k * 1.5f);
            int parseColor = Color.parseColor("#4D000000");
            Paint paint5 = this.f;
            Intrinsics.checkNotNull(paint5);
            paint5.setColor(parseColor);
        }
    }

    private final void f() {
        if (this.e == null) {
            Paint paint = new Paint();
            this.e = paint;
            Intrinsics.checkNotNull(paint);
            paint.setAntiAlias(true);
            Paint paint2 = this.e;
            Intrinsics.checkNotNull(paint2);
            paint2.setStyle(Paint.Style.STROKE);
            Paint paint3 = this.e;
            Intrinsics.checkNotNull(paint3);
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            Paint paint4 = this.e;
            Intrinsics.checkNotNull(paint4);
            paint4.setStrokeWidth(this.k * 1.0f);
            int parseColor = Color.parseColor("#FFFFFF");
            Paint paint5 = this.e;
            Intrinsics.checkNotNull(paint5);
            paint5.setColor(parseColor);
        }
    }

    public final void setCountable(boolean z) {
        this.a = z;
    }

    public final void setIsWhiteStroke(boolean z) {
        this.m = z;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(656150);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (this.d != z) {
            this.d = z;
            invalidate();
        }
    }

    private final void a(Context context) {
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.k = resources.getDisplayMetrics().density;
        this.j = context.getResources().getDrawable(2130842721);
    }

    public final void setChecked(boolean z) {
        if (!this.a) {
            this.b = z;
            invalidate();
            return;
        }
        throw new IllegalStateException("CheckView is countable, call setCheckedNum() instead.".toString());
    }

    public final void setCheckedNum(int i) {
        boolean z;
        if (this.a) {
            if (i != Integer.MIN_VALUE && i <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.c = i;
                invalidate();
                return;
            }
            throw new IllegalArgumentException("checked num can't be negative.".toString());
        }
        throw new IllegalStateException("CheckView is not countable, call setChecked() instead.".toString());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.a) {
            if (this.c != Integer.MIN_VALUE) {
                c();
                float f2 = 20;
                float f3 = this.k;
                float f4 = 2;
                Paint paint = this.h;
                Intrinsics.checkNotNull(paint);
                canvas.drawCircle((f2 * f3) / f4, (f2 * f3) / f4, f3 * 10.0f, paint);
                e();
                String valueOf = String.valueOf(this.c);
                float width = getWidth();
                TextPaint textPaint = this.i;
                Intrinsics.checkNotNull(textPaint);
                int measureText = ((int) (width - textPaint.measureText(valueOf))) / 2;
                float height = getHeight();
                TextPaint textPaint2 = this.i;
                Intrinsics.checkNotNull(textPaint2);
                float descent = height - textPaint2.descent();
                TextPaint textPaint3 = this.i;
                Intrinsics.checkNotNull(textPaint3);
                float ascent = ((int) (descent - textPaint3.ascent())) / 2;
                TextPaint textPaint4 = this.i;
                Intrinsics.checkNotNull(textPaint4);
                canvas.drawText(valueOf, measureText, ascent, textPaint4);
            } else {
                b();
                float f5 = 20;
                float f6 = this.k;
                float f7 = 2;
                Paint paint2 = this.g;
                Intrinsics.checkNotNull(paint2);
                canvas.drawCircle((f5 * f6) / f7, (f5 * f6) / f7, f6 * 10.0f, paint2);
                f();
                float f8 = this.k;
                Paint paint3 = this.e;
                Intrinsics.checkNotNull(paint3);
                canvas.drawCircle((f5 * f8) / f7, (f5 * f8) / f7, f8 * 9.5f, paint3);
            }
        } else if (this.b) {
            c();
            float f9 = 20;
            float f10 = this.k;
            float f11 = 2;
            Paint paint4 = this.h;
            Intrinsics.checkNotNull(paint4);
            canvas.drawCircle((f9 * f10) / f11, (f9 * f10) / f11, f10 * 10.0f, paint4);
            Drawable drawable = this.j;
            Intrinsics.checkNotNull(drawable);
            drawable.setBounds(getCheckRect());
            Drawable drawable2 = this.j;
            Intrinsics.checkNotNull(drawable2);
            drawable2.draw(canvas);
        } else if (this.m) {
            b();
            float f12 = 20;
            float f13 = this.k;
            float f14 = 2;
            Paint paint5 = this.g;
            Intrinsics.checkNotNull(paint5);
            canvas.drawCircle((f12 * f13) / f14, (f12 * f13) / f14, f13 * 10.0f, paint5);
            f();
            float f15 = this.k;
            Paint paint6 = this.e;
            Intrinsics.checkNotNull(paint6);
            canvas.drawCircle((f12 * f15) / f14, (f12 * f15) / f14, f15 * 9.5f, paint6);
        } else {
            d();
            float f16 = 20;
            float f17 = this.k;
            float f18 = 2;
            Paint paint7 = this.f;
            Intrinsics.checkNotNull(paint7);
            canvas.drawCircle((f16 * f17) / f18, (f16 * f17) / f18, f17 * 9.25f, paint7);
        }
        if (this.d) {
            f = 1.0f;
        } else {
            f = 0.5f;
        }
        setAlpha(f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = true;
        this.c = Integer.MIN_VALUE;
        this.d = true;
        a(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (20 * this.k), 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
