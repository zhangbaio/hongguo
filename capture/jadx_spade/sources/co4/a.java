package co4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final int a;
    public final boolean b;
    public final b c;
    public final boolean d;

    static {
        Covode.recordClassIndex(609003);
    }

    public /* synthetic */ a(int i, boolean z, b bVar, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, bVar, z2);
    }

    /* renamed from: co4.a$a, reason: collision with other inner class name */
    public static final class C0013a {
        public static final int f;
        private int a;
        private boolean b = true;
        private boolean c;
        private int d;
        private boolean e;

        static {
            Covode.recordClassIndex(609004);
            f = 8;
        }

        public final a a() {
            return new a(this.a, this.b, new b(this.c, this.d), this.e, null);
        }

        public final C0013a b(boolean z) {
            this.b = z;
            return this;
        }

        public final C0013a c(boolean z) {
            this.e = z;
            return this;
        }

        public final C0013a d(int i) {
            this.d = i;
            return this;
        }

        public final C0013a e(int i) {
            this.a = i;
            return this;
        }
    }

    public static final class b {
        public final boolean a;
        public final int b;

        static {
            Covode.recordClassIndex(609005);
        }

        public b(boolean z, int i) {
            this.a = z;
            this.b = i;
        }
    }

    private a(int i, boolean z, b bVar, boolean z2) {
        this.a = i;
        this.b = z;
        this.c = bVar;
        this.d = z2;
    }
}
