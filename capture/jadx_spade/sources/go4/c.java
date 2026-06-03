package go4;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.w0;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.kmp.shortvideo.distribution.infinite.g;
import com.dragon.read.kmp.shortvideo.distribution.model.FilterType;
import com.dragon.read.widget.dialog.AnimationSwipeBottomDialog;
import h2.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c extends AnimationSwipeBottomDialog implements LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner, ViewModelStoreOwner {
    public static final a h;
    public static final int i;
    public final Context a;
    public final g b;
    public final FilterType c;
    private final LifecycleRegistry d;
    private final h2.g e;
    private final ViewModelStore f;
    private final OnBackPressedDispatcher g;

    public static final class a {
        static {
            Covode.recordClassIndex(609018);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609017);
        h = new a(null);
        i = 8;
    }

    public Lifecycle getLifecycle() {
        return this.d;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.g;
    }

    public ViewModelStore getViewModelStore() {
        return this.f;
    }

    public h2.e getSavedStateRegistry() {
        return this.e.b;
    }

    public void onBackPressed() {
        this.g.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super/*android.app.Dialog*/.onSaveInstanceState();
        Intrinsics.checkNotNullExpressionValue(onSaveInstanceState, "onSaveInstanceState(...)");
        this.e.d(onSaveInstanceState);
        return onSaveInstanceState;
    }

    protected void onStart() {
        super.onStart();
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        super/*android.app.Dialog*/.onStop();
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void onDetachedFromWindow() {
        if (!e0()) {
            this.d.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.onDetachedFromWindow();
    }

    private final boolean e0() {
        boolean z;
        if (this.d.getCurrentState() == Lifecycle.State.DESTROYED) {
            z = true;
        } else {
            z = false;
        }
        LogWrapper.info("FilterPanelDialog", "hasDestroy " + z, new Object[0]);
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        getContentContainer().addView(new e(context, this.b, new Function0() { // from class: go4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit f0;
                f0 = c.f0(c.this);
                return f0;
            }
        }, this.c), new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void g0() {
        View decorView;
        View decorView2;
        View decorView3;
        View decorView4;
        Window window = getWindow();
        if (window != null && (decorView4 = window.getDecorView()) != null) {
            ViewTreeLifecycleOwner.set(decorView4, this);
        }
        Window window2 = getWindow();
        if (window2 != null && (decorView3 = window2.getDecorView()) != null) {
            ViewTreeOnBackPressedDispatcherOwner.b(decorView3, this);
        }
        Window window3 = getWindow();
        if (window3 != null && (decorView2 = window3.getDecorView()) != null) {
            k.b(decorView2, this);
        }
        Window window4 = getWindow();
        if (window4 != null && (decorView = window4.getDecorView()) != null) {
            w0.b(decorView, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void h0(c cVar) {
        super/*android.app.Dialog*/.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(c cVar) {
        cVar.dismiss();
        return Unit.INSTANCE;
    }

    public void setContentView(int i2) {
        g0();
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.setContentView(i2);
    }

    public void setContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        g0();
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.setContentView(view);
    }

    protected void onCreate(Bundle bundle) {
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.onCreate(bundle);
        this.e.c(bundle);
        this.d.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        g0();
        super/*android.app.Dialog*/.addContentView(view, layoutParams);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        g0();
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.setContentView(view, layoutParams);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context mContext, g infiniteFilterData, FilterType filterType) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(infiniteFilterData, "infiniteFilterData");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        this.a = mContext;
        this.b = infiniteFilterData;
        this.c = filterType;
        this.d = new LifecycleRegistry(this);
        this.e = h2.g.c.b(this);
        this.f = new ViewModelStore();
        this.g = new OnBackPressedDispatcher(new Runnable() { // from class: go4.b
            @Override // java.lang.Runnable
            public final void run() {
                c.h0(c.this);
            }
        });
    }
}
