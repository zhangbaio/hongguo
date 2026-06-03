package rn4;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ui.util.CubicBezierInterpolator;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.widget.dialog.AdaptedToDialogInfo;
import com.dragon.read.widget.dialog.AnimationBottomDialog;
import com.dragon.read.widget.swipeback.SwipeBackLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class j extends com.dragon.read.widget.dialog.h implements wn4.b, LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner {
    public static final int s;
    public final List<bh1.a> d;
    public final Function1<bh1.a, Unit> e;
    private final boolean f;
    private Function1<? super String, Unit> g;
    private String h;
    private FrameLayout i;
    private final Lazy j;
    public View k;
    private boolean l;
    private float m;
    private boolean n;
    private LifecycleRegistry o;
    private final h2.g p;
    private final OnBackPressedDispatcher q;
    private final Lazy r;

    static {
        Covode.recordClassIndex(608908);
        s = 8;
    }

    public abstract FrameLayout D0(View view);

    public abstract View I0(Context context, ViewGroup viewGroup);

    public abstract Function2<Composer, Integer, Unit> J0(List<bh1.a> list, Function1<? super bh1.a, Unit> function1, boolean z);

    public abstract void K0();

    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.q;
    }

    public Lifecycle getLifecycle() {
        return E0();
    }

    public h2.e getSavedStateRegistry() {
        return this.p.b;
    }

    private final int C0() {
        return ((Number) this.j.getValue()).intValue();
    }

    private final LifecycleRegistry E0() {
        LifecycleRegistry lifecycleRegistry = this.o;
        if (lifecycleRegistry == null) {
            LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
            this.o = lifecycleRegistry2;
            return lifecycleRegistry2;
        }
        return lifecycleRegistry;
    }

    public final int H0() {
        return ((Number) this.r.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super/*android.app.Dialog*/.onSaveInstanceState();
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "onSaveInstanceState(...)");
        this.p.d(onSaveInstanceState);
        return onSaveInstanceState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStart() {
        super/*android.app.Dialog*/.onStart();
        E0().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        E0().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.o = null;
        super/*android.app.Dialog*/.onStop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setLayoutParams() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 8388613;
        attributes.width = -1;
        attributes.height = -1;
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
        window.clearFlags(2);
    }

    public void dismiss() {
        if (!this.l) {
            w0();
        }
        Function1<? super String, Unit> function1 = this.g;
        if (function1 != null) {
            function1.invoke(this.h);
        }
    }

    @Override // wn4.b
    public void show() {
        this.m = 0.0f;
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.show();
        final View view = this.k;
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: rn4.c
            @Override // java.lang.Runnable
            public final void run() {
                j.P0(view, this);
            }
        });
    }

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            j.this.enableNotifyHeightChange(new AdaptedToDialogInfo(j.this.getSwipeBackLayout().getHeight(), (AdaptedToDialogInfo.DialogType) null, 2, (DefaultConstructorMarker) null));
            j.this.getSwipeBackLayout().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L0() {
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

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        composeView.setLayoutParams(layoutParams);
        FrameLayout frameLayout = this.i;
        if (frameLayout != null) {
            frameLayout.addView(composeView);
        }
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.b);
        composeView.setContent(J0(this.d, this.e, this.f));
        getSwipeBackLayout().setIsEnableSwipeLeftPullDown(true);
        getSwipeBackLayout().getViewTreeObserver().addOnGlobalLayoutListener(new a());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.0f);
            window.clearFlags(2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w0() {
        final int i;
        this.l = true;
        View view = this.k;
        if (view == null) {
            return;
        }
        final AdaptedToDialogInfo.DialogType dialogType = AdaptedToDialogInfo.DialogType.SHARE_PANEL;
        Activity activity = ContextUtils.getActivity(getContext());
        if (activity != null) {
            i = activity.hashCode();
        } else {
            i = 0;
        }
        view.animate().cancel();
        final ValueAnimator ofFloat = ValueAnimator.ofFloat(this.m, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new CubicBezierInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: rn4.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                j.x0(i, valueAnimator);
            }
        });
        view.animate().translationX(H0()).alpha(0.0f).setDuration(200L).setInterpolator(new CubicBezierInterpolator(0.42f, 0.0f, 0.58f, 1.0f)).withStartAction(new Runnable() { // from class: rn4.e
            @Override // java.lang.Runnable
            public final void run() {
                j.y0(j.this, ofFloat);
            }
        }).withEndAction(new Runnable() { // from class: rn4.f
            @Override // java.lang.Runnable
            public final void run() {
                j.B0(j.this, i, dialogType);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void N0(j jVar) {
        super/*android.app.Dialog*/.onBackPressed();
    }

    @Override // wn4.b
    public void init(Function1<? super String, Unit> onClose) {
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.g = onClose;
    }

    public void onShowPercent(float f) {
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.onShowPercent(f);
        ignoreHeightChange(false);
    }

    @Override // wn4.b
    public void dismiss(String closeReason) {
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        this.h = closeReason;
        dismiss();
    }

    public static final class b implements Animation.AnimationListener {
        final /* synthetic */ Function2<Composer, Integer, Unit> b;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            FrameLayout frameLayout = j.this.i;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            j.this.v0(this.b);
        }

        b(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.b = function2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final int u0(j jVar) {
        Activity activity = ContextUtils.getActivity(jVar.getContext());
        if (activity != null) {
            return activity.hashCode();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final int M0(j jVar) {
        Object systemService = jVar.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        return (int) (r0.widthPixels * 0.42f);
    }

    public final void O0(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f));
        animationSet.setDuration(200L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new b(content));
        View view = this.k;
        if (view != null) {
            view.startAnimation(animationSet);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p.c(bundle);
        E0().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        L0();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View I0 = I0(context, c0());
        this.k = I0;
        if (I0 != null) {
            this.i = D0(I0);
        }
        c0().getLayoutParams().width = H0();
        c0().requestLayout();
        eq2.b.h().f(this);
        setLayoutParams();
        initView();
        K0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v0(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        animationSet.addAnimation(new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f));
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(200L);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        composeView.setLayoutParams(layoutParams);
        composeView.setContent(content);
        FrameLayout frameLayout = this.i;
        if (frameLayout != null) {
            frameLayout.addView(composeView);
        }
        View view = this.k;
        if (view != null) {
            view.startAnimation(animationSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(j jVar, ValueAnimator valueAnimator) {
        if (!jVar.n) {
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(int i, ValueAnimator va) {
        Intrinsics.checkNotNullParameter(va, "va");
        Object animatedValue = va.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        com.dragon.read.widget.dialog.d.a.k(1.0f - ((Float) animatedValue).floatValue(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(View view, j jVar) {
        view.setTranslationX(jVar.H0());
        view.setAlpha(0.0f);
        view.animate().translationX(0.0f).alpha(1.0f).setDuration(200L).setInterpolator(new CubicBezierInterpolator(0.42f, 0.0f, 0.58f, 1.0f)).start();
        com.dragon.read.widget.dialog.d.n(com.dragon.read.widget.dialog.d.a, AdaptedToDialogInfo.DialogType.SHARE_PANEL, false, 0, 6, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(j jVar, int i, AdaptedToDialogInfo.DialogType dialogType) {
        if (!jVar.n) {
            com.dragon.read.widget.dialog.d dVar = com.dragon.read.widget.dialog.d.a;
            dVar.k(0.0f, i);
            dVar.g(dialogType, i);
        }
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.dismiss();
        jVar.l = false;
    }

    protected void onDragPositionChange(SwipeBackLayout swipeBackLayout, View view, float f) {
        this.m = f;
        if (((AnimationBottomDialog) this).enableNotifyHeightChange) {
            com.dragon.read.widget.dialog.d.a.k(1.0f - f, C0());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Activity activity, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, boolean z) {
        super(activity);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.d = shareChannelList;
        this.e = onClickListener;
        this.f = z;
        this.h = "mask_layer";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: rn4.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int u0;
                u0 = j.u0(j.this);
                return Integer.valueOf(u0);
            }
        });
        this.j = lazy;
        this.p = h2.g.c.b(this);
        this.q = new OnBackPressedDispatcher(new Runnable() { // from class: rn4.h
            @Override // java.lang.Runnable
            public final void run() {
                j.N0(j.this);
            }
        });
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: rn4.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int M0;
                M0 = j.M0(j.this);
                return Integer.valueOf(M0);
            }
        });
        this.r = lazy2;
    }
}
