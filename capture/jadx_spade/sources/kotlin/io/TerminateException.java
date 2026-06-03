package kotlin.io;

import com.bytedance.covode.number.Covode;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class TerminateException extends FileSystemException {
    static {
        Covode.recordClassIndex(658397);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TerminateException(File file) {
        super(file, null, null, 6, null);
        Intrinsics.checkNotNullParameter(file, "file");
    }
}
