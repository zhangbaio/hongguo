package kotlinx.coroutines.rx2;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.selects.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
/* synthetic */ class RxObservableCoroutine$onSend$1 extends FunctionReferenceImpl implements Function3<RxObservableCoroutine<?>, h<?>, Object, Unit> {
    public static final RxObservableCoroutine$onSend$1 INSTANCE = new RxObservableCoroutine$onSend$1();

    RxObservableCoroutine$onSend$1() {
        super(3, RxObservableCoroutine.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RxObservableCoroutine<?> rxObservableCoroutine, h<?> hVar, Object obj) {
        rxObservableCoroutine.S0(hVar, obj);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(RxObservableCoroutine<?> rxObservableCoroutine, h<?> hVar, Object obj) {
        invoke2(rxObservableCoroutine, hVar, obj);
        return Unit.INSTANCE;
    }
}
