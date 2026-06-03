package com.dragon.read.kmp.share.business.series;

import com.bytedance.kmp.reading.model.jb0;
import com.bytedance.kmp.reading.model.lb0;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.json.JsonObject;

@DebugMetadata(c = "com.dragon.read.kmp.share.business.series.VideoPlayerSharePanelController$preparePostShareParams$tryComplete$1", f = "VideoPlayerSharePanelController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class VideoPlayerSharePanelController$preparePostShareParams$tryComplete$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ un4.e $kmpShareContent;
    final /* synthetic */ un4.h $localBgBitmap;
    final /* synthetic */ un4.h $localCoverBitmap;
    final /* synthetic */ String $localShortUrl;
    final /* synthetic */ un4.f $pair;
    final /* synthetic */ jb0 $shareInfoData;
    int label;
    final /* synthetic */ VideoPlayerSharePanelController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerSharePanelController$preparePostShareParams$tryComplete$1(VideoPlayerSharePanelController videoPlayerSharePanelController, un4.h hVar, un4.h hVar2, un4.f fVar, String str, un4.e eVar, jb0 jb0Var, Continuation<? super VideoPlayerSharePanelController$preparePostShareParams$tryComplete$1> continuation) {
        super(1, continuation);
        this.this$0 = videoPlayerSharePanelController;
        this.$localCoverBitmap = hVar;
        this.$localBgBitmap = hVar2;
        this.$pair = fVar;
        this.$localShortUrl = str;
        this.$kmpShareContent = eVar;
        this.$shareInfoData = jb0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new VideoPlayerSharePanelController$preparePostShareParams$tryComplete$1(this.this$0, this.$localCoverBitmap, this.$localBgBitmap, this.$pair, this.$localShortUrl, this.$kmpShareContent, this.$shareInfoData, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((VideoPlayerSharePanelController$preparePostShareParams$tryComplete$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        yn4.b bVar;
        o oVar;
        Function0 function0;
        String str3;
        String str4;
        String str5;
        JsonObject jsonObject;
        String str6;
        String g;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            VideoPlayerSharePanelController videoPlayerSharePanelController = this.this$0;
            e0 B = this.this$0.B();
            String str7 = "";
            if (B == null || (str = ((bh1.b) B).b) == null) {
                str = "";
            }
            e0 B2 = this.this$0.B();
            if (B2 == null || (str2 = ((bh1.b) B2).c) == null) {
                str2 = "";
            }
            e0 B3 = this.this$0.B();
            if (B3 != null) {
                bVar = B3.h;
            } else {
                bVar = null;
            }
            videoPlayerSharePanelController.l = new o("video_player_poster", str, str2, bVar);
            oVar = this.this$0.l;
            if (oVar != null) {
                VideoPlayerSharePanelController videoPlayerSharePanelController2 = this.this$0;
                un4.h hVar = this.$localCoverBitmap;
                un4.h hVar2 = this.$localBgBitmap;
                un4.f fVar = this.$pair;
                String str8 = this.$localShortUrl;
                un4.e eVar = this.$kmpShareContent;
                jb0 jb0Var = this.$shareInfoData;
                oVar.e("video_player_poster");
                e0 B4 = videoPlayerSharePanelController2.B();
                if (B4 == null || (str3 = ((bh1.b) B4).b) == null) {
                    str3 = "";
                }
                oVar.b(str3);
                e0 B5 = videoPlayerSharePanelController2.B();
                if (B5 == null || (str4 = ((bh1.b) B5).c) == null) {
                    str4 = "";
                }
                oVar.c(str4);
                oVar.o = videoPlayerSharePanelController2.B();
                oVar.p = hVar;
                oVar.q = hVar2;
                oVar.r = fVar;
                oVar.s = true;
                oVar.t = "扫码后免费观看全集";
                oVar.j.setValue(str8);
                oVar.m = eVar.i;
                com.dragon.read.kmp.utils.v vVar = com.dragon.read.kmp.utils.v.a;
                lb0 lb0Var = jb0Var.c;
                if (lb0Var != null) {
                    str5 = lb0Var.c;
                } else {
                    str5 = null;
                }
                JsonObject g2 = vVar.g(str5);
                if (g2 instanceof JsonObject) {
                    jsonObject = g2;
                } else {
                    jsonObject = null;
                }
                if (jsonObject == null || (str6 = com.dragon.read.kmp.utils.w.g(jsonObject, "title", null, 2, null)) == null) {
                    str6 = "";
                }
                oVar.u = str6;
                if (jsonObject != null && (g = com.dragon.read.kmp.utils.w.g(jsonObject, "detail", null, 2, null)) != null) {
                    str7 = g;
                }
                oVar.v = str7;
            }
            this.this$0.k = false;
            function0 = this.this$0.m;
            if (function0 != null) {
                function0.invoke();
            }
            this.this$0.m = null;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
