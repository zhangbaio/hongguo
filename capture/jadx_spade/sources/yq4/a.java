package yq4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final i a;
    public final p b;

    static {
        Covode.recordClassIndex(611358);
    }

    public /* synthetic */ a(i iVar, p pVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, pVar);
    }

    /* renamed from: yq4.a$a, reason: collision with other inner class name */
    public static final class C0302a {
        public static final int c;
        private i a;
        private p b;

        static {
            Covode.recordClassIndex(611359);
            c = 8;
        }

        private final void b() {
            if (this.a != null) {
            } else {
                throw new RuntimeException("saasDepend should be initialized");
            }
        }

        public final a a() {
            b();
            i iVar = this.a;
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (iVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saasDepend");
                iVar = null;
            }
            return new a(iVar, this.b, defaultConstructorMarker);
        }

        public final C0302a c(p novelDepend) {
            Intrinsics.checkNotNullParameter(novelDepend, "novelDepend");
            this.b = novelDepend;
            return this;
        }

        public final C0302a d(i cssDepend) {
            Intrinsics.checkNotNullParameter(cssDepend, "cssDepend");
            this.a = cssDepend;
            return this;
        }
    }

    private a(i iVar, p pVar) {
        this.a = iVar;
        this.b = pVar;
    }
}
