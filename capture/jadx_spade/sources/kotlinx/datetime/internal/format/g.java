package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g<T, E> implements s<T> {
    private final E a;
    private final Function1<T, E> b;

    static {
        Covode.recordClassIndex(659595);
    }

    @Override // kotlinx.datetime.internal.format.s
    public boolean test(T t) {
        return Intrinsics.areEqual(this.b.invoke(t), this.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(E e, Function1<? super T, ? extends E> getter) {
        Intrinsics.checkNotNullParameter(getter, "getter");
        this.a = e;
        this.b = getter;
    }
}
