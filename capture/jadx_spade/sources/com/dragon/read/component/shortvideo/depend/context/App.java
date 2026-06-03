package com.dragon.read.component.shortvideo.depend.context;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.component.shortvideo.depend.context.App;
import com.dragon.read.component.shortvideo.depend.context.IShortVideoAppService;
import com.dragon.read.report.PageRecorder;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class App {
    public static final App INSTANCE;
    private static final Lazy proxy$delegate;

    private App() {
    }

    public final void removePendantView() {
        getProxy().removeRecentWatchVideoPendant();
    }

    public static final Application context() {
        return INSTANCE.getProxy().context();
    }

    private final IShortVideoAppService getProxy() {
        return (IShortVideoAppService) proxy$delegate.getValue();
    }

    public static final boolean isDebugMode() {
        return INSTANCE.getProxy().isDebugMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IShortVideoAppService proxy_delegate$lambda$0() {
        return (IShortVideoAppService) ServiceManager.getService(IShortVideoAppService.class);
    }

    public final Activity currentActivityOrNull() {
        return getProxy().currentActivityOrNull();
    }

    public final Activity getCurrentActivity() {
        return getProxy().getCurrentActivity();
    }

    public final boolean isNightTheme() {
        return getProxy().isNightTheme();
    }

    public final boolean isRecentWatchVideoPendantShowing() {
        return getProxy().isRecentWatchVideoPendantShowing();
    }

    public final boolean shouldPlaySeriesMall() {
        return getProxy().shouldPlaySeriesMall();
    }

    static {
        Lazy lazy;
        Covode.recordClassIndex(599173);
        INSTANCE = new App();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: ys3.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IShortVideoAppService proxy_delegate$lambda$0;
                proxy_delegate$lambda$0 = App.proxy_delegate$lambda$0();
                return proxy_delegate$lambda$0;
            }
        });
        proxy$delegate = lazy;
    }

    public final void setShouldPlaySeriesMall(boolean z) {
        getProxy().setShouldPlaySeriesMall(z);
    }

    public static final void sendLocalBroadcast(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        INSTANCE.getProxy().sendLocalBroadcast(intent);
    }

    public final void unregisterPendantView(View pendantView) {
        Intrinsics.checkNotNullParameter(pendantView, "pendantView");
        getProxy().unregisterPendantView(pendantView);
    }

    public final void unregisterLocalReceiver(BroadcastReceiver... receivers) {
        Intrinsics.checkNotNullParameter(receivers, "receivers");
        getProxy().unregisterLocalReceiver((BroadcastReceiver[]) Arrays.copyOf(receivers, receivers.length));
    }

    public final void registerLocalReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        getProxy().registerLocalReceiver(broadcastReceiver, intentFilter);
    }

    public final void refreshPendantViewLocation(Activity activity, View view) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        getProxy().refreshPendantViewLocation(activity, view);
    }

    public final void registerLocalReceiver(BroadcastReceiver broadcastReceiver, String... actions) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        getProxy().registerLocalReceiver(broadcastReceiver, (String[]) Arrays.copyOf(actions, actions.length));
    }

    public final void registerPendantView(Activity activity, View pendantView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pendantView, "pendantView");
        getProxy().registerPendantView(activity, pendantView);
    }

    public final void openUrl(Context context, String str, PageRecorder pageRecorder) {
        getProxy().openUrl(context, str, pageRecorder);
    }

    public final void openUrl(Context context, String str, PageRecorder pageRecorder, Map<String, ? extends Serializable> map) {
        getProxy().openUrl(context, str, pageRecorder, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openUrl$default(App app, Context context, String str, PageRecorder pageRecorder, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = null;
        }
        app.openUrl(context, str, pageRecorder, map);
    }
}
