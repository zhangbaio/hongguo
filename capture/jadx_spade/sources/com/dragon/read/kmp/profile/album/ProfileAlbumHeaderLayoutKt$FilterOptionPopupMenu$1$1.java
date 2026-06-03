package com.dragon.read.kmp.profile.album;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.n1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.dragon.read.kmp.profile.album.ProfileAlbumHeaderLayoutKt$FilterOptionPopupMenu$1$1", f = "ProfileAlbumHeaderLayout.kt", i = {}, l = {403, 410}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileAlbumHeaderLayoutKt$FilterOptionPopupMenu$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $animDuration;
    final /* synthetic */ MutableState<Boolean> $animateVisible$delegate;
    final /* synthetic */ MutableState<Boolean> $shouldExist$delegate;
    final /* synthetic */ boolean $show;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileAlbumHeaderLayoutKt$FilterOptionPopupMenu$1$1(boolean z, int i, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, Continuation<? super ProfileAlbumHeaderLayoutKt$FilterOptionPopupMenu$1$1> continuation) {
        super(2, continuation);
        this.$show = z;
        this.$animDuration = i;
        this.$shouldExist$delegate = mutableState;
        this.$animateVisible$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileAlbumHeaderLayoutKt$FilterOptionPopupMenu$1$1(this.$show, this.$animDuration, this.$shouldExist$delegate, this.$animateVisible$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileAlbumHeaderLayoutKt$FilterOptionPopupMenu$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(long j) {
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    ProfileAlbumHeaderLayoutKt.y(this.$shouldExist$delegate, false);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ProfileAlbumHeaderLayoutKt.A(this.$animateVisible$delegate, true);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (this.$show) {
                ProfileAlbumHeaderLayoutKt.y(this.$shouldExist$delegate, true);
                Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.album.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ProfileAlbumHeaderLayoutKt$FilterOptionPopupMenu$1$1.invokeSuspend$lambda$0(((Long) obj2).longValue());
                        return invokeSuspend$lambda$0;
                    }
                };
                this.label = 1;
                if (n1.c(function1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ProfileAlbumHeaderLayoutKt.A(this.$animateVisible$delegate, true);
            } else {
                ProfileAlbumHeaderLayoutKt.A(this.$animateVisible$delegate, false);
                long j = this.$animDuration;
                this.label = 2;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ProfileAlbumHeaderLayoutKt.y(this.$shouldExist$delegate, false);
            }
        }
        return Unit.INSTANCE;
    }
}
