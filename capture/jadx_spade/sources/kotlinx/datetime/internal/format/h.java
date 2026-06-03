package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class h<T> implements n<T> {
    public final List<q<T>> a;

    static {
        Covode.recordClassIndex(659596);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlinx.datetime.internal.format.n
    public kotlinx.datetime.internal.format.parser.u<T> a() {
        List<q<T>> list = this.a;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((q) it2.next()).a());
        }
        return kotlinx.datetime.internal.format.parser.q.c(arrayList);
    }

    @Override // kotlinx.datetime.internal.format.n
    public bn6.e<T> b() {
        List<q<T>> list = this.a;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((q) it2.next()).b());
        }
        if (arrayList.size() == 1) {
            return (bn6.e) CollectionsKt___CollectionsKt.single((List) arrayList);
        }
        return new bn6.a(arrayList);
    }

    public String toString() {
        return "ConcatenatedFormatStructure(" + CollectionsKt___CollectionsKt.joinToString$default(this.a, ", ", null, null, 0, null, null, 62, null) + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends q<? super T>> formats) {
        Intrinsics.checkNotNullParameter(formats, "formats");
        this.a = formats;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof h) && Intrinsics.areEqual(this.a, ((h) obj).a)) {
            return true;
        }
        return false;
    }
}
