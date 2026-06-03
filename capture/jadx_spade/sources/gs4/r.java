package gs4;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.report.ReportManager;
import com.dragon.read.util.DebugManager;
import com.ss.android.excitingvideo.utils.GsonUtilKt;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public static final r a;
    private static final Handler b;
    private static final HashMap<String, FpsTracer> c;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    public static final int g;

    private r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        f = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        e = false;
    }

    static {
        Covode.recordClassIndex(612316);
        a = new r();
        b = new HandlerDelegate(Looper.getMainLooper());
        c = new HashMap<>(10);
        d = true;
        e = true;
        f = true;
        g = 8;
    }

    public static final class a implements FpsTracer.IDropFrameCallback {
        public static final int c;
        private final c a;
        public final Map<String, Object> b;

        static {
            Covode.recordClassIndex(612317);
            c = 8;
        }

        public void dropFrame(JSONObject jSONObject) {
            c cVar = this.a;
            cVar.c = jSONObject;
            cVar.a(this.b);
        }

        public a(c fpsInfo, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(fpsInfo, "fpsInfo");
            this.a = fpsInfo;
            this.b = map;
        }
    }

    public final void i(String tabName) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        c.remove(tabName);
    }

    public static final class b implements FpsTracer.IFPSCallBack {
        public static final int c;
        private final c a;
        public final Map<String, Object> b;

        static {
            Covode.recordClassIndex(612318);
            c = 8;
        }

        public void fpsCallBack(double d) {
            c cVar = this.a;
            cVar.b = d;
            cVar.e = System.currentTimeMillis();
            this.a.a(this.b);
        }

        public b(c fpsInfo, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(fpsInfo, "fpsInfo");
            this.a = fpsInfo;
            this.b = map;
        }
    }

    public static final class c {
        public static final int f;
        public String a;
        public double b;
        public JSONObject c;
        public final long d;
        public long e;

        static {
            Covode.recordClassIndex(612319);
            f = 8;
        }

        public final void a(Map<String, ? extends Object> map) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            if (this.b > 0.0d && this.c != null) {
                int i8 = 1;
                int i9 = 1;
                int i10 = 0;
                while (true) {
                    i = 3;
                    if (i9 >= 3) {
                        break;
                    }
                    JSONObject jSONObject = this.c;
                    if (jSONObject != null) {
                        i7 = jSONObject.optInt(String.valueOf(i9), 0);
                    } else {
                        i7 = 0;
                    }
                    i10 += i7;
                    i9++;
                }
                int i11 = 0;
                while (true) {
                    i2 = 7;
                    if (i >= 7) {
                        break;
                    }
                    JSONObject jSONObject2 = this.c;
                    if (jSONObject2 != null) {
                        i6 = jSONObject2.optInt(String.valueOf(i), 0);
                    } else {
                        i6 = 0;
                    }
                    i11 += i6;
                    i++;
                }
                int i12 = 0;
                while (true) {
                    if (i2 >= 14) {
                        break;
                    }
                    JSONObject jSONObject3 = this.c;
                    if (jSONObject3 != null) {
                        i5 = jSONObject3.optInt(String.valueOf(i2), 0);
                    } else {
                        i5 = 0;
                    }
                    i12 += i5;
                    i2++;
                }
                int i13 = 0;
                for (i3 = 14; i3 < 60; i3++) {
                    JSONObject jSONObject4 = this.c;
                    if (jSONObject4 != null) {
                        i4 = jSONObject4.optInt(String.valueOf(i3), 0);
                    } else {
                        i4 = 0;
                    }
                    i13 += i4;
                }
                int i14 = i11 + i12 + i13;
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("fps", this.b);
                jSONObject5.put("category_name", this.a);
                jSONObject5.put("refresh_rate", FpsUtil.getRefreshRate());
                jSONObject5.put("real_refresh_rate", FpsUtil.getRealRefreshRate());
                jSONObject5.put("max_refresh_rate", FpsUtil.getDeviceMaxRefreshRate());
                jSONObject5.put("less_than_30sec", r.f ? 1 : 0);
                if (r.f || !r.e) {
                    i8 = 0;
                }
                jSONObject5.put("between_30_and_60sec", i8);
                jSONObject5.put("less_than_1min", r.e ? 1 : 0);
                jSONObject5.put("light_drop_count", i11);
                jSONObject5.put("slight_drop_count", i10);
                jSONObject5.put("moderate_drop_count", i12);
                jSONObject5.put("heavy_drop_count", i13);
                jSONObject5.put("total_drop_count", i14);
                jSONObject5.put("is_audio_playing", NsCommonDepend.IMPL.audioPlayManager().isCurrentPlayerPlaying());
                long j = this.e;
                if (j > -1) {
                    jSONObject5.put("total_scroll_time", j - this.d);
                }
                if (map != null) {
                    for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                        jSONObject5.put(entry.getKey(), entry.getValue());
                    }
                }
                if (DebugManager.isDebugBuild()) {
                    LogWrapper.info("FeedFpsUtils", "page_scroll_fps mapsize " + r.c.size() + " params = " + GsonUtilKt.toJsonString(jSONObject5), new Object[0]);
                }
                ReportManager.onReport("page_scroll_fps", jSONObject5);
                this.b = 0.0d;
                this.c = null;
            }
        }

        public c(String tabName, i0 i0Var, double d, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(tabName, "tabName");
            this.a = tabName;
            this.b = d;
            this.c = jSONObject;
            this.d = System.currentTimeMillis();
            this.e = -1L;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ c(java.lang.String r8, gs4.i0 r9, double r10, org.json.JSONObject r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
            /*
                r7 = this;
                r14 = r13 & 2
                r0 = 0
                if (r14 == 0) goto L7
                r3 = r0
                goto L8
            L7:
                r3 = r9
            L8:
                r9 = r13 & 4
                if (r9 == 0) goto Le
                r10 = 0
            Le:
                r4 = r10
                r9 = r13 & 8
                if (r9 == 0) goto L15
                r6 = r0
                goto L16
            L15:
                r6 = r12
            L16:
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: gs4.r.c.<init>(java.lang.String, gs4.i0, double, org.json.JSONObject, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }

    public final void j(FpsTracer fpsTracer, String tabName, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(fpsTracer, "<this>");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        c cVar = new c(tabName, null, 0.0d, null, 12, null);
        fpsTracer.setIFPSCallBack(new b(cVar, map));
        fpsTracer.setDropFrameCallback(new a(cVar, map));
    }

    public static final FpsTracer f(String tabName, i0 i0Var, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        if (d) {
            d = false;
            Handler handler = b;
            handler.postDelayed(new Runnable() { // from class: gs4.p
                @Override // java.lang.Runnable
                public final void run() {
                    r.g();
                }
            }, 30000L);
            handler.postDelayed(new Runnable() { // from class: gs4.q
                @Override // java.lang.Runnable
                public final void run() {
                    r.h();
                }
            }, 60000L);
        }
        HashMap<String, FpsTracer> hashMap = c;
        FpsTracer fpsTracer = hashMap.get(tabName);
        c cVar = new c(tabName, i0Var, 0.0d, null, 12, null);
        if (fpsTracer == null) {
            FpsTracer fpsTracer2 = new FpsTracer(tabName, true);
            fpsTracer2.setIFPSCallBack(new b(cVar, map));
            fpsTracer2.setDropFrameCallback(new a(cVar, map));
            hashMap.put(tabName, fpsTracer2);
            return fpsTracer2;
        }
        return fpsTracer;
    }
}
