package com.dragon.read.kmp.story.impl.feeds.guide;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1", f = "KmpNextStoryBottomGuideHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<kp4.b> $currentBottomStory$delegate;
    final /* synthetic */ State<kp4.b> $currentStory$delegate;
    final /* synthetic */ MutableState<Boolean> $hasExecuted;
    final /* synthetic */ State<Boolean> $isFirstFeedDataReady$delegate;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KmpNextStoryBottomGuideHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1(MutableState<Boolean> mutableState, KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper, State<Boolean> state, State<kp4.b> state2, State<kp4.b> state3, Continuation<? super KmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1> continuation) {
        super(2, continuation);
        this.$hasExecuted = mutableState;
        this.this$0 = kmpNextStoryBottomGuideHelper;
        this.$isFirstFeedDataReady$delegate = state;
        this.$currentStory$delegate = state2;
        this.$currentBottomStory$delegate = state3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1 kmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1 = new KmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1(this.$hasExecuted, this.this$0, this.$isFirstFeedDataReady$delegate, this.$currentStory$delegate, this.$currentBottomStory$delegate, continuation);
        kmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1.L$0 = obj;
        return kmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean k;
        kp4.b g;
        kp4.b h;
        boolean O;
        boolean z;
        Job job;
        kp4.b g2;
        kp4.b bVar;
        kp4.b bVar2;
        String str;
        Job e;
        tp4.b bVar3;
        String str2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            k = KmpNextStoryBottomGuideHelper.k(this.$isFirstFeedDataReady$delegate);
            if (k && !((Boolean) this.$hasExecuted.getValue()).booleanValue()) {
                KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper = this.this$0;
                g = KmpNextStoryBottomGuideHelper.g(this.$currentStory$delegate);
                h = KmpNextStoryBottomGuideHelper.h(this.$currentBottomStory$delegate);
                O = kmpNextStoryBottomGuideHelper.O(g, h);
                kmpNextStoryBottomGuideHelper.d = O;
                if (!((Boolean) this.this$0.b.getValue()).booleanValue()) {
                    z = this.this$0.d;
                    if (z) {
                        job = this.this$0.i;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        this.this$0.i = null;
                        KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper2 = this.this$0;
                        g2 = KmpNextStoryBottomGuideHelper.g(this.$currentStory$delegate);
                        kmpNextStoryBottomGuideHelper2.f = g2;
                        KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper3 = this.this$0;
                        kmpNextStoryBottomGuideHelper3.g = kmpNextStoryBottomGuideHelper3.a.y.h();
                        bVar = this.this$0.f;
                        if (bVar != null) {
                            KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper4 = this.this$0;
                            bVar2 = kmpNextStoryBottomGuideHelper4.g;
                            if (bVar2 != null) {
                                kmpNextStoryBottomGuideHelper4.Q("pct_5", bVar, bVar2);
                                com.dragon.read.kmp.story.impl.feeds.o oVar = com.dragon.read.kmp.story.impl.feeds.o.a;
                                str = kmpNextStoryBottomGuideHelper4.e;
                                if (str == null) {
                                    str = "";
                                }
                                oVar.b(str);
                                oVar.e();
                                e = kotlinx.coroutines.i.e(coroutineScope, null, null, new KmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1$1$1$1(kmpNextStoryBottomGuideHelper4, null), 3, null);
                                kmpNextStoryBottomGuideHelper4.i = e;
                                bVar3 = kmpNextStoryBottomGuideHelper4.o;
                                StringBuilder sb = new StringBuilder();
                                sb.append("新用户内流引导：当前篇");
                                str2 = kmpNextStoryBottomGuideHelper4.e;
                                sb.append(str2);
                                sb.append(" 开始展示引导");
                                bVar3.d(sb.toString());
                            }
                        }
                    }
                }
                this.$hasExecuted.setValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
