package com.ss.ttvideoengine.utils;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.log.VideoEventLoggerV2;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTVideoEngineUtils {
    public static int sEnableHTTPSForFetch;
    public static int sSensitiveScene;

    public static boolean isFlagOn(long j, long j2) {
        return (j & j2) != 0;
    }

    static {
        Covode.recordClassIndex(652764);
        sEnableHTTPSForFetch = 1;
        sSensitiveScene = 0;
    }

    public static int getSensitiveScene() {
        boolean booleanValue;
        int i;
        if (VideoEventLoggerV2.sIsColdStart == 1 && (i = sSensitiveScene) > 0) {
            return i;
        }
        try {
            boolean booleanValue2 = ((Boolean) l3.a.q("com.ss.android.ugc.aweme.utils.PrivacyPolicyAgreementUtils").getMethod("isUserAgreePrivacyPolicy", new Class[0]).invoke(null, new Object[0])).booleanValue();
            TTVideoEngineLog.d("TTVideoEngineUtils", "isUserAgreePrivacyPolicy:" + booleanValue2);
            if (!booleanValue2) {
                return 1;
            }
        } catch (Throwable th) {
            TTVideoEngineLog.e("TTVideoEngineUtils", "get PrivacyPolicy failed:" + th.toString());
        }
        try {
            Class q = l3.a.q("com.ss.android.ugc.aweme.compliance.api.ComplianceServiceProvider");
            if (q == null) {
                return -1;
            }
            try {
                boolean booleanValue3 = ((Boolean) l3.a.q("com.ss.android.ugc.aweme.compliance.api.services.teenmode.ITeenModeService").getMethod("isTeenModeON", new Class[0]).invoke(q.getMethod("teenModeService", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
                TTVideoEngineLog.d("TTVideoEngineUtils", "isTeenModeOn:" + booleanValue3);
                if (booleanValue3) {
                    return 2;
                }
            } catch (Throwable th2) {
                TTVideoEngineLog.e("TTVideoEngineUtils", "get teenModeService failed:" + th2.toString());
            }
            try {
                booleanValue = ((Boolean) l3.a.q("com.ss.android.ugc.aweme.compliance.api.services.businesses.IComplianceBusinessService").getMethod("isGuestMode", new Class[0]).invoke(q.getMethod("businessService", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
                TTVideoEngineLog.d("TTVideoEngineUtils", "isGuestMode:" + booleanValue);
            } catch (Throwable th3) {
                TTVideoEngineLog.e("TTVideoEngineUtils", "get businessService failed:" + th3.toString());
            }
            if (!booleanValue) {
                return -1;
            }
            return 3;
        } catch (Throwable th4) {
            TTVideoEngineLog.e("TTVideoEngineUtils", "get ComplianceServiceProvider failed:" + th4.toString());
            return -1;
        }
    }

    public static void setSensitiveScene(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            sSensitiveScene = i;
        }
    }

    public static String BuildHttpsApi(String str) {
        if (sEnableHTTPSForFetch == 1 && !TextUtils.isEmpty(str) && str.startsWith("http://")) {
            TTVideoEngineLog.i("TTVideoEngineUtils", "fetch api need replace https");
            return str.replaceFirst("http://", "https://");
        }
        return str;
    }

    public static <T> void addToList(ArrayList<T> arrayList, T t) {
        if (arrayList == null) {
            return;
        }
        if (TTVideoEngine.sBuryDataOptimize && arrayList.size() < 100) {
            arrayList.add(t);
        } else {
            arrayList.add(t);
        }
    }

    public static <T> void addToList(ArrayList<T> arrayList, T t, int i) {
        if (arrayList != null && i >= 0) {
            if (TTVideoEngine.sBuryDataOptimize && arrayList.size() < i) {
                arrayList.add(t);
            } else {
                arrayList.add(t);
            }
        }
    }
}
