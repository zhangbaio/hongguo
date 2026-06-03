package bn6;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface e<T> {
    void a(T t, Appendable appendable, boolean z);

    public static final class a {
        static {
            Covode.recordClassIndex(659629);
        }

        public static /* synthetic */ void a(e eVar, Object obj, Appendable appendable, boolean z, int i, Object obj2) {
            if (obj2 == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                eVar.a(obj, appendable, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: format");
        }
    }
}
