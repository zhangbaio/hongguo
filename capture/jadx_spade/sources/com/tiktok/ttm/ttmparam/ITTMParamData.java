package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class ITTMParamData {
    static {
        Covode.recordClassIndex(654002);
    }

    public void addArrayItem(ITTMParamData iTTMParamData) {
    }

    public boolean addValue(String str, int i, Object obj) {
        return false;
    }

    public boolean containsKey(String str) {
        return false;
    }

    public double[] getAllDoubleValue(String str) {
        return null;
    }

    public long[] getAllIntValue(String str) {
        return null;
    }

    public String[] getAllStringValue(String str) {
        return null;
    }

    public ITTMParamData getArrayItem(int i) {
        return null;
    }

    public int getArraySize() {
        return 0;
    }

    public double[] getDictDoubleValuesImmediate() {
        return null;
    }

    public long[] getDictIntValuesImmediate() {
        return null;
    }

    public String[] getDictKeys() {
        return null;
    }

    public String[] getDictStringValuesImmediate() {
        return null;
    }

    public Object[] getDictValuesImmediate() {
        return null;
    }

    public double getDoubleValue() {
        return Double.MAX_VALUE;
    }

    public double getDoubleValue(String str, int i) {
        return Double.MAX_VALUE;
    }

    public Object getInputData() {
        return this;
    }

    public long getIntValue() {
        return Long.MAX_VALUE;
    }

    public long getIntValue(String str, int i) {
        return Long.MAX_VALUE;
    }

    public ITTMParamData getObjectItem(String str) {
        return null;
    }

    public String getStringValue() {
        return null;
    }

    public String getStringValue(String str, int i) {
        return null;
    }

    public int getType() {
        return 14;
    }

    public void mergeDataAsSubData(String str, ITTMParamData iTTMParamData) {
    }

    public void removeData(String str) {
    }

    public boolean removeValue(String str, int i) {
        return false;
    }

    public boolean replaceValue(String str, int i, Object obj) {
        return false;
    }
}
