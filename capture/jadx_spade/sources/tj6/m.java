package tj6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m {
    public final String a;
    public final JSONObject b;

    static {
        Covode.recordClassIndex(654080);
    }

    public m(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    public /* synthetic */ m(String str, JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "tt_quality" : str, jSONObject);
    }
}
