package com.ttreader.tthtmlparser.dom;

import com.bytedance.covode.number.Covode;
import com.ttreader.tttext.a;
import com.ttreader.tttext.b;
import java.io.ByteArrayOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTHtmlElement {
    private final TTHtmlDocument document;
    private final long instance;

    static {
        Covode.recordClassIndex(654767);
    }

    private final native long nativeAddElement(long j, long j2, byte[] bArr);

    private final native long nativeAddText(long j, long j2, int i, String str);

    private final native byte[] nativeGetAttributes(long j);

    private final native long nativeGetBeforeSibling(long j, long j2);

    private final native long nativeGetChild(long j, int i);

    private final native int nativeGetChildCount(long j);

    private final native int nativeGetIndex(long j);

    private final native long nativeGetNextSibling(long j, long j2);

    private final native long nativeGetParent(long j);

    private final native String nativeGetTagName(long j);

    private final native String nativeGetText(long j);

    private final native int nativeGetType(long j);

    private final native long nativeRemoveChild(long j, long j2, int i);

    public final long getInstance$TTHtmlParser_release() {
        return this.instance;
    }

    public final int getChildCount() {
        return nativeGetChildCount(this.instance);
    }

    public final int getIndex() {
        return nativeGetIndex(this.instance);
    }

    public final String getTagName() {
        return nativeGetTagName(this.instance);
    }

    public int hashCode() {
        return j.a(this.instance);
    }

    public final String getText() {
        String nativeGetText = nativeGetText(this.instance);
        if (nativeGetText == null) {
            return "";
        }
        return nativeGetText;
    }

    public final TTHtmlElement getBeforeSibling() {
        long nativeGetBeforeSibling = nativeGetBeforeSibling(this.document.getInstance$TTHtmlParser_release(), this.instance);
        if (nativeGetBeforeSibling == -1) {
            return null;
        }
        return new TTHtmlElement(this.document, nativeGetBeforeSibling);
    }

    public final TTHtmlElement getNextSibling() {
        long nativeGetNextSibling = nativeGetNextSibling(this.document.getInstance$TTHtmlParser_release(), this.instance);
        if (nativeGetNextSibling == -1) {
            return null;
        }
        return new TTHtmlElement(this.document, nativeGetNextSibling);
    }

    public final TTHtmlElement getParent() {
        long nativeGetParent = nativeGetParent(this.instance);
        if (nativeGetParent == -1) {
            return null;
        }
        return new TTHtmlElement(this.document, nativeGetParent);
    }

    public String toString() {
        return "TTElement(instance=" + this.instance + ')';
    }

    public final Map<String, String> getAttributes() {
        boolean z;
        byte[] nativeGetAttributes = nativeGetAttributes(this.instance);
        if (nativeGetAttributes == null) {
            return null;
        }
        if (nativeGetAttributes.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a aVar = new a(nativeGetAttributes);
        int readInt = aVar.readInt();
        for (int i = 0; i < readInt; i++) {
            linkedHashMap.put(aVar.a(), aVar.a());
        }
        return linkedHashMap;
    }

    public final TTElementType getType() {
        switch (nativeGetType(this.instance)) {
        }
        return TTElementType.NODE_DOCUMENT;
    }

    public final long removeChild(int i) {
        return nativeRemoveChild(this.document.getInstance$TTHtmlParser_release(), this.instance, i);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TTHtmlElement) || ((TTHtmlElement) obj).instance != this.instance) {
            return false;
        }
        return true;
    }

    public final TTHtmlElement getChild(int i) {
        long nativeGetChild = nativeGetChild(this.instance, i);
        if (nativeGetChild == -1) {
            return null;
        }
        return new TTHtmlElement(this.document, nativeGetChild);
    }

    public TTHtmlElement(TTHtmlDocument document, long j) {
        Intrinsics.checkNotNullParameter(document, "document");
        this.document = document;
        this.instance = j;
    }

    public final TTHtmlElement addText(int i, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TTHtmlElement(this.document, nativeAddText(this.document.getInstance$TTHtmlParser_release(), this.instance, i, text));
    }

    public final TTHtmlElement addElement(int i, String tagName, String text, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Intrinsics.checkNotNullParameter(text, "text");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b bVar = new b(byteArrayOutputStream);
        bVar.c(i);
        bVar.a(tagName);
        bVar.a(text);
        bVar.d(map);
        long instance$TTHtmlParser_release = this.document.getInstance$TTHtmlParser_release();
        long j = this.instance;
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return new TTHtmlElement(this.document, nativeAddElement(instance$TTHtmlParser_release, j, byteArray));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TTHtmlElement addElement$default(TTHtmlElement tTHtmlElement, int i, String str, String str2, Map map, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            map = null;
        }
        return tTHtmlElement.addElement(i, str, str2, map);
    }
}
