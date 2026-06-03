package com.ss.ttvideoengine.superresolution;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SRStrategy {
    private SRStrategyConfig mSRConfig = new SRStrategyConfig();
    private ISRStrategyListener mSRStrategyListener = null;
    private int mSRStrategyMode = 1;
    private boolean mSRSatisfied = false;
    private boolean mShouldUseSRTexture = false;
    private int mSRNotUseReason = 0;
    private int mSRStatus = -1;
    private Map<Integer, List<Integer>> mSRBenchmark = new HashMap();
    private Map<String, Object> mStrategyInfo = new HashMap();

    static {
        Covode.recordClassIndex(652731);
    }

    public SRStrategyConfig getConfig() {
        return this.mSRConfig;
    }

    public Map<Integer, List<Integer>> getSRBenchmark() {
        return this.mSRBenchmark;
    }

    public int getSRNotUseReason() {
        return this.mSRNotUseReason;
    }

    public int getSRStatus() {
        return this.mSRStatus;
    }

    public int getSRStrategyMode() {
        return this.mSRStrategyMode;
    }

    public Map<String, Object> getStrategyInfo() {
        return this.mStrategyInfo;
    }

    public boolean isSRSatisfied() {
        return this.mSRSatisfied;
    }

    public boolean shouldUseSRTexture() {
        return this.mShouldUseSRTexture;
    }

    public String configString() {
        return this.mSRConfig.toString();
    }

    public JSONObject getConfigJson() {
        return this.mSRConfig.getJson();
    }

    public Integer getMaxHeight() {
        return this.mSRConfig.getMaxHeight();
    }

    public Integer getMaxWidth() {
        return this.mSRConfig.getMaxWidth();
    }

    public boolean isSREnabled() {
        Boolean enableSR = this.mSRConfig.getEnableSR();
        if (enableSR != null) {
            return enableSR.booleanValue();
        }
        return false;
    }

    public void resetAll() {
        this.mSRConfig.resetAll();
        this.mSRConfig.enableSR(false);
        this.mSRConfig.setEnableHdr(false);
        this.mSRConfig.setIsSpeed(false);
        this.mSRStrategyListener = null;
        this.mSRStrategyMode = 1;
        this.mSRSatisfied = false;
        this.mShouldUseSRTexture = false;
        this.mSRNotUseReason = 0;
        this.mSRStatus = -1;
        this.mStrategyInfo.clear();
    }

    public SRStrategy() {
        resetAll();
        this.mSRBenchmark.put(2, new ArrayList(Arrays.asList(3)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0099, code lost:
    
        if (r1.compareTo(java.lang.Integer.valueOf(r0.intValue() & r1.intValue())) != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
    
        if (r1.compareTo(java.lang.Integer.valueOf(r0.intValue() & r1.intValue())) != 0) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void checkSatisfied() {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.superresolution.SRStrategy.checkSatisfied():void");
    }

    public void setSRStrategyListener(ISRStrategyListener iSRStrategyListener) {
        this.mSRStrategyListener = iSRStrategyListener;
    }

    public void setSRStrategyMode(int i) {
        this.mSRStrategyMode = i;
    }

    public static int getResolutionIndex(VideoInfo videoInfo) {
        int i;
        Resolution resolution = videoInfo.getResolution();
        if (resolution != null) {
            i = resolution.getIndex();
        } else {
            i = -1;
        }
        String valueStr = videoInfo.getValueStr(32);
        if (valueStr != null) {
            try {
                return Integer.parseInt(valueStr);
            } catch (Exception unused) {
                return i;
            }
        }
        return i;
    }

    public void updateConfig(SRStrategyConfig sRStrategyConfig) {
        if (sRStrategyConfig == null) {
            return;
        }
        this.mSRConfig.updateFrom(sRStrategyConfig);
        String extraConfig = sRStrategyConfig.getExtraConfig();
        if (extraConfig != null && !extraConfig.isEmpty()) {
            String lowerCase = extraConfig.toLowerCase();
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(lowerCase).getJSONObject("sr").getJSONObject("benchmark");
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    int parseInt = Integer.parseInt(next);
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
                    }
                    hashMap.put(Integer.valueOf(parseInt), arrayList);
                }
                this.mSRBenchmark = hashMap;
                TTVideoEngineLog.i("TTVideoEngine.SRStrategy", "[SRLog]updateConfig mSRBenchmark=" + this.mSRBenchmark);
            } catch (Exception e) {
                TTVideoEngineLog.i("TTVideoEngine.SRStrategy", "[SRLog]updateConfig exception=" + e);
                e.printStackTrace();
            }
        }
        checkSatisfied();
    }

    public void onSRStatus(int i, int i2) {
        int i3 = this.mSRStatus;
        if (i == i3) {
            return;
        }
        if (i == 0 && 2 == i3) {
            return;
        }
        this.mSRStatus = i;
        if (2 == i) {
            this.mSRNotUseReason = i2;
        }
    }

    public void setStrategyInfo(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && !this.mStrategyInfo.containsKey(str)) {
            this.mStrategyInfo.put(str, obj);
        }
    }

    public Boolean videoInfoSupportSR(VideoInfo videoInfo, List<VideoInfo> list) {
        int resolutionIndex = getResolutionIndex(videoInfo);
        if (!this.mSRBenchmark.containsKey(Integer.valueOf(resolutionIndex))) {
            return Boolean.FALSE;
        }
        Integer screenWidth = this.mSRConfig.getScreenWidth();
        List<Integer> list2 = this.mSRBenchmark.get(Integer.valueOf(resolutionIndex));
        if (list2 == null) {
            return Boolean.FALSE;
        }
        VideoInfo videoInfo2 = null;
        for (VideoInfo videoInfo3 : list) {
            int resolutionIndex2 = getResolutionIndex(videoInfo3);
            Iterator<Integer> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (it2.next().intValue() == resolutionIndex2 && (videoInfo2 == null || videoInfo2.getValueInt(3) < videoInfo3.getValueInt(3))) {
                    videoInfo2 = videoInfo3;
                    break;
                }
            }
        }
        if (videoInfo2 != null && (screenWidth == null || videoInfo2.getValueInt(1) > screenWidth.intValue())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
