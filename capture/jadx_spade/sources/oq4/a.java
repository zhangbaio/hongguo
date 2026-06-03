package oq4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final d a;
    public final c b;
    public final g c;
    public final b d;
    public final f e;
    public final e f;
    public final i g;

    static {
        Covode.recordClassIndex(611301);
    }

    public /* synthetic */ a(d dVar, c cVar, g gVar, b bVar, f fVar, e eVar, i iVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(dVar, cVar, gVar, bVar, fVar, eVar, iVar);
    }

    /* renamed from: oq4.a$a, reason: collision with other inner class name */
    public static final class C0251a {
        public static final int g;
        private d a;
        private c b;
        private g c;
        private b d;
        private f e;
        private e f;

        static {
            Covode.recordClassIndex(611302);
            g = 8;
        }

        public final a a() {
            d dVar = this.a;
            if (dVar == null) {
                dVar = new tq4.c();
            }
            d dVar2 = dVar;
            c cVar = this.b;
            if (cVar == null) {
                cVar = new tq4.b();
            }
            c cVar2 = cVar;
            g gVar = this.c;
            if (gVar == null) {
                gVar = new tq4.f();
            }
            g gVar2 = gVar;
            b bVar = this.d;
            if (bVar == null) {
                bVar = new tq4.a();
            }
            b bVar2 = bVar;
            f fVar = this.e;
            if (fVar == null) {
                fVar = new tq4.e();
            }
            f fVar2 = fVar;
            e eVar = this.f;
            if (eVar == null) {
                eVar = new tq4.d();
            }
            return new a(dVar2, cVar2, gVar2, bVar2, fVar2, eVar, new tq4.g(), null);
        }

        public final C0251a b(b config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.d = config;
            return this;
        }

        public final C0251a c(c config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.b = config;
            return this;
        }

        public final C0251a d(d config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.a = config;
            return this;
        }

        public final C0251a e(e config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.f = config;
            return this;
        }

        public final C0251a f(f config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.e = config;
            return this;
        }

        public final C0251a g(g config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.c = config;
            return this;
        }
    }

    private a(d dVar, c cVar, g gVar, b bVar, f fVar, e eVar, i iVar) {
        this.a = dVar;
        this.b = cVar;
        this.c = gVar;
        this.d = bVar;
        this.e = fVar;
        this.f = eVar;
        this.g = iVar;
    }
}
