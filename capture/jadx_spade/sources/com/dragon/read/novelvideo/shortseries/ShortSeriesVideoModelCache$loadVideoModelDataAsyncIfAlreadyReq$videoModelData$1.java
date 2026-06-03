package com.dragon.read.novelvideo.shortseries;

import com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$videoModelData$1", f = "ShortSeriesVideoModelCache.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$videoModelData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ShortSeriesVideoModelCache.d>, Object> {
    final /* synthetic */ ShortSeriesVideoModelCache.c $params;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ShortSeriesVideoModelCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$videoModelData$1(ShortSeriesVideoModelCache shortSeriesVideoModelCache, ShortSeriesVideoModelCache.c cVar, Continuation<? super ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$videoModelData$1> continuation) {
        super(2, continuation);
        this.this$0 = shortSeriesVideoModelCache;
        this.$params = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$videoModelData$1(this.this$0, this.$params, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ShortSeriesVideoModelCache.d> continuation) {
        return ((ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$videoModelData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public static final class a implements ShortSeriesVideoModelCache.b {
        final /* synthetic */ CancellableContinuation<ShortSeriesVideoModelCache.d> a;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super ShortSeriesVideoModelCache.d> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        @Override // com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.b
        public void a(ShortSeriesVideoModelCache.d videoModelData) {
            Intrinsics.checkNotNullParameter(videoModelData, "videoModelData");
            this.a.resumeWith(Result.m773constructorimpl(videoModelData));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Continuation intercepted;
        Map map;
        Object coroutine_suspended2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ShortSeriesVideoModelCache shortSeriesVideoModelCache = this.this$0;
            ShortSeriesVideoModelCache.c cVar = this.$params;
            this.L$0 = shortSeriesVideoModelCache;
            this.L$1 = cVar;
            this.label = 1;
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(this);
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            map = shortSeriesVideoModelCache.vid2ReqListenerMap;
            Object obj2 = map.get(cVar.a);
            Intrinsics.checkNotNull(obj2);
            ((List) obj2).add(new a(cancellableContinuationImpl));
            obj = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (obj == coroutine_suspended2) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
