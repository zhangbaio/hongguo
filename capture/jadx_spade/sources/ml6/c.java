package ml6;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    public static final c a;

    private c() {
    }

    static {
        Covode.recordClassIndex(655942);
        a = new c();
    }

    public final void b(String str, String str2, String str3, int i, int i2, String str4, String str5, boolean z) {
        ik6.a aVar;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("origin_url", str);
            jSONObject.putOpt("real_play_url", str2);
            jSONObject.putOpt("scene", str3);
            jSONObject.putOpt("play_stage", str4);
            jSONObject.putOpt("intercept_tip_name", str5);
            jSONObject.putOpt("play_type", Integer.valueOf(i));
            jSONObject.putOpt("is_old_tip_player", Boolean.valueOf(z));
            jSONObject.putOpt("vm_index", Integer.valueOf(i2));
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (aVar = bVar.f) != null) {
                aVar.onEvent("v3_tip_play_start", jSONObject);
            }
        } catch (Exception unused) {
        }
    }

    public final void a(String str, String str2, String str3, int i, int i2, String str4, String str5, boolean z, int i3, String str6, String str7) {
        ik6.a aVar;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("origin_url", str);
            jSONObject.putOpt("real_play_url", str2);
            jSONObject.putOpt("scene", str3);
            jSONObject.putOpt("play_stage", str4);
            jSONObject.putOpt("intercept_tip_name", str5);
            jSONObject.putOpt("play_type", Integer.valueOf(i));
            jSONObject.putOpt("is_old_tip_player", Boolean.valueOf(z));
            jSONObject.putOpt("vm_index", Integer.valueOf(i2));
            jSONObject.putOpt("error_code", Integer.valueOf(i3));
            jSONObject.putOpt("error_msg", str6);
            jSONObject.putOpt("error_type", str7);
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (aVar = bVar.f) != null) {
                aVar.onEvent("v3_tip_play_error", jSONObject);
            }
        } catch (Exception unused) {
        }
    }
}
