package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class o {
    static {
        Covode.recordClassIndex(659604);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<k<T>> b(n<? super T> nVar) {
        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        c(createListBuilder, nVar);
        return CollectionsKt__CollectionsJVMKt.build(createListBuilder);
    }

    private static final <T> void c(List<k<T>> list, n<? super T> nVar) {
        if (nVar instanceof e) {
            list.add(((e) nVar).a);
            return;
        }
        if (nVar instanceof h) {
            Iterator<T> it2 = ((h) nVar).a.iterator();
            while (it2.hasNext()) {
                c(list, (q) it2.next());
            }
            return;
        }
        if (!(nVar instanceof j)) {
            if (nVar instanceof SignedFormatStructure) {
                c(list, ((SignedFormatStructure) nVar).a);
                return;
            }
            if (nVar instanceof c) {
                c cVar = (c) nVar;
                c(list, cVar.a);
                Iterator<T> it4 = cVar.b.iterator();
                while (it4.hasNext()) {
                    c(list, (n) it4.next());
                }
                return;
            }
            if (nVar instanceof OptionalFormatStructure) {
                c(list, ((OptionalFormatStructure) nVar).b);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
