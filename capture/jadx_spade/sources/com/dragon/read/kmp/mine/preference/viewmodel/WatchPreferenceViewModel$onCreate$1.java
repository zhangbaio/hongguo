package com.dragon.read.kmp.mine.preference.viewmodel;

import androidx.compose.runtime.MutableState;
import com.bytedance.kmp.reading.model.dl;
import com.bytedance.kmp.reading.model.k00;
import com.dragon.read.kmp.service.c0;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import xn0.b;

@DebugMetadata(c = "com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel$onCreate$1", f = "WatchPreferenceViewModel.kt", i = {}, l = {67, 68}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class WatchPreferenceViewModel$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WatchPreferenceViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchPreferenceViewModel$onCreate$1(WatchPreferenceViewModel watchPreferenceViewModel, Continuation<? super WatchPreferenceViewModel$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = watchPreferenceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchPreferenceViewModel$onCreate$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchPreferenceViewModel$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel$onCreate$1$1", f = "WatchPreferenceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.mine.preference.viewmodel.WatchPreferenceViewModel$onCreate$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isUnselected;
        int label;
        final /* synthetic */ WatchPreferenceViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, WatchPreferenceViewModel watchPreferenceViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isUnselected = z;
            this.this$0 = watchPreferenceViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isUnselected, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableState mutableState;
            MutableState mutableState2;
            MutableState mutableState3;
            List list;
            boolean z;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.$isUnselected) {
                    mutableState = this.this$0.e;
                    WatchPreferenceViewModel watchPreferenceViewModel = this.this$0;
                    k00 k00Var = watchPreferenceViewModel.a.d;
                    Object obj2 = null;
                    if (k00Var != null && (list = k00Var.b) != null) {
                        Iterator it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next = it2.next();
                            dl dlVar = (dl) next;
                            if (Intrinsics.areEqual(dlVar.c, Boxing.boxBoolean(watchPreferenceViewModel.a.c)) && Intrinsics.areEqual(dlVar.b, watchPreferenceViewModel.a.b)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                obj2 = next;
                                break;
                            }
                        }
                        obj2 = (dl) obj2;
                    }
                    mutableState.setValue(obj2);
                    mutableState2 = this.this$0.g;
                    mutableState3 = this.this$0.e;
                    mutableState2.setValue(mutableState3.getValue());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
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
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            WatchPreferenceViewModel watchPreferenceViewModel = this.this$0;
            this.label = 1;
            obj = watchPreferenceViewModel.Q0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        boolean z = ((b) obj).getBoolean("kmp_watch_preference_gender_unselected" + c0.a.getUserId(), false);
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(z, this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
