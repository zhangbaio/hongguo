package os3;

import android.content.Context;
import android.os.Handler;
import androidx.compose.ui.graphics.colorspace.f0;
import com.bytedance.covode.number.Covode;
import com.bytedance.watson.assist.api.AssistConfig;
import com.bytedance.watson.assist.api.AssistStatFactory;
import com.bytedance.watson.assist.api.IAssistStat;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsCommunityApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final a j;
    public static final int k;
    private final Handler a;
    private final InterfaceC0252c b;
    private final long c;
    private final long d;
    private final Context e;
    private boolean f;
    private String g;
    private final List<b> h;
    private IAssistStat i;

    /* renamed from: os3.c$c, reason: collision with other inner class name */
    public interface InterfaceC0252c {
        void a(List<b> list);
    }

    static {
        Covode.recordClassIndex(599017);
        j = new a(null);
        k = 8;
    }

    private final void g() {
        this.a.postDelayed(new Runnable() { // from class: os3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.h(c.this);
            }
        }, this.c);
    }

    private final void i() {
        this.a.postDelayed(new Runnable() { // from class: os3.a
            @Override // java.lang.Runnable
            public final void run() {
                c.j(c.this);
            }
        }, this.d);
    }

    private final void c() {
        if (!this.f) {
            return;
        }
        this.h.add(d());
        if (this.h.size() >= 10) {
            e();
        }
        if (this.f) {
            g();
        }
    }

    private final void e() {
        if (this.h.isEmpty()) {
            return;
        }
        try {
            this.b.a(new ArrayList(this.h));
        } catch (Throwable th) {
            LogWrapper.warn("CpuPowerLogger", "report error: " + th.getMessage(), new Object[0]);
        }
        this.h.clear();
    }

    private final void f() {
        try {
            AssistConfig assistConfig = new AssistConfig();
            assistConfig.setEnableCpuUsageStat(true);
            assistConfig.setEnableCpuSpeedStat(true);
            this.i = AssistStatFactory.create(this.e, assistConfig).start();
        } catch (Exception e) {
            LogWrapper.error("CpuPowerLogger", "init Watson fail: " + e.getMessage(), new Object[0]);
        }
    }

    private final void n() {
        try {
            IAssistStat iAssistStat = this.i;
            if (iAssistStat != null) {
                iAssistStat.refreshCpuStat();
            }
        } catch (Throwable th) {
            LogWrapper.warn("CpuPowerLogger", "warmUpCpu fail: " + th.getMessage(), new Object[0]);
        }
    }

    private final b d() {
        double d;
        double d2;
        double d3;
        IAssistStat iAssistStat;
        double d4 = -1.0d;
        try {
            iAssistStat = this.i;
        } catch (Throwable th) {
            th = th;
            d = -1.0d;
        }
        if (iAssistStat != null) {
            iAssistStat.refreshCpuStat();
            d = l(iAssistStat.getProcCpuSpeed());
            try {
                d4 = l(iAssistStat.getProcCpuUsage());
            } catch (Throwable th2) {
                th = th2;
                LogWrapper.warn("CpuPowerLogger", "fillCpuSample fail: " + th.getMessage(), new Object[0]);
                d3 = d4;
                d2 = d;
                return new b(this.g, d3, d2);
            }
            d3 = d4;
            d2 = d;
            return new b(this.g, d3, d2);
        }
        d3 = -1.0d;
        d2 = -1.0d;
        return new b(this.g, d3, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c cVar) {
        cVar.c();
    }

    public final void m(String str) {
        if (str == null) {
            str = "";
        }
        this.g = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(c cVar) {
        cVar.e();
        if (cVar.f) {
            cVar.i();
        }
    }

    private final double l(double d) {
        return Math.rint(d * 1000) / 1000.0d;
    }

    public final void k(String str) {
        m(str);
        if (this.f) {
            return;
        }
        this.f = true;
        g();
        i();
        n();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(599018);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JSONObject a(b info) {
            int i;
            boolean z;
            Intrinsics.checkNotNullParameter(info, "info");
            JSONObject jSONObject = new JSONObject();
            try {
                int i2 = 1;
                if (ActivityRecordManager.inst().isAppForeground()) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("app_foreground", i);
                jSONObject.put("main_scene", info.a);
                jSONObject.put("cpu_usage", info.b);
                jSONObject.put("cpu_speed", info.c);
                NsCommunityApi nsCommunityApi = NsCommunityApi.IMPL;
                if (nsCommunityApi.videoDanmakuService().C() && nsCommunityApi.videoDanmakuService().i()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    i2 = 0;
                }
                jSONObject.put("hongguo_danmaku_status", i2);
            } catch (JSONException e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "convertJson error";
                }
                LogWrapper.error("CpuPowerLogger", message, new Object[0]);
            }
            return jSONObject;
        }
    }

    public static final class b {
        public final String a;
        public final double b;
        public final double c;

        static {
            Covode.recordClassIndex(599019);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && Double.compare(this.b, bVar.b) == 0 && Double.compare(this.c, bVar.c) == 0;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + f0.a(this.b)) * 31) + f0.a(this.c);
        }

        public String toString() {
            return "CpuSample(mainScene=" + this.a + ", procCpuUsagePct=" + this.b + ", procCpuSpeed=" + this.c + ')';
        }

        public b(String mainScene, double d, double d2) {
            Intrinsics.checkNotNullParameter(mainScene, "mainScene");
            this.a = mainScene;
            this.b = d;
            this.c = d2;
        }
    }

    public c(Context context, Handler handler, InterfaceC0252c reporter, long j2, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.a = handler;
        this.b = reporter;
        this.c = j2;
        this.d = j3;
        this.e = context.getApplicationContext();
        this.g = "";
        this.h = new ArrayList();
        f();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ c(android.content.Context r11, android.os.Handler r12, os3.c.InterfaceC0252c r13, long r14, long r16, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 8
            if (r0 == 0) goto L9
            r0 = 60000(0xea60, double:2.9644E-319)
            r6 = r0
            goto La
        L9:
            r6 = r14
        La:
            r0 = r18 & 16
            if (r0 == 0) goto L13
            r0 = 120000(0x1d4c0, double:5.9288E-319)
            r8 = r0
            goto L15
        L13:
            r8 = r16
        L15:
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r2.<init>(r3, r4, r5, r6, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: os3.c.<init>(android.content.Context, android.os.Handler, os3.c$c, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
