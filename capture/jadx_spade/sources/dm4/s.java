package dm4;

import com.bytedance.covode.number.Covode;
import dm4.j;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s implements j {
    public static final s b;
    public static final int c;
    private final /* synthetic */ j a;

    static {
        Covode.recordClassIndex(608330);
        b = new s();
        c = 8;
    }

    @Override // dm4.j
    public void a(String event, ym4.a args) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(args, "args");
        this.a.a(event, args);
    }

    private s() {
        j reporterDepend = xf4.d.o3.a().reporterDepend();
        this.a = reporterDepend == null ? new a() : reporterDepend;
    }

    public static final class a implements j {
        a() {
        }

        @Override // dm4.j
        public void a(String str, ym4.a aVar) {
            j.a.a(this, str, aVar);
        }
    }
}
