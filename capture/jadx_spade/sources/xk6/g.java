package xk6;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.bytedance.common.jato.JatoXL;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class g {
    private static bl6.a a;
    private static final Handler b;
    private static final Handler c;

    public static Handler b() {
        return b;
    }

    private static class b implements Runnable {
        final Runnable a;

        static {
            Covode.recordClassIndex(655874);
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception e) {
                    g.a.b("fail to execute runnable = %s, error =%s ", this.a, Log.getStackTraceString(e));
                }
            }
        }

        private b(Runnable runnable) {
            this.a = runnable;
        }
    }

    static {
        Covode.recordClassIndex(655873);
        a = new bl6.a("ThreadUtils");
        b = new HandlerDelegate(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("player_background_thread_utils");
        handlerThread.start();
        c = new HandlerDelegate(handlerThread.getLooper());
        a.d("ThreadUtils 初始化完成，currentThread = %s", Thread.currentThread());
    }

    public static void d(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        c.post(new b(runnable));
    }

    public static void e(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        b.post(new b(runnable));
    }

    public static void f(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        b.post(runnable);
    }

    public static void g(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        b.postAtFrontOfQueue(runnable);
    }

    public static void i(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        b.removeCallbacks(runnable);
    }

    public static void k(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            e(runnable);
        }
    }

    public static void c(Runnable runnable, long j) {
        if (runnable == null) {
            return;
        }
        b.postDelayed(runnable, j);
    }

    public static void j(int i, boolean z) {
        if (z) {
            JatoXL.resetCoreBind(i);
        }
        JatoXL.resetPriority(i);
    }

    public static void h(int i, int i2, boolean z) {
        if (z) {
            JatoXL.bindBigCore(i);
        }
        if (i2 > 19 || i2 < -20) {
            i2 = 0;
        }
        JatoXL.setPriority(i, i2);
    }
}
