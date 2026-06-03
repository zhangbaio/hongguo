package kotlin.io.path;

import com.bytedance.covode.number.Covode;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class e {
    public static final e a;
    private static final Path b;
    private static final Path c;

    private e() {
    }

    static {
        Covode.recordClassIndex(658422);
        a = new e();
        b = Paths.get("", new String[0]);
        c = Paths.get("..", new String[0]);
    }

    public final Path a(Path path, Path base) {
        String dropLast;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(base, "base");
        Path normalize = base.normalize();
        Path normalize2 = path.normalize();
        Path relativize = normalize.relativize(normalize2);
        int min = Math.min(normalize.getNameCount(), normalize2.getNameCount());
        for (int i = 0; i < min; i++) {
            Path name = normalize.getName(i);
            Path path2 = c;
            if (!Intrinsics.areEqual(name, path2)) {
                break;
            }
            if (!Intrinsics.areEqual(normalize2.getName(i), path2)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (Intrinsics.areEqual(normalize2, normalize) || !Intrinsics.areEqual(normalize, b)) {
            String obj = relativize.toString();
            String separator = relativize.getFileSystem().getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, "getSeparator(...)");
            if (StringsKt__StringsJVMKt.endsWith$default(obj, separator, false, 2, null)) {
                FileSystem fileSystem = relativize.getFileSystem();
                dropLast = StringsKt___StringsKt.dropLast(obj, relativize.getFileSystem().getSeparator().length());
                normalize2 = fileSystem.getPath(dropLast, new String[0]);
            } else {
                normalize2 = relativize;
            }
        }
        Intrinsics.checkNotNull(normalize2);
        return normalize2;
    }
}
