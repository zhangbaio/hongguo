package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t0 extends h0 {
    public static final int s;

    static {
        Covode.recordClassIndex(611600);
        s = h0.r;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t0(h0 item) {
        this(item.a, item.b, item.c, item.d, item.e, item.f, item.g, item.h, item.i, item.j, item.k, item.l, item.m, item.n, item.o, item.p, item.q);
        Intrinsics.checkNotNullParameter(item, "item");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(long j, int i, String bookId, String chapterId, int i2, int i3, int i4, int i5, String chapterVersion, String content, String chapterTitle, String volumeName, int i6, long j2, int i7, int i8, String notes) {
        super(j, i, bookId, chapterId, i2, i3, i4, i5, chapterVersion, content, chapterTitle, volumeName, i6, j2, i7, i8, notes);
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(chapterVersion, "chapterVersion");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(chapterTitle, "chapterTitle");
        Intrinsics.checkNotNullParameter(volumeName, "volumeName");
        Intrinsics.checkNotNullParameter(notes, "notes");
    }
}
