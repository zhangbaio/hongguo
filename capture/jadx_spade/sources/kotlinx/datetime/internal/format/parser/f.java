package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlinx.datetime.internal.format.parser.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f {
    static {
        Covode.recordClassIndex(659641);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <Object, Type> g f(a<? super Object, Type> aVar, Object object, Type type) {
        Type c = aVar.c(object, type);
        if (c == null) {
            return null;
        }
        return new g.a(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int d(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            i3 = (i3 * 10) + an6.f.a(charSequence.charAt(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer e(CharSequence charSequence, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            i3 = (i3 * 10) + an6.f.a(charSequence.charAt(i));
            if (i3 < 0) {
                return null;
            }
            i++;
        }
        return Integer.valueOf(i3);
    }
}
