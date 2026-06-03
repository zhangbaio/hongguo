package kotlinx.coroutines.channels;

import com.bytedance.covode.number.Covode;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface ProducerScope<E> extends CoroutineScope, SendChannel<E> {
    SendChannel<E> getChannel();

    public static final class a {
        static {
            Covode.recordClassIndex(659096);
        }

        public static <E> boolean a(ProducerScope<? super E> producerScope, E e) {
            return SendChannel.DefaultImpls.offer(producerScope, e);
        }
    }
}
