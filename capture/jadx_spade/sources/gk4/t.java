package gk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    static {
        Covode.recordClassIndex(607806);
    }

    public static final boolean a(x xVar) {
        Intrinsics.checkNotNullParameter(xVar, "<this>");
        if (xVar.r == VideoContentType.MotionComic.getValue()) {
            return true;
        }
        return false;
    }

    public static final BookType c(x xVar) {
        Intrinsics.checkNotNullParameter(xVar, "<this>");
        int i = xVar.f;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return BookType.SHORT_SERIES;
                }
                return BookType.SHORT_SERIES;
            }
            return BookType.LISTEN;
        }
        return BookType.READ;
    }

    public static final String b(x xVar) {
        Intrinsics.checkNotNullParameter(xVar, "<this>");
        return xVar.a + ',' + xVar.f + ',' + xVar.l + ',' + xVar.m;
    }
}
