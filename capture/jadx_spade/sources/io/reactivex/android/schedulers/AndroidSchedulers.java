package io.reactivex.android.schedulers;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import io.reactivex.Scheduler;
import java.util.concurrent.Callable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD;

    static class a implements Callable<Scheduler> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return b.a;
        }
    }

    public static Scheduler mainThread() {
        return jm6.a.e(MAIN_THREAD);
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    private static final class b {
        static final Scheduler a;

        static {
            Covode.recordClassIndex(656248);
            a = new io.reactivex.android.schedulers.a(new HandlerDelegate(Looper.getMainLooper()), false);
        }
    }

    static {
        Covode.recordClassIndex(656247);
        MAIN_THREAD = jm6.a.d(new a());
    }

    public static Scheduler from(Looper looper) {
        return from(looper, false);
    }

    public static Scheduler from(Looper looper, boolean z) {
        if (looper != null) {
            int i = Build.VERSION.SDK_INT;
            if (z && i < 22) {
                Message obtain = Message.obtain();
                try {
                    obtain.setAsynchronous(true);
                } catch (NoSuchMethodError unused) {
                    z = false;
                }
                obtain.recycle();
            }
            return new io.reactivex.android.schedulers.a(new HandlerDelegate(looper), z);
        }
        throw new NullPointerException("looper == null");
    }
}
