package wn4;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ui.util.StatusBarUtil;
import com.dragon.read.kmp.share.view.SeriesSharePostViewKt;
import com.dragon.read.kmp.share.view.a0;
import com.dragon.read.kmp.share.view.b0;
import com.dragon.read.util.CdnLargeImageLoader;
import com.dragon.read.util.kotlin.UIKt;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o extends rn4.l {
    public static final int p;
    public final com.dragon.read.kmp.share.business.series.o o;

    static {
        Covode.recordClassIndex(608953);
        p = 8;
    }

    @Override // rn4.l
    public int g() {
        return 2131038327;
    }

    @Override // rn4.l
    public ViewGroup d() {
        View findViewById = findViewById(2131822237);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        return (ViewGroup) findViewById;
    }

    @Override // rn4.l
    public ViewGroup h() {
        View findViewById = findViewById(2131832227);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        return (ViewGroup) findViewById;
    }

    @Override // rn4.l
    public void j() {
        u();
        q();
        s();
    }

    private final void s() {
        View findViewById = findViewById(2131821050);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        ((TextView) findViewById).setOnClickListener(new View.OnClickListener() { // from class: wn4.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.t(o.this, view);
            }
        });
    }

    private final void q() {
        final un4.f fVar = this.o.r;
        if (fVar == null) {
            return;
        }
        ConstraintLayout findViewById = findViewById(2131825462);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        final ConstraintLayout constraintLayout = findViewById;
        constraintLayout.post(new Runnable() { // from class: wn4.m
            @Override // java.lang.Runnable
            public final void run() {
                o.r(constraintLayout, fVar);
            }
        });
        SimpleDraweeView findViewById2 = findViewById(2131825449);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        CdnLargeImageLoader.load(findViewById2, "img_671_short_series_post_panel_bg_v2.png", ScalingUtils.ScaleType.FIT_XY);
    }

    private final void u() {
        View findViewById = findViewById(2131820948);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        if (textView.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = StatusBarUtil.getStatusHeight(getContext());
            textView.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(o oVar, View view) {
        oVar.dismiss("close_button");
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        a() {
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
                    ComposerKt.traceEventStart(1102330417, i, -1, "com.dragon.read.kmp.share.panel.KmpShortSeriesPostDialog.getPanelCardComposeView.<anonymous> (KmpShortSeriesPostDialog.kt:57)");
                }
                SeriesSharePostViewKt.b(o.this.o, composer, 0);
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
        final /* synthetic */ List<bh1.a> a;
        final /* synthetic */ Function1<bh1.a, Unit> b;

        b(List<bh1.a> list, Function1<? super bh1.a, Unit> function1) {
            this.a = list;
            this.b = function1;
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
                    ComposerKt.traceEventStart(-1931632250, i, -1, "com.dragon.read.kmp.share.panel.KmpShortSeriesPostDialog.getSharePanelComposeView.<anonymous> (KmpShortSeriesPostDialog.kt:67)");
                }
                for (bh1.a aVar : this.a) {
                    Pair<Integer, Integer> e = qn4.a.a.e(aVar.a);
                    if (e != null) {
                        aVar.c = e.getFirst();
                        aVar.d = e.getSecond();
                    }
                    if (Intrinsics.areEqual(aVar.a, "image_share")) {
                        aVar.b("保存海报");
                    }
                    if (Intrinsics.areEqual(aVar.a, "douyin_im")) {
                        aVar.c = aVar.d;
                    }
                }
                a0.m(this.a, this.b, true, true, new b0(60, -1, 12, 22.0f, 56, true, null, 64, null), 22, composer, 200064, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ConstraintLayout constraintLayout, un4.f fVar) {
        constraintLayout.setBackground(hp2.n.a.a(constraintLayout.getHeight(), fVar.a, fVar.b, UIKt.getDp(400)));
    }

    @Override // rn4.l
    public Function2<Composer, Integer, Unit> f(un4.j tvUgPostShareParams, boolean z) {
        Intrinsics.checkNotNullParameter(tvUgPostShareParams, "tvUgPostShareParams");
        return t.c(1102330417, true, new a());
    }

    @Override // rn4.l
    public Function2<Composer, Integer, Unit> i(List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, boolean z) {
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        return t.c(-1931632250, true, new b(shareChannelList, onClickListener));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Activity activity, com.dragon.read.kmp.share.business.series.o videoPlayerPost, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener) {
        super(activity, videoPlayerPost, shareChannelList, onClickListener, 0, false, 48, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(videoPlayerPost, "videoPlayerPost");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.o = videoPlayerPost;
    }
}
