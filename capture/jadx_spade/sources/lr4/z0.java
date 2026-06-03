package lr4;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.dragon.read.local.db.entity.Book;
import com.dragon.read.pages.bookshelf.model.BookType;
import java.util.Arrays;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class z0 implements pr4.a {
    public String A;
    public String B;
    public String C;
    public long D;
    public boolean E;
    public boolean F;
    public boolean G;
    public long H;
    public String I;
    public int J;
    public String K;
    public long L;
    public boolean M;
    public boolean N;
    public boolean O;
    public int P;
    public boolean Q;
    public boolean R;
    public String S;
    public String T;
    public int U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public String a;
    public String a0;
    public String b;
    public boolean b0;
    public int c;
    public String c0;
    public BookType d;
    public String d0;
    public String e;
    public String f;
    public String g;
    public long h;
    public int i;
    public String j;
    public String k;
    public boolean l;
    public String m;
    public String n;
    public int o;
    public String p;
    public long q;
    public boolean r;
    public String s;
    public String t;
    public String u;
    public String v;
    public Set<String> w;
    public String x;
    public String y;
    public String z;

    static {
        Covode.recordClassIndex(611607);
    }

    @Override // pr4.a
    public String getBookId() {
        return this.b;
    }

    @Override // pr4.a
    public BookType getBookType() {
        return this.d;
    }

    @Override // pr4.a
    public int getGenreType() {
        return this.i;
    }

    public String a() {
        String str = this.I;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String b() {
        if (TextUtils.isEmpty(this.K)) {
            return "";
        }
        return this.K;
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.b});
    }

    public z0() {
        this.h = System.currentTimeMillis();
        this.A = "";
        this.b0 = false;
        this.c0 = "";
        this.d0 = "";
    }

    public String toString() {
        return "RealBookshelf{author='" + this.a + "', bookId='" + this.b + "', bookType=" + this.d + ", bookName='" + this.e + "', listenBookshelfName='" + this.f + "', coverUrl='" + this.g + "', createTime=" + this.h + ", genreType=" + this.i + ", isFinish=" + this.l + ", lastSerialCount='" + this.m + "', serialCount='" + this.n + "', ttsStatus=" + this.o + ", updateStatus='" + this.p + "', updateTime=" + this.q + ", isExclusive=" + this.r + ", recommendInfo='" + this.t + "', recommendGroupId='" + this.u + "', bookStatus='" + this.v + ", validInCnRegion=" + this.b0 + "', score='" + this.T + "', wordNumber='" + this.U + "', relativeAudioBookSet=" + this.w + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.b.equals(((z0) obj).b);
        }
        return false;
    }

    public z0(p pVar, Book book, d1 d1Var, e1 e1Var) {
        this.h = System.currentTimeMillis();
        this.A = "";
        this.b0 = false;
        this.c0 = "";
        this.d0 = "";
        if (pVar != null) {
            this.b = pVar.a();
            this.d = pVar.e;
            this.c = pVar.a;
            this.R = pVar.p;
            this.M = pVar.m;
            this.N = pVar.n;
            this.L = pVar.o;
            this.q = pVar.c;
            this.A = pVar.f;
            this.D = pVar.i;
            this.E = pVar.g;
            this.G = pVar.j;
            this.H = pVar.k;
            this.F = pVar.h;
            this.h = pVar.b;
            this.a0 = "" + pVar.s;
            this.Z = "" + pVar.w;
        }
        if (book != null) {
            this.K = book.horizThumbUrl;
            this.J = book.creationStatus;
            this.I = book.abstraction;
            this.B = book.category;
            this.C = book.tags;
            this.e = book.bookName;
            this.g = book.coverUrl;
            this.m = book.lastSerialCount;
            this.n = book.serialCount;
            this.p = book.updateStatus;
            this.a = book.author;
            this.l = book.isFinish;
            this.i = book.genreType;
            this.j = book.genre;
            this.T = book.score;
            this.U = book.wordNumber;
            this.k = book.lengthType;
            this.S = book.bookShortName;
            this.o = book.ttsStatus;
            this.r = book.isExclusive;
            this.s = book.iconTag;
            this.t = book.recommendInfo;
            this.u = book.recommendGroupId;
            this.v = book.bookStatus;
            this.b0 = book.validInCnRegion;
            this.f = book.listenBookshelfName;
            this.y = book.lastChapterTitle;
            this.z = book.lastChapterUpdateTime;
            this.O = book.isPubPay;
            this.P = book.payType;
            this.Q = book.showVipTag;
            this.V = book.relativePostSchema;
            this.W = book.relativePostId;
            this.X = book.posterId;
            this.Y = book.smallCoverUrl;
        }
        if (d1Var != null) {
            this.w = d1Var.c;
            this.x = d1Var.d;
        }
        if (e1Var != null) {
            this.c0 = e1Var.a;
            this.d0 = e1Var.b;
        }
    }
}
