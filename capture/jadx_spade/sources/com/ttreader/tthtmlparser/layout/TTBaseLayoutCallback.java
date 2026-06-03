package com.ttreader.tthtmlparser.layout;

import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.ILayoutCallback;
import com.ttreader.tthtmlparser.TTEpubChapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTBaseLayoutCallback implements ILayoutCallback {
    private TTEpubChapter chapter;

    static {
        Covode.recordClassIndex(654776);
    }

    @Override // com.ttreader.tthtmlparser.ILayoutCallback
    public void OnLayoutFinished() {
    }

    @Override // com.ttreader.tthtmlparser.ILayoutCallback
    public boolean OnPageLayout(int i, boolean z) {
        return true;
    }

    @Override // com.ttreader.tthtmlparser.ILayoutCallback
    public void OnRelayout() {
    }

    @Override // com.ttreader.tthtmlparser.ILayoutCallback
    public void OnRelayoutFinished() {
    }

    protected final TTEpubChapter getChapter() {
        TTEpubChapter tTEpubChapter = this.chapter;
        if (tTEpubChapter != null) {
            return tTEpubChapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("chapter");
        return null;
    }

    @Override // com.ttreader.tthtmlparser.ILayoutCallback
    public void OnChapterCreated(TTEpubChapter chapter) {
        Intrinsics.checkNotNullParameter(chapter, "chapter");
        this.chapter = chapter;
    }
}
