package lr4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.Objects;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class h {
    public String a;
    public int b;
    public String c;
    public int d;
    public float e;
    public int f;
    public long g;
    public String h;
    public BookType i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public long p;
    public long q;
    public long r;
    public long s;

    static {
        Covode.recordClassIndex(611556);
    }

    public int c() {
        return -1;
    }

    public String a() {
        String str = this.a;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String b() {
        String str = this.c;
        if (str == null) {
            return "";
        }
        return str;
    }

    public long d() {
        long j = this.q;
        if (j != -1) {
            return j;
        }
        return this.p;
    }

    public h() {
        this.k = -1;
        this.l = 0;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = 0L;
        this.q = -1L;
        this.r = 0L;
        this.s = 0L;
    }

    public int hashCode() {
        return Objects.hash(this.a, Integer.valueOf(this.b), this.c, Integer.valueOf(this.d), Float.valueOf(this.e), Integer.valueOf(this.f), Long.valueOf(this.g), this.h, this.i, Float.valueOf(this.j));
    }

    public String toString() {
        return "BookProgress{chapterId='" + this.a + "', chapterIndex=" + this.b + ", chapterTitle='" + this.c + "', pageIndex=" + this.d + ", progressRate=" + this.e + ", sync=" + this.f + ", updateTime=" + this.g + ", bookId='" + this.h + "', bookType=" + this.i + ", pagerProgressRate=" + this.j + ", paragraphId=" + this.k + ", lineInParagraphOffset=" + this.l + ", startContainerId=" + this.m + ", startElementIndex=" + this.n + ", startElementOffset=" + this.o + ", toneId=" + this.p + ", toneIdAfterV579=" + this.q + '}';
    }

    public void e(long j) {
        if (j == -1) {
            return;
        }
        this.p = j;
        this.q = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.b == hVar.b && this.d == hVar.d && Float.compare(hVar.e, this.e) == 0 && this.f == hVar.f && this.g == hVar.g && Float.compare(hVar.j, this.j) == 0 && a().equals(hVar.a()) && b().equals(hVar.b()) && this.h.equals(hVar.h) && this.i == hVar.i) {
            return true;
        }
        return false;
    }

    public h(h hVar) {
        this.k = -1;
        this.l = 0;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = 0L;
        this.q = -1L;
        this.r = 0L;
        this.s = 0L;
        if (hVar == null) {
            return;
        }
        this.h = hVar.h;
        this.i = hVar.i;
        this.a = hVar.a;
        this.b = hVar.b;
        this.c = hVar.c;
        this.d = hVar.d;
        this.k = hVar.k;
        this.l = hVar.l;
        this.f = hVar.f;
        this.g = hVar.g;
        this.e = hVar.e;
        this.m = hVar.m;
        this.n = hVar.n;
        this.o = hVar.o;
        this.j = hVar.j;
        this.p = hVar.p;
        this.q = hVar.q;
        this.r = hVar.r;
        this.s = hVar.s;
    }

    public h(String str, BookType bookType, String str2, int i, String str3, int i2, int i3, long j) {
        this(str, bookType, str2, i, str3, i2, i3, j, 0.0f);
    }

    public h(String str, BookType bookType, String str2, int i, String str3, int i2, int i3, long j, float f) {
        this(str, bookType, str2, i, str3, i2, -1, 0, i3, -1, -1, -1, j, f);
    }

    public h(String str, BookType bookType, String str2, int i, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j, float f) {
        this.p = 0L;
        this.q = -1L;
        this.r = 0L;
        this.s = 0L;
        this.h = str;
        this.i = bookType;
        this.a = str2;
        this.b = i;
        this.c = str3;
        this.d = i2;
        this.k = i3;
        this.l = i4;
        this.f = i5;
        this.g = j;
        this.e = f;
        this.m = i6;
        this.n = i7;
        this.o = i8;
    }
}
