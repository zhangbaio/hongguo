package kotlin.io;

import com.bytedance.covode.number.Covode;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    public final File a;
    public final List<File> b;

    static {
        Covode.recordClassIndex(658375);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.a + ", segments=" + this.b + ')';
    }

    public final int a() {
        return this.b.size();
    }

    public final boolean b() {
        String path = this.a.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        if (path.length() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(File root, List<? extends File> segments) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(segments, "segments");
        this.a = root;
        this.b = segments;
    }

    public final File c(int i, int i2) {
        if (i >= 0 && i <= i2 && i2 <= a()) {
            List<File> subList = this.b.subList(i, i2);
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            return new File(CollectionsKt___CollectionsKt.joinToString$default(subList, separator, null, null, 0, null, null, 62, null));
        }
        throw new IllegalArgumentException();
    }
}
