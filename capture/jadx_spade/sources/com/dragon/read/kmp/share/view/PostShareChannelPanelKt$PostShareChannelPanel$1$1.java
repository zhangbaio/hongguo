package com.dragon.read.kmp.share.view;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.share.view.PostShareChannelPanelKt$PostShareChannelPanel$1$1", f = "PostShareChannelPanel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class PostShareChannelPanelKt$PostShareChannelPanel$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $canShowQrVisibleSwitch;
    final /* synthetic */ MutableState<Boolean> $isShowQrScan$delegate;
    final /* synthetic */ Function1<Boolean, Unit> $onQrScanChange;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PostShareChannelPanelKt$PostShareChannelPanel$1$1(boolean z, Function1<? super Boolean, Unit> function1, MutableState<Boolean> mutableState, Continuation<? super PostShareChannelPanelKt$PostShareChannelPanel$1$1> continuation) {
        super(2, continuation);
        this.$canShowQrVisibleSwitch = z;
        this.$onQrScanChange = function1;
        this.$isShowQrScan$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostShareChannelPanelKt$PostShareChannelPanel$1$1(this.$canShowQrVisibleSwitch, this.$onQrScanChange, this.$isShowQrScan$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PostShareChannelPanelKt$PostShareChannelPanel$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean d;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.$canShowQrVisibleSwitch) {
                d = PostShareChannelPanelKt.d(this.$isShowQrScan$delegate);
                if (d) {
                    PostShareChannelPanelKt.g(this.$isShowQrScan$delegate, false);
                    this.$onQrScanChange.invoke(Boxing.boxBoolean(false));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
