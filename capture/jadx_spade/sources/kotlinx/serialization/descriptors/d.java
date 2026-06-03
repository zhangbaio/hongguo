package kotlinx.serialization.descriptors;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;

@ExperimentalSerializationApi
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class d {
    static {
        Covode.recordClassIndex(659824);
    }

    private d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @ExperimentalSerializationApi
    public static final class a extends d {
        public static final a a;

        static {
            Covode.recordClassIndex(659825);
            a = new a();
        }

        private a() {
            super(null);
        }
    }

    @ExperimentalSerializationApi
    public static final class b extends d {
        public static final b a;

        static {
            Covode.recordClassIndex(659826);
            a = new b();
        }

        private b() {
            super(null);
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        return simpleName;
    }
}
