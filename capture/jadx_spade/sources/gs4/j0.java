package gs4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.template.CpuReportConfig;
import com.dragon.read.base.ssconfig.template.FpsReportConfig;
import com.dragon.read.util.DebugManager;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j0 {
    public static final j0 a;
    private static ArrayList<String> b;
    private static ArrayList<String> c;
    private static ArrayList<String> d;
    private static ArrayList<String> e;
    public static final int f;

    private j0() {
    }

    static {
        Covode.recordClassIndex(612331);
        j0 j0Var = new j0();
        a = j0Var;
        b = new ArrayList<>();
        c = new ArrayList<>();
        d = new ArrayList<>();
        e = new ArrayList<>();
        j0Var.d();
        f = 8;
    }

    private final void d() {
        ArrayList<String> arrayList = b;
        FpsReportConfig.a aVar = FpsReportConfig.a;
        arrayList.addAll(aVar.a().whiteList);
        d.addAll(CpuReportConfig.a.a().whiteList);
        for (Map.Entry entry : aVar.a().samplingList.entrySet()) {
            String str = (String) entry.getKey();
            if (a.c(((Number) entry.getValue()).intValue())) {
                c.add(str);
            }
        }
        for (Map.Entry entry2 : CpuReportConfig.a.a().samplingList.entrySet()) {
            String str2 = (String) entry2.getKey();
            if (a.c(((Number) entry2.getValue()).intValue())) {
                e.add(str2);
            }
        }
    }

    private final boolean c(int i) {
        boolean z;
        int random;
        if (i >= 0 && i < 101) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        random = RangesKt___RangesKt.random(new IntRange(0, 99), Random.Default);
        if (random < i) {
            return true;
        }
        return false;
    }

    public final boolean a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!d.contains(key) && !e.contains(key)) {
            return false;
        }
        return true;
    }

    public final boolean b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (DebugManager.isDebugBuild() || b.contains(key) || c.contains(key)) {
            return true;
        }
        return false;
    }
}
