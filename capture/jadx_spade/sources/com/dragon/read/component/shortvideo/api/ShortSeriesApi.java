package com.dragon.read.component.shortvideo.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoDetailModel;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.VideoModel;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pr3.r;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface ShortSeriesApi extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598185);
        Companion = a.a;
    }

    void cleanDiskExpireVideoModel();

    void cleanDiskRecentWatchVideoModelInfo();

    void clearAllSeriesVidCache();

    void clearExpiredDetailAndModelCache();

    void clearSeriesVideoProgress(Set<String> set);

    void clearVideoDetailCache();

    Bundle createBundleFromArgs(ShortSeriesLaunchArgs shortSeriesLaunchArgs);

    Intent createIntentFromArgs(ShortSeriesLaunchArgs shortSeriesLaunchArgs);

    zr3.i createSeekBarExpandDragProxy(Context context, boolean z);

    TTVideoEngine createTTVideoEngine();

    ShortSeriesLaunchArgs createVideoFeedShortSeriesLaunch(ps3.h hVar);

    void deleteVidCacheFromMemoryAndDisk(String str);

    void deleteVideoModelsFromDisk(List<String> list);

    boolean enableFillScreen();

    boolean enableResolution(Resolution resolution);

    void enqueue(List<pr3.n> list);

    boolean floatingWindowEnable();

    qq3.b getAbTagManager();

    Map<String, r> getAllVideoModelsFromDisk();

    kq3.a getAudioPlayerManager();

    Resolution getAvailableResolution(VideoModel videoModel, Resolution[] resolutionArr, String str, int i);

    float getCacheVideoSpeed(String str);

    rq3.n getController(Context context);

    xr3.c getCurrentShortSeriesScaleConfig();

    y getDocker();

    boolean getLockStatus();

    long getMaterialVideoGuidanceCloseTime();

    qr3.b getPlayChainTraceMonitor();

    Resolution getPreloadResolution(VideoModel videoModel, Resolution[] resolutionArr, String str, int i);

    ss3.a getRequestManager();

    Fragment getSeriesBookMallTabFragment(ir3.a aVar);

    SaasVideoDetailModel getSeriesIdPrefetchCache(String str);

    vr3.b getSeriesReporter();

    rq3.q getSeriesShortPageController(rq3.p pVar);

    sr3.a getSeriesVideoPrepareManager();

    Class<?> getShortSeriesActivityCls();

    jr3.b getShortSeriesGuideFrequencyService();

    r getVideoModelFromDisk(String str);

    boolean hasSystemAlertPermission(boolean z);

    void init(Context context, y yVar);

    boolean isDisableFastPlayWhenPeak();

    boolean isInShortSeriesActivityDetailFragment(Context context);

    boolean isNowInHotTime();

    boolean isSeriesResolutionUiShow();

    boolean isShortSeriesActivity(Context context);

    boolean isShortSeriesLandActivity(Context context);

    void launchPlayer(Context context, String str, pq3.s sVar);

    Observable<r> loadVideoModel(boolean z, pr3.f fVar);

    void markCanPauseVideoWhenLossAudioFocus();

    as3.a newViewPageOrientationHelper(as3.b bVar);

    rr3.a obtainShortPlayer();

    r obtainVideoModelFromCache(String str);

    void openShortSeriesActivity(ShortSeriesLaunchArgs shortSeriesLaunchArgs);

    void openShortSeriesActivityForResult(ShortSeriesLaunchArgs shortSeriesLaunchArgs);

    void prefetchMultiVideoModel(List<pr3.f> list, int i);

    void prefetchSingleVideoModel(String str, String str2, int i);

    void preloadVideoResource(SaasVideoData saasVideoData, Activity activity);

    void reportLauncherServiceParseSuccess(String str);

    void resumePreload();

    void saveVideoModeToDisk(String str, r rVar);

    void saveVideoModelsToDisk(Map<String, r> map);

    void setShortSeriesScaleConfig(xr3.c cVar);

    void sharePlayerPoolRelease();

    void showDefinitionFinishToast(String str, String str2, int i, int i2);

    void showDefinitionLoadingToast(String str, String str2, int i);

    void showWifiToastIfNeeded(boolean z);

    boolean tryPrepareVideo(ShortSeriesLaunchArgs shortSeriesLaunchArgs, int i);

    void updateFillScreen(boolean z);

    void updateFloatingWindowEnable(boolean z);

    public static final class a {
        static final /* synthetic */ a a;
        private static final Lazy<ShortSeriesApi> b;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ShortSeriesApi b() {
            return (ShortSeriesApi) ServiceManager.getService(ShortSeriesApi.class);
        }

        public final ShortSeriesApi c() {
            ShortSeriesApi value = b.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return value;
        }

        static {
            Lazy<ShortSeriesApi> lazy;
            Covode.recordClassIndex(598186);
            a = new a();
            lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.z
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    ShortSeriesApi b2;
                    b2 = ShortSeriesApi.a.b();
                    return b2;
                }
            });
            b = lazy;
        }
    }

    /* renamed from: com.dragon.read.component.shortvideo.api.ShortSeriesApi$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a aVar = ShortSeriesApi.Companion;
        }

        public static /* synthetic */ boolean hasSystemAlertPermission$default(ShortSeriesApi shortSeriesApi, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return shortSeriesApi.hasSystemAlertPermission(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasSystemAlertPermission");
        }

        public static /* synthetic */ zr3.i createSeekBarExpandDragProxy$default(ShortSeriesApi shortSeriesApi, Context context, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return shortSeriesApi.createSeekBarExpandDragProxy(context, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSeekBarExpandDragProxy");
        }

        public static /* synthetic */ Observable loadVideoModel$default(ShortSeriesApi shortSeriesApi, boolean z, pr3.f fVar, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return shortSeriesApi.loadVideoModel(z, fVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadVideoModel");
        }

        public static /* synthetic */ Resolution getAvailableResolution$default(ShortSeriesApi shortSeriesApi, VideoModel videoModel, Resolution[] resolutionArr, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    i = -1;
                }
                return shortSeriesApi.getAvailableResolution(videoModel, resolutionArr, str, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAvailableResolution");
        }

        public static /* synthetic */ Resolution getPreloadResolution$default(ShortSeriesApi shortSeriesApi, VideoModel videoModel, Resolution[] resolutionArr, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    i = -1;
                }
                return shortSeriesApi.getPreloadResolution(videoModel, resolutionArr, str, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPreloadResolution");
        }

        public static /* synthetic */ void showDefinitionFinishToast$default(ShortSeriesApi shortSeriesApi, String str, String str2, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    i2 = 0;
                }
                shortSeriesApi.showDefinitionFinishToast(str, str2, i, i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDefinitionFinishToast");
        }
    }
}
