package kotlinx.coroutines.channels;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class ChannelsKt__DeprecatedKt$zip$1 extends Lambda implements Function2 {
    public static final ChannelsKt__DeprecatedKt$zip$1 INSTANCE = new ChannelsKt__DeprecatedKt$zip$1();

    ChannelsKt__DeprecatedKt$zip$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Pair invoke(Object obj, Object obj2) {
        return TuplesKt.to(obj, obj2);
    }
}
