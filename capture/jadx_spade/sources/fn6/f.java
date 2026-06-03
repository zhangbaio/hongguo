package fn6;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static {
        Covode.recordClassIndex(659822);
    }

    public static final class a implements Iterator<SerialDescriptor>, KMappedMarker {
        private int a;
        final /* synthetic */ SerialDescriptor b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SerialDescriptor next() {
            SerialDescriptor serialDescriptor = this.b;
            int elementsCount = serialDescriptor.getElementsCount();
            int i = this.a;
            this.a = i - 1;
            return serialDescriptor.getElementDescriptor(elementsCount - i);
        }

        a(SerialDescriptor serialDescriptor) {
            this.b = serialDescriptor;
            this.a = serialDescriptor.getElementsCount();
        }
    }

    public static final class b implements Iterator<String>, KMappedMarker {
        private int a;
        final /* synthetic */ SerialDescriptor b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            SerialDescriptor serialDescriptor = this.b;
            int elementsCount = serialDescriptor.getElementsCount();
            int i = this.a;
            this.a = i - 1;
            return serialDescriptor.getElementName(elementsCount - i);
        }

        b(SerialDescriptor serialDescriptor) {
            this.b = serialDescriptor;
            this.a = serialDescriptor.getElementsCount();
        }
    }

    public static final class c implements Iterable<SerialDescriptor>, KMappedMarker {
        final /* synthetic */ SerialDescriptor a;

        @Override // java.lang.Iterable
        public Iterator<SerialDescriptor> iterator() {
            return new a(this.a);
        }

        public c(SerialDescriptor serialDescriptor) {
            this.a = serialDescriptor;
        }
    }

    public static final class d implements Iterable<String>, KMappedMarker {
        final /* synthetic */ SerialDescriptor a;

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return new b(this.a);
        }

        public d(SerialDescriptor serialDescriptor) {
            this.a = serialDescriptor;
        }
    }

    public static final Iterable<SerialDescriptor> a(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return new c(serialDescriptor);
    }

    public static final Iterable<String> b(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return new d(serialDescriptor);
    }
}
