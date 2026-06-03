package vs4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.rpc.model.ResearchSceneType;
import com.dragon.read.rpc.model.UserResearchData;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r {
    public static final r a;
    private static final String b;
    private static WeakReference<Context> c;
    private static UserResearchData d;
    private static ResearchSceneType e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static int k;
    private static boolean l;
    private static boolean m;
    public static final int n;

    private r() {
    }

    public final void l() {
        m = true;
    }

    public final void w() {
        m = false;
    }

    public final String b() {
        return h;
    }

    public final String c() {
        return i;
    }

    public final int d() {
        return k;
    }

    public final UserResearchData e() {
        return d;
    }

    public final String f() {
        return j;
    }

    public final String g() {
        return f;
    }

    public final String h() {
        return g;
    }

    public final boolean i() {
        return l;
    }

    public final WeakReference<Context> j() {
        return c;
    }

    static {
        Covode.recordClassIndex(612552);
        a = new r();
        b = "NPS_GLOBAL | READER_NPS_DATA_CACHER";
        k = -1;
        n = 8;
    }

    public final void a() {
        if (m) {
            LogWrapper.info(b, "Lock状态暂不清除数据", new Object[0]);
            return;
        }
        LogWrapper.info(b, "NpsDataCacher 清空缓存", new Object[0]);
        c = null;
        d = null;
        f = null;
        g = null;
        l = false;
        e = null;
        h = null;
        i = null;
        j = null;
        k = -1;
    }

    public final void m(String str) {
        h = str;
    }

    public final void n(String str) {
        i = str;
    }

    public final void o(int i2) {
        k = i2;
    }

    public final void p(UserResearchData userResearchData) {
        d = userResearchData;
    }

    public final void q(String str) {
        j = str;
    }

    public final void r(String str) {
        f = str;
    }

    public final void s(String str) {
        g = str;
    }

    public final void t(boolean z) {
        l = z;
    }

    public final void u(ResearchSceneType researchSceneType) {
        e = researchSceneType;
    }

    public final void v(WeakReference<Context> weakReference) {
        c = weakReference;
    }

    public final boolean k(ResearchSceneType scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (d != null && e == scene) {
            return true;
        }
        return false;
    }
}
