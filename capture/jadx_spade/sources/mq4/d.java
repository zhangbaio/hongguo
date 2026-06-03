package mq4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends lq4.c<Integer> {
    public static final int g;

    static {
        Covode.recordClassIndex(611292);
        g = 8;
    }

    @Override // lq4.c
    public String e() {
        return "最多点击次数";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public String toString() {
        String jSONObject = new JSONObject().put("_current_", d().getInt("click_cnt", 0)).put("max_cnt", ((Number) this.a).intValue()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return jSONObject;
    }

    public d(int i) {
        super(Integer.valueOf(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // lq4.c
    public Boolean f(String str) {
        if (this.d || d().getInt("click_cnt", 0) < ((Number) this.a).intValue()) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // lq4.c
    public void h(String str) {
        int i = d().getInt("click_cnt", 0);
        SharedPreferences.Editor edit = d().edit();
        edit.putInt("click_cnt", i + 1);
        edit.apply();
    }
}
