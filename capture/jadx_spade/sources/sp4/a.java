package sp4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a {
    static {
        Covode.recordClassIndex(609369);
    }

    private a() {
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: sp4.a$a, reason: collision with other inner class name */
    public static final class C0266a extends a {
        public static final C0266a a;

        static {
            Covode.recordClassIndex(609370);
            a = new C0266a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0266a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1483234461;
        }

        public String toString() {
            return "PageFirstDrawIntent";
        }

        private C0266a() {
            super(null);
        }
    }

    public static final class b extends a {
        public static final b a;

        static {
            Covode.recordClassIndex(609371);
            a = new b();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2115237529;
        }

        public String toString() {
            return "PageSecondDrawIntent";
        }

        private b() {
            super(null);
        }
    }
}
