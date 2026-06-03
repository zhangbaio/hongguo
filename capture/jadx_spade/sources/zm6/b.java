package zm6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Serializable(with = cn6.c.class)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b extends c {
    public static final a Companion;
    private final int a;
    private final int b;

    static {
        Covode.recordClassIndex(659378);
        Companion = new a(null);
    }

    @Override // zm6.c
    public int c() {
        return 0;
    }

    @Override // zm6.c
    public int d() {
        return 0;
    }

    @Override // zm6.c
    public int f() {
        return 0;
    }

    @Override // zm6.c
    public int g() {
        return 0;
    }

    @Override // zm6.c
    public long i() {
        return 0L;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(659379);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<b> serializer() {
            return cn6.c.a;
        }
    }

    @Override // zm6.c
    public int b() {
        return this.b;
    }

    @Override // zm6.c
    public int h() {
        return this.a;
    }

    public b(int i, int i2) {
        super(null);
        this.a = i;
        this.b = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(int r1, int r2, int r3) {
        /*
            r0 = this;
            int r1 = zm6.e.b(r1, r2)
            r0.<init>(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zm6.b.<init>(int, int, int):void");
    }

    public /* synthetic */ b(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }
}
