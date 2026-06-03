package com.dragon.read.kmp.reader.download;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr", f = "ReaderDownloadMgr.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {775, 779}, m = "parseUnfinishedChapterIdListDebug", n = {"bookId", "list", "unfinishedIdList", "unfinishedIdSet", "startMark", "bookId", "list", "unfinishedIdList", "unfinishedIdSet", "chapterImageDownloadStatus", "chapterId", "startMark", "i"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$parseUnfinishedChapterIdListDebug$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReaderDownloadMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$parseUnfinishedChapterIdListDebug$1(ReaderDownloadMgr readerDownloadMgr, Continuation<? super ReaderDownloadMgr$parseUnfinishedChapterIdListDebug$1> continuation) {
        super(continuation);
        this.this$0 = readerDownloadMgr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Y(null, null, this);
    }
}
