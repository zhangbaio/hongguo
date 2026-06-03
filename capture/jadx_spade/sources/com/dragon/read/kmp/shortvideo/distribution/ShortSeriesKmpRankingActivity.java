package com.dragon.read.kmp.shortvideo.distribution;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.apm.agent.v2.instrumentation.ActivityAgent;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.dragon.read.base.AbsActivity;
import com.dragon.read.base.Args;
import com.dragon.read.base.ui.skin.Skinable;
import com.dragon.read.component.biz.api.NsAdApi;
import com.dragon.read.kmp.shortvideo.distribution.page.SeriesRankLandingPageKt;
import com.dragon.read.kmp.shortvideo.distribution.page.viewmodel.SeriesRankViewModel;
import com.dragon.read.kmp.utils.v;
import com.dragon.read.report.PageRecorderKtKt;
import com.dragon.read.report.PageRecorderUtils;
import com.dragon.read.report.ReportManager;
import com.dragon.read.util.DebugManager;
import com.dragon.read.util.ToastUtils;
import com.ss.android.messagebus.BusProvider;
import com.ss.android.messagebus.Subscriber;
import fo4.c;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

@Skinable
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortSeriesKmpRankingActivity extends AbsActivity {
    public static final a d;
    public static final int e;
    private final String a = "ShortSeriesKmpRankingActivity";
    private ComposeView b;
    private lo4.b c;

    public static final class a {
        static {
            Covode.recordClassIndex(609002);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609001);
        d = new a(null);
        e = 8;
    }

    public void T1() {
        super.onStop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U1(Intent intent, Bundle bundle) {
        super/*android.app.Activity*/.startActivity(intent, bundle);
    }

    public boolean isTopPaddingAutoAdd() {
        return false;
    }

    public void onResume() {
        ActivityAgent.onTrace("com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity", "onResume", true);
        super.onResume();
        ActivityAgent.onTrace("com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity", "onResume", false);
    }

    public void onStart() {
        ActivityAgent.onTrace("com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity", "onStart", true);
        super.onStart();
        ActivityAgent.onTrace("com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity", "onStart", false);
    }

    protected void onStop() {
        X1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onWindowFocusChanged(boolean z) {
        ActivityAgent.onTrace("com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity", "onWindowFocusChanged", true);
        super/*android.app.Activity*/.onWindowFocusChanged(z);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        Y1(this, intent, bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
        BusProvider.unregister(this);
    }

    protected void onPause() {
        super.onPause();
        c2();
    }

    public ShortSeriesKmpRankingActivity() {
        lo4.b bVar = new lo4.b();
        bVar.k = new c();
        this.c = bVar;
    }

    private final void c2() {
        Args args = new Args();
        PageRecorderKtKt.putAll(args, PageRecorderUtils.getCurrentPageRecorder());
        args.put("is_kmp", 1);
        args.put("duration", Long.valueOf(getPageStayTime()));
        ReportManager.onReport("rank_list_stay_duration", args);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00dc A[Catch: Exception -> 0x00e3, TRY_LEAVE, TryCatch #1 {Exception -> 0x00e3, blocks: (B:31:0x00b8, B:33:0x00cf, B:39:0x00dc), top: B:30:0x00b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0056 A[Catch: Exception -> 0x005d, TRY_LEAVE, TryCatch #0 {Exception -> 0x005d, blocks: (B:56:0x0032, B:58:0x0049, B:64:0x0056), top: B:55:0x0032 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ip2.i Z1() {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity.Z1():ip2.i");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void X1(ShortSeriesKmpRankingActivity shortSeriesKmpRankingActivity) {
        shortSeriesKmpRankingActivity.T1();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                shortSeriesKmpRankingActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }

    @Subscriber
    private final void onReserveStateChangeEvent(wr3.a aVar) {
        Map<String, ? extends Object> map;
        map = MapsKt__MapsKt.toMap(aVar.a);
        ((SeriesRankViewModel) new ViewModelProvider(this).get(SeriesRankViewModel.class)).k1(v.a.k(map));
    }

    private final void b2(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("page_name");
        String string2 = bundle.getString("search_id");
        String string3 = bundle.getString("input_query");
        String string4 = bundle.getString("type");
        String string5 = bundle.getString("search_entrance");
        if (string != null) {
            PageRecorderUtils.getParentPage(this, false).addParam("page_name", string);
        }
        if (string2 != null) {
            PageRecorderUtils.getParentPage(this, false).addParam("search_id", string2);
        }
        if (string3 != null) {
            PageRecorderUtils.getParentPage(this, false).addParam("input_query", string3);
        }
        if (string4 != null) {
            PageRecorderUtils.getParentPage(this, false).addParam("type", string4);
        }
        if (string5 != null) {
            PageRecorderUtils.getParentPage(this, false).addParam("search_entrance", string5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        ActivityAgent.onTrace("com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity", "onCreate", true);
        super.onCreate(bundle);
        a2(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        ComposeView composeView = new ComposeView(this, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setViewCompositionStrategy(new ViewCompositionStrategy.b(this));
        composeView.setContent(t.c(-1791402961, true, new b()));
        this.b = composeView;
        frameLayout.addView((View) composeView, (ViewGroup.LayoutParams) new FrameLayout.LayoutParams(-1, -1));
        setContentView(frameLayout);
        if (DebugManager.isDebugBuild()) {
            ToastUtils.showCommonToast("kmp page");
        }
        BusProvider.register(this);
        ActivityAgent.onTrace("com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity", "onCreate", false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c0, code lost:
    
        if (com.dragon.read.util.kotlin.StringKt.isNotNullOrEmpty(r4) == true) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a2(android.os.Bundle r9) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity.a2(android.os.Bundle):void");
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        b() {
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
                    ComposerKt.traceEventStart(-1791402961, i, -1, "com.dragon.read.kmp.shortvideo.distribution.ShortSeriesKmpRankingActivity.onCreate.<anonymous>.<anonymous> (ShortSeriesKmpRankingActivity.kt:61)");
                }
                SeriesRankLandingPageKt.i(ShortSeriesKmpRankingActivity.this.c, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Intrinsics.checkNotNullParameter(outPersistentState, "outPersistentState");
        super/*android.app.Activity*/.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("key_preloader_id", 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "startActivity")
    public static void Y1(ShortSeriesKmpRankingActivity shortSeriesKmpRankingActivity, Intent intent, Bundle bundle) {
        al2.a.a.i("startActivity-aop", new Object[0]);
        if (NsAdApi.IMPL.interceptQuickApp(intent)) {
            return;
        }
        shortSeriesKmpRankingActivity.U1(intent, bundle);
    }
}
