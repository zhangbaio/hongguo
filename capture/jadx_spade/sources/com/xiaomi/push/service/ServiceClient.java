package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.app.launch.task.c3;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.NsPushService;
import com.dragon.read.util.DebugManager;
import com.ss.android.common.util.ToolUtils;
import com.xiaomi.push.dx;
import com.xiaomi.push.fk;
import com.xiaomi.push.fl;
import com.xiaomi.push.fm;
import com.xiaomi.push.fp;
import com.xiaomi.push.fw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.apache.http.NameValuePair;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ServiceClient {
    private static long a;

    /* renamed from: a, reason: collision with other field name */
    private static ServiceClient f857a;

    /* renamed from: a, reason: collision with other field name */
    private static String f858a;
    private static String b;

    /* renamed from: a, reason: collision with other field name */
    private Context f860a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f863a;

    /* renamed from: b, reason: collision with other field name */
    private Messenger f864b;

    /* renamed from: a, reason: collision with other field name */
    private Messenger f861a = null;

    /* renamed from: a, reason: collision with other field name */
    private final BroadcastReceiver f859a = new BroadcastReceiver() { // from class: com.xiaomi.push.service.ServiceClient.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.xiaomi.push.at.m154a();
        }
    };

    /* renamed from: a, reason: collision with other field name */
    private List<Message> f862a = new ArrayList();

    /* renamed from: b, reason: collision with other field name */
    private boolean f865b = false;

    public static String getSession() {
        return f858a;
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f863a;
    }

    private void a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(an.s, str);
        intent.putExtra(an.v, str2);
        intent.putExtra(an.z, str3);
        intent.putExtra(an.B, str5);
        intent.putExtra(an.A, str4);
        intent.putExtra(an.C, z);
        intent.putExtra(an.J, f858a);
        intent.putExtra(an.N, this.f861a);
        if (map != null && map.size() > 0) {
            String a2 = a(map);
            if (!TextUtils.isEmpty(a2)) {
                intent.putExtra(an.D, a2);
            }
        }
        if (map2 == null || map2.size() <= 0) {
            return;
        }
        String a3 = a(map2);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        intent.putExtra(an.E, a3);
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m649a() {
        if (com.xiaomi.push.w.f1039a) {
            return false;
        }
        try {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_resource_PackageManagerAop_getPackageInfo(this.f860a.getPackageManager(), "com.xiaomi.xmsf", 4);
            if (INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_resource_PackageManagerAop_getPackageInfo == null) {
                return false;
            }
            return INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_resource_PackageManagerAop_getPackageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private synchronized void m648a(Intent intent) {
        if (this.f865b) {
            Message a2 = a(intent);
            if (this.f862a.size() >= 50) {
                this.f862a.remove(0);
            }
            this.f862a.add(a2);
            return;
        }
        if (this.f864b == null) {
            INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_aop_ContextAop_bindService(this.f860a, intent, new ServiceConnection() { // from class: com.xiaomi.push.service.ServiceClient.2
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ServiceClient.this.f864b = null;
                    ServiceClient.this.f865b = false;
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (ServiceClient.this) {
                        ServiceClient.this.f864b = new Messenger(iBinder);
                        ServiceClient.this.f865b = false;
                        Iterator it2 = ServiceClient.this.f862a.iterator();
                        while (it2.hasNext()) {
                            try {
                                ServiceClient.this.f864b.send((Message) it2.next());
                            } catch (RemoteException e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                            }
                        }
                        ServiceClient.this.f862a.clear();
                    }
                }
            }, 1);
            this.f865b = true;
            this.f862a.clear();
            this.f862a.add(a(intent));
        } else {
            try {
                this.f864b.send(a(intent));
            } catch (RemoteException unused) {
                this.f864b = null;
                this.f865b = false;
            }
        }
    }

    public void checkAlive() {
        Intent a2 = a();
        a2.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(a2);
    }

    public boolean closeChannel() {
        Intent a2 = a();
        a2.setAction(an.i);
        return startServiceSafely(a2);
    }

    /* renamed from: a, reason: collision with other method in class */
    private String m645a() {
        try {
            if (INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_resource_PackageManagerAop_getPackageInfo(this.f860a.getPackageManager(), "com.xiaomi.xmsf", 4).versionCode >= 106) {
                return "com.xiaomi.push.service.XMPushService";
            }
            return "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    private void b() {
        this.f860a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f860a, (Class<?>) XMPushService.class), 1, 1);
    }

    static {
        Covode.recordClassIndex(655631);
        f858a = null;
        b = fw.a(5) + "-";
        a = 0L;
    }

    private Intent a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m645a());
            intent.putExtra(an.F, this.f860a.getPackageName());
            m647a();
            return intent;
        }
        Intent intent2 = new Intent(this.f860a, (Class<?>) XMPushService.class);
        intent2.putExtra(an.F, this.f860a.getPackageName());
        b();
        return intent2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m647a() {
        this.f860a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f860a, (Class<?>) XMPushService.class), 2, 1);
    }

    public static void setSession(String str) {
        f858a = str;
    }

    public void setMessenger(Messenger messenger) {
        this.f861a = messenger;
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static ServiceClient getInstance(Context context) {
        if (f857a == null) {
            f857a = new ServiceClient(context);
        }
        return f857a;
    }

    public boolean closeChannel(String str) {
        Intent a2 = a();
        a2.setAction(an.i);
        a2.putExtra(an.v, str);
        return startServiceSafely(a2);
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (!com.xiaomi.push.j.m630a() && Build.VERSION.SDK_INT >= 26) {
                m648a(intent);
                return true;
            }
            INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_aop_ContextAop_startService(this.f860a, intent);
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    private ServiceClient(Context context) {
        this.f863a = false;
        Context applicationContext = context.getApplicationContext();
        this.f860a = applicationContext;
        com.xiaomi.push.q.a(applicationContext);
        a(this.f860a);
        if (m649a()) {
            com.xiaomi.channel.commonutils.logger.b.c("use miui push service");
            this.f863a = true;
        }
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            if (i < map.size()) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    public boolean sendIQ(fl flVar) {
        if (!com.xiaomi.push.at.m155a(this.f860a)) {
            return false;
        }
        Intent a2 = a();
        Bundle a3 = flVar.a();
        if (a3 == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + flVar.mo435a());
        a2.setAction(an.f);
        a2.putExtra(an.J, f858a);
        a2.putExtra("ext_packet", a3);
        return startServiceSafely(a2);
    }

    public boolean sendPresence(fp fpVar) {
        if (!com.xiaomi.push.at.m155a(this.f860a)) {
            return false;
        }
        Intent a2 = a();
        Bundle a3 = fpVar.a();
        if (a3 == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fpVar.mo435a());
        a2.setAction(an.h);
        a2.putExtra(an.J, f858a);
        a2.putExtra("ext_packet", a3);
        return startServiceSafely(a2);
    }

    private Map<String, String> a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair != null) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        return hashMap;
    }

    private void a(Context context) {
        try {
            com.xiaomi.push.at.m150a(context);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m54a("add network status listener failed:" + th);
        }
    }

    @Proxy("startService")
    @TargetClass("android.content.Context")
    public static ComponentName INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_aop_ContextAop_startService(Context context, Intent intent) {
        if (!(context instanceof Context)) {
            return context.startService(intent);
        }
        if (lz4.b.a()) {
            lz4.b.b(context, intent);
        } else if (ToolUtils.isMainProcess(App.context()) && c3.g() && NsPushService.IMPL.isInterceptStartPushStart(context, intent)) {
            return null;
        }
        return context.startService(intent);
    }

    public boolean closeChannel(String str, String str2) {
        Intent a2 = a();
        a2.setAction(an.i);
        a2.putExtra(an.v, str);
        a2.putExtra(an.s, str2);
        return startServiceSafely(a2);
    }

    public boolean batchSendMessage(fm[] fmVarArr, boolean z) {
        if (!com.xiaomi.push.at.m155a(this.f860a)) {
            return false;
        }
        Intent a2 = a();
        int length = fmVarArr.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i = 0; i < fmVarArr.length; i++) {
            String a3 = dx.a();
            if (!TextUtils.isEmpty(a3)) {
                fk fkVar = new fk("pf", null, null, null);
                fk fkVar2 = new fk("sent", null, null, null);
                fkVar2.m433a(a3);
                fkVar.a(fkVar2);
                fmVarArr[i].a(fkVar);
            }
            com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fmVarArr[i].mo435a());
            bundleArr[i] = fmVarArr[i].a();
        }
        if (length <= 0) {
            return false;
        }
        a2.setAction(an.g);
        a2.putExtra(an.J, f858a);
        a2.putExtra("ext_packets", bundleArr);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public boolean sendMessage(fm fmVar, boolean z) {
        if (!com.xiaomi.push.at.m155a(this.f860a)) {
            return false;
        }
        Intent a2 = a();
        String a3 = dx.a();
        if (!TextUtils.isEmpty(a3)) {
            fk fkVar = new fk("pf", null, null, null);
            fk fkVar2 = new fk("sent", null, null, null);
            fkVar2.m433a(a3);
            fkVar.a(fkVar2);
            fmVar.a(fkVar);
        }
        Bundle a4 = fmVar.a();
        if (a4 == null) {
            return false;
        }
        com.xiaomi.channel.commonutils.logger.b.c("SEND:" + fmVar.mo435a());
        a2.setAction(an.e);
        a2.putExtra(an.J, f858a);
        a2.putExtra("ext_packet", a4);
        a2.putExtra("ext_encrypt", z);
        return startServiceSafely(a2);
    }

    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, a(list), a(list2));
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(an.l);
        if (map != null) {
            String a3 = a(map);
            if (!TextUtils.isEmpty(a3)) {
                a2.putExtra(an.D, a3);
            }
        }
        if (map2 != null) {
            String a4 = a(map2);
            if (!TextUtils.isEmpty(a4)) {
                a2.putExtra(an.E, a4);
            }
        }
        a2.putExtra(an.v, str);
        startServiceSafely(a2);
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }

    public boolean notifyMessage(Bundle bundle, String str, String str2) {
        if (bundle != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent a2 = a();
            a2.setAction(an.o);
            a2.putExtras(bundle);
            com.xiaomi.channel.commonutils.logger.b.e("notify: chid=" + str2 + " bundle:" + bundle);
            return startServiceSafely(a2);
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("Failed to notify message: bundle|userId|chid may be empty");
        return false;
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        String str4;
        if (com.xiaomi.push.at.m155a(this.f860a) && bArr != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Intent a2 = a();
            a2.setAction(an.e);
            a2.putExtra(an.J, f858a);
            a2.putExtra("ext_raw_packet", bArr);
            int indexOf = str.indexOf("@");
            String str5 = null;
            if (indexOf != -1) {
                str3 = str.substring(0, indexOf);
            } else {
                str3 = null;
            }
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf != -1) {
                str5 = str.substring(indexOf + 1, lastIndexOf);
                str4 = str.substring(lastIndexOf + 1);
            } else {
                str4 = null;
            }
            a2.putExtra(an.s, str3);
            a2.putExtra(an.t, str5);
            a2.putExtra(an.u, str4);
            StringBuilder sb = new StringBuilder();
            sb.append(b);
            long j = a;
            a = 1 + j;
            sb.append(j);
            String sb2 = sb.toString();
            a2.putExtra("ext_pkt_id", sb2);
            a2.putExtra("ext_chid", str2);
            com.xiaomi.channel.commonutils.logger.b.e("SEND: chid=" + str2 + ", packetId=" + sb2);
            return startServiceSafely(a2);
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
        return false;
    }

    @Proxy("bindService")
    @TargetClass("android.content.Context")
    public static boolean INVOKEVIRTUAL_com_xiaomi_push_service_ServiceClient_com_dragon_read_aop_ContextAop_bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        if (ko2.e.a() && intent != null && "com.google.android.gms.ads.identifier.service.START".equals(intent.getAction())) {
            return true;
        }
        if (!(context instanceof Context)) {
            return context.bindService(intent, serviceConnection, i);
        }
        if (lz4.b.a()) {
            lz4.b.b(context, intent);
        } else if (ToolUtils.isMainProcess(App.context()) && c3.g() && NsPushService.IMPL.isInterceptStartPushBind(context, intent, serviceConnection, i)) {
            return true;
        }
        return context.bindService(intent, serviceConnection, i);
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent a2 = a();
        a2.setAction(an.d);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
        return 0;
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, a(list), a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(an.j);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(a2);
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, a(list), a(list2), z);
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent a2 = a();
        a2.setAction(an.k);
        a(a2, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(a2);
    }
}
