package yi6;

import com.bytedance.covode.number.Covode;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    public static final a b;
    public final ConcurrentHashMap<String, yi6.b> a = new ConcurrentHashMap<>();

    public static final class a {
        static {
            Covode.recordClassIndex(652821);
        }

        private a() {
        }

        /* renamed from: yi6.c$a$a, reason: collision with other inner class name */
        private static final class C0298a {
            private static final c a;
            public static final C0298a b;

            private C0298a() {
            }

            public final c a() {
                return a;
            }

            static {
                Covode.recordClassIndex(652822);
                b = new C0298a();
                a = new c();
            }
        }

        public final c a() {
            c a = b.b.a();
            if (a == null) {
                return C0298a.b.a();
            }
            return a;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(652820);
        b = new a(null);
    }

    public static final c b() {
        return b.a();
    }

    public yi6.b a(String serviceName) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        return null;
    }

    public static final class b {
        private static c a;
        public static final b b;

        private b() {
        }

        public final c a() {
            return a;
        }

        static {
            Covode.recordClassIndex(652823);
            b = new b();
        }
    }
}
