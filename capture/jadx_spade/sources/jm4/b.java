package jm4;

import cm4.i;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.ui.menu.moresettings.model.e;
import com.dragon.read.reader.ui.ReaderActivity;
import i25.h0;
import kotlin.jvm.internal.Intrinsics;
import sm4.k;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(608470);
    }

    public final k a(i reader) {
        ReaderActivity readerActivity;
        Intrinsics.checkNotNullParameter(reader, "reader");
        ReaderActivity b = reader.b();
        if (b instanceof ReaderActivity) {
            readerActivity = b;
        } else {
            readerActivity = null;
        }
        if (readerActivity == null || !h0.a(readerActivity).b.c()) {
            return null;
        }
        return new e(reader);
    }
}
