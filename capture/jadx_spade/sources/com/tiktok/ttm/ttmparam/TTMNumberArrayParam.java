package com.tiktok.ttm.ttmparam;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTMNumberArrayParam extends ITTMParamData {
    private double[] doubleArray;
    private float[] floatArray;
    private int[] intArray;
    private long[] longArray;
    private final int type;

    static {
        Covode.recordClassIndex(654009);
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getType() {
        return this.type;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public int getArraySize() {
        int[] iArr = this.intArray;
        if (iArr != null) {
            return iArr.length;
        }
        float[] fArr = this.floatArray;
        if (fArr != null) {
            return fArr.length;
        }
        double[] dArr = this.doubleArray;
        if (dArr != null) {
            return dArr.length;
        }
        long[] jArr = this.longArray;
        if (jArr != null) {
            return jArr.length;
        }
        return 0;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public Object getInputData() {
        int[] iArr = this.intArray;
        if (iArr != null) {
            return iArr;
        }
        long[] jArr = this.longArray;
        if (jArr != null) {
            return jArr;
        }
        double[] dArr = this.doubleArray;
        if (dArr != null) {
            return dArr;
        }
        float[] fArr = this.floatArray;
        if (fArr != null) {
            return fArr;
        }
        return null;
    }

    public TTMNumberArrayParam(int[] iArr) {
        this.longArray = null;
        this.doubleArray = null;
        this.floatArray = null;
        this.type = 7;
        this.intArray = iArr;
    }

    public TTMNumberArrayParam(double[] dArr) {
        this.intArray = null;
        this.longArray = null;
        this.floatArray = null;
        this.type = 8;
        this.doubleArray = dArr;
    }

    public TTMNumberArrayParam(float[] fArr) {
        this.intArray = null;
        this.longArray = null;
        this.doubleArray = null;
        this.type = 8;
        this.floatArray = fArr;
    }

    public TTMNumberArrayParam(long[] jArr) {
        this.intArray = null;
        this.doubleArray = null;
        this.floatArray = null;
        this.type = 7;
        this.longArray = jArr;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double[] getAllDoubleValue(String str) {
        int[] iArr = this.intArray;
        int i = 0;
        if (iArr != null) {
            double[] dArr = new double[iArr.length];
            int length = iArr.length;
            int i2 = 0;
            while (i < length) {
                dArr[i2] = iArr[i];
                i++;
                i2++;
            }
            return dArr;
        }
        double[] dArr2 = this.doubleArray;
        if (dArr2 != null) {
            return dArr2;
        }
        long[] jArr = this.longArray;
        if (jArr != null) {
            double[] dArr3 = new double[jArr.length];
            int length2 = jArr.length;
            int i3 = 0;
            while (i < length2) {
                dArr3[i3] = jArr[i];
                i++;
                i3++;
            }
            return dArr3;
        }
        float[] fArr = this.floatArray;
        if (fArr != null) {
            double[] dArr4 = new double[fArr.length];
            int length3 = fArr.length;
            int i4 = 0;
            while (i < length3) {
                dArr4[i4] = fArr[i];
                i++;
                i4++;
            }
            return dArr4;
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long[] getAllIntValue(String str) {
        int[] iArr = this.intArray;
        int i = 0;
        if (iArr != null) {
            long[] jArr = new long[iArr.length];
            int length = iArr.length;
            int i2 = 0;
            while (i < length) {
                jArr[i2] = iArr[i];
                i++;
                i2++;
            }
            return jArr;
        }
        long[] jArr2 = this.longArray;
        if (jArr2 != null) {
            return jArr2;
        }
        double[] dArr = this.doubleArray;
        if (dArr != null) {
            long[] jArr3 = new long[dArr.length];
            int length2 = dArr.length;
            int i3 = 0;
            while (i < length2) {
                jArr3[i3] = (long) dArr[i];
                i++;
                i3++;
            }
            return jArr3;
        }
        float[] fArr = this.floatArray;
        if (fArr != null) {
            long[] jArr4 = new long[fArr.length];
            int length3 = fArr.length;
            int i4 = 0;
            while (i < length3) {
                jArr4[i4] = (long) fArr[i];
                i++;
                i4++;
            }
            return jArr4;
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public ITTMParamData getArrayItem(int i) {
        int[] iArr = this.intArray;
        int i2 = 0;
        if (iArr != null) {
            if (i < 0) {
                i2 = iArr.length + i;
            }
            if (i2 < 0 || i2 >= iArr.length) {
                return null;
            }
            return a.c(iArr[i]);
        }
        long[] jArr = this.longArray;
        if (jArr != null) {
            if (i < 0) {
                i2 = jArr.length + i;
            }
            if (i2 < 0 || i2 >= jArr.length) {
                return null;
            }
            return a.d(jArr[i]);
        }
        double[] dArr = this.doubleArray;
        if (dArr != null) {
            if (i < 0) {
                i2 = dArr.length + i;
            }
            if (i2 < 0 || i2 >= dArr.length) {
                return null;
            }
            return a.a(dArr[i]);
        }
        float[] fArr = this.floatArray;
        if (fArr != null) {
            if (i < 0) {
                i2 = fArr.length + i;
            }
            if (i2 >= 0 && i2 < fArr.length) {
                return a.b(fArr[i]);
            }
        }
        return null;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public double getDoubleValue(String str, int i) {
        if (i == Integer.MAX_VALUE) {
            return Double.MAX_VALUE;
        }
        int[] iArr = this.intArray;
        int i2 = 0;
        if (iArr != null) {
            if (i < 0) {
                i2 = iArr.length + i;
            }
            if (i2 < 0 || i2 >= iArr.length) {
                return Double.MAX_VALUE;
            }
            return iArr[i2];
        }
        long[] jArr = this.longArray;
        if (jArr != null) {
            if (i < 0) {
                i2 = jArr.length + i;
            }
            if (i2 < 0 || i2 >= jArr.length) {
                return Double.MAX_VALUE;
            }
            return jArr[i2];
        }
        float[] fArr = this.floatArray;
        if (fArr != null) {
            if (i < 0) {
                i2 = fArr.length + i;
            }
            if (i2 < 0 || i2 >= fArr.length) {
                return Double.MAX_VALUE;
            }
            return fArr[i2];
        }
        double[] dArr = this.doubleArray;
        if (dArr == null) {
            return Double.MAX_VALUE;
        }
        if (i < 0) {
            i2 = dArr.length + i;
        }
        if (i2 < 0 || i2 >= dArr.length) {
            return Double.MAX_VALUE;
        }
        return dArr[i2];
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public long getIntValue(String str, int i) {
        if (i != Integer.MAX_VALUE) {
            int[] iArr = this.intArray;
            int i2 = 0;
            if (iArr != null) {
                if (i < 0) {
                    i2 = iArr.length + i;
                }
                if (i2 < 0 || i2 >= iArr.length) {
                    return Long.MAX_VALUE;
                }
                return iArr[i2];
            }
            long[] jArr = this.longArray;
            if (jArr != null) {
                if (i < 0) {
                    i2 = jArr.length + i;
                }
                if (i2 < 0 || i2 >= jArr.length) {
                    return Long.MAX_VALUE;
                }
                return jArr[i2];
            }
            float[] fArr = this.floatArray;
            if (fArr != null) {
                if (i < 0) {
                    i2 = fArr.length + i;
                }
                if (i2 < 0 || i2 >= fArr.length) {
                    return Long.MAX_VALUE;
                }
                return (long) fArr[i2];
            }
            double[] dArr = this.doubleArray;
            if (dArr != null) {
                if (i < 0) {
                    i2 = dArr.length + i;
                }
                if (i2 >= 0 && i2 < dArr.length) {
                    return (long) dArr[i2];
                }
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // com.tiktok.ttm.ttmparam.ITTMParamData
    public boolean replaceValue(String str, int i, Object obj) {
        long j;
        long j2;
        long j3;
        long j4;
        if (i != Integer.MAX_VALUE && (obj instanceof Number)) {
            int[] iArr = this.intArray;
            if (iArr != null) {
                if (i < 0) {
                    j4 = iArr.length + i;
                } else {
                    j4 = 0;
                }
                if (j4 < 0 || j4 >= iArr.length) {
                    return false;
                }
                iArr[(int) j4] = ((Number) obj).intValue();
                return true;
            }
            long[] jArr = this.longArray;
            if (jArr != null) {
                if (i < 0) {
                    j3 = jArr.length + i;
                } else {
                    j3 = 0;
                }
                if (j3 < 0 || j3 >= jArr.length) {
                    return false;
                }
                jArr[(int) j3] = ((Number) obj).longValue();
                return true;
            }
            float[] fArr = this.floatArray;
            if (fArr != null) {
                if (i < 0) {
                    j2 = fArr.length + i;
                } else {
                    j2 = 0;
                }
                if (j2 < 0 || j2 >= fArr.length) {
                    return false;
                }
                fArr[(int) j2] = ((Number) obj).floatValue();
                return true;
            }
            double[] dArr = this.doubleArray;
            if (dArr != null) {
                if (i < 0) {
                    j = dArr.length + i;
                } else {
                    j = 0;
                }
                if (j >= 0 && j < dArr.length) {
                    dArr[(int) j] = ((Number) obj).doubleValue();
                    return true;
                }
            }
        }
        return false;
    }
}
