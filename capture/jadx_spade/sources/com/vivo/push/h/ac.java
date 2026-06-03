package com.vivo.push.h;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class ac extends ab {
    static {
        Covode.recordClassIndex(655046);
    }

    ac(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        JSONObject jSONObject;
        com.vivo.push.b.u uVar = (com.vivo.push.b.u) vVar;
        ArrayList<String> e = uVar.e();
        List<String> f = uVar.f();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int j = uVar.j();
        com.vivo.push.util.t.c("OnSetTagsTask", "doTask,删除成功的标签 = " + e + " 删除失败的= " + f + " 错误码= " + j);
        String i = uVar.i();
        if (e != null) {
            for (String str : e) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (f != null) {
            for (String str2 : f) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            com.vivo.push.util.t.c("OnSetTagsTask", "doTask1,订阅成功的标签 = " + arrayList + " 订阅失败的标签= " + arrayList3 + " 错误码= " + j);
            if (arrayList.size() > 0) {
                com.vivo.push.m.a();
                try {
                    if (arrayList.size() > 0) {
                        String g = com.vivo.push.restructure.a.a().e().g();
                        if (TextUtils.isEmpty(g)) {
                            jSONObject = new JSONObject();
                        } else {
                            jSONObject = new JSONObject(g);
                        }
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            jSONObject.put((String) it2.next(), System.currentTimeMillis());
                        }
                        String jSONObject2 = jSONObject.toString();
                        if (TextUtils.isEmpty(jSONObject2)) {
                            com.vivo.push.restructure.a.a().e().h();
                        } else {
                            com.vivo.push.restructure.a.a().e().d(jSONObject2);
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    com.vivo.push.restructure.a.a().e().h();
                }
            }
            com.vivo.push.m.a().a(uVar.i(), j);
            com.vivo.push.t.a(new ad(this, j, arrayList, arrayList3, i));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            com.vivo.push.util.t.c("OnSetTagsTask", "doTask1,订阅成功的别名 = " + arrayList + " 订阅失败的别名= " + arrayList3 + " 错误码= " + j);
            if (arrayList2.size() > 0) {
                com.vivo.push.m.a().a((String) arrayList2.get(0));
            }
            com.vivo.push.m.a().a(uVar.i(), j);
            com.vivo.push.t.a(new ae(this, j, arrayList2, arrayList4, i));
        }
    }
}
