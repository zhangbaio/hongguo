package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m {
    public static final a a;

    static {
        Covode.recordClassIndex(659651);
        a = new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object b(Object obj) {
        return obj;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(659652);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object b(int i) {
            return m.b(Integer.valueOf(i));
        }

        public final Object a(int i, Function0<String> message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return m.b(new l(i, message));
        }
    }
}
