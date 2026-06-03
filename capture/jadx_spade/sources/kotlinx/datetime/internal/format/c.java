package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c<T> implements q<T> {
    public final n<T> a;
    public final List<n<T>> b;

    static {
        Covode.recordClassIndex(659591);
    }

    @Override // kotlinx.datetime.internal.format.n
    public bn6.e<T> b() {
        return this.a.b();
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "AlternativesParsing(" + this.b + ')';
    }

    @Override // kotlinx.datetime.internal.format.n
    public kotlinx.datetime.internal.format.parser.u<T> a() {
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        createListBuilder.add(this.a.a());
        Iterator<n<T>> it2 = this.b.iterator();
        while (it2.hasNext()) {
            createListBuilder.add(it2.next().a());
        }
        return new kotlinx.datetime.internal.format.parser.u<>(emptyList, CollectionsKt__CollectionsJVMKt.build(createListBuilder));
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(n<? super T> mainFormat, List<? extends n<? super T>> formats) {
        Intrinsics.checkNotNullParameter(mainFormat, "mainFormat");
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.a = mainFormat;
        this.b = formats;
    }
}
