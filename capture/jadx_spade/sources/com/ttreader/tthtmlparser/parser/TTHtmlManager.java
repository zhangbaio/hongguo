package com.ttreader.tthtmlparser.parser;

import com.bytedance.covode.number.Covode;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTHtmlManager {
    private static native byte[] nativeParseHtml(byte[] bArr, byte[] bArr2);

    static {
        Covode.recordClassIndex(654780);
        System.loadLibrary("TTHtmlParser");
        System.loadLibrary("tttext");
    }

    public static List<HtmlElement> parseHtml(String str, String str2) {
        return HtmlElement.readFromBytes(nativeParseHtml(str.getBytes(), str2.getBytes()));
    }
}
