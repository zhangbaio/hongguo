package com.dragon.read.kmp.mine.preference.widget;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.kmp.reading.model.j00;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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

@DebugMetadata(c = "com.dragon.read.kmp.mine.preference.widget.WatchPreferencePinLayoutKt$WatchPreferencePinLayout$1$1$1", f = "WatchPreferencePinLayout.kt", i = {}, l = {ConstantsAPI.COMMAND_OPEN_QRCODE_PAY}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class WatchPreferencePinLayoutKt$WatchPreferencePinLayout$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Integer> $currentScrollIndex$delegate;
    final /* synthetic */ LazyListState $it;
    final /* synthetic */ List<j00> $preferenceDataList;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchPreferencePinLayoutKt$WatchPreferencePinLayout$1$1$1(LazyListState lazyListState, List<j00> list, MutableState<Integer> mutableState, Continuation<? super WatchPreferencePinLayoutKt$WatchPreferencePinLayout$1$1$1> continuation) {
        super(2, continuation);
        this.$it = lazyListState;
        this.$preferenceDataList = list;
        this.$currentScrollIndex$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchPreferencePinLayoutKt$WatchPreferencePinLayout$1$1$1(this.$it, this.$preferenceDataList, this.$currentScrollIndex$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchPreferencePinLayoutKt$WatchPreferencePinLayout$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(LazyListState lazyListState) {
        return TuplesKt.to(Integer.valueOf(lazyListState.u()), Boolean.valueOf(lazyListState.c()));
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
            final LazyListState lazyListState = this.$it;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.mine.preference.widget.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Pair invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = WatchPreferencePinLayoutKt$WatchPreferencePinLayout$1$1$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            });
            a aVar = new a(this.$preferenceDataList, this.$currentScrollIndex$delegate);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ List<j00> a;
        final /* synthetic */ MutableState<Integer> b;

        a(List<j00> list, MutableState<Integer> mutableState) {
            this.a = list;
            this.b = mutableState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Pair<Integer, Boolean> pair, Continuation<? super Unit> continuation) {
            List<j00> list;
            int intValue = pair.component1().intValue();
            boolean booleanValue = pair.component2().booleanValue();
            MutableState<Integer> mutableState = this.b;
            if (!booleanValue && (list = this.a) != null) {
                intValue = list.size() - 1;
            }
            WatchPreferencePinLayoutKt.e(mutableState, intValue);
            return Unit.INSTANCE;
        }
    }
}
