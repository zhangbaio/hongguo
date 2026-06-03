package kotlinx.datetime.internal.format;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
/* synthetic */ class OptionalFormatStructure$formatter$1<T> extends FunctionReferenceImpl implements Function1<T, Boolean> {
    OptionalFormatStructure$formatter$1(Object obj) {
        super(1, obj, s.class, "test", "test(Ljava/lang/Object;)Z", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return invoke((OptionalFormatStructure$formatter$1<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(T t) {
        return Boolean.valueOf(((s) this.receiver).test(t));
    }
}
