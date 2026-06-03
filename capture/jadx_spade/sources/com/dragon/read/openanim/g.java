package com.dragon.read.openanim;

import android.animation.TypeEvaluator;
import android.app.Activity;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.depend.NsBaseUtilsDependImpl;
import com.dragon.read.base.util.ActivityRecordHelper;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.openanim.BookOpenAnimTask;
import com.dragon.read.openanim.g;
import com.dragon.read.openanim.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g {
    public static final a j;
    public static final int k;
    public final BookOpenAnimTask a;
    public final Function0<Unit> b;
    public final Camera c;
    public final Matrix d;
    public final Matrix e;
    public v f;
    public com.dragon.read.openanim.c g;
    public boolean h;
    public boolean i;

    public static final class a {
        static {
            Covode.recordClassIndex(612626);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(612625);
        j = new a(null);
        k = 8;
    }

    public final BookOpenAnimTask.State f() {
        return this.a.k;
    }

    public final int d() {
        f0 f0Var;
        com.dragon.read.openanim.b bVar = this.a.a;
        if (bVar instanceof f0) {
            f0Var = (f0) bVar;
        } else {
            f0Var = null;
        }
        if (f0Var != null) {
            return f0Var.k;
        }
        return 0;
    }

    public final void e() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.a.c();
        this.a.a.a();
        this.b.invoke();
    }

    public final boolean g() {
        f0 f0Var;
        com.dragon.read.openanim.b bVar = this.a.a;
        o oVar = null;
        if (bVar instanceof f0) {
            f0Var = (f0) bVar;
        } else {
            f0Var = null;
        }
        if (f0Var != null) {
            oVar = f0Var.i;
        }
        if (oVar != null && f0Var.j != null) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        f0 f0Var;
        boolean z;
        com.dragon.read.openanim.b bVar = this.a.a;
        if (bVar instanceof e0) {
            return true;
        }
        if (bVar instanceof f0) {
            f0Var = (f0) bVar;
        } else {
            f0Var = null;
        }
        if (f0Var != null && f0Var.l) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public final void i() {
        BookOpenAnimTask bookOpenAnimTask = this.a;
        if (bookOpenAnimTask.k != BookOpenAnimTask.State.STATE_INIT) {
            return;
        }
        bookOpenAnimTask.g();
        Drawable e = this.a.a.e();
        if (!this.a.b.isEmpty() && e != null) {
            BookOpenAnimTask bookOpenAnimTask2 = this.a;
            m(false, e, bookOpenAnimTask2.b, bookOpenAnimTask2.d, bookOpenAnimTask2.e, bookOpenAnimTask2.g, bookOpenAnimTask2.i, new Function0() { // from class: com.dragon.read.openanim.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit j2;
                    j2 = g.j(g.this);
                    return j2;
                }
            });
        } else {
            this.a.f();
        }
    }

    private final boolean h() {
        View view;
        View view2;
        Integer num;
        Integer num2;
        Integer num3;
        Window window;
        Window window2;
        Activity findActivity = ActivityRecordHelper.findActivity(this.a.j);
        Integer num4 = null;
        if (findActivity != null && (window2 = findActivity.getWindow()) != null) {
            view = window2.getDecorView();
        } else {
            view = null;
        }
        Activity currentActivity = ActivityRecordHelper.getCurrentActivity();
        if (currentActivity != null && (window = currentActivity.getWindow()) != null) {
            view2 = window.getDecorView();
        } else {
            view2 = null;
        }
        if (view != null) {
            num = Integer.valueOf(view.getWidth());
        } else {
            num = null;
        }
        if (view2 != null) {
            num2 = Integer.valueOf(view2.getWidth());
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            if (view != null) {
                num3 = Integer.valueOf(view.getHeight());
            } else {
                num3 = null;
            }
            if (view2 != null) {
                num4 = Integer.valueOf(view2.getHeight());
            }
            if (Intrinsics.areEqual(num3, num4)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(g gVar) {
        gVar.a.f();
        return Unit.INSTANCE;
    }

    public static final class b implements v.a {
        final /* synthetic */ Function0<Unit> b;

        @Override // com.dragon.read.openanim.v.a
        public /* synthetic */ void b(v vVar) {
            u.a(this, vVar);
        }

        @Override // com.dragon.read.openanim.v.a
        public void a(v animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            final g gVar = g.this;
            final Function0<Unit> function0 = this.b;
            ThreadUtils.postInForeground(new Runnable() { // from class: com.dragon.read.openanim.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.d(g.this, function0);
                }
            });
        }

        b(Function0<Unit> function0) {
            this.b = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(g gVar, Function0 function0) {
            gVar.h = false;
            function0.invoke();
        }
    }

    public static final class c implements TypeEvaluator<com.dragon.read.openanim.c> {
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;
        final /* synthetic */ float e;
        final /* synthetic */ float f;
        final /* synthetic */ float g;
        final /* synthetic */ float h;
        final /* synthetic */ float i;
        final /* synthetic */ float j;
        final /* synthetic */ g k;
        final /* synthetic */ Matrix l;
        final /* synthetic */ Drawable m;

        private final Matrix b(float f) {
            this.k.c.save();
            this.k.d.reset();
            this.k.c.setLocation(0.0f, 0.0f, 30.0f);
            this.k.c.rotateY(f);
            g gVar = this.k;
            gVar.c.getMatrix(gVar.d);
            this.k.c.restore();
            return this.k.d;
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.dragon.read.openanim.c evaluate(float f, com.dragon.read.openanim.c cVar, com.dragon.read.openanim.c cVar2) {
            Matrix matrix;
            float f2;
            float f3 = this.a;
            float f4 = ((this.b - f3) * f) + f3;
            float f5 = this.c;
            float f6 = ((this.d - f5) * f) + f5;
            float f7 = f4 / f3;
            float f8 = f6 / f5;
            float f9 = this.e * f7;
            float f10 = this.f * f8;
            float f11 = f7 * this.g;
            float f12 = f8 * this.h;
            float f13 = 1 - f;
            float f14 = this.i * f13;
            float f15 = this.j * f13;
            if (this.k.o()) {
                matrix = b(90.0f * f);
                float f16 = this.c;
                matrix.preScale(f11, f12);
                matrix.preTranslate(0.0f, (-f16) / 2.0f);
                matrix.postTranslate(0.0f, f6 / 2.0f);
                matrix.postTranslate(f14, f15);
            } else if (this.k.g()) {
                float f17 = this.a;
                float f18 = this.c;
                if (f17 > f18) {
                    float f19 = (this.d - (f18 * f11)) / 2;
                    float f20 = this.j;
                    f2 = f20 + ((f19 - f20) * f);
                } else {
                    f2 = f15;
                }
                if (f17 > f18) {
                    f12 = f11;
                }
                matrix = this.k.d;
                matrix.reset();
                matrix.preScale(f11, f12);
                matrix.postTranslate(f14, f2);
            } else {
                matrix = null;
            }
            Matrix matrix2 = this.k.e;
            matrix2.reset();
            matrix2.postScale(f9, f10);
            matrix2.postTranslate(f14, f15);
            Matrix matrix3 = this.l;
            if (matrix3 != null && matrix != null) {
                matrix.preConcat(matrix3);
            }
            return new com.dragon.read.openanim.c(f, this.m, matrix2, matrix);
        }

        c(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, g gVar, Matrix matrix, Drawable drawable) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            this.g = f7;
            this.h = f8;
            this.i = f9;
            this.j = f10;
            this.k = gVar;
            this.l = matrix;
            this.m = drawable;
        }
    }

    public final void k(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        BookOpenAnimTask bookOpenAnimTask = this.a;
        if (bookOpenAnimTask.k != BookOpenAnimTask.State.STATE_ENTERED) {
            return;
        }
        bookOpenAnimTask.i();
        Function0<Unit> function0 = new Function0() { // from class: com.dragon.read.openanim.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit l;
                l = g.l(g.this, block);
                return l;
            }
        };
        Drawable f = this.a.a.f();
        if (!this.a.c.isEmpty() && f != null && Intrinsics.areEqual(String.valueOf(ActivityRecordHelper.getPreviousActivity()), this.a.j) && NsBaseUtilsDependImpl.INSTANCE.getAnimOptimize().a() && !h()) {
            BookOpenAnimTask bookOpenAnimTask2 = this.a;
            m(true, f, bookOpenAnimTask2.c, bookOpenAnimTask2.d, bookOpenAnimTask2.f, bookOpenAnimTask2.h, bookOpenAnimTask2.i, function0);
        } else {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(g gVar, Function0 function0) {
        gVar.a.h();
        function0.invoke();
        gVar.e();
        return Unit.INSTANCE;
    }

    public g(BookOpenAnimTask bookOpenAnimTask, Function0<Unit> onDestroyAction) {
        Intrinsics.checkNotNullParameter(bookOpenAnimTask, "bookOpenAnimTask");
        Intrinsics.checkNotNullParameter(onDestroyAction, "onDestroyAction");
        this.a = bookOpenAnimTask;
        this.b = onDestroyAction;
        this.c = new Camera();
        this.d = new Matrix();
        this.e = new Matrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(g gVar, c cVar, v vVar, v vVar2) {
        gVar.g = cVar.evaluate(vVar.c(), null, null);
    }

    protected v m(boolean z, Drawable drawable, Rect bookCoverRect, Rect bookContentRect, Matrix matrix, Matrix matrix2, Rect rect, Function0<Unit> endAction) {
        float f;
        Intrinsics.checkNotNullParameter(bookCoverRect, "bookCoverRect");
        Intrinsics.checkNotNullParameter(bookContentRect, "bookContentRect");
        Intrinsics.checkNotNullParameter(endAction, "endAction");
        float width = bookCoverRect.width();
        float height = bookCoverRect.height();
        float width2 = bookContentRect.width();
        float height2 = bookContentRect.height();
        final c cVar = new c(width, width2, height, height2, width / width2, height / height2, width / width, height / height, bookCoverRect.left, bookCoverRect.top, this, matrix, drawable);
        this.h = true;
        final v vVar = new v();
        this.f = vVar;
        if (z) {
            vVar.m(this.a.a.c);
            vVar.i = this.a.a.e;
        } else {
            vVar.m(this.a.a.b);
            vVar.i = this.a.a.d;
        }
        vVar.a(new b(endAction));
        if (z) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        this.g = cVar.evaluate(f, null, null);
        vVar.b(new v.b() { // from class: com.dragon.read.openanim.f
            @Override // com.dragon.read.openanim.v.b
            public final void a(v vVar2) {
                g.n(g.this, cVar, vVar, vVar2);
            }
        });
        vVar.p(z);
        LogWrapper.info("BookOpenAnimExecutor", "start, reverse: " + z, new Object[0]);
        return vVar;
    }
}
