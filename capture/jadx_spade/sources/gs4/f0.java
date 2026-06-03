package gs4;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.util.DebugManager;
import gs4.f0;
import java.util.HashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f0 {
    public static final a c;
    public static final int d;
    private static final HashMap<String, FpsTracer> e;
    private static final HashMap<String, f0> f;
    private static long g;
    private FpsTracer a;
    private String b;

    public static final void j(int i, String str, String str2, String str3) {
        c.g(i, str, str2, str3);
    }

    public static final void k(String str) {
        c.q(str);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(612323);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k() {
            f.o("feed_scroll", null, 2, null);
        }

        public final void q(final String scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.b0
                @Override // java.lang.Runnable
                public final void run() {
                    f0.a.r(scene);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(String str) {
            FpsTracer fpsTracer = (FpsTracer) f0.e.remove(str);
            if (fpsTracer != null) {
                fpsTracer.stop();
                r.a.i(str);
                if (DebugManager.isDebugBuild()) {
                    LogWrapper.info("FpsMonitorWrapper", "scene(" + str + ") stop fps monitor.", new Object[0]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(String str) {
            f0 f0Var = (f0) f0.f.remove(str);
            if (f0Var != null) {
                f0Var.e();
                if (DebugManager.isDebugBuild()) {
                    LogWrapper.info("FpsMonitorWrapper", "scene(" + str + ") clear recyclerview fps monitor.", new Object[0]);
                }
            }
        }

        public final void o(final String scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.d0
                @Override // java.lang.Runnable
                public final void run() {
                    f0.a.p(scene);
                }
            });
            fk5.d.a.update(0);
            uj5.a aVar = uj5.a.a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("scene", scene);
            Unit unit = Unit.INSTANCE;
            aVar.e("feed_scroll_finish", jSONObject);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(String str) {
            boolean z;
            HashMap hashMapOf;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (f0.g <= 0 || elapsedRealtime - f0.g >= 30000) {
                f0.g = elapsedRealtime;
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return;
            }
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("biz_scene", str));
            f.j("feed_scroll", hashMapOf);
            ThreadUtils.postInForeground(new Runnable() { // from class: gs4.c0
                @Override // java.lang.Runnable
                public final void run() {
                    f0.a.k();
                }
            }, 3000L);
        }

        public final void l(final String scene, final Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.a0
                @Override // java.lang.Runnable
                public final void run() {
                    f0.a.n(scene, map);
                }
            });
            if (fk5.d.a.update(1)) {
                uj5.a aVar = uj5.a.a;
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("scene", scene);
                Unit unit = Unit.INSTANCE;
                aVar.e("feed_scroll_start", jSONObject);
                j(scene);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(String str, Map map) {
            if (j0.a.b(str) && !f0.e.containsKey(str)) {
                FpsTracer f = r.f(str, null, map);
                f0.e.put(str, f);
                f.start();
                if (DebugManager.isDebugBuild()) {
                    LogWrapper.info("FpsMonitorWrapper", "scene(" + str + ") start fps monitor.", new Object[0]);
                }
            }
        }

        public final void h(final int i, final String scene, final Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            ThreadUtils.runInMain(new Runnable() { // from class: gs4.e0
                @Override // java.lang.Runnable
                public final void run() {
                    f0.a.i(scene, i, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(String str, int i, Map map) {
            if (!j0.a.b(str)) {
                return;
            }
            HashMap hashMap = f0.f;
            Object obj = hashMap.get(str);
            if (obj == null) {
                if (DebugManager.isDebugBuild()) {
                    LogWrapper.info("FpsMonitorWrapper", "scene(" + str + ") start recyclerview fps monitor.", new Object[0]);
                }
                obj = new f0();
                hashMap.put(str, obj);
            }
            ((f0) obj).h(i, str, map);
        }

        public final void g(int i, String scene, String str, String str2) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            HashMap hashMap = new HashMap();
            if (str != null) {
                hashMap.put("main_scene", str);
            }
            if (str2 != null) {
                hashMap.put("sub_scene", str2);
            }
            h(i, scene, hashMap);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void m(a aVar, String str, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            aVar.l(str, map);
        }
    }

    static {
        Covode.recordClassIndex(612322);
        c = new a(null);
        d = 8;
        e = new HashMap<>();
        f = new HashMap<>();
    }

    public final void e() {
        boolean z;
        String str = this.b;
        if (str != null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                r.a.i("feed_" + str);
            }
        }
    }

    private final void f(int i, String str) {
        if (i == 0) {
            fk5.d.a.update(0);
            uj5.a aVar = uj5.a.a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("scene", str);
            Unit unit = Unit.INSTANCE;
            aVar.e("feed_scroll_finish", jSONObject);
            return;
        }
        if (fk5.d.a.update(1)) {
            uj5.a aVar2 = uj5.a.a;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("scene", str);
            Unit unit2 = Unit.INSTANCE;
            aVar2.e("feed_scroll_start", jSONObject2);
            c.j(str);
        }
    }

    public final void h(int i, String categoryName, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        this.b = categoryName;
        f(i, categoryName);
        if (!TextUtils.isEmpty(categoryName) && j0.a.b(categoryName)) {
            if (i == 0) {
                FpsTracer fpsTracer = this.a;
                if (fpsTracer != null) {
                    fpsTracer.stop();
                }
                this.a = null;
                return;
            }
            FpsTracer fpsTracer2 = this.a;
            if (fpsTracer2 != null) {
                if (map != null) {
                    r rVar = r.a;
                    Intrinsics.checkNotNull(fpsTracer2);
                    rVar.j(fpsTracer2, "feed_" + categoryName, map);
                    if (DebugManager.isDebugBuild()) {
                        LogWrapper.info("FpsMonitorWrapper", "scene(" + categoryName + ") updateExtras called.", new Object[0]);
                        return;
                    }
                    return;
                }
                return;
            }
            FpsTracer f2 = r.f("feed_" + categoryName, null, map);
            this.a = f2;
            if (f2 != null) {
                f2.start();
            }
        }
    }

    public final void g(int i, String categoryName, String str, String str2) {
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("main_scene", str);
        }
        if (str2 != null) {
            hashMap.put("sub_scene", str2);
        }
        h(i, categoryName, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(f0 f0Var, int i, String str, Map map, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            map = null;
        }
        f0Var.h(i, str, map);
    }
}
