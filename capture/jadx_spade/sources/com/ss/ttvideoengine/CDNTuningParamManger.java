package com.ss.ttvideoengine;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.setting.SettingsHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CDNTuningParamManger {
    private int mBitrate = -1;
    private boolean mBitrateEnable;
    private boolean mCdnTuningEnable;
    private boolean mDeviceIdEnable;
    private boolean mDeviceModelEnable;
    private String mFormat;
    private boolean mFormatEnable;
    private boolean mNetTypeEnable;
    private boolean mOSEnable;
    private boolean mRangeEnable;
    private boolean mTraceIdEnable;

    static {
        Covode.recordClassIndex(652249);
    }

    public boolean isCdnTuningEnable() {
        return this.mCdnTuningEnable;
    }

    CDNTuningParamManger() {
        updateSettings();
    }

    private String getParamNetType() {
        int currentAccessType = TTNetWorkListener.getInstance().getCurrentAccessType();
        int i = 1;
        if (currentAccessType != 0) {
            if (currentAccessType != 1) {
                i = 2;
                if (currentAccessType != 2) {
                    i = 3;
                    if (currentAccessType != 3) {
                        if (currentAccessType != 4) {
                            i = 6;
                            if (currentAccessType != 6) {
                                i = -1;
                            }
                        } else {
                            i = 5;
                        }
                    }
                }
            } else {
                i = 4;
            }
        }
        return String.valueOf(i);
    }

    public String getParam() {
        return getEncodeParam(this.mFormatEnable, this.mFormat) + "," + getEncodeParam(this.mRangeEnable, "1") + "," + getEncodeParam(this.mNetTypeEnable, getParamNetType()) + "," + getEncodeParam(this.mOSEnable, "1") + "," + getEncodeParam(this.mBitrateEnable, String.valueOf(this.mBitrate)) + "," + getEncodeParam(this.mDeviceModelEnable, Build.MODEL) + "," + getEncodeParam(this.mTraceIdEnable, "1") + "," + getEncodeParam(this.mDeviceIdEnable, "1");
    }

    private void updateSettings() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = false;
        if (SettingsHelper.helper().getVodInt("cdn_tuning_enable", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.mCdnTuningEnable = z;
        JSONObject vodJsonObject = SettingsHelper.helper().getVodJsonObject("cdn_tuning_param");
        if (vodJsonObject == null) {
            return;
        }
        if (vodJsonObject.optInt("format_enable") == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mFormatEnable = z2;
        if (vodJsonObject.optInt("range_enable") == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.mRangeEnable = z3;
        if (vodJsonObject.optInt("net_type_enable") == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.mNetTypeEnable = z4;
        if (vodJsonObject.optInt("os_enable") == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.mOSEnable = z5;
        if (vodJsonObject.optInt("bitrate_enable") == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.mBitrateEnable = z6;
        if (vodJsonObject.optInt("device_model_enable") == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        this.mDeviceModelEnable = z7;
        if (vodJsonObject.optInt("traceid_enable") == 1) {
            z8 = true;
        } else {
            z8 = false;
        }
        this.mTraceIdEnable = z8;
        if (vodJsonObject.optInt("deviceid_enable") == 1) {
            z9 = true;
        }
        this.mDeviceIdEnable = z9;
    }

    public void setBitrate(int i) {
        this.mBitrate = i;
    }

    public void setFormat(String str) {
        this.mFormat = str;
    }

    private String getEncodeParam(boolean z, String str) {
        if (!z) {
            return String.valueOf(0);
        }
        if (TextUtils.isEmpty(str)) {
            return String.valueOf(-1);
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return String.valueOf(-1);
        }
    }
}
