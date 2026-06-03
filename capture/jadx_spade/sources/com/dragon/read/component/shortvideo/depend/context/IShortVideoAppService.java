package com.dragon.read.component.shortvideo.depend.context;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.dragon.read.report.PageRecorder;
import java.io.Serializable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface IShortVideoAppService extends IService {
    public static final /* synthetic */ int T0 = 0;

    static {
        Covode.recordClassIndex(599177);
    }

    Application context();

    Activity currentActivityOrNull();

    Activity getCurrentActivity();

    boolean isDebugMode();

    boolean isNightTheme();

    boolean isRecentWatchVideoPendantShowing();

    void openUrl(Context context, String str, PageRecorder pageRecorder);

    void openUrl(Context context, String str, PageRecorder pageRecorder, Map<String, ? extends Serializable> map);

    void refreshPendantViewLocation(Activity activity, View view);

    void registerLocalReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    void registerLocalReceiver(BroadcastReceiver broadcastReceiver, String... strArr);

    void registerPendantView(Activity activity, View view);

    void removeRecentWatchVideoPendant();

    void sendLocalBroadcast(Intent intent);

    void setShouldPlaySeriesMall(boolean z);

    boolean shouldPlaySeriesMall();

    void unregisterLocalReceiver(BroadcastReceiver... broadcastReceiverArr);

    void unregisterPendantView(View view);

    /* renamed from: com.dragon.read.component.shortvideo.depend.context.IShortVideoAppService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isRecentWatchVideoPendantShowing(IShortVideoAppService iShortVideoAppService) {
            return false;
        }

        public static void $default$refreshPendantViewLocation(IShortVideoAppService iShortVideoAppService, Activity activity, View view) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public static void $default$registerPendantView(IShortVideoAppService iShortVideoAppService, Activity activity, View pendantView) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(pendantView, "pendantView");
        }

        public static void $default$removeRecentWatchVideoPendant(IShortVideoAppService iShortVideoAppService) {
        }

        public static void $default$setShouldPlaySeriesMall(IShortVideoAppService iShortVideoAppService, boolean z) {
        }

        public static boolean $default$shouldPlaySeriesMall(IShortVideoAppService iShortVideoAppService) {
            return false;
        }

        static {
            int i = IShortVideoAppService.T0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void openUrl$default(IShortVideoAppService iShortVideoAppService, Context context, String str, PageRecorder pageRecorder, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    map = null;
                }
                iShortVideoAppService.openUrl(context, str, pageRecorder, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openUrl");
        }
    }
}
