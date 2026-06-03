package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class c implements k {
    private final Choreographer a;

    static {
        Covode.recordClassIndex(654398);
    }

    class a implements Choreographer.FrameCallback {
        final /* synthetic */ Runnable a;

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.a.run();
        }

        a(Runnable runnable) {
            this.a = runnable;
        }
    }

    c(Choreographer choreographer) {
        this.a = choreographer;
    }

    @Override // com.ttnet.org.chromium.base.task.k
    public void a(Runnable runnable, long j) {
        this.a.postFrameCallbackDelayed(new a(runnable), j);
    }
}
