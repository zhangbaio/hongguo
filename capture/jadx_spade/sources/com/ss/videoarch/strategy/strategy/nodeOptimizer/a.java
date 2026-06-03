package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static String p;
    public final String a;
    public int b;
    private List<String> c = new ArrayList();
    public List<String> d = new ArrayList();
    private List<String> e = new ArrayList();
    private Map<Integer, List<String>> f = new HashMap();
    private Map<Integer, List<String>> g = new HashMap();
    private Map<Integer, List<String>> h = new HashMap();
    private List<String> i = new ArrayList();
    private ReentrantLock j = new ReentrantLock();
    private final List<String> k = new ArrayList(10);
    private final List<String> l = new ArrayList();
    public String m = null;
    public int n = -1;
    public int o = 2;

    static {
        Covode.recordClassIndex(653202);
        p = "(^((([0-9A-Fa-f]{1,4}:){7}(([0-9A-Fa-f]{1,4}){1}|:))|(([0-9A-Fa-f]{1,4}:){6}((:[0-9A-Fa-f]{1,4}){1}|((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){5}((:[0-9A-Fa-f]{1,4}){1,2}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){4}((:[0-9A-Fa-f]{1,4}){1,3}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){3}((:[0-9A-Fa-f]{1,4}){1,4}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){2}((:[0-9A-Fa-f]{1,4}){1,5}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(([0-9A-Fa-f]{1,4}:){1}((:[0-9A-Fa-f]{1,4}){1,6}|:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:))|(:((:[0-9A-Fa-f]{1,4}){1,7}|(:[fF]{4}){0,1}:((22[0-3]|2[0-1][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})([.](25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|([0-9]){1,2})){3})|:)))$)";
    }

    List<String> b() {
        this.j.lock();
        ArrayList arrayList = new ArrayList();
        List<String> list = this.c;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(this.c);
        }
        List<String> list2 = this.e;
        if (list2 != null && !list2.isEmpty()) {
            arrayList.addAll(this.e);
        }
        List<String> list3 = this.d;
        if (list3 != null && !list3.isEmpty()) {
            arrayList.addAll(this.d);
        }
        this.j.unlock();
        return arrayList;
    }

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        if (lj6.a.m().r.e.mEnableUseNewOptRecordStruct == 1) {
            int i = DnsOptimizer.O().T;
            List<String> c = c(i, 1);
            List<String> c2 = c(i, 2);
            List<String> c3 = c(i, 3);
            if (c != null && !c.isEmpty()) {
                arrayList.addAll(c);
            }
            if (c2 != null && !c2.isEmpty()) {
                arrayList.addAll(c2);
            }
            if (c3 != null && !c3.isEmpty()) {
                arrayList.addAll(c3);
                return arrayList;
            }
            return arrayList;
        }
        return b();
    }

    JSONArray i() {
        this.j.lock();
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.c;
        if (list != null && this.e != null) {
            if (!list.isEmpty()) {
                for (int i = 0; i < this.c.size(); i++) {
                    jSONArray.put(this.c.get(i));
                }
            }
            if (!this.e.isEmpty()) {
                for (int i2 = 0; i2 < this.e.size(); i2++) {
                    jSONArray.put(this.e.get(i2));
                }
            }
        }
        this.j.unlock();
        return jSONArray;
    }

    boolean q(List<String> list) {
        this.j.lock();
        this.c = list;
        this.j.unlock();
        return true;
    }

    boolean s(List<String> list) {
        this.j.lock();
        this.e = list;
        this.j.unlock();
        return true;
    }

    void t(String str) {
        this.j.lock();
        this.i.add(str);
        this.j.unlock();
    }

    boolean r(List<String> list) {
        this.j.lock();
        this.d = list;
        if (list != null && !list.isEmpty()) {
            this.n = 1;
        } else {
            this.n = 0;
        }
        this.j.unlock();
        return true;
    }

    JSONArray n(int i) {
        this.j.lock();
        JSONArray jSONArray = new JSONArray();
        List<String> c = c(i, 1);
        List<String> c2 = c(i, 2);
        if (c != null && !c.isEmpty()) {
            for (int i2 = 0; i2 < c.size(); i2++) {
                jSONArray.put(c.get(i2));
            }
        }
        if (c2 != null && !c2.isEmpty()) {
            for (int i3 = 0; i3 < c2.size(); i3++) {
                jSONArray.put(c2.get(i3));
            }
        }
        this.j.unlock();
        return jSONArray;
    }

    JSONObject d(String str) {
        this.j.lock();
        JSONObject jSONObject = new JSONObject();
        List<String> list = this.d;
        if (list != null && list.size() != 0) {
            try {
                jSONObject.put("local_dns", new JSONArray((Collection) this.d));
                if (this.d.contains(str)) {
                    jSONObject.put(str, "local_dns");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        List<String> list2 = this.e;
        if (list2 != null && list2.size() != 0) {
            try {
                jSONObject.put("remote_local_dns", new JSONArray((Collection) this.e));
                if (this.e.contains(str)) {
                    jSONObject.put(str, "remote_local_dns");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        List<String> list3 = this.c;
        if (list3 != null && list3.size() != 0) {
            try {
                jSONObject.put("http_dns", new JSONArray((Collection) this.c));
                if (this.c.contains(str)) {
                    jSONObject.put(str, "http_dns");
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        this.j.unlock();
        return jSONObject;
    }

    public static boolean j(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            return str.contains(".");
        }
        try {
            return Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(Normalizer.normalize(str, Normalizer.Form.NFKC)).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean k(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (z) {
            return str.contains(":");
        }
        return Pattern.compile(p).matcher(Normalizer.normalize(str, Normalizer.Form.NFKC)).matches();
    }

    List<String> f(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        this.j.lock();
        List<String> list = this.c;
        List<String> list2 = this.d;
        int i3 = lj6.a.m().r.e.mRequiredHttpIpCount;
        int i4 = lj6.a.m().r.e.mRequiredLocalIpCount;
        h(i, i2, list, arrayList, hashSet, i3);
        h(i, i2, list2, arrayList, hashSet, i4);
        this.j.unlock();
        return arrayList;
    }

    a(String str, int i) {
        this.b = 0;
        this.a = str;
        this.b = i;
    }

    private List<String> c(int i, int i2) {
        Map<Integer, List<String>> map;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 && (map = this.g) != null && map.containsKey(Integer.valueOf(i))) {
                    return this.g.get(Integer.valueOf(i));
                }
                return null;
            }
            Map<Integer, List<String>> map2 = this.h;
            if (map2 != null && map2.containsKey(Integer.valueOf(i))) {
                return this.h.get(Integer.valueOf(i));
            }
            return null;
        }
        Map<Integer, List<String>> map3 = this.f;
        if (map3 != null && map3.containsKey(Integer.valueOf(i))) {
            return this.f.get(Integer.valueOf(i));
        }
        return null;
    }

    private String e(List<String> list, int i) {
        boolean z;
        if (list != null && list.size() != 0) {
            if (lj6.a.m().r.e.mPerfOptIpValid == 1) {
                z = true;
            } else {
                z = false;
            }
            if (i == 1) {
                for (String str : list) {
                    if (k(str, z)) {
                        return str;
                    }
                }
            }
            if (i == 0) {
                for (String str2 : list) {
                    if (j(str2, z)) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }

    JSONObject m(String str, int i) {
        this.j.lock();
        JSONObject jSONObject = new JSONObject();
        List<String> c = c(i, 3);
        if (c != null && c.size() > 0) {
            try {
                jSONObject.put("local_dns", new JSONArray((Collection) c));
                if (c.contains(str)) {
                    jSONObject.put(str, "local_dns");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        List<String> c2 = c(i, 2);
        if (c2 != null && c2.size() > 0) {
            try {
                jSONObject.put("remote_local_dns", new JSONArray((Collection) c2));
                if (c2.contains(str)) {
                    jSONObject.put(str, "remote_local_dns");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        List<String> c3 = c(i, 1);
        if (c3 != null && c3.size() > 0) {
            try {
                jSONObject.put("http_dns", new JSONArray((Collection) c3));
                if (c3.contains(str)) {
                    jSONObject.put(str, "http_dns");
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        this.j.unlock();
        return jSONObject;
    }

    String l(boolean z, int i) {
        boolean z2;
        List<String> list;
        List<String> list2;
        this.j.lock();
        List<String> list3 = this.c;
        List<String> list4 = this.e;
        List<String> list5 = this.d;
        if (lj6.a.m().r.e.mEnableCheckHttpDnsAndLocalIntersection == 1 && (list = this.c) != null && list.size() > 0 && (list2 = this.d) != null && list2.size() > 0 && Collections.disjoint(this.c, this.d)) {
            list3 = this.e;
            list4 = this.c;
        }
        if (list3 != null && !list3.isEmpty() && this.i.size() > 0) {
            list3.removeAll(this.i);
        }
        if (list4 != null && !list4.isEmpty() && this.i.size() > 0) {
            list4.removeAll(this.i);
        }
        if (list5 != null && !list5.isEmpty() && this.i.size() > 0) {
            list5.removeAll(this.i);
        }
        if (lj6.a.m().r.e.mPerfOptIpValid == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (DnsOptimizer.O().T == 4 && lj6.a.m().r.e.mForbidUseIpv6InWiFi == 1) {
            if (list3 != null) {
                for (String str : list3) {
                    if (!k(str, z2)) {
                        this.j.unlock();
                        return str;
                    }
                }
            }
            if (list4 != null) {
                for (String str2 : list4) {
                    if (!k(str2, z2)) {
                        this.j.unlock();
                        return str2;
                    }
                }
            }
            if (list5 != null) {
                for (String str3 : list5) {
                    if (!k(str3, z2)) {
                        this.j.unlock();
                        return str3;
                    }
                }
            }
        }
        if (list3 != null && !list3.isEmpty()) {
            String str4 = list3.get(0);
            this.j.unlock();
            return str4;
        }
        if (list4 != null && !list4.isEmpty()) {
            String str5 = list4.get(0);
            this.j.unlock();
            return str5;
        }
        if (list5 != null && !list5.isEmpty()) {
            for (String str6 : list5) {
                if (k(str6, z2)) {
                    if (z) {
                        this.j.unlock();
                        return str6;
                    }
                } else if (!z) {
                    this.j.unlock();
                    return str6;
                }
            }
            String str7 = list5.get(0);
            this.j.unlock();
            return str7;
        }
        this.j.unlock();
        return null;
    }

    List<String> g(int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        this.j.lock();
        int i4 = lj6.a.m().r.e.mRequiredHttpIpCount;
        int i5 = lj6.a.m().r.e.mRequiredLocalIpCount;
        List<String> c = c(i3, 1);
        List<String> c2 = c(i3, 3);
        h(i, i2, c, arrayList, hashSet, i4);
        h(i, i2, c2, arrayList, hashSet, i5);
        this.j.unlock();
        return arrayList;
    }

    boolean p(List<String> list, int i, int i2) {
        Map<Integer, List<String>> map;
        this.j.lock();
        if (i != 1) {
            if (i != 2) {
                if (i == 3 && (map = this.g) != null) {
                    map.put(Integer.valueOf(i2), list);
                }
            } else {
                Map<Integer, List<String>> map2 = this.h;
                if (map2 != null) {
                    map2.put(Integer.valueOf(i2), list);
                }
            }
        } else {
            Map<Integer, List<String>> map3 = this.f;
            if (map3 != null) {
                map3.put(Integer.valueOf(i2), list);
            }
        }
        this.j.unlock();
        return true;
    }

    String o(boolean z, int i, int i2) {
        String str;
        boolean z2;
        this.j.lock();
        List<String> c = c(i, 1);
        List<String> c2 = c(i, 2);
        List<String> c3 = c(i, 3);
        if (lj6.a.m().r.e.mEnableCheckHttpDnsAndLocalIntersection == 1 && c != null && c.size() > 0 && c3 != null && c3.size() > 0 && Collections.disjoint(c, c3)) {
            c2 = c;
            c = c2;
        }
        ArrayList arrayList = new ArrayList();
        if (c != null && c.size() > 0) {
            if (this.i.size() > 0) {
                c.removeAll(this.i);
            }
            arrayList.addAll(c);
        }
        if (c2 != null && c2.size() > 0) {
            if (this.i.size() > 0) {
                c2.removeAll(this.i);
            }
            arrayList.addAll(c2);
        }
        if (c3 != null && c3.size() > 0) {
            if (this.i.size() > 0) {
                c3.removeAll(this.i);
            }
            arrayList.addAll(c3);
        }
        if (i2 != -1) {
            str = e(arrayList, i2);
            if (str != null) {
                this.j.unlock();
                return str;
            }
        } else {
            str = null;
        }
        if (c != null && c.size() > 0) {
            String str2 = c.get(0);
            this.j.unlock();
            return str2;
        }
        if (c2 != null && c2.size() > 0) {
            String str3 = c2.get(0);
            this.j.unlock();
            return str3;
        }
        if (c3 != null && c3.size() > 0) {
            for (String str4 : c3) {
                if (lj6.a.m().r.e.mPerfOptIpValid == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (k(str4, z2)) {
                    if (z) {
                        this.j.unlock();
                        return str4;
                    }
                } else if (!z) {
                    this.j.unlock();
                    return str4;
                }
            }
            String str5 = c3.get(0);
            this.j.unlock();
            return str5;
        }
        this.j.unlock();
        return str;
    }

    void h(int i, int i2, List<String> list, List<String> list2, Set<String> set, int i3) {
        boolean z;
        boolean j;
        int size = list2.size();
        if (lj6.a.m().r.e.mPerfOptIpValid == 1) {
            z = true;
        } else {
            z = false;
        }
        if (list != null && !list.isEmpty()) {
            int i4 = 0;
            for (String str : list) {
                if (i4 < i3 && size < i2) {
                    if (i != 0) {
                        if (i != 1) {
                            j = false;
                        } else {
                            j = k(str, z);
                            str = '[' + str + ']';
                        }
                    } else {
                        j = j(str, z);
                    }
                    if (j && !set.contains(str)) {
                        list2.add(str);
                        set.add(str);
                        size++;
                        i4++;
                    }
                } else {
                    return;
                }
            }
        }
    }
}
