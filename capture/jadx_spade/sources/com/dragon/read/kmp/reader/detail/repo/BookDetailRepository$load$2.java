package com.dragon.read.kmp.reader.detail.repo;

import com.dragon.read.kmp.reader.detail.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$2", f = "BookDetailRepository.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, ConstantsAPI.COMMAND_LAUNCH_BY_WX, ConstantsAPI.COMMAND_LAUNCH_BY_WX, ConstantsAPI.COMMAND_LAUNCH_BY_WX, ConstantsAPI.COMMAND_LAUNCH_BY_WX, ConstantsAPI.COMMAND_LAUNCH_BY_WX, ConstantsAPI.COMMAND_LAUNCH_BY_WX, ConstantsAPI.COMMAND_LAUNCH_BY_WX, 7, 7, 7, 7, 7, 7, 7}, l = {149, 150, 151, 152, 153, 154, 155, 156}, m = "invokeSuspend", n = {"listenDeferred", "alsoReadDeferred", "commonPlanDeferred", "hotCommentsDeferred", "forumDeferred", "adaptIpDeferred", "inBookshelfDeferred", "alsoReadDeferred", "commonPlanDeferred", "hotCommentsDeferred", "forumDeferred", "adaptIpDeferred", "inBookshelfDeferred", "bookDetail", "commonPlanDeferred", "hotCommentsDeferred", "forumDeferred", "adaptIpDeferred", "inBookshelfDeferred", "bookDetail", "listenState", "hotCommentsDeferred", "forumDeferred", "adaptIpDeferred", "inBookshelfDeferred", "bookDetail", "listenState", "alsoRead", "forumDeferred", "adaptIpDeferred", "inBookshelfDeferred", "bookDetail", "listenState", "alsoRead", "commonPlan", "adaptIpDeferred", "inBookshelfDeferred", "bookDetail", "listenState", "alsoRead", "commonPlan", "hotCommentsData", "inBookshelfDeferred", "bookDetail", "listenState", "alsoRead", "commonPlan", "hotCommentsData", "forumData", "bookDetail", "listenState", "alsoRead", "commonPlan", "hotCommentsData", "forumData", "adaptIp"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailRepository$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends b>>, Object> {
    final /* synthetic */ d $args;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ BookDetailRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailRepository$load$2(d dVar, BookDetailRepository bookDetailRepository, Continuation<? super BookDetailRepository$load$2> continuation) {
        super(2, continuation);
        this.$args = dVar;
        this.this$0 = bookDetailRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BookDetailRepository$load$2 bookDetailRepository$load$2 = new BookDetailRepository$load$2(this.$args, this.this$0, continuation);
        bookDetailRepository$load$2.L$0 = obj;
        return bookDetailRepository$load$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends b>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<b>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<b>> continuation) {
        return ((BookDetailRepository$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x029f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x027f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0258 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0236 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0213 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x02d8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 860
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.repo.BookDetailRepository$load$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
