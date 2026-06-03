package kotlin.io.path;

import com.bytedance.covode.number.Covode;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class b extends SimpleFileVisitor<Path> {
    public final boolean a;
    private d b;
    private ArrayDeque<d> c = new ArrayDeque<>();

    static {
        Covode.recordClassIndex(658412);
    }

    public b(boolean z) {
        this.a = z;
    }

    public final List<d> b(d directoryNode) {
        Intrinsics.checkNotNullParameter(directoryNode, "directoryNode");
        this.b = directoryNode;
        Files.walkFileTree(directoryNode.a, c.a.b(this.a), 1, this);
        this.c.removeFirst();
        ArrayDeque<d> arrayDeque = this.c;
        this.c = new ArrayDeque<>();
        return arrayDeque;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.c.add(new d(dir, attrs.fileKey(), this.b));
        FileVisitResult preVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.checkNotNullExpressionValue(preVisitDirectory, "preVisitDirectory(...)");
        return preVisitDirectory;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.c.add(new d(file, null, this.b));
        FileVisitResult visitFile = super.visitFile(file, attrs);
        Intrinsics.checkNotNullExpressionValue(visitFile, "visitFile(...)");
        return visitFile;
    }
}
