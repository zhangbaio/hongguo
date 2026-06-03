package kotlinx.datetime.internal.format;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
/* synthetic */ class ReducedIntFieldDirective$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, Integer> {
    ReducedIntFieldDirective$formatter$1(Object obj) {
        super(1, obj, b.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Object obj) {
        return invoke((ReducedIntFieldDirective$formatter$1<Target>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(Target target) {
        return (Integer) ((b) this.receiver).b(target);
    }
}
