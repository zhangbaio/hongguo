package com.dragon.read.component.shortvideo.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.component.interfaces.NsAcctManager;
import com.dragon.read.component.shortvideo.api.docker.provider.ProviderScene;
import com.dragon.read.pages.preview.ImageData;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.rpc.model.BottomTabBarItemType;
import com.dragon.read.rpc.model.ImageType;
import com.dragon.read.rpc.model.ReadCountShowStrategy;
import com.dragon.read.rpc.model.RedDotData;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tq3.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface NsShortVideoDepend extends IService {
    public static final a Companion;
    public static final NsShortVideoDepend IMPL;

    public static final class a {
        static final /* synthetic */ a a;

        static {
            Covode.recordClassIndex(598166);
            a = new a();
        }

        private a() {
        }
    }

    void addLoadProgressListener(i.a aVar);

    void cancelUploadReportMediaItem();

    Map<Set<ProviderScene>, List<br3.e<?>>> createShortSeriesDataProviders();

    void destroyVideoControlLayout();

    NsAcctManager getAccManagerInstance();

    int getCoverPlaceHolderSkinResId();

    String getEmptyReadHistory();

    String getEnterFromVideoHistoryPage();

    bv5.h getMainTabButtonByTabType(Activity activity, BottomTabBarItemType bottomTabBarItemType);

    int getMaxVideoHistoryCacheCount();

    String getMediaCacheListPath(String str);

    z25.a getReadCountData(String str, ReadCountShowStrategy readCountShowStrategy);

    tq3.v<?> getSeriesInsertAdDataProviderClass();

    String getShortVideoTag();

    int getUpdateTagRes();

    boolean hasPermission(Context context, String str);

    void hideVideoPlayerPendantAndPausePlayer();

    boolean isInHomePageActivity(Activity activity);

    boolean isLogin();

    boolean isOneStopAdModel(Object obj);

    boolean isShortSeriesAttributionType();

    boolean isTabButtonInStartEdge(BottomTabBarItemType bottomTabBarItemType);

    ImageData obtainImageData(View view, String str, int i, int i2, ImageType imageType);

    void onGetWatchPreferenceInfo(RedDotData redDotData);

    boolean onShortSeriesAttribution();

    void onSingleDislikeGuideViewHide();

    void onSingleFeedHolderUnselected(long j);

    void openLoginActivity(Context context, PageRecorder pageRecorder, String str);

    void openRealBookDetail(Context context, String str, PageRecorder pageRecorder, String str2, boolean z, String str3);

    void openSelectMediaPage(Activity activity, sj5.f fVar);

    void removeLoadProgressListener(i.a aVar);

    void requestVideoStoragePermission(Activity activity, Runnable runnable, Runnable runnable2);

    void sendEventToJS(AppCompatActivity appCompatActivity, String str, JSONObject jSONObject);

    void showVideoPlayerPendantAndResumePlayer();

    void startShortSeriesMemorySample(int i);

    void stopShortSeriesMemorySample(int i);

    void tryShowUserSelectGenderDialog(boolean z);

    void uploadReportMediaItem(Context context, List<? extends tj5.e> list, sj5.f fVar);

    boolean useNewVideoDetailPage();

    static {
        Covode.recordClassIndex(598165);
        Companion = a.a;
        Object service = ServiceManager.getService(NsShortVideoDepend.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(...)");
        IMPL = (NsShortVideoDepend) service;
    }

    public static final class b {
        static {
            Covode.recordClassIndex(598167);
        }

        public static void b(NsShortVideoDepend nsShortVideoDepend, AppCompatActivity activity, String event, JSONObject data) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(data, "data");
        }

        public static /* synthetic */ z25.a a(NsShortVideoDepend nsShortVideoDepend, String str, ReadCountShowStrategy readCountShowStrategy, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    readCountShowStrategy = null;
                }
                return nsShortVideoDepend.getReadCountData(str, readCountShowStrategy);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getReadCountData");
        }
    }
}
