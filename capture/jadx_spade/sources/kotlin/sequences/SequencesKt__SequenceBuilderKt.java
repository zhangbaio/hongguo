package kotlin.sequences;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SequencesKt__SequenceBuilderKt {
    static {
        Covode.recordClassIndex(658723);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Sequence<T> {
        final /* synthetic */ Function2 a;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            Iterator<T> it2;
            it2 = SequencesKt__SequenceBuilderKt.iterator(this.a);
            return it2;
        }

        public a(Function2 function2) {
            this.a = function2;
        }
    }

    public static <T> Sequence<T> sequence(Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new a(block);
    }

    public static <T> Iterator<T> iterator(Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Continuation<? super Unit> createCoroutineUnintercepted;
        Intrinsics.checkNotNullParameter(block, "block");
        m mVar = new m();
        createCoroutineUnintercepted = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(block, mVar, mVar);
        mVar.d = createCoroutineUnintercepted;
        return mVar;
    }
}
