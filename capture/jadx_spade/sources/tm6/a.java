package tm6;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.time.Instant;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends sm6.a {
    static {
        Covode.recordClassIndex(658365);
    }

    public static final class b implements kotlin.time.a {
        b() {
        }

        @Override // kotlin.time.a
        public Instant now() {
            java.time.Instant now = java.time.Instant.now();
            Intrinsics.checkNotNullExpressionValue(now, "now(...)");
            return wm6.a.a(now);
        }
    }

    public static final class c implements kotlin.time.a {
        c() {
        }

        @Override // kotlin.time.a
        public Instant now() {
            return Instant.Companion.a(System.currentTimeMillis());
        }
    }

    @Override // rm6.a
    public Random b() {
        if (e(34)) {
            return new vm6.a();
        }
        return super.b();
    }

    @Override // rm6.a
    public kotlin.time.a d() {
        if (e(26)) {
            return new b();
        }
        return new c();
    }

    /* renamed from: tm6.a$a, reason: collision with other inner class name */
    private static final class C0272a {
        public static final C0272a a;
        public static final Integer b;

        private C0272a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
        static {
            /*
                r0 = 658366(0xa0bbe, float:9.22567E-40)
                com.bytedance.covode.number.Covode.recordClassIndex(r0)
                tm6.a$a r0 = new tm6.a$a
                r0.<init>()
                tm6.a.C0272a.a = r0
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = l3.a.q(r1)     // Catch: java.lang.Throwable -> L25
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L25
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L25
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L25
                if (r2 == 0) goto L26
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L25
                goto L27
            L25:
            L26:
                r1 = r0
            L27:
                if (r1 == 0) goto L35
                int r2 = r1.intValue()
                if (r2 <= 0) goto L31
                r2 = 1
                goto L32
            L31:
                r2 = 0
            L32:
                if (r2 == 0) goto L35
                r0 = r1
            L35:
                tm6.a.C0272a.b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tm6.a.C0272a.<clinit>():void");
        }
    }

    private final boolean e(int i) {
        Integer num = C0272a.b;
        if (num != null && num.intValue() < i) {
            return false;
        }
        return true;
    }
}
