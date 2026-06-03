package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class BufferedChannel$sendImpl$1 extends Lambda implements Function4 {
    public static final BufferedChannel$sendImpl$1 INSTANCE = new BufferedChannel$sendImpl$1();

    public BufferedChannel$sendImpl$1() {
        super(4);
    }

    public final Void invoke(d<Object> dVar, int i, Object obj, long j) {
        throw new IllegalStateException("unexpected".toString());
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((d<Object>) obj, ((Number) obj2).intValue(), obj3, ((Number) obj4).longValue());
    }
}
