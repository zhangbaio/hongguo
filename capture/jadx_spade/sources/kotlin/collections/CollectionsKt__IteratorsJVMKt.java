package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class CollectionsKt__IteratorsJVMKt extends CollectionsKt__IterablesKt {
    static {
        Covode.recordClassIndex(658183);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ Enumeration<T> a;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.a.nextElement();
        }

        a(Enumeration<T> enumeration) {
            this.a = enumeration;
        }
    }

    public static <T> Iterator<T> iterator(Enumeration<T> enumeration) {
        Intrinsics.checkNotNullParameter(enumeration, "<this>");
        return new a(enumeration);
    }
}
