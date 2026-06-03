package kotlin.random;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class PlatformRandom extends kotlin.random.a implements Serializable {
    private static final a Companion;
    private static final long serialVersionUID = 0;
    private final java.util.Random impl;

    private static final class a {
        static {
            Covode.recordClassIndex(658605);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(658604);
        Companion = new a(null);
    }

    @Override // kotlin.random.a
    public java.util.Random getImpl() {
        return this.impl;
    }

    public PlatformRandom(java.util.Random impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.impl = impl;
    }
}
