package com.dragon.read.openanim;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.widget.ActiveFrameLayout;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q extends i {
    public static final int d;
    public final boolean a;
    private final WeakReference<Activity> b;
    private final a c;

    static {
        Covode.recordClassIndex(612637);
        d = 8;
    }

    private final Activity getActivity() {
        return this.b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActiveFrameLayout f() {
        View view;
        Activity activity = getActivity();
        if (activity != null) {
            view = activity.findViewById(2131821113);
        } else {
            view = null;
        }
        if (!(view instanceof ActiveFrameLayout)) {
            return null;
        }
        return (ActiveFrameLayout) view;
    }

    @Override // com.dragon.read.openanim.i
    public void a() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ActiveFrameLayout f = f();
        if (f != null) {
            f.setActive(true);
        }
        LifecycleOwner activity = getActivity();
        if (activity instanceof LifecycleOwner) {
            lifecycleOwner = activity;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.c);
        }
    }

    public static final class a implements LifecycleEventObserver {
        a() {
        }

        public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            boolean z;
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_START || event == Lifecycle.Event.ON_RESUME) {
                ActiveFrameLayout f = q.this.f();
                if (f != null && !f.getActive()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    LogWrapper.info("DeactivateLayoutListener", "active by onStateChanged " + event, new Object[0]);
                    ActiveFrameLayout f2 = q.this.f();
                    if (f2 != null) {
                        f2.setActive(true);
                    }
                    source.getLifecycle().removeObserver(this);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public q(Activity activity) {
        this(activity, true);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public q(Activity realActivity, boolean z) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(realActivity, "realActivity");
        this.a = z;
        this.b = new WeakReference<>(realActivity);
        a aVar = new a();
        this.c = aVar;
        LifecycleOwner activity = getActivity();
        if (activity instanceof LifecycleOwner) {
            lifecycleOwner = activity;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(aVar);
        }
        ActiveFrameLayout f = f();
        if (f != null) {
            f.setActive(false);
        }
    }
}
