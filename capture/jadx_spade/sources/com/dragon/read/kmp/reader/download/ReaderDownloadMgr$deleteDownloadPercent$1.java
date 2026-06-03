package com.dragon.read.kmp.reader.download;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr$deleteDownloadPercent$1", f = "ReaderDownloadMgr.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_SETSURFACESYNC_SENDATFRONTOFQUEUE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$deleteDownloadPercent$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $bookIds;
    final /* synthetic */ String $targetUserId;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$deleteDownloadPercent$1(List<String> list, String str, Continuation<? super ReaderDownloadMgr$deleteDownloadPercent$1> continuation) {
        super(1, continuation);
        this.$bookIds = list;
        this.$targetUserId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ReaderDownloadMgr$deleteDownloadPercent$1(this.$bookIds, this.$targetUserId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ReaderDownloadMgr$deleteDownloadPercent$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Iterator<String> it2;
        com.dragon.read.kmp.i iVar;
        qj4.a aVar;
        String a0;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                it2 = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            it2 = this.$bookIds.iterator();
        }
        while (it2.hasNext()) {
            String next = it2.next();
            iVar = ReaderDownloadMgr.h;
            iVar.d("删除书籍下载进度，userId=" + this.$targetUserId + ", bookId=" + next);
            aVar = ReaderDownloadMgr.b;
            a0 = ReaderDownloadMgr.a.a0(this.$targetUserId, next);
            String[] strArr = {a0};
            this.L$0 = it2;
            this.label = 1;
            if (aVar.c(strArr, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
