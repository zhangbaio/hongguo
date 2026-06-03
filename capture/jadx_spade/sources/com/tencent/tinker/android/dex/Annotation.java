package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dex.util.HashCodeHelper;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Annotation extends TableOfContents.Section.Item<Annotation> {
    public EncodedValue encodedAnnotation;
    public byte visibility;

    static {
        Covode.recordClassIndex(653583);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int byteCountInDex() {
        return this.encodedAnnotation.byteCountInDex() + 1;
    }

    public EncodedValueReader getReader() {
        return new EncodedValueReader(this.encodedAnnotation, 29);
    }

    public int getTypeIndex() {
        EncodedValueReader reader = getReader();
        reader.readAnnotation();
        return reader.getAnnotationType();
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public int hashCode() {
        return HashCodeHelper.hash(Byte.valueOf(this.visibility), this.encodedAnnotation);
    }

    @Override // com.tencent.tinker.android.dex.TableOfContents.Section.Item
    public boolean equals(Object obj) {
        if (!(obj instanceof Annotation) || compareTo((Annotation) obj) != 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(Annotation annotation) {
        int compareTo = this.encodedAnnotation.compareTo(annotation.encodedAnnotation);
        if (compareTo != 0) {
            return compareTo;
        }
        return CompareUtils.uCompare(this.visibility, annotation.visibility);
    }

    public Annotation(int i, byte b, EncodedValue encodedValue) {
        super(i);
        this.visibility = b;
        this.encodedAnnotation = encodedValue;
    }
}
