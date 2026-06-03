package com.ss.ttvideoengine.model;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LiveVideoInfo {
    public String mBackupUrl;
    public String mMainUrl;
    public String[] mURLs;

    static {
        Covode.recordClassIndex(652544);
    }

    public void extractFields(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        String optString = jSONObject.optString("main_play_url");
        this.mMainUrl = optString;
        if (!TextUtils.isEmpty(optString)) {
            arrayList.add(this.mMainUrl);
        }
        String optString2 = jSONObject.optString("backup_play_url");
        this.mBackupUrl = optString2;
        if (!TextUtils.isEmpty(optString2)) {
            arrayList.add(this.mBackupUrl);
        }
        String[] strArr = new String[arrayList.size()];
        this.mURLs = strArr;
        arrayList.toArray(strArr);
    }
}
