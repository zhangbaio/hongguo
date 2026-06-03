package com.vv;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.service.manager.permission.boot.AlertRequestParam;
import com.bytedance.covode.number.Covode;
import com.bytedance.push.third.PushChannelHelper;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;
import com.vivo.push.PushConfig;
import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.VivoPushException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;
import v01.n;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VvPushAdapter extends com.bytedance.push.third.b implements com.bytedance.push.third.c {
    private static int VV_PUSH;
    private static boolean hasSendValidToken;
    private static boolean sHasRegistered;
    private final Handler mHandler = new HandlerDelegate(Looper.getMainLooper());
    private volatile boolean appStatusHasChanged = false;
    private boolean hasShown = false;
    private final long DIALOG_SHOW_TIME_OUT = 2000;
    private final String SUCCESS = "success";

    private interface j {
        void a(boolean z);
    }

    public int getPushType() {
        return 11;
    }

    public boolean requestRemoveVoipNotification(Context context, int i2) {
        return false;
    }

    public void trackPush(Context context, int i2, Object obj) {
    }

    public static boolean hasTryRegistered() {
        return sHasRegistered;
    }

    class a implements IPushActionListener {
        final /* synthetic */ int a;
        final /* synthetic */ Context b;

        /* renamed from: com.vv.VvPushAdapter$a$a, reason: collision with other inner class name */
        class C0128a implements IPushQueryActionListener {

            /* renamed from: com.vv.VvPushAdapter$a$a$a, reason: collision with other inner class name */
            class RunnableC0129a implements Runnable {
                final /* synthetic */ String a;

                @Override // java.lang.Runnable
                public void run() {
                    VvPushAdapter.sendToken(a.this.b, this.a);
                }

                RunnableC0129a(String str) {
                    this.a = str;
                }
            }

            C0128a() {
            }

            @Override // com.vivo.push.listener.IPushRequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onFail(Integer num) {
                com.bytedance.push.i.v().e("VivoPush", "onFail,error code: " + num);
            }

            @Override // com.vivo.push.listener.IPushRequestListener
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str) {
                if (!TextUtils.isEmpty(str)) {
                    com.bytedance.push.i.v().i("VivoPush", "success get token");
                    com.bytedance.push.i.v().d("VivoPush", "token = " + str);
                    VvPushAdapter.this.mHandler.post(new RunnableC0129a(str));
                }
            }
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i) {
            if (i != 0) {
                com.bytedance.push.i.w().j(this.a, 104, String.valueOf(i), "vivo channel register failed");
                com.bytedance.push.i.v().e("VivoPush", "open push error [" + i + "] ，please check the official documentation of the vendor");
            } else {
                com.bytedance.push.i.v().i("VivoPush", "open push success");
            }
            PushClient.getInstance(this.b).getRegId(new C0128a());
        }

        a(int i, Context context) {
            this.a = i;
            this.b = context;
        }
    }

    static {
        Covode.recordClassIndex(655226);
        VV_PUSH = -1;
        sHasRegistered = false;
        hasSendValidToken = false;
    }

    class d implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ Boolean[] c;
        final /* synthetic */ CountDownLatch d;
        final /* synthetic */ String[] e;

        @Override // java.lang.Runnable
        public void run() {
            PushClient.getInstance(this.a).addProfileId(this.b, new a());
        }

        class a implements IPushRequestCallback<Integer> {
            a() {
            }

            @Override // com.vivo.push.restructure.request.IPushRequestCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Integer num) {
                com.bytedance.push.i.v().d("VivoPush", "[setProfileId]success set profile id:" + num);
                d dVar = d.this;
                dVar.c[0] = Boolean.TRUE;
                dVar.d.countDown();
            }

            @Override // com.vivo.push.restructure.request.IPushRequestCallback
            public void onError(int i) {
                d.this.c[0] = Boolean.FALSE;
                com.bytedance.push.i.v().e("VivoPush", "[setProfileId]failed set profile id:" + i);
                d.this.e[0] = "vv error:" + i;
                d.this.d.countDown();
            }
        }

        d(Context context, String str, Boolean[] boolArr, CountDownLatch countDownLatch, String[] strArr) {
            this.a = context;
            this.b = str;
            this.c = boolArr;
            this.d = countDownLatch;
            this.e = strArr;
        }
    }

    public static int getVvPush() {
        if (VV_PUSH == -1) {
            VV_PUSH = PushChannelHelper.v(je6.b.a()).e(VvPushAdapter.class.getName());
        }
        return VV_PUSH;
    }

    class h implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ f90.j c;

        @Override // java.lang.Runnable
        public void run() {
            v01.h.d("VivoPush", "backup detect dialog show result now, hasShown:" + VvPushAdapter.this.hasShown + " appStatusHasChanged:" + VvPushAdapter.this.appStatusHasChanged);
            if (VvPushAdapter.this.hasShown) {
                if (VvPushAdapter.this.appStatusHasChanged) {
                    VvPushAdapter.this.onGuideRequestResult(this.a, this.b, "vv", true, "success", this.c);
                } else {
                    VvPushAdapter.this.onGuideRequestResult(this.a, this.b, "vv", false, "time out", this.c);
                }
            }
            VvPushAdapter.this.hasShown = false;
        }

        h(String str, int i, f90.j jVar) {
            this.a = str;
            this.b = i;
            this.c = jVar;
        }
    }

    private Boolean isPushServiceAvailable() {
        try {
            PackageInfo INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_resource_PackageManagerAop_getPackageInfo(je6.b.a().getPackageManager(), "com.vivo.pushservice", 0);
            v01.h.h("VivoPush", "com.vivo.pushservice versionName: " + INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionName);
            if (INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode >= 5380000) {
                v01.h.h("VivoPush", "com.vivo.pushservice versionCode: " + INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode + " is available!");
                return Boolean.TRUE;
            }
            v01.h.h("VivoPush", "com.vivo.pushservice versionCode: " + INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode + " version not supported!");
            return Boolean.FALSE;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private String requestNotificationInternal() {
        com.bytedance.push.i.v().d("VivoPush", "requestNotificationInternal");
        Application a2 = je6.b.a();
        try {
            IBinder iBinder = (IBinder) l3.a.q("android.os.ServiceManager").getDeclaredMethod("getService", String.class).invoke(null, "notification");
            if (iBinder == null) {
                com.bytedance.push.i.v().e("VivoPush", "get service failed.");
                return "notification service is null";
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            iBinder.transact(1598968902, obtain, obtain2, 0);
            String readString = obtain2.readString();
            if (readString != null && !readString.equals("")) {
                Object invoke = l3.a.q(readString + "$Stub").getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
                if (invoke != null) {
                    invoke.getClass().getDeclaredMethod("requestNotificationPermission", String.class).invoke(invoke, a2.getPackageName());
                    return "success";
                }
                return "asInterface is null";
            }
            return "readString is null";
        } catch (NoSuchMethodException e2) {
            return "not support device:" + e2.getLocalizedMessage();
        } catch (Throwable th) {
            v01.h.i("VivoPush", "requestNotificationInternal error ", th);
            return "exception:" + th.getLocalizedMessage();
        }
    }

    class f implements j {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ f90.j c;

        class a implements com.vv.a {
            a() {
            }

            @Override // com.vv.a
            public void onNotifyGuideDialogResult(int i) {
                com.bytedance.push.i.v().i("VivoPush", "onNotifyGuideDialogResult: message = " + i);
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                f fVar = f.this;
                VvPushAdapter.this.onUserClickResult(fVar.a, z, fVar.c);
            }
        }

        @Override // com.vv.VvPushAdapter.j
        public void a(boolean z) {
            if (z) {
                v01.h.d("VivoPush", "requestNotificationOfficial show success");
                VvPushAdapter.this.onGuideRequestResult(this.a, this.b, "vv", true, "success", this.c);
                com.vv.b.a().a = new a();
                return;
            }
            v01.h.d("VivoPush", "requestNotificationOfficial show failed");
            VvPushAdapter.this.onGuideRequestResult(this.a, this.b, "vv", false, "failed", this.c);
            com.vv.b.a().a = null;
        }

        f(String str, int i, f90.j jVar) {
            this.a = str;
            this.b = i;
            this.c = jVar;
        }
    }

    class i implements IPushActionListener {
        final /* synthetic */ Context a;
        final /* synthetic */ Activity b;
        final /* synthetic */ j c;

        class a implements IPushActionListener {
            a() {
            }

            @Override // com.vivo.push.IPushActionListener
            public void onStateChanged(int i) {
                if (i == 0) {
                    j jVar = i.this.c;
                    if (jVar != null) {
                        jVar.a(true);
                        return;
                    }
                    return;
                }
                v01.h.h("VivoPush", "NotifyGuideDialog show failed");
                j jVar2 = i.this.c;
                if (jVar2 != null) {
                    jVar2.a(false);
                }
            }
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i) {
            if (i == 0) {
                PushClient.getInstance(this.a).showNotifyGuideDialog(this.b, new a());
                return;
            }
            v01.h.h("VivoPush", "NotifyGuideDialog is not allowed: " + i);
            j jVar = this.c;
            if (jVar != null) {
                jVar.a(false);
            }
        }

        i(Context context, Activity activity, j jVar) {
            this.a = context;
            this.b = activity;
            this.c = jVar;
        }
    }

    class b implements IPushActionListener {
        b() {
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i) {
            v01.h.d("VivoPush", "onStateChanged() called with: i = [" + i + "]");
        }
    }

    class c implements IPushActionListener {
        c() {
        }

        @Override // com.vivo.push.IPushActionListener
        public void onStateChanged(int i) {
            v01.h.d("VivoPush", "onStateChanged() called with: i = [" + i + "]");
        }
    }

    class e implements IPushRequestCallback<Integer> {
        final /* synthetic */ Boolean[] a;
        final /* synthetic */ CountDownLatch b;
        final /* synthetic */ String[] c;

        @Override // com.vivo.push.restructure.request.IPushRequestCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Integer num) {
            com.bytedance.push.i.v().d("VivoPush", "[deleteProfileId]success delete profile id:" + num);
            this.a[0] = Boolean.TRUE;
            this.b.countDown();
        }

        @Override // com.vivo.push.restructure.request.IPushRequestCallback
        public void onError(int i) {
            this.a[0] = Boolean.FALSE;
            com.bytedance.push.i.v().d("VivoPush", "[deleteProfileId]failed set profile id:" + i);
            this.c[0] = "vv error:" + i;
            this.b.countDown();
        }

        e(Boolean[] boolArr, CountDownLatch countDownLatch, String[] strArr) {
            this.a = boolArr;
            this.b = countDownLatch;
            this.c = strArr;
        }
    }

    private void requestNotificationOfficial(j jVar) {
        com.bytedance.push.i.v().d("VivoPush", "requestNotificationOfficial");
        Application a2 = je6.b.a();
        try {
            Activity topActivity = e90.b.e().getTopActivity();
            PushClient.getInstance(a2).isNotifyGuideDialogAllowed(topActivity, new i(a2, topActivity, jVar));
        } catch (Exception e2) {
            v01.h.i("VivoPush", "requestNotificationOfficial error ", e2);
            if (jVar != null) {
                jVar.a(false);
            }
        }
    }

    public boolean isPushAvailable(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23 && n.a() && PushClient.getInstance(context.getApplicationContext()).isSupport()) {
            return true;
        }
        return false;
    }

    public void unregisterPush(Context context, int i2) {
        try {
            PushClient.getInstance(context).turnOffPush(new c());
            com.bytedance.push.i.v().i("VivoPush", "unregisterPush");
        } catch (Throwable unused) {
        }
    }

    public boolean checkThirdPushConfig(String str, Context context) throws Exception {
        try {
            PushClient.getInstance(context).checkManifest();
            return true;
        } catch (VivoPushException e2) {
            v01.h.h(str, "VivoPush Errcode = " + e2.getCode() + " " + e2.getMessage());
            e2.printStackTrace();
            return false;
        }
    }

    public String isBusinessAlertDialogAvailable(Context context, boolean z) {
        if (!isPushAvailable(context, VV_PUSH)) {
            v01.h.k("VivoPush", "[isBusinessAlertDialogAvailable]return false because push is not available");
            return "push is not available";
        }
        if (!com.ss.android.pushmanager.setting.b.g().l().V0()) {
            v01.h.k("VivoPush", "[isBusinessAlertDialogAvailable]return false because enableVvBusinessNotificationDialog is false");
            return "enableVvBusinessNotificationDialog is false";
        }
        v01.h.k("VivoPush", "[isBusinessAlertDialogAvailable]return true");
        return "1";
    }

    class g implements Observer {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ f90.j c;
        final /* synthetic */ Context d;

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            v01.h.d("VivoPush", "app status changed,isInBackGround:" + booleanValue + " appStatusHasChange：" + VvPushAdapter.this.appStatusHasChanged);
            if (booleanValue) {
                VvPushAdapter.this.appStatusHasChanged = true;
                if (VvPushAdapter.this.hasShown) {
                    VvPushAdapter.this.onGuideRequestResult(this.a, this.b, "vv", true, "success", this.c);
                }
            }
            if (!booleanValue && VvPushAdapter.this.appStatusHasChanged) {
                if (ke6.g.h(this.d) == ke6.g.n) {
                    VvPushAdapter.this.onUserClickResult(this.a, true, this.c);
                } else {
                    VvPushAdapter.this.onUserClickResult(this.a, false, this.c);
                }
                yy0.f.c().deleteObserver(this);
            }
        }

        g(String str, int i, f90.j jVar, Context context) {
            this.a = str;
            this.b = i;
            this.c = jVar;
            this.d = context;
        }
    }

    public static void sendToken(Context context, String str) {
        if (context == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            v01.h.d("VivoPush", "[sendToken]hasSendValidToken:" + hasSendValidToken);
            if (!hasSendValidToken) {
                hasSendValidToken = true;
                com.bytedance.push.i.z().c(context, getVvPush(), str);
                return;
            }
            return;
        }
        if (com.bytedance.push.i.z().isMainProcess(context)) {
            com.bytedance.push.i.w().j(getVvPush(), 102, "0", "token is empty");
        }
    }

    public void registerPush(Context context, int i2) {
        try {
            com.bytedance.push.i.v().i("VivoPush", "registerVivoPush");
            if (com.bytedance.push.i.v().debug()) {
                PushClient.getInstance(context).checkManifest();
            }
            sHasRegistered = true;
            PushClient.getInstance(context.getApplicationContext()).initialize(new PushConfig.Builder().agreePrivacyStatement(true).build());
            PushClient.getInstance(context).turnOnPush(new a(i2, context));
        } catch (Exception e2) {
            com.bytedance.push.i.v().e("VivoPush", "error when register vv push ", e2);
            e2.printStackTrace();
        }
    }

    public boolean deleteProfileId(Context context, String str) {
        int i2;
        String localizedMessage;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            int isSupportSyncProfileInfo = PushClient.getInstance(context).isSupportSyncProfileInfo();
            com.bytedance.push.i.v().i("VivoPush", "[deleteProfileId]supportProfile:" + isSupportSyncProfileInfo + " profileId:" + str);
            String str2 = null;
            if (isSupportSyncProfileInfo == 0) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                Boolean[] boolArr = {null};
                String[] strArr = {""};
                PushClient.getInstance(context).deleteProfileId(str, new e(boolArr, countDownLatch, strArr));
                try {
                    countDownLatch.await(10000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                Boolean bool = boolArr[0];
                if (bool != null) {
                    if (bool.booleanValue()) {
                        i2 = 1;
                    } else {
                        v01.h.d("VivoPush", "error msg is :" + strArr[0]);
                        i2 = 6;
                        str2 = strArr[0];
                    }
                } else {
                    i2 = 4;
                }
            } else {
                i2 = 3;
            }
            localizedMessage = str2;
        } catch (Throwable th) {
            i2 = 5;
            localizedMessage = th.getLocalizedMessage();
        }
        onDeleteProfileIdResult(getVvPush(), currentTimeMillis, i2, localizedMessage);
        if (i2 != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean setProfileId(android.content.Context r19, java.lang.String r20) {
        /*
            r18 = this;
            java.lang.String r1 = "VivoPush"
            long r4 = java.lang.System.currentTimeMillis()
            r8 = 0
            r9 = 1
            com.vivo.push.PushClient r0 = com.vivo.push.PushClient.getInstance(r19)     // Catch: java.lang.Throwable -> La6
            int r0 = r0.isSupportSyncProfileInfo()     // Catch: java.lang.Throwable -> La6
            ez0.b r2 = com.bytedance.push.i.v()     // Catch: java.lang.Throwable -> La6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6
            r3.<init>()     // Catch: java.lang.Throwable -> La6
            java.lang.String r6 = "[setProfileId]supportProfile:"
            r3.append(r6)     // Catch: java.lang.Throwable -> La6
            r3.append(r0)     // Catch: java.lang.Throwable -> La6
            java.lang.String r6 = " profileId len:"
            r3.append(r6)     // Catch: java.lang.Throwable -> La6
            int r6 = r20.length()     // Catch: java.lang.Throwable -> La6
            r3.append(r6)     // Catch: java.lang.Throwable -> La6
            java.lang.String r6 = " profileId："
            r3.append(r6)     // Catch: java.lang.Throwable -> La6
            r6 = r20
            r3.append(r6)     // Catch: java.lang.Throwable -> La6
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> La6
            r2.i(r1, r3)     // Catch: java.lang.Throwable -> La6
            r2 = 0
            if (r0 != 0) goto L9f
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch     // Catch: java.lang.Throwable -> La6
            r0.<init>(r9)     // Catch: java.lang.Throwable -> La6
            java.lang.Boolean[] r3 = new java.lang.Boolean[r9]     // Catch: java.lang.Throwable -> La6
            r3[r8] = r2     // Catch: java.lang.Throwable -> La6
            java.lang.String r7 = ""
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch: java.lang.Throwable -> La6
            je6.e r15 = je6.e.d()     // Catch: java.lang.Throwable -> La6
            com.vv.VvPushAdapter$d r14 = new com.vv.VvPushAdapter$d     // Catch: java.lang.Throwable -> La6
            r10 = r14
            r11 = r18
            r12 = r19
            r13 = r20
            r6 = r14
            r14 = r3
            r2 = r15
            r15 = r0
            r16 = r7
            r10.<init>(r12, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> La6
            r2.e(r6)     // Catch: java.lang.Throwable -> La6
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.InterruptedException -> L71 java.lang.Throwable -> La6
            r10 = 10000(0x2710, double:4.9407E-320)
            r0.await(r10, r2)     // Catch: java.lang.InterruptedException -> L71 java.lang.Throwable -> La6
            goto L75
        L71:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> La6
        L75:
            r0 = r3[r8]     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto L9d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto L81
            r2 = 1
            goto La0
        L81:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6
            r0.<init>()     // Catch: java.lang.Throwable -> La6
            java.lang.String r2 = "error msg is :"
            r0.append(r2)     // Catch: java.lang.Throwable -> La6
            r2 = r7[r8]     // Catch: java.lang.Throwable -> La6
            r0.append(r2)     // Catch: java.lang.Throwable -> La6
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La6
            v01.h.d(r1, r0)     // Catch: java.lang.Throwable -> La6
            r0 = r7[r8]     // Catch: java.lang.Throwable -> La6
            r2 = 6
            r17 = r0
            goto La2
        L9d:
            r2 = 4
            goto La0
        L9f:
            r2 = 3
        La0:
            r17 = 0
        La2:
            r0 = r2
            r7 = r17
            goto Lae
        La6:
            r0 = move-exception
            java.lang.String r0 = r0.getLocalizedMessage()
            r2 = 5
            r7 = r0
            r0 = 5
        Lae:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "onSetProfileIdResult,resultStatus:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = " extra:"
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            v01.h.d(r1, r2)
            int r3 = getVvPush()
            r2 = r18
            r6 = r0
            r2.onSetProfileIdResult(r3, r4, r6, r7)
            if (r0 != r9) goto Ld7
            r8 = 1
        Ld7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vv.VvPushAdapter.setProfileId(android.content.Context, java.lang.String):boolean");
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i2);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f2 = bVar.f(packageName, i2);
        if (f2 != null) {
            return f2;
        }
        PackageInfo INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i2);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i2, INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUserClickResult(String str, boolean z, f90.j jVar) {
        v01.h.k("VivoPush", "on request vv notification permission result,report click event,hasAgree:" + z);
        onClickResult(str, getVvPush(), "vv", z, "", 0, (JSONObject) null, jVar);
    }

    private void setComponentStatus(Context context, Class cls, boolean z) {
        int i2;
        ComponentName componentName = new ComponentName(context, (Class<?>) cls);
        com.bytedance.push.i.v().i("VivoPush", "set " + cls.getName() + " to:" + z);
        PackageManager packageManager = context.getPackageManager();
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        try {
            packageManager.setComponentEnabledSetting(componentName, i2, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setAlias(Context context, String str, int i2) {
        try {
            com.bytedance.push.i.v().i("VivoPush", "setAlias alias = " + str);
            PushClient.getInstance(context).bindAlias(str, new b());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_vv_VvPushAdapter_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i2) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i2);
    }

    private void requestNotificationHook(String str, int i2, int i3, f90.j jVar) {
        Application a2 = je6.b.a();
        if (this.hasShown) {
            v01.h.h("VivoPush", "can't requestNotificationPermission because cur has showing");
        }
        this.hasShown = true;
        this.appStatusHasChanged = false;
        ((com.bytedance.push.third.b) this).hasCallbackShowResult = false;
        yy0.f.c().addObserver(new g(str, i2, jVar, a2));
        String requestNotificationInternal = requestNotificationInternal();
        if (!TextUtils.equals(requestNotificationInternal, "success")) {
            onGuideRequestResult(str, i2, "vv", false, requestNotificationInternal, jVar);
            this.hasShown = false;
        } else {
            v01.h.d("VivoPush", "backup detect dialog show result after 2000");
            je6.e.d().f(new h(str, i2, jVar), 2000L);
        }
    }

    public synchronized boolean requestNotificationPermission(String str, int i2, int i3, AlertRequestParam alertRequestParam, f90.j jVar) {
        com.bytedance.push.i.v().d("VivoPush", "[requestNotificationPermission]");
        if (i2 != getVvPush()) {
            v01.h.h("VivoPush", "invalid push_type:" + i2);
            onGuideRequestResult(str, i2, "vv", false, "invalid push_type:" + i2, jVar);
            return false;
        }
        if (ke6.g.h(je6.b.a()) == 1) {
            v01.h.h("VivoPush", "cur notification are enabled,needn't request");
            onGuideRequestResult(str, i2, "vv", false, "cur notification are enabled,needn't request", jVar);
            return false;
        }
        if (e90.b.e().getTopActivity() == null) {
            v01.h.h("VivoPush", "can't requestNotificationPermission on vv device because topActivity is null");
            onGuideRequestResult(str, i2, "vv", false, "topActivity is null,app is not in the foreground!", jVar);
            return false;
        }
        ((com.bytedance.push.third.b) this).hasCallbackShowResult = false;
        ((com.bytedance.push.third.b) this).hasCallbackClickResult = false;
        ((com.bytedance.push.third.b) this).mAlertRequestParam = alertRequestParam;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30 && i4 <= 32) {
            requestNotificationHook(str, i2, i3, jVar);
        } else if (i4 >= 28 && isPushServiceAvailable().booleanValue()) {
            requestNotificationOfficial(new f(str, i2, jVar));
        }
        return true;
    }
}
