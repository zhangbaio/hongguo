package yq4;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface v {

    public static final class a {
        static {
            Covode.recordClassIndex(611390);
        }

        public static void a(v vVar, String key, Serializable serializable) {
            Intrinsics.checkNotNullParameter(key, "key");
        }

        public static void b(v vVar, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "map");
        }

        public static void c(v vVar) {
        }

        public static void d(v vVar, String spanName) {
            Intrinsics.checkNotNullParameter(spanName, "spanName");
        }

        public static long e(v vVar) {
            return 0L;
        }

        public static String f(v vVar) {
            return "";
        }

        public static String g(v vVar) {
            return "";
        }

        public static void h(v vVar, String str) {
        }

        public static void i(v vVar, String str) {
        }

        public static w j(v vVar, String spanName) {
            Intrinsics.checkNotNullParameter(spanName, "spanName");
            return null;
        }
    }

    void a(String str, Serializable serializable);

    void b(String str);

    void c(Map<String, ? extends Object> map);

    void cancel();

    void d(String str);

    String e();

    void endSpan(String str);

    long getStartTime();

    String getTraceId();

    w startSpan(String str);
}
