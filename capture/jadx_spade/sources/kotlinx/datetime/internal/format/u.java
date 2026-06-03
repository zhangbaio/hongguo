package kotlinx.datetime.internal.format;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlinx.datetime.internal.format.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class u<Object, Field> implements b<Object, Field> {
    private final KMutableProperty1<Object, Field> a;

    static {
        Covode.recordClassIndex(659616);
    }

    @Override // kotlinx.datetime.internal.format.parser.a
    public String getName() {
        return this.a.getName();
    }

    @Override // kotlinx.datetime.internal.format.b
    public Field a(Object object) {
        return this.a.get(object);
    }

    @Override // kotlinx.datetime.internal.format.b
    public Field b(Object object) {
        return (Field) b.a.a(this, object);
    }

    public u(KMutableProperty1<Object, Field> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.a = property;
    }

    @Override // kotlinx.datetime.internal.format.parser.a
    public Field c(Object object, Field field) {
        Field field2 = this.a.get(object);
        if (field2 == null) {
            this.a.set(object, field);
        } else if (!Intrinsics.areEqual(field2, field)) {
            return field2;
        }
        return null;
    }
}
