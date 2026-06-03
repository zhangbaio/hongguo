package jj6;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.videoarch.liveplayer.log.LiveError;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import fj6.c;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static final SparseArray<String> A;
    private static final SparseIntArray x;
    private static final SparseArray<String> y;
    private static final SparseArray<String> z;
    private final b a;
    private long b;
    private long c;
    public long d;
    private c n;
    public int e = 5000;
    private int f = 50;
    private AtomicInteger g = new AtomicInteger(0);
    private int h = 7;
    public String i = null;
    private boolean j = false;
    private long k = 0;
    private boolean l = false;
    private boolean m = false;
    public int o = -1;
    private boolean p = false;
    private int q = 2;
    private int r = -1;
    private int s = -1;
    private boolean t = false;
    private int u = -1;
    public boolean v = false;
    private final Handler w = new C0195a(Looper.myLooper());

    public interface b {
        void a(boolean z);

        void b(boolean z);

        void c();

        void d(LiveError liveError);

        void e();

        void f();

        void g(LiveError liveError);

        void h();

        void onStallStart();
    }

    public void r() {
        this.m = true;
    }

    public void u() {
        this.m = false;
    }

    public int i() {
        return this.g.get();
    }

    public boolean k() {
        c cVar = this.n;
        if (cVar != null) {
            return cVar.g0();
        }
        return false;
    }

    public void s() {
        if (this.o != -1) {
            if (this.w.hasMessages(10005)) {
                this.w.removeMessages(10005);
            }
            this.w.sendEmptyMessageDelayed(10005, this.o);
        }
    }

    public void t() {
        if (this.w.hasMessages(10006)) {
            this.w.removeMessages(10006);
        }
        this.w.sendEmptyMessageDelayed(10006, -1L);
    }

    public void n() {
        this.g.set(0);
        this.c = 0L;
        this.h = 7;
        this.j = false;
        this.k = 0L;
        this.l = false;
        this.p = false;
        this.q = 2;
        this.u = -1;
        this.w.removeCallbacksAndMessages(null);
    }

    static {
        Covode.recordClassIndex(653084);
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        SparseArray<String> sparseArray = new SparseArray<>();
        y = sparseArray;
        SparseArray<String> sparseArray2 = new SparseArray<>();
        z = sparseArray2;
        SparseArray<String> sparseArray3 = new SparseArray<>();
        A = sparseArray3;
        sparseIntArray.put(-100002, 3);
        sparseIntArray.put(-100006, 3);
        sparseIntArray.put(-100007, 3);
        sparseIntArray.put(-100008, 3);
        sparseIntArray.put(-100009, 3);
        sparseIntArray.put(-100013, 3);
        sparseIntArray.put(-100014, 3);
        sparseArray.put(-499988, "media player: setting uri is null error");
        sparseArray.put(-499987, "media player: setting uri is error");
        sparseArray.put(-499986, "media player: url is not mp4 error");
        sparseArray.put(-499985, "media player: invalid data error");
        sparseArray.put(-499899, "media player: http bad request error");
        sparseArray.put(-499898, "media player: http unauthorized error");
        sparseArray.put(-499897, "media player: http forbidden error");
        sparseArray.put(-499896, "media player: http not found error");
        sparseArray.put(-499894, "media player: http other 4xx error");
        sparseArray.put(-499893, "media player: http server error");
        sparseArray.put(-499891, "media player: http content type invalid");
        sparseArray.put(251658241, "media info http redirect");
        sparseArray.put(-499799, "media player: tcp failed to resolve hostname");
        sparseArray.put(-499795, "media player: tcp send data failed");
        sparseArray.put(-499794, "media player: tcp receive data failed");
        sparseArray.put(-499793, "media player: tcp read network timeout");
        sparseArray.put(-499792, "media player: tcp write network timeout");
        sparseArray2.put(-499999, "media player setting is null");
        sparseArray2.put(-499997, "media player start decoder error");
        sparseArray2.put(-499996, "media player open decoder error");
        sparseArray2.put(-499992, "media player open outlet error");
        sparseArray2.put(-499991, "media player start outputer error");
        sparseArray2.put(-499990, "media player start outlet error");
        sparseArray2.put(-499989, "media player open device error");
        sparseArray2.put(1, "android media player unknown");
        sparseArray3.put(-1, "not retry, report to application");
        sparseArray3.put(1, "try next url from live info");
        sparseArray3.put(2, "reset player");
    }

    private void v(LiveError liveError) {
        int i = this.h - 1;
        this.h = i;
        if (i >= 0) {
            this.n.z0(liveError.code, liveError.getInfoJSON());
        }
    }

    public void p(int i) {
        this.f = i;
        com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "setRetryCountLimit retryCountLimit: " + i);
    }

    public void q(long j) {
        this.b = j * 1000;
        com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "setStallRetryTimeout mRetryTimeLimit: " + this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i) {
        boolean z2 = this.j;
        if (!z2 || (z2 && System.currentTimeMillis() - this.k >= 1000)) {
            this.n.D0(i);
            this.n.g1(i);
            this.j = true;
            this.k = System.currentTimeMillis();
        }
    }

    public void o(JSONObject jSONObject) {
        boolean z2 = false;
        if (jSONObject == null) {
            this.t = false;
            return;
        }
        if (jSONObject.optInt("enable") == 1) {
            z2 = true;
        }
        this.t = z2;
        if (z2) {
            this.r = jSONObject.optInt("errorStartup");
            this.s = jSONObject.optInt("errorSteps");
            long optInt = jSONObject.optInt("stallTimeThres");
            if (optInt > 0) {
                this.d = optInt;
            }
        }
        com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "enable switch line: " + this.t + ", start up switch error count: " + this.r + ", step switch error count: " + this.s + ", stall time thres: " + this.d);
    }

    /* renamed from: jj6.a$a, reason: collision with other inner class name */
    class C0195a extends HandlerDelegate {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 10001:
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - a.this.c >= a.this.b) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("stallTime", Long.valueOf(currentTimeMillis - a.this.c));
                        a.this.j(-1, new LiveError(-100007, "Stall retry timeout", hashMap));
                        break;
                    } else {
                        a.this.w(-100015);
                        com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "stall timeout, trigger retry");
                        if (!a.this.t) {
                            a.this.a.b(false);
                        } else {
                            a.this.a.d(new LiveError(-100015, null, null));
                        }
                        a.this.w.sendEmptyMessageDelayed(10001, a.this.d);
                        break;
                    }
                case 10002:
                case 10003:
                    a.this.j(2, null);
                    break;
                case 10004:
                    a.this.j(1, null);
                    break;
                case 10005:
                    a.this.j(7, null);
                    break;
                case 10006:
                    a.this.j(9, null);
                    break;
            }
        }

        C0195a(Looper looper) {
            super(looper);
        }
    }

    public void m(boolean z2, boolean z3) {
        com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "onStall " + z2);
        if (z2) {
            this.c = System.currentTimeMillis();
            if (z3) {
                this.a.b(true);
                w(-100018);
            }
            if (!this.w.hasMessages(10001)) {
                this.w.sendEmptyMessageDelayed(10001, this.d);
                return;
            }
            return;
        }
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i, LiveError liveError) {
        com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "handleRetryForError action=" + i);
        long j = 0;
        switch (i) {
            case -1:
                com.ss.videoarch.liveplayer.log.a.a("RetryProcessor", "ACTION_REPORT_OUTSIDE");
                this.a.g(liveError);
                break;
            case 1:
                com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "ACTION_NEXT_URL");
                this.a.e();
                break;
            case 2:
                com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "ACTION_RESET_PLAYER");
                this.a.b(false);
                break;
            case 3:
                com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "ACTION_RESET_LATER");
                if (!this.w.hasMessages(10002)) {
                    com.ss.videoarch.liveplayer.log.a.c("RETRY", "start " + this.g);
                    Handler handler = this.w;
                    if (this.g.get() > 3) {
                        j = this.e;
                    }
                    handler.sendEmptyMessageDelayed(10002, j);
                    break;
                }
                break;
            case 4:
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "ACTION_RTC_FALLBACK");
                this.a.c();
                break;
            case 5:
                com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "ACTION_RTC_RESET_LATER start " + this.g + ", max retry count " + this.n.Ab + ",fallback threshold:" + this.n.Bb + ", retry interval:" + this.n.Cb);
                this.w.sendEmptyMessageDelayed(10003, (long) this.n.Cb);
                break;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "ACTION_NEXT_URL later");
                if (!this.w.hasMessages(10004)) {
                    com.ss.videoarch.liveplayer.log.a.c("RETRY", "start " + this.g);
                    Handler handler2 = this.w;
                    if (this.g.get() > 3) {
                        j = this.e;
                    }
                    handler2.sendEmptyMessageDelayed(10004, j);
                    break;
                }
                break;
            case 7:
                com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "ACTION_RESOLUTION_DEGRADE");
                this.a.a(this.p);
                this.p = true;
                break;
            case 9:
                com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "ACTION_SWITCH_NETWORK");
                this.a.h();
                break;
            case 10:
                com.ss.videoarch.liveplayer.log.a.c("RetryProcessor", "ACTION_SWITCH_LINE");
                this.a.d(liveError);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(com.ss.videoarch.liveplayer.log.LiveError r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jj6.a.l(com.ss.videoarch.liveplayer.log.LiveError, boolean):void");
    }

    public a(b bVar, int i, long j, c cVar) {
        this.d = 10000L;
        this.a = bVar;
        this.b = i * 1000;
        this.d = j;
        this.g.set(0);
        this.n = cVar;
    }
}
