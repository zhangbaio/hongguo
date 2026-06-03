package com.ss.ttvideoengine;

import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface DataLoaderListener {

    /* renamed from: com.ss.ttvideoengine.DataLoaderListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onMultiNetworkSwitch(DataLoaderListener dataLoaderListener, String str, String str2) {
        }

        public static void $default$onStartComplete(DataLoaderListener dataLoaderListener) {
        }
    }

    String apiStringForFetchVideoModel(Map<String, String> map, String str, Resolution resolution);

    String authStringForFetchVideoModel(String str, Resolution resolution);

    void dataLoaderError(String str, int i, Error error);

    String getCheckSumInfo(String str);

    HashMap<String, String> getCustomHttpHeaders(String str);

    boolean loadLibrary(String str);

    void onLoadProgress(DataLoaderHelper.DataLoaderTaskLoadProgress dataLoaderTaskLoadProgress);

    void onLogInfo(int i, String str, JSONObject jSONObject);

    void onLogInfoToMonitor(int i, String str, JSONObject jSONObject);

    void onMultiNetworkSwitch(String str, String str2);

    void onNotify(int i, long j, long j2, String str);

    void onNotifyCDNLog(DataLoaderCDNLog dataLoaderCDNLog);

    void onNotifyCDNLog(JSONObject jSONObject);

    void onStartComplete();

    void onTaskProgress(DataLoaderHelper.DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo);
}
