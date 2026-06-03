package com.unionpay;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class r implements f {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654879);
    }

    r(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    @Override // com.unionpay.f
    public final void a(String str, g gVar) {
        String l;
        String l2;
        String l3;
        try {
            this.a.h = gVar;
            String optString = new JSONObject(str).optString("scheme");
            if (TextUtils.isEmpty(optString)) {
                if (gVar != null) {
                    l2 = UPPayWapActivity.l("1", "Parameter error", null);
                    gVar.a(l2);
                    return;
                }
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(optString));
            try {
                this.a.startActivity(intent);
            } catch (Exception unused) {
                if (gVar != null) {
                    l3 = UPPayWapActivity.l("2", "Call application error", null);
                    gVar.a(l3);
                }
            }
        } catch (Exception e) {
            if (gVar != null) {
                l = UPPayWapActivity.l("1", e.getMessage(), null);
                gVar.a(l);
            }
        }
    }
}
