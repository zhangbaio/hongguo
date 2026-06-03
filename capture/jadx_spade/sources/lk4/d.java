package lk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.goldcoinbox.pendant.audio.GoldCoinBoxFMManager;
import com.dragon.read.goldcoinbox.pendant.video.PolarisVideoPendantMgr;
import com.dragon.read.polaris.video.l3;
import ix4.d5;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import pg1.e;
import sy4.p1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements e {
    static {
        Covode.recordClassIndex(607900);
    }

    public Map<String, String> getDaoliangTaskData() {
        return null;
    }

    public Map<String, String> getSevenTaskData() {
        Map<String, ? extends Object> a;
        af1.a m = p1.a.m();
        if (m != null && (a = m.a()) != null) {
            return z0(a);
        }
        return null;
    }

    public Map<String, String> getReadingTaskData() {
        Map<String, ? extends Object> a;
        p1 p1Var = p1.a;
        List X1 = d5.X2().X1();
        Intrinsics.checkNotNullExpressionValue(X1, "getMergeOrDailyReadTask(...)");
        af1.a n = p1Var.n(X1, d5.X2().Y1().longValue() / 1000);
        if (n != null && (a = n.a()) != null) {
            return z0(a);
        }
        return null;
    }

    public Map<String, String> getRedPackSplitTaskData() {
        Map<String, ? extends Object> map;
        af1.a l = p1.a.l();
        if (l != null) {
            map = l.a();
        } else {
            map = null;
        }
        if (map != null) {
            map.put("leave_red_packet", Boolean.valueOf(PolarisVideoPendantMgr.a.e1()));
        }
        if (map == null) {
            return null;
        }
        return z0(map);
    }

    public Map<String, String> getListeningTaskData() {
        Map<String, ? extends Object> map;
        if (j74.a.a.n()) {
            map = p1.a.h().a();
        } else {
            p1 p1Var = p1.a;
            List c2 = d5.X2().c2();
            Intrinsics.checkNotNullExpressionValue(c2, "getMergeOrListenTask(...)");
            af1.a n = p1Var.n(c2, d5.X2().W1().longValue() / 1000);
            if (n != null) {
                map = n.a();
            } else {
                map = null;
            }
        }
        if (map != null) {
            map.put("did_enter_save_coin", Boolean.valueOf(GoldCoinBoxFMManager.a.s()));
        }
        if (map == null) {
            return null;
        }
        return z0(map);
    }

    public Map<String, String> getMergeTaskData() {
        Map<String, ? extends Object> a;
        Map<String, ? extends Object> a2;
        if (d5.X2().P()) {
            af1.a j = p1.a.j();
            if (j == null || (a2 = j.a()) == null) {
                return null;
            }
            return z0(a2);
        }
        p1 p1Var = p1.a;
        List X1 = d5.X2().X1();
        Intrinsics.checkNotNullExpressionValue(X1, "getMergeOrDailyReadTask(...)");
        af1.a n = p1Var.n(X1, d5.X2().Y1().longValue() / 1000);
        if (n == null || (a = n.a()) == null) {
            return null;
        }
        return z0(a);
    }

    public Map<String, String> getShortVideoTaskData() {
        Map<String, ? extends Object> a;
        if (!d5.X2().W2("daily_short_video_collect") && !d5.X2().P()) {
            af1.a k = p1.a.k();
            if (k != null) {
                a = k.a();
            }
            a = null;
        } else {
            af1.a g = p1.a.g();
            if (g != null) {
                a = g.a();
            }
            a = null;
        }
        if (a != null) {
            a.put("did_enter_save_coin", Boolean.valueOf(PolarisVideoPendantMgr.a.a1()));
        }
        if (a != null) {
            a.put("is_double_reward_video", Boolean.valueOf(l3.a.I().q));
        }
        if (a != null) {
            a.put("related_album_id", l3.a.I().c);
        }
        if (a == null) {
            return null;
        }
        return z0(a);
    }

    private final Map<String, String> z0(Map<String, ? extends Object> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return linkedHashMap;
    }
}
