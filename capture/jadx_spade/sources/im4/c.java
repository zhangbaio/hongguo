package im4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.font.Font;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final a t;
    public static final int u;
    private static final c v;
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public long g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public long l;
    public int m;
    public double n;
    public double o;
    public int p;
    public int q;
    public int r;
    public Map<String, String> s = new HashMap();

    public static final class a {
        static {
            Covode.recordClassIndex(608466);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return c.v;
        }
    }

    static {
        Covode.recordClassIndex(608465);
        t = new a(null);
        u = 8;
        v = new c(24, Font.DEFAULT.getFontTitle(), 2, 0, 1, false, 0L, true, 0, 0, 0, Clock.System.INSTANCE.now().toEpochMilliseconds() / 1000, 0, 0.0d, 0.0d, 0, 0, 0);
    }

    public c(int i, String str, int i2, int i3, int i4, boolean z, long j, boolean z2, int i5, int i6, int i7, long j2, int i8, double d, double d2, int i9, int i10, int i11) {
        this.l = -1L;
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = z;
        this.g = j;
        this.h = z2;
        this.i = i5;
        this.j = i6;
        this.k = i7;
        this.l = j2;
        this.m = i8;
        this.n = d;
        this.o = d2;
        this.p = i9;
        this.q = i10;
        this.r = i11;
    }
}
