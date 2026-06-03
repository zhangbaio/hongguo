package com.ttreader.tthtmlparser.position;

import com.bytedance.covode.number.Covode;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTPosition {
    private final int elementIndex;
    private final int offsetInElement;
    private final int paragraphId;

    static {
        Covode.recordClassIndex(654782);
    }

    public final int getElementIndex() {
        return this.elementIndex;
    }

    public final int getOffsetInElement() {
        return this.offsetInElement;
    }

    public final int getParagraphId() {
        return this.paragraphId;
    }

    public final byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeInt(this.paragraphId);
        dataOutputStream.writeInt(this.elementIndex);
        dataOutputStream.writeInt(this.offsetInElement);
        return byteArrayOutputStream.toByteArray();
    }

    public final void convertBytes$TTHtmlParser_release(DataOutputStream output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeInt(this.paragraphId);
        output.writeInt(this.elementIndex);
        output.writeInt(this.offsetInElement);
    }

    public TTPosition(int i, int i2, int i3) {
        this.paragraphId = i;
        this.elementIndex = i2;
        this.offsetInElement = i3;
    }
}
