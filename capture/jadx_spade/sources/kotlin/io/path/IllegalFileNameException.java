package kotlin.io.path;

import com.bytedance.covode.number.Covode;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class IllegalFileNameException extends FileSystemException {
    static {
        Covode.recordClassIndex(658418);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IllegalFileNameException(Path file) {
        this(file, null, null);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public IllegalFileNameException(java.nio.file.Path r2, java.nio.file.Path r3, java.lang.String r4) {
        /*
            r1 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = r2.toString()
            if (r3 == 0) goto L10
            java.lang.String r3 = r3.toString()
            goto L11
        L10:
            r3 = 0
        L11:
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.IllegalFileNameException.<init>(java.nio.file.Path, java.nio.file.Path, java.lang.String):void");
    }
}
