package kotlinx.datetime.internal.format;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
/* synthetic */ class DecimalFractionFieldFormatDirective$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, an6.a> {
    DecimalFractionFieldFormatDirective$formatter$1(Object obj) {
        super(1, obj, b.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ an6.a invoke(Object obj) {
        return invoke((DecimalFractionFieldFormatDirective$formatter$1<Target>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function1
    public final an6.a invoke(Target target) {
        return (an6.a) ((b) this.receiver).b(target);
    }
}
