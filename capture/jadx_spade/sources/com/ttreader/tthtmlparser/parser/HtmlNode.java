package com.ttreader.tthtmlparser.parser;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class HtmlNode {
    public final String classAttr;
    public final int idxAttr;
    public final String tag;

    static {
        Covode.recordClassIndex(654779);
    }

    public HtmlNode(String str, String str2, int i) {
        this.tag = str;
        this.classAttr = str2;
        this.idxAttr = i;
    }
}
