package rm6;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    static {
        Covode.recordClassIndex(658354);
    }

    public kotlin.time.a d() {
        throw null;
    }

    public Random b() {
        return new kotlin.random.b();
    }

    /* renamed from: rm6.a$a, reason: collision with other inner class name */
    private static final class C0261a {
        public static final C0261a a;
        public static final Method b;
        public static final Method c;

        private C0261a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0043 A[LOOP:0: B:2:0x0019->B:10:0x0043, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0047 A[EDGE_INSN: B:11:0x0047->B:12:0x0047 BREAK  A[LOOP:0: B:2:0x0019->B:10:0x0043], SYNTHETIC] */
        static {
            /*
                r0 = 658355(0xa0bb3, float:9.22552E-40)
                com.bytedance.covode.number.Covode.recordClassIndex(r0)
                rm6.a$a r0 = new rm6.a$a
                r0.<init>()
                rm6.a.C0261a.a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L19:
                r5 = 0
                if (r4 >= r2) goto L46
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
                if (r7 == 0) goto L3f
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "getParameterTypes(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                java.lang.Object r7 = kotlin.collections.ArraysKt.singleOrNull(r7)
                boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
                if (r7 == 0) goto L3f
                r7 = 1
                goto L40
            L3f:
                r7 = 0
            L40:
                if (r7 == 0) goto L43
                goto L47
            L43:
                int r4 = r4 + 1
                goto L19
            L46:
                r6 = r5
            L47:
                rm6.a.C0261a.b = r6
                int r0 = r1.length
            L4a:
                if (r3 >= r0) goto L5f
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
                if (r4 == 0) goto L5c
                r5 = r2
                goto L5f
            L5c:
                int r3 = r3 + 1
                goto L4a
            L5f:
                rm6.a.C0261a.c = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rm6.a.C0261a.<clinit>():void");
        }
    }

    public List<Throwable> c(Throwable exception) {
        Object invoke;
        List<Throwable> asList;
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = C0261a.c;
        if (method == null || (invoke = method.invoke(exception, new Object[0])) == null || (asList = ArraysKt___ArraysJvmKt.asList((Throwable[]) invoke)) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return asList;
    }

    public void a(Throwable cause, Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = C0261a.b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }
}
