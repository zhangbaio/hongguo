package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ClassData extends TableOfContents.Section.Item<ClassData> {
    public Method[] directMethods;
    public Field[] instanceFields;
    public Field[] staticFields;
    public Method[] virtualMethods;

    static {
        Covode.recordClassIndex(653587);
    }

    public static class Field implements Comparable<Field> {
        public int accessFlags;
        public int fieldIndex;

        static {
            Covode.recordClassIndex(653588);
        }

        public int hashCode() {
            return HashCodeHelper.hash(Integer.valueOf(this.fieldIndex), Integer.valueOf(this.accessFlags));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Field) || compareTo((Field) obj) != 0) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(Field field) {
            int uCompare = CompareUtils.uCompare(this.fieldIndex, field.fieldIndex);
            if (uCompare != 0) {
                return uCompare;
            }
            return CompareUtils.sCompare(this.accessFlags, field.accessFlags);
        }

        public Field(int i, int i2) {
            this.fieldIndex = i;
            this.accessFlags = i2;
        }
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(this.staticFields, this.instanceFields, this.directMethods, this.virtualMethods);
    }

    public static class Method implements Comparable<Method> {
        public int accessFlags;
        public int codeOffset;
        public int methodIndex;

        static {
            Covode.recordClassIndex(653589);
        }

        public int hashCode() {
            return HashCodeHelper.hash(Integer.valueOf(this.methodIndex), Integer.valueOf(this.accessFlags), Integer.valueOf(this.codeOffset));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Method) || compareTo((Method) obj) != 0) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Comparable
        public int compareTo(Method method) {
            int uCompare = CompareUtils.uCompare(this.methodIndex, method.methodIndex);
            if (uCompare != 0) {
                return uCompare;
            }
            int sCompare = CompareUtils.sCompare(this.accessFlags, method.accessFlags);
            if (sCompare != 0) {
                return sCompare;
            }
            return CompareUtils.sCompare(this.codeOffset, method.codeOffset);
        }

        public Method(int i, int i2, int i3) {
            this.methodIndex = i;
            this.accessFlags = i2;
            this.codeOffset = i3;
        }
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return Leb128.unsignedLeb128Size(this.staticFields.length) + Leb128.unsignedLeb128Size(this.instanceFields.length) + Leb128.unsignedLeb128Size(this.directMethods.length) + Leb128.unsignedLeb128Size(this.virtualMethods.length) + calcFieldsSize(this.staticFields) + calcFieldsSize(this.instanceFields) + calcMethodsSize(this.directMethods) + calcMethodsSize(this.virtualMethods);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof ClassData) || compareTo((ClassData) obj) != 0) {
            return false;
        }
        return true;
    }

    private int calcFieldsSize(Field[] fieldArr) {
        int length = fieldArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            Field field = fieldArr[i];
            int i4 = field.fieldIndex;
            i2 += Leb128.unsignedLeb128Size(i4 - i3) + Leb128.unsignedLeb128Size(field.accessFlags);
            i++;
            i3 = i4;
        }
        return i2;
    }

    private int calcMethodsSize(Method[] methodArr) {
        int length = methodArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            Method method = methodArr[i];
            int i4 = method.methodIndex;
            i2 += Leb128.unsignedLeb128Size(i4 - i3) + Leb128.unsignedLeb128Size(method.accessFlags) + Leb128.unsignedLeb128Size(method.codeOffset);
            i++;
            i3 = i4;
        }
        return i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassData classData) {
        int aArrCompare = CompareUtils.aArrCompare(this.staticFields, classData.staticFields);
        if (aArrCompare != 0) {
            return aArrCompare;
        }
        int aArrCompare2 = CompareUtils.aArrCompare(this.instanceFields, classData.instanceFields);
        if (aArrCompare2 != 0) {
            return aArrCompare2;
        }
        int aArrCompare3 = CompareUtils.aArrCompare(this.directMethods, classData.directMethods);
        if (aArrCompare3 != 0) {
            return aArrCompare3;
        }
        return CompareUtils.aArrCompare(this.virtualMethods, classData.virtualMethods);
    }

    public ClassData(int i, Field[] fieldArr, Field[] fieldArr2, Method[] methodArr, Method[] methodArr2) {
        super(i);
        this.staticFields = fieldArr;
        this.instanceFields = fieldArr2;
        this.directMethods = methodArr;
        this.virtualMethods = methodArr2;
    }
}
