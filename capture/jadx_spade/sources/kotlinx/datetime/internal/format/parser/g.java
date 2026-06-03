package kotlinx.datetime.internal.format.parser;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface g {

    public static final class b implements g {
        public static final b a;

        static {
            Covode.recordClassIndex(659644);
            a = new b();
        }

        private b() {
        }

        @Override // kotlinx.datetime.internal.format.parser.g
        public String errorMessage() {
            return "expected an Int value";
        }
    }

    String errorMessage();

    public static final class a implements g {
        public final Object a;

        static {
            Covode.recordClassIndex(659643);
        }

        @Override // kotlinx.datetime.internal.format.parser.g
        public String errorMessage() {
            return "attempted to overwrite the existing value '" + this.a + '\'';
        }

        public a(Object conflicting) {
            Intrinsics.checkNotNullParameter(conflicting, "conflicting");
            this.a = conflicting;
        }
    }

    public static final class c implements g {
        public final int a;

        static {
            Covode.recordClassIndex(659645);
        }

        @Override // kotlinx.datetime.internal.format.parser.g
        public String errorMessage() {
            return "expected at least " + this.a + " digits";
        }

        public c(int i) {
            this.a = i;
        }
    }

    public static final class d implements g {
        public final int a;

        static {
            Covode.recordClassIndex(659646);
        }

        @Override // kotlinx.datetime.internal.format.parser.g
        public String errorMessage() {
            return "expected at most " + this.a + " digits";
        }

        public d(int i) {
            this.a = i;
        }
    }

    public static final class e implements g {
        public final String a;

        static {
            Covode.recordClassIndex(659647);
        }

        @Override // kotlinx.datetime.internal.format.parser.g
        public String errorMessage() {
            return "expected '" + this.a + '\'';
        }

        public e(String expected) {
            Intrinsics.checkNotNullParameter(expected, "expected");
            this.a = expected;
        }
    }
}
