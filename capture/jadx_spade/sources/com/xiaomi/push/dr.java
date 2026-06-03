package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dr {
    private static a a;

    /* renamed from: a, reason: collision with other field name */
    private static Map<String, go> f334a;

    public interface a {
        void uploader(Context context, gi giVar);
    }

    public static int a(int i) {
        if (i > 0) {
            return i + 1000;
        }
        return -1;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m361a(int i) {
        return i == 1000 ? "E100000" : i == 3000 ? "E100002" : i == 2000 ? "E100001" : i == 6000 ? "E100003" : "";
    }

    private static void a(Context context, gi giVar) {
        if (m363a(context.getApplicationContext())) {
            com.xiaomi.push.service.ba.a(context.getApplicationContext(), giVar);
            return;
        }
        a aVar = a;
        if (aVar != null) {
            aVar.uploader(context, giVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m363a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                gi a2 = a(context, it2.next());
                if (!com.xiaomi.push.service.az.a(a2, false)) {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d(th.getMessage());
        }
    }

    public static void a(Context context, Config config) {
        ClientReportClient.init(context, config, new dp(context), new dq(context));
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m362a(Context context) {
        ClientReportClient.updateConfig(context, a(context));
    }

    static {
        Covode.recordClassIndex(655466);
        f334a = null;
    }

    public static PerfClientReport a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static void a(a aVar) {
        a = aVar;
    }

    public static EventClientReport a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof ge) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof go) {
                return r1.ordinal() + 2001;
            }
            if (r1 instanceof ec) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    public static Config a(Context context) {
        boolean a2 = com.xiaomi.push.service.ah.a(context).a(gj.PerfUploadSwitch.a(), false);
        boolean a3 = com.xiaomi.push.service.ah.a(context).a(gj.EventUploadNewSwitch.a(), false);
        return Config.getBuilder().setEventUploadSwitchOpen(a3).setEventUploadFrequency(com.xiaomi.push.service.ah.a(context).a(gj.EventUploadFrequency.a(), 86400)).setPerfUploadSwitchOpen(a2).setPerfUploadFrequency(com.xiaomi.push.service.ah.a(context).a(gj.PerfUploadFrequency.a(), 86400)).build(context);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static go m360a(String str) {
        if (f334a == null) {
            synchronized (go.class) {
                if (f334a == null) {
                    f334a = new HashMap();
                    for (go goVar : go.values()) {
                        f334a.put(goVar.f529a.toLowerCase(), goVar);
                    }
                }
            }
        }
        go goVar2 = f334a.get(str.toLowerCase());
        if (goVar2 == null) {
            return go.Invalid;
        }
        return goVar2;
    }

    public static gi a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gi giVar = new gi();
        giVar.d("category_client_report_data");
        giVar.a("push_sdk_channel");
        giVar.a(1L);
        giVar.b(str);
        giVar.a(true);
        giVar.b(System.currentTimeMillis());
        giVar.g(context.getPackageName());
        giVar.e("com.xiaomi.xmsf");
        giVar.f(com.xiaomi.push.service.az.a());
        giVar.c("quality_support");
        return giVar;
    }

    public static PerfClientReport a(Context context, int i, long j, long j2) {
        PerfClientReport a2 = a();
        a2.code = i;
        a2.perfCounts = j;
        a2.perfLatencies = j2;
        return a2;
    }

    public static EventClientReport a(Context context, String str, String str2, int i, long j, String str3) {
        EventClientReport a2 = a(str);
        a2.eventId = str2;
        a2.eventType = i;
        a2.eventTime = j;
        a2.eventContent = str3;
        return a2;
    }
}
