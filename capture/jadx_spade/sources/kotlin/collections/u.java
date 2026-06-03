package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class u implements Iterator<Character>, KMappedMarker {
    static {
        Covode.recordClassIndex(658178);
    }

    public abstract char c();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(c());
    }
}
