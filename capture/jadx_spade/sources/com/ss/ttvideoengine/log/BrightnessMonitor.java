package com.ss.ttvideoengine.log;

import android.content.Context;
import android.database.ContentObserver;
import android.provider.Settings;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BrightnessMonitor {
    private final Context mContext;
    private volatile boolean mIsPlaying;
    private volatile boolean mIsStart;
    private final ArrayList<String> mHistoryList = new ArrayList<>();
    private final ContentObserver mBrightnessObserver = new ContentObserver(null) { // from class: com.ss.ttvideoengine.log.BrightnessMonitor.1
        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            BrightnessMonitor.this.addToHistory();
        }
    };

    static {
        Covode.recordClassIndex(652459);
    }

    public ArrayList<String> getList() {
        return this.mHistoryList;
    }

    public void stop() {
        if (!this.mIsStart) {
            return;
        }
        this.mIsStart = false;
        this.mContext.getContentResolver().unregisterContentObserver(this.mBrightnessObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToHistory() {
        if (this.mIsPlaying && this.mHistoryList.size() <= 100) {
            HashMap hashMap = new HashMap();
            hashMap.put("b", Float.valueOf(ScreenUtils.getNormalizedBrightness(this.mContext)));
            hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
            TTVideoEngineUtils.addToList(this.mHistoryList, new JSONObject(hashMap).toString());
        }
    }

    public void start() {
        if (this.mIsStart) {
            return;
        }
        this.mIsStart = true;
        try {
            this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, this.mBrightnessObserver);
        } catch (Exception e) {
            TTVideoEngineLog.w("BrightnessMonitor", e.getMessage());
        }
        addToHistory();
    }

    public void setPlaying(boolean z) {
        this.mIsPlaying = z;
    }

    public BrightnessMonitor(Context context) {
        this.mContext = context.getApplicationContext();
    }
}
