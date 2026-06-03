package us4;

import com.bytedance.covode.number.Covode;
import com.bytedance.ttnet.TTMultiNetwork;
import com.dragon.read.NsUtilsDepend;
import com.dragon.read.app.App;
import com.dragon.read.base.util.LogHelper;
import com.ss.android.common.applog.AppLog;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.DataLoaderListener;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class g implements DataLoaderListener {
    private static final LogHelper a;

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public String apiStringForFetchVideoModel(Map<String, String> map, String str, Resolution resolution) {
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public String authStringForFetchVideoModel(String str, Resolution resolution) {
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public String getCheckSumInfo(String str) {
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public HashMap<String, String> getCustomHttpHeaders(String str) {
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public boolean loadLibrary(String str) {
        return false;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onLogInfoToMonitor(int i, String str, JSONObject jSONObject) {
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onNotifyCDNLog(DataLoaderCDNLog dataLoaderCDNLog) {
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onNotifyCDNLog(JSONObject jSONObject) {
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public /* synthetic */ void onStartComplete() {
        DataLoaderListener.CC.$default$onStartComplete(this);
    }

    static {
        Covode.recordClassIndex(612515);
        a = new LogHelper("TTVideoDataLoaderListener");
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onLoadProgress(DataLoaderHelper.DataLoaderTaskLoadProgress dataLoaderTaskLoadProgress) {
        NsUtilsDepend.IMPL.notifyLoadProgress(dataLoaderTaskLoadProgress);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onTaskProgress(DataLoaderHelper.DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo) {
        LogHelper logHelper = a;
        logHelper.i("缓存进度通知", new Object[0]);
        if (dataLoaderTaskProgressInfo != null) {
            int i = dataLoaderTaskProgressInfo.mTaskType;
            if (i != 1) {
                if (i != 2) {
                    logHelper.i("未知任务", new Object[0]);
                } else {
                    logHelper.i("为预加载任务", new Object[0]);
                }
            } else {
                logHelper.i("为播放任务", new Object[0]);
            }
            logHelper.i("缓存资源key: " + dataLoaderTaskProgressInfo.mKey + ",\n视频id: " + dataLoaderTaskProgressInfo.mVideoId + ",\n本地缓存路径: " + dataLoaderTaskProgressInfo.mLocalFilePath + ",\n文件content length: " + dataLoaderTaskProgressInfo.mMediaSize + ",\n缓存size: " + dataLoaderTaskProgressInfo.mCacheSizeFromZero + ",\n视频id: " + dataLoaderTaskProgressInfo.mVideoId + ",\nvideoInfo: " + dataLoaderTaskProgressInfo.mUsingVideoInfo, new Object[0]);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onMultiNetworkSwitch(String str, String str2) {
        if (NsUtilsDepend.IMPL.onMultiNetworkSwitchEnable()) {
            a.i("onMultiNetworkSwitch targetNetwork=$s, currentNetwork=$s", new Object[]{str, str2});
            TTMultiNetwork.triggerSwitchingToCellular();
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void dataLoaderError(String str, int i, Error error) {
        LogHelper logHelper = a;
        logHelper.e("MDL 启动出错！", new Object[0]);
        logHelper.e("DataLoaderError, videoId: " + str + ", errorType: " + i + ", error:" + error, new Object[0]);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onLogInfo(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("v_tag", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("loader_info");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String str2 = null;
                    int i3 = -1;
                    try {
                        JSONObject jSONObject2 = new JSONObject(optJSONArray.optString(0));
                        i3 = jSONObject2.optInt("download_size", -1);
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("urls");
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            str2 = optJSONArray2.optString(0, null);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (i3 > 0) {
                        long j = i3;
                        NsUtilsDepend.IMPL.addVideoTraffic(j);
                        s55.d.k(j, "TTVideoEngine", optString, str2);
                    }
                }
            }
        }
        try {
            AppLog.recordMiscLog(App.context(), str, jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onNotify(int i, long j, long j2, String str) {
        LogHelper logHelper = a;
        logHelper.i("网络，io读写信息速度", new Object[0]);
        logHelper.i("DataLoaderSpeedInfo: " + i + ", code: " + j + ", parameter: " + j2 + ", info: " + str, new Object[0]);
        NsUtilsDepend.IMPL.preloadMgrOnNotify(i, j, j2, str);
    }
}
