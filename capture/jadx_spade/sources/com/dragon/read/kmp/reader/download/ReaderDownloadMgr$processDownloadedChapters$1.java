package com.dragon.read.kmp.reader.download;

import com.ss.ttm.player.MediaPlayer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr", f = "ReaderDownloadMgr.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5}, l = {483, 489, 491, 496, 501, 509, MediaPlayer.MEDIA_PLAYER_OPTION_APPID}, m = "processDownloadedChapters", n = {"userId", "bookId", "allDownloadList", "unFinishChapterIdSet", "listener", "chapterId", "item", "containsImage", "userId", "bookId", "allDownloadList", "unFinishChapterIdSet", "listener", "chapterId", "containsImage", "userId", "bookId", "allDownloadList", "unFinishChapterIdSet", "listener", "chapterId", "containsImage", "userId", "bookId", "allDownloadList", "unFinishChapterIdSet", "listener", "chapterId", "userId", "bookId", "allDownloadList", "unFinishChapterIdSet", "listener", "bookId", "allDownloadList", "unFinishChapterIdSet", "listener", "totalSize", "finishSize", "percent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "F$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$processDownloadedChapters$1 extends ContinuationImpl {
    float F$0;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReaderDownloadMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$processDownloadedChapters$1(ReaderDownloadMgr readerDownloadMgr, Continuation<? super ReaderDownloadMgr$processDownloadedChapters$1> continuation) {
        super(continuation);
        this.this$0 = readerDownloadMgr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c0;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        c0 = this.this$0.c0(null, null, null, null, null, null, this);
        return c0;
    }
}
