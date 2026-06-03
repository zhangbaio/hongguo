package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class h {
    protected static h a;
    protected HandlerThread e;
    protected Handler f;
    protected Random b = new SecureRandom();
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());
    protected Executor g = l.b();
    protected Executor h = l.b();

    static {
        Covode.recordClassIndex(653520);
    }

    protected void b() {
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                a = new h();
            }
            hVar = a;
        }
        return hVar;
    }

    protected void d() {
        if (!m.b(com.tencent.open.utils.g.a())) {
            return;
        }
        this.g.execute(new Runnable() { // from class: com.tencent.open.b.h.3
            /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
            
                r18 = r5;
                r22 = r9;
                r20 = r14;
                r7 = true;
             */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00c5 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:37:? A[LOOP:0: B:9:0x002f->B:37:?, LOOP_END, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 277
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.AnonymousClass3.run():void");
            }
        });
    }

    private h() {
        this.e = null;
        if (this.e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e = handlerThread;
            handlerThread.start();
        }
        if (this.e.isAlive() && this.e.getLooper() != null) {
            this.f = new HandlerDelegate(this.e.getLooper()) { // from class: com.tencent.open.b.h.1
                /* JADX WARN: Multi-variable type inference failed */
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i != 1000) {
                        if (i == 1001) {
                            h.this.d();
                        }
                    } else {
                        h.this.b();
                    }
                    super/*android.os.Handler*/.handleMessage(message);
                }
            };
        }
    }

    protected Map<String, String> c() {
        List<Serializable> b = g.b("report_via");
        if (b != null) {
            this.d.addAll(b);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.d) {
            JSONObject jSONObject = new JSONObject();
            c cVar = (c) serializable;
            for (String str : cVar.a.keySet()) {
                try {
                    String str2 = cVar.a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject2.toString());
            return hashMap;
        } catch (JSONException e2) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected int a(int i) {
        if (i == 0) {
            int a2 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a2 == 0) {
                return 10;
            }
            return a2;
        }
        int a3 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a3 == 0) {
            return 100;
        }
        return a3;
    }

    public void a(final String str, final Map<String, String> map) {
        if (!m.b(com.tencent.open.utils.g.a())) {
            return;
        }
        l.b(new Runnable() { // from class: com.tencent.open.b.h.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int a2 = f.a();
                    if (a2 == 0) {
                        a2 = 3;
                    }
                    SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + a2);
                    int i = 0;
                    do {
                        i++;
                        try {
                            SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + com.tencent.open.a.f.a().a(str, map).d());
                        } catch (SocketTimeoutException e) {
                            SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e);
                        } catch (Exception e2) {
                            SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e2);
                        }
                    } while (i < a2);
                } catch (Exception e3) {
                    SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e3);
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r0 == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1e
            android.content.Context r0 = com.tencent.open.utils.g.a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.i.a(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L1c:
            r1 = r0
            goto L38
        L1e:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L37
            android.content.Context r0 = com.tencent.open.utils.g.a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.i.a(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L37:
            r1 = 0
        L38:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "-->availableCount, report: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " | dataSize: "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = " | maxcount: "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "openSDK_LOG.ReportManager"
            com.tencent.open.log.SLog.d(r0, r5)
            if (r6 < r1) goto L62
            r5 = 1
            return r5
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.h.a(java.lang.String, int):boolean");
    }

    protected boolean a(String str, String str2) {
        int a2;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 100;
        if (str.equals("report_cgi")) {
            try {
                a2 = a(Integer.parseInt(str2));
                if (this.b.nextInt(100) < a2) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                a2 = f.a(str2);
                if (this.b.nextInt(100) < a2) {
                    i = a2;
                    z = true;
                }
            }
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
            return z;
        }
        i = a2;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
        return z;
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (!a("report_via", str) && !z) {
            return;
        }
        this.g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("uin", "1000");
                    bundle2.putString("platform", "1");
                    bundle2.putString("os_ver", Build.VERSION.RELEASE);
                    bundle2.putString("position", "");
                    bundle2.putString("network", a.a(com.tencent.open.utils.g.a()));
                    bundle2.putString("language", d.a());
                    bundle2.putString("resolution", d.a(com.tencent.open.utils.g.a()));
                    bundle2.putString("apn", a.b(com.tencent.open.utils.g.a()));
                    bundle2.putString("model_name", com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
                    bundle2.putString("timezone", TimeZone.getDefault().getID());
                    bundle2.putString("sdk_ver", "3.5.11.lite");
                    bundle2.putString("qz_ver", m.d(com.tencent.open.utils.g.a(), "com.qzone"));
                    bundle2.putString("qq_ver", m.c(com.tencent.open.utils.g.a(), "com.tencent.mobileqq"));
                    bundle2.putString("qua", m.e(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                    bundle2.putString("packagename", com.tencent.open.utils.g.b());
                    bundle2.putString("app_ver", m.d(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                    Bundle bundle3 = bundle;
                    if (bundle3 != null) {
                        bundle2.putAll(bundle3);
                    }
                    h.this.d.add(new c(bundle2));
                    int size = h.this.d.size();
                    int a2 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                    if (a2 == 0) {
                        a2 = 10000;
                    }
                    if (!h.this.a("report_via", size) && !z) {
                        if (!h.this.f.hasMessages(1001)) {
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            h.this.f.sendMessageDelayed(obtain, a2);
                            return;
                        }
                        return;
                    }
                    h.this.d();
                    h.this.f.removeMessages(1001);
                } catch (Exception e) {
                    SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                }
            }
        });
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(String str, long j, long j2, long j3, int i, String str2, boolean z) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
    }
}
