package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMStringArrayParam extends ITTMParamData {
    private String[] value;

    static {
        Covode.recordClassIndex(654015);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        return 9;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getArraySize() {
        return this.value.length;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        return this.value;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getAllStringValue(String str) {
        return this.value;
    }

    public TTMStringArrayParam(String[] strArr) {
        this.value = strArr;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public ITTMParamData getArrayItem(int i) {
        int i2;
        String[] strArr = this.value;
        if (strArr != null) {
            if (i < 0) {
                i2 = strArr.length + i;
            } else {
                i2 = 0;
            }
            if (i2 >= 0 && i2 < strArr.length) {
                return a.h(strArr[i]);
            }
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue(String str, int i) {
        String[] strArr;
        int i2;
        if (str == null && i != Integer.MAX_VALUE && (strArr = this.value) != null) {
            if (i < 0) {
                i2 = strArr.length + i;
            } else {
                i2 = 0;
            }
            if (i2 >= 0 && i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean replaceValue(String str, int i, Object obj) {
        String[] strArr;
        int i2;
        if (i != Integer.MAX_VALUE && (strArr = this.value) != null && (obj instanceof String)) {
            if (i < 0) {
                i2 = strArr.length + i;
            } else {
                i2 = 0;
            }
            if (i2 >= 0 && i2 < strArr.length) {
                strArr[i2] = (String) obj;
                return true;
            }
        }
        return false;
    }
}
