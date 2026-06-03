package com.unionpay;

import com.bytedance.covode.number.Covode;
import com.unionpay.utils.UPUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class w implements f {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654884);
    }

    w(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // com.unionpay.f
    public final void a(String str, g gVar) {
        String l;
        String l2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                UPUtils.g(this.a, jSONObject.getString(next), next);
            }
            if (gVar != null) {
                l2 = UPPayWapActivity.l("0", "success", null);
                gVar.a(l2);
            }
        } catch (Exception e) {
            if (gVar != null) {
                l = UPPayWapActivity.l("1", e.getMessage(), null);
                gVar.a(l);
            }
        }
    }
}
