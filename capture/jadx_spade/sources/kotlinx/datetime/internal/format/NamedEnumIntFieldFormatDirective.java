package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class NamedEnumIntFieldFormatDirective<Target, Type> implements k<Target> {
    private final m<Target, Type> a;
    private final Map<Type, String> b;
    private final String c;
    private final Map<String, Type> d;

    static {
        Covode.recordClassIndex(659606);
    }

    @Override // kotlinx.datetime.internal.format.k
    public final m<Target, Type> c() {
        return this.a;
    }

    private final class a implements kotlinx.datetime.internal.format.parser.a<Target, String> {
        static {
            Covode.recordClassIndex(659607);
        }

        @Override // kotlinx.datetime.internal.format.parser.a
        public String getName() {
            return ((NamedEnumIntFieldFormatDirective) NamedEnumIntFieldFormatDirective.this).c;
        }

        public a() {
        }

        @Override // kotlinx.datetime.internal.format.parser.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String c(Target target, String newValue) {
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            b<Target, Type> b = NamedEnumIntFieldFormatDirective.this.c().b();
            Object obj = ((NamedEnumIntFieldFormatDirective) NamedEnumIntFieldFormatDirective.this).d.get(newValue);
            Intrinsics.checkNotNull(obj);
            Type c = b.c(target, obj);
            if (c != null) {
                return (String) ((NamedEnumIntFieldFormatDirective) NamedEnumIntFieldFormatDirective.this).b.get(c);
            }
            return null;
        }
    }

    @Override // kotlinx.datetime.internal.format.k
    public bn6.e<Target> b() {
        return new bn6.j(new NamedEnumIntFieldFormatDirective$formatter$1(this));
    }

    @Override // kotlinx.datetime.internal.format.k
    public kotlinx.datetime.internal.format.parser.u<Target> a() {
        return new kotlinx.datetime.internal.format.parser.u<>(CollectionsKt__CollectionsJVMKt.listOf(new StringSetParserOperation(this.b.values(), new a(), "one of " + this.b.values() + " for " + this.c)), CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(Target target) {
        Type b = this.a.b().b(target);
        String str = this.b.get(this.a.b().b(target));
        if (str == null) {
            return "The value " + b + " of " + this.a.getName() + " does not have a corresponding string representation";
        }
        return str;
    }
}
