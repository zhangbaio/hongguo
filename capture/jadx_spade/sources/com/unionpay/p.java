package com.unionpay;

import com.bytedance.covode.number.Covode;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class p implements f {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654877);
    }

    p(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // com.unionpay.f
    public final void a(String str, g gVar) {
        String l;
        String l2;
        String m;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                if (gVar != null) {
                    l2 = UPPayWapActivity.l("1", "Parameter error", null);
                    gVar.a(l2);
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            while (true) {
                String str2 = "0";
                if (i >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("packageName");
                if (com.unionpay.utils.b.i(this.a, string, jSONObject2.getString("packageSign"), jSONObject2.getString("supportVersion"))) {
                    str2 = "1";
                }
                jSONObject.put(string, str2);
                i++;
            }
            if (gVar != null) {
                m = UPPayWapActivity.m("0", "success", jSONObject);
                gVar.a(m);
            }
        } catch (Exception e) {
            if (gVar != null) {
                l = UPPayWapActivity.l("1", e.getMessage(), null);
                gVar.a(l);
            }
        }
    }
}
