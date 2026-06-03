package com.unionpay;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class m implements f {
    final /* synthetic */ UPPayWapActivity a;

    static {
        Covode.recordClassIndex(654874);
    }

    m(UPPayWapActivity uPPayWapActivity) {
        this.a = uPPayWapActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034 A[Catch: Exception -> 0x0040, TRY_LEAVE, TryCatch #0 {Exception -> 0x0040, blocks: (B:3:0x0005, B:10:0x002d, B:12:0x0034, B:20:0x0022), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // com.unionpay.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r6, com.unionpay.g r7) {
        /*
            r5 = this;
            java.lang.String r0 = "1"
            java.lang.String r1 = ""
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L40
            r3.<init>(r6)     // Catch: java.lang.Exception -> L40
            java.lang.String r6 = "resultCode"
            java.lang.Object r6 = r3.get(r6)     // Catch: java.lang.Exception -> L1e
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L1e
            java.lang.String r4 = "resultData"
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Exception -> L1c
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> L1c
            r1 = r3
            goto L2d
        L1c:
            r3 = move-exception
            goto L20
        L1e:
            r3 = move-exception
            r6 = r1
        L20:
            if (r7 == 0) goto L2d
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Exception -> L40
            java.lang.String r3 = com.unionpay.UPPayWapActivity.f(r0, r3, r2)     // Catch: java.lang.Exception -> L40
            r7.a(r3)     // Catch: java.lang.Exception -> L40
        L2d:
            com.unionpay.UPPayWapActivity r3 = r5.a     // Catch: java.lang.Exception -> L40
            com.unionpay.UPPayWapActivity.h(r3, r6, r1)     // Catch: java.lang.Exception -> L40
            if (r7 == 0) goto L3f
            java.lang.String r6 = "0"
            java.lang.String r1 = "success"
            java.lang.String r6 = com.unionpay.UPPayWapActivity.f(r6, r1, r2)     // Catch: java.lang.Exception -> L40
            r7.a(r6)     // Catch: java.lang.Exception -> L40
        L3f:
            return
        L40:
            r6 = move-exception
            if (r7 == 0) goto L4e
            java.lang.String r6 = r6.getMessage()
            java.lang.String r6 = com.unionpay.UPPayWapActivity.f(r0, r6, r2)
            r7.a(r6)
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.m.a(java.lang.String, com.unionpay.g):void");
    }
}
