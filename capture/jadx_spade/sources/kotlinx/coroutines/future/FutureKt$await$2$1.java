package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class FutureKt$await$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ a<Object> $consumer;
    final /* synthetic */ CompletableFuture<Object> $future;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FutureKt$await$2$1(CompletableFuture<Object> completableFuture, a<Object> aVar) {
        super(1);
        this.$future = completableFuture;
        this.$consumer = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$future.cancel(false);
        this.$consumer.cont = null;
    }
}
