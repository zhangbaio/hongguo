package pq3;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n {
    public static final a b;
    public final b a;

    public static final class a {
        static {
            Covode.recordClassIndex(598244);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598243);
        b = new a(null);
    }

    public n(b videoInfoConfigNew) {
        Intrinsics.checkNotNullParameter(videoInfoConfigNew, "videoInfoConfigNew");
        this.a = videoInfoConfigNew;
    }

    public static final class b {
        public final boolean a;
        public final boolean b;
        public final int c;

        static {
            Covode.recordClassIndex(598245);
        }

        public b(boolean z, boolean z2, int i) {
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        public /* synthetic */ b(boolean z, boolean z2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? 0 : i);
        }
    }

    public /* synthetic */ n(b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new b(false, false, 0, 7, null) : bVar);
    }
}
