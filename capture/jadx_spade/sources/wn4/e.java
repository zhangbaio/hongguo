package wn4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.share.view.a0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e extends rn4.j {
    public static final int v;
    public final String t;
    private final Lazy u;

    static {
        Covode.recordClassIndex(608949);
        v = 8;
    }

    public final int T0() {
        return ((Number) this.u.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rn4.j
    public void K0() {
        ImageView imageView = (ImageView) findViewById(2131820553);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: wn4.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.U0(e.this, view);
                }
            });
        }
    }

    @Override // rn4.j
    public FrameLayout D0(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        return (FrameLayout) rootView.findViewById(2131824992);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int V0(e eVar) {
        int H0 = eVar.H0();
        com.dragon.read.pages.bookmall.place.m mVar = com.dragon.read.pages.bookmall.place.m.a;
        int dp = ((H0 - (mVar.getDp(16) * 2)) + mVar.getDp(4)) / (mVar.getDp(77) + mVar.getDp(4));
        if (dp < 1) {
            return 1;
        }
        if (dp > 5) {
            return 4;
        }
        return dp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(e eVar, View view) {
        eVar.dismiss("close_button");
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ List<bh1.a> b;
        final /* synthetic */ Function1<bh1.a, Unit> c;

        a(List<bh1.a> list, Function1<? super bh1.a, Unit> function1) {
            this.b = list;
            this.c = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(948991930, i, -1, "com.dragon.read.kmp.share.panel.KmpLandingWebSharePanelDialog.getSharePanelComposeView.<anonymous> (KmpLandingWebSharePanelDialog.kt:38)");
                }
                a0.p(this.b, null, e.this.T0(), this.c, composer, 0, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ List<bh1.a> b;
        final /* synthetic */ String c;
        final /* synthetic */ Function1<bh1.a, Unit> d;

        b(List<bh1.a> list, String str, Function1<? super bh1.a, Unit> function1) {
            this.b = list;
            this.c = str;
            this.d = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-930090354, i, -1, "com.dragon.read.kmp.share.panel.KmpLandingWebSharePanelDialog.replaceContentView.<anonymous> (KmpLandingWebSharePanelDialog.kt:49)");
                }
                a0.p(this.b, this.c, e.this.T0(), this.d, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    @Override // rn4.j
    public View I0(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(2131038328, viewGroup, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    @Override // rn4.j
    public Function2<Composer, Integer, Unit> J0(List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, boolean z) {
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        return t.c(948991930, true, new a(shareChannelList, onClickListener));
    }

    @Override // wn4.b
    public void C(String title, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener) {
        TextView textView;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        View view = this.k;
        if (view != null && (textView = (TextView) view.findViewById(2131835011)) != null) {
            textView.setVisibility(8);
        }
        O0(t.c(-930090354, true, new b(shareChannelList, title, onClickListener)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Activity activity, String title, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, boolean z) {
        super(activity, shareChannelList, onClickListener, z);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.t = title;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: wn4.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int V0;
                V0 = e.V0(e.this);
                return Integer.valueOf(V0);
            }
        });
        this.u = lazy;
    }
}
