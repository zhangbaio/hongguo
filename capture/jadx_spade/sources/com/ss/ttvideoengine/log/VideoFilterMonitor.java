package com.ss.ttvideoengine.log;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoFilterMonitor {
    private final ArrayList<String> mHistoryList = new ArrayList<>();
    private boolean mIsFilterOn;

    static {
        Covode.recordClassIndex(652520);
    }

    public ArrayList<String> getList() {
        return this.mHistoryList;
    }

    private boolean isEyeProtectionModeOn(Bundle bundle) {
        int i = bundle.getInt("action");
        if (bundle.getInt("effect_type") != 2) {
            return false;
        }
        if (i == 21) {
            if (bundle.getInt("use_effect") != 1) {
                return false;
            }
            return true;
        }
        if (i != 19 || bundle.getInt("int_value") != 1) {
            return false;
        }
        return true;
    }

    private void updateHistory(boolean z) {
        String str;
        HashMap hashMap = new HashMap();
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("on", str);
        hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
        TTVideoEngineUtils.addToList(this.mHistoryList, new JSONObject(hashMap).toString());
    }

    public void setEffect(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.getInt("effect_type") != 2) {
            TTVideoEngineLog.d("VideoFilterMonitor", "not eye protection filter bundle");
            return;
        }
        boolean isEyeProtectionModeOn = isEyeProtectionModeOn(bundle);
        if (isEyeProtectionModeOn != this.mIsFilterOn) {
            this.mIsFilterOn = isEyeProtectionModeOn;
            updateHistory(isEyeProtectionModeOn);
        }
    }
}
