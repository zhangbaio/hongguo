package mq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f extends lq4.c<Long> {
    public static final int h;
    private volatile long g;

    static {
        Covode.recordClassIndex(611295);
        h = 8;
    }

    @Override // lq4.c
    public String e() {
        return "两次生效最小间隔秒数";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public String toString() {
        String jSONObject = new JSONObject().put("seconds", ((Number) this.a).longValue()).put("current", Math.abs(System.currentTimeMillis() - this.g) / 1000).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return jSONObject;
    }

    @Override // lq4.c
    public void i(String str) {
        this.g = System.currentTimeMillis();
        k(this.g);
    }

    private final void k(long j) {
        d().edit().putLong("last_show_time", j).apply();
    }

    @Override // lq4.c
    public void g(boolean z) {
        if (this.g != 0) {
            LogWrapper.info("LFC.Rule.MinTimeInterval", "lastShowTime use: " + this.g, new Object[0]);
            k(this.g);
            return;
        }
        this.g = d().getLong("last_show_time", 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public Boolean f(String str) {
        if (this.d) {
            return null;
        }
        long abs = Math.abs(System.currentTimeMillis() - this.g);
        long longValue = ((Number) this.a).longValue() * 1000;
        if (abs <= longValue) {
            LogWrapper.warn("LFC.Rule.MinTimeInterval", "intercepted: " + abs + '/' + longValue, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(abs);
            sb.append(" <= ");
            sb.append(longValue);
            this.b = sb.toString();
            return Boolean.TRUE;
        }
        this.b = null;
        LogWrapper.debug("LFC.Rule.MinTimeInterval", "accepted: " + abs + '/' + longValue, new Object[0]);
        return null;
    }

    public f(long j, long j2) {
        super(Long.valueOf(j));
        if (j2 > 0) {
            int i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
            this.g = System.currentTimeMillis() + ((j2 - j) * 1000);
        }
    }

    public /* synthetic */ f(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }
}
