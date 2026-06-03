package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.ss.android.ugc.bytex.taskmonitor.proxy.PThreadScheduledThreadPoolExecutorDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.push.ge;
import com.xiaomi.push.gi;
import com.xiaomi.push.gr;
import com.xiaomi.push.hd;
import com.xiaomi.push.service.az;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MiTinyDataClient {
    static {
        Covode.recordClassIndex(655282);
    }

    public static class a {
        private static volatile a a;

        /* renamed from: a, reason: collision with other field name */
        private Context f28a;

        /* renamed from: a, reason: collision with other field name */
        private Boolean f30a;

        /* renamed from: a, reason: collision with other field name */
        private String f31a;

        /* renamed from: a, reason: collision with other field name */
        private C0130a f29a = new C0130a();

        /* renamed from: a, reason: collision with other field name */
        private final ArrayList<gi> f32a = new ArrayList<>();

        static {
            Covode.recordClassIndex(655283);
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m74a() {
            if (this.f28a != null) {
                return true;
            }
            return false;
        }

        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a, reason: collision with other inner class name */
        public class C0130a {

            /* renamed from: a, reason: collision with other field name */
            private ScheduledFuture<?> f35a;

            /* renamed from: a, reason: collision with other field name */
            private ScheduledThreadPoolExecutor f36a = new PThreadScheduledThreadPoolExecutorDelegate(1, new DefaultThreadFactory("MiTinyDataClient$a$a"));

            /* renamed from: a, reason: collision with other field name */
            public final ArrayList<gi> f34a = new ArrayList<>();

            /* renamed from: a, reason: collision with other field name */
            private final Runnable f33a = new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C0130a.this.f34a.size() == 0) {
                        if (C0130a.this.f35a != null) {
                            C0130a.this.f35a.cancel(false);
                            C0130a.this.f35a = null;
                            return;
                        }
                        return;
                    }
                    C0130a.this.b();
                }
            };

            static {
                Covode.recordClassIndex(655284);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a() {
                if (this.f35a == null) {
                    this.f35a = this.f36a.scheduleAtFixedRate(this.f33a, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                gi remove = this.f34a.remove(0);
                for (hd hdVar : az.a(Arrays.asList(remove), a.this.f28a.getPackageName(), b.m79a(a.this.f28a).m80a(), 30720)) {
                    com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    u.a(a.this.f28a).a((u) hdVar, ge.Notification, true, (gr) null);
                }
            }

            public C0130a() {
            }

            public void a(final gi giVar) {
                this.f36a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C0130a.this.f34a.add(giVar);
                        C0130a.this.a();
                    }
                });
            }
        }

        public static a a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        private boolean b(Context context) {
            if (b.m79a(context).m80a() == null && !a(this.f28a)) {
                return true;
            }
            return false;
        }

        private void a(gi giVar) {
            synchronized (this.f32a) {
                if (!this.f32a.contains(giVar)) {
                    this.f32a.add(giVar);
                    if (this.f32a.size() > 100) {
                        this.f32a.remove(0);
                    }
                }
            }
        }

        private boolean b(gi giVar) {
            if (az.a(giVar, false)) {
                return false;
            }
            if (this.f30a.booleanValue()) {
                com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + giVar.d());
                u.a(this.f28a).a(giVar);
                return true;
            }
            this.f29a.a(giVar);
            return true;
        }

        private boolean a(Context context) {
            if (!u.a(context).m124a()) {
                return true;
            }
            try {
                PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), "com.xiaomi.xmsf", 4);
                if (INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_resource_PackageManagerAop_getPackageInfo == null) {
                    return false;
                }
                if (INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode >= 108) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        public void b(String str) {
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f32a) {
                arrayList.addAll(this.f32a);
                this.f32a.clear();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                m75a((gi) it2.next());
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m73a(Context context) {
            if (context == null) {
                com.xiaomi.channel.commonutils.logger.b.m54a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f28a = context;
            this.f30a = Boolean.valueOf(a(context));
            b("com.xiaomi.xmpushsdk.tinydataPending.init");
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                com.xiaomi.channel.commonutils.logger.b.m54a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
            } else {
                this.f31a = str;
                b("com.xiaomi.xmpushsdk.tinydataPending.channel");
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a3, code lost:
        
            com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient Pending " + r6.b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.channel");
         */
        /* renamed from: a, reason: collision with other method in class */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized boolean m75a(com.xiaomi.push.gi r6) {
            /*
                Method dump skipped, instructions count: 279
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiTinyDataClient.a.m75a(com.xiaomi.push.gi):boolean");
        }

        @Proxy("getPackageInfo")
        @TargetClass("android.content.pm.PackageManager")
        public static PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            if (x55.a.a()) {
                PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
                Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
                return INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
            }
            x55.b bVar = x55.b.a;
            PackageInfo f = bVar.f(packageName, i);
            if (f != null) {
                return f;
            }
            PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
            return INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
        }

        @Proxy("getPackageInfo")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
        public static PackageInfo INVOKEVIRTUAL_com_xiaomi_mipush_sdk_MiTinyDataClient$a_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
            if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
                return null;
            }
            if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
                LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
            }
            return packageManager.getPackageInfo(str, i);
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.m54a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().m73a(context);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, gi giVar) {
        com.xiaomi.channel.commonutils.logger.b.c("MiTinyDataClient.upload " + giVar.d());
        if (!a.a().m74a()) {
            a.a().m73a(context);
        }
        return a.a().m75a(giVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        gi giVar = new gi();
        giVar.d(str);
        giVar.c(str2);
        giVar.a(j);
        giVar.b(str3);
        return a.a().m75a(giVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        gi giVar = new gi();
        giVar.d(str);
        giVar.c(str2);
        giVar.a(j);
        giVar.b(str3);
        giVar.a(true);
        giVar.a("push_sdk_channel");
        return upload(context, giVar);
    }
}
