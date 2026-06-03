package com.dragon.read.kmp.story.impl.feeds.guide;

import com.bytedance.kmp.ugc.model.InsideContentScene;
import com.bytedance.kmp.ugc.model.UgcRelativeType;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.guide.KmpBaseStoryExitAlertHelper$prepareExitRecommendStory$1", f = "KmpBaseStoryExitAlertHelper.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpBaseStoryExitAlertHelper$prepareExitRecommendStory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KmpBaseStoryExitAlertHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpBaseStoryExitAlertHelper$prepareExitRecommendStory$1(KmpBaseStoryExitAlertHelper kmpBaseStoryExitAlertHelper, Continuation<? super KmpBaseStoryExitAlertHelper$prepareExitRecommendStory$1> continuation) {
        super(2, continuation);
        this.this$0 = kmpBaseStoryExitAlertHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpBaseStoryExitAlertHelper$prepareExitRecommendStory$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KmpBaseStoryExitAlertHelper$prepareExitRecommendStory$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        yo4.d dVar;
        yo4.d dVar2;
        yo4.d dVar3;
        yo4.d dVar4;
        Object d;
        float f;
        MutableStateFlow mutableStateFlow;
        yo4.d dVar5;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                d = ((Result) obj).m782unboximpl();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ip4.a aVar = new ip4.a();
            KmpBaseStoryExitAlertHelper kmpBaseStoryExitAlertHelper = this.this$0;
            aVar.k = Boxing.boxInt(InsideContentScene.StoryInnerFeedQuit.getValue());
            aVar.b = Boxing.boxInt(1);
            aVar.c = Boxing.boxInt(UgcRelativeType.Post.getValue());
            dVar = kmpBaseStoryExitAlertHelper.a;
            aVar.d = dVar.e;
            dVar2 = kmpBaseStoryExitAlertHelper.a;
            aVar.i = dVar2.g;
            dVar3 = kmpBaseStoryExitAlertHelper.a;
            aVar.j = Boxing.boxInt(dVar3.h);
            dVar4 = kmpBaseStoryExitAlertHelper.a;
            aVar.m = Boxing.boxInt(dVar4.f);
            StoryDataSource storyDataSource = StoryDataSource.a;
            this.label = 1;
            d = storyDataSource.d(aVar, this);
            if (d == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (Result.m779isFailureimpl(d)) {
            d = null;
        }
        com.dragon.read.kmp.story.impl.feeds.data.g gVar = (com.dragon.read.kmp.story.impl.feeds.data.g) d;
        if (gVar != null) {
            f = this.this$0.b;
            b1 b1Var = b1.a;
            op4.b bVar = new op4.b(f, b1Var.q(), b1Var.o());
            ArrayList arrayList = new ArrayList();
            List<com.dragon.read.kmp.story.impl.feeds.data.e> list = gVar.a;
            KmpBaseStoryExitAlertHelper kmpBaseStoryExitAlertHelper2 = this.this$0;
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                com.dragon.read.kmp.story.impl.feeds.data.b b = op4.b.b(bVar, (com.dragon.read.kmp.story.impl.feeds.data.e) it2.next(), false, 2, null);
                String e = b.e();
                kp4.d dVar6 = new kp4.d("related_recommend");
                dVar5 = kmpBaseStoryExitAlertHelper2.a;
                arrayList.add(new kp4.b(e, b, dVar6, dVar5));
            }
            mutableStateFlow = this.this$0.f;
            mutableStateFlow.setValue(arrayList);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
