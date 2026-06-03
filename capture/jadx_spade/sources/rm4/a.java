package rm4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {
    void a(boolean z);

    void b();

    /* renamed from: rm4.a$a, reason: collision with other inner class name */
    public static final class C0260a {
        static {
            Covode.recordClassIndex(608601);
        }

        public static /* synthetic */ void a(a aVar, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                aVar.a(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismiss");
        }
    }
}
