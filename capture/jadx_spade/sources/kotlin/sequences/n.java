package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class n extends SequencesKt__SequenceBuilderKt {
    static {
        Covode.recordClassIndex(658724);
    }

    private static final <T> Sequence<T> asSequence(Enumeration<T> enumeration) {
        Iterator it2;
        Sequence<T> asSequence;
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        it2 = CollectionsKt__IteratorsJVMKt.iterator(enumeration);
        asSequence = SequencesKt__SequencesKt.asSequence(it2);
        return asSequence;
    }
}
