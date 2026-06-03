package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class g implements Executor {
    private static final AtomicBoolean g;
    public boolean b;
    public boolean c;
    private InterruptedIOException d;
    private RuntimeException e;
    private long f = -1;
    private final BlockingQueue<Runnable> a = new LinkedBlockingQueue();

    public void c() {
        this.c = false;
    }

    public void quit() {
        this.b = false;
    }

    static {
        Covode.recordClassIndex(654691);
        g = new AtomicBoolean(false);
    }

    public boolean b() {
        long j = this.f;
        if (j != -1 && j != Thread.currentThread().getId()) {
            return false;
        }
        return true;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException {
        if (runnable != null) {
            try {
                this.a.put(runnable);
                return;
            } catch (InterruptedException e) {
                throw new RejectedExecutionException(e);
            }
        }
        throw new IllegalArgumentException();
    }

    public void a(int i) throws IOException {
        long nanoTime = System.nanoTime();
        long convert = TimeUnit.NANOSECONDS.convert(i, TimeUnit.MILLISECONDS);
        if (this.c) {
            InterruptedIOException interruptedIOException = this.d;
            if (interruptedIOException != null) {
                throw interruptedIOException;
            }
            throw this.e;
        }
        if (!this.b) {
            this.b = true;
            while (this.b) {
                if (i == 0) {
                    try {
                        d(false, 0L).run();
                    } catch (SocketTimeoutException e) {
                        this.b = false;
                        this.c = true;
                        throw e;
                    } catch (InterruptedIOException e2) {
                        this.b = false;
                        this.c = true;
                        this.d = e2;
                        throw e2;
                    } catch (RuntimeException e3) {
                        this.b = false;
                        this.c = true;
                        this.e = e3;
                        throw e3;
                    }
                } else {
                    d(true, (convert - System.nanoTime()) + nanoTime).run();
                }
            }
            return;
        }
        throw new IllegalStateException("Cannot run loop when it is already running.");
    }

    private Runnable d(boolean z, long j) throws InterruptedIOException {
        Runnable poll;
        try {
            if (!z) {
                poll = this.a.take();
            } else {
                poll = this.a.poll(j, TimeUnit.NANOSECONDS);
            }
            if (poll != null) {
                return poll;
            }
            throw new SocketTimeoutException("ttnet");
        } catch (InterruptedException e) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e);
            throw interruptedIOException;
        }
    }
}
