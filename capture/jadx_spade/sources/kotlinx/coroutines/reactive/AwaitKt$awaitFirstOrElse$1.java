package kotlinx.coroutines.reactive;

import com.ss.ttvideoengine.log.IVideoEventLogger;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "kotlinx.coroutines.reactive.AwaitKt", f = "Await.kt", i = {0}, l = {IVideoEventLogger.LOGGER_OPTION_IS_DEGRADE_RELEASE}, m = "awaitFirstOrElse", n = {"defaultValue"}, s = {"L$0"})
/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class AwaitKt$awaitFirstOrElse$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    AwaitKt$awaitFirstOrElse$1(Continuation<? super AwaitKt$awaitFirstOrElse$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.c(null, null, this);
    }
}
