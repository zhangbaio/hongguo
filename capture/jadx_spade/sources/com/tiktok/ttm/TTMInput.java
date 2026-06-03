package com.tiktok.ttm;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMInput {
    public long extendedFunc;
    public String machineCode;
    public long machineCodeAddress = 0;
    public byte[] machineCodeByte;
    public long nativeParamAddress;
    public TTMParamData paramData;
    public ParamType paramType;
    public TTMContext ttmContext;

    static {
        Covode.recordClassIndex(653992);
    }

    public enum ParamType {
        VOID(0),
        TYPE_MAP(10),
        TYPE_JSON(11),
        TYPE_NATIVE_JSON_PARAM(12),
        TYPE_NATIVE_PARAM(13);

        final int typeVal;

        static {
            Covode.recordClassIndex(653993);
        }

        ParamType(int i) {
            this.typeVal = i;
        }
    }
}
