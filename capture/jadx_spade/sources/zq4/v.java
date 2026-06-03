package zq4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface v {
    void a(a aVar);

    public static final class a {
        public static final int f;
        public String a;
        public String b;
        public int c;
        public int d;
        public int e;

        static {
            Covode.recordClassIndex(611432);
            f = 8;
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.b = str;
        }

        public final void b(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.a = str;
        }

        public a(String from, String chapterId, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(chapterId, "chapterId");
            this.a = from;
            this.b = chapterId;
            this.c = i;
            this.d = i2;
            this.e = i3;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ a(java.lang.String r4, java.lang.String r5, int r6, int r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
            /*
                r3 = this;
                r10 = r9 & 1
                java.lang.String r0 = ""
                if (r10 == 0) goto L8
                r10 = r0
                goto L9
            L8:
                r10 = r4
            L9:
                r4 = r9 & 2
                if (r4 == 0) goto Le
                goto Lf
            Le:
                r0 = r5
            Lf:
                r4 = r9 & 4
                r5 = -1
                if (r4 == 0) goto L16
                r1 = -1
                goto L17
            L16:
                r1 = r6
            L17:
                r4 = r9 & 8
                if (r4 == 0) goto L1d
                r2 = -1
                goto L1e
            L1d:
                r2 = r7
            L1e:
                r4 = r9 & 16
                if (r4 == 0) goto L25
                r8 = 0
                r9 = 0
                goto L26
            L25:
                r9 = r8
            L26:
                r4 = r3
                r5 = r10
                r6 = r0
                r7 = r1
                r8 = r2
                r4.<init>(r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zq4.v.a.<init>(java.lang.String, java.lang.String, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
