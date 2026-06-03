package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class FutureKt$asCompletableFuture$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CompletableFuture<Unit> $future;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FutureKt$asCompletableFuture$2(CompletableFuture<Unit> completableFuture) {
        super(1);
        this.$future = completableFuture;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        if (th == null) {
            this.$future.complete(Unit.INSTANCE);
        } else {
            this.$future.completeExceptionally(th);
        }
    }
}
