package kotlin.io.path;

import com.bytedance.covode.number.Covode;
import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class c {
    public static final c a;
    private static final LinkOption[] b;
    private static final LinkOption[] c;
    private static final Set<FileVisitOption> d;
    private static final Set<FileVisitOption> e;

    private c() {
    }

    static {
        Set<FileVisitOption> emptySet;
        Set<FileVisitOption> of;
        Covode.recordClassIndex(658419);
        a = new c();
        b = new LinkOption[]{LinkOption.NOFOLLOW_LINKS};
        c = new LinkOption[0];
        emptySet = SetsKt__SetsKt.emptySet();
        d = emptySet;
        of = SetsKt__SetsJVMKt.setOf(FileVisitOption.FOLLOW_LINKS);
        e = of;
    }

    public final LinkOption[] a(boolean z) {
        if (z) {
            return c;
        }
        return b;
    }

    public final Set<FileVisitOption> b(boolean z) {
        if (z) {
            return e;
        }
        return d;
    }
}
