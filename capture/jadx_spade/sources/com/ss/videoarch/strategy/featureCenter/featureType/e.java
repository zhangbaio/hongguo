package com.ss.videoarch.strategy.featureCenter.featureType;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.dataCenter.strategyData.DataWarehouse;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e extends a {
    private static volatile e f;
    private JSONObject c;
    private JSONObject d;
    private final String e = "UserProfileCollector";

    static {
        Covode.recordClassIndex(653139);
        f = null;
    }

    private e() {
        this.a = "TypeUserProfileFeature";
        mj6.b bVar = this.b;
        if (bVar != null) {
            bVar.a = "TypeUserProfileFeature";
        }
    }

    public static e e() {
        if (f == null) {
            synchronized (e.class) {
                if (f == null) {
                    f = new e();
                }
            }
        }
        return f;
    }

    public void f() {
        String offlineFeatures = DataWarehouse.getOfflineFeatures();
        if (!offlineFeatures.isEmpty()) {
            try {
                this.d = new JSONObject(offlineFeatures);
                return;
            } catch (Exception e) {
                Log.e("UserProfileCollector", "Update Offline Features: " + e.getMessage());
                return;
            }
        }
        Log.i("UserProfileCollector", "Update Offline Features: no offline features!");
    }

    private Number c(String str) {
        Number valueOf;
        try {
            if (str.contains(".")) {
                valueOf = Double.valueOf(Double.parseDouble(str));
            } else {
                valueOf = Integer.valueOf(Integer.parseInt(str));
            }
            return valueOf;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void g(JSONObject jSONObject) {
        this.c = jSONObject;
        if (jSONObject != null && lj6.a.m().s.i == 1) {
            ArrayList arrayList = new ArrayList();
            com.ss.videoarch.strategy.dataCenter.strategyData.model.a aVar = new com.ss.videoarch.strategy.dataCenter.strategyData.model.a();
            aVar.a = "UserProfile";
            aVar.b = this.c.toString();
            arrayList.add(aVar);
            nj6.b.f(arrayList);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x007c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0207 A[Catch: JSONException -> 0x012c, TryCatch #12 {JSONException -> 0x012c, blocks: (B:219:0x0081, B:65:0x014c, B:72:0x0161, B:73:0x0165, B:74:0x016a, B:76:0x016f, B:77:0x0175, B:79:0x017a, B:82:0x0182, B:83:0x0193, B:86:0x019b, B:87:0x01ab, B:90:0x01b2, B:91:0x01c2, B:94:0x01c9, B:95:0x01d9, B:98:0x01e0, B:99:0x01f0, B:102:0x01f7, B:103:0x0207, B:105:0x0216, B:17:0x008d, B:175:0x0099, B:178:0x00a5, B:181:0x00b0, B:184:0x00bb, B:187:0x00c6, B:190:0x00d2, B:193:0x00dd, B:196:0x00e7, B:199:0x00f0, B:202:0x00fa, B:205:0x0104, B:208:0x010f, B:211:0x0119, B:214:0x0122), top: B:218:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x014c A[Catch: JSONException -> 0x012c, TRY_ENTER, TryCatch #12 {JSONException -> 0x012c, blocks: (B:219:0x0081, B:65:0x014c, B:72:0x0161, B:73:0x0165, B:74:0x016a, B:76:0x016f, B:77:0x0175, B:79:0x017a, B:82:0x0182, B:83:0x0193, B:86:0x019b, B:87:0x01ab, B:90:0x01b2, B:91:0x01c2, B:94:0x01c9, B:95:0x01d9, B:98:0x01e0, B:99:0x01f0, B:102:0x01f7, B:103:0x0207, B:105:0x0216, B:17:0x008d, B:175:0x0099, B:178:0x00a5, B:181:0x00b0, B:184:0x00bb, B:187:0x00c6, B:190:0x00d2, B:193:0x00dd, B:196:0x00e7, B:199:0x00f0, B:202:0x00fa, B:205:0x0104, B:208:0x010f, B:211:0x0119, B:214:0x0122), top: B:218:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016a A[Catch: JSONException -> 0x012c, TryCatch #12 {JSONException -> 0x012c, blocks: (B:219:0x0081, B:65:0x014c, B:72:0x0161, B:73:0x0165, B:74:0x016a, B:76:0x016f, B:77:0x0175, B:79:0x017a, B:82:0x0182, B:83:0x0193, B:86:0x019b, B:87:0x01ab, B:90:0x01b2, B:91:0x01c2, B:94:0x01c9, B:95:0x01d9, B:98:0x01e0, B:99:0x01f0, B:102:0x01f7, B:103:0x0207, B:105:0x0216, B:17:0x008d, B:175:0x0099, B:178:0x00a5, B:181:0x00b0, B:184:0x00bb, B:187:0x00c6, B:190:0x00d2, B:193:0x00dd, B:196:0x00e7, B:199:0x00f0, B:202:0x00fa, B:205:0x0104, B:208:0x010f, B:211:0x0119, B:214:0x0122), top: B:218:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017a A[Catch: JSONException -> 0x012c, TryCatch #12 {JSONException -> 0x012c, blocks: (B:219:0x0081, B:65:0x014c, B:72:0x0161, B:73:0x0165, B:74:0x016a, B:76:0x016f, B:77:0x0175, B:79:0x017a, B:82:0x0182, B:83:0x0193, B:86:0x019b, B:87:0x01ab, B:90:0x01b2, B:91:0x01c2, B:94:0x01c9, B:95:0x01d9, B:98:0x01e0, B:99:0x01f0, B:102:0x01f7, B:103:0x0207, B:105:0x0216, B:17:0x008d, B:175:0x0099, B:178:0x00a5, B:181:0x00b0, B:184:0x00bb, B:187:0x00c6, B:190:0x00d2, B:193:0x00dd, B:196:0x00e7, B:199:0x00f0, B:202:0x00fa, B:205:0x0104, B:208:0x010f, B:211:0x0119, B:214:0x0122), top: B:218:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0193 A[Catch: JSONException -> 0x012c, TryCatch #12 {JSONException -> 0x012c, blocks: (B:219:0x0081, B:65:0x014c, B:72:0x0161, B:73:0x0165, B:74:0x016a, B:76:0x016f, B:77:0x0175, B:79:0x017a, B:82:0x0182, B:83:0x0193, B:86:0x019b, B:87:0x01ab, B:90:0x01b2, B:91:0x01c2, B:94:0x01c9, B:95:0x01d9, B:98:0x01e0, B:99:0x01f0, B:102:0x01f7, B:103:0x0207, B:105:0x0216, B:17:0x008d, B:175:0x0099, B:178:0x00a5, B:181:0x00b0, B:184:0x00bb, B:187:0x00c6, B:190:0x00d2, B:193:0x00dd, B:196:0x00e7, B:199:0x00f0, B:202:0x00fa, B:205:0x0104, B:208:0x010f, B:211:0x0119, B:214:0x0122), top: B:218:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ab A[Catch: JSONException -> 0x012c, TryCatch #12 {JSONException -> 0x012c, blocks: (B:219:0x0081, B:65:0x014c, B:72:0x0161, B:73:0x0165, B:74:0x016a, B:76:0x016f, B:77:0x0175, B:79:0x017a, B:82:0x0182, B:83:0x0193, B:86:0x019b, B:87:0x01ab, B:90:0x01b2, B:91:0x01c2, B:94:0x01c9, B:95:0x01d9, B:98:0x01e0, B:99:0x01f0, B:102:0x01f7, B:103:0x0207, B:105:0x0216, B:17:0x008d, B:175:0x0099, B:178:0x00a5, B:181:0x00b0, B:184:0x00bb, B:187:0x00c6, B:190:0x00d2, B:193:0x00dd, B:196:0x00e7, B:199:0x00f0, B:202:0x00fa, B:205:0x0104, B:208:0x010f, B:211:0x0119, B:214:0x0122), top: B:218:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c2 A[Catch: JSONException -> 0x012c, TryCatch #12 {JSONException -> 0x012c, blocks: (B:219:0x0081, B:65:0x014c, B:72:0x0161, B:73:0x0165, B:74:0x016a, B:76:0x016f, B:77:0x0175, B:79:0x017a, B:82:0x0182, B:83:0x0193, B:86:0x019b, B:87:0x01ab, B:90:0x01b2, B:91:0x01c2, B:94:0x01c9, B:95:0x01d9, B:98:0x01e0, B:99:0x01f0, B:102:0x01f7, B:103:0x0207, B:105:0x0216, B:17:0x008d, B:175:0x0099, B:178:0x00a5, B:181:0x00b0, B:184:0x00bb, B:187:0x00c6, B:190:0x00d2, B:193:0x00dd, B:196:0x00e7, B:199:0x00f0, B:202:0x00fa, B:205:0x0104, B:208:0x010f, B:211:0x0119, B:214:0x0122), top: B:218:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d9 A[Catch: JSONException -> 0x012c, TryCatch #12 {JSONException -> 0x012c, blocks: (B:219:0x0081, B:65:0x014c, B:72:0x0161, B:73:0x0165, B:74:0x016a, B:76:0x016f, B:77:0x0175, B:79:0x017a, B:82:0x0182, B:83:0x0193, B:86:0x019b, B:87:0x01ab, B:90:0x01b2, B:91:0x01c2, B:94:0x01c9, B:95:0x01d9, B:98:0x01e0, B:99:0x01f0, B:102:0x01f7, B:103:0x0207, B:105:0x0216, B:17:0x008d, B:175:0x0099, B:178:0x00a5, B:181:0x00b0, B:184:0x00bb, B:187:0x00c6, B:190:0x00d2, B:193:0x00dd, B:196:0x00e7, B:199:0x00f0, B:202:0x00fa, B:205:0x0104, B:208:0x010f, B:211:0x0119, B:214:0x0122), top: B:218:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f0 A[Catch: JSONException -> 0x012c, TryCatch #12 {JSONException -> 0x012c, blocks: (B:219:0x0081, B:65:0x014c, B:72:0x0161, B:73:0x0165, B:74:0x016a, B:76:0x016f, B:77:0x0175, B:79:0x017a, B:82:0x0182, B:83:0x0193, B:86:0x019b, B:87:0x01ab, B:90:0x01b2, B:91:0x01c2, B:94:0x01c9, B:95:0x01d9, B:98:0x01e0, B:99:0x01f0, B:102:0x01f7, B:103:0x0207, B:105:0x0216, B:17:0x008d, B:175:0x0099, B:178:0x00a5, B:181:0x00b0, B:184:0x00bb, B:187:0x00c6, B:190:0x00d2, B:193:0x00dd, B:196:0x00e7, B:199:0x00f0, B:202:0x00fa, B:205:0x0104, B:208:0x010f, B:211:0x0119, B:214:0x0122), top: B:218:0x0081 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject d(org.json.JSONObject r27, org.json.JSONArray r28, java.lang.String r29, java.lang.String r30, org.json.JSONObject r31) {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.featureCenter.featureType.e.d(org.json.JSONObject, org.json.JSONArray, java.lang.String, java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }
}
