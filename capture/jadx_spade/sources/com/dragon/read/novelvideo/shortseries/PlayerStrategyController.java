package com.dragon.read.novelvideo.shortseries;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsUtilsDepend;
import com.dragon.read.absettings.PlayletPeekTime;
import com.dragon.read.base.util.JSONUtils;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.component.shortvideo.api.config.ResolutionStrategyData;
import com.dragon.read.component.shortvideo.api.config.ResolutionStrategyDataList;
import com.dragon.read.component.shortvideo.api.config.ssconfig.SeriesResolution1080AbValue;
import com.dragon.read.component.shortvideo.api.config.ssconfig.SeriesResolutionV713;
import com.dragon.read.component.shortvideo.api.config.ssconfig.ServerSeriesResolutionABValue;
import com.dragon.read.rpc.model.DeviceLevel;
import com.dragon.read.rpc.model.PlayStrategyRequest;
import com.dragon.read.rpc.model.PlayStrategyResponse;
import com.dragon.read.rpc.model.PlayStrategyResponseData;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import g65.f;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pq3.j;
import pq3.k;
import pu1.a0;
import pu1.y;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerStrategyController {
    public static final PlayerStrategyController a;
    private static long b;
    private static Boolean c;
    private static boolean d;
    private static final Handler e;
    private static final LogHelper f;
    private static PeakDownShiftData g;
    private static List<ResolutionStrategyData> h;
    private static int i;
    private static final Runnable j;
    private static final ServerSeriesResolutionABValue k;
    private static final SeriesResolution1080AbValue l;
    private static volatile ResolutionStrategyData m;
    private static volatile long n;
    public static final int o;

    private PlayerStrategyController() {
    }

    public final ResolutionStrategyData g() {
        return m;
    }

    public final long h() {
        return n;
    }

    public final boolean k() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p() {
        a.q();
    }

    private final DeviceLevel f() {
        NsUtilsDepend nsUtilsDepend = NsUtilsDepend.IMPL;
        if (nsUtilsDepend.isLowDevice()) {
            return DeviceLevel.Low;
        }
        if (nsUtilsDepend.isMiddleLowDevice()) {
            return DeviceLevel.Middle;
        }
        return DeviceLevel.High;
    }

    public static final class PeakDownShiftData {
        public static final int b;
        public boolean a;

        @SerializedName("force_sr")
        public final boolean forceSr;

        @SerializedName("resolution")
        public final String resolution;

        @SerializedName("resolution_in_peak_min_episode_index")
        public final int resolutionInPeakMinEpisodeIndex;

        static {
            Covode.recordClassIndex(612521);
            b = 8;
        }

        public PeakDownShiftData() {
            this(null, false, 0, false, 15, null);
        }

        public String toString() {
            return "resolution: " + this.resolution + " , forceSr: " + this.forceSr + " , resolutionInPeakMinEpisodeIndex: " + this.resolutionInPeakMinEpisodeIndex;
        }

        public PeakDownShiftData(String str, boolean z, int i, boolean z2) {
            this.resolution = str;
            this.forceSr = z;
            this.resolutionInPeakMinEpisodeIndex = i;
            this.a = z2;
        }

        public /* synthetic */ PeakDownShiftData(String str, boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? -1 : i, (i2 & 8) != 0 ? false : z2);
        }
    }

    public final k i() {
        j jVar;
        String str;
        boolean z;
        int i2;
        if (g == null) {
            jVar = null;
        } else {
            PeakDownShiftData peakDownShiftData = g;
            if (peakDownShiftData == null || (str = peakDownShiftData.resolution) == null) {
                str = "";
            }
            boolean z2 = false;
            if (peakDownShiftData != null) {
                z = peakDownShiftData.forceSr;
            } else {
                z = false;
            }
            if (peakDownShiftData != null) {
                i2 = peakDownShiftData.resolutionInPeakMinEpisodeIndex;
            } else {
                i2 = -1;
            }
            if (peakDownShiftData != null) {
                z2 = peakDownShiftData.a;
            }
            jVar = new j(str, z, i2, z2);
        }
        return new k(jVar, h);
    }

    private final void q() {
        e.removeCallbacks(j);
        PlayStrategyRequest playStrategyRequest = new PlayStrategyRequest();
        playStrategyRequest.deviceLevel = a.f();
        playStrategyRequest.deviceScore = 0;
        Observable observeOn = f.b(playStrategyRequest).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1 function1 = new Function1() { // from class: com.dragon.read.novelvideo.shortseries.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r;
                r = PlayerStrategyController.r((PlayStrategyResponse) obj);
                return r;
            }
        };
        Consumer consumer = new Consumer() { // from class: com.dragon.read.novelvideo.shortseries.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PlayerStrategyController.s(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.novelvideo.shortseries.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit t;
                t = PlayerStrategyController.t((Throwable) obj);
                return t;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.novelvideo.shortseries.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PlayerStrategyController.u(Function1.this, obj);
            }
        });
    }

    static {
        Covode.recordClassIndex(612520);
        PlayerStrategyController playerStrategyController = new PlayerStrategyController();
        a = playerStrategyController;
        b = 300000L;
        e = new HandlerDelegate(Looper.getMainLooper());
        LogHelper logHelper = new LogHelper("PlayerStrategyController");
        f = logHelper;
        j = new Runnable() { // from class: com.dragon.read.novelvideo.shortseries.a
            @Override // java.lang.Runnable
            public final void run() {
                PlayerStrategyController.p();
            }
        };
        ServerSeriesResolutionABValue a2 = a0.c.a();
        k = a2;
        SeriesResolution1080AbValue a3 = y.c.a();
        l = a3;
        n = -1L;
        try {
        } catch (Exception e2) {
            f.e("request error " + e2.getMessage(), new Object[0]);
        }
        if (!a2.enableServer && !PlayletPeekTime.a.a().enable && !a3.enableServer && !SeriesResolutionV713.a.a().enable) {
            logHelper.i("enable server false", new Object[0]);
            o = 8;
        }
        logHelper.i("do first request", new Object[0]);
        playerStrategyController.q();
        o = 8;
    }

    public final void o(ResolutionStrategyData resolutionStrategyData) {
        m = resolutionStrategyData;
        n = System.currentTimeMillis();
    }

    public final boolean j(Boolean bool) {
        if (d) {
            Boolean bool2 = c;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            return false;
        }
        if (bool != null || (bool = c) != null) {
            return bool.booleanValue();
        }
        return ShortSeriesApi.Companion.c().isNowInHotTime();
    }

    private final void n(Map<String, String> map) {
        boolean z;
        List<ResolutionStrategyData> list = null;
        if (!map.containsKey("resolution_strategy")) {
            f.i("data not contains key: resolution_strategy  return", new Object[0]);
            h = null;
            return;
        }
        String str = map.get("resolution_strategy");
        LogHelper logHelper = f;
        logHelper.i("parse resolution_strategy is " + str, new Object[0]);
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            ResolutionStrategyDataList resolutionStrategyDataList = (ResolutionStrategyDataList) JSONUtils.getSafeObject(str, ResolutionStrategyDataList.class);
            logHelper.i("load successful ! resolution strategy is: " + resolutionStrategyDataList, new Object[0]);
            if (resolutionStrategyDataList != null) {
                list = resolutionStrategyDataList.list;
            }
            h = list;
            return;
        }
        h = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(PlayStrategyResponse playStrategyResponse) {
        Boolean bool;
        boolean z;
        long j2;
        LogHelper logHelper = f;
        logHelper.i("subscribe resp is " + playStrategyResponse, new Object[0]);
        PlayStrategyResponseData playStrategyResponseData = playStrategyResponse.data;
        if (playStrategyResponseData != null) {
            bool = Boolean.valueOf(playStrategyResponseData.isPeakPeriod);
        } else {
            bool = null;
        }
        c = bool;
        if (playStrategyResponseData != null) {
            z = playStrategyResponseData.useVideoarchPeakPeriod;
        } else {
            z = false;
        }
        d = z;
        if (playStrategyResponseData != null) {
            j2 = playStrategyResponseData.queryGap * 1000;
        } else {
            j2 = b;
        }
        i = 0;
        logHelper.i("in peak period", new Object[0]);
        PlayerStrategyController playerStrategyController = a;
        Map<String, String> strategies = playStrategyResponseData.strategies;
        Intrinsics.checkNotNullExpressionValue(strategies, "strategies");
        playerStrategyController.l(strategies, playStrategyResponseData.isPeakPeriod);
        logHelper.i("delayRequest " + j2, new Object[0]);
        e.postDelayed(j, j2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Throwable th) {
        LogHelper logHelper = f;
        logHelper.i("request failed ! message is " + th.getMessage(), new Object[0]);
        int i2 = i + 1;
        i = i2;
        long j2 = ((long) (i2 * 10)) * 1000;
        logHelper.d("Request failed. Retrying in " + j2 + "/1000 ...", new Object[0]);
        e.postDelayed(j, j2);
        if (i >= 3) {
            logHelper.d("Request failed too much time , use local config", new Object[0]);
            g = null;
            h = null;
            c = null;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    private final void l(Map<String, String> map, boolean z) {
        m(map, z);
        n(map);
    }

    private final void m(Map<String, String> map, boolean z) {
        boolean z2;
        if (!map.containsKey("peak_demotion")) {
            f.i("data not contains key: peak_demotion  return", new Object[0]);
            g = null;
            return;
        }
        String str = map.get("peak_demotion");
        LogHelper logHelper = f;
        logHelper.i("parse peak_demotion is " + str, new Object[0]);
        if (str != null && str.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            PeakDownShiftData peakDownShiftData = (PeakDownShiftData) JSONUtils.getSafeObject(str, PeakDownShiftData.class);
            logHelper.i("load successful ! peakDemotion:  " + peakDownShiftData, new Object[0]);
            if (peakDownShiftData != null) {
                peakDownShiftData.a = z;
            }
            g = peakDownShiftData;
            return;
        }
        logHelper.i("load failed!", new Object[0]);
        g = null;
    }
}
