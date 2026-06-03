package com.dragon.read.kmp.reader.download;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final C0049a f;
    public static final int g;
    public final String a;
    public boolean b;
    public boolean c;
    public String d;
    public boolean e;

    /* renamed from: com.dragon.read.kmp.reader.download.a$a, reason: collision with other inner class name */
    public static final class C0049a {
        static {
            Covode.recordClassIndex(608403);
        }

        private C0049a() {
        }

        public /* synthetic */ C0049a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608402);
        f = new C0049a(null);
        g = 8;
    }

    public final a a(boolean z) {
        this.b = z;
        return this;
    }

    public final a b(boolean z) {
        this.e = z;
        return this;
    }

    public final a c(boolean z) {
        this.c = z;
        return this;
    }

    public a(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.a = bookId;
        this.b = true;
        this.d = "";
    }
}
