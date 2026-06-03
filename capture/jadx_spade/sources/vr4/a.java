package vr4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.byted.mgl.merge.service.api.aweme.AwemeHomePageCaptionListener;
import com.byted.mgl.merge.service.api.aweme.AwemeHomePageSideBarEntryAnimListener;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeService;
import com.byted.mgl.merge.service.api.aweme.FollowAwemeCallback;
import com.byted.mgl.merge.service.api.aweme.FollowDesignateAwemeUserCallback;
import com.byted.mgl.merge.service.api.aweme.JoinConversationCallback;
import com.byted.mgl.merge.service.api.aweme.OnProfileCardOpenCallback;
import com.byted.mgl.merge.service.api.aweme.OpenAwemeUserProfileCallback;
import com.byted.mgl.merge.service.api.aweme.RequestLynxPaymentCallback;
import com.byted.mgl.merge.service.api.aweme.f;
import com.byted.mgl.merge.service.api.aweme.g;
import com.bytedance.bdp.appbase.base.ipc.BdpIpcService;
import com.bytedance.bdp.appbase.base.log.BdpLogger;
import com.bytedance.bdp.bdpbase.ipc.IpcBaseCallback;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.ProcessUtil;
import com.bytedance.bdp.serviceapi.hostimpl.account.model.BdpUserInfo;
import com.bytedance.covode.number.Covode;
import com.bytedance.ies.xbridge.ReadableMapImpl;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.bytedance.router.SmartRouter;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.AppProperty;
import com.dragon.read.base.ssconfig.template.VideoFeedSlideBarConfig;
import com.dragon.read.mgl.service.AwemeIpcProvider;
import com.dragon.read.mgl.service.view.BdpTransferActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements BdpAwemeService {
    public static final C0280a a;

    /* renamed from: vr4.a$a, reason: collision with other inner class name */
    public static final class C0280a {
        static {
            Covode.recordClassIndex(611964);
        }

        private C0280a() {
        }

        public /* synthetic */ C0280a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611963);
        a = new C0280a(null);
    }

    public void cacheShareScreenshotContent(String str, String str2, Bundle bundle) {
    }

    public void checkFollowAwemeState(String str, String str2, FollowAwemeCallback followAwemeCallback) {
    }

    public JSONArray fetchAwemeFriendsList(String str, int i) {
        return null;
    }

    public void followAwemeAccountWithOutJump(String id, String secUserId, int i, int i2, int i3, String str, int i4, String str2, BdpAwemeService.FollowStatusListener followStatusListener, String str3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(secUserId, "secUserId");
    }

    public void followDesignateAwemeUser(Activity activity, String secUserId, FollowDesignateAwemeUserCallback followDesignateAwemeUserCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(secUserId, "secUserId");
    }

    public void getAwemeAccountInfo(String str, String str2, BdpAwemeService.c cVar) {
    }

    public void getAwemeOfficialAccountInfo(String str, String str2, BdpAwemeService.GetAwemeOfficialAccountInfoListener getAwemeOfficialAccountInfoListener) {
    }

    public boolean getChatGroupInfo(String str, com.byted.mgl.merge.service.api.aweme.a aVar, BdpUserInfo bdpUserInfo) {
        return false;
    }

    public String getGameDetailSchema(String str) {
        return "";
    }

    public boolean getIsNoNeedOpenSchemaMiddleActivity() {
        return true;
    }

    public String getMiniGameGiftIcon() {
        return "";
    }

    public String getMiniGameLoadingShow() {
        return "";
    }

    public int getPluginPreloadDelayOpt() {
        return 0;
    }

    public void getUserInfo(String secUid, BdpAwemeService.d dVar) {
        Intrinsics.checkNotNullParameter(secUid, "secUid");
    }

    public boolean hasAwemeImpl() {
        return false;
    }

    public boolean hasPOILocationPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return false;
    }

    public boolean isAwemeTeenMode() {
        return false;
    }

    public boolean isNoNeedBdpTransferActivity() {
        return false;
    }

    public boolean isPad() {
        return false;
    }

    public boolean isSideMenuInMainPageSync() {
        return false;
    }

    public boolean isSupportAwemeAuthAbility() {
        return false;
    }

    public boolean isSupportShareScreenshot() {
        return false;
    }

    public boolean joinChatGroup(Activity activity, String appId, boolean z, com.byted.mgl.merge.service.api.aweme.b bVar) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        return false;
    }

    public boolean joinConversation(Map<String, String> map, JoinConversationCallback joinConversationCallback, Activity activity, BdpUserInfo bdpUserInfo) {
        return false;
    }

    public void openAwemeUserProfile(Activity activity, String str, String str2, boolean z, boolean z2, OpenAwemeUserProfileCallback openAwemeUserProfileCallback) {
    }

    public void openCardProfilePanel(Activity activity, String secUid, String str, OnProfileCardOpenCallback onProfileCardOpenCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(secUid, "secUid");
    }

    public void openLiveAnchorPanel(Activity activity, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void rateAwemeOrder(Activity activity, String str, com.byted.mgl.merge.service.api.aweme.d dVar) {
    }

    public void requestAuthCode(String appId, List<String> scopeKeyList, String ticket, com.byted.mgl.merge.service.api.aweme.e requestAuthCodeListener) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(scopeKeyList, "scopeKeyList");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(requestAuthCodeListener, "requestAuthCodeListener");
    }

    public void requestAuthScopeInfo(String appId, BdpAwemeService.a authTickerRequestResult, f requestAuthInfoListener) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(authTickerRequestResult, "authTickerRequestResult");
        Intrinsics.checkNotNullParameter(requestAuthInfoListener, "requestAuthInfoListener");
    }

    public void requestAuthTicket(String appId, List<String> scopeKeyList, g requestAuthTicketListener) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(scopeKeyList, "scopeKeyList");
        Intrinsics.checkNotNullParameter(requestAuthTicketListener, "requestAuthTicketListener");
    }

    public void sendAuthorLiveCastingPageChanged(String str, String str2) {
    }

    public void setIsCanShowShareFlow(boolean z) {
    }

    public void showInvitePanel(Activity activity, HashMap<String, String> appInfoMap, HashMap<String, String> hashMap, com.byted.mgl.merge.service.api.aweme.c cVar) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appInfoMap, "appInfoMap");
    }

    public boolean useMiniGameNewIcon() {
        return false;
    }

    public Boolean isColdBoot() {
        return Boolean.TRUE;
    }

    public Boolean skipRealNameAuth() {
        return Boolean.FALSE;
    }

    public static final class b implements IpcBaseCallback<Bundle> {
        final /* synthetic */ BdpAwemeService.JsEventCallback a;

        b(BdpAwemeService.JsEventCallback jsEventCallback) {
            this.a = jsEventCallback;
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(int i, String str, Bundle bundle) {
            JSONObject jSONObject;
            if (i == 100 && bundle != null) {
                String string = bundle.getString("eventName");
                try {
                    jSONObject = new JSONObject(bundle.getString("data"));
                } catch (Exception unused) {
                    jSONObject = new JSONObject();
                }
                BdpAwemeService.JsEventCallback jsEventCallback = this.a;
                if (jsEventCallback != null) {
                    jsEventCallback.onReceiveJsEvent(string, jSONObject);
                }
            }
        }
    }

    public static final class c implements JsEventSubscriber {
        final /* synthetic */ BdpAwemeService.JsEventCallback a;

        c(BdpAwemeService.JsEventCallback jsEventCallback) {
            this.a = jsEventCallback;
        }

        public void onReceiveJsEvent(Js2NativeEvent jsEvent) {
            Map map;
            Intrinsics.checkNotNullParameter(jsEvent, "jsEvent");
            JSONObject jSONObject = new JSONObject();
            XReadableMap params = jsEvent.getParams();
            if (params != null && (map = params.toMap()) != null) {
                jSONObject = new JSONObject(map);
            }
            BdpAwemeService.JsEventCallback jsEventCallback = this.a;
            if (jsEventCallback != null) {
                jsEventCallback.onReceiveJsEvent(jsEvent.getEventName(), jSONObject);
            }
        }
    }

    public JSONObject getCjPaiInfo(Context context) {
        return new JSONObject();
    }

    public boolean checkScene(String str) {
        boolean z;
        if (!Intrinsics.areEqual(str, "sidebar")) {
            BdpLogger.i("BdpAwemeServiceImpl", new Object[]{"checkScene rejected, unsupported scene=" + str});
            return false;
        }
        int appId = AppProperty.getAppId();
        if (appId == 1967) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            BdpLogger.i("BdpAwemeServiceImpl", new Object[]{"checkScene allowed, fanqie appId=" + appId});
            return true;
        }
        boolean z2 = VideoFeedSlideBarConfig.a.a().enable;
        BdpLogger.i("BdpAwemeServiceImpl", new Object[]{"checkScene hongguo, sidebar enable=" + z2 + ", appId=" + appId});
        return z2;
    }

    public void sendPageEventInMainProcess(String str, JSONObject jSONObject) {
        sendPageEvent(str, jSONObject, true);
    }

    public void tryShowEntranceCaption(String str, AwemeHomePageCaptionListener awemeHomePageCaptionListener) {
        if (awemeHomePageCaptionListener != null) {
            awemeHomePageCaptionListener.fail(10301, "feature is not supported in app");
        }
    }

    public void handlePageEventListenerInMainProcess(String str, boolean z, BdpAwemeService.JsEventCallback jsEventCallback) {
        handlePageEventListener(str, z, true, jsEventCallback);
    }

    public void requestAuth(FragmentActivity fragmentActivity, String str, BdpAwemeService.AuthResultCallBack authResultCallBack) {
        if (authResultCallBack != null) {
            authResultCallBack.onUserDenied(false);
        }
    }

    public void showAuth(FragmentActivity fragmentActivity, String str, BdpAwemeService.AuthResultCallBack authResultCallBack) {
        if (authResultCallBack != null) {
            authResultCallBack.onUserDenied(false);
        }
    }

    public void tryShowEntranceGuideAnim(String str, String str2, AwemeHomePageSideBarEntryAnimListener awemeHomePageSideBarEntryAnimListener) {
        if (awemeHomePageSideBarEntryAnimListener != null) {
            awemeHomePageSideBarEntryAnimListener.onShowFailed("feature is not supported in app");
        }
    }

    public void tryShowEntranceBubble(String str, String str2, AwemeHomePageCaptionListener awemeHomePageCaptionListener) {
        if (awemeHomePageCaptionListener != null) {
            awemeHomePageCaptionListener.fail(10301, "feature is not supported in app");
        }
    }

    public void navigateToScene(String str, String str2, BdpAwemeService.IOperateSceneListener iOperateSceneListener) {
        Activity currentActivity;
        ActivityRecordManager inst = ActivityRecordManager.inst();
        if (inst != null && (currentActivity = inst.getCurrentActivity()) != null) {
            Unit unit = null;
            if (!Intrinsics.areEqual(str, "sidebar")) {
                currentActivity = null;
            }
            if (currentActivity != null) {
                SmartRouter.buildRoute(currentActivity, str2).open();
                if (iOperateSceneListener != null) {
                    iOperateSceneListener.onResult(0, "");
                    unit = Unit.INSTANCE;
                }
                if (unit != null) {
                    return;
                }
            }
        }
        if (iOperateSceneListener != null) {
            iOperateSceneListener.onResult(-1, "feature is not supported in app");
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public void sendPageEvent(String str, JSONObject jSONObject, boolean z) {
        AwemeIpcProvider awemeIpcProvider;
        if (z) {
            BdpIpcService service = BdpManager.getInst().getService(BdpIpcService.class);
            if (service != null && (awemeIpcProvider = (AwemeIpcProvider) service.getMainBdpIPC().create(AwemeIpcProvider.class)) != null) {
                awemeIpcProvider.sendPageEvent(str, jSONObject);
                return;
            }
            return;
        }
        if (str == null) {
            str = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        EventCenter.enqueueEvent(new Event(str, currentTimeMillis, new ReadableMapImpl(jSONObject)));
    }

    public void fetchBulletContent(int i, int i2, Map<String, ?> map, BdpAwemeService.b bVar) {
        if (bVar != null) {
            bVar.onFailed();
        }
    }

    public void handlePageEventListener(String str, boolean z, boolean z2, BdpAwemeService.JsEventCallback jsEventCallback) {
        AwemeIpcProvider awemeIpcProvider;
        if (!z2) {
            c cVar = new c(jsEventCallback);
            if (z) {
                if (str == null) {
                    str = "";
                }
                EventCenter.registerJsEventSubscriber(str, cVar);
                return;
            } else {
                if (str == null) {
                    str = "";
                }
                EventCenter.unregisterJsEventSubscriber(str, cVar);
                return;
            }
        }
        BdpIpcService service = BdpManager.getInst().getService(BdpIpcService.class);
        if (service != null && (awemeIpcProvider = (AwemeIpcProvider) service.getMainBdpIPC().create(AwemeIpcProvider.class)) != null) {
            awemeIpcProvider.handlePageEventListener(str, z, new b(jsEventCallback));
        }
    }

    public void openSchema(Activity activity, String str, String str2, Function2<? super Boolean, ? super String, Unit> function2, JSONObject jSONObject) {
        boolean z;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        ds4.c.a.a(activity, str, str2, function2, jSONObject);
    }

    public void joinFansGroup(boolean z, String str, String str2, String str3, boolean z2, BdpAwemeService.JoinFansGroupListener joinFansGroupListener) {
        if (joinFansGroupListener != null) {
            joinFansGroupListener.onError(10301, "feature is not supported in app");
        }
    }

    public void requestLynxPayment(Activity activity, String str, int i, String str2, String str3, String str4, RequestLynxPaymentCallback requestLynxPaymentCallback) {
        if (activity == null) {
            if (requestLynxPaymentCallback != null) {
                requestLynxPaymentCallback.onFailed(10301, "curActivity is null");
            }
        } else if (!ProcessUtil.isMainProcess(activity) && !ProcessUtil.isMiniAppProcess(activity) && !ProcessUtil.isMiniGameProcess(activity)) {
            if (requestLynxPaymentCallback != null) {
                requestLynxPaymentCallback.onFailed(10301, "feature is not supported in app");
            }
        } else {
            if (requestLynxPaymentCallback != null) {
                requestLynxPaymentCallback.payWidthType("lynx");
            }
            BdpTransferActivity.g.f(activity, str, i, str2, str3, str4, requestLynxPaymentCallback);
        }
    }
}
