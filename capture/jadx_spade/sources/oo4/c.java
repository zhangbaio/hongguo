package oo4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.datetime.Clock;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final a d;
    public static final int e;
    private long a;
    private long b;
    private boolean c;

    public static final class a {
        static {
            Covode.recordClassIndex(609103);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609102);
        d = new a(null);
        e = 8;
    }

    public final void a() {
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        this.b = epochMilliseconds;
        if (!this.c) {
            this.a = epochMilliseconds;
        }
        b();
    }

    private final void b() {
        ym4.a aVar = new ym4.a();
        aVar.g("load_scene", "video_load_more");
        aVar.g("duration", Long.valueOf(this.b - this.a));
        aVar.g("is_kmp", "1");
        o.a.d("video_detail_sensible_load_more", aVar);
    }

    public final void c(boolean z) {
        this.c = z;
        long epochMilliseconds = Clock.System.INSTANCE.now().toEpochMilliseconds();
        if (z) {
            this.a = epochMilliseconds;
        }
    }

    public final void d(boolean z) {
        if (this.c != z && z) {
            this.c = true;
            this.a = Clock.System.INSTANCE.now().toEpochMilliseconds();
        }
    }
}
