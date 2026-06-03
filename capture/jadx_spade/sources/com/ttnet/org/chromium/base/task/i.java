package com.ttnet.org.chromium.base.task;

import com.bytedance.covode.number.Covode;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class i implements Executor {
    final ArrayDeque<Runnable> a = new ArrayDeque<>();
    Runnable b;

    static {
        Covode.recordClassIndex(654406);
    }

    i() {
    }

    class a implements Runnable {
        final /* synthetic */ Runnable a;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } finally {
                i.this.a();
            }
        }

        a(Runnable runnable) {
            this.a = runnable;
        }
    }

    protected synchronized void a() {
        Runnable poll = this.a.poll();
        this.b = poll;
        if (poll != null) {
            AsyncTask.a.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.a.offer(new a(runnable));
        if (this.b == null) {
            a();
        }
    }
}
