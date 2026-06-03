package com.unionpay;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class q implements f {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654878);
    }

    q(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @Override // com.unionpay.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r13, com.unionpay.g r14) {
        /*
            r12 = this;
            java.lang.String r0 = "extra"
            java.lang.String r1 = "1"
            r2 = 0
            com.unionpay.UPPayWapActivity r3 = r12.a     // Catch: java.lang.Exception -> Lcb
            com.unionpay.UPPayWapActivity.d(r3, r14)     // Catch: java.lang.Exception -> Lcb
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> Lcb
            r3.<init>(r13)     // Catch: java.lang.Exception -> Lcb
            java.lang.String r13 = "packageName"
            java.lang.String r13 = r3.getString(r13)     // Catch: java.lang.Exception -> Lcb
            java.lang.String r4 = "type"
            java.lang.String r4 = r3.getString(r4)     // Catch: java.lang.Exception -> Lcb
            java.lang.String r5 = "openParams"
            java.lang.String r5 = r3.optString(r5)     // Catch: java.lang.Exception -> Lcb
            java.lang.String r6 = "tn"
            java.lang.String r6 = r3.optString(r6)     // Catch: java.lang.Exception -> Lcb
            java.lang.String r3 = r3.optString(r0)     // Catch: java.lang.Exception -> Lcb
            java.lang.String r7 = "0"
            boolean r7 = r7.equals(r4)     // Catch: java.lang.Exception -> Lcb
            java.lang.String r8 = "Call application error"
            r9 = 1
            java.lang.String r10 = "Parameter error"
            java.lang.String r11 = "2"
            if (r7 == 0) goto L80
            boolean r4 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Exception -> Lcb
            if (r4 != 0) goto L76
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> Lcb
            if (r4 != 0) goto L76
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Exception -> Lcb
            r4.<init>()     // Catch: java.lang.Exception -> Lcb
            java.lang.String r5 = "com.unionpay.uppay.PayActivity"
            r4.setClassName(r13, r5)     // Catch: java.lang.Exception -> Lcb
            java.lang.String r13 = "paydata"
            r4.putExtra(r13, r6)     // Catch: java.lang.Exception -> Lcb
            java.lang.String r13 = com.unionpay.UPPayWapActivity.e()     // Catch: java.lang.Exception -> Lcb
            com.unionpay.UPPayWapActivity r5 = r12.a     // Catch: java.lang.Exception -> Lcb
            java.lang.String r5 = com.unionpay.UPPayWapActivity.n(r5)     // Catch: java.lang.Exception -> Lcb
            r4.putExtra(r13, r5)     // Catch: java.lang.Exception -> Lcb
            r4.putExtra(r0, r3)     // Catch: java.lang.Exception -> Lcb
            com.unionpay.UPPayWapActivity r13 = r12.a     // Catch: java.lang.Exception -> L6b
            r13.startActivityForResult(r4, r9)     // Catch: java.lang.Exception -> L6b
            return
        L6b:
            if (r14 == 0) goto L75
            java.lang.String r13 = com.unionpay.UPPayWapActivity.f(r11, r8, r2)     // Catch: java.lang.Exception -> Lcb
            r14.a(r13)     // Catch: java.lang.Exception -> Lcb
        L75:
            return
        L76:
            if (r14 == 0) goto Lca
            java.lang.String r13 = com.unionpay.UPPayWapActivity.f(r1, r10, r2)     // Catch: java.lang.Exception -> Lcb
            r14.a(r13)     // Catch: java.lang.Exception -> Lcb
            return
        L80:
            boolean r4 = r11.equals(r4)     // Catch: java.lang.Exception -> Lcb
            if (r4 == 0) goto Lc1
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> Lcb
            if (r4 != 0) goto Lb7
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Exception -> Lcb
            java.lang.String r6 = "android.intent.action.VIEW"
            r4.<init>(r6)     // Catch: java.lang.Exception -> Lcb
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch: java.lang.Exception -> Lcb
            r4.setData(r5)     // Catch: java.lang.Exception -> Lcb
            r4.putExtra(r0, r3)     // Catch: java.lang.Exception -> Lcb
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Exception -> Lcb
            if (r0 != 0) goto La6
            r4.setPackage(r13)     // Catch: java.lang.Exception -> Lcb
        La6:
            com.unionpay.UPPayWapActivity r13 = r12.a     // Catch: java.lang.Exception -> Lac
            r13.startActivityForResult(r4, r9)     // Catch: java.lang.Exception -> Lac
            return
        Lac:
            if (r14 == 0) goto Lb6
            java.lang.String r13 = com.unionpay.UPPayWapActivity.f(r11, r8, r2)     // Catch: java.lang.Exception -> Lcb
            r14.a(r13)     // Catch: java.lang.Exception -> Lcb
        Lb6:
            return
        Lb7:
            if (r14 == 0) goto Lca
            java.lang.String r13 = com.unionpay.UPPayWapActivity.f(r1, r10, r2)     // Catch: java.lang.Exception -> Lcb
            r14.a(r13)     // Catch: java.lang.Exception -> Lcb
            return
        Lc1:
            if (r14 == 0) goto Lca
            java.lang.String r13 = com.unionpay.UPPayWapActivity.f(r1, r10, r2)     // Catch: java.lang.Exception -> Lcb
            r14.a(r13)     // Catch: java.lang.Exception -> Lcb
        Lca:
            return
        Lcb:
            r13 = move-exception
            if (r14 == 0) goto Ld9
            java.lang.String r13 = r13.getMessage()
            java.lang.String r13 = com.unionpay.UPPayWapActivity.f(r1, r13, r2)
            r14.a(r13)
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.q.a(java.lang.String, com.unionpay.g):void");
    }
}
