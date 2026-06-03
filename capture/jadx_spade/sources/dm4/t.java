package dm4;

import com.bytedance.covode.number.Covode;
import dm4.k;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t implements k {
    public static final t b;
    public static final int c;
    private final /* synthetic */ k a;

    static {
        Covode.recordClassIndex(608331);
        b = new t();
        c = 8;
    }

    @Override // dm4.k
    public boolean h() {
        return this.a.h();
    }

    @Override // dm4.k
    public boolean isDarkSkin() {
        return this.a.isDarkSkin();
    }

    @Override // dm4.k
    public boolean v() {
        return this.a.v();
    }

    public static final class a implements k {
        a() {
        }

        @Override // dm4.k
        public boolean h() {
            return k.a.c(this);
        }

        @Override // dm4.k
        public boolean isDarkSkin() {
            return k.a.a(this);
        }

        @Override // dm4.k
        public boolean v() {
            return k.a.b(this);
        }
    }

    private t() {
        k skinDepend = xf4.d.o3.a().skinDepend();
        this.a = skinDepend == null ? new a() : skinDepend;
    }
}
