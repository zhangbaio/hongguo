package rn4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.core.view.ViewGroupKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.covode.number.Covode;
import com.dragon.read.util.a1;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wn4.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class l extends Dialog implements wn4.a, LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner {
    public static final int n;
    private final Activity a;
    public final un4.j b;
    public final List<bh1.a> c;
    public final Function1<bh1.a, Unit> d;
    public final int e;
    private final boolean f;
    private Function1<? super String, Unit> g;
    private String h;
    private ViewGroup i;
    private ViewGroup j;
    private LifecycleRegistry k;
    private final h2.g l;
    private final OnBackPressedDispatcher m;

    static {
        Covode.recordClassIndex(608909);
        n = 8;
    }

    public abstract ViewGroup d();

    public abstract Function2<Composer, Integer, Unit> f(un4.j jVar, boolean z);

    public abstract int g();

    public abstract ViewGroup h();

    public abstract Function2<Composer, Integer, Unit> i(List<bh1.a> list, Function1<? super bh1.a, Unit> function1, boolean z);

    public abstract void j();

    public final Activity getActivity() {
        return this.a;
    }

    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.m;
    }

    public Lifecycle getLifecycle() {
        return e();
    }

    public h2.e getSavedStateRegistry() {
        return this.l.b;
    }

    private final LifecycleRegistry e() {
        LifecycleRegistry lifecycleRegistry = this.k;
        if (lifecycleRegistry == null) {
            LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
            this.k = lifecycleRegistry2;
            return lifecycleRegistry2;
        }
        return lifecycleRegistry;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Function1<? super String, Unit> function1 = this.g;
        if (function1 != null) {
            function1.invoke(this.h);
        }
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "onSaveInstanceState(...)");
        this.l.d(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        e().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        e().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.k = null;
        super.onStop();
    }

    private final void n() {
        Window window = getWindow();
        if (window != null) {
            m(window);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
        }
    }

    @Override // wn4.a
    public un4.h x() {
        View view;
        ViewGroup viewGroup = this.j;
        if (viewGroup != null && (view = ViewGroupKt.get(viewGroup, 0)) != null) {
            return b(view);
        }
        return null;
    }

    private final void k() {
        View decorView;
        View decorView2;
        View decorView3;
        Window window = getWindow();
        if (window != null && (decorView3 = window.getDecorView()) != null) {
            ViewTreeLifecycleOwner.set(decorView3, this);
        }
        Window window2 = getWindow();
        if (window2 != null && (decorView2 = window2.getDecorView()) != null) {
            ViewTreeOnBackPressedDispatcherOwner.b(decorView2, this);
        }
        Window window3 = getWindow();
        if (window3 != null && (decorView = window3.getDecorView()) != null) {
            h2.k.b(decorView, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(l lVar) {
        super.onBackPressed();
    }

    @Override // wn4.b
    public void init(Function1<? super String, Unit> onClose) {
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.g = onClose;
    }

    @Override // wn4.b
    public void dismiss(String closeReason) {
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        this.h = closeReason;
        dismiss();
    }

    private final void m(Window window) {
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (a1.p(this.a)) {
            window.clearFlags(134217728);
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        decorView.setSystemUiVisibility(5126);
        window.addFlags(1024);
    }

    private final un4.h b(View view) {
        Object m773constructorimpl;
        Object obj = null;
        try {
            Result.Companion companion = Result.Companion;
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setColor(getContext().getResources().getColor(2131560252));
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), paint);
            view.draw(canvas);
            m773constructorimpl = Result.m773constructorimpl(new un4.h(androidx.compose.ui.graphics.j.c(createBitmap), null, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m779isFailureimpl(m773constructorimpl)) {
            obj = m773constructorimpl;
        }
        return (un4.h) obj;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g());
        n();
        j();
        ViewGroup h = h();
        this.i = h;
        if (h != null) {
            ComposeView c = c(-1, -2);
            c.setContent(i(this.c, this.d, this.f));
            h.addView(c);
        }
        ViewGroup d = d();
        this.j = d;
        if (d != null) {
            ComposeView c2 = c(-1, -2);
            c2.setContent(f(this.b, this.f));
            d.addView(c2);
        }
        this.l.c(bundle);
        e().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        k();
        eq2.b.h().f(this);
    }

    private final ComposeView c(int i, int i2) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.b);
        return composeView;
    }

    @Override // wn4.b
    public void C(String str, List<bh1.a> list, Function1<? super bh1.a, Unit> function1) {
        a.C0288a.a(this, str, list, function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Activity activity, un4.j tvUgPostShareParams, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, int i, boolean z) {
        super(activity, i);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(tvUgPostShareParams, "tvUgPostShareParams");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.a = activity;
        this.b = tvUgPostShareParams;
        this.c = shareChannelList;
        this.d = onClickListener;
        this.e = i;
        this.f = z;
        this.h = "mask_layer";
        this.l = h2.g.c.b(this);
        this.m = new OnBackPressedDispatcher(new Runnable() { // from class: rn4.k
            @Override // java.lang.Runnable
            public final void run() {
                l.l(l.this);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ l(android.app.Activity r8, un4.j r9, java.util.List r10, kotlin.jvm.functions.Function1 r11, int r12, boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 16
            if (r15 == 0) goto Lb
            r12 = 2131296872(0x7f090268, float:1.8211673E38)
            r5 = 2131296872(0x7f090268, float:1.8211673E38)
            goto Lc
        Lb:
            r5 = r12
        Lc:
            r12 = r14 & 32
            if (r12 == 0) goto L16
            fq4.a r12 = fq4.a.a
            boolean r13 = r12.a()
        L16:
            r6 = r13
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rn4.l.<init>(android.app.Activity, un4.j, java.util.List, kotlin.jvm.functions.Function1, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
