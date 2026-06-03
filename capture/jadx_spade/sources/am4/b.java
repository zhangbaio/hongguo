package am4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.bookcover.BookCoverDataLoadState;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    static {
        Covode.recordClassIndex(608263);
    }

    public static final boolean a(BookCoverDataLoadState bookCoverDataLoadState) {
        Intrinsics.checkNotNullParameter(bookCoverDataLoadState, "<this>");
        if (bookCoverDataLoadState != BookCoverDataLoadState.SUCCESS && bookCoverDataLoadState != BookCoverDataLoadState.EMPTY) {
            return false;
        }
        return true;
    }
}
