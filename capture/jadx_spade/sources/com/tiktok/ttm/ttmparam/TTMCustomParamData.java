package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;
import com.tiktok.ttm.TTMParamData;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMCustomParamData extends ITTMParamData {
    private final ITTMParamData actualParamData;

    static {
        Covode.recordClassIndex(654004);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getArraySize() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return 0;
        }
        return iTTMParamData.getArraySize();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getDictDoubleValuesImmediate() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getDictDoubleValuesImmediate();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getDictIntValuesImmediate() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getDictIntValuesImmediate();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getDictKeys() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getDictKeys();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getDictStringValuesImmediate() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getDictStringValuesImmediate();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object[] getDictValuesImmediate() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getDictValuesImmediate();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return Double.MAX_VALUE;
        }
        return iTTMParamData.getDoubleValue();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getInputData();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return Long.MAX_VALUE;
        }
        return iTTMParamData.getIntValue();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getStringValue();
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return 13;
        }
        return iTTMParamData.getType();
    }

    public TTMCustomParamData(ITTMParamData iTTMParamData) {
        this.actualParamData = iTTMParamData;
    }

    public void AddArrayItem(TTMParamData tTMParamData) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return;
        }
        iTTMParamData.addArrayItem(tTMParamData.getActualParamData());
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean containsKey(String str) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData != null) {
            return iTTMParamData.containsKey(str);
        }
        return false;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getAllDoubleValue(String str) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getAllDoubleValue(str);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getAllIntValue(String str) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getAllIntValue(str);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getAllStringValue(String str) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getAllStringValue(str);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public ITTMParamData getArrayItem(int i) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return a.g(iTTMParamData.getArrayItem(i));
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public ITTMParamData getObjectItem(String str) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return a.g(iTTMParamData.getObjectItem(str));
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public void removeData(String str) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return;
        }
        iTTMParamData.removeData(str);
    }

    public void mergeDataAsSubData(String str, TTMParamData tTMParamData) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return;
        }
        iTTMParamData.mergeDataAsSubData(str, tTMParamData.getActualParamData());
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean removeValue(String str, int i) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return false;
        }
        return iTTMParamData.removeValue(str, i);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue(String str, int i) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return Double.MAX_VALUE;
        }
        return iTTMParamData.getDoubleValue(str, i);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue(String str, int i) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return Long.MAX_VALUE;
        }
        return iTTMParamData.getIntValue(str, i);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue(String str, int i) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return null;
        }
        return iTTMParamData.getStringValue(str, i);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean addValue(String str, int i, Object obj) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return false;
        }
        return iTTMParamData.addValue(str, i, obj);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean replaceValue(String str, int i, Object obj) {
        ITTMParamData iTTMParamData = this.actualParamData;
        if (iTTMParamData == null) {
            return false;
        }
        return iTTMParamData.replaceValue(str, i, obj);
    }
}
