package com.vivo.push;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PushClient extends a implements com.vivo.push.e.a {
    private static volatile PushClient sPushClient;
    private Context mContext;
    private boolean mIsInitSdk;
    private com.vivo.push.e.a mSyncProfileInfo;

    static {
        Covode.recordClassIndex(654971);
    }

    public void checkManifest() throws VivoPushException {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return;
        }
        m.a().b();
    }

    public String getVersion() {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return null;
        }
        return "506";
    }

    private boolean checkAgreePrivacyStatementAndInitSdk() {
        if (!com.vivo.push.restructure.a.a().e().m().isAgreePrivacyStatement()) {
            return false;
        }
        inidSdk(this.mContext);
        return true;
    }

    public String getAlias() {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return null;
        }
        return m.a().i();
    }

    public List<String> getTopics() {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return new ArrayList();
        }
        m.a();
        return m.c();
    }

    public boolean isSupport() {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return false;
        }
        return m.a().d();
    }

    public int isSupportNewControlStrategies() {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return -1;
        }
        return com.vivo.push.restructure.a.a().g().a();
    }

    public int isSupportSyncProfileInfo() {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return -1;
        }
        return com.vivo.push.restructure.a.a().g().b();
    }

    private void initialize() throws VivoPushException {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return;
        }
        checkManifest();
        m a = m.a();
        com.vivo.push.b.f fVar = new com.vivo.push.b.f();
        fVar.a(com.vivo.push.restructure.a.a().e().l());
        a.a(fVar);
        com.vivo.push.util.t.d("PushClientManager", "startWork");
    }

    public void setSystemModel(boolean z) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return;
        }
        m.a().a(z);
    }

    private PushClient(Context context) {
        this.mContext = ContextDelegate.getContext(context);
        com.vivo.push.restructure.a.a().a(context);
        m.a().a(context);
        this.mSyncProfileInfo = new com.vivo.push.e.d();
    }

    private void checkParam(String str) {
        if (str != null) {
        } else {
            throw new IllegalArgumentException("PushManager String param should not be ".concat(String.valueOf(str)));
        }
    }

    private String getAppId(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return com.vivo.push.restructure.a.a().e().a();
    }

    private String getAppKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return com.vivo.push.restructure.a.a().e().c();
    }

    public static synchronized PushClient getInstance(Context context) {
        PushClient pushClient;
        synchronized (PushClient.class) {
            if (sPushClient == null) {
                sPushClient = new PushClient(context.getApplicationContext());
            }
            pushClient = sPushClient;
        }
        return pushClient;
    }

    private void inidSdk(Context context) {
        synchronized (this) {
            if (!this.mIsInitSdk) {
                m.a().a(context);
                this.mIsInitSdk = true;
            }
        }
    }

    @Override // com.vivo.push.e.a
    public void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else {
            com.vivo.push.e.a aVar = this.mSyncProfileInfo;
            if (aVar != null) {
                aVar.deleteAllProfileId(iPushRequestCallback);
            }
        }
    }

    public void deleteRegid(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
                return;
            }
            return;
        }
        super.deleteRegid(iPushActionListener, getAppId(""), getAppKey(""));
    }

    @Override // com.vivo.push.a
    public void getRegId(IPushQueryActionListener iPushQueryActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushQueryActionListener != null) {
                iPushQueryActionListener.onFail(104);
                return;
            }
            return;
        }
        super.getRegId(iPushQueryActionListener);
    }

    public void initialize(PushConfig pushConfig) throws VivoPushException {
        if (pushConfig != null) {
            com.vivo.push.restructure.a.a().e().a(pushConfig);
            initialize();
            return;
        }
        throw new VivoPushException("initialize error config is null");
    }

    public boolean isPushSupport(int i) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            return false;
        }
        return com.vivo.push.restructure.a.a().g().a(i);
    }

    @Override // com.vivo.push.e.a
    public void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else {
            com.vivo.push.e.a aVar = this.mSyncProfileInfo;
            if (aVar != null) {
                aVar.queryProfileIds(iPushRequestCallback);
            }
        }
    }

    @Override // com.vivo.push.a
    public void querySubscribeState(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(104);
        }
        super.querySubscribeState(iPushActionListener);
    }

    public void turnOffPush(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
                return;
            }
            return;
        }
        m.a().c(iPushActionListener, getAppId(""), getAppKey(""));
    }

    public void turnOnPush(IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
                return;
            }
            return;
        }
        m.a().a(iPushActionListener, getAppId(""), getAppKey(""));
    }

    @Override // com.vivo.push.e.a
    public void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else {
            com.vivo.push.e.a aVar = this.mSyncProfileInfo;
            if (aVar != null) {
                aVar.addProfileId(str, iPushRequestCallback);
            }
        }
    }

    @Override // com.vivo.push.e.a
    public void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(104);
            }
        } else {
            com.vivo.push.e.a aVar = this.mSyncProfileInfo;
            if (aVar != null) {
                aVar.deleteProfileId(str, iPushRequestCallback);
            }
        }
    }

    public void isNotifyGuideDialogAllowed(Activity activity, IPushActionListener iPushActionListener) {
        if (iPushActionListener == null) {
            return;
        }
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            iPushActionListener.onStateChanged(104);
        } else {
            com.vivo.push.d.b.a().a(activity, iPushActionListener);
        }
    }

    public void showNotifyGuideDialog(Activity activity, IPushActionListener iPushActionListener) {
        if (iPushActionListener == null) {
            return;
        }
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            iPushActionListener.onStateChanged(104);
        } else {
            com.vivo.push.d.b.a().a(activity, iPushActionListener, SystemClock.elapsedRealtime());
        }
    }

    public void bindAlias(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else {
            checkParam(str);
            m.a().a(str, getAppId(""), getAppKey(""), iPushActionListener);
        }
    }

    public void delTopic(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            m.a().b(arrayList, getAppId(""), getAppKey(""), iPushActionListener);
        }
    }

    public void setTopic(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            m.a().a(arrayList, getAppId(""), getAppKey(""), iPushActionListener);
        }
    }

    public void unBindAlias(String str, IPushActionListener iPushActionListener) {
        if (!checkAgreePrivacyStatementAndInitSdk()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(104);
            }
        } else {
            checkParam(str);
            m.a().b(str, getAppId(""), getAppKey(""), iPushActionListener);
        }
    }
}
