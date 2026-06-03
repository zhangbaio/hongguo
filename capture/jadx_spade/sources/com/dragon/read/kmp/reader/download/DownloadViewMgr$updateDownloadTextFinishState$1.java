package com.dragon.read.kmp.reader.download;

import dm4.r;
import dm4.s;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.DownloadViewMgr$updateDownloadTextFinishState$1", f = "DownloadViewMgr.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class DownloadViewMgr$updateDownloadTextFinishState$1 extends SuspendLambda implements Function2<cm4.i, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bookId;
    final /* synthetic */ cm4.i $reader;
    int label;
    final /* synthetic */ DownloadViewMgr this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadViewMgr$updateDownloadTextFinishState$1(DownloadViewMgr downloadViewMgr, cm4.i iVar, String str, Continuation<? super DownloadViewMgr$updateDownloadTextFinishState$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadViewMgr;
        this.$reader = iVar;
        this.$bookId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewMgr$updateDownloadTextFinishState$1(this.this$0, this.$reader, this.$bookId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(cm4.i iVar, Continuation<? super Unit> continuation) {
        return ((DownloadViewMgr$updateDownloadTextFinishState$1) create(iVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    private static final void invokeSuspend$reportClick(String str) {
        ym4.a aVar = new ym4.a();
        aVar.g("book_id", str);
        aVar.g("clicked_content", "download_content");
        s.b.a("click_reader", aVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.dragon.read.kmp.i iVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            iVar = this.this$0.d;
            iVar.d("openBookDownloadManagementActivity topBook:false showDialog:false");
            r.b.a(this.$reader.b(), this.$bookId, false, "reader_top");
            invokeSuspend$reportClick(this.$bookId);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
