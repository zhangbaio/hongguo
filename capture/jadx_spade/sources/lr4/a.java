package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int d;
    public String a;
    public long b;
    public long c;

    static {
        Covode.recordClassIndex(611548);
        d = 8;
    }

    public a() {
        this(null, 0L, 0L, 7, null);
    }

    public String toString() {
        return "AudioBookshelfGuideInfo( bookId='" + this.a + "', playerAccumulateTotalTime=" + this.b + " last_show_time_ms='" + this.c + ")'";
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public a(String bookId, long j, long j2) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.a = bookId;
        this.b = j;
        this.c = j2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(java.lang.String r5, long r6, long r8, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            if (r11 == 0) goto L6
            java.lang.String r5 = ""
        L6:
            r11 = r10 & 2
            r0 = 0
            if (r11 == 0) goto Le
            r2 = r0
            goto Lf
        Le:
            r2 = r6
        Lf:
            r6 = r10 & 4
            if (r6 == 0) goto L15
            r10 = r0
            goto L16
        L15:
            r10 = r8
        L16:
            r6 = r4
            r7 = r5
            r8 = r2
            r6.<init>(r7, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lr4.a.<init>(java.lang.String, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
