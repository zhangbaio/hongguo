package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o1 extends n1 {
    public static final int C;

    static {
        Covode.recordClassIndex(611624);
        C = 8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o1(n1 item) {
        this(item.a, item.b, item.c, item.d, item.e, item.f, item.g, item.h, item.i, item.j, item.k, item.l, item.m, item.n, item.o, item.p, item.q, item.r, item.s, item.t, item.u, item.v, item.w, item.x, item.y, item.z, item.A);
        Intrinsics.checkNotNullParameter(item, "item");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(long j, int i, String bookId, String chapterId, int i2, int i3, int i4, int i5, int i6, String chapterVersion, String content, String chapterTitle, String volumeName, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j2, int i15, boolean z, long j3, int i16, String notes) {
        super(j, i, bookId, chapterId, i2, i3, i4, i5, i6, chapterVersion, content, chapterTitle, volumeName, i7, i8, i9, i10, i11, i12, i13, i14, j2, i15, z, j3, i16, notes);
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(chapterVersion, "chapterVersion");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(chapterTitle, "chapterTitle");
        Intrinsics.checkNotNullParameter(volumeName, "volumeName");
        Intrinsics.checkNotNullParameter(notes, "notes");
    }
}
