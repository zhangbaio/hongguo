package com.dragon.read.kmp.service;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.AppLifecycleCallback;
import com.dragon.read.app.AppLifecycleMonitor;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i0 implements eo0.a {
    public static final i0 a;

    static {
        Covode.recordClassIndex(608873);
        a = new i0();
    }

    private i0() {
    }

    public static final class a implements AppLifecycleCallback {
        final /* synthetic */ h1 a;

        a(h1 h1Var) {
            this.a = h1Var;
        }

        public void onEnterBackground(WeakReference<Activity> weakReference) {
            Activity activity;
            h1 h1Var = this.a;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            h1Var.onEnterBackground(activity);
        }

        public void onEnterForeground(WeakReference<Activity> weakReference) {
            Activity activity;
            h1 h1Var = this.a;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            h1Var.onEnterForeground(activity);
        }
    }

    public void z0(h1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        AppLifecycleMonitor.getInstance().addCallback(new a(listener));
    }
}
