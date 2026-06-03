package kotlinx.datetime.internal.format;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [Target] */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
/* synthetic */ class NamedUnsignedIntFieldFormatDirective$formatter$1<Target> extends FunctionReferenceImpl implements Function1<Target, String> {
    NamedUnsignedIntFieldFormatDirective$formatter$1(Object obj) {
        super(1, obj, NamedUnsignedIntFieldFormatDirective.class, "getStringValue", "getStringValue(Ljava/lang/Object;)Ljava/lang/String;", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Object obj) {
        return invoke2((NamedUnsignedIntFieldFormatDirective$formatter$1<Target>) obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Target target) {
        String g;
        g = ((NamedUnsignedIntFieldFormatDirective) this.receiver).g(target);
        return g;
    }
}
