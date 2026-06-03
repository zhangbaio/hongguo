package com.ss.ttvideoengine.log;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class ViewSizeMonitor {
    private int currentHeight;
    private int currentWidth;
    private final ArrayList<String> historyList = new ArrayList<>();
    private int lastValidHeight;
    private int lastValidWidth;

    static {
        Covode.recordClassIndex(652521);
    }

    public ArrayList<String> getHistory() {
        return new ArrayList<>(this.historyList);
    }

    ViewSizeMonitor() {
    }

    public void reset() {
        this.currentWidth = 0;
        this.currentHeight = 0;
        this.historyList.clear();
    }

    public void tryAddLastSizeToHistory() {
        if (this.currentWidth <= 0 && this.currentHeight <= 0) {
            maybeAddToHistory(this.lastValidWidth, this.lastValidHeight);
        }
    }

    public void setSize(int i, int i2) {
        if (i > 0) {
            this.currentWidth = i;
            this.lastValidWidth = i;
        }
        if (i2 > 0) {
            this.currentHeight = i2;
            this.lastValidHeight = i2;
        }
        maybeAddToHistory(this.currentWidth, this.currentHeight);
    }

    private void maybeAddToHistory(int i, int i2) {
        if (i > 0 && i2 > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("w", Integer.valueOf(i));
            hashMap.put("h", Integer.valueOf(i2));
            hashMap.put("t", Long.valueOf(System.currentTimeMillis()));
            try {
                TTVideoEngineUtils.addToList(this.historyList, new JSONObject(hashMap).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.currentWidth = 0;
            this.currentHeight = 0;
        }
    }
}
