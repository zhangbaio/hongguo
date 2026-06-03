package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMNumberObjectArrayParam extends ITTMParamData {
    private Number[] inputValue;
    private int type;

    static {
        Covode.recordClassIndex(654010);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        return this.inputValue;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        return this.type;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getArraySize() {
        Number[] numberArr = this.inputValue;
        if (numberArr != null) {
            return numberArr.length;
        }
        return 0;
    }

    public TTMNumberObjectArrayParam(Double[] dArr) {
        this.inputValue = dArr;
        this.type = 8;
    }

    public TTMNumberObjectArrayParam(Float[] fArr) {
        this.inputValue = fArr;
        this.type = 8;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getAllDoubleValue(String str) {
        Number[] numberArr = this.inputValue;
        if (numberArr != null) {
            double[] dArr = new double[numberArr.length];
            int length = numberArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                dArr[i2] = numberArr[i].doubleValue();
                i++;
                i2++;
            }
            return dArr;
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getAllIntValue(String str) {
        Number[] numberArr = this.inputValue;
        if (numberArr != null) {
            long[] jArr = new long[numberArr.length];
            int length = numberArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                jArr[i2] = numberArr[i].longValue();
                i++;
                i2++;
            }
            return jArr;
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public ITTMParamData getArrayItem(int i) {
        Number[] numberArr = this.inputValue;
        if (numberArr != null) {
            if (i < 0) {
                i += numberArr.length;
            }
            if (i >= 0 && i < numberArr.length) {
                return a.f(numberArr[i]);
            }
        }
        return null;
    }

    public TTMNumberObjectArrayParam(Integer[] numArr) {
        this.inputValue = numArr;
        this.type = 7;
    }

    public TTMNumberObjectArrayParam(Long[] lArr) {
        this.inputValue = lArr;
        this.type = 7;
    }

    public TTMNumberObjectArrayParam(Number[] numberArr) {
        this.type = 0;
        if (!(numberArr instanceof Integer[]) && !(numberArr instanceof Long[])) {
            if ((numberArr instanceof Float[]) || (numberArr instanceof Double[])) {
                this.type = 8;
                this.inputValue = numberArr;
                return;
            }
            return;
        }
        this.type = 7;
        this.inputValue = numberArr;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue(String str, int i) {
        Number[] numberArr = this.inputValue;
        if (numberArr != null) {
            if (i < 0) {
                i += numberArr.length;
            }
            if (i >= 0 && i < numberArr.length) {
                return numberArr[i].doubleValue();
            }
        }
        return Double.MAX_VALUE;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue(String str, int i) {
        Number[] numberArr = this.inputValue;
        if (numberArr != null) {
            if (i < 0) {
                i += numberArr.length;
            }
            if (i >= 0 && i < numberArr.length) {
                return numberArr[i].longValue();
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean replaceValue(String str, int i, Object obj) {
        Number[] numberArr;
        if (i != Integer.MAX_VALUE && (numberArr = this.inputValue) != null) {
            long j = i;
            if (i < 0) {
                j = numberArr.length + i;
            }
            if (j >= 0 && j < numberArr.length) {
                numberArr[(int) j] = (Number) obj;
                return true;
            }
        }
        return false;
    }
}
