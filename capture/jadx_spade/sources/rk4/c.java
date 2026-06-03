package rk4;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.inter.AbsPlayListener;
import com.xs.fm.player.base.play.inter.IPlayManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qk6.d;
import sk4.e;
import sk4.f;
import sk4.g;
import sk4.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements eo0.a {
    public static final a h;
    public static final int i;
    private static final Lazy<c> j;
    private final Lazy a;
    private final Map<sk4.b, AbsPlayListener> b;
    private final Map<e, qk6.c> c;
    private final Map<sk4.c, qk6.b> d;
    private final Map<wk4.c, ll6.b> e;
    private final Map<wk4.a, ll6.a> f;
    private final Map<g, d> g;

    public static final class a {
        static {
            Covode.recordClassIndex(607920);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return b();
        }

        private final c b() {
            return (c) c.j.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPlayManager I1() {
        return il6.a.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c J0() {
        return new c();
    }

    private final IPlayManager b5() {
        Object value = this.a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (IPlayManager) value;
    }

    public boolean Aa() {
        return b5().isPlaying();
    }

    public String D9() {
        pk6.c currentPlayParam = b5().getCurrentPlayParam();
        if (currentPlayParam != null) {
            return currentPlayParam.k;
        }
        return null;
    }

    public int M8() {
        return b5().getCurrentListSize();
    }

    public String Q6() {
        return b5().getCurrentListId();
    }

    public int Q9() {
        return b5().getCurrentProgress();
    }

    public String d6() {
        return b5().getCurrentItemId();
    }

    public int ra() {
        return b5().getCurrentSpeed();
    }

    public int xa() {
        return b5().getCurrentTone();
    }

    public int y5() {
        return b5().getCurrentDuration();
    }

    public int ya() {
        return b5().getPlayState();
    }

    public int za() {
        return b5().getUIState();
    }

    static {
        Lazy<c> lazy;
        Covode.recordClassIndex(607919);
        h = new a(null);
        i = 8;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: rk4.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                c J0;
                J0 = c.J0();
                return J0;
            }
        });
        j = lazy;
    }

    public c() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: rk4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IPlayManager I1;
                I1 = c.I1();
                return I1;
            }
        });
        this.a = lazy;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
    }

    public void Ka(int i2) {
        b5().setPlaySpeed(i2);
    }

    public void Ca(g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        d remove = this.g.remove(listener);
        if (remove != null) {
            b5().removeInterceptorListener(remove);
        }
    }

    public void Da(wk4.a interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        ll6.a remove = this.f.remove(interceptor);
        if (remove != null) {
            b5().removeManualChangeChapterInterceptor(remove);
        }
    }

    public void Ea(wk4.c interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        ll6.b remove = this.e.remove(interceptor);
        if (remove != null) {
            b5().removeManualResumePlayInterceptor(remove);
        }
    }

    public void Fa(sk4.c interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        qk6.b remove = this.d.remove(interceptor);
        if (remove != null) {
            b5().removePlayAutoNextInterceptor(remove);
        }
    }

    public void Ga(sk4.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        AbsPlayListener remove = this.b.remove(listener);
        if (remove != null) {
            b5().removePlayListener(remove);
        }
    }

    public void H2(wk4.c interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        ll6.b a2 = wk4.d.a(interceptor);
        if (a2 == null) {
            return;
        }
        this.e.put(interceptor, a2);
        b5().addManualResumePlayInterceptor(a2);
    }

    public void Ha(e interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        qk6.c remove = this.c.remove(interceptor);
        if (remove != null) {
            b5().removePlayStartInterceptor(remove);
        }
    }

    public void O3(sk4.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        sk4.a aVar = new sk4.a(listener);
        this.b.put(listener, aVar);
        b5().addPlayListener(aVar);
    }

    public void R4(e interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        qk6.c a2 = f.a(interceptor);
        if (a2 == null) {
            return;
        }
        this.c.put(interceptor, a2);
        b5().addPlayStartInterceptor(a2);
    }

    public void j2(g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        d a2 = h.a(listener);
        if (a2 == null) {
            return;
        }
        this.g.put(listener, a2);
        b5().addInterceptorListener(a2);
    }

    public void l3(sk4.c interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        qk6.b a2 = sk4.d.a(interceptor);
        if (a2 == null) {
            return;
        }
        this.d.put(interceptor, a2);
        b5().addPlayAutoNextInterceptor(a2);
    }

    public void u2(wk4.a interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        ll6.a a2 = wk4.b.a(interceptor);
        if (a2 == null) {
            return;
        }
        this.f.put(interceptor, a2);
        b5().addManualChangeChapterInterceptor(a2);
    }

    public void Ba(boolean z, kl6.a playEntrance) {
        Intrinsics.checkNotNullParameter(playEntrance, "playEntrance");
        b5().pause(z, playEntrance);
    }

    public void Ia(boolean z, kl6.a playEntrance) {
        Intrinsics.checkNotNullParameter(playEntrance, "playEntrance");
        b5().resume(z, playEntrance);
    }

    public void Ja(long j2, kl6.a playEntrance) {
        Intrinsics.checkNotNullParameter(playEntrance, "playEntrance");
        b5().seekTo(j2, playEntrance);
    }
}
