package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ad;
import com.xiaomi.push.ba;
import com.xiaomi.push.bh;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bk;
import com.xiaomi.push.bl;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static final int a;

    /* renamed from: a, reason: collision with other field name */
    private static volatile a f9a;

    /* renamed from: a, reason: collision with other field name */
    private Context f10a;

    /* renamed from: a, reason: collision with other field name */
    private Config f11a;

    /* renamed from: a, reason: collision with other field name */
    private IEventProcessor f12a;

    /* renamed from: a, reason: collision with other field name */
    private IPerfProcessor f13a;

    /* renamed from: a, reason: collision with other field name */
    private String f14a;

    /* renamed from: a, reason: collision with other field name */
    private ExecutorService f16a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ort/manager/a"), "com.xiaomi.clientreport.manager.a");

    /* renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f15a = new HashMap<>();
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> b = new HashMap<>();

    /* renamed from: a, reason: collision with other method in class */
    public void m64a() {
        a(this.f10a).f();
        a(this.f10a).g();
    }

    public void a(String str) {
        this.f14a = str;
    }

    public void a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f11a = config;
        this.f12a = iEventProcessor;
        this.f13a = iPerfProcessor;
        iEventProcessor.setEventMap(this.b);
        this.f13a.setPerfMap(this.f15a);
    }

    public void a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f11a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f11a.isPerfUploadSwitchOpen() && j == this.f11a.getEventUploadFrequency() && j2 == this.f11a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f11a.getEventUploadFrequency();
            long perfUploadFrequency = this.f11a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(bk.a(this.f10a)).setEventEncrypted(this.f11a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f10a);
            this.f11a = build;
            if (!build.isEventUploadSwitchOpen()) {
                ad.a(this.f10a).m135a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                b.c(this.f10a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                f();
            }
            if (!this.f11a.isPerfUploadSwitchOpen()) {
                ad.a(this.f10a).m135a("100887");
                return;
            }
            if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                b.c(this.f10a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                g();
            }
        }
    }

    public void a(final EventClientReport eventClientReport) {
        if (m63a().isEventUploadSwitchOpen()) {
            this.f16a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(eventClientReport);
                }
            });
        }
    }

    public void a(final PerfClientReport perfClientReport) {
        if (m63a().isPerfUploadSwitchOpen()) {
            this.f16a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(perfClientReport);
                }
            });
        }
    }

    static {
        int i;
        Covode.recordClassIndex(655248);
        if (j.m630a()) {
            i = 30;
        } else {
            i = 10;
        }
        a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f12a.b();
        } catch (Exception e) {
            b.d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f13a.b();
        } catch (Exception e) {
            b.d("wp: " + e.getMessage());
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m65b() {
        if (m63a().isEventUploadSwitchOpen()) {
            bj bjVar = new bj();
            bjVar.a(this.f10a);
            bjVar.a(this.f12a);
            this.f16a.execute(bjVar);
        }
    }

    public void c() {
        if (m63a().isPerfUploadSwitchOpen()) {
            bj bjVar = new bj();
            bjVar.a(this.f13a);
            bjVar.a(this.f10a);
            this.f16a.execute(bjVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        int i;
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.b;
        if (hashMap == null) {
            return 0;
        }
        Iterator<String> it2 = hashMap.keySet().iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            ArrayList<com.xiaomi.clientreport.data.a> arrayList = this.b.get(it2.next());
            if (arrayList != null) {
                i = arrayList.size();
            } else {
                i = 0;
            }
            i2 += i;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f15a;
        int i = 0;
        if (hashMap != null) {
            Iterator<String> it2 = hashMap.keySet().iterator();
            while (it2.hasNext()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f15a.get(it2.next());
                if (hashMap2 != null) {
                    Iterator<String> it4 = hashMap2.keySet().iterator();
                    while (it4.hasNext()) {
                        com.xiaomi.clientreport.data.a aVar = hashMap2.get(it4.next());
                        if (aVar instanceof PerfClientReport) {
                            i = (int) (i + ((PerfClientReport) aVar).perfCounts);
                        }
                    }
                }
            }
        }
        return i;
    }

    private void f() {
        if (!a(this.f10a).m63a().isEventUploadSwitchOpen()) {
            return;
        }
        final bh bhVar = new bh(this.f10a);
        int eventUploadFrequency = (int) a(this.f10a).m63a().getEventUploadFrequency();
        if (eventUploadFrequency < 1800) {
            eventUploadFrequency = 1800;
        }
        if (System.currentTimeMillis() - bl.a(this.f10a).a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
            ad.a(this.f10a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.5
                @Override // java.lang.Runnable
                public void run() {
                    bhVar.run();
                }
            }, 10);
        }
        synchronized (a.class) {
            if (!ad.a(this.f10a).a((ad.a) bhVar, eventUploadFrequency)) {
                ad.a(this.f10a).m135a("100886");
                ad.a(this.f10a).a((ad.a) bhVar, eventUploadFrequency);
            }
        }
    }

    private void g() {
        if (!a(this.f10a).m63a().isPerfUploadSwitchOpen()) {
            return;
        }
        final bi biVar = new bi(this.f10a);
        int perfUploadFrequency = (int) a(this.f10a).m63a().getPerfUploadFrequency();
        if (perfUploadFrequency < 1800) {
            perfUploadFrequency = 1800;
        }
        if (System.currentTimeMillis() - bl.a(this.f10a).a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
            ad.a(this.f10a).a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.6
                @Override // java.lang.Runnable
                public void run() {
                    biVar.run();
                }
            }, 15);
        }
        synchronized (a.class) {
            if (!ad.a(this.f10a).a((ad.a) biVar, perfUploadFrequency)) {
                ad.a(this.f10a).m135a("100887");
                ad.a(this.f10a).a((ad.a) biVar, perfUploadFrequency);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Config m63a() {
        if (this.f11a == null) {
            this.f11a = Config.defaultConfig(this.f10a);
        }
        return this.f11a;
    }

    public static a a(Context context) {
        if (f9a == null) {
            synchronized (a.class) {
                if (f9a == null) {
                    f9a = new a(context);
                }
            }
        }
        return f9a;
    }

    private a(Context context) {
        this.f10a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f12a;
        if (iEventProcessor != null) {
            iEventProcessor.mo66a(eventClientReport);
            if (a() >= 10) {
                d();
                ad.a(this.f10a).m135a("100888");
            } else {
                a(new ad.a() { // from class: com.xiaomi.clientreport.manager.a.3
                    @Override // com.xiaomi.push.ad.a
                    /* renamed from: a */
                    public String mo187a() {
                        return "100888";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.a() > 0) {
                            a.this.f16a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.d();
                                }
                            });
                        }
                    }
                }, a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f13a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo66a(perfClientReport);
            if (b() >= 10) {
                e();
                ad.a(this.f10a).m135a("100889");
            } else {
                a(new ad.a() { // from class: com.xiaomi.clientreport.manager.a.4
                    @Override // com.xiaomi.push.ad.a
                    /* renamed from: a */
                    public String mo187a() {
                        return "100889";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.b() > 0) {
                            a.this.f16a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.e();
                                }
                            });
                        }
                    }
                }, a);
            }
        }
    }

    private void a(ad.a aVar, int i) {
        ad.a(this.f10a).b(aVar, i);
    }

    public EventClientReport a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = ba.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f10a.getPackageName());
        eventClientReport.setSdkVersion(this.f14a);
        return eventClientReport;
    }
}
