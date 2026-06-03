package com.dragon.read.kmp.mine.model;

import android.content.Context;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.mine.profile.ProfileItemType;
import com.dragon.read.kmp.mine.profile.b2;
import com.dragon.read.kmp.mine.profile.x;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.mine.model.ChangeProfileItemPageViewModel$onSave$2", f = "ChangeProfileItemPageViewModel.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ChangeProfileItemPageViewModel$onSave$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChangeProfileItemPageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChangeProfileItemPageViewModel$onSave$2(ChangeProfileItemPageViewModel changeProfileItemPageViewModel, Continuation<? super ChangeProfileItemPageViewModel$onSave$2> continuation) {
        super(2, continuation);
        this.this$0 = changeProfileItemPageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChangeProfileItemPageViewModel$onSave$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChangeProfileItemPageViewModel$onSave$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        x xVar;
        String L0;
        Context b;
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
            ChangeProfileItemPageViewModel changeProfileItemPageViewModel = this.this$0;
            this.label = 1;
            obj = changeProfileItemPageViewModel.b1(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        b2 b2Var = (b2) obj;
        xVar = this.this$0.c;
        L0 = this.this$0.L0();
        xVar.a(b2Var, L0);
        if (b2Var.a == 0) {
            ProfileItemType type = this.this$0.getType();
            if (type != null) {
                this.this$0.X0(type);
            }
            zm4.d.a.b();
        } else {
            String str = b2Var.b;
            if (str != null && (!StringsKt__StringsKt.isBlank(str)) && (b = ig4.f.b()) != null) {
                ig4.g.d(b, str, (ToastDuration) null, 4, (Object) null);
            }
        }
        return Unit.INSTANCE;
    }
}
