package kotlin.collections;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class m0 implements Iterator<Short>, KMappedMarker {
    static {
        Covode.recordClassIndex(658224);
    }

    public abstract short c();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Short next() {
        return Short.valueOf(c());
    }
}
