package com.dragon.read.kmp.mine.model;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.mine.model.ChangeProfilePageViewModel", f = "ChangeProfilePageViewModel.kt", i = {0, 0, 0, 0, 0}, l = {313}, m = "setProfile", n = {"avatarChanged", "userNameChanged", "genderChanged", "descriptionChanged", "bizUserIdChanged"}, s = {"I$0", "I$1", "I$2", "I$3", "I$4"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ChangeProfilePageViewModel$setProfile$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChangeProfilePageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChangeProfilePageViewModel$setProfile$1(ChangeProfilePageViewModel changeProfilePageViewModel, Continuation<? super ChangeProfilePageViewModel$setProfile$1> continuation) {
        super(continuation);
        this.this$0 = changeProfilePageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object u1;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        u1 = this.this$0.u1(this);
        return u1;
    }
}
