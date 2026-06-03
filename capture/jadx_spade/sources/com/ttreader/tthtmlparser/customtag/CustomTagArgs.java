package com.ttreader.tthtmlparser.customtag;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class CustomTagArgs {
    private final ElementNode elementNode;

    static {
        Covode.recordClassIndex(654754);
    }

    public static /* synthetic */ CustomTagArgs copy$default(CustomTagArgs customTagArgs, ElementNode elementNode, int i, Object obj) {
        if ((i & 1) != 0) {
            elementNode = customTagArgs.elementNode;
        }
        return customTagArgs.copy(elementNode);
    }

    public final ElementNode component1() {
        return this.elementNode;
    }

    public final CustomTagArgs copy(ElementNode elementNode) {
        Intrinsics.checkNotNullParameter(elementNode, "elementNode");
        return new CustomTagArgs(elementNode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomTagArgs) && Intrinsics.areEqual(this.elementNode, ((CustomTagArgs) obj).elementNode);
    }

    public int hashCode() {
        return this.elementNode.hashCode();
    }

    public String toString() {
        return "CustomTagArgs(elementNode=" + this.elementNode + ')';
    }

    public final ElementNode getElementNode() {
        return this.elementNode;
    }

    public CustomTagArgs(ElementNode elementNode) {
        Intrinsics.checkNotNullParameter(elementNode, "elementNode");
        this.elementNode = elementNode;
    }
}
