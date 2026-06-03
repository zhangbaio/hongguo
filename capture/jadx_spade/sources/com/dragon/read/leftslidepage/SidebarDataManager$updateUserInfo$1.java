package com.dragon.read.leftslidepage;

import androidx.compose.runtime.MutableState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.leftslidepage.SidebarDataManager$updateUserInfo$1", f = "SidebarDataManager.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SidebarDataManager$updateUserInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SidebarDataManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SidebarDataManager$updateUserInfo$1(SidebarDataManager sidebarDataManager, Continuation<? super SidebarDataManager$updateUserInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = sidebarDataManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SidebarDataManager$updateUserInfo$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SidebarDataManager$updateUserInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        s sVar;
        Object l;
        MutableState<v> mutableState;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            sVar = this.this$0.d;
            if (sVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sidebarInfo");
                sVar = null;
            }
            MutableState<v> mutableState2 = sVar.a;
            SidebarDataManager sidebarDataManager = this.this$0;
            this.L$0 = mutableState2;
            this.label = 1;
            l = sidebarDataManager.l(this);
            if (l == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableState = mutableState2;
            obj = l;
        }
        mutableState.setValue(obj);
        return Unit.INSTANCE;
    }
}
