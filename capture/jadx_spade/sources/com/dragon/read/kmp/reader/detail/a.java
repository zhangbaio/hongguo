package com.dragon.read.kmp.reader.detail;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {

    public static final class b implements a {
        public static final int f;
        public final Context a;
        public final String b;
        public final BookType c;
        public final com.dragon.read.kmp.reader.detail.widget.a d;
        public final ym4.k e;

        static {
            Covode.recordClassIndex(608337);
            f = 8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b) && this.c == bVar.c && Intrinsics.areEqual(this.d, bVar.d) && Intrinsics.areEqual(this.e, bVar.e);
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "BookClick(context=" + this.a + ", itemId=" + this.b + ", bookType=" + this.c + ", data=" + this.d + ", pageRecorder=" + this.e + ')';
        }

        public final Context getContext() {
            return this.a;
        }

        public b(Context context, String itemId, BookType bookType, com.dragon.read.kmp.reader.detail.widget.a data, ym4.k pageRecorder) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(bookType, "bookType");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
            this.a = context;
            this.b = itemId;
            this.c = bookType;
            this.d = data;
            this.e = pageRecorder;
        }
    }

    /* renamed from: com.dragon.read.kmp.reader.detail.a$a, reason: collision with other inner class name */
    public static final class C0046a implements a {
        public final String a;

        static {
            Covode.recordClassIndex(608336);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0046a) && Intrinsics.areEqual(this.a, ((C0046a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "BackClick(bookId=" + this.a + ')';
        }

        public C0046a(String bookId) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            this.a = bookId;
        }
    }

    public static final class d implements a {
        public final String a;

        static {
            Covode.recordClassIndex(608339);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && Intrinsics.areEqual(this.a, ((d) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "OpenAiBot(bookName=" + this.a + ')';
        }

        public d(String bookName) {
            Intrinsics.checkNotNullParameter(bookName, "bookName");
            this.a = bookName;
        }
    }

    public static final class f implements a {
        public final String a;

        static {
            Covode.recordClassIndex(608341);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && Intrinsics.areEqual(this.a, ((f) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "OpenReviewList(bookId=" + this.a + ')';
        }

        public f(String bookId) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            this.a = bookId;
        }
    }

    public static final class h implements a {
        public final String a;

        static {
            Covode.recordClassIndex(608343);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof h) && Intrinsics.areEqual(this.a, ((h) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "OpenUrl(url=" + this.a + ')';
        }

        public h(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.a = url;
        }
    }

    public static final class g implements a {
        public static final int c;
        public final String a;
        public final com.dragon.read.kmp.utils.e<Boolean> b;

        static {
            Covode.recordClassIndex(608342);
            c = 8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return Intrinsics.areEqual(this.a, gVar.a) && Intrinsics.areEqual(this.b, gVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "OpenSharePanel(bookId=" + this.a + ", addBookshelfCallback=" + this.b + ')';
        }

        public g(String bookId, com.dragon.read.kmp.utils.e<Boolean> addBookshelfCallback) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            Intrinsics.checkNotNullParameter(addBookshelfCallback, "addBookshelfCallback");
            this.a = bookId;
            this.b = addBookshelfCallback;
        }
    }

    public static final class c implements a {
        public final String a;
        public final String b;
        public final String c;

        static {
            Covode.recordClassIndex(608338);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b) && Intrinsics.areEqual(this.c, cVar.c);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            String str = this.b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.c;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ListenClick(bookId=" + this.a + ", bookName=" + this.b + ", listenDisabledMessage=" + this.c + ')';
        }

        public c(String bookId, String str, String str2) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            this.a = bookId;
            this.b = str;
            this.c = str2;
        }
    }

    public static final class e implements a {
        public final String a;
        public final String b;
        public final String c;

        static {
            Covode.recordClassIndex(608340);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return Intrinsics.areEqual(this.a, eVar.a) && Intrinsics.areEqual(this.b, eVar.b) && Intrinsics.areEqual(this.c, eVar.c);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            String str = this.b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.c;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "OpenReader(bookId=" + this.a + ", bookName=" + this.b + ", bookCoverUrl=" + this.c + ')';
        }

        public e(String bookId, String str, String str2) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            this.a = bookId;
            this.b = str;
            this.c = str2;
        }
    }
}
