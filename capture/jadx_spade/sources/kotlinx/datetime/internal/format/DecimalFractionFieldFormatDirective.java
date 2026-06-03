package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class DecimalFractionFieldFormatDirective<Target> implements k<Target> {
    private final m<Target, an6.a> a;
    private final int b;
    private final int c;
    private final List<Integer> d;

    static {
        Covode.recordClassIndex(659599);
    }

    @Override // kotlinx.datetime.internal.format.k
    public final m<Target, an6.a> c() {
        return this.a;
    }

    @Override // kotlinx.datetime.internal.format.k
    public bn6.e<Target> b() {
        return new bn6.d(new DecimalFractionFieldFormatDirective$formatter$1(this.a.b()), this.b, this.c, this.d);
    }

    @Override // kotlinx.datetime.internal.format.k
    public kotlinx.datetime.internal.format.parser.u<Target> a() {
        return new kotlinx.datetime.internal.format.parser.u<>(CollectionsKt__CollectionsJVMKt.listOf(new kotlinx.datetime.internal.format.parser.k(CollectionsKt__CollectionsJVMKt.listOf(new kotlinx.datetime.internal.format.parser.d(this.b, this.c, this.a.b(), this.a.getName())))), CollectionsKt__CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DecimalFractionFieldFormatDirective(m<? super Target, an6.a> field, int i, int i2, List<Integer> zerosToAdd) {
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(zerosToAdd, "zerosToAdd");
        this.a = field;
        this.b = i;
        this.c = i2;
        this.d = zerosToAdd;
    }
}
