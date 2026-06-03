package com.dragon.read.nps.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.skin.SkinManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FiveStarScoreView extends ConstraintLayout {
    public static final int m;
    private a g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private final ImageView[] l;

    public interface a {
        void onChanged(int i);
    }

    static {
        Covode.recordClassIndex(612565);
        m = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(View view) {
    }

    public final void V1() {
        S1();
    }

    public final a getChangedListener() {
        return this.g;
    }

    public final ImageView[] getStars() {
        return this.l;
    }

    public final void c2() {
        e2(this.h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W1() {
        Y1();
        invalidate();
        requestLayout();
        this.h = 0;
    }

    private final void Y1() {
        for (int i = 0; i < 5; i++) {
            if (SkinManager.isNightMode()) {
                ImageView imageView = this.l[i];
                Intrinsics.checkNotNull(imageView);
                imageView.setImageResource(2130848994);
            } else {
                ImageView imageView2 = this.l[i];
                Intrinsics.checkNotNull(imageView2);
                imageView2.setImageResource(2130848993);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void S1() {
        this.l[0] = findViewById(2131832713);
        this.l[1] = findViewById(2131832714);
        this.l[2] = findViewById(2131832715);
        this.l[3] = findViewById(2131832716);
        this.l[4] = findViewById(2131832717);
        setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FiveStarScoreView.T1(view);
            }
        });
    }

    public final void setChangedListener(a aVar) {
        this.g = aVar;
    }

    public final void setStarSelectUIChange(boolean z) {
        this.k = z;
    }

    public final void setTouchEnable(boolean z) {
        this.j = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e2(int i) {
        Y1();
        setStars(i);
        invalidate();
        requestLayout();
        this.h = i;
    }

    private final void setStars(int i) {
        if (!this.k) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (SkinManager.isNightMode()) {
                ImageView imageView = this.l[i2];
                Intrinsics.checkNotNull(imageView);
                imageView.setImageResource(2130848995);
            } else {
                ImageView imageView2 = this.l[i2];
                Intrinsics.checkNotNull(imageView2);
                imageView2.setImageResource(2130848996);
            }
        }
    }

    private final void f2(MotionEvent motionEvent) {
        ImageView imageView = this.l[0];
        Intrinsics.checkNotNull(imageView);
        imageView.getLocationInWindow(new int[2]);
        ImageView imageView2 = this.l[1];
        Intrinsics.checkNotNull(imageView2);
        imageView2.getLocationInWindow(new int[2]);
        ImageView imageView3 = this.l[2];
        Intrinsics.checkNotNull(imageView3);
        imageView3.getLocationInWindow(new int[2]);
        ImageView imageView4 = this.l[3];
        Intrinsics.checkNotNull(imageView4);
        imageView4.getLocationInWindow(new int[2]);
        ImageView imageView5 = this.l[4];
        Intrinsics.checkNotNull(imageView5);
        imageView5.getLocationInWindow(new int[2]);
        if (motionEvent.getRawX() >= r5[0]) {
            e2(5);
            return;
        }
        if (motionEvent.getRawX() > r4[0]) {
            e2(4);
            return;
        }
        if (motionEvent.getRawX() > r3[0]) {
            e2(3);
        } else if (motionEvent.getRawX() > r2[0]) {
            e2(2);
        } else {
            e2(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (!this.j) {
            return super/*android.view.ViewGroup*/.dispatchTouchEvent(motionEvent);
        }
        boolean z3 = true;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f2(motionEvent);
            this.i = true;
        } else {
            if (this.i) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    getHitRect(new Rect());
                    if (motionEvent.getX() > 0.0f && motionEvent.getX() <= r0.right - r0.left && motionEvent.getY() > -100.0f && motionEvent.getY() <= (r0.bottom - r0.top) + 100) {
                        f2(motionEvent);
                    } else {
                        this.i = false;
                        a aVar = this.g;
                        if (aVar != null) {
                            aVar.onChanged(this.h);
                        }
                    }
                }
            }
            if (this.i) {
                if (motionEvent == null || motionEvent.getAction() != 1) {
                    z3 = false;
                }
                if (z3) {
                    f2(motionEvent);
                    a aVar2 = this.g;
                    if (aVar2 != null) {
                        aVar2.onChanged(this.h);
                    }
                    this.i = false;
                }
            }
        }
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FiveStarScoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.j = true;
        this.k = true;
        this.l = new ImageView[5];
        ViewGroup.inflate(context, 2131038494, this);
        V1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a2(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        Object obj;
        getLayoutParams().height = i2;
        getLayoutParams().width = i;
        int i3 = (i - (i2 * 5)) / 4;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView imageView = this.l[i4];
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (imageView != null) {
                layoutParams = imageView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.width = i2;
            }
            if (layoutParams != null) {
                layoutParams.height = i2;
            }
            ImageView imageView2 = this.l[i4];
            if (imageView2 != null) {
                imageView2.setLayoutParams(layoutParams);
            }
            if (i4 != 0) {
                ImageView imageView3 = this.l[i4];
                if (imageView3 != null) {
                    obj = imageView3.getLayoutParams();
                } else {
                    obj = null;
                }
                if (obj instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) obj;
                }
                if (marginLayoutParams != null) {
                    marginLayoutParams.leftMargin = i3;
                }
            }
        }
        invalidate();
        requestLayout();
    }
}
