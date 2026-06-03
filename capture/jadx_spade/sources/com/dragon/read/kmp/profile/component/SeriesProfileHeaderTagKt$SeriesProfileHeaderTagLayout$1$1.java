package com.dragon.read.kmp.profile.component;

import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.profile.component.SeriesProfileHeaderTagKt$SeriesProfileHeaderTagLayout$1$1", f = "SeriesProfileHeaderTag.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class SeriesProfileHeaderTagKt$SeriesProfileHeaderTagLayout$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<r> $tagDataList;
    final /* synthetic */ String $tagPosition;
    final /* synthetic */ GuestProfileViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeriesProfileHeaderTagKt$SeriesProfileHeaderTagLayout$1$1(List<r> list, GuestProfileViewModel guestProfileViewModel, String str, Continuation<? super SeriesProfileHeaderTagKt$SeriesProfileHeaderTagLayout$1$1> continuation) {
        super(2, continuation);
        this.$tagDataList = list;
        this.$viewModel = guestProfileViewModel;
        this.$tagPosition = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeriesProfileHeaderTagKt$SeriesProfileHeaderTagLayout$1$1(this.$tagDataList, this.$viewModel, this.$tagPosition, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeriesProfileHeaderTagKt$SeriesProfileHeaderTagLayout$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String u;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            com.dragon.read.kmp.r rVar = com.dragon.read.kmp.r.a;
            String e = rVar.e();
            String d = rVar.d();
            List<r> list = this.$tagDataList;
            GuestProfileViewModel guestProfileViewModel = this.$viewModel;
            String str = this.$tagPosition;
            for (r rVar2 : list) {
                u = SeriesProfileHeaderTagKt.u(rVar2.d);
                com.dragon.read.kmp.r.v(com.dragon.read.kmp.r.a, guestProfileViewModel.r0(), u, str, e, d, (String) null, 32, (Object) null);
                com.dragon.read.kmp.star_fans.e.a.b(rVar2.d.a, true, "actor_profile");
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
