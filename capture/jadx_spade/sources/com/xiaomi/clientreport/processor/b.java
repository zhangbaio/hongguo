package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bk;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b implements IPerfProcessor {
    protected Context a;

    /* renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f22a;

    static {
        Covode.recordClassIndex(655252);
    }

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        bk.a(this.a, "perf", "perfUploading");
        File[] m190a = bk.m190a(this.a, "perfUploading");
        if (m190a != null && m190a.length > 0) {
            for (File file : m190a) {
                if (file != null) {
                    List<String> a = e.a(this.a, file.getAbsolutePath());
                    file.delete();
                    a(a);
                }
            }
        }
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap = this.f22a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it2 = this.f22a.keySet().iterator();
            while (it2.hasNext()) {
                HashMap<String, com.xiaomi.clientreport.data.a> hashMap2 = this.f22a.get(it2.next());
                if (hashMap2 != null && hashMap2.size() > 0) {
                    com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[hashMap2.size()];
                    hashMap2.values().toArray(aVarArr);
                    a(aVarArr);
                }
            }
        }
        this.f22a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> hashMap) {
        this.f22a = hashMap;
    }

    public b(Context context) {
        this.a = context;
    }

    public void a(List<String> list) {
        bk.a(this.a, list);
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production) + "#" + aVar.clientInterfaceId;
    }

    private String c(com.xiaomi.clientreport.data.a aVar) {
        String b = b(aVar);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        for (int i = 0; i < 20; i++) {
            String str = b + i;
            if (bk.m189a(this.a, str)) {
                return str;
            }
        }
        return null;
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        String str;
        int i = aVar.production;
        String str2 = aVar.clientInterfaceId;
        if (i > 0 && !TextUtils.isEmpty(str2)) {
            str = String.valueOf(i) + "#" + str2;
        } else {
            str = "";
        }
        PolarisFileWrapper polarisFileWrapper = new PolarisFileWrapper(this.a.getFilesDir(), "perf");
        if (!polarisFileWrapper.exists()) {
            polarisFileWrapper.mkdirs();
        }
        return new PolarisFileWrapper(polarisFileWrapper, str).getAbsolutePath();
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* renamed from: a */
    public void mo66a(com.xiaomi.clientreport.data.a aVar) {
        if (!(aVar instanceof PerfClientReport) || this.f22a == null) {
            return;
        }
        PerfClientReport perfClientReport = (PerfClientReport) aVar;
        String a = a((com.xiaomi.clientreport.data.a) perfClientReport);
        String a2 = e.a(perfClientReport);
        HashMap<String, com.xiaomi.clientreport.data.a> hashMap = this.f22a.get(a);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        PerfClientReport perfClientReport2 = (PerfClientReport) hashMap.get(a2);
        if (perfClientReport2 != null) {
            perfClientReport.perfCounts += perfClientReport2.perfCounts;
            perfClientReport.perfLatencies += perfClientReport2.perfLatencies;
        }
        hashMap.put(a2, perfClientReport);
        this.f22a.put(a, hashMap);
    }

    public void a(com.xiaomi.clientreport.data.a[] aVarArr) {
        String c = c(aVarArr[0]);
        if (TextUtils.isEmpty(c)) {
            return;
        }
        e.a(c, aVarArr);
    }
}
