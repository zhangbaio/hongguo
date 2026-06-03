package tq3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.dragon.read.component.shortvideo.api.config.ssconfig.CenterAnimationResConfigsWrap;
import com.dragon.read.component.shortvideo.api.datacenter.AbsSeriesDataCenter;
import com.dragon.read.component.shortvideo.api.model.DataSource;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.dragon.read.report.PageRecorder;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final /* synthetic */ class d {

    public static final class a implements ys3.b {
        a() {
        }

        @Override // ys3.b
        public boolean a(Activity activity) {
            return false;
        }

        @Override // ys3.b
        public void b(String userId, Context context, PageRecorder pageRecorder) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
        }

        @Override // ys3.b
        public void onActivityResult(int i, int i2, Intent intent) {
        }
    }

    public static final class b implements mr3.a {
        b() {
        }

        @Override // mr3.a
        public void bindBigCore(int i) {
        }

        @Override // mr3.a
        public void resetCoreBind(int i) {
        }
    }

    public static final class c implements kr3.a {
        c() {
        }

        @Override // kr3.a
        public void a(String seriesId, long j) {
            Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        }

        @Override // kr3.a
        public long b(String seriesId) {
            Intrinsics.checkNotNullParameter(seriesId, "seriesId");
            return 0L;
        }

        @Override // kr3.a
        public void c(String seriesId, long j) {
            Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        }
    }

    static {
        int i = e.a;
    }

    public static void A(e eVar, ar3.j holderDataProvider, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(holderDataProvider, "holderDataProvider");
    }

    public static boolean B(e eVar, String str, String str2) {
        return false;
    }

    public static boolean C(e eVar, Activity activity, com.dragon.read.component.shortvideo.data.saas.video.d dVar, rq3.n nVar) {
        return false;
    }

    public static boolean D(e eVar, String str, String str2) {
        return false;
    }

    public static boolean E(e eVar, String seriesId, String videoId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        return false;
    }

    public static boolean F(e eVar) {
        return false;
    }

    public static boolean G(e eVar, String seriesId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        return false;
    }

    public static boolean H(e eVar, String str, String videoId, Context context) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        return false;
    }

    public static boolean I(e eVar, String str) {
        return false;
    }

    public static boolean J(e eVar) {
        return false;
    }

    public static void K(e eVar) {
    }

    public static void L(e eVar, String seriesId, String videoId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
    }

    public static void M(e eVar) {
    }

    public static void N(e eVar, String str) {
    }

    public static void O(e eVar, SaasVideoData videoData) {
        Intrinsics.checkNotNullParameter(videoData, "videoData");
    }

    public static void P(e eVar, SaasVideoDetailModel saasVideoDetailModel, SaasVideoData saasVideoData, long j, long j2) {
    }

    public static long b(e eVar) {
        return -1L;
    }

    public static ys3.c c(e eVar) {
        return null;
    }

    public static CenterAnimationResConfigsWrap d(e eVar) {
        return null;
    }

    public static ct3.a e(e eVar) {
        return null;
    }

    public static gs3.a f(e eVar, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    public static String g(e eVar) {
        return "";
    }

    public static Pair h(e eVar, SaasVideoDetailModel saasVideoDetailModel) {
        return null;
    }

    public static int i(e eVar) {
        return 0;
    }

    public static tq3.c j(e eVar) {
        return null;
    }

    public static jr3.a l(e eVar, Context context, LifecycleOwner parentLifecycleOwner, ViewGroup animContainer, Observable videoPlayStatusObservable, Observable pageVisibleObservable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parentLifecycleOwner, "parentLifecycleOwner");
        Intrinsics.checkNotNullParameter(animContainer, "animContainer");
        Intrinsics.checkNotNullParameter(videoPlayStatusObservable, "videoPlayStatusObservable");
        Intrinsics.checkNotNullParameter(pageVisibleObservable, "pageVisibleObservable");
        return null;
    }

    public static AbsSeriesDataCenter o(e eVar, rq3.n nVar) {
        return null;
    }

    public static ss3.a p(e eVar) {
        return null;
    }

    public static r q(e eVar) {
        return null;
    }

    public static String s(e eVar) {
        return "";
    }

    public static long t(e eVar, String seriesId, String videoId) {
        Intrinsics.checkNotNullParameter(seriesId, "seriesId");
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        return 0L;
    }

    public static a0 u(e eVar) {
        return null;
    }

    public static nq3.b v(e eVar) {
        return null;
    }

    public static Map w(e eVar, SaasVideoData saasVideoData) {
        return null;
    }

    public static dt3.a y(e eVar) {
        return null;
    }

    public static void z(e eVar, ar3.j holderDataProvider) {
        Intrinsics.checkNotNullParameter(holderDataProvider, "holderDataProvider");
    }

    public static ys3.b a(e eVar) {
        return new a();
    }

    public static List k(e eVar) {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static mr3.a m(e eVar) {
        return new b();
    }

    public static long r(e eVar) {
        return System.currentTimeMillis();
    }

    public static kr3.a x(e eVar) {
        return new c();
    }

    public static DataSource n(e eVar, int i) {
        return new DataSource();
    }

    public static /* synthetic */ void Q(e eVar, ar3.j jVar, boolean z, boolean z2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            eVar.insertVideoRecordOnPlay(jVar, z, z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: insertVideoRecordOnPlay");
    }
}
