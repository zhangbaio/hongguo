package kotlin.io.path;

import com.bytedance.covode.number.Covode;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class d {
    public final Path a;
    public final Object b;
    public final d c;
    public Iterator<d> d;

    static {
        Covode.recordClassIndex(658421);
    }

    public d(Path path, Object obj, d dVar) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.a = path;
        this.b = obj;
        this.c = dVar;
    }
}
