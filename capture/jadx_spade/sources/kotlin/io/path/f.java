package kotlin.io.path;

import com.bytedance.covode.number.Covode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static {
        Covode.recordClassIndex(658424);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(d dVar) {
        Object obj;
        for (d dVar2 = dVar.c; dVar2 != null; dVar2 = dVar2.c) {
            Object obj2 = dVar2.b;
            if (obj2 != null && (obj = dVar.b) != null) {
                if (Intrinsics.areEqual(obj2, obj)) {
                    return true;
                }
            } else {
                try {
                    if (Files.isSameFile(dVar2.a, dVar.a)) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Path path, LinkOption[] linkOptionArr) {
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            BasicFileAttributes readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
            Intrinsics.checkNotNullExpressionValue(readAttributes, "readAttributes(...)");
            return readAttributes.fileKey();
        } catch (Throwable unused) {
            return null;
        }
    }
}
