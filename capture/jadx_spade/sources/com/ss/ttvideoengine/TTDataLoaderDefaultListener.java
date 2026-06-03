package com.ss.ttvideoengine;

import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.DataLoaderListener;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTDataLoaderDefaultListener implements DataLoaderListener {
    private DataLoaderListener mInjectDataLoaderListener;
    private ss1.b mPredictor;

    static {
        Covode.recordClassIndex(652323);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public /* synthetic */ void onMultiNetworkSwitch(String str, String str2) {
        DataLoaderListener.CC.$default$onMultiNetworkSwitch(this, str, str2);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public /* synthetic */ void onStartComplete() {
        DataLoaderListener.CC.$default$onStartComplete(this);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onLoadProgress(DataLoaderHelper.DataLoaderTaskLoadProgress dataLoaderTaskLoadProgress) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onLoadProgress(dataLoaderTaskLoadProgress);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onNotifyCDNLog(DataLoaderCDNLog dataLoaderCDNLog) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onNotifyCDNLog(dataLoaderCDNLog);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onTaskProgress(DataLoaderHelper.DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onTaskProgress(dataLoaderTaskProgressInfo);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public String getCheckSumInfo(String str) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.getCheckSumInfo(str);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public HashMap<String, String> getCustomHttpHeaders(String str) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.getCustomHttpHeaders(str);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public boolean loadLibrary(String str) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.loadLibrary(str);
        }
        return false;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onNotifyCDNLog(JSONObject jSONObject) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onNotifyCDNLog(jSONObject);
        }
    }

    TTDataLoaderDefaultListener(ss1.b bVar, DataLoaderListener dataLoaderListener) {
        this.mPredictor = bVar;
        this.mInjectDataLoaderListener = dataLoaderListener;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public String authStringForFetchVideoModel(String str, Resolution resolution) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.authStringForFetchVideoModel(str, resolution);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void dataLoaderError(String str, int i, Error error) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.dataLoaderError(str, i, error);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onLogInfo(int i, String str, JSONObject jSONObject) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onLogInfo(i, str, jSONObject);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onLogInfoToMonitor(int i, String str, JSONObject jSONObject) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onLogInfoToMonitor(i, str, jSONObject);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public String apiStringForFetchVideoModel(Map<String, String> map, String str, Resolution resolution) {
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.apiStringForFetchVideoModel(map, str, resolution);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onNotify(int i, long j, long j2, String str) {
        ss1.b bVar;
        if (i == 2 && (bVar = this.mPredictor) != null) {
            bVar.update(j, j2, SystemClock.elapsedRealtime());
            if (j2 != 0) {
                TTVideoEngineLog.d("TTVideoEngine", String.format(Locale.US, "[IESSpeedPredictor]: speedRecord:%f", Double.valueOf(j / j2)));
            }
        }
        DataLoaderListener dataLoaderListener = this.mInjectDataLoaderListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onNotify(i, j, j2, str);
        }
    }
}
