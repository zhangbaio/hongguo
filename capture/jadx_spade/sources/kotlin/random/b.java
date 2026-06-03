package kotlin.random;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b extends kotlin.random.a {
    private final a a = new a();

    static {
        Covode.recordClassIndex(658601);
    }

    public static final class a extends ThreadLocal<java.util.Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    }

    @Override // kotlin.random.a
    public java.util.Random getImpl() {
        java.util.Random random = this.a.get();
        Intrinsics.checkNotNullExpressionValue(random, "get(...)");
        return random;
    }
}
