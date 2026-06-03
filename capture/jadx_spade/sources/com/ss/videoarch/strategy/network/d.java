package com.ss.videoarch.strategy.network;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class d {
    private static String a;
    static HashMap<String, ArrayList<String>> b;

    private static class a {
        private static final d a;
        private static final b b;

        static {
            Covode.recordClassIndex(653156);
            a = new d();
            b = (b) d.a("full", "NetworkMonitor");
        }
    }

    public static d e() {
        return a.a;
    }

    public int c() {
        if (a.b != null) {
            return a.b.getNetworkType();
        }
        return -1;
    }

    static {
        Covode.recordClassIndex(653155);
        a = "NetworkMonitorLoader";
        b = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList.add("com.ss.videoarch.strategy.base.NetworkMonitor");
        arrayList2.add("com.ss.videoarch.strategy.network.NetworkMonitor");
        b.put("tob", arrayList);
        b.put("full", arrayList2);
    }

    public String d() {
        String str;
        int c = c();
        if (c != 1) {
            if (c != 2) {
                if (c != 3) {
                    if (c != 4) {
                        if (c != 5) {
                            str = "NONE";
                        } else {
                            str = "4g";
                        }
                    } else {
                        str = "wifi";
                    }
                } else {
                    str = "3g";
                }
            } else {
                str = "2g";
            }
        } else {
            str = "mobile";
        }
        return str.toUpperCase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object a(String str, String str2) {
        try {
            ArrayList<String> arrayList = b.get(str);
            Objects.requireNonNull(arrayList);
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (next.contains(str2)) {
                    try {
                        Class q = l3.a.q(next);
                        ClassLoader classLoader = q.getClassLoader();
                        if (classLoader == null) {
                            return null;
                        }
                        classLoader.loadClass(q.getName());
                        return q.newInstance();
                    } catch (ClassNotFoundException e) {
                        Log.d(a, "LoadObject: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e2) {
            Log.e(a, "LoadClass: " + e2.getMessage());
        }
        return null;
    }
}
