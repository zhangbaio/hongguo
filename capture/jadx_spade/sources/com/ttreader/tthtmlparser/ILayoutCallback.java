package com.ttreader.tthtmlparser;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ILayoutCallback {

    /* renamed from: com.ttreader.tthtmlparser.ILayoutCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$OnChapterCreated(ILayoutCallback iLayoutCallback, TTEpubChapter tTEpubChapter) {
        }

        public static void $default$OnLayoutFinished(ILayoutCallback iLayoutCallback) {
        }

        public static boolean $default$OnPageLayout(ILayoutCallback iLayoutCallback, int i, boolean z) {
            return true;
        }

        public static void $default$OnRelayout(ILayoutCallback iLayoutCallback) {
        }

        public static void $default$OnRelayoutFinished(ILayoutCallback iLayoutCallback) {
        }
    }

    void OnChapterCreated(TTEpubChapter tTEpubChapter);

    void OnLayoutFinished();

    boolean OnPageLayout(int i, boolean z);

    void OnRelayout();

    void OnRelayoutFinished();
}
