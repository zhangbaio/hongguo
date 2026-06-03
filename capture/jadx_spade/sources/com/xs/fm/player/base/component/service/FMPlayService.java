package com.xs.fm.player.base.component.service;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.media.MediaBrowserCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.media.MediaBrowserServiceCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.xs.fm.player.base.play.inter.AbsPlayListener;
import com.xs.fm.player.base.play.inter.IPlayManager;
import com.xs.fm.player.base.play.player.IPlayer;
import java.util.Collections;
import java.util.List;
import ko2.u;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import pk6.c;
import xo2.j;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class FMPlayService extends MediaBrowserServiceCompat {
    private static final bl6.a a;
    private static Context b;
    private static hk6.a c;
    private static final Handler d;
    private static final Runnable e;
    private static final boolean f;
    private static final int g;
    private static Boolean h;
    private static boolean i;
    private static final AbsPlayListener j;
    private static String k;
    private static volatile boolean l;
    public static final Companion m;

    public static final void u() {
        m.h();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return t(this, intent, i2, i3);
    }

    public static final class a extends AbsPlayListener {
        a() {
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onListDataChanged() {
            g();
        }

        private final void g() {
            Companion companion = FMPlayService.m;
            if (!Intrinsics.areEqual(companion.j(), Boolean.TRUE)) {
                companion.t();
            } else {
                companion.u(FMPlayService.g);
            }
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onItemChanged(String str, String str2) {
            g();
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onListChanged(pk6.b bVar, pk6.b bVar2) {
            g();
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onPlayStateChange(IPlayer iPlayer, int i) {
            g();
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void onUIStateChange(IPlayer iPlayer, int i) {
            g();
        }

        @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
        public void beforePlay(String str, String str2) {
            bl6.a aVar = FMPlayService.a;
            StringBuilder sb = new StringBuilder();
            sb.append("beforePlay  isFirstPlay=");
            Companion companion = FMPlayService.m;
            sb.append(companion.j());
            boolean z = false;
            aVar.d(sb.toString(), new Object[0]);
            IPlayManager B = il6.a.B();
            Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
            c currentPlayParam = B.getCurrentPlayParam();
            if (currentPlayParam != null && currentPlayParam.h) {
                if (companion.j() == null && FMPlayService.f) {
                    z = true;
                }
                companion.m(Boolean.valueOf(z));
            }
        }
    }

    public static final class Companion {
        static {
            Covode.recordClassIndex(655780);
        }

        private Companion() {
        }

        public final boolean i() {
            return FMPlayService.i;
        }

        public final Boolean j() {
            return FMPlayService.h;
        }

        private final void k() {
            hk6.a aVar = FMPlayService.c;
            if (aVar != null) {
                aVar.h();
            }
            s();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void t() {
            u(lk6.c.a.l.k0());
        }

        private final String f() {
            boolean z;
            String str = FMPlayService.k;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return "audio_notify_channel";
            }
            return FMPlayService.k;
        }

        private final int g() {
            int i;
            hk6.a aVar = FMPlayService.c;
            if (aVar != null) {
                i = aVar.f();
            } else {
                i = 0;
            }
            if (i > 0) {
                return i;
            }
            return 18;
        }

        static final class b implements Runnable {
            final /* synthetic */ Application a;

            b(Application application) {
                this.a = application;
            }

            @Override // java.lang.Runnable
            public final void run() {
                hk6.a aVar;
                try {
                    Intent intent = new Intent();
                    intent.setClassName(this.a, FMPlayService.class.getName());
                    intent.setAction("audio_service_control");
                    ContextCompat.startForegroundService(this.a, intent);
                } catch (Exception e) {
                    FMPlayService.a.b(e.getMessage(), new Object[0]);
                    lk6.b bVar = lk6.c.a;
                    if (bVar != null && (aVar = bVar.h) != null) {
                        aVar.ensureNotReachHere(e, e.getMessage());
                    }
                }
            }
        }

        static final class c implements Runnable {
            final /* synthetic */ Application a;

            c(Application application) {
                this.a = application;
            }

            @Override // java.lang.Runnable
            public final void run() {
                hk6.a aVar;
                try {
                    Intent intent = new Intent();
                    intent.setClassName(this.a, FMPlayService.class.getName());
                    intent.setAction("audio_service_control");
                    ContextCompat.startForegroundService(this.a, intent);
                } catch (Exception e) {
                    FMPlayService.a.b(e.getMessage(), new Object[0]);
                    lk6.b bVar = lk6.c.a;
                    if (bVar != null && (aVar = bVar.h) != null) {
                        aVar.ensureNotReachHere(e, e.getMessage());
                    }
                }
            }
        }

        static final class d implements Runnable {
            final /* synthetic */ Application a;

            d(Application application) {
                this.a = application;
            }

            @Override // java.lang.Runnable
            public final void run() {
                hk6.a aVar;
                try {
                    Intent intent = new Intent();
                    intent.setClassName(this.a, FMPlayService.class.getName());
                    intent.setAction("audio_service_control");
                    this.a.stopService(intent);
                } catch (Exception e) {
                    FMPlayService.a.b(e.getMessage(), new Object[0]);
                    lk6.b bVar = lk6.c.a;
                    if (bVar != null && (aVar = bVar.h) != null) {
                        aVar.ensureNotReachHere(e, e.getMessage());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q() {
            hk6.a aVar;
            if (FMPlayService.b == null) {
                return;
            }
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (aVar = bVar.h) != null && aVar.a()) {
                if (!i()) {
                    p();
                    return;
                } else {
                    k();
                    return;
                }
            }
            r();
        }

        public final void h() {
            Application application;
            lk6.b bVar = lk6.c.a;
            if (bVar == null || (application = bVar.b) == null) {
                return;
            }
            FMPlayService.b = application;
            hk6.a aVar = lk6.c.a.h;
            if (aVar == null) {
                return;
            }
            FMPlayService.c = aVar;
            FMPlayService.d.removeCallbacksAndMessages(null);
            hk6.a aVar2 = FMPlayService.c;
            if (aVar2 != null && !aVar2.i()) {
                o();
            }
        }

        public final void n() {
            if (FMPlayService.f) {
                FMPlayService.a.d("startServiceAndUpdateNotification: enableDelayService=true, updateWithPostDelay", new Object[0]);
                t();
            } else {
                FMPlayService.a.d("startServiceAndUpdateNotification: enableDelayService=false, tryStartServiceAndUpdateNotification", new Object[0]);
                q();
            }
        }

        public final void r() {
            Application application;
            FMPlayService.a.d("tryStopService()", new Object[0]);
            FMPlayService.d.removeCallbacksAndMessages(null);
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (application = bVar.b) != null) {
                new HandlerDelegate(Looper.getMainLooper()).post(new d(application));
            }
        }

        public final void o() {
            NotificationChannel notificationChannel;
            String str;
            if (FMPlayService.l) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                hk6.a aVar = FMPlayService.c;
                if (aVar != null) {
                    notificationChannel = aVar.c();
                } else {
                    notificationChannel = null;
                }
                if (notificationChannel == null || (str = notificationChannel.getId()) == null) {
                    str = "";
                }
                FMPlayService.k = str;
                Context context = FMPlayService.b;
                if (context != null) {
                    Object systemService = context.getSystemService("notification");
                    if (systemService != null) {
                        NotificationManager notificationManager = (NotificationManager) systemService;
                        if (notificationChannel != null) {
                            try {
                                notificationManager.createNotificationChannel(notificationChannel);
                            } catch (Throwable th) {
                                FMPlayService.a.b("UserControllerManager create channel error:" + th, new Object[0]);
                            }
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
                    }
                }
            }
            il6.a.B().addPlayListener(FMPlayService.j);
            FMPlayService.l = true;
        }

        public final void p() {
            Application application;
            hk6.a aVar;
            hk6.a aVar2 = lk6.c.a.h;
            if (aVar2 != null && aVar2.i() && !FMPlayService.l) {
                return;
            }
            hk6.a aVar3 = lk6.c.a.h;
            if (aVar3 != null && !aVar3.i()) {
                o();
            }
            boolean z = false;
            FMPlayService.a.d("tryStartService()", new Object[0]);
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (application = bVar.b) != null) {
                HandlerDelegate handlerDelegate = new HandlerDelegate(Looper.getMainLooper());
                lk6.b bVar2 = lk6.c.a;
                if (bVar2 != null && (aVar = bVar2.h) != null) {
                    z = aVar.d();
                }
                if (z) {
                    handlerDelegate.postAtFrontOfQueue(new b(application));
                } else {
                    handlerDelegate.post(new c(application));
                }
            }
        }

        public final void s() {
            Application application;
            kk6.a aVar;
            hk6.a aVar2;
            FMPlayService.a.d("updateNotification()", new Object[0]);
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (application = bVar.b) != null) {
                hk6.a aVar3 = FMPlayService.c;
                if (aVar3 != null) {
                    Companion companion = FMPlayService.m;
                    Notification g = aVar3.g(application, new NotificationCompat.Builder(application, companion.f()));
                    if (g != null) {
                        try {
                            NotificationManagerCompat.from(application).notify(companion.g(), g);
                        } catch (Throwable th) {
                            FMPlayService.a.b("UserControllerManager NotificationManagerCompat.notify error:" + th, new Object[0]);
                            lk6.b bVar2 = lk6.c.a;
                            if (bVar2 != null && (aVar2 = bVar2.h) != null) {
                                aVar2.ensureNotReachHere(th, th.getMessage());
                            }
                        }
                    }
                }
                lk6.b bVar3 = lk6.c.a;
                if (bVar3 != null && (aVar = bVar3.i) != null && aVar.c()) {
                    cl6.a.g.update(application);
                }
            }
        }

        static final class a implements Runnable {
            final /* synthetic */ Service a;
            final /* synthetic */ int b;
            final /* synthetic */ Notification c;

            a(Service service, int i, Notification notification) {
                this.a = service;
                this.b = i;
                this.c = notification;
            }

            private static List b(ActivityManager activityManager, int i) throws SecurityException {
                Result preInvoke = new HeliosApiHook().preInvoke(101302, "android/app/ActivityManager", "getRunningServices", activityManager, new Object[]{Integer.valueOf(i)}, "java.util.List", new ExtraInfo(false, "(I)Ljava/util/List;"));
                return preInvoke.isIntercept() ? (List) preInvoke.getReturnValue() : activityManager.getRunningServices(i);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0030 A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:3:0x0002, B:5:0x0009, B:6:0x0011, B:9:0x0017, B:11:0x001b, B:13:0x0024, B:18:0x0030, B:19:0x0036, B:21:0x003c, B:24:0x0059, B:37:0x0066, B:39:0x0071), top: B:2:0x0002 }] */
            /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    r9 = this;
                    r0 = 1
                    r1 = 0
                    android.content.Context r2 = com.xs.fm.player.base.component.service.FMPlayService.g()     // Catch: java.lang.Exception -> L80
                    r3 = 0
                    if (r2 == 0) goto L10
                    java.lang.String r4 = "activity"
                    java.lang.Object r2 = r2.getSystemService(r4)     // Catch: java.lang.Exception -> L80
                    goto L11
                L10:
                    r2 = r3
                L11:
                    boolean r4 = r2 instanceof android.app.ActivityManager     // Catch: java.lang.Exception -> L80
                    if (r4 != 0) goto L16
                    goto L17
                L16:
                    r3 = r2
                L17:
                    android.app.ActivityManager r3 = (android.app.ActivityManager) r3     // Catch: java.lang.Exception -> L80
                    if (r3 == 0) goto L97
                    r2 = 2147483647(0x7fffffff, float:NaN)
                    java.util.List r2 = a(r3, r2)     // Catch: java.lang.Exception -> L80
                    if (r2 == 0) goto L2d
                    boolean r3 = r2.isEmpty()     // Catch: java.lang.Exception -> L80
                    if (r3 == 0) goto L2b
                    goto L2d
                L2b:
                    r3 = 0
                    goto L2e
                L2d:
                    r3 = 1
                L2e:
                    if (r3 != 0) goto L97
                    java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L80
                    r3 = 0
                    r4 = 0
                L36:
                    boolean r5 = r2.hasNext()     // Catch: java.lang.Exception -> L80
                    if (r5 == 0) goto L62
                    java.lang.Object r5 = r2.next()     // Catch: java.lang.Exception -> L80
                    android.app.ActivityManager$RunningServiceInfo r5 = (android.app.ActivityManager.RunningServiceInfo) r5     // Catch: java.lang.Exception -> L80
                    java.lang.Class<com.xs.fm.player.base.component.service.FMPlayService> r6 = com.xs.fm.player.base.component.service.FMPlayService.class
                    java.lang.String r6 = r6.getName()     // Catch: java.lang.Exception -> L80
                    android.content.ComponentName r7 = r5.service     // Catch: java.lang.Exception -> L80
                    java.lang.String r8 = "serviceInfo.service"
                    kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r8)     // Catch: java.lang.Exception -> L80
                    java.lang.String r7 = r7.getClassName()     // Catch: java.lang.Exception -> L80
                    boolean r6 = r6.equals(r7)     // Catch: java.lang.Exception -> L80
                    if (r6 == 0) goto L36
                    boolean r3 = r5.foreground     // Catch: java.lang.Exception -> L80
                    if (r3 == 0) goto L60
                    r3 = 1
                    r4 = 1
                    goto L36
                L60:
                    r3 = 1
                    goto L36
                L62:
                    if (r3 == 0) goto L6f
                    if (r4 != 0) goto L6f
                    android.app.Service r2 = r9.a     // Catch: java.lang.Exception -> L80
                    int r4 = r9.b     // Catch: java.lang.Exception -> L80
                    android.app.Notification r5 = r9.c     // Catch: java.lang.Exception -> L80
                    r2.startForeground(r4, r5)     // Catch: java.lang.Exception -> L80
                L6f:
                    if (r3 != 0) goto L97
                    com.xs.fm.player.base.component.service.FMPlayService$Companion r2 = com.xs.fm.player.base.component.service.FMPlayService.m     // Catch: java.lang.Exception -> L80
                    r2.p()     // Catch: java.lang.Exception -> L80
                    android.app.Service r2 = r9.a     // Catch: java.lang.Exception -> L80
                    int r3 = r9.b     // Catch: java.lang.Exception -> L80
                    android.app.Notification r4 = r9.c     // Catch: java.lang.Exception -> L80
                    r2.startForeground(r3, r4)     // Catch: java.lang.Exception -> L80
                    goto L97
                L80:
                    r2 = move-exception
                    bl6.a r3 = com.xs.fm.player.base.component.service.FMPlayService.h()
                    r4 = 2
                    java.lang.Object[] r4 = new java.lang.Object[r4]
                    java.lang.String r5 = "%s "
                    r4[r1] = r5
                    java.lang.String r1 = r2.getMessage()
                    r4[r0] = r1
                    java.lang.String r0 = "checkServiceIsExistOrForeground"
                    r3.b(r0, r4)
                L97:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xs.fm.player.base.component.service.FMPlayService.Companion.a.run():void");
            }

            @Proxy("getRunningServices")
            @TargetClass("android.app.ActivityManager")
            public static List a(ActivityManager activityManager, int i) throws SecurityException {
                if (PrivacyMgr.inst().hasConfirmedAndNotBasic()) {
                    return b(activityManager, i);
                }
                return Collections.emptyList();
            }
        }

        public final void m(Boolean bool) {
            FMPlayService.h = bool;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u(int i) {
            FMPlayService.a.d("updateWithPostDelayWithTime  isFirstPlay=" + j() + ", postDelay=" + i, new Object[0]);
            if (i == 0) {
                q();
            } else if (i > 0) {
                FMPlayService.d.removeCallbacksAndMessages(null);
                FMPlayService.d.postDelayed(FMPlayService.e, i);
            }
        }

        public final void d(Context context) {
            hk6.a aVar;
            FMPlayService.d.removeCallbacksAndMessages(null);
            if (context != null) {
                try {
                    NotificationManagerCompat.from(context).cancel(FMPlayService.m.g());
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    FMPlayService.a.b("UserControllerManager NotificationManagerCompat.cancel error:" + th, new Object[0]);
                    lk6.b bVar = lk6.c.a;
                    if (bVar != null && (aVar = bVar.h) != null) {
                        aVar.ensureNotReachHere(th, th.getMessage());
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }

        public final void l(Service service) {
            Notification notification;
            hk6.a aVar = FMPlayService.c;
            if (aVar != null) {
                notification = aVar.g(FMPlayService.b, new NotificationCompat.Builder(service, f()));
            } else {
                notification = null;
            }
            if (notification != null) {
                service.startForeground(g(), notification);
            } else {
                FMPlayService.a.b("UserControllerManager serviceStartForeground create default Notification", new Object[0]);
                notification = new NotificationCompat.Builder(service, f()).setContentText("音频播放中").setAutoCancel(false).build();
                service.startForeground(g(), notification);
            }
            e(service, g(), notification);
        }

        private final void e(Service service, int i, Notification notification) {
            hk6.a aVar;
            lk6.b bVar;
            nk6.b bVar2;
            lk6.b bVar3 = lk6.c.a;
            if (bVar3 != null && (aVar = bVar3.h) != null && aVar.a() && (bVar = lk6.c.a) != null && (bVar2 = bVar.l) != null && bVar2.Y()) {
                FMPlayService.d.postDelayed(new a(service, i, notification), 5000L);
            }
        }
    }

    static final class b implements Runnable {
        public static final b a = new b();

        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            FMPlayService.m.q();
        }
    }

    private final void s() {
        if (b == null) {
            vl6.a a2 = vl6.a.a();
            Intrinsics.checkExpressionValueIsNotNull(a2, "FMPlayConfigurationManager.getInstance()");
            b = a2.getContext();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        a.d("onCreate()", new Object[0]);
        super.onCreate();
        s();
        if (b != null) {
            i = true;
            if (!f) {
                m.l(this);
            }
            cl6.a.g.f(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        a.d("onDestroy()", new Object[0]);
        super/*android.app.Service*/.onDestroy();
        d.removeCallbacksAndMessages(null);
        if (b != null) {
            i = false;
            stopForeground(true);
            m.d(this);
        }
    }

    static {
        boolean z;
        int i2;
        Covode.recordClassIndex(655779);
        m = new Companion(null);
        a = new bl6.a("FMSDKPlayerTrace-FMPlayService");
        d = new HandlerDelegate(Looper.getMainLooper());
        e = b.a;
        hk6.a aVar = lk6.c.a.h;
        if (aVar != null) {
            z = aVar.b();
        } else {
            z = false;
        }
        f = z;
        hk6.a aVar2 = lk6.c.a.h;
        if (aVar2 != null) {
            i2 = aVar2.e();
        } else {
            i2 = 50;
        }
        g = i2;
        j = new a();
        k = "";
    }

    public IBinder onBind(Intent intent) {
        a.d("onBind", new Object[0]);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onUnbind(Intent intent) {
        a.d("onUnbind", new Object[0]);
        return super/*android.app.Service*/.onUnbind(intent);
    }

    public void onLoadChildren(String str, MediaBrowserServiceCompat.l<List<MediaBrowserCompat.MediaItem>> lVar) {
        a.d("onLoadChildren()", new Object[0]);
        if (b != null) {
            lVar.e((Object) null);
        }
    }

    public MediaBrowserServiceCompat.e onGetRoot(String str, int i2, Bundle bundle) {
        a.d("onGetRoot()", new Object[0]);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int a(Intent intent, int i2, int i3) {
        a.d("onStartCommand", new Object[0]);
        s();
        if (b != null) {
            i = true;
            Companion companion = m;
            companion.l(this);
            if (!f) {
                companion.n();
                return 2;
            }
            return 2;
        }
        return 2;
    }

    @TargetClass(scope = Scope.ALL, value = "android.app.Service")
    @Insert(mayCreateSuper = true, value = "onStartCommand")
    public static int t(FMPlayService fMPlayService, Intent intent, int i2, int i3) {
        int a2 = fMPlayService.a(intent, i2, i3);
        boolean a3 = u.a(a2, fMPlayService);
        if (a3) {
            String name = FMPlayService.class.getName();
            j.a("intercept_sticky_service", "class_name", name);
            LogWrapper.info("ServiceAop", "intercept service onStartCommand " + name, new Object[0]);
        }
        if (a3) {
            return 2;
        }
        return a2;
    }
}
