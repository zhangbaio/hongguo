package com.ss.videoarch.strategy.dataCenter.strategyData.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    public String a = "none";
    public String b = "none";
    public String c = "none";
    public int d = 300000;
    public String e = "";
    public String f = "";

    static {
        Covode.recordClassIndex(653131);
    }

    public String a() {
        String str = this.c;
        if (str != null && !TextUtils.isEmpty(str) && !this.c.equals("none")) {
            String[] split = this.c.split(",");
            if (split.length > 0) {
                return split[0];
            }
            return null;
        }
        return null;
    }

    public String toString() {
        return "domain: " + this.a + ",network:" + this.b + ",ips:" + this.c + ",ttl:" + this.d + ",update_time:" + this.e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a6, code lost:
    
        if (r12 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x009d, code lost:
    
        if (r12 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x00ab, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00a8, code lost:
    
        r12.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject b(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r1 = 2
            java.lang.String[] r3 = new java.lang.String[r1]
            java.lang.String r2 = nj6.d.d
            r9 = 0
            r3[r9] = r2
            java.lang.String r2 = "update_time"
            r10 = 1
            r3[r10] = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = nj6.d.b
            r2.append(r4)
            java.lang.String r4 = " = ? and "
            r2.append(r4)
            java.lang.String r4 = nj6.d.c
            r2.append(r4)
            java.lang.String r4 = " = ? "
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            java.lang.String[] r5 = new java.lang.String[r1]
            r5[r9] = r12
            java.lang.String r12 = java.lang.String.valueOf(r13)
            r5[r10] = r12
            java.lang.String r2 = nj6.d.a
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r12 = nj6.a.query(r2, r3, r4, r5, r6, r7, r8)
            java.lang.String r13 = "reason"
            java.lang.String r1 = "code"
            r2 = -1
            if (r12 == 0) goto L96
            int r3 = r12.getCount()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            if (r3 == 0) goto L96
            r3 = -1
        L50:
            boolean r4 = r12.moveToNext()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            if (r4 == 0) goto L97
            java.lang.String r3 = r12.getString(r9)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r11.c = r3     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            java.lang.String r3 = r12.getString(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r11.e = r3     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            java.lang.String r4 = nj6.a.c()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            long r3 = nj6.a.a(r3, r4)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            lj6.a r5 = lj6.a.m()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            mj6.c r5 = r5.s     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            int r5 = r5.d     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            long r5 = (long) r5     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L7d
            java.lang.String r3 = r11.a()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r4 = 0
            goto L7f
        L7d:
            r3 = 0
            r4 = 1
        L7f:
            if (r3 == 0) goto L90
            java.lang.String r2 = "Ip"
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r0.put(r13, r4)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r12.close()
            return r0
        L90:
            r3 = r4
            goto L50
        L92:
            r13 = move-exception
            goto La0
        L94:
            goto La6
        L96:
            r3 = -1
        L97:
            r0.put(r1, r2)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r0.put(r13, r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            if (r12 == 0) goto Lab
            goto La8
        La0:
            if (r12 == 0) goto La5
            r12.close()
        La5:
            throw r13
        La6:
            if (r12 == 0) goto Lab
        La8:
            r12.close()
        Lab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.dataCenter.strategyData.model.b.b(java.lang.String, java.lang.String):org.json.JSONObject");
    }
}
