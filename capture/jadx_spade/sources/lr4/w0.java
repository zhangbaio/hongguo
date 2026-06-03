package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w0 extends p1 {
    public static final int D;

    static {
        Covode.recordClassIndex(611603);
        D = p1.C;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w0(p1 item) {
        this(item.a, item.b, item.c, item.d, item.e, item.f, item.g, item.h, item.i, item.j, item.k, item.l, item.m, item.n, item.o, item.p, item.q, item.r, item.s, item.t, item.u, item.v, item.w, item.x, item.y, item.z, item.A, item.B);
        Intrinsics.checkNotNullParameter(item, "item");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(long j, int i, String bookId, String chapterId, int i2, int i3, int i4, int i5, int i6, String chapterVersion, String content, String chapterTitle, String volumeName, boolean z, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j2, int i15, boolean z2, long j3, int i16, String notes) {
        super(j, i, bookId, chapterId, i2, i3, i4, i5, i6, chapterVersion, content, chapterTitle, volumeName, z, i7, i8, i9, i10, i11, i12, i13, i14, j2, i15, z2, j3, i16, notes);
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(chapterVersion, "chapterVersion");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(chapterTitle, "chapterTitle");
        Intrinsics.checkNotNullParameter(volumeName, "volumeName");
        Intrinsics.checkNotNullParameter(notes, "notes");
    }
}
