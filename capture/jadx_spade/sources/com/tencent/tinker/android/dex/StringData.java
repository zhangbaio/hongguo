package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import java.io.UTFDataFormatException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StringData extends TableOfContents.Section.Item<StringData> {
    public String value;

    static {
        Covode.recordClassIndex(653617);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        try {
            return Leb128.unsignedLeb128Size(this.value.length()) + ((int) Mutf8.countBytes(this.value, false)) + 1;
        } catch (UTFDataFormatException e) {
            throw new DexException(e);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(StringData stringData) {
        return this.value.compareTo(stringData.value);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof StringData) || compareTo((StringData) obj) != 0) {
            return false;
        }
        return true;
    }

    public StringData(int i, String str) {
        super(i);
        this.value = str;
    }
}
