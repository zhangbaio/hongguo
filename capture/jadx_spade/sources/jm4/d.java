package jm4;

import cm4.i;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.ui.menu.moresettings.model.u;
import com.dragon.read.reader.ui.ReaderActivity;
import i25.h0;
import kotlin.jvm.internal.Intrinsics;
import sm4.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(608472);
    }

    public final h a(i reader) {
        ReaderActivity readerActivity;
        Intrinsics.checkNotNullParameter(reader, "reader");
        ReaderActivity b = reader.b();
        if (b instanceof ReaderActivity) {
            readerActivity = b;
        } else {
            readerActivity = null;
        }
        if (readerActivity == null || !h0.a(readerActivity).g.c()) {
            return null;
        }
        return new u(reader);
    }
}
