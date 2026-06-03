package kotlin.jvm.internal;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class q implements ClassBasedDeclarationContainer {
    private final Class<?> a;
    private final String b;

    static {
        Covode.recordClassIndex(658541);
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.a;
    }

    @Override // kotlin.reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        throw new KotlinReflectionNotSupportedError();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass() + " (Kotlin reflection is not available)";
    }

    public boolean equals(Object obj) {
        if ((obj instanceof q) && Intrinsics.areEqual(getJClass(), ((q) obj).getJClass())) {
            return true;
        }
        return false;
    }

    public q(Class<?> jClass, String moduleName) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.a = jClass;
        this.b = moduleName;
    }
}
