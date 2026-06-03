package pm4;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.reader.ui.ReaderActivity;
import com.dragon.reader.lib.ReaderClient;
import com.dragon.reader.lib.pager.u;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    static {
        Covode.recordClassIndex(608515);
    }

    public static final void a(Context context, String bookId) {
        ReaderActivity readerActivity;
        ReaderClient readerClient;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (context instanceof ReaderActivity) {
            readerActivity = (ReaderActivity) context;
        } else {
            readerActivity = null;
        }
        if (readerActivity == null || (readerClient = readerActivity.getReaderClient()) == null || !readerActivity.P3()) {
            return;
        }
        readerClient.getFrameController().w1().M1(new u((az5.k) null, true, false, true, 0, 21, (DefaultConstructorMarker) null));
    }
}
