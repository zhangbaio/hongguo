package com.ttreader.tthtmlparser.customtag;

import com.bytedance.covode.number.Covode;
import com.ttreader.tttext.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class ElementNode {
    public static final Companion Companion;
    private Map<String, String> attribute;
    private final List<ElementNode> children;
    private final String tag;
    private final String text;
    private final ElementType type;

    static {
        Covode.recordClassIndex(654759);
        Companion = new Companion(null);
    }

    public static /* synthetic */ ElementNode copy$default(ElementNode elementNode, String str, ElementType elementType, String str2, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = elementNode.tag;
        }
        if ((i & 2) != 0) {
            elementType = elementNode.type;
        }
        ElementType elementType2 = elementType;
        if ((i & 4) != 0) {
            str2 = elementNode.text;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            map = elementNode.attribute;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            list = elementNode.children;
        }
        return elementNode.copy(str, elementType2, str3, map2, list);
    }

    private static final ElementNode fromBytes(a aVar) {
        return Companion.fromBytes(aVar);
    }

    public static final ElementNode fromBytes(byte[] bArr) {
        return Companion.fromBytes(bArr);
    }

    public final String component1() {
        return this.tag;
    }

    public final ElementType component2() {
        return this.type;
    }

    public final String component3() {
        return this.text;
    }

    public final Map<String, String> component4() {
        return this.attribute;
    }

    public final List<ElementNode> component5() {
        return this.children;
    }

    public final ElementNode copy(String tag, ElementType type, String text, Map<String, String> map, List<ElementNode> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        return new ElementNode(tag, type, text, map, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ElementNode)) {
            return false;
        }
        ElementNode elementNode = (ElementNode) obj;
        return Intrinsics.areEqual(this.tag, elementNode.tag) && this.type == elementNode.type && Intrinsics.areEqual(this.text, elementNode.text) && Intrinsics.areEqual(this.attribute, elementNode.attribute) && Intrinsics.areEqual(this.children, elementNode.children);
    }

    public int hashCode() {
        int hashCode = ((((this.tag.hashCode() * 31) + this.type.hashCode()) * 31) + this.text.hashCode()) * 31;
        Map<String, String> map = this.attribute;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        List<ElementNode> list = this.children;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "ElementNode(tag=" + this.tag + ", type=" + this.type + ", text=" + this.text + ", attribute=" + this.attribute + ", children=" + this.children + ')';
    }

    public final Map<String, String> getAttribute() {
        return this.attribute;
    }

    public final List<ElementNode> getChildren() {
        return this.children;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getText() {
        return this.text;
    }

    public final ElementType getType() {
        return this.type;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ElementType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ElementType[] $VALUES;
        public static final ElementType ELEMENT;
        public static final ElementType TEXT;
        public static final ElementType UNKNOWN;

        private static final /* synthetic */ ElementType[] $values() {
            return new ElementType[]{ELEMENT, TEXT, UNKNOWN};
        }

        public static EnumEntries<ElementType> getEntries() {
            return $ENTRIES;
        }

        public static ElementType[] values() {
            return (ElementType[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(654761);
            ELEMENT = new ElementType("ELEMENT", 0);
            TEXT = new ElementType("TEXT", 1);
            UNKNOWN = new ElementType("UNKNOWN", 2);
            ElementType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ElementType valueOf(String str) {
            return (ElementType) Enum.valueOf(ElementType.class, str);
        }

        private ElementType(String str, int i) {
        }
    }

    public final void setAttribute(Map<String, String> map) {
        this.attribute = map;
    }

    public static final class Companion {
        static {
            Covode.recordClassIndex(654760);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ElementNode fromBytes(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return fromBytes(new a(bytes));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ElementNode fromBytes(a aVar) {
            int readInt = aVar.readInt();
            if (readInt != 1) {
                if (readInt != 2) {
                    return new ElementNode("", ElementType.UNKNOWN, "", null, null);
                }
                String a = aVar.a();
                ElementType elementType = ElementType.TEXT;
                Intrinsics.checkNotNull(a);
                return new ElementNode("", elementType, a, null, null);
            }
            String a2 = aVar.a();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int readInt2 = aVar.readInt();
            for (int i = 0; i < readInt2; i++) {
                linkedHashMap.put(aVar.a(), aVar.a());
            }
            int readInt3 = aVar.readInt();
            if (readInt3 > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < readInt3; i2++) {
                    arrayList.add(fromBytes(aVar));
                }
                Intrinsics.checkNotNull(a2);
                return new ElementNode(a2, ElementType.ELEMENT, "", linkedHashMap, arrayList);
            }
            Intrinsics.checkNotNull(a2);
            return new ElementNode(a2, ElementType.ELEMENT, "", linkedHashMap, null);
        }
    }

    public ElementNode(String tag, ElementType type, String text, Map<String, String> map, List<ElementNode> list) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        this.tag = tag;
        this.type = type;
        this.text = text;
        this.attribute = map;
        this.children = list;
    }
}
