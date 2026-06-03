package kotlin.io.path;

import com.bytedance.covode.number.Covode;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class i extends h {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            Covode.recordClassIndex(658429);
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    static {
        Covode.recordClassIndex(658428);
    }

    private static final FileVisitResult h(CopyActionResult copyActionResult) {
        int i = a.a[copyActionResult.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return FileVisitResult.SKIP_SUBTREE;
                }
                throw new NoWhenBranchMatchedException();
            }
            return FileVisitResult.TERMINATE;
        }
        return FileVisitResult.CONTINUE;
    }

    private static final FileVisitResult i(OnErrorResult onErrorResult) {
        int i = a.b[onErrorResult.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return FileVisitResult.SKIP_SUBTREE;
            }
            throw new NoWhenBranchMatchedException();
        }
        return FileVisitResult.TERMINATE;
    }

    public static final void c(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        String j = j.j(path);
        int hashCode = j.hashCode();
        if (hashCode != 46) {
            if (hashCode != 1518) {
                if (hashCode != 45679) {
                    if (hashCode != 45724) {
                        if (hashCode != 1472) {
                            if (hashCode != 1473 || !j.equals("./")) {
                                return;
                            }
                        } else if (!j.equals("..")) {
                            return;
                        }
                    } else if (!j.equals("..\\")) {
                        return;
                    }
                } else if (!j.equals("../")) {
                    return;
                }
            } else if (!j.equals(".\\")) {
                return;
            }
        } else if (!j.equals(".")) {
            return;
        }
        throw new IllegalFileNameException(path);
    }

    private static final void d(Path path, Path path2) {
        if (!Files.isSymbolicLink(path) && Files.isSameFile(path, path2)) {
            throw new FileSystemLoopException(path.toString());
        }
    }

    private static final Path f(Path path, Path path2, Path path3, Path path4) {
        Path resolve = path2.resolve(j.m(path4, path).toString());
        if (resolve.normalize().startsWith(path3)) {
            Intrinsics.checkNotNull(resolve);
            return resolve;
        }
        throw new IllegalFileNameException(path4, resolve, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult g(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3, Path path4, Exception exc) {
        return i(function3.invoke(path4, f(path, path2, path3, path4), exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult e(ArrayList<Path> arrayList, Function3<Object, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path path, Path path2, Path path3, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function32, Path path4, BasicFileAttributes basicFileAttributes) {
        try {
            if (!arrayList.isEmpty()) {
                c(path4);
                Object last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                Intrinsics.checkNotNullExpressionValue(last, "last(...)");
                d(path4, (Path) last);
            }
            return h(function3.invoke(kotlin.io.path.a.a, path4, f(path, path2, path3, path4)));
        } catch (Exception e) {
            return g(function32, path, path2, path3, path4, e);
        }
    }
}
