package rn4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.covode.number.Covode;
import com.dragon.read.util.a1;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wn4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class b extends Dialog implements wn4.b, LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner {
    public static final int l;
    private final Activity a;
    public final un4.j b;
    public final List<bh1.a> c;
    public final Function1<bh1.a, Unit> d;
    public final int e;
    private final boolean f;
    private Function1<? super String, Unit> g;
    private String h;
    private LifecycleRegistry i;
    private final h2.g j;
    private final OnBackPressedDispatcher k;

    static {
        Covode.recordClassIndex(608907);
        l = 8;
    }

    public abstract ViewGroup b();

    public abstract Function2<Composer, Integer, Unit> c(un4.j jVar, List<bh1.a> list, Function1<? super bh1.a, Unit> function1, boolean z);

    public abstract int e();

    public abstract void f();

    public final Activity getActivity() {
        return this.a;
    }

    public OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.k;
    }

    public Lifecycle getLifecycle() {
        return d();
    }

    public h2.e getSavedStateRegistry() {
        return this.j.b;
    }

    private final LifecycleRegistry d() {
        LifecycleRegistry lifecycleRegistry = this.i;
        if (lifecycleRegistry == null) {
            LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
            this.i = lifecycleRegistry2;
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
        this.j.d(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        d().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        d().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.i = null;
        super.onStop();
    }

    private final void j() {
        Window window = getWindow();
        if (window != null) {
            i(window);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
        }
    }

    private final void g() {
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
    public static final void h(b bVar) {
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

    private final void i(Window window) {
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
        decorView.setSystemUiVisibility(1028);
        window.addFlags(1024);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e());
        j();
        f();
        ViewGroup b = b();
        if (b != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            composeView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow.b);
            composeView.setContent(c(this.b, this.c, this.d, this.f));
            b.addView(composeView);
        }
        this.j.c(bundle);
        d().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        g();
        eq2.b.h().f(this);
    }

    @Override // wn4.b
    public void C(String str, List<bh1.a> list, Function1<? super bh1.a, Unit> function1) {
        b.a.a(this, str, list, function1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Activity activity, un4.j tvUgPostShareParams, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, int i, boolean z) {
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
        this.j = h2.g.c.b(this);
        this.k = new OnBackPressedDispatcher(new Runnable() { // from class: rn4.a
            @Override // java.lang.Runnable
            public final void run() {
                b.h(b.this);
            }
        });
    }
}
