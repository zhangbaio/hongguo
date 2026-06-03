package com.tencent.tinker.android.utils;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SparseBoolArray implements Cloneable {
    private static final boolean[] EMPTY_BOOL_ARRAY;
    private static final int[] EMPTY_INT_ARRAY;
    private int[] mKeys;
    private int mSize;
    private boolean[] mValues;

    private static int growSize(int i) {
        if (i <= 4) {
            return 8;
        }
        return i + (i >> 1);
    }

    public void clear() {
        this.mSize = 0;
    }

    public static class KeyNotFoundException extends Exception {
        static {
            Covode.recordClassIndex(653644);
        }

        public KeyNotFoundException() {
        }

        public KeyNotFoundException(String str) {
            super(str);
        }
    }

    public int size() {
        return this.mSize;
    }

    public SparseBoolArray() {
        this(10);
    }

    static {
        Covode.recordClassIndex(653643);
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_BOOL_ARRAY = new boolean[0];
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseBoolArray m46clone() {
        SparseBoolArray sparseBoolArray = null;
        try {
            SparseBoolArray sparseBoolArray2 = (SparseBoolArray) super.clone();
            try {
                sparseBoolArray2.mKeys = (int[]) this.mKeys.clone();
                sparseBoolArray2.mValues = (boolean[]) this.mValues.clone();
                return sparseBoolArray2;
            } catch (CloneNotSupportedException unused) {
                sparseBoolArray = sparseBoolArray2;
                return sparseBoolArray;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i));
            sb.append('=');
            sb.append(valueAt(i));
        }
        sb.append('}');
        return sb.toString();
    }

    public int keyAt(int i) {
        return this.mKeys[i];
    }

    public boolean valueAt(int i) {
        return this.mValues[i];
    }

    public boolean containsKey(int i) {
        if (indexOfKey(i) >= 0) {
            return true;
        }
        return false;
    }

    public void delete(int i) {
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            removeAt(binarySearch);
        }
    }

    public int indexOfKey(int i) {
        return binarySearch(this.mKeys, this.mSize, i);
    }

    public SparseBoolArray(int i) {
        if (i == 0) {
            this.mKeys = EMPTY_INT_ARRAY;
            this.mValues = EMPTY_BOOL_ARRAY;
        } else {
            this.mKeys = new int[i];
            this.mValues = new boolean[i];
        }
        this.mSize = 0;
    }

    public int indexOfValue(boolean z) {
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == z) {
                return i;
            }
        }
        return -1;
    }

    public void removeAt(int i) {
        int[] iArr = this.mKeys;
        int i2 = i + 1;
        System.arraycopy(iArr, i2, iArr, i, this.mSize - i2);
        boolean[] zArr = this.mValues;
        System.arraycopy(zArr, i2, zArr, i, this.mSize - i2);
        this.mSize--;
    }

    public boolean get(int i) throws KeyNotFoundException {
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            return this.mValues[binarySearch];
        }
        throw new KeyNotFoundException("" + i);
    }

    public void append(int i, boolean z) {
        int i2 = this.mSize;
        if (i2 != 0 && i <= this.mKeys[i2 - 1]) {
            put(i, z);
            return;
        }
        this.mKeys = appendElementIntoIntArray(this.mKeys, i2, i);
        this.mValues = appendElementIntoBoolArray(this.mValues, this.mSize, z);
        this.mSize++;
    }

    public void put(int i, boolean z) {
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = z;
            return;
        }
        int i2 = ~binarySearch;
        this.mKeys = insertElementIntoIntArray(this.mKeys, this.mSize, i2, i);
        this.mValues = insertElementIntoBoolArray(this.mValues, this.mSize, i2, z);
        this.mSize++;
    }

    private int binarySearch(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else if (i6 > i2) {
                i3 = i5 - 1;
            } else {
                return i5;
            }
        }
        return ~i4;
    }

    private boolean[] appendElementIntoBoolArray(boolean[] zArr, int i, boolean z) {
        if (i <= zArr.length) {
            if (i + 1 > zArr.length) {
                boolean[] zArr2 = new boolean[growSize(i)];
                System.arraycopy(zArr, 0, zArr2, 0, i);
                zArr = zArr2;
            }
            zArr[i] = z;
            return zArr;
        }
        throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i);
    }

    private int[] appendElementIntoIntArray(int[] iArr, int i, int i2) {
        if (i <= iArr.length) {
            if (i + 1 > iArr.length) {
                int[] iArr2 = new int[growSize(i)];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                iArr = iArr2;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
    }

    private boolean[] insertElementIntoBoolArray(boolean[] zArr, int i, int i2, boolean z) {
        if (i <= zArr.length) {
            if (i + 1 <= zArr.length) {
                System.arraycopy(zArr, i2, zArr, i2 + 1, i - i2);
                zArr[i2] = z;
                return zArr;
            }
            boolean[] zArr2 = new boolean[growSize(i)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            zArr2[i2] = z;
            System.arraycopy(zArr, i2, zArr2, i2 + 1, zArr.length - i2);
            return zArr2;
        }
        throw new IllegalArgumentException("Bad currentSize, originalSize: " + zArr.length + " currentSize: " + i);
    }

    private int[] insertElementIntoIntArray(int[] iArr, int i, int i2, int i3) {
        if (i <= iArr.length) {
            if (i + 1 <= iArr.length) {
                System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
                iArr[i2] = i3;
                return iArr;
            }
            int[] iArr2 = new int[growSize(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr2[i2] = i3;
            System.arraycopy(iArr, i2, iArr2, i2 + 1, iArr.length - i2);
            return iArr2;
        }
        throw new IllegalArgumentException("Bad currentSize, originalSize: " + iArr.length + " currentSize: " + i);
    }
}
