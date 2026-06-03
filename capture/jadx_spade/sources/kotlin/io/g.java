package kotlin.io;

import com.bytedance.covode.number.Covode;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class g implements Sequence<String> {
    private final BufferedReader a;

    static {
        Covode.recordClassIndex(658392);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<String> iterator() {
        return new a();
    }

    public static final class a implements Iterator<String>, KMappedMarker {
        private String a;
        private boolean b;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (hasNext()) {
                String str = this.a;
                this.a = null;
                Intrinsics.checkNotNull(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == null && !this.b) {
                String readLine = g.this.a.readLine();
                this.a = readLine;
                if (readLine == null) {
                    this.b = true;
                }
            }
            if (this.a != null) {
                return true;
            }
            return false;
        }

        a() {
        }
    }

    public g(BufferedReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.a = reader;
    }
}
