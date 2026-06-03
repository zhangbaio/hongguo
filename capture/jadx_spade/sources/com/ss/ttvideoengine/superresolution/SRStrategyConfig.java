package com.ss.ttvideoengine.superresolution;

import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SRStrategyConfig {
    private Integer mCurrentDuration;
    private Float mCurrentFps;
    private Integer mCurrentHeight;
    private Integer mCurrentPower;
    private Integer mCurrentScene;
    private Integer mCurrentVideoFormatType;
    private Integer mCurrentWidth;
    private Bundle mEffectBuddle;
    private Boolean mEnableHdr;
    private Boolean mEnableSR;
    private Boolean mEnableSpeed;
    private String mExtraConfig;
    private Map<String, String> mExtraInfo = new HashMap();
    private Boolean mIsCharging;
    private Boolean mIsHdr;
    private Boolean mIsSpeed;
    private Long mMaxDuration;
    private Float mMaxFps;
    private Integer mMaxHeight;
    private Integer mMaxWidth;
    private Long mMinDuration;
    private Integer mMinPower;
    private Boolean mResolutionChanged;
    private Integer mSRPercent;
    private Integer mScreenWidth;
    ISRStatusListener mStatusListener;
    ISRStrategyListener mStrategyListener;
    private Integer mStrategyType;
    private Integer mSupportScene;
    private Integer mVideoFormatType;

    static {
        Covode.recordClassIndex(652732);
    }

    public Integer getCurrentDuration() {
        return this.mCurrentDuration;
    }

    public Float getCurrentFps() {
        return this.mCurrentFps;
    }

    public Integer getCurrentHeight() {
        return this.mCurrentHeight;
    }

    public Integer getCurrentPower() {
        return this.mCurrentPower;
    }

    public Integer getCurrentScene() {
        return this.mCurrentScene;
    }

    public Integer getCurrentVideoFormatType() {
        return this.mCurrentVideoFormatType;
    }

    public Integer getCurrentWidth() {
        return this.mCurrentWidth;
    }

    public Boolean getEnableHdr() {
        return this.mEnableHdr;
    }

    public Boolean getEnableSR() {
        return this.mEnableSR;
    }

    public Boolean getEnableSpeed() {
        return this.mEnableSpeed;
    }

    public String getExtraConfig() {
        return this.mExtraConfig;
    }

    public Map<String, String> getExtraInfo() {
        return this.mExtraInfo;
    }

    public Boolean getIsCharging() {
        return this.mIsCharging;
    }

    public Boolean getIsHdr() {
        return this.mIsHdr;
    }

    public Boolean getIsSpeed() {
        return this.mIsSpeed;
    }

    public ISRStatusListener getListener() {
        return this.mStatusListener;
    }

    public Long getMaxDuration() {
        return this.mMaxDuration;
    }

    public Float getMaxFps() {
        return this.mMaxFps;
    }

    public Integer getMaxHeight() {
        return this.mMaxHeight;
    }

    public Integer getMaxWidth() {
        return this.mMaxWidth;
    }

    public Long getMinDuration() {
        return this.mMinDuration;
    }

    public Integer getMinPower() {
        return this.mMinPower;
    }

    public Boolean getResolutionChanged() {
        return this.mResolutionChanged;
    }

    public Integer getSRPercent() {
        return this.mSRPercent;
    }

    public Integer getScreenWidth() {
        return this.mScreenWidth;
    }

    public ISRStrategyListener getStrategyListener() {
        return this.mStrategyListener;
    }

    public Integer getStrategyType() {
        return this.mStrategyType;
    }

    public Integer getSupportScene() {
        return this.mSupportScene;
    }

    public Integer getVideoFormatType() {
        return this.mVideoFormatType;
    }

    public static SRStrategyConfig newConfig() {
        return new SRStrategyConfig();
    }

    public SRStrategyConfig() {
        resetAll();
    }

    public String toString() {
        return getJson().toString();
    }

    public void resetStream() {
        this.mMaxFps = null;
        this.mCurrentVideoFormatType = null;
        this.mCurrentDuration = null;
        this.mCurrentWidth = null;
        this.mCurrentHeight = null;
        this.mCurrentFps = null;
        this.mIsHdr = null;
        this.mResolutionChanged = null;
        this.mIsSpeed = null;
        this.mStrategyType = null;
    }

    public void resetAll() {
        this.mEnableSR = null;
        this.mVideoFormatType = null;
        this.mMinDuration = null;
        this.mMaxDuration = null;
        this.mMinPower = null;
        this.mSupportScene = null;
        this.mEnableSpeed = null;
        this.mSRPercent = null;
        this.mMaxWidth = null;
        this.mMaxHeight = null;
        this.mMaxFps = null;
        this.mEnableHdr = null;
        this.mCurrentVideoFormatType = null;
        this.mCurrentDuration = null;
        this.mCurrentPower = null;
        this.mIsCharging = null;
        this.mCurrentScene = null;
        this.mIsSpeed = null;
        this.mCurrentWidth = null;
        this.mCurrentHeight = null;
        this.mCurrentFps = null;
        this.mIsHdr = null;
        this.mExtraConfig = null;
        this.mExtraInfo.clear();
        this.mStatusListener = null;
        this.mResolutionChanged = null;
        this.mStrategyType = null;
        this.mScreenWidth = null;
        this.mStrategyListener = null;
        this.mEffectBuddle = null;
    }

    public JSONObject getJson() {
        int i;
        int i2;
        int i3;
        int i4;
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean bool = this.mEnableSR;
            int i5 = 1;
            if (bool != null) {
                if (bool.booleanValue()) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                jSONObject.put("e", i4);
            }
            Integer num = this.mStrategyType;
            if (num != null) {
                jSONObject.put("st", num);
            }
            Integer num2 = this.mMaxWidth;
            if (num2 != null) {
                jSONObject.put("mw", num2);
            }
            Integer num3 = this.mMaxHeight;
            if (num3 != null) {
                jSONObject.put("mh", num3);
            }
            Integer num4 = this.mScreenWidth;
            if (num4 != null) {
                jSONObject.put("sw", num4);
            }
            Integer num5 = this.mCurrentWidth;
            if (num5 != null) {
                jSONObject.put("cw", num5);
            }
            Integer num6 = this.mCurrentHeight;
            if (num6 != null) {
                jSONObject.put("ch", num6);
            }
            Integer num7 = this.mVideoFormatType;
            if (num7 != null) {
                jSONObject.put("ft", num7);
            }
            Integer num8 = this.mCurrentVideoFormatType;
            if (num8 != null) {
                jSONObject.put("cft", num8);
            }
            Long l = this.mMinDuration;
            if (l != null) {
                jSONObject.put("mid", l);
            }
            Long l2 = this.mMaxDuration;
            if (l2 != null) {
                jSONObject.put("mad", l2);
            }
            Integer num9 = this.mCurrentDuration;
            if (num9 != null) {
                jSONObject.put("cd", num9);
            }
            Integer num10 = this.mSupportScene;
            if (num10 != null) {
                jSONObject.put("ss", num10);
            }
            Integer num11 = this.mCurrentScene;
            if (num11 != null) {
                jSONObject.put("cs", num11);
            }
            Boolean bool2 = this.mEnableSpeed;
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("es", i3);
            }
            Boolean bool3 = this.mIsSpeed;
            if (bool3 != null) {
                if (bool3.booleanValue()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("is", i2);
            }
            Float f = this.mMaxFps;
            if (f != null) {
                jSONObject.put("mf", f);
            }
            Float f2 = this.mCurrentFps;
            if (f2 != null) {
                jSONObject.put("cf", f2);
            }
            Boolean bool4 = this.mEnableHdr;
            if (bool4 != null) {
                if (bool4.booleanValue()) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("eh", i);
            }
            Boolean bool5 = this.mIsHdr;
            if (bool5 != null) {
                if (!bool5.booleanValue()) {
                    i5 = 0;
                }
                jSONObject.put("ih", i5);
            }
            if (this.mExtraInfo != null) {
                jSONObject.put("ei", new JSONObject(this.mExtraInfo));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public SRStrategyConfig setExtraConfig(String str) {
        this.mExtraConfig = str;
        return this;
    }

    public SRStrategyConfig setExtraInfo(Map<String, String> map) {
        this.mExtraInfo = map;
        return this;
    }

    public SRStrategyConfig setListener(ISRStatusListener iSRStatusListener) {
        this.mStatusListener = iSRStatusListener;
        return this;
    }

    public SRStrategyConfig setStrategyListener(ISRStrategyListener iSRStrategyListener) {
        this.mStrategyListener = iSRStrategyListener;
        return this;
    }

    public SRStrategyConfig enableSR(boolean z) {
        this.mEnableSR = Boolean.valueOf(z);
        return this;
    }

    public SRStrategyConfig enableSpeed(boolean z) {
        this.mEnableSpeed = Boolean.valueOf(z);
        return this;
    }

    public SRStrategyConfig resolutionChanged(boolean z) {
        this.mResolutionChanged = Boolean.valueOf(z);
        return this;
    }

    public void setCurrentDuration(int i) {
        this.mCurrentDuration = Integer.valueOf(i);
    }

    public SRStrategyConfig setCurrentFps(float f) {
        this.mCurrentFps = Float.valueOf(f);
        return this;
    }

    public SRStrategyConfig setCurrentHeight(int i) {
        this.mCurrentHeight = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setCurrentPower(int i) {
        this.mCurrentPower = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setCurrentScene(int i) {
        this.mCurrentScene = Integer.valueOf(i);
        return this;
    }

    public void setCurrentVideoFormatType(int i) {
        this.mCurrentVideoFormatType = Integer.valueOf(i);
    }

    public SRStrategyConfig setCurrentWidth(int i) {
        this.mCurrentWidth = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setEnableHdr(boolean z) {
        this.mEnableHdr = Boolean.valueOf(z);
        return this;
    }

    public SRStrategyConfig setIsCharging(boolean z) {
        this.mIsCharging = Boolean.valueOf(z);
        return this;
    }

    public SRStrategyConfig setIsHdr(boolean z) {
        this.mIsHdr = Boolean.valueOf(z);
        return this;
    }

    public SRStrategyConfig setIsSpeed(boolean z) {
        this.mIsSpeed = Boolean.valueOf(z);
        return this;
    }

    public SRStrategyConfig setMaxFps(float f) {
        this.mMaxFps = Float.valueOf(f);
        return this;
    }

    public SRStrategyConfig setMaxHeight(int i) {
        this.mMaxHeight = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setMaxWidth(int i) {
        this.mMaxWidth = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setMinPower(int i) {
        this.mMinPower = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setSRPercent(int i) {
        this.mSRPercent = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setScreenWidth(int i) {
        this.mScreenWidth = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setStrategyType(int i) {
        this.mStrategyType = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setSupportScene(int i) {
        this.mSupportScene = Integer.valueOf(i);
        return this;
    }

    public SRStrategyConfig setVideoFormatType(int i) {
        this.mVideoFormatType = Integer.valueOf(i);
        return this;
    }

    public void updateFrom(SRStrategyConfig sRStrategyConfig) {
        if (sRStrategyConfig == null) {
            return;
        }
        Boolean resolutionChanged = sRStrategyConfig.getResolutionChanged();
        if (resolutionChanged != null) {
            this.mResolutionChanged = resolutionChanged;
        }
        Boolean enableSR = sRStrategyConfig.getEnableSR();
        if (enableSR != null) {
            this.mEnableSR = enableSR;
        }
        Integer videoFormatType = sRStrategyConfig.getVideoFormatType();
        if (videoFormatType != null) {
            this.mVideoFormatType = videoFormatType;
        }
        Long minDuration = sRStrategyConfig.getMinDuration();
        if (minDuration != null) {
            this.mMinDuration = minDuration;
        }
        Long maxDuration = sRStrategyConfig.getMaxDuration();
        if (maxDuration != null) {
            this.mMaxDuration = maxDuration;
        }
        Integer minPower = sRStrategyConfig.getMinPower();
        if (minPower != null) {
            this.mMinPower = minPower;
        }
        Integer supportScene = sRStrategyConfig.getSupportScene();
        if (supportScene != null) {
            this.mSupportScene = supportScene;
        }
        Boolean enableSpeed = sRStrategyConfig.getEnableSpeed();
        if (enableSpeed != null) {
            this.mEnableSpeed = enableSpeed;
        }
        Integer sRPercent = sRStrategyConfig.getSRPercent();
        if (sRPercent != null) {
            this.mSRPercent = sRPercent;
        }
        Integer maxWidth = sRStrategyConfig.getMaxWidth();
        if (maxWidth != null) {
            this.mMaxWidth = maxWidth;
        }
        Integer maxHeight = sRStrategyConfig.getMaxHeight();
        if (maxHeight != null) {
            this.mMaxHeight = maxHeight;
        }
        Float maxFps = sRStrategyConfig.getMaxFps();
        if (maxFps != null) {
            this.mMaxFps = maxFps;
        }
        Boolean enableHdr = sRStrategyConfig.getEnableHdr();
        if (enableHdr != null) {
            this.mEnableHdr = enableHdr;
        }
        Integer currentVideoFormatType = sRStrategyConfig.getCurrentVideoFormatType();
        if (currentVideoFormatType != null) {
            this.mCurrentVideoFormatType = currentVideoFormatType;
        }
        Integer currentDuration = sRStrategyConfig.getCurrentDuration();
        if (currentDuration != null) {
            this.mCurrentDuration = currentDuration;
        }
        Integer currentPower = sRStrategyConfig.getCurrentPower();
        if (currentPower != null) {
            this.mCurrentPower = currentPower;
        }
        Boolean isCharging = sRStrategyConfig.getIsCharging();
        if (isCharging != null) {
            this.mIsCharging = isCharging;
        }
        Integer currentScene = sRStrategyConfig.getCurrentScene();
        if (currentScene != null) {
            this.mCurrentScene = currentScene;
        }
        Boolean isSpeed = sRStrategyConfig.getIsSpeed();
        if (isSpeed != null) {
            this.mIsSpeed = isSpeed;
        }
        Integer currentWidth = sRStrategyConfig.getCurrentWidth();
        if (currentWidth != null) {
            this.mCurrentWidth = currentWidth;
        }
        Integer currentHeight = sRStrategyConfig.getCurrentHeight();
        if (currentHeight != null) {
            this.mCurrentHeight = currentHeight;
        }
        Float currentFps = sRStrategyConfig.getCurrentFps();
        if (currentFps != null) {
            this.mCurrentFps = currentFps;
        }
        Boolean isHdr = sRStrategyConfig.getIsHdr();
        if (isHdr != null) {
            this.mIsHdr = isHdr;
        }
        ISRStatusListener listener = sRStrategyConfig.getListener();
        if (listener != null) {
            this.mStatusListener = listener;
        }
        ISRStrategyListener strategyListener = sRStrategyConfig.getStrategyListener();
        if (strategyListener != null) {
            this.mStrategyListener = strategyListener;
        }
        Integer strategyType = sRStrategyConfig.getStrategyType();
        if (strategyType != null) {
            this.mStrategyType = strategyType;
        }
        Integer screenWidth = sRStrategyConfig.getScreenWidth();
        if (screenWidth != null) {
            this.mScreenWidth = screenWidth;
        }
        Map<String, String> extraInfo = sRStrategyConfig.getExtraInfo();
        if (extraInfo != null) {
            this.mExtraInfo.putAll(extraInfo);
        }
        Object value = sRStrategyConfig.getValue(1, null);
        if (value != null) {
            this.mEffectBuddle = (Bundle) value;
        }
    }

    public Object getValue(int i, Object obj) {
        if (i == 1) {
            return this.mEffectBuddle;
        }
        return obj;
    }

    public SRStrategyConfig setDurationRangeSecond(long j, long j2) {
        this.mMinDuration = Long.valueOf(j);
        this.mMaxDuration = Long.valueOf(j2);
        return this;
    }

    public SRStrategyConfig setValue(int i, Object obj) {
        if (i == 1) {
            this.mEffectBuddle = (Bundle) obj;
        }
        return this;
    }
}
