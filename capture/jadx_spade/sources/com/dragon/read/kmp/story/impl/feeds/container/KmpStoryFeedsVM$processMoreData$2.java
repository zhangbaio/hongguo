package com.dragon.read.kmp.story.impl.feeds.container;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$2", f = "KmpStoryFeedsVM.kt", i = {0, 0, 0, 1, 1}, l = {TTVideoEngineInterface.PLAYER_OPTION_IS_DEGRADE_RELEASE, 622}, m = "invokeSuspend", n = {"$this$supervisorScope", "index$iv", "index", "$this$supervisorScope", "index$iv"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryFeedsVM$processMoreData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $asyncSize;
    final /* synthetic */ List<com.dragon.read.kmp.story.impl.feeds.data.e> $waitDataList;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ KmpStoryFeedsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryFeedsVM$processMoreData$2(List<com.dragon.read.kmp.story.impl.feeds.data.e> list, int i, KmpStoryFeedsVM kmpStoryFeedsVM, Continuation<? super KmpStoryFeedsVM$processMoreData$2> continuation) {
        super(2, continuation);
        this.$waitDataList = list;
        this.$asyncSize = i;
        this.this$0 = kmpStoryFeedsVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KmpStoryFeedsVM$processMoreData$2 kmpStoryFeedsVM$processMoreData$2 = new KmpStoryFeedsVM$processMoreData$2(this.$waitDataList, this.$asyncSize, this.this$0, continuation);
        kmpStoryFeedsVM$processMoreData$2.L$0 = obj;
        return kmpStoryFeedsVM$processMoreData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpStoryFeedsVM$processMoreData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0070  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00f8 -> B:6:0x00fb). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
