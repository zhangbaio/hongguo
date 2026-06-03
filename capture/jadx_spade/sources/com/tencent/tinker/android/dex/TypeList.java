package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TypeList extends TableOfContents.Section.Item<TypeList> {
    public static final TypeList EMPTY;
    public short[] types;

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return (this.types.length * 2) + 4;
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return Arrays.hashCode(this.types);
    }

    static {
        Covode.recordClassIndex(653621);
        EMPTY = new TypeList(0, Dex.EMPTY_SHORT_ARRAY);
    }

    @Override // java.lang.Comparable
    public int compareTo(TypeList typeList) {
        return CompareUtils.uArrCompare(this.types, typeList.types);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof TypeList) || compareTo((TypeList) obj) != 0) {
            return false;
        }
        return true;
    }

    public TypeList(int i, short[] sArr) {
        super(i);
        this.types = sArr;
    }
}
