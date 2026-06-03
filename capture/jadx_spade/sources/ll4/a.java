package ll4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;
import tl4.l;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends l {
    private com.dragon.read.kmp.subscribe.a m;

    static {
        Covode.recordClassIndex(608133);
    }

    @Override // tl4.l
    public void H() {
        super.H();
        com.dragon.read.kmp.profile.params.a aVar = this.a.p;
        if (aVar != null) {
            aVar.w(this.m, false);
        }
    }

    private final void f0() {
        C0236a c0236a = new C0236a();
        this.m = c0236a;
        com.dragon.read.kmp.profile.params.a aVar = this.a.p;
        if (aVar != null) {
            aVar.w(c0236a, true);
        }
    }

    /* renamed from: ll4.a$a, reason: collision with other inner class name */
    public static final class C0236a implements com.dragon.read.kmp.subscribe.a {
        C0236a() {
        }

        @Override // com.dragon.read.kmp.subscribe.a
        public void c(String seriesId, boolean z) {
            Intrinsics.checkNotNullParameter(seriesId, "seriesId");
            for (Object obj : a.this.h.a) {
                if (obj instanceof com.dragon.read.kmp.subscribe.a) {
                    ((com.dragon.read.kmp.subscribe.a) obj).c(seriesId, z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(rl4.c tabParam, rl4.a uiConfig) {
        super(tabParam, uiConfig);
        Intrinsics.checkNotNullParameter(tabParam, "tabParam");
        Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
        f0();
    }
}
