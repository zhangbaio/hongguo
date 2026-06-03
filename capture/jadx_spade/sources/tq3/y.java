package tq3;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.dragon.read.base.Args;
import com.dragon.read.component.shortvideo.api.model.SeriesEndRecData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.report.PageRecorder;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class y {
    public static void A(z zVar, SaasVideoData saasVideoData, s sVar, boolean z) {
    }

    public static void B(z zVar, String pageName, int i, rq3.n nVar) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
    }

    public static void C(z zVar, String pageName, rq3.n nVar) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
    }

    public static void D(z zVar, rq3.n nVar) {
    }

    public static void E(z zVar) {
    }

    public static void F(z zVar) {
    }

    public static void a(z zVar, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static void b(z zVar) {
    }

    public static boolean c(z zVar, rq3.n nVar, rq3.g gVar) {
        return false;
    }

    public static void d(z zVar) {
    }

    public static void e(z zVar, boolean z) {
    }

    public static void f(z zVar, boolean z) {
    }

    public static void g(z zVar, boolean z) {
    }

    public static void h(z zVar) {
    }

    public static void i(z zVar, rq3.g basePlayerController) {
        Intrinsics.checkNotNullParameter(basePlayerController, "basePlayerController");
    }

    public static void j(z zVar, MotionEvent motionEvent) {
    }

    public static void k(z zVar, SeriesEndRecData seriesEndRecData, int i, com.dragon.read.component.shortvideo.data.saas.video.d dVar, View view) {
    }

    public static void l(z zVar, SeriesEndRecData seriesEndRecData, int i, com.dragon.read.component.shortvideo.data.saas.video.d dVar) {
    }

    public static void m(z zVar, SaasVideoData saasVideoData, s sVar, boolean z) {
    }

    public static boolean n(z zVar, rq3.n nVar) {
        return false;
    }

    public static void o(z zVar, boolean z) {
    }

    public static void p(z zVar, Context context, View muteView) {
        Intrinsics.checkNotNullParameter(muteView, "muteView");
    }

    public static void q(z zVar, Context context, View muteView) {
        Intrinsics.checkNotNullParameter(muteView, "muteView");
    }

    public static void r(z zVar, int i, boolean z, long j) {
    }

    public static void s(z zVar, String bookId, com.dragon.read.component.shortvideo.data.saas.video.d dVar, PageRecorder pageRecorder, Args args) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
    }

    public static void t(z zVar, String bookId, com.dragon.read.component.shortvideo.data.saas.video.d dVar, PageRecorder pageRecorder, Args args) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
    }

    public static void u(z zVar, MotionEvent motionEvent) {
    }

    public static void v(z zVar, boolean z, rq3.n nVar) {
    }

    public static void w(z zVar, Context context, String seriesId, boolean z, cs3.a aVar, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
    }

    public static boolean x(z zVar, rq3.n nVar) {
        return false;
    }

    public static void y(z zVar, rq3.n nVar) {
    }

    public static boolean z(z zVar, rq3.g gVar, rq3.e eVar, Activity activity, rq3.j jVar) {
        return false;
    }

    public static /* synthetic */ void G(z zVar, Context context, String str, boolean z, cs3.a aVar, String str2, int i, Object obj) {
        if (obj == null) {
            if ((i & 16) != 0) {
                str2 = null;
            }
            zVar.X2(context, str, z, aVar, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSeriesSubscribeViewClick");
    }
}
