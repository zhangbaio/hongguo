package com.ttnet.org.chromium.net.impl;

import com.bytedance.covode.number.Covode;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class p implements Executor {
    private final Executor a;

    static {
        Covode.recordClassIndex(654637);
    }

    private static final class a implements Runnable {
        private final Runnable a;
        private Thread b;
        private InlineExecutionProhibitedException c;

        static {
            Covode.recordClassIndex(654638);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Thread.currentThread() == this.b) {
                this.c = new InlineExecutionProhibitedException();
            } else {
                this.a.run();
            }
        }

        private a(Runnable runnable, Thread thread) {
            this.a = runnable;
            this.b = thread;
        }
    }

    public p(Executor executor) {
        this.a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        a aVar = new a(runnable, Thread.currentThread());
        this.a.execute(aVar);
        if (aVar.c != null) {
            throw aVar.c;
        }
        aVar.b = null;
    }
}
