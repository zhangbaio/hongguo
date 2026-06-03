package com.dragon.read.kmp.profile.justsaw;

import androidx.compose.runtime.SnapshotStateKt;
import com.dragon.read.kmp.compose.common.list.ScrollableListState;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@DebugMetadata(c = "com.dragon.read.kmp.profile.justsaw.ProfileTabJustSawViewModel$showJustSawButtonFirstEnter$1", f = "ProfileTabJustSawViewModel.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ProfileTabJustSawViewModel$showJustSawButtonFirstEnter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollableListState $scrollListState;
    int label;
    final /* synthetic */ ProfileTabJustSawViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileTabJustSawViewModel$showJustSawButtonFirstEnter$1(ScrollableListState scrollableListState, ProfileTabJustSawViewModel profileTabJustSawViewModel, Continuation<? super ProfileTabJustSawViewModel$showJustSawButtonFirstEnter$1> continuation) {
        super(2, continuation);
        this.$scrollListState = scrollableListState;
        this.this$0 = profileTabJustSawViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileTabJustSawViewModel$showJustSawButtonFirstEnter$1(this.$scrollListState, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileTabJustSawViewModel$showJustSawButtonFirstEnter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final ScrollableListState scrollableListState = this.$scrollListState;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.profile.justsaw.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    List i2;
                    i2 = scrollableListState.i();
                    return i2;
                }
            });
            a aVar = new a(this.this$0, this.$scrollListState);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ ProfileTabJustSawViewModel a;
        final /* synthetic */ ScrollableListState b;

        a(ProfileTabJustSawViewModel profileTabJustSawViewModel, ScrollableListState scrollableListState) {
            this.a = profileTabJustSawViewModel;
            this.b = scrollableListState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(List<? extends Object> list, Continuation<? super Unit> continuation) {
            int i;
            T t;
            boolean g;
            int i2;
            int i3;
            boolean z;
            ProfileTabJustSawViewModel profileTabJustSawViewModel = this.a;
            if (!profileTabJustSawViewModel.e.b) {
                i = profileTabJustSawViewModel.k;
                if (i != -1) {
                    List i4 = this.b.i();
                    ProfileTabJustSawViewModel profileTabJustSawViewModel2 = this.a;
                    Iterator<T> it2 = i4.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            t = it2.next();
                            i2 = profileTabJustSawViewModel2.i(t);
                            i3 = profileTabJustSawViewModel2.k;
                            if (i2 == i3) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                break;
                            }
                        } else {
                            t = null;
                            break;
                        }
                    }
                    if (t != null) {
                        g = this.a.g(t, this.b.f());
                        if (g) {
                            ProfileTabJustSawViewModel.p(this.a, false, 1, null);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
