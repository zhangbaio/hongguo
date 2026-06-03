package gs4;

import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.AppLifecycleMonitor;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.report.ReportManager;
import com.dragon.read.util.DebugManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final f a;
    private static final ExecutorService b;
    private static final ConcurrentHashMap<String, a> c;
    public static final int d;

    private f() {
    }

    private final a g() {
        return new a(0L, 0L, 0L, false, null, 31, null);
    }

    static {
        Covode.recordClassIndex(612313);
        a = new f();
        b = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("CpuMonitorWrapper"), "com.dragon.read.monitor.CpuMonitorWrapper");
        c = new ConcurrentHashMap<>();
        d = 8;
    }

    private final a h(Map<String, ? extends Object> map) {
        int cpuCoreNum = CommonMonitorUtil.getCpuCoreNum();
        if (cpuCoreNum <= 0) {
            return null;
        }
        return new a(System.currentTimeMillis(), CommonMonitorUtil.getAppCPUTime(), com.bytedance.monitor.collector.j.o().l(cpuCoreNum), NsCommonDepend.IMPL.audioPlayManager().isCurrentPlayerPlaying(), map);
    }

    public static final void j(final String scene, final Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        ThreadUtils.runInMain(new Runnable() { // from class: gs4.b
            @Override // java.lang.Runnable
            public final void run() {
                f.l(scene, map);
            }
        });
    }

    public static final void n(final String scene, final Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        ThreadUtils.runInMain(new Runnable() { // from class: gs4.c
            @Override // java.lang.Runnable
            public final void run() {
                f.p(scene, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final String str, final Map map) {
        if (!c.containsKey(str)) {
            return;
        }
        b.submit(new Runnable() { // from class: gs4.e
            @Override // java.lang.Runnable
            public final void run() {
                f.q(str, map);
            }
        });
    }

    private final Map<String, Object> f(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        if (map == null) {
            return map2;
        }
        if (map2 == null) {
            return map;
        }
        HashMap hashMap = new HashMap(map2);
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final String str, final Map map) {
        if (j0.a.a(str)) {
            ConcurrentHashMap<String, a> concurrentHashMap = c;
            if (!concurrentHashMap.containsKey(str)) {
                concurrentHashMap.put(str, a.g());
                b.submit(new Runnable() { // from class: gs4.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.m(map, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Map map, String str) {
        a h = a.h(map);
        if (h != null) {
            c.replace(str, h);
            if (DebugManager.isDebugBuild()) {
                LogWrapper.info("CpuMonitorWrapper", "scene(" + str + ") real start and finish read cpu info.", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String str, Map map) {
        f fVar;
        a i;
        boolean z;
        a remove = c.remove(str);
        if (remove != null && remove.a >= 0 && (i = i((fVar = a), null, 1, null)) != null) {
            double a2 = remove.a(i);
            double b2 = remove.b(i);
            if (!remove.d && !i.d) {
                z = false;
            } else {
                z = true;
            }
            Map<String, Object> f = fVar.f(remove.e, map);
            fVar.e(str, a2, b2, z, f);
            if (DebugManager.isDebugBuild()) {
                LogWrapper.info("CpuMonitorWrapper", "scene(" + str + ") stop, cpuRate:" + a2 + ", cpuSpeed:" + b2 + " audioPlaying:" + z + " extras:" + f, new Object[0]);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ a i(f fVar, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        return fVar.h(map);
    }

    public static /* synthetic */ void k(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        j(str, map);
    }

    public static /* synthetic */ void o(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        n(str, map);
    }

    private final void e(String str, double d2, double d3, boolean z, Map<String, ? extends Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            boolean isForeground = AppLifecycleMonitor.getInstance().isForeground();
            try {
                jSONObject.put("cpu_speed", d3);
                jSONObject.put("cpu_rate", d2);
                jSONObject.put("scene", str);
                jSONObject.put("foreground", isForeground ? 1 : 0);
                jSONObject.put("has_audio_play", z);
                if (map != null) {
                    for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ReportManager.onReport("scene_cpu_data", jSONObject);
        } catch (Exception e2) {
            LogWrapper.error("CpuMonitorWrapper", "%s", new Object[]{e2.getMessage()});
        }
    }
}
