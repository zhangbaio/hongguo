package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class FutureKt$asCompletableFuture$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CompletableFuture<Object> $future;
    final /* synthetic */ Deferred<Object> $this_asCompletableFuture;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FutureKt$asCompletableFuture$1(CompletableFuture<Object> completableFuture, Deferred<Object> deferred) {
        super(1);
        this.$future = completableFuture;
        this.$this_asCompletableFuture = deferred;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        try {
            this.$future.complete(this.$this_asCompletableFuture.getCompleted());
        } catch (Throwable th2) {
            this.$future.completeExceptionally(th2);
        }
    }
}
