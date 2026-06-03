package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    public static final int f;
    public String a;
    public String b;
    public int c;
    public String d;
    public String e;

    static {
        Covode.recordClassIndex(611572);
        f = 8;
    }

    public w() {
        this(null, null, 0, null, null, 31, null);
    }

    public String toString() {
        return "ComicReadProgressRecordInfo( comicId='" + this.a + "', chapterId='" + this.b + "', readProgress='" + this.c + ", catalogOrder='" + this.d + ", lastUpdateTime='" + this.e + ",)'";
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.e = str;
    }

    public w(String comicId, String chapterId, int i, String catalogOrder, String lastUpdateTime) {
        Intrinsics.checkNotNullParameter(comicId, "comicId");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(catalogOrder, "catalogOrder");
        Intrinsics.checkNotNullParameter(lastUpdateTime, "lastUpdateTime");
        this.a = comicId;
        this.b = chapterId;
        this.c = i;
        this.d = catalogOrder;
        this.e = lastUpdateTime;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ w(java.lang.String r5, java.lang.String r6, int r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            java.lang.String r0 = ""
            if (r11 == 0) goto L8
            r11 = r0
            goto L9
        L8:
            r11 = r5
        L9:
            r5 = r10 & 2
            if (r5 == 0) goto Lf
            r1 = r0
            goto L10
        Lf:
            r1 = r6
        L10:
            r5 = r10 & 4
            if (r5 == 0) goto L17
            r7 = 0
            r2 = 0
            goto L18
        L17:
            r2 = r7
        L18:
            r5 = r10 & 8
            if (r5 == 0) goto L1e
            r3 = r0
            goto L1f
        L1e:
            r3 = r8
        L1f:
            r5 = r10 & 16
            if (r5 == 0) goto L25
            r10 = r0
            goto L26
        L25:
            r10 = r9
        L26:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lr4.w.<init>(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
