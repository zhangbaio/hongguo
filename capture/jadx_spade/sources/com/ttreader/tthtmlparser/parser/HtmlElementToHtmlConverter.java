package com.ttreader.tthtmlparser.parser;

import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.parser.HtmlElementToHtmlConverter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class HtmlElementToHtmlConverter {
    static {
        Covode.recordClassIndex(654778);
    }

    public final StringBuilder appendEndTag(StringBuilder sb, String tag) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        sb.append("</");
        sb.append(tag);
        sb.append(">");
        return sb;
    }

    public final StringBuilder appendWithHtmlEscape(StringBuilder sb, String input) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        char[] charArray = input.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        for (char c : charArray) {
            if (c != '&') {
                if (c != '<') {
                    if (c != '>') {
                        sb.append(c);
                    } else {
                        sb.append("&gt;");
                    }
                } else {
                    sb.append("&lt;");
                }
            } else {
                sb.append("&amp;");
            }
        }
        return sb;
    }

    public final String convert(List<? extends HtmlElement> elements, boolean z) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>");
        if (z) {
            sb.append("<article>");
        }
        HtmlNode htmlNode = null;
        for (final HtmlElement htmlElement : elements) {
            final HtmlNode htmlNode2 = htmlElement.paraNode;
            if (!Intrinsics.areEqual(htmlNode2, htmlNode)) {
                if (htmlNode != null) {
                    String tag = htmlNode.tag;
                    Intrinsics.checkNotNullExpressionValue(tag, "tag");
                    appendEndTag(sb, tag);
                }
                String tag2 = htmlNode2.tag;
                Intrinsics.checkNotNullExpressionValue(tag2, "tag");
                appendStartTag(sb, tag2, new Function1() { // from class: yj6.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit convert$lambda$0;
                        convert$lambda$0 = HtmlElementToHtmlConverter.convert$lambda$0(HtmlElementToHtmlConverter.this, htmlNode2, (StringBuilder) obj);
                        return convert$lambda$0;
                    }
                });
                htmlNode = htmlNode2;
            }
            appendStartTag(sb, "blk", new Function1() { // from class: yj6.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit convert$lambda$1;
                    convert$lambda$1 = HtmlElementToHtmlConverter.convert$lambda$1(HtmlElementToHtmlConverter.this, htmlElement, (StringBuilder) obj);
                    return convert$lambda$1;
                }
            });
            String content = htmlElement.getContent();
            Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
            appendWithHtmlEscape(sb, content);
            appendEndTag(sb, "blk");
        }
        if (!elements.isEmpty() && htmlNode != null) {
            String tag3 = htmlNode.tag;
            Intrinsics.checkNotNullExpressionValue(tag3, "tag");
            appendEndTag(sb, tag3);
        }
        if (z) {
            sb.append("</article>");
        }
        sb.append("</body></html>");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final StringBuilder appendStartTag(StringBuilder sb, String tag, Function1<? super StringBuilder, Unit> attrBuilder) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(attrBuilder, "attrBuilder");
        sb.append("<");
        sb.append(tag);
        attrBuilder.invoke(sb);
        sb.append(">");
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convert$lambda$0(HtmlElementToHtmlConverter htmlElementToHtmlConverter, HtmlNode htmlNode, StringBuilder appendStartTag) {
        boolean z;
        Intrinsics.checkNotNullParameter(appendStartTag, "$this$appendStartTag");
        htmlElementToHtmlConverter.appendTagAttrs(appendStartTag, "idx", Integer.valueOf(htmlNode.idxAttr));
        String classAttr = htmlNode.classAttr;
        Intrinsics.checkNotNullExpressionValue(classAttr, "classAttr");
        if (classAttr.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            String classAttr2 = htmlNode.classAttr;
            Intrinsics.checkNotNullExpressionValue(classAttr2, "classAttr");
            htmlElementToHtmlConverter.appendTagAttrs(appendStartTag, "class", classAttr2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convert$lambda$1(HtmlElementToHtmlConverter htmlElementToHtmlConverter, HtmlElement htmlElement, StringBuilder appendStartTag) {
        Intrinsics.checkNotNullParameter(appendStartTag, "$this$appendStartTag");
        htmlElementToHtmlConverter.appendTagAttrs(appendStartTag, "p_idx", Integer.valueOf(htmlElement.pIdx));
        htmlElementToHtmlConverter.appendTagAttrs(appendStartTag, "e_idx", Integer.valueOf(htmlElement.eIdx));
        htmlElementToHtmlConverter.appendTagAttrs(appendStartTag, "e_order", Integer.valueOf(htmlElement.eOrder));
        return Unit.INSTANCE;
    }

    public final StringBuilder appendTagAttrs(StringBuilder sb, String attr, Object value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(attr, "attr");
        Intrinsics.checkNotNullParameter(value, "value");
        sb.append(' ');
        sb.append(attr);
        sb.append('=');
        sb.append('\"');
        sb.append(value);
        sb.append('\"');
        return sb;
    }
}
