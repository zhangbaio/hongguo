package com.ttreader.tthtmlparser.dom;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTHtmlDocument {
    private final long instance;

    static {
        Covode.recordClassIndex(654766);
    }

    private final native long nativeGetBody(long j);

    private final native long[] nativeGetElementsByClass(long j, String str);

    private final native long nativeGetHead(long j);

    public final long getInstance$TTHtmlParser_release() {
        return this.instance;
    }

    public final TTHtmlElement getBody() {
        return new TTHtmlElement(this, nativeGetBody(this.instance));
    }

    public final TTHtmlElement getHead() {
        return new TTHtmlElement(this, nativeGetHead(this.instance));
    }

    public TTHtmlDocument(long j) {
        this.instance = j;
    }

    public final List<TTHtmlElement> getElementsByClass(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        long[] nativeGetElementsByClass = nativeGetElementsByClass(this.instance, name);
        if (nativeGetElementsByClass != null) {
            ArrayList arrayList = new ArrayList(nativeGetElementsByClass.length);
            for (long j : nativeGetElementsByClass) {
                arrayList.add(new TTHtmlElement(this, this.instance));
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
