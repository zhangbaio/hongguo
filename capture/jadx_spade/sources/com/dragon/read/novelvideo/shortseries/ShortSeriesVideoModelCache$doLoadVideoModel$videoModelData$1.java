package com.dragon.read.novelvideo.shortseries;

import com.dragon.read.base.util.LogHelper;
import com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache;
import com.dragon.read.social.videorecommendbook.VideoRecBookDataHelper;
import com.ss.ttvideoengine.PreloaderVideoModelItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoModel;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import pq3.i;
import seriessdk.com.dragon.read.saas.rpc.model.GetVideoModelResponse;

@DebugMetadata(c = "com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1", f = "ShortSeriesVideoModelCache.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ShortSeriesVideoModelCache.d>, Object> {
    final /* synthetic */ ShortSeriesVideoModelCache.c $params;
    int label;
    final /* synthetic */ ShortSeriesVideoModelCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1(ShortSeriesVideoModelCache.c cVar, ShortSeriesVideoModelCache shortSeriesVideoModelCache, Continuation<? super ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1> continuation) {
        super(2, continuation);
        this.$params = cVar;
        this.this$0 = shortSeriesVideoModelCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1(this.$params, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ShortSeriesVideoModelCache.d> continuation) {
        return ((ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
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
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$params, this.this$0, null);
            this.label = 1;
            obj = BuildersKt.withContext(io2, anonymousClass1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @DebugMetadata(c = "com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1$1", f = "ShortSeriesVideoModelCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ShortSeriesVideoModelCache.d>, Object> {
        final /* synthetic */ ShortSeriesVideoModelCache.c $params;
        int label;
        final /* synthetic */ ShortSeriesVideoModelCache this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ShortSeriesVideoModelCache.c cVar, ShortSeriesVideoModelCache shortSeriesVideoModelCache, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$params = cVar;
            this.this$0 = shortSeriesVideoModelCache;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$params, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ShortSeriesVideoModelCache.d> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            LogHelper logHelper;
            VideoModel convertVideoModel;
            String str;
            Map map;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                VideoRecBookDataHelper videoRecBookDataHelper = VideoRecBookDataHelper.a;
                ShortSeriesVideoModelCache.c cVar = this.$params;
                GetVideoModelResponse getVideoModelResponse = (GetVideoModelResponse) videoRecBookDataHelper.B(cVar.a, cVar.b, cVar.c).blockingSingle();
                logHelper = ShortSeriesVideoModelCache.log;
                logHelper.i(this.$params.a + ". 拉数据成功", new Object[0]);
                String str2 = getVideoModelResponse.data.videoModel;
                if (str2 == null) {
                    throw new Exception("videoModel is empty.");
                }
                convertVideoModel = this.this$0.convertVideoModel(str2);
                PreloaderVideoModelItem preloaderVideoModelItem = new PreloaderVideoModelItem(convertVideoModel, Resolution.Standard, 1048576L, i.c.a().c());
                str = this.this$0.tag;
                preloaderVideoModelItem.setTag(str);
                TTVideoEngine.addTask(preloaderVideoModelItem);
                ShortSeriesVideoModelCache.d dVar = new ShortSeriesVideoModelCache.d(str2, ShortSeriesVideoModelCache.VideoModelWrapperType.FROM_NET, this.$params.a, null, 8, null);
                map = this.this$0.vid2VideoModelDataMap;
                map.put(this.$params.a, dVar);
                return dVar;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
