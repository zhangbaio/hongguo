package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMNumberParam extends ITTMParamData {
    private int type;
    private Number value;

    static {
        Covode.recordClassIndex(654011);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        return this.value;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        return this.type;
    }

    public TTMNumberParam(Number number) {
        this.value = number;
        if ((number instanceof Integer) || (number instanceof Long)) {
            this.type = 4;
        } else if ((number instanceof Double) || (number instanceof Float)) {
            this.type = 5;
        }
    }

    public TTMNumberParam(boolean z) {
        this.value = Integer.valueOf(z ? 1 : 0);
        this.type = 4;
    }

    public TTMNumberParam(Long l) {
        this.value = l;
        this.type = 4;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getArraySize() {
        if (this.value == null) {
            return 0;
        }
        return 1;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue() {
        Number number = this.value;
        if (number != null) {
            return number.doubleValue();
        }
        return Double.MAX_VALUE;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue() {
        Number number = this.value;
        if (number != null) {
            return number.longValue();
        }
        return Long.MAX_VALUE;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue() {
        try {
            Number number = this.value;
            if (number != null) {
                if (this.type == 4) {
                    return String.valueOf(number.longValue());
                }
                return String.valueOf(number.doubleValue());
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public TTMNumberParam(double d) {
        this.value = Double.valueOf(d);
        this.type = 5;
    }

    public TTMNumberParam(float f) {
        this.value = Float.valueOf(f);
        this.type = 5;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getAllDoubleValue(String str) {
        Number number = this.value;
        if (number == null) {
            return null;
        }
        return new double[]{number.doubleValue()};
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getAllIntValue(String str) {
        Number number = this.value;
        if (number == null) {
            return null;
        }
        return new long[]{number.longValue()};
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getAllStringValue(String str) {
        try {
            Number number = this.value;
            if (number == null) {
                return null;
            }
            return new String[]{String.valueOf(number.doubleValue())};
        } catch (Exception unused) {
            return null;
        }
    }

    public TTMNumberParam(int i) {
        this.value = Integer.valueOf(i);
        this.type = 4;
    }

    public TTMNumberParam(long j) {
        this.value = Long.valueOf(j);
        this.type = 4;
    }

    public TTMNumberParam(Boolean bool) {
        this.value = Integer.valueOf(bool.booleanValue() ? 1 : 0);
        this.type = 4;
    }

    public TTMNumberParam(Double d) {
        this.value = d;
        this.type = 5;
    }

    public TTMNumberParam(Float f) {
        this.value = f;
        this.type = 5;
    }

    public TTMNumberParam(Integer num) {
        this.value = num;
        this.type = 4;
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
        return getStringValue();
    }
}
