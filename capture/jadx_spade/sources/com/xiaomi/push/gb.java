package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class gb {
    static {
        Covode.recordClassIndex(655551);
    }

    private static HashMap<String, ArrayList<gi>> a(Context context, List<gi> list) {
        if (list != null && list.size() != 0) {
            HashMap<String, ArrayList<gi>> hashMap = new HashMap<>();
            for (gi giVar : list) {
                a(context, giVar);
                ArrayList<gi> arrayList = hashMap.get(giVar.c());
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    hashMap.put(giVar.c(), arrayList);
                }
                arrayList.add(giVar);
            }
            return hashMap;
        }
        return null;
    }

    private static void a(Context context, gi giVar) {
        if (giVar.f504a) {
            giVar.a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(giVar.d())) {
            giVar.f(com.xiaomi.push.service.az.a());
        }
        giVar.b(System.currentTimeMillis());
        if (TextUtils.isEmpty(giVar.e())) {
            giVar.e(context.getPackageName());
        }
        if (TextUtils.isEmpty(giVar.c())) {
            giVar.e(giVar.e());
        }
    }

    private static void a(Context context, gd gdVar, HashMap<String, ArrayList<gi>> hashMap) {
        for (Map.Entry<String, ArrayList<gi>> entry : hashMap.entrySet()) {
            try {
                ArrayList<gi> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    gdVar.a(value, value.get(0).e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, gd gdVar, List<gi> list) {
        HashMap<String, ArrayList<gi>> a = a(context, list);
        if (a != null && a.size() != 0) {
            a(context, gdVar, a);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m54a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }
}
