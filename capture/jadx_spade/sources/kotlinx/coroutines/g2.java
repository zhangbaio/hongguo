package kotlinx.coroutines;

import com.bytedance.covode.number.Covode;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class g2 extends AbstractCoroutineContextElement {
    public static final a b;
    public boolean a;

    public static final class a implements CoroutineContext.Key<g2> {
        static {
            Covode.recordClassIndex(659047);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(659046);
        b = new a(null);
    }

    public g2() {
        super(b);
    }
}
