package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.g0;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    public static final b Factory;

    static {
        Covode.recordClassIndex(659071);
        Factory = b.a;
    }

    public static final class b {
        static final /* synthetic */ b a;
        private static final int b;

        private b() {
        }

        public final int a() {
            return b;
        }

        static {
            Covode.recordClassIndex(659073);
            a = new b();
            b = g0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
        }
    }

    public static final class a {
        static {
            Covode.recordClassIndex(659072);
        }

        public static <E> E b(Channel<E> channel) {
            return (E) ReceiveChannel.DefaultImpls.poll(channel);
        }

        public static <E> boolean a(Channel<E> channel, E e) {
            return SendChannel.DefaultImpls.offer(channel, e);
        }

        public static <E> Object c(Channel<E> channel, Continuation<? super E> continuation) {
            return ReceiveChannel.DefaultImpls.receiveOrNull(channel, continuation);
        }
    }
}
