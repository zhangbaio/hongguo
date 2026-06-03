package zo4;

import com.bytedance.covode.number.Covode;
import gd4.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends e {
    public static final C0307a p;
    public static final int q;
    public final String d;
    public final String e;
    public final String f;
    public final Integer g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final Integer l;
    public final String m;
    public final String n;
    public final Integer o;

    /* renamed from: zo4.a$a, reason: collision with other inner class name */
    public static final class C0307a {
        static {
            Covode.recordClassIndex(609174);
        }

        private C0307a() {
        }

        public /* synthetic */ C0307a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609173);
        p = new C0307a(null);
        q = e.c;
    }

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e) && Intrinsics.areEqual(this.f, aVar.f) && Intrinsics.areEqual(this.g, aVar.g) && Intrinsics.areEqual(this.h, aVar.h) && Intrinsics.areEqual(this.i, aVar.i) && Intrinsics.areEqual(this.j, aVar.j) && Intrinsics.areEqual(this.k, aVar.k) && Intrinsics.areEqual(this.l, aVar.l) && Intrinsics.areEqual(this.m, aVar.m) && Intrinsics.areEqual(this.n, aVar.n) && Intrinsics.areEqual(this.o, aVar.o);
    }

    public int hashCode() {
        String str = this.d;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.g;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.h;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.i;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.j;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.k;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num2 = this.l;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str8 = this.m;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.n;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num3 = this.o;
        return hashCode11 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "CommonStoryData(postId=" + this.d + ", bookId=" + this.e + ", chapterId=" + this.f + ", genreType=" + this.g + ", genre=" + this.h + ", title=" + this.i + ", content=" + this.j + ", htmlContent=" + this.k + ", truncateFlag=" + this.l + ", recommendInfo=" + this.m + ", relativeId=" + this.n + ", relativeType=" + this.o + ')';
    }

    public a(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, Integer num2, String str8, String str9, Integer num3) {
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = num;
        this.h = str4;
        this.i = str5;
        this.j = str6;
        this.k = str7;
        this.l = num2;
        this.m = str8;
        this.n = str9;
        this.o = num3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Integer r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.Integer r22, java.lang.String r23, java.lang.String r24, java.lang.Integer r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = r2
            goto La
        L9:
            r1 = r14
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = r2
            goto L11
        L10:
            r3 = r15
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L17
            r4 = r2
            goto L19
        L17:
            r4 = r16
        L19:
            r5 = r0 & 8
            if (r5 == 0) goto L1f
            r5 = r2
            goto L21
        L1f:
            r5 = r17
        L21:
            r6 = r0 & 16
            if (r6 == 0) goto L27
            r6 = r2
            goto L29
        L27:
            r6 = r18
        L29:
            r7 = r0 & 32
            if (r7 == 0) goto L2f
            r7 = r2
            goto L31
        L2f:
            r7 = r19
        L31:
            r8 = r0 & 64
            if (r8 == 0) goto L37
            r8 = r2
            goto L39
        L37:
            r8 = r20
        L39:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L3f
            r9 = r2
            goto L41
        L3f:
            r9 = r21
        L41:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L47
            r10 = r2
            goto L49
        L47:
            r10 = r22
        L49:
            r11 = r0 & 512(0x200, float:7.17E-43)
            if (r11 == 0) goto L4f
            r11 = r2
            goto L51
        L4f:
            r11 = r23
        L51:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L57
            r12 = r2
            goto L59
        L57:
            r12 = r24
        L59:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L5e
            goto L60
        L5e:
            r2 = r25
        L60:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zo4.a.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
