package dl6;

import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.xs.fm.player.base.play.inter.AbsPlayListener;
import com.xs.fm.player.base.play.player.IPlayer;
import java.security.SecureRandom;
import xk6.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static bl6.a a;
    private static AbsPlayListener b;
    private static PowerManager.WakeLock c;
    private static Handler d;
    private static Runnable e;

    /* renamed from: dl6.a$a, reason: collision with other inner class name */
    static class C0141a extends AbsPlayListener {
        C0141a() {
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onPlayStateChange(IPlayer iPlayer, int i) {
            if (i == 103) {
                a.f();
                return;
            }
            if (i == 101) {
                a.l();
            } else if (i == 102 && lk6.c.a.l.r()) {
                a.f();
            }
        }
    }

    static class b implements a.b {
        b() {
        }

        @Override // xk6.a.b
        public void onEnterForeground() {
            a.l();
        }

        @Override // xk6.a.b
        public void onEnterBackground() {
            if (il6.a.B().isPlaying()) {
                a.d.removeCallbacks(a.e);
                a.f();
            }
        }
    }

    public static boolean h() {
        nk6.b bVar;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.l) != null) {
            return bVar.b0();
        }
        return false;
    }

    public static boolean i() {
        nk6.b bVar;
        lk6.b bVar2 = lk6.c.a;
        if (bVar2 != null && (bVar = bVar2.l) != null) {
            return bVar.a0();
        }
        return false;
    }

    public static void k() {
        il6.a.B().addPlayListener(b);
        if (i()) {
            xk6.a.g().e(new b());
        }
    }

    public static void l() {
        a.d("releaseWakeLockLater: start", new Object[0]);
        if (c != null) {
            d.postDelayed(e, lk6.c.a.l.r0());
        }
    }

    public static class c implements Runnable {
        static {
            Covode.recordClassIndex(655904);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.a.d("releaseWakeLockRunnable: start", new Object[0]);
                if (a.c != null) {
                    a.a.d("releaseWakeLockRunnable: release", new Object[0]);
                    a.c.release();
                    PowerManager.WakeLock unused = a.c = null;
                }
                dl6.b.c.e();
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    static {
        Covode.recordClassIndex(655903);
        a = new bl6.a("AudioServiceWakeLock");
        b = new C0141a();
        c = null;
        d = new HandlerDelegate(Looper.getMainLooper());
        e = new c();
    }

    private static String j() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder("AudioServiceWakeLock-");
        for (int i = 0; i < 5; i++) {
            sb.append(secureRandom.nextInt(10));
        }
        return sb.toString();
    }

    public static void g() {
        try {
            if (xk6.a.g().b && i()) {
                a.d("acquireWakeLock: enableDoNotAcquireWakelockInForeground", new Object[0]);
                return;
            }
            a.d("acquireWakeLockIgnore: start", new Object[0]);
            d.removeCallbacks(e);
            PowerManager.WakeLock newWakeLock = ((PowerManager) lk6.c.a.b.getSystemService("power")).newWakeLock(1, j());
            if (newWakeLock != null) {
                newWakeLock.acquire();
                PowerManager.WakeLock wakeLock = c;
                if (wakeLock != null) {
                    wakeLock.release();
                }
                c = newWakeLock;
            }
            dl6.b.c.b();
        } catch (Throwable th) {
            th.printStackTrace();
            a.b("acquireWakeLock error:%s", th);
        }
    }

    public static void f() {
        try {
            if (xk6.a.g().b && i()) {
                a.d("acquireWakeLock: enableDoNotAcquireWakelockInForeground", new Object[0]);
                return;
            }
            if (!xk6.a.g().b && h()) {
                a.d("acquireWakeLock: enableDoNotAcquireWakelockInBackground", new Object[0]);
                return;
            }
            a.d("acquireWakeLock: start", new Object[0]);
            d.removeCallbacks(e);
            if (c == null) {
                a.d("acquireWakeLock: getSystemService", new Object[0]);
                PowerManager.WakeLock newWakeLock = ((PowerManager) lk6.c.a.b.getSystemService("power")).newWakeLock(536870913, "AudioServiceWakeLock");
                c = newWakeLock;
                if (newWakeLock != null) {
                    a.d("acquireWakeLock: acquire", new Object[0]);
                    c.acquire();
                }
            }
            dl6.b.c.a();
        } catch (Throwable th) {
            a.d("acquireWakeLock: " + th.getMessage(), new Object[0]);
        }
    }
}
