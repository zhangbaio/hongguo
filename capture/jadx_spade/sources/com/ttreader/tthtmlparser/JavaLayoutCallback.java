package com.ttreader.tthtmlparser;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.TTEpubDefinition;
import com.ttreader.tttext.j;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class JavaLayoutCallback {
    private final ILayoutCallback callback_;
    private final long instance_ = nativeCreateLayoutCallback();
    private j resource_manager_;
    public TTEpubChapter result_chapter_;

    static {
        Covode.recordClassIndex(654715);
    }

    private native long nativeCreateLayoutCallback();

    private native void nativeDestroyLayoutCallback(long j);

    private native void nativeSetResourceCallback(long j, long j2);

    public long GetInstance() {
        return this.instance_;
    }

    public void OnLayoutFinished() {
        this.callback_.OnLayoutFinished();
    }

    public void OnRelayout() {
        this.callback_.OnRelayout();
    }

    public void OnRelayoutFinished() {
        this.callback_.OnRelayoutFinished();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        nativeDestroyLayoutCallback(this.instance_);
    }

    public void SetManager(j jVar) {
        this.resource_manager_ = jVar;
    }

    public void SetResourceCallback(long j) {
        nativeSetResourceCallback(this.instance_, j);
    }

    public JavaLayoutCallback(ILayoutCallback iLayoutCallback) {
        this.callback_ = iLayoutCallback;
    }

    public void OnChapterCreated(long j) {
        TTEpubChapter tTEpubChapter = new TTEpubChapter(j, this.resource_manager_);
        this.result_chapter_ = tTEpubChapter;
        this.callback_.OnChapterCreated(tTEpubChapter);
    }

    public int OnPageLayout(int i, boolean z) {
        TTEpubDefinition.PageRelayout pageRelayout;
        boolean OnPageLayout = this.callback_.OnPageLayout(i, z);
        if (!OnPageLayout) {
            Log.e("Java Layout Callback", "OnPageLayout: ReLayout");
        }
        if (OnPageLayout) {
            pageRelayout = TTEpubDefinition.PageRelayout.kSuccess;
        } else {
            pageRelayout = TTEpubDefinition.PageRelayout.kRelayout;
        }
        return pageRelayout.ordinal();
    }
}
