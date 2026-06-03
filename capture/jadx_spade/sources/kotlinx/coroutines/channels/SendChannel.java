package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.e0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SendChannel<E> {
    boolean close(Throwable th);

    kotlinx.coroutines.selects.e<E, SendChannel<E>> getOnSend();

    void invokeOnClose(Function1<? super Throwable, Unit> function1);

    boolean isClosedForSend();

    boolean offer(E e);

    Object send(E e, Continuation<? super Unit> continuation);

    /* renamed from: trySend-JP2dKIU */
    Object mo1078trySendJP2dKIU(E e);

    public static final class DefaultImpls {
        static {
            Covode.recordClassIndex(659101);
        }

        public static /* synthetic */ void isClosedForSend$annotations() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <E> boolean offer(SendChannel<? super E> sendChannel, E e) {
            Object mo1078trySendJP2dKIU = sendChannel.mo1078trySendJP2dKIU(e);
            if (ChannelResult.m1095isSuccessimpl(mo1078trySendJP2dKIU)) {
                return true;
            }
            Throwable m1089exceptionOrNullimpl = ChannelResult.m1089exceptionOrNullimpl(mo1078trySendJP2dKIU);
            if (m1089exceptionOrNullimpl == null) {
                return false;
            }
            throw e0.a(m1089exceptionOrNullimpl);
        }

        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return sendChannel.close(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }
}
