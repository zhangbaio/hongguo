package com.ss.videoarch.strategy.featureCenter.featureType;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d extends a {
    private static volatile d d;
    public JSONObject c = null;

    static {
        Covode.recordClassIndex(653138);
        d = null;
    }

    private d() {
        this.a = "TypePushFeature";
        mj6.b bVar = this.b;
        if (bVar != null) {
            bVar.a = "TypePushFeature";
        }
    }

    public static d e() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    public <T> T d(String str, T t) {
        if (this.c != null) {
            str.hashCode();
            if (!str.equals("stream_session_vv_id")) {
                if (str.equals("neptuneName")) {
                    if (t.getClass() == String.class && this.c.has("neptuneName")) {
                        return (T) this.c.optString("neptuneName");
                    }
                }
            }
            if (t.getClass() == String.class && this.c.has("stream_session_vv_id")) {
                return (T) this.c.optString("stream_session_vv_id");
            }
        }
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[Catch: JSONException -> 0x003f, TryCatch #0 {JSONException -> 0x003f, blocks: (B:6:0x000e, B:14:0x0026, B:16:0x002a, B:18:0x0030, B:20:0x003a, B:22:0x0018), top: B:5:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject c(org.json.JSONObject r4, org.json.JSONArray r5, java.lang.String r6, java.lang.String r7, org.json.JSONObject r8) {
        /*
            r3 = this;
            java.lang.String r6 = "neptuneName"
            r7 = 0
            r8 = 0
        L4:
            int r0 = r5.length()
            if (r8 >= r0) goto L46
            java.lang.String r0 = r5.optString(r8)
            int r1 = r0.hashCode()     // Catch: org.json.JSONException -> L3f
            r2 = 927307017(0x37459509, float:1.1776815E-5)
            if (r1 == r2) goto L18
            goto L22
        L18:
            java.lang.String r1 = "PUSH-neptuneName"
            boolean r1 = r0.equals(r1)     // Catch: org.json.JSONException -> L3f
            if (r1 == 0) goto L22
            r1 = 0
            goto L23
        L22:
            r1 = -1
        L23:
            if (r1 == 0) goto L26
            goto L43
        L26:
            org.json.JSONObject r1 = r3.c     // Catch: org.json.JSONException -> L3f
            if (r1 == 0) goto L3a
            boolean r1 = r1.has(r6)     // Catch: org.json.JSONException -> L3f
            if (r1 == 0) goto L3a
            org.json.JSONObject r1 = r3.c     // Catch: org.json.JSONException -> L3f
            org.json.JSONObject r1 = r1.optJSONObject(r6)     // Catch: org.json.JSONException -> L3f
            r4.put(r0, r1)     // Catch: org.json.JSONException -> L3f
            goto L43
        L3a:
            r1 = 0
            r4.put(r0, r1)     // Catch: org.json.JSONException -> L3f
            goto L43
        L3f:
            r0 = move-exception
            r0.printStackTrace()
        L43:
            int r8 = r8 + 1
            goto L4
        L46:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.featureCenter.featureType.d.c(org.json.JSONObject, org.json.JSONArray, java.lang.String, java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }
}
