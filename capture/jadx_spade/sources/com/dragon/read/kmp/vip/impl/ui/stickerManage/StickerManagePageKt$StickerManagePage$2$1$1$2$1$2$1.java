package com.dragon.read.kmp.vip.impl.ui.stickerManage;

import com.dragon.read.kmp.service.b1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.vip.impl.ui.stickerManage.StickerManagePageKt$StickerManagePage$2$1$1$2$1$2$1", f = "StickerManagePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class StickerManagePageKt$StickerManagePage$2$1$1$2$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPause;
    final /* synthetic */ boolean $isSuccess;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StickerManagePageKt$StickerManagePage$2$1$1$2$1$2$1(boolean z, boolean z2, Continuation<? super StickerManagePageKt$StickerManagePage$2$1$1$2$1$2$1> continuation) {
        super(2, continuation);
        this.$isSuccess = z;
        this.$isPause = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StickerManagePageKt$StickerManagePage$2$1$1$2$1$2$1(this.$isSuccess, this.$isPause, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StickerManagePageKt$StickerManagePage$2$1$1$2$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = this.$isSuccess;
            if (z && !this.$isPause) {
                b1.a.D("使用成功");
            } else if (z && this.$isPause) {
                b1.a.D("已暂停使用");
            } else if (!z && !this.$isPause) {
                b1.a.D("使用失败，请重试");
            } else {
                b1.a.D("暂停失败，请重试");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
