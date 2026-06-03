package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMStringParam extends ITTMParamData {
    private String value;

    static {
        Covode.recordClassIndex(654016);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        return 6;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        return this.value;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue() {
        return this.value;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue() {
        try {
            String str = this.value;
            if (str == null) {
                return Double.MAX_VALUE;
            }
            return Double.parseDouble(str);
        } catch (Exception unused) {
            return Double.MAX_VALUE;
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue() {
        try {
            String str = this.value;
            if (str == null) {
                return Long.MAX_VALUE;
            }
            return Long.parseLong(str);
        } catch (Exception unused) {
            return Long.MAX_VALUE;
        }
    }

    public TTMStringParam(String str) {
        this.value = str;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue(String str, int i) {
        return getDoubleValue();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue(String str, int i) {
        return getIntValue();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue(String str, int i) {
        return this.value;
    }
}
