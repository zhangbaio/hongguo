package com.ss.ttvideoengine;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.DataLoaderListener;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;
import u55.q;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class DataLoaderListenerWrapper implements DataLoaderListener {
    private DataLoaderListener mListener;
    private final CopyOnWriteArrayList<DataLoaderListener2> mListener2s = new CopyOnWriteArrayList<>();

    static {
        Covode.recordClassIndex(652276);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onLogInfo(int i, String str, JSONObject jSONObject) {
        com_ss_ttvideoengine_DataLoaderListenerWrapper_com_dragon_read_aop_NetworkTrafficAop_onLogInfo(this, i, str, jSONObject);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public /* synthetic */ void onMultiNetworkSwitch(String str, String str2) {
        DataLoaderListener.CC.$default$onMultiNetworkSwitch(this, str, str2);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onStartComplete() {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onStartComplete();
        }
    }

    DataLoaderListenerWrapper() {
    }

    void clearListeners() {
        this.mListener = null;
        this.mListener2s.clear();
    }

    void setListener(DataLoaderListener dataLoaderListener) {
        this.mListener = dataLoaderListener;
    }

    void addListener(DataLoaderListener2 dataLoaderListener2) {
        this.mListener2s.addIfAbsent(dataLoaderListener2);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onLoadProgress(DataLoaderHelper.DataLoaderTaskLoadProgress dataLoaderTaskLoadProgress) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onLoadProgress(dataLoaderTaskLoadProgress);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onNotifyCDNLog(DataLoaderCDNLog dataLoaderCDNLog) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onNotifyCDNLog(dataLoaderCDNLog);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onTaskProgress(DataLoaderHelper.DataLoaderTaskProgressInfo dataLoaderTaskProgressInfo) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onTaskProgress(dataLoaderTaskProgressInfo);
        }
    }

    void removeListener(DataLoaderListener2 dataLoaderListener2) {
        this.mListener2s.remove(dataLoaderListener2);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public String getCheckSumInfo(String str) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.getCheckSumInfo(str);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public HashMap<String, String> getCustomHttpHeaders(String str) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.getCustomHttpHeaders(str);
        }
        return null;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public boolean loadLibrary(String str) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.loadLibrary(str);
        }
        return false;
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onNotifyCDNLog(JSONObject jSONObject) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onNotifyCDNLog(jSONObject);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public String authStringForFetchVideoModel(String str, Resolution resolution) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.authStringForFetchVideoModel(str, resolution);
        }
        return null;
    }

    public void DataLoaderListenerWrapper__onLogInfo$___twin___(int i, String str, JSONObject jSONObject) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onLogInfo(i, str, jSONObject);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void dataLoaderError(String str, int i, Error error) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.dataLoaderError(str, i, error);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onLogInfoToMonitor(int i, String str, JSONObject jSONObject) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onLogInfoToMonitor(i, str, jSONObject);
        }
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public String apiStringForFetchVideoModel(Map<String, String> map, String str, Resolution resolution) {
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            return dataLoaderListener.apiStringForFetchVideoModel(map, str, resolution);
        }
        return null;
    }

    @TargetClass(scope = Scope.SELF, value = "com.ss.ttvideoengine.DataLoaderListenerWrapper")
    @Insert("onLogInfo")
    public static void com_ss_ttvideoengine_DataLoaderListenerWrapper_com_dragon_read_aop_NetworkTrafficAop_onLogInfo(DataLoaderListenerWrapper dataLoaderListenerWrapper, int i, String str, JSONObject jSONObject) {
        dataLoaderListenerWrapper.DataLoaderListenerWrapper__onLogInfo$___twin___(i, str, jSONObject);
        if (!u55.k.o() || jSONObject == null) {
            return;
        }
        q.d(str, jSONObject);
    }

    @Override // com.ss.ttvideoengine.DataLoaderListener
    public void onNotify(int i, long j, long j2, String str) {
        Iterator<DataLoaderListener2> it2 = this.mListener2s.iterator();
        while (it2.hasNext()) {
            it2.next().onNotify(i, j, j2, str);
        }
        DataLoaderListener dataLoaderListener = this.mListener;
        if (dataLoaderListener != null) {
            dataLoaderListener.onNotify(i, j, j2, str);
        }
    }
}
