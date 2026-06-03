package com.dragon.read.openanim;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a implements LifecycleEventObserver {
    public static final int b;
    private boolean a;

    static {
        Covode.recordClassIndex(612622);
        b = 8;
    }

    public void a() {
        throw null;
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_STOP || event == Lifecycle.Event.ON_PAUSE) {
            this.a = true;
        }
        if (this.a) {
            if (event == Lifecycle.Event.ON_START || event == Lifecycle.Event.ON_RESUME) {
                a();
                source.getLifecycle().removeObserver(this);
            }
        }
    }
}
