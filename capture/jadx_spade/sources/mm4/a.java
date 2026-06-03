package mm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.k;
import dm4.s;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf4.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final C0242a d;
    public static final int e;
    public final String a;
    public long b;
    public final HashMap<String, Object> c;

    /* renamed from: mm4.a$a, reason: collision with other inner class name */
    public static final class C0242a {
        static {
            Covode.recordClassIndex(608499);
        }

        private C0242a() {
        }

        public /* synthetic */ C0242a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608498);
        d = new C0242a(null);
        e = 8;
    }

    public final void d() {
        this.b = e.a.a();
    }

    public String toString() {
        return "event: " + this.a + " => " + this.c;
    }

    public final void b() {
        this.c.put(this.a, Long.valueOf(e.a.a() - this.b));
        s.b.a(this.a, new ym4.a(this.c));
        k.c("KmpTrace", String.valueOf(this));
    }

    public a(String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.a = event;
        this.c = new HashMap<>();
    }

    public final void c(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.c.put(scene, Long.valueOf(e.a.a() - this.b));
    }

    public final void a(String key, Object tag) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.c.put(key, tag);
    }
}
