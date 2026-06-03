package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    private static b a;
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private List<Serializable> i = Collections.synchronizedList(new ArrayList());
    private List<Serializable> j = Collections.synchronizedList(new ArrayList());
    private Executor k = l.b();
    private boolean l;

    static {
        Covode.recordClassIndex(653514);
    }

    public static String b() {
        return a().b;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    private b() {
    }

    private void c() {
        while (!this.j.isEmpty()) {
            c cVar = (c) this.j.remove(0);
            cVar.a.put("appid", this.b);
            cVar.a.put("app_name", this.c);
            cVar.a.put("app_ver", this.e);
            cVar.a.put("pkg_name", this.f);
            cVar.a.put("qq_install", this.g);
            cVar.a.put("qq_ver", this.h);
            cVar.a.put("openid", this.d);
            cVar.a.put("time_appid_openid", cVar.a.get("time") + "_" + this.b + "_" + this.d);
            StringBuilder sb = new StringBuilder();
            sb.append("fixDirtyData--------------------------");
            sb.append(cVar);
            SLog.i("AttaReporter", sb.toString());
            this.i.add(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (!this.l) {
            List<Serializable> b = g.b("report_atta");
            this.l = b.isEmpty();
            this.i.addAll(b);
            Iterator<Serializable> it2 = b.iterator();
            while (it2.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread from db = " + it2.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.i.isEmpty()) {
            c cVar = (c) this.i.remove(0);
            if (!b(cVar)) {
                arrayList.add(cVar);
            }
        }
        if (!arrayList.isEmpty()) {
            SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) ((Serializable) it4.next())));
            }
            g.a("report_atta", arrayList);
            this.l = false;
            return;
        }
        if (!this.l) {
            SLog.i("AttaReporter", "attaReportAtSubThread clear db");
            g.a("report_atta");
            this.l = true;
        }
    }

    private void a(final c cVar) {
        this.k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.i.add(cVar);
                if (!m.b(com.tencent.open.utils.g.a())) {
                    SLog.i("AttaReporter", "attaReport net disconnect, " + cVar);
                    return;
                }
                try {
                    b.this.d();
                } catch (Exception e) {
                    SLog.e("AttaReporter", "Exception", e);
                }
            }
        });
    }

    private boolean b(c cVar) {
        int i = 0;
        do {
            i++;
            try {
                SLog.i("AttaReporter", "doAttaReportItem post " + cVar);
                if (com.tencent.open.a.f.a().b("https://h.trace.qq.com/kv", cVar.a).d() != 200) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                SLog.i("AttaReporter", "Exception", e);
            }
        } while (i < 2);
        return false;
    }

    public void a(String str) {
        SLog.i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.d = str;
    }

    public void a(String str, Object obj) {
        a(str, "", obj, null);
    }

    public void a(String str, Context context) {
        String str2;
        SLog.i("AttaReporter", "init");
        this.b = str;
        this.c = k.a(context);
        this.e = m.d(context, com.tencent.open.utils.g.b());
        this.f = com.tencent.open.utils.g.b();
        if (k.b(context)) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        this.g = str2;
        this.h = m.c(context, "com.tencent.mobileqq");
        c();
        g.a();
    }

    public void a(String str, String str2) {
        a(str, str2, null);
    }

    public void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, "", map);
    }

    private c b(String str, String str2, Object obj, Map<String, Object> map) {
        String obj2;
        String obj3;
        String obj4;
        String obj5;
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "09400051119");
        hashMap.put("token", "9389887874");
        hashMap.put("time_appid_openid", currentTimeMillis + "_" + this.b + "_" + this.d);
        hashMap.put("time", String.valueOf(currentTimeMillis));
        hashMap.put("openid", this.d);
        hashMap.put("appid", this.b);
        hashMap.put("app_name", this.c);
        hashMap.put("app_ver", this.e);
        hashMap.put("pkg_name", this.f);
        hashMap.put("os", "AND");
        hashMap.put("os_ver", Build.VERSION.RELEASE);
        hashMap.put("sdk_ver", "3.5.11.lite");
        hashMap.put("model_name", com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
        hashMap.put("interface_name", str);
        hashMap.put("interface_data", str2);
        String str3 = "";
        if (obj == null) {
            obj2 = "";
        } else {
            obj2 = obj.toString();
        }
        hashMap.put("interface_result", obj2);
        hashMap.put("qq_install", this.g);
        hashMap.put("qq_ver", this.h);
        if (map != null && !map.isEmpty()) {
            Object obj6 = map.get("reserve1");
            if (obj6 == null) {
                obj3 = "";
            } else {
                obj3 = obj6.toString();
            }
            hashMap.put("reserve1", obj3);
            Object obj7 = map.get("reserve2");
            if (obj7 == null) {
                obj4 = "";
            } else {
                obj4 = obj7.toString();
            }
            hashMap.put("reserve2", obj4);
            Object obj8 = map.get("reserve3");
            if (obj8 == null) {
                obj5 = "";
            } else {
                obj5 = obj8.toString();
            }
            hashMap.put("reserve3", obj5);
            Object obj9 = map.get("reserve4");
            if (obj9 != null) {
                str3 = obj9.toString();
            }
            hashMap.put("reserve4", str3);
        }
        return new c((HashMap<String, String>) hashMap);
    }

    public void a(String str, String str2, Object obj, Map<String, Object> map) {
        c b = b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && com.tencent.open.utils.g.a() != null) {
            a(b);
            return;
        }
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.b + ", mAppName=" + this.c + ", context=" + com.tencent.open.utils.g.a() + ", " + b);
        this.j.add(b);
    }
}
