package mq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends lq4.c<Integer> {
    public static final int g;

    static {
        Covode.recordClassIndex(611289);
        g = 8;
    }

    @Override // lq4.c
    public String e() {
        return "当天前N次启动不生效";
    }

    private final int k() {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(NsCommonDepend.IMPL.attributionManager().getTodayColdStartCount(), 1);
        return coerceAtLeast;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public String toString() {
        String jSONObject = new JSONObject().put("n", ((Number) this.a).intValue()).put("_current_", k()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return jSONObject;
    }

    public a(int i) {
        super(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public Boolean f(String str) {
        if (this.d) {
            return null;
        }
        int k = k();
        if (k <= ((Number) this.a).intValue()) {
            LogWrapper.warn("LFC.Rule.NthLaunchToday", "intercepted: " + k + '/' + ((Number) this.a).intValue(), new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(k);
            sb.append(" <= ");
            sb.append(((Number) this.a).intValue());
            this.b = sb.toString();
            return Boolean.TRUE;
        }
        this.b = null;
        LogWrapper.debug("LFC.Rule.NthLaunchToday", "accepted: " + k + '/' + ((Number) this.a).intValue(), new Object[0]);
        return null;
    }
}
