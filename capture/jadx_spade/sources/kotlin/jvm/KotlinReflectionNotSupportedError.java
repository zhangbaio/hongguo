package kotlin.jvm;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class KotlinReflectionNotSupportedError extends Error {
    static {
        Covode.recordClassIndex(658454);
    }

    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public KotlinReflectionNotSupportedError(String str) {
        super(str);
    }

    public KotlinReflectionNotSupportedError(Throwable th) {
        super(th);
    }

    public KotlinReflectionNotSupportedError(String str, Throwable th) {
        super(str, th);
    }
}
