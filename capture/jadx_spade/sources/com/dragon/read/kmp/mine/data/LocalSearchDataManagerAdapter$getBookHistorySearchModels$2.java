package com.dragon.read.kmp.mine.data;

import com.dragon.read.component.biz.api.NsBookshelfApi;
import com.dragon.read.local.db.entity.RecordModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.data.LocalSearchDataManagerAdapter$getBookHistorySearchModels$2", f = "LocalSearchDataManagerAdapter.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class LocalSearchDataManagerAdapter$getBookHistorySearchModels$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<b>>, Object> {
    int label;

    LocalSearchDataManagerAdapter$getBookHistorySearchModels$2(Continuation<? super LocalSearchDataManagerAdapter$getBookHistorySearchModels$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalSearchDataManagerAdapter$getBookHistorySearchModels$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<b>> continuation) {
        return ((LocalSearchDataManagerAdapter$getBookHistorySearchModels$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<com.dragon.read.pages.video.model.a> list = (List) NsBookshelfApi.IMPL.apiFetcher().f().blockingGet();
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNull(list);
            for (com.dragon.read.pages.video.model.a aVar : list) {
                if (aVar instanceof com.dragon.read.pages.video.model.a) {
                    arrayList.add(LocalSearchDataManagerAdapter.a.b(aVar));
                } else if (aVar instanceof RecordModel) {
                    arrayList.add(LocalSearchDataManagerAdapter.a.a((RecordModel) aVar));
                } else {
                    b bVar = new b();
                    bVar.h = aVar.getId();
                    bVar.e = aVar.getProgressPercent();
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
