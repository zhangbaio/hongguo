package gk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.dragon.read.kmp.base_database.api.bookapi.BookCreationStatus;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 {
    public static final a0 a;

    static {
        Covode.recordClassIndex(607817);
        a = new a0();
    }

    private a0() {
    }

    private final p c(boolean z, String str, boolean z2) {
        if (z) {
            return new p(-16747690, -2690839, str, z2);
        }
        return new p(-1308622848, -1644826, str, z2);
    }

    public final p b(int i, int i2, int i3, boolean z) {
        Pair pair;
        Pair pair2;
        if (z) {
            if (i == VideoContentType.MotionComic.getValue()) {
                pair2 = TuplesKt.to("漫剧", Boolean.TRUE);
            } else {
                pair2 = TuplesKt.to("短剧", Boolean.TRUE);
            }
            return d(this, ((Boolean) pair2.getSecond()).booleanValue(), (String) pair2.getFirst(), false, 4, null);
        }
        oc4.a aVar = oc4.a.a;
        if (aVar.g(Integer.valueOf(i2))) {
            pair = TuplesKt.to("已下架", Boolean.FALSE);
        } else if (BookCreationStatus.a.d(i3)) {
            pair = TuplesKt.to("断更", Boolean.FALSE);
        } else if (aVar.j(i3)) {
            pair = TuplesKt.to("", Boolean.FALSE);
        } else {
            pair = TuplesKt.to("连载", Boolean.FALSE);
        }
        return d(this, ((Boolean) pair.getSecond()).booleanValue(), (String) pair.getFirst(), false, 4, null);
    }

    static /* synthetic */ p d(a0 a0Var, boolean z, String str, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return a0Var.c(z, str, z2);
    }

    public final p a(BookType bookType, int i, int i2, String str, int i3, boolean z, boolean z2) {
        Pair pair;
        String str2;
        Boolean bool;
        Intrinsics.checkNotNullParameter(bookType, "bookType");
        oc4.a aVar = oc4.a.a;
        if (!aVar.g(Integer.valueOf(i)) && z) {
            return c(false, "vip", true);
        }
        if (aVar.r(i2)) {
            if (z2) {
                str2 = "短篇";
                bool = Boolean.TRUE;
            } else {
                str2 = "";
                bool = Boolean.FALSE;
            }
            pair = TuplesKt.to(str2, bool);
        } else if (z2 && aVar.q(str)) {
            pair = TuplesKt.to("出版", Boolean.TRUE);
        } else if (z2 && aVar.f(str, i2)) {
            pair = TuplesKt.to("古籍", Boolean.TRUE);
        } else if (z2 && aVar.h(i2)) {
            pair = TuplesKt.to("漫画", Boolean.TRUE);
        } else if (aVar.g(Integer.valueOf(i))) {
            pair = TuplesKt.to("已下架", Boolean.FALSE);
        } else if (BookCreationStatus.a.d(i3) && bookType == BookType.READ) {
            pair = TuplesKt.to("断更", Boolean.FALSE);
        } else if (aVar.j(i3)) {
            pair = TuplesKt.to("完结", Boolean.FALSE);
        } else {
            pair = TuplesKt.to("连载", Boolean.FALSE);
        }
        return d(this, ((Boolean) pair.getSecond()).booleanValue(), (String) pair.getFirst(), false, 4, null);
    }
}
