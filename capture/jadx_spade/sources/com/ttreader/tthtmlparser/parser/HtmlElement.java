package com.ttreader.tthtmlparser.parser;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ttreader.tttext.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class HtmlElement {
    private String content;
    public final int eIdx;
    public final int eOrder;
    public final int endOffsetInPara;
    public final int length;
    public final int pIdx;
    public final HtmlNode paraNode;
    public final int startOffsetInPara;

    static {
        Covode.recordClassIndex(654777);
    }

    public String getContent() {
        return this.content;
    }

    public String toString() {
        return "HtmlElement{content='" + this.content + "', pIdx=" + this.pIdx + ", eOrder=" + this.eOrder + ", eIdx=" + this.eIdx + ", startOffsetInPara=" + this.startOffsetInPara + ", endOffsetInPara=" + this.endOffsetInPara + ", length=" + this.length + '}';
    }

    public void setContent(String str) {
        this.content = str;
    }

    public static ArrayList<HtmlElement> readFromBytes(byte[] bArr) {
        ArrayList<HtmlElement> arrayList = new ArrayList<>();
        if (bArr != null && bArr.length != 0) {
            a aVar = new a(new ByteArrayInputStream(bArr));
            while (aVar.available() > 0) {
                try {
                    String a = aVar.a();
                    String a2 = aVar.a();
                    int d = aVar.d();
                    int d2 = aVar.d();
                    if (d2 > 0) {
                        HtmlNode htmlNode = new HtmlNode(a, a2, d);
                        for (int i = 0; i < d2; i++) {
                            String a3 = aVar.a();
                            int d3 = aVar.d();
                            int d4 = aVar.d();
                            int d5 = aVar.d();
                            arrayList.add(new HtmlElement(htmlNode, a3, d, d3, d4, d5, d5 + aVar.d()));
                        }
                    }
                } catch (IOException e) {
                    Log.e("HtmlElement", "parse error", e);
                }
            }
        }
        return arrayList;
    }

    public HtmlElement(HtmlNode htmlNode, String str, int i, int i2, int i3, int i4, int i5) {
        this.paraNode = htmlNode;
        this.content = str;
        this.pIdx = i;
        this.eOrder = i2;
        this.eIdx = i3;
        this.startOffsetInPara = i4;
        this.endOffsetInPara = i5;
        this.length = i5 - i4;
    }
}
