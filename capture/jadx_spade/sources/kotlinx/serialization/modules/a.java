package kotlinx.serialization.modules;

import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a {
    static {
        Covode.recordClassIndex(660090);
    }

    private a() {
    }

    public abstract KSerializer<?> a(List<? extends KSerializer<?>> list);

    /* renamed from: kotlinx.serialization.modules.a$a, reason: collision with other inner class name */
    public static final class C0230a extends a {
        public final KSerializer<?> a;

        static {
            Covode.recordClassIndex(660091);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        @Override // kotlinx.serialization.modules.a
        public KSerializer<?> a(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.a;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof C0230a) && Intrinsics.areEqual(((C0230a) obj).a, this.a)) {
                return true;
            }
            return false;
        }
    }

    public static final class b extends a {
        public final Function1<List<? extends KSerializer<?>>, KSerializer<?>> a;

        static {
            Covode.recordClassIndex(660092);
        }

        @Override // kotlinx.serialization.modules.a
        public KSerializer<?> a(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.a.invoke(typeArgumentsSerializers);
        }
    }
}
