package com.ttreader.txtparser;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Chapter {
    private int chapterIdx;
    private int contentLength;
    private int startOffset;
    private String title = "";

    static {
        Covode.recordClassIndex(654831);
    }

    public int getChapterIdx() {
        return this.chapterIdx;
    }

    public int getContentLength() {
        return this.contentLength;
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public String getTitle() {
        return this.title;
    }
}
