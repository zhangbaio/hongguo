package nq4;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.util.kotlin.StringKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int d;
    private final SharedPreferences a;
    private final boolean b;
    public volatile JSONObject c;

    static {
        Covode.recordClassIndex(611300);
        d = 8;
    }

    public final int a() {
        return b().optInt("all", 0);
    }

    public final JSONObject b() {
        JSONObject jSONObject = this.c;
        if (jSONObject != null) {
            return jSONObject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cntJson");
        return null;
    }

    public final void h(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.c = jSONObject;
    }

    public final int c(String str) {
        return b().optInt('_' + str, 0);
    }

    public final void d(boolean z) {
        JSONObject parseJSONObjectNonNull;
        if (z) {
            parseJSONObjectNonNull = new JSONObject();
        } else {
            parseJSONObjectNonNull = JSONUtils.parseJSONObjectNonNull(this.a.getString("record_cnt", null));
            Intrinsics.checkNotNull(parseJSONObjectNonNull);
        }
        h(parseJSONObjectNonNull);
    }

    public final void i(JSONObject jSONObject) {
        if (jSONObject != null) {
            h(jSONObject);
        }
        this.a.edit().putString("record_cnt", b().toString()).apply();
    }

    public final void e(String str) {
        boolean z;
        int optInt;
        int optInt2 = b().optInt("all", 0) + 1;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            optInt = optInt2;
        } else {
            optInt = b().optInt('_' + str, 0) + 1;
        }
        k(str, optInt2, optInt);
    }

    public a(SharedPreferences sp, boolean z) {
        Intrinsics.checkNotNullParameter(sp, "sp");
        this.a = sp;
        this.b = z;
    }

    public final void f(String str, int i) {
        boolean z;
        int coerceAtLeast;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            coerceAtLeast = i;
        } else {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((b().optInt("all", 0) - b().optInt('_' + str, 0)) + i, 0);
        }
        k(str, coerceAtLeast, i);
    }

    private final void k(String str, int i, int i2) {
        b().put("all", i);
        if (StringKt.isNotNullOrEmpty(str)) {
            b().put('_' + str, i2);
        }
        if (!this.b) {
            return;
        }
        j(this, null, 1, null);
    }

    public static /* synthetic */ void j(a aVar, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = null;
        }
        aVar.i(jSONObject);
    }

    public static /* synthetic */ void g(a aVar, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        aVar.f(str, i);
    }
}
