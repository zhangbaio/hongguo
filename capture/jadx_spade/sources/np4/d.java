package np4;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d extends bp4.a {
    public static final int k;
    public final String d;
    public String e;
    public String f;
    public String g;
    public List<String> h;
    public Integer i;
    public String j;

    static {
        Covode.recordClassIndex(609320);
        k = 8;
    }

    @Override // yo4.c
    public int i() {
        return 90;
    }

    public final String d() {
        boolean z;
        String str = this.g;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return "";
        }
        return this.g + (char) 20998;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r1 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.String> e() {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<java.lang.String> r1 = r6.h
            java.lang.String r2 = ""
            if (r1 == 0) goto L13
            java.lang.Object r1 = kotlin.collections.CollectionsKt.firstOrNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L14
        L13:
            r1 = r2
        L14:
            int r3 = r1.length()
            r4 = 1
            r5 = 0
            if (r3 <= 0) goto L1e
            r3 = 1
            goto L1f
        L1e:
            r3 = 0
        L1f:
            if (r3 == 0) goto L24
            r0.add(r1)
        L24:
            java.lang.Integer r1 = r6.i
            java.lang.String r1 = r6.b(r1)
            int r3 = r1.length()
            if (r3 <= 0) goto L32
            r3 = 1
            goto L33
        L32:
            r3 = 0
        L33:
            if (r3 == 0) goto L38
            r0.add(r1)
        L38:
            java.lang.String r1 = r6.j
            if (r1 != 0) goto L3d
            goto L3e
        L3d:
            r2 = r1
        L3e:
            int r1 = r2.length()
            if (r1 <= 0) goto L45
            goto L46
        L45:
            r4 = 0
        L46:
            if (r4 == 0) goto L4b
            r0.add(r2)
        L4b:
            java.util.List r0 = kotlin.collections.CollectionsKt.distinct(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: np4.d.e():java.util.List");
    }

    private final String b(Integer num) {
        if (num != null && num.intValue() != -1) {
            if (num.intValue() == 0) {
                return "完结";
            }
            return "连载中";
        }
        return "";
    }

    @Override // yo4.c
    public String a(int i) {
        return c() + "_bookcard_" + i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String storyId, String lastChapterId, String bookId) {
        super(storyId, lastChapterId);
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(lastChapterId, "lastChapterId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.d = bookId;
        this.i = -1;
    }
}
