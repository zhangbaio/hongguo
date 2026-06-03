package mq4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m extends lq4.c<Integer> {
    public static final int h;
    private final AtomicInteger g;

    static {
        Covode.recordClassIndex(611299);
        h = 8;
    }

    @Override // lq4.c
    public String e() {
        return "每隔N次询问生效一次";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public String toString() {
        String jSONObject = new JSONObject().put("n", ((Number) this.a).intValue()).put("current", this.g.get()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return jSONObject;
    }

    public m(int i) {
        super(Integer.valueOf(i));
        this.g = new AtomicInteger(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public Boolean f(String str) {
        if (this.d) {
            return null;
        }
        if (((Number) this.a).intValue() <= 0) {
            LogWrapper.error("LFC.Rule.PulseGap", "ignored: /" + ((Number) this.a).intValue(), new Object[0]);
            return null;
        }
        AtomicInteger atomicInteger = this.g;
        int andSet = atomicInteger.getAndSet((atomicInteger.get() + 1) % ((Number) this.a).intValue());
        if (andSet % ((Number) this.a).intValue() != 0) {
            LogWrapper.warn("LFC.Rule.PulseGap", "intercepted: " + andSet + '/' + ((Number) this.a).intValue(), new Object[0]);
            this.b = '(' + andSet + " % " + ((Number) this.a).intValue() + " = " + (andSet % ((Number) this.a).intValue()) + ") is not ZERO";
            return Boolean.TRUE;
        }
        LogWrapper.debug("LFC.Rule.PulseGap", "accepted: " + andSet + '/' + ((Number) this.a).intValue(), new Object[0]);
        this.b = null;
        return null;
    }
}
