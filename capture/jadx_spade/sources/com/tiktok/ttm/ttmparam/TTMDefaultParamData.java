package com.tiktok.ttm.ttmparam;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class TTMDefaultParamData extends ITTMParamData {
    private final Object inputData;
    private final int type = 5;

    static {
        Covode.recordClassIndex(654005);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        return this.inputData;
    }

    public TTMDefaultParamData(int[] iArr) {
        this.inputData = iArr;
    }

    public TTMDefaultParamData(long[] jArr) {
        this.inputData = jArr;
    }

    public TTMDefaultParamData(double[] dArr) {
        this.inputData = dArr;
    }

    public TTMDefaultParamData(float[] fArr) {
        this.inputData = fArr;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getDictKeys() {
        if (this.type != 0) {
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java getDictKeys unexpected usage scenarios.");
                return null;
            }
            return null;
        }
        Set keySet = ((Map) this.inputData).keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getDictStringValuesImmediate() {
        Object obj;
        if (this.type == 0 && (obj = this.inputData) != null) {
            Collection values = ((Map) obj).values();
            String[] strArr = new String[values.size()];
            Iterator it2 = values.iterator();
            int i = 0;
            while (it2.hasNext()) {
                strArr[i] = (String) it2.next();
                i++;
            }
            return strArr;
        }
        if (b.a) {
            Log.d("TTM/ParamData", ">>> Java jniGetDictValuesImmediate unexpected usage scenarios.");
            return null;
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object[] getDictValuesImmediate() {
        if (this.type != 0) {
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java getDictValuesImmediate unexpected usage scenarios.");
                return null;
            }
            return null;
        }
        Collection values = ((Map) this.inputData).values();
        return values.toArray(new Object[values.size()]);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String getStringValue() {
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("GetStringValue");
        try {
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java GetStringValue: ");
            }
            if (this.type != 2) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java GetStringValue Return Default: ");
                }
            }
            String str = (String) this.inputData;
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
            return str;
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getDictDoubleValuesImmediate() {
        Object obj;
        if (this.type == 0 && (obj = this.inputData) != null) {
            Collection values = ((Map) obj).values();
            double[] dArr = new double[values.size()];
            int i = 0;
            for (Object obj2 : values) {
                if (obj2 instanceof Number) {
                    dArr[i] = ((Number) obj2).doubleValue();
                    i++;
                } else {
                    dArr[i] = -1.0d;
                    i++;
                }
            }
            return dArr;
        }
        if (b.a) {
            Log.d("TTM/ParamData", ">>> Java jniGetDictValuesImmediate unexpected usage scenarios.");
            return null;
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getDictIntValuesImmediate() {
        Object obj;
        int i;
        long j;
        if (this.type == 0 && (obj = this.inputData) != null) {
            Collection values = ((Map) obj).values();
            long[] jArr = new long[values.size()];
            int i2 = 0;
            for (Object obj2 : values) {
                if (obj2 instanceof Boolean) {
                    i = i2 + 1;
                    if (((Boolean) obj2).booleanValue()) {
                        j = 1;
                    } else {
                        j = 0;
                    }
                    jArr[i2] = j;
                } else if (obj2 instanceof Number) {
                    i = i2 + 1;
                    jArr[i2] = ((Number) obj2).longValue();
                } else {
                    jArr[i2] = -1;
                    i2++;
                }
                i2 = i;
            }
            return jArr;
        }
        if (b.a) {
            Log.d("TTM/ParamData", ">>> Java jniGetDictValuesImmediate unexpected usage scenarios.");
            return null;
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue() {
        double d;
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("GetDoubleValue");
        try {
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java GetIntValue: ");
            }
            int i = this.type;
            if (i == 2 || i == 4 || i == 5) {
                Object obj = this.inputData;
                if (obj instanceof Boolean) {
                    if (((Boolean) obj).booleanValue()) {
                        d = 1.0d;
                    } else {
                        d = 0.0d;
                    }
                    if (createAndStart != null) {
                        createAndStart.endAndPrint();
                    }
                    return d;
                }
                if (obj instanceof Number) {
                    double doubleValue = ((Number) obj).doubleValue();
                    if (createAndStart != null) {
                        createAndStart.endAndPrint();
                    }
                    return doubleValue;
                }
            }
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java GetDoubleValue return default value ");
            }
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue() {
        long j;
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("GetIntValue");
        try {
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java GetIntValue: ");
            }
            int i = this.type;
            if (i == 2 || i == 4 || i == 5) {
                Object obj = this.inputData;
                if (obj instanceof Boolean) {
                    if (((Boolean) obj).booleanValue()) {
                        j = 1;
                    } else {
                        j = 0;
                    }
                    if (createAndStart != null) {
                        createAndStart.endAndPrint();
                    }
                    return j;
                }
                if (obj instanceof Number) {
                    long longValue = ((Number) obj).longValue();
                    if (createAndStart != null) {
                        createAndStart.endAndPrint();
                    }
                    return longValue;
                }
            }
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java GetIntValue return default value ");
            }
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        int i = this.type;
        if (i == 2) {
            Object obj = this.inputData;
            if (obj == null) {
                return 13;
            }
            if (obj instanceof Collection) {
                return 1;
            }
            if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Boolean)) {
                if (!(obj instanceof Float) && !(obj instanceof Double)) {
                    if (obj instanceof String) {
                        return 6;
                    }
                    if (obj instanceof String[]) {
                        return 9;
                    }
                    if (!(obj instanceof Integer[]) && !(obj instanceof int[]) && !(obj instanceof Long[]) && !(obj instanceof long[])) {
                        if ((obj instanceof Double[]) || (obj instanceof double[]) || (obj instanceof Float[]) || (obj instanceof float[])) {
                            return 8;
                        }
                        return i;
                    }
                    return 7;
                }
                return 5;
            }
            return 4;
        }
        return i;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getArraySize() {
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("GetArraySize");
        try {
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java GetArraySize: ");
            }
            Object obj = this.inputData;
            if (obj == null) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java GetArraySize Return Default");
                }
                return -1;
            }
            if (obj instanceof Collection) {
                int size = ((Collection) obj).size();
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return size;
            }
            if (obj instanceof Object[]) {
                int length = ((Object[]) obj).length;
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return length;
            }
            if (obj instanceof int[]) {
                int length2 = ((int[]) obj).length;
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return length2;
            }
            if (obj instanceof long[]) {
                int length3 = ((long[]) obj).length;
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return length3;
            }
            if (obj instanceof double[]) {
                int length4 = ((double[]) obj).length;
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return length4;
            }
            if (obj instanceof float[]) {
                int length5 = ((float[]) obj).length;
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return length5;
            }
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java GetArraySize Return Default");
            }
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
            return -1;
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    public TTMDefaultParamData(double d) {
        this.inputData = Double.valueOf(d);
    }

    public TTMDefaultParamData(float f) {
        this.inputData = Float.valueOf(f);
    }

    public TTMDefaultParamData(int i) {
        this.inputData = Integer.valueOf(i);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public void addArrayItem(ITTMParamData iTTMParamData) {
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("AddArrayItem");
        try {
            if (this.type != 1) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java AddArrayItem unexpected usage scenarios.");
                }
            } else {
                ((Collection) this.inputData).add(Long.valueOf(iTTMParamData.getIntValue()));
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
            }
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public void removeData(String str) {
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("removeData");
        try {
            if (this.type != 0) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java removeData unexpected usage scenarios.");
                }
            } else {
                ((Map) this.inputData).remove(str);
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
            }
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    public TTMDefaultParamData(long j) {
        this.inputData = Long.valueOf(j);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public ITTMParamData getObjectItem(String str) {
        Object obj;
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("GetObjectItem");
        try {
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java GetObjectItem: " + str);
            }
            if (this.type == 0 && (obj = this.inputData) != null) {
                return a.g(((Map) obj).get(str));
            }
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java GetObjectItem Return Default: " + str);
            }
            if (createAndStart != null) {
                createAndStart.endAndPrint();
                return null;
            }
            return null;
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    public TTMDefaultParamData(Object obj) {
        this.inputData = obj;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public String[] getAllStringValue(String str) {
        Object obj;
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("jniGetAllStringValue");
        try {
            if (str != null) {
                obj = ((Map) this.inputData).get(str);
            } else {
                obj = this.inputData;
            }
            int i = 0;
            if (obj instanceof Collection) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllStringValue Collection: " + str);
                }
                String[] strArr = new String[((Collection) obj).size()];
                Iterator it2 = ((Collection) obj).iterator();
                while (it2.hasNext()) {
                    int i2 = i + 1;
                    strArr[i] = (String) it2.next();
                    i = i2;
                }
                return strArr;
            }
            if (obj instanceof String[]) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllStringValue String[]: " + str);
                }
                String[] strArr2 = (String[]) obj;
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return strArr2;
            }
            if (obj instanceof Object[]) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllStringValue Object[]: " + str);
                }
                String[] strArr3 = new String[((Object[]) obj).length];
                Object[] objArr = (Object[]) obj;
                int length = objArr.length;
                int i3 = 0;
                while (i < length) {
                    int i4 = i3 + 1;
                    strArr3[i3] = objArr[i].toString();
                    i++;
                    i3 = i4;
                }
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return strArr3;
            }
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java jniGetAllStringValue Return Default: ");
            }
            if (createAndStart != null) {
                createAndStart.endAndPrint();
                return null;
            }
            return null;
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    public TTMDefaultParamData(Collection<Object> collection) {
        this.inputData = collection;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getAllDoubleValue(String str) {
        Object obj;
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("jniGetAllDoubleValue");
        try {
            if (str != null) {
                obj = ((Map) this.inputData).get(str);
            } else {
                obj = this.inputData;
            }
            int i = 0;
            if (obj instanceof Collection) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllDoubleValue Collection:" + str);
                }
                double[] dArr = new double[((Collection) obj).size()];
                for (Object obj2 : (Collection) obj) {
                    if (obj2 instanceof Number) {
                        dArr[i] = ((Number) obj2).doubleValue();
                        i++;
                    } else {
                        int i2 = i + 1;
                        dArr[i] = -1.0d;
                        i = i2;
                    }
                }
                return dArr;
            }
            if (obj instanceof Object[]) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllDoubleValue Object[]:" + str);
                }
                double[] dArr2 = new double[((Object[]) obj).length];
                Object[] objArr = (Object[]) obj;
                int length = objArr.length;
                int i3 = 0;
                while (i < length) {
                    Object obj3 = objArr[i];
                    if (obj3 instanceof Number) {
                        dArr2[i3] = ((Number) obj3).doubleValue();
                        i3++;
                    } else {
                        int i4 = i3 + 1;
                        dArr2[i3] = -1.0d;
                        i3 = i4;
                    }
                    i++;
                }
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return dArr2;
            }
            if (obj instanceof double[]) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllDoubleValue double[]:" + str);
                }
                double[] dArr3 = (double[]) obj;
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return dArr3;
            }
            if (obj instanceof float[]) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllDoubleValue float[]:" + str);
                }
                double[] dArr4 = new double[((float[]) obj).length];
                int length2 = ((float[]) obj).length;
                int i5 = 0;
                while (i < length2) {
                    int i6 = i5 + 1;
                    dArr4[i5] = r1[i];
                    i++;
                    i5 = i6;
                }
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return dArr4;
            }
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java jniGetAllDoubleValue Return Default: ");
            }
            if (createAndStart != null) {
                createAndStart.endAndPrint();
                return null;
            }
            return null;
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getAllIntValue(String str) {
        Object obj;
        int i;
        long j;
        int i2;
        long j2;
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("jniGetAllIntValue");
        try {
            if (str != null) {
                obj = ((Map) this.inputData).get(str);
            } else {
                obj = this.inputData;
            }
            int i3 = 0;
            if (obj instanceof Collection) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllIntValue Collection:  " + str);
                }
                long[] jArr = new long[((Collection) obj).size()];
                for (Object obj2 : (Collection) obj) {
                    if (obj2 instanceof Boolean) {
                        i2 = i3 + 1;
                        if (((Boolean) obj2).booleanValue()) {
                            j2 = 1;
                        } else {
                            j2 = 0;
                        }
                        jArr[i3] = j2;
                    } else if (obj2 instanceof Number) {
                        i2 = i3 + 1;
                        jArr[i3] = ((Number) obj2).longValue();
                    } else {
                        int i4 = i3 + 1;
                        jArr[i3] = -1;
                        i3 = i4;
                    }
                    i3 = i2;
                }
                return jArr;
            }
            if (obj instanceof Object[]) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllIntValue Object[]:  " + str);
                }
                long[] jArr2 = new long[((Object[]) obj).length];
                Object[] objArr = (Object[]) obj;
                int length = objArr.length;
                int i5 = 0;
                while (i3 < length) {
                    Object obj3 = objArr[i3];
                    if (obj3 instanceof Boolean) {
                        i = i5 + 1;
                        if (((Boolean) obj3).booleanValue()) {
                            j = 1;
                        } else {
                            j = 0;
                        }
                        jArr2[i5] = j;
                    } else if (obj3 instanceof Number) {
                        i = i5 + 1;
                        jArr2[i5] = ((Number) obj3).longValue();
                    } else {
                        int i6 = i5 + 1;
                        jArr2[i5] = -1;
                        i5 = i6;
                        i3++;
                    }
                    i5 = i;
                    i3++;
                }
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return jArr2;
            }
            if (obj instanceof int[]) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllIntValue int[]:  " + str);
                }
                long[] jArr3 = new long[((int[]) obj).length];
                int length2 = ((int[]) obj).length;
                int i7 = 0;
                while (i3 < length2) {
                    int i8 = i7 + 1;
                    jArr3[i7] = r3[i3];
                    i3++;
                    i7 = i8;
                }
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return jArr3;
            }
            if (obj instanceof long[]) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java jniGetAllIntValue long[]:  " + str);
                }
                long[] jArr4 = (long[]) obj;
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
                return jArr4;
            }
            if (b.a) {
                Log.d("TTM/ParamData", ">>> Java jniGetAllIntValue Return Default: ");
            }
            if (createAndStart != null) {
                createAndStart.endAndPrint();
                return null;
            }
            return null;
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0128, code lost:
    
        r0.endAndPrint();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005c, code lost:
    
        r0.endAndPrint();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
    
        r0.endAndPrint();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ae, code lost:
    
        r0.endAndPrint();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00ff, code lost:
    
        r0.endAndPrint();
     */
    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.tiktok.ttm.ttmparam.ITTMParamData getArrayItem(int r7) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tiktok.ttm.ttmparam.TTMDefaultParamData.getArrayItem(int):com.tiktok.ttm.ttmparam.ITTMParamData");
    }

    public TTMDefaultParamData(Map<String, Object> map) {
        this.inputData = map;
    }

    public TTMDefaultParamData(boolean z) {
        this.inputData = Integer.valueOf(z ? 1 : 0);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public void mergeDataAsSubData(String str, ITTMParamData iTTMParamData) {
        TTMPrefMetric createAndStart = TTMPrefMetric.createAndStart("mergeDataAsSubData");
        try {
            if (this.type != 0) {
                if (b.a) {
                    Log.d("TTM/ParamData", ">>> Java mergeDataAsSubData unexpected usage scenarios.");
                }
            } else {
                ((Map) this.inputData).put(str, iTTMParamData.getInputData());
                if (createAndStart != null) {
                    createAndStart.endAndPrint();
                }
            }
        } finally {
            if (createAndStart != null) {
                createAndStart.endAndPrint();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ca, code lost:
    
        r0.endAndPrint();
     */
    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double getDoubleValue(java.lang.String r9, int r10) {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tiktok.ttm.ttmparam.TTMDefaultParamData.getDoubleValue(java.lang.String, int):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d5, code lost:
    
        r0.endAndPrint();
     */
    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getStringValue(java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tiktok.ttm.ttmparam.TTMDefaultParamData.getStringValue(java.lang.String, int):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d8, code lost:
    
        r0.endAndPrint();
     */
    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long getIntValue(java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tiktok.ttm.ttmparam.TTMDefaultParamData.getIntValue(java.lang.String, int):long");
    }
}
