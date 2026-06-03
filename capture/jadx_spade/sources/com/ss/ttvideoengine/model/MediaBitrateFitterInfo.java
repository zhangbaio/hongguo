package com.ss.ttvideoengine.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MediaBitrateFitterInfo {
    private int mDuration;
    private float[] mFunctionParams = null;
    private int mFunctionType = 0;
    private int mHeaderSize;

    static {
        Covode.recordClassIndex(652546);
    }

    public int getDuration() {
        return this.mDuration;
    }

    public float[] getFunctionParams() {
        return this.mFunctionParams;
    }

    public int getFunctionType() {
        return this.mFunctionType;
    }

    public int getHeaderSize() {
        return this.mHeaderSize;
    }

    private int calculateSizeByFun2(float f) {
        float[] functionParams = getFunctionParams();
        if (functionParams.length != 3) {
            return 0;
        }
        double d = f;
        return (int) (((((functionParams[0] / Math.pow(d, functionParams[2])) + functionParams[1]) * d) * 1024.0d) / 8.0d);
    }

    private int calculateSize(float f) {
        float[] functionParams = getFunctionParams();
        getHeaderSize();
        if (functionParams.length > 50) {
            TTVideoEngineLog.e("FitterInfo", "bitrateFitterParams num: " + functionParams.length);
            return 0;
        }
        double d = 0.0d;
        for (int i = 0; i < functionParams.length; i++) {
            double d2 = 1.0d;
            for (int i2 = 0; i2 < (functionParams.length - i) - 1; i2++) {
                d2 *= f;
            }
            d += d2 * functionParams[i];
        }
        return (int) (((d * f) * 1024.0d) / 8.0d);
    }

    public int calculateSizeBySecond(float f) {
        if (this.mFunctionParams == null) {
            TTVideoEngineLog.e("FitterInfo", "fitter params empty");
            return 0;
        }
        if (f <= getDuration() && f > 0.0f) {
            int i = this.mFunctionType;
            if (i == 0) {
                return calculateSize(f);
            }
            if (i == 1) {
                return calculateSizeByFun2(f);
            }
            return calculateSize(f);
        }
        TTVideoEngineLog.e("FitterInfo", String.format("preload second:%f, fitter duration:%d", Float.valueOf(f), Integer.valueOf(getDuration())));
        return 0;
    }

    public void extractFields(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("func_params")) {
                JSONArray jSONArray = jSONObject.getJSONArray("func_params");
                if (jSONArray.length() <= 0) {
                    return;
                }
                this.mFunctionParams = new float[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.mFunctionParams[i] = (float) jSONArray.optDouble(i);
                }
            }
            this.mHeaderSize = jSONObject.optInt("header_size");
            this.mDuration = jSONObject.optInt("duration");
            this.mFunctionType = jSONObject.optInt("func_method");
        } catch (Exception e) {
            TTVideoEngineLog.d(e);
        }
    }
}
