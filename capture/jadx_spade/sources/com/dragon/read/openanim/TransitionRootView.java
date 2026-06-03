package com.dragon.read.openanim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.ActivityRecordHelper;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.openanim.BookOpenAnimTask;
import com.dragon.read.widget.ActiveFrameLayout;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TransitionRootView extends ActiveFrameLayout {
    public static final a g;
    public static final int h;
    private g e;
    private final Lazy f;

    public static final class a {
        static {
            Covode.recordClassIndex(612659);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(612658);
        g = new a(null);
        h = 8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransitionRootView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransitionRootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final g getBookOpenAnimExecutor() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path i() {
        return new Path();
    }

    public void n() {
        g gVar = this.e;
        if (gVar != null) {
            gVar.e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        invalidate();
        getRootView().setBackground(null);
    }

    protected final Path getClipPath() {
        return (Path) this.f.getValue();
    }

    public boolean m() {
        g gVar = this.e;
        if (gVar == null || !gVar.h) {
            return false;
        }
        return true;
    }

    public void o() {
        u();
        g gVar = this.e;
        if (gVar != null) {
            gVar.i();
        }
    }

    public void w() {
        this.e = m.a.e();
    }

    public final Activity getFromActivity() {
        String str;
        BookOpenAnimTask bookOpenAnimTask;
        g gVar = this.e;
        if (gVar != null && (bookOpenAnimTask = gVar.a) != null) {
            str = bookOpenAnimTask.j;
        } else {
            str = null;
        }
        return ActivityRecordHelper.findActivity(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean x() {
        Activity activity;
        Intent intent;
        Context context = getContext();
        String str = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("ignore_book_exit_anim");
        }
        return Intrinsics.areEqual(str, "1");
    }

    public final void setBookOpenAnimExecutor(g gVar) {
        this.e = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(n nVar) {
        nVar.a(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void y(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super/*android.widget.FrameLayout*/.draw(canvas);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        g gVar = this.e;
        boolean z = false;
        if (gVar != null && gVar.h) {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private final void v(Runnable runnable) {
        g gVar = this.e;
        if (gVar != null) {
            if (!(!gVar.i)) {
                gVar = null;
            }
            if (gVar != null) {
                BookOpenAnimTask bookOpenAnimTask = gVar.a;
                BookOpenAnimTask.State f = gVar.f();
                if (f == BookOpenAnimTask.State.STATE_ENTERED) {
                    bookOpenAnimTask.i();
                    bookOpenAnimTask.h();
                } else if (f == BookOpenAnimTask.State.STATE_EXISTING) {
                    bookOpenAnimTask.h();
                }
                gVar.e();
            }
        }
        runnable.run();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        g gVar = this.e;
        if (gVar != null) {
            if (gVar.f() == BookOpenAnimTask.State.STATE_ENTERED) {
                super/*android.widget.FrameLayout*/.draw(canvas);
                return;
            }
            if (!k(canvas, gVar.a)) {
                super/*android.widget.FrameLayout*/.draw(canvas);
                return;
            }
            c cVar = gVar.g;
            if (cVar != null) {
                l(canvas, cVar);
                j(canvas, cVar);
                return;
            } else {
                super/*android.widget.FrameLayout*/.draw(canvas);
                return;
            }
        }
        super/*android.widget.FrameLayout*/.draw(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q(final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        u();
        if (x()) {
            v(runnable);
            return;
        }
        g gVar = this.e;
        if (gVar != null) {
            if (!(!gVar.i)) {
                gVar = null;
            }
            if (gVar != null) {
                View findViewById = findViewById(2131830803);
                if (findViewById != null) {
                    findViewById.setBackgroundColor(16777216);
                }
                gVar.k(new Function0() { // from class: com.dragon.read.openanim.k0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit s;
                        s = TransitionRootView.s(runnable, this);
                        return s;
                    }
                });
                return;
            }
        }
        runnable.run();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(final n callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        u();
        if (x()) {
            v(new Runnable() { // from class: com.dragon.read.openanim.i0
                @Override // java.lang.Runnable
                public final void run() {
                    TransitionRootView.t(n.this);
                }
            });
            return;
        }
        g gVar = this.e;
        if (gVar != null) {
            if (!(!gVar.i)) {
                gVar = null;
            }
            if (gVar != null) {
                View findViewById = findViewById(2131830803);
                if (findViewById != null) {
                    findViewById.setBackgroundColor(16777216);
                }
                gVar.k(new Function0() { // from class: com.dragon.read.openanim.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit r;
                        r = TransitionRootView.r(n.this, this);
                        return r;
                    }
                });
                return;
            }
        }
        callBack.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit r(n nVar, TransitionRootView transitionRootView) {
        Activity activity;
        nVar.a(true);
        Context context = transitionRootView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit s(Runnable runnable, TransitionRootView transitionRootView) {
        Activity activity;
        runnable.run();
        Context context = transitionRootView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void j(Canvas canvas, c cVar) {
        g gVar = this.e;
        boolean z = false;
        if (gVar != null && gVar.o()) {
            z = true;
        }
        if (z) {
            canvas.save();
            canvas.setMatrix(cVar.c);
            super/*android.widget.FrameLayout*/.draw(canvas);
            Matrix matrix = cVar.d;
            if (matrix != null) {
                canvas.setMatrix(matrix);
                Drawable drawable = cVar.b;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
            }
            canvas.restore();
            invalidate();
        }
    }

    private final boolean k(Canvas canvas, BookOpenAnimTask bookOpenAnimTask) {
        Window window;
        View decorView;
        try {
            Activity fromActivity = getFromActivity();
            if (fromActivity != null && (window = fromActivity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
                decorView.draw(canvas);
                return true;
            }
        } catch (Exception e) {
            LogWrapper.error("BookOpenRootView", e.toString(), new Object[0]);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void l(Canvas canvas, c animValue) {
        int width;
        Integer num;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(animValue, "animValue");
        g gVar = this.e;
        boolean z = false;
        if (gVar != null && gVar.g()) {
            z = true;
        }
        if (z) {
            float width2 = getWidth();
            Drawable drawable = animValue.b;
            if (drawable != null) {
                width = drawable.getIntrinsicWidth();
            } else {
                width = getWidth();
            }
            float f = width2 / width;
            canvas.save();
            Matrix matrix = animValue.d;
            if (matrix != null) {
                canvas.setMatrix(matrix);
            }
            Drawable drawable2 = animValue.b;
            if (drawable2 != null) {
                drawable2.setAlpha((int) (255 * (1.0f - animValue.a)));
            }
            Drawable drawable3 = animValue.b;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
            canvas.restore();
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (255 * animValue.a));
            canvas.setMatrix(animValue.c);
            g gVar2 = this.e;
            if (gVar2 != null) {
                num = Integer.valueOf(gVar2.d());
            } else {
                num = null;
            }
            if (num != null && num.intValue() > 0) {
                getClipPath().reset();
                float f2 = f - 1.0f;
                getClipPath().addRoundRect(0.0f, 0.0f, getWidth(), getHeight(), (num.intValue() * f2 * animValue.a) + num.intValue(), (num.intValue() * f2 * animValue.a) + num.intValue(), Path.Direction.CW);
                canvas.clipPath(getClipPath());
            }
            super/*android.widget.FrameLayout*/.draw(canvas);
            canvas.restore();
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransitionRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.openanim.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Path i2;
                i2 = TransitionRootView.i();
                return i2;
            }
        });
        this.f = lazy;
        setWillNotDraw(false);
    }

    public /* synthetic */ TransitionRootView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
