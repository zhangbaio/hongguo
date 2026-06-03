package it3;

import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.component.shortvideo.depend.context.App;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.rpc.model.GetRedDotRequest;
import com.dragon.read.rpc.model.GetRedDotResponse;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e {
    public static final e a;
    private static final LogHelper b;
    private static String c;
    private static final SharedPreferences d;
    public static final int e;

    private e() {
    }

    private final String e() {
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    static {
        Covode.recordClassIndex(599233);
        a = new e();
        b = new LogHelper("SeriesFeedTabRedDotManager");
        c = "action_short_series_feed_button_dot";
        d = KvCacheMgr.getPrivate(App.context(), "video_feed_red_dot_manager");
        e = 8;
    }

    private final int f() {
        SharedPreferences.Editor putInt;
        SharedPreferences.Editor putString;
        SharedPreferences sharedPreferences = d;
        String string = sharedPreferences.getString("last_date", "");
        String e2 = e();
        if (!Intrinsics.areEqual(string, e2)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null || (putInt = edit.putInt("video_feed_red_dot_daily_show_count", 0)) == null || (putString = putInt.putString("last_date", e2)) == null) {
                return 0;
            }
            putString.apply();
            return 0;
        }
        return sharedPreferences.getInt("video_feed_red_dot_daily_show_count", 0);
    }

    private final int g() {
        SharedPreferences.Editor putInt;
        SharedPreferences.Editor putString;
        SharedPreferences sharedPreferences = d;
        String string = sharedPreferences.getString("last_date", "");
        String e2 = e();
        if (!Intrinsics.areEqual(string, e2)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null || (putInt = edit.putInt("video_feed_tab_daily_enter_count", 0)) == null || (putString = putInt.putString("last_date", e2)) == null) {
                return 0;
            }
            putString.apply();
            return 0;
        }
        return sharedPreferences.getInt("video_feed_tab_daily_enter_count", 0);
    }

    public final void h() {
        SharedPreferences.Editor putInt;
        int g = g();
        SharedPreferences.Editor edit = d.edit();
        if (edit != null && (putInt = edit.putInt("video_feed_tab_daily_enter_count", g + 1)) != null) {
            putInt.apply();
        }
        b.d("onEnterShortSeriesFeedTab , enter count:" + (g + 1), new Object[0]);
    }

    public final void i() {
        SharedPreferences.Editor putInt;
        int f = f();
        SharedPreferences.Editor edit = d.edit();
        if (edit != null && (putInt = edit.putInt("video_feed_red_dot_daily_show_count", f + 1)) != null) {
            putInt.apply();
        }
        b.d("onShortSeriesFeedTabRedDotShow , show count:" + (f + 1), new Object[0]);
    }

    public final void j() {
        GetRedDotRequest getRedDotRequest = new GetRedDotRequest();
        getRedDotRequest.showVideoSingleFeedReddotDaily = f();
        getRedDotRequest.enterVideoSingleFeedDaily = g();
        b.d("showVideoSingleFeedReddotDaily:" + getRedDotRequest.showVideoSingleFeedReddotDaily + ", enterVideoSingleFeedDaily:" + getRedDotRequest.enterVideoSingleFeedDaily, new Object[0]);
        Observable observeOn = g65.c.a0(getRedDotRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1 function1 = new Function1() { // from class: it3.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k;
                k = e.k((GetRedDotResponse) obj);
                return k;
            }
        };
        Consumer consumer = new Consumer() { // from class: it3.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                e.l(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: it3.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m;
                m = e.m((Throwable) obj);
                return m;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: it3.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                e.n(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Throwable th) {
        b.e(Log.getStackTraceString(th), new Object[0]);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r2.hasReddot == true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit k(com.dragon.read.rpc.model.GetRedDotResponse r5) {
        /*
            com.dragon.read.rpc.model.BookApiERR r0 = r5.code
            int r0 = r0.getValue()
            r1 = 0
            if (r0 != 0) goto L7f
            com.dragon.read.rpc.model.RedDotData r0 = r5.data
            if (r0 == 0) goto L7f
            com.dragon.read.base.util.LogHelper r0 = it3.e.b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "response has red dot: "
            r2.append(r3)
            com.dragon.read.rpc.model.RedDotData r3 = r5.data
            r4 = 0
            if (r3 == 0) goto L29
            com.dragon.read.rpc.model.VideoSingleFeedReddot r3 = r3.videoSingleFeedReddot
            if (r3 == 0) goto L29
            boolean r3 = r3.hasReddot
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L2a
        L29:
            r3 = r4
        L2a:
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r0.i(r2, r3)
            com.dragon.read.rpc.model.RedDotData r2 = r5.data
            if (r2 == 0) goto L44
            com.dragon.read.rpc.model.VideoSingleFeedReddot r2 = r2.videoSingleFeedReddot
            if (r2 == 0) goto L44
            boolean r2 = r2.hasReddot
            r3 = 1
            if (r2 != r3) goto L44
            goto L45
        L44:
            r3 = 0
        L45:
            if (r3 == 0) goto L6e
            java.lang.String r2 = "tryShowMainFragmentShortSeriesButtonRedDot"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.i(r2, r1)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = it3.e.c
            r0.<init>(r1)
            com.dragon.read.rpc.model.RedDotData r1 = r5.data
            if (r1 == 0) goto L60
            com.dragon.read.rpc.model.VideoSingleFeedReddot r1 = r1.videoSingleFeedReddot
            if (r1 == 0) goto L60
            java.lang.String r4 = r1.recommendInfo
        L60:
            java.lang.String r1 = "recommend_info"
            android.content.Intent r0 = r0.putExtra(r1, r4)
            java.lang.String r1 = "putExtra(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.dragon.read.component.shortvideo.depend.context.App.sendLocalBroadcast(r0)
        L6e:
            com.dragon.read.component.shortvideo.api.NsShortVideoDepend r0 = com.dragon.read.component.shortvideo.api.NsShortVideoDepend.IMPL
            com.dragon.read.rpc.model.RedDotData r1 = r5.data
            r0.onGetWatchPreferenceInfo(r1)
            ky3.a r0 = ky3.a.a
            com.dragon.read.rpc.model.RedDotData r5 = r5.data
            com.dragon.read.rpc.model.PreferenceTipData r5 = r5.singleColPreferenceTip
            r0.c(r5)
            goto La3
        L7f:
            com.dragon.read.base.util.LogHelper r0 = it3.e.b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getRedDotRequest error, msg:"
            r2.append(r3)
            java.lang.String r3 = r5.message
            r2.append(r3)
            java.lang.String r3 = ", code:"
            r2.append(r3)
            com.dragon.read.rpc.model.BookApiERR r5 = r5.code
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.e(r5, r1)
        La3:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: it3.e.k(com.dragon.read.rpc.model.GetRedDotResponse):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 function1, Object obj) {
        function1.invoke(obj);
    }
}
