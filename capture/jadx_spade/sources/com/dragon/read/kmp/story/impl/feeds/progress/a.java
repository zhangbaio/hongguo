package com.dragon.read.kmp.story.impl.feeds.progress;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final String a;
    public final BookType b;
    public final String c;
    public final int d;
    public final String e;
    public final int f;
    public final float g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;

    static {
        Covode.recordClassIndex(609339);
    }

    public a() {
        this(null, null, null, 0, null, 0, 0.0f, 0, 0, 0, 0, 0, 4095, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b && Intrinsics.areEqual(this.c, aVar.c) && this.d == aVar.d && Intrinsics.areEqual(this.e, aVar.e) && this.f == aVar.f && Float.compare(this.g, aVar.g) == 0 && this.h == aVar.h && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k && this.l == aVar.l;
    }

    public int hashCode() {
        int hashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        String str = this.e;
        return ((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f) * 31) + Float.floatToIntBits(this.g)) * 31) + this.h) * 31) + this.i) * 31) + this.j) * 31) + this.k) * 31) + this.l;
    }

    public String toString() {
        return "StoryProgress(bookId=" + this.a + ", bookType=" + this.b + ", chapterId=" + this.c + ", chapterIndex=" + this.d + ", chapterTitle=" + this.e + ", pageIndex=" + this.f + ", pagerProgressRate=" + this.g + ", paragraphId=" + this.h + ", lineInParagraphOffset=" + this.i + ", startContainerId=" + this.j + ", startElementIndex=" + this.k + ", startElementOffset=" + this.l + ')';
    }

    public a(String bookId, BookType bookType, String chapterId, int i, String str, int i2, float f, int i3, int i4, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(bookType, "bookType");
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        this.a = bookId;
        this.b = bookType;
        this.c = chapterId;
        this.d = i;
        this.e = str;
        this.f = i2;
        this.g = f;
        this.h = i3;
        this.i = i4;
        this.j = i5;
        this.k = i6;
        this.l = i7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ a(java.lang.String r14, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType r15, java.lang.String r16, int r17, java.lang.String r18, int r19, float r20, int r21, int r22, int r23, int r24, int r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto La
            r1 = r2
            goto Lb
        La:
            r1 = r14
        Lb:
            r3 = r0 & 2
            if (r3 == 0) goto L12
            com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType r3 = com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType.READ
            goto L13
        L12:
            r3 = r15
        L13:
            r4 = r0 & 4
            if (r4 == 0) goto L18
            goto L1a
        L18:
            r2 = r16
        L1a:
            r4 = r0 & 8
            r5 = -1
            if (r4 == 0) goto L21
            r4 = -1
            goto L23
        L21:
            r4 = r17
        L23:
            r6 = r0 & 16
            if (r6 == 0) goto L29
            r6 = 0
            goto L2b
        L29:
            r6 = r18
        L2b:
            r7 = r0 & 32
            if (r7 == 0) goto L31
            r7 = -1
            goto L33
        L31:
            r7 = r19
        L33:
            r8 = r0 & 64
            if (r8 == 0) goto L39
            r8 = 0
            goto L3b
        L39:
            r8 = r20
        L3b:
            r9 = r0 & 128(0x80, float:1.8E-43)
            if (r9 == 0) goto L41
            r9 = -1
            goto L43
        L41:
            r9 = r21
        L43:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L49
            r10 = 0
            goto L4b
        L49:
            r10 = r22
        L4b:
            r11 = r0 & 512(0x200, float:7.17E-43)
            if (r11 == 0) goto L51
            r11 = -1
            goto L53
        L51:
            r11 = r23
        L53:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L59
            r12 = -1
            goto L5b
        L59:
            r12 = r24
        L5b:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L60
            goto L62
        L60:
            r5 = r25
        L62:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r2
            r18 = r4
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r5
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.progress.a.<init>(java.lang.String, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType, java.lang.String, int, java.lang.String, int, float, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
