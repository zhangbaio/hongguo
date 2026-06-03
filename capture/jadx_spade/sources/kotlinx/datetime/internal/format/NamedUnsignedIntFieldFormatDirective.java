package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class NamedUnsignedIntFieldFormatDirective<Target> implements k<Target> {
    public final x<Target> a;
    private final List<String> b;
    private final String c;

    static {
        Covode.recordClassIndex(659608);
    }

    @Override // kotlinx.datetime.internal.format.k
    public /* bridge */ /* synthetic */ m c() {
        return this.a;
    }

    private final class a implements kotlinx.datetime.internal.format.parser.a<Target, String> {
        static {
            Covode.recordClassIndex(659609);
        }

        @Override // kotlinx.datetime.internal.format.parser.a
        public String getName() {
            return ((NamedUnsignedIntFieldFormatDirective) NamedUnsignedIntFieldFormatDirective.this).c;
        }

        public a() {
        }

        @Override // kotlinx.datetime.internal.format.parser.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String c(Target target, String newValue) {
            Intrinsics.checkNotNullParameter(newValue, "newValue");
            Integer c = NamedUnsignedIntFieldFormatDirective.this.a.b().c(target, Integer.valueOf(((NamedUnsignedIntFieldFormatDirective) NamedUnsignedIntFieldFormatDirective.this).b.indexOf(newValue) + NamedUnsignedIntFieldFormatDirective.this.a.b));
            if (c != null) {
                NamedUnsignedIntFieldFormatDirective<Target> namedUnsignedIntFieldFormatDirective = NamedUnsignedIntFieldFormatDirective.this;
                return (String) ((NamedUnsignedIntFieldFormatDirective) namedUnsignedIntFieldFormatDirective).b.get(c.intValue() - namedUnsignedIntFieldFormatDirective.a.b);
            }
            return null;
        }
    }

    @Override // kotlinx.datetime.internal.format.k
    public bn6.e<Target> b() {
        return new bn6.j(new NamedUnsignedIntFieldFormatDirective$formatter$1(this));
    }

    @Override // kotlinx.datetime.internal.format.k
    public kotlinx.datetime.internal.format.parser.u<Target> a() {
        return new kotlinx.datetime.internal.format.parser.u<>(CollectionsKt__CollectionsJVMKt.listOf(new StringSetParserOperation(this.b, new a(), "one of " + this.b + " for " + this.c)), CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(Target target) {
        int intValue = this.a.b().b(target).intValue();
        String str = (String) CollectionsKt___CollectionsKt.getOrNull(this.b, intValue - this.a.b);
        if (str == null) {
            return "The value " + intValue + " of " + this.a.getName() + " does not have a corresponding string representation";
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NamedUnsignedIntFieldFormatDirective(x<? super Target> field, List<String> values, String name) {
        boolean z;
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(name, "name");
        this.a = field;
        this.b = values;
        this.c = name;
        if (values.size() == (field.c - field.b) + 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("The number of values (" + values.size() + ") in " + values + " does not match the range of the field (" + ((field.c - field.b) + 1) + ')').toString());
    }
}
