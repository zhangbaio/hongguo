package com.dragon.read.kmp.reader.ui.menu.moresettings;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@DebugMetadata(c = "com.dragon.read.kmp.reader.ui.menu.moresettings.LockTimePickerPanelKt$WheelPicker$1$1", f = "LockTimePickerPanel.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_SET_SUPER_RES_STRENGTH}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class LockTimePickerPanelKt$WheelPicker$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $initialIndex;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ Function1<Integer, Unit> $onSelectionChanged;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LockTimePickerPanelKt$WheelPicker$1$1(int i, LazyListState lazyListState, Function1<? super Integer, Unit> function1, Continuation<? super LockTimePickerPanelKt$WheelPicker$1$1> continuation) {
        super(2, continuation);
        this.$initialIndex = i;
        this.$listState = lazyListState;
        this.$onSelectionChanged = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LockTimePickerPanelKt$WheelPicker$1$1(this.$initialIndex, this.$listState, this.$onSelectionChanged, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LockTimePickerPanelKt$WheelPicker$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$0(LazyListState lazyListState) {
        return TuplesKt.to(Boolean.valueOf(lazyListState.b()), lazyListState.x());
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
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = this.$initialIndex;
            final LazyListState lazyListState = this.$listState;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.dragon.read.kmp.reader.ui.menu.moresettings.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Pair invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = LockTimePickerPanelKt$WheelPicker$1$1.invokeSuspend$lambda$0(lazyListState);
                    return invokeSuspend$lambda$0;
                }
            });
            a aVar = new a(ref$IntRef, this.$onSelectionChanged);
            this.label = 1;
            if (snapshotFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ Ref$IntRef a;
        final /* synthetic */ Function1<Integer, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Ref$IntRef ref$IntRef, Function1<? super Integer, Unit> function1) {
            this.a = ref$IntRef;
            this.b = function1;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Pair<Boolean, ? extends androidx.compose.foundation.lazy.x> pair, Continuation<? super Unit> continuation) {
            T t;
            boolean booleanValue = pair.component1().booleanValue();
            androidx.compose.foundation.lazy.x component2 = pair.component2();
            int b = (component2.b() + component2.c()) / 2;
            Iterator<T> it2 = component2.h().iterator();
            if (!it2.hasNext()) {
                t = null;
            } else {
                T next = it2.next();
                if (it2.hasNext()) {
                    androidx.compose.foundation.lazy.o oVar = (androidx.compose.foundation.lazy.o) next;
                    int abs = Math.abs((oVar.getOffset() + (oVar.getSize() / 2)) - b);
                    do {
                        T next2 = it2.next();
                        androidx.compose.foundation.lazy.o oVar2 = (androidx.compose.foundation.lazy.o) next2;
                        int abs2 = Math.abs((oVar2.getOffset() + (oVar2.getSize() / 2)) - b);
                        if (abs > abs2) {
                            next = next2;
                            abs = abs2;
                        }
                    } while (it2.hasNext());
                }
                t = next;
            }
            androidx.compose.foundation.lazy.o oVar3 = (androidx.compose.foundation.lazy.o) t;
            if (oVar3 == null) {
                return Unit.INSTANCE;
            }
            int abs3 = Math.abs((oVar3.getOffset() + (oVar3.getSize() / 2)) - b);
            float size = oVar3.getSize() * 0.3f;
            if (!booleanValue || abs3 < size) {
                int index = oVar3.getIndex();
                Ref$IntRef ref$IntRef = this.a;
                if (index != ref$IntRef.element) {
                    ref$IntRef.element = oVar3.getIndex();
                    this.b.invoke(Boxing.boxInt(oVar3.getIndex()));
                }
            }
            return Unit.INSTANCE;
        }
    }
}
