package sm6;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a extends rm6.a {
    static {
        Covode.recordClassIndex(658363);
    }

    /* renamed from: sm6.a$a, reason: collision with other inner class name */
    private static final class C0265a {
        public static final C0265a a;
        public static final Integer b;

        private C0265a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
        static {
            /*
                r0 = 658364(0xa0bbc, float:9.22564E-40)
                com.bytedance.covode.number.Covode.recordClassIndex(r0)
                sm6.a$a r0 = new sm6.a$a
                r0.<init>()
                sm6.a.C0265a.a = r0
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
                sm6.a.C0265a.b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sm6.a.C0265a.<clinit>():void");
        }
    }

    private final boolean e(int i) {
        Integer num = C0265a.b;
        if (num != null && num.intValue() < i) {
            return false;
        }
        return true;
    }

    @Override // rm6.a
    public List<Throwable> c(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (e(19)) {
            Throwable[] suppressed = exception.getSuppressed();
            Intrinsics.checkNotNullExpressionValue(suppressed, "getSuppressed(...)");
            return ArraysKt___ArraysJvmKt.asList(suppressed);
        }
        return super.c(exception);
    }

    @Override // rm6.a
    public void a(Throwable cause, Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (e(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
