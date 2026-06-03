package lr4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z {
    public static final int k;
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public int h;
    public String i;
    public String j;

    static {
        Covode.recordClassIndex(611577);
        k = 8;
    }

    public z() {
        this(null, null, null, null, 0, 0, 0, 0, null, null, 1023, null);
    }

    public String toString() {
        return "ComicDownloadItemInfo(bookId='" + this.b + "', chapterId='" + this.a + "', md5='" + this.c + "', absSavePath='" + this.d + "', downloadCreateTime='" + this.e + "', contentOrder='" + this.f + "', downloadStatus='" + this.g + "', downloadId='" + this.h + "', contentLength='" + this.j + "')";
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
        this.j = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.i = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public z(String chapterId, String bookId, String md5, String absSavePath, int i, int i2, int i3, int i4, String downloadSDKTaskId, String contentLength) {
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(absSavePath, "absSavePath");
        Intrinsics.checkNotNullParameter(downloadSDKTaskId, "downloadSDKTaskId");
        Intrinsics.checkNotNullParameter(contentLength, "contentLength");
        this.a = chapterId;
        this.b = bookId;
        this.c = md5;
        this.d = absSavePath;
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = downloadSDKTaskId;
        this.j = contentLength;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ z(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, int r16, int r17, int r18, int r19, java.lang.String r20, java.lang.String r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto La
            r1 = r2
            goto Lb
        La:
            r1 = r12
        Lb:
            r3 = r0 & 2
            if (r3 == 0) goto L11
            r3 = r2
            goto L12
        L11:
            r3 = r13
        L12:
            r4 = r0 & 4
            if (r4 == 0) goto L18
            r4 = r2
            goto L19
        L18:
            r4 = r14
        L19:
            r5 = r0 & 8
            if (r5 == 0) goto L1e
            goto L1f
        L1e:
            r2 = r15
        L1f:
            r5 = r0 & 16
            r6 = -1
            if (r5 == 0) goto L26
            r5 = -1
            goto L28
        L26:
            r5 = r16
        L28:
            r7 = r0 & 32
            if (r7 == 0) goto L2e
            r7 = -1
            goto L30
        L2e:
            r7 = r17
        L30:
            r8 = r0 & 64
            if (r8 == 0) goto L36
            r8 = -1
            goto L38
        L36:
            r8 = r18
        L38:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L3d
            goto L3f
        L3d:
            r6 = r19
        L3f:
            r9 = r0 & 256(0x100, float:3.59E-43)
            java.lang.String r10 = "-1"
            if (r9 == 0) goto L47
            r9 = r10
            goto L49
        L47:
            r9 = r20
        L49:
            r0 = r0 & 512(0x200, float:7.17E-43)
            if (r0 == 0) goto L4e
            goto L50
        L4e:
            r10 = r21
        L50:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r2
            r17 = r5
            r18 = r7
            r19 = r8
            r20 = r6
            r21 = r9
            r22 = r10
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lr4.z.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
