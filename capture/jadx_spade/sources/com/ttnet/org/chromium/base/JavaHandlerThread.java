package com.ttnet.org.chromium.base;

import android.os.HandlerThread;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.lang.Thread;

@JNINamespace("base::android")
@MainDex
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JavaHandlerThread {
    private final HandlerThread a;
    private Throwable b;

    interface d {
        void a(long j);

        void b(long j, long j2);
    }

    private Throwable getUncaughtExceptionIfAny() {
        return this.b;
    }

    private boolean isAlive() {
        return this.a.isAlive();
    }

    class a implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ long b;

        @Override // java.lang.Runnable
        public void run() {
            f.c().b(this.a, this.b);
        }

        a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    static {
        Covode.recordClassIndex(654217);
    }

    private boolean c() {
        if (this.a.getState() != Thread.State.NEW) {
            return true;
        }
        return false;
    }

    private void joinThread() {
        boolean z = false;
        while (!z) {
            try {
                this.a.join();
                z = true;
            } catch (InterruptedException unused) {
            }
        }
    }

    private void listenForUncaughtExceptionsForTesting() {
        this.a.setUncaughtExceptionHandler(new c());
    }

    public void d() {
        if (c()) {
            return;
        }
        this.a.start();
    }

    class b implements Runnable {
        final /* synthetic */ long a;

        @Override // java.lang.Runnable
        public void run() {
            JavaHandlerThread.this.a.quit();
            f.c().a(this.a);
        }

        b(long j) {
            this.a = j;
        }
    }

    class c implements Thread.UncaughtExceptionHandler {
        c() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            JavaHandlerThread.this.b = th;
        }
    }

    private void quitThreadSafely(long j) {
        new HandlerDelegate(this.a.getLooper()).post(new b(j));
        this.a.getLooper().quitSafely();
    }

    private static JavaHandlerThread create(String str, int i) {
        return new JavaHandlerThread(str, i);
    }

    public JavaHandlerThread(String str, int i) {
        this.a = new HandlerThread(str, i);
    }

    private void startAndInitialize(long j, long j2) {
        d();
        new HandlerDelegate(this.a.getLooper()).post(new a(j, j2));
    }
}
