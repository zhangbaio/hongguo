package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.StringSetParserOperation;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class StringFieldFormatDirective<Target> implements k<Target> {
    private final m<Target, String> a;
    private final Set<String> b;

    static {
        Covode.recordClassIndex(659620);
    }

    @Override // kotlinx.datetime.internal.format.k
    public final m<Target, String> c() {
        return this.a;
    }

    @Override // kotlinx.datetime.internal.format.k
    public bn6.e<Target> b() {
        return new bn6.j(new StringFieldFormatDirective$formatter$1(this.a.b()));
    }

    @Override // kotlinx.datetime.internal.format.k
    public kotlinx.datetime.internal.format.parser.u<Target> a() {
        return new kotlinx.datetime.internal.format.parser.u<>(CollectionsKt__CollectionsJVMKt.listOf(new StringSetParserOperation(this.b, this.a.b(), this.a.getName())), CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StringFieldFormatDirective(m<? super Target, String> field, Set<String> acceptedStrings) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(acceptedStrings, "acceptedStrings");
        this.a = field;
        this.b = acceptedStrings;
        if (!acceptedStrings.isEmpty()) {
        } else {
            throw new IllegalArgumentException("The set of accepted strings is empty".toString());
        }
    }
}
