package com.dragon.read.kmp.reader.download;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr$autoStartUncompletedTask$1", f = "ReaderDownloadMgr.kt", i = {1}, l = {140, 141}, m = "invokeSuspend", n = {"percentF"}, s = {"F$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$autoStartUncompletedTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bookId;
    final /* synthetic */ Function1<Boolean, Unit> $onStartDownloadConsumer;
    final /* synthetic */ String $targetUserId;
    float F$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ReaderDownloadMgr$autoStartUncompletedTask$1(String str, String str2, Function1<? super Boolean, Unit> function1, Continuation<? super ReaderDownloadMgr$autoStartUncompletedTask$1> continuation) {
        super(2, continuation);
        this.$bookId = str;
        this.$targetUserId = str2;
        this.$onStartDownloadConsumer = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReaderDownloadMgr$autoStartUncompletedTask$1(this.$bookId, this.$targetUserId, this.$onStartDownloadConsumer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReaderDownloadMgr$autoStartUncompletedTask$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0054  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            float r0 = r6.F$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4b
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1c:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L32
        L20:
            kotlin.ResultKt.throwOnFailure(r7)
            dm4.a r7 = dm4.f.c()
            java.lang.String r1 = r6.$bookId
            r6.label = r3
            java.lang.Object r7 = r7.f(r1, r6)
            if (r7 != r0) goto L32
            return r0
        L32:
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            dm4.n r1 = dm4.n.b
            java.lang.String r4 = r6.$targetUserId
            java.lang.String r5 = r6.$bookId
            r6.F$0 = r7
            r6.label = r2
            java.lang.Object r1 = r1.b(r4, r5, r6)
            if (r1 != r0) goto L49
            return r0
        L49:
            r0 = r7
            r7 = r1
        L4b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r1 = 0
            if (r7 != 0) goto L85
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r7 = r6.$onStartDownloadConsumer
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r7.invoke(r0)
            com.dragon.read.kmp.i r7 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.g()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " 下载器 - 书籍不在书架(收藏）上，不能触发自动下载，user_id = "
            r0.append(r1)
            java.lang.String r1 = r6.$targetUserId
            r0.append(r1)
            java.lang.String r1 = "，book_id = "
            r0.append(r1)
            java.lang.String r1 = r6.$bookId
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.d(r0)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L85:
            r7 = 0
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L9e
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r7 = r6.$onStartDownloadConsumer
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r7.invoke(r0)
            com.dragon.read.kmp.i r7 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.g()
            java.lang.String r0 = "下载器 - 用户没有触发过下载，不需要自动下载"
            r7.d(r0)
            goto Le5
        L9e:
            r7 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 < 0) goto Lb8
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r7 = r6.$onStartDownloadConsumer
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r7.invoke(r0)
            com.dragon.read.kmp.i r7 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.g()
            java.lang.String r0 = "下载器 - 用户已经下载完成，不需要自动下载"
            r7.d(r0)
            goto Le5
        Lb8:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r7 = r6.$onStartDownloadConsumer
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r7.invoke(r0)
            com.dragon.read.kmp.i r7 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.g()
            java.lang.String r0 = "下载器 - 用户触发过下载，开启自动下载检查"
            r7.d(r0)
            com.dragon.read.kmp.reader.download.a r7 = new com.dragon.read.kmp.reader.download.a
            java.lang.String r0 = r6.$bookId
            r7.<init>(r0)
            com.dragon.read.kmp.reader.download.a r7 = r7.a(r1)
            com.dragon.read.kmp.reader.download.a r7 = r7.b(r1)
            com.dragon.read.kmp.reader.download.a r7 = r7.c(r1)
            dm4.a r0 = dm4.f.c()
            r0.d(r7)
        Le5:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr$autoStartUncompletedTask$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
