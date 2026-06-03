package com.dragon.read.kmp.story.impl;

import android.graphics.Bitmap;
import com.dragon.read.util.ImageLoaderUtils;
import com.dragon.read.util.PictureUtils;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.KmpStoryPlatformHelper$extractHslFromImage$2", f = "PlatformExpect.android.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class KmpStoryPlatformHelper$extractHslFromImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super float[]>, Object> {
    final /* synthetic */ float[] $defaultHsl;
    final /* synthetic */ CompletableDeferred<float[]> $result;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KmpStoryPlatformHelper$extractHslFromImage$2(String str, CompletableDeferred<float[]> completableDeferred, float[] fArr, Continuation<? super KmpStoryPlatformHelper$extractHslFromImage$2> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$result = completableDeferred;
        this.$defaultHsl = fArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpStoryPlatformHelper$extractHslFromImage$2(this.$url, this.$result, this.$defaultHsl, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super float[]> continuation) {
        return ((KmpStoryPlatformHelper$extractHslFromImage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public static final class a implements ImageLoaderUtils.w {
        final /* synthetic */ CompletableDeferred<float[]> a;
        final /* synthetic */ float[] b;

        public void a(Throwable th) {
            this.a.complete(this.b);
        }

        public void b(Bitmap bitmap) {
            float[] fArr;
            if (bitmap != null) {
                fArr = PictureUtils.getColorHSLByPalette(bitmap, this.b);
            } else {
                fArr = this.b;
            }
            CompletableDeferred<float[]> completableDeferred = this.a;
            Intrinsics.checkNotNull(fArr);
            completableDeferred.complete(fArr);
        }

        a(CompletableDeferred<float[]> completableDeferred, float[] fArr) {
            this.a = completableDeferred;
            this.b = fArr;
        }
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
            ImageLoaderUtils.downloadImage(this.$url, new a(this.$result, this.$defaultHsl));
            CompletableDeferred<float[]> completableDeferred = this.$result;
            this.label = 1;
            obj = completableDeferred.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
