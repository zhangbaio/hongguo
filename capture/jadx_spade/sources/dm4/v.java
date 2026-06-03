package dm4;

import com.bytedance.covode.number.Covode;
import dm4.m;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v implements m {
    public static final v b;
    public static final int c;
    private final /* synthetic */ m a;

    static {
        Covode.recordClassIndex(608333);
        b = new v();
        c = 8;
    }

    @Override // dm4.m
    public boolean isPlaying(String str) {
        return this.a.isPlaying(str);
    }

    private v() {
        m playerDepend = xf4.d.o3.a().playerDepend();
        this.a = playerDepend == null ? new a() : playerDepend;
    }

    public static final class a implements m {
        a() {
        }

        @Override // dm4.m
        public boolean isPlaying(String str) {
            return m.a.a(this, str);
        }
    }
}
