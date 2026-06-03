package rn4;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
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
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.widget.dialog.AdaptedToDialogInfo;
import com.dragon.read.widget.dialog.AnimationBottomDialog;
import com.dragon.read.widget.dialog.AnimationSwipeBottomDialog;
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
public abstract class o extends AnimationSwipeBottomDialog implements wn4.b, LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner {
    public static final int n;
    public final List<bh1.a> a;
    public final Function1<bh1.a, Unit> b;
    public final boolean c;
    private String d;
    private Function1<? super String, Unit> e;
    private View f;
    private ViewGroup g;
    private final Lazy h;
    public final int i;
    public final int j;
    private LifecycleRegistry k;
    private final h2.g l;
    private final OnBackPressedDispatcher m;

    static {
        Covode.recordClassIndex(608910);
        n = 8;
    }

    public abstract ViewGroup k0(View view);

    public abstract View m0(Context context, ViewGroup viewGroup);

    public abstract Function2<Composer, Integer, Unit> n0(List<bh1.a> list, Function1<? super bh1.a, Unit> function1, boolean z);

    protected void o0() {
    }

    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.m;
    }

    public Lifecycle getLifecycle() {
        return l0();
    }

    public h2.e getSavedStateRegistry() {
        return this.l.b;
    }

    protected void onDismissBySwipe() {
        ignoreHeightChange(true);
    }

    private final int i0() {
        return ((Number) this.h.getValue()).intValue();
    }

    private final LifecycleRegistry l0() {
        LifecycleRegistry lifecycleRegistry = this.k;
        if (lifecycleRegistry == null) {
            LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
            this.k = lifecycleRegistry2;
            return lifecycleRegistry2;
        }
        return lifecycleRegistry;
    }

    public void dismiss() {
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.dismiss();
        Function1<? super String, Unit> function1 = this.e;
        if (function1 != null) {
            function1.invoke(this.d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super/*android.app.Dialog*/.onSaveInstanceState();
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "onSaveInstanceState(...)");
        this.l.d(onSaveInstanceState);
        return onSaveInstanceState;
    }

    protected void onStart() {
        super.onStart();
        l0().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        l0().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.k = null;
        super/*android.app.Dialog*/.onStop();
    }

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            o.this.enableNotifyHeightChange(new AdaptedToDialogInfo(o.this.getSwipeBackLayout().getHeight(), (AdaptedToDialogInfo.DialogType) null, 2, (DefaultConstructorMarker) null));
            o.this.getSwipeBackLayout().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q0() {
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
    private final void setLayoutParams() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            if (window.getAttributes().gravity == 80) {
                window.setWindowAnimations(2131297282);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void initDialog() {
        UIKt.updateMargin$default(getSwipeBackLayout(), (Integer) null, Integer.valueOf(getContext().getResources().getDimensionPixelSize(2131493486)), (Integer) null, (Integer) null, 13, (Object) null);
        adaptWindowHeightIfNeed(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.addView(composeView);
        }
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.b);
        composeView.setContent(n0(this.a, this.b, this.c));
        getSwipeBackLayout().setIsEnableSideSlipPullDown(true);
        getSwipeBackLayout().getViewTreeObserver().addOnGlobalLayoutListener(new a());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.0f);
            window.clearFlags(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void s0(o oVar) {
        super/*android.app.Dialog*/.onBackPressed();
    }

    @Override // wn4.b
    public void init(Function1<? super String, Unit> onClose) {
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.e = onClose;
    }

    public void onShowPercent(float f) {
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.onShowPercent(f);
        ignoreHeightChange(false);
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
            ViewGroup viewGroup = o.this.g;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            o.this.h0(this.b);
        }

        b(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.b = function2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final int g0(o oVar) {
        Activity activity = ContextUtils.getActivity(oVar.getContext());
        if (activity != null) {
            return activity.hashCode();
        }
        return 0;
    }

    @Override // wn4.b
    public void dismiss(String closeReason) {
        Intrinsics.checkNotNullParameter(closeReason, "closeReason");
        this.d = closeReason;
        dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.onCreate(bundle);
        this.l.c(bundle);
        l0().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        q0();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View m0 = m0(context, getContentContainer());
        this.f = m0;
        this.g = k0(m0);
        eq2.b.h().f(this);
        setLayoutParams();
        initView();
        o0();
    }

    public final void t0(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.addAnimation(getHideAnimation());
        animationSet.setDuration(this.j);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new b(content));
        View view = this.f;
        if (view != null) {
            view.startAnimation(animationSet);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h0(Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        animationSet.addAnimation(getShowAnimation());
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(this.i);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        composeView.setContent(content);
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.addView(composeView);
        }
        View view = this.f;
        if (view != null) {
            view.startAnimation(animationSet);
        }
    }

    protected void onDragPositionChange(SwipeBackLayout swipeBackLayout, View view, float f) {
        if (((AnimationBottomDialog) this).enableNotifyHeightChange) {
            com.dragon.read.widget.dialog.d.a.k(1.0f - f, i0());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Activity activity, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, int i, boolean z) {
        super(activity, i);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.a = shareChannelList;
        this.b = onClickListener;
        this.c = z;
        this.d = "mask_layer";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: rn4.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int g0;
                g0 = o.g0(o.this);
                return Integer.valueOf(g0);
            }
        });
        this.h = lazy;
        this.i = 300;
        this.j = 300;
        this.l = h2.g.c.b(this);
        this.m = new OnBackPressedDispatcher(new Runnable() { // from class: rn4.n
            @Override // java.lang.Runnable
            public final void run() {
                o.s0(o.this);
            }
        });
    }
}
