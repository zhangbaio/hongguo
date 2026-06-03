package dm4;

import com.bytedance.covode.number.Covode;
import dm4.l;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u implements l {
    public static final u b;
    public static final int c;
    private final /* synthetic */ l a;

    static {
        Covode.recordClassIndex(608332);
        b = new u();
        c = 8;
    }

    @Override // dm4.l
    public boolean a() {
        return this.a.a();
    }

    @Override // dm4.l
    public String b() {
        return this.a.b();
    }

    public static final class a implements l {
        a() {
        }

        @Override // dm4.l
        public boolean a() {
            return l.a.a(this);
        }

        @Override // dm4.l
        public String b() {
            return l.a.b(this);
        }
    }

    private u() {
        l userInfoDepend = xf4.d.o3.a().userInfoDepend();
        this.a = userInfoDepend == null ? new a() : userInfoDepend;
    }
}
