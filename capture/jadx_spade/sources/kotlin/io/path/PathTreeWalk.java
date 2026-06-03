package kotlin.io.path;

import com.bytedance.covode.number.Covode;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class PathTreeWalk implements Sequence<Path> {
    private final Path a;
    private final PathWalkOption[] b;

    static {
        Covode.recordClassIndex(658423);
    }

    private final Iterator<Path> g() {
        Iterator<Path> it2;
        it2 = SequencesKt__SequenceBuilderKt.iterator(new PathTreeWalk$bfsIterator$1(this, null));
        return it2;
    }

    private final Iterator<Path> h() {
        Iterator<Path> it2;
        it2 = SequencesKt__SequenceBuilderKt.iterator(new PathTreeWalk$dfsIterator$1(this, null));
        return it2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i() {
        return ArraysKt___ArraysKt.contains(this.b, PathWalkOption.FOLLOW_LINKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        return ArraysKt___ArraysKt.contains(this.b, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkOption[] k() {
        return c.a.a(i());
    }

    private final boolean l() {
        return ArraysKt___ArraysKt.contains(this.b, PathWalkOption.BREADTH_FIRST);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Path> iterator() {
        if (l()) {
            return g();
        }
        return h();
    }
}
