package com.unionpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.unionpay.utils.UPUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private static String A;
    private static String B;
    private static String C;
    private static String D;
    private static String E;
    private static String F;
    private static String G;
    private static String H;
    private static boolean I;
    private static int J;
    private static WeakReference K;
    private static String L;
    private static String M;
    private static String N;
    private static String O;
    private static String P;
    private static boolean Q;
    private static String R;
    private static int S;
    private static boolean T;
    private static boolean U;
    private static zj6.d V;
    private static Handler W;
    private static String X;
    private static String Y;
    private static String Z;
    private static String a;
    private static String a0;
    private static String b;
    private static JSONArray b0;
    private static String c;
    private static final Handler.Callback c0;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static String m;
    private static String n;
    private static String o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static String t;
    private static String u;
    private static String v;
    private static String w;
    private static String x;
    private static String y;
    private static String z;

    static {
        Covode.recordClassIndex(654841);
        a = "SpId";
        b = "paydata";
        c = "pay_tn";
        d = "SysProvide";
        e = "UseTestMode";
        f = "SecurityChipType";
        g = "uppayuri";
        h = "resultIntentAction";
        i = "reqOriginalId";
        j = "wapurl";
        k = "actionType";
        l = "dlgstyle";
        m = "com.unionpay.uppay";
        n = "com.unionpay.uppay.PayActivity";
        o = "com.huawei.wallet";
        p = "com.huawei.wallet.action.onlinepay.startpay";
        q = "ex_mode";
        r = "server";
        s = "source";
        t = "samsung_out";
        u = "se_type";
        v = "se_title_logo";
        w = "se_loading_logo";
        x = "se_title_bg_color";
        y = "se_cancel_bg_color";
        z = "02";
        E = "";
        F = "";
        G = "";
        H = "";
        I = false;
        J = 10;
        L = "";
        M = null;
        N = null;
        O = "";
        P = "";
        Q = false;
        R = "";
        S = 0;
        T = false;
        U = false;
        V = null;
        W = null;
        X = "[{\"package_info\":[{\"schema\":\"com.unionpay\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":101,\"version\":\".*\"}],\"sort\":100,\"type\":\"app\"}]";
        Y = "[{\"package_info\":[{\"schema\":\"com.unionpay\",\"sign\":\"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\":101,\"version\":\".*\"}],\"sort\":100,\"type\":\"app\"}]";
        Z = "[{\"package_info\": [{\"schema\": \"com.unionpay.tsmservice\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 102,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[2-9].*|^01\\\\.00\\\\.1[012789].*|^01\\\\.00\\\\.0[8-9].*\"},{\"schema\": \"com.unionpay.tsmservice.mi\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 103,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[1-9].*|^01\\\\.00\\\\.0[8-9].*\"}],\"sort\": 100,\"type\": \"app\"}]";
        a0 = "[{\"package_info\": [{\"schema\": \"com.huawei.wallet\",\"sign\": \"9095F915D6C143A41CE029209AFECB87AB481DDD\",\"sort\": 101,\"version\": \"([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\"},{\"schema\": \"com.huawei.wallet\",\"sign\": \"059e2480adf8c1c5b3d9ec007645ccfc442a23c5\",\"sort\": 102,\"version\": \"([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\\\\.([0-9]\\\\d*)\"},{\"schema\": \"com.unionpay.tsmservice\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 103,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[2-9].*|^01\\\\.00\\\\.1[012789].*|^01\\\\.00\\\\.0[8-9].*\"},{\"schema\": \"com.unionpay.tsmservice.mi\",\"sign\": \"536C79B93ACFBEA950AE365D8CE1AEF91FEA9535\",\"sort\": 104,\"version\": \"^[1-9].*|^0[2-9].*|^01\\\\.[1-9].*|^01\\\\.0[1-9].*|^01\\\\.00\\\\.[1-9].*|^01\\\\.00\\\\.0[8-9].*\"}],\"sort\": 100,\"type\": \"app\"}]";
        c0 = new b();
    }

    static /* synthetic */ boolean C() {
        U = true;
        return true;
    }

    private static int F() {
        int i2;
        WeakReference weakReference = K;
        if (weakReference == null || weakReference.get() == null) {
            return 1;
        }
        if (TextUtils.isEmpty(F) && TextUtils.isEmpty(G)) {
            I = false;
        } else {
            I = true;
            if (z.equalsIgnoreCase(G)) {
                F = t;
            }
        }
        S = 0;
        T = false;
        U = false;
        try {
            System.loadLibrary("entryexpro");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String c2 = UPUtils.c(G(), "configs" + G);
        String c3 = UPUtils.c(G(), "mode" + G);
        String c4 = UPUtils.c(G(), "or" + G);
        if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(c3) && !TextUtils.isEmpty(c4)) {
            try {
                JSONObject jSONObject = new JSONObject(c2);
                String b2 = com.unionpay.utils.i.b(jSONObject, "sign");
                try {
                    i2 = Integer.parseInt(c3);
                } catch (Exception unused) {
                    i2 = 0;
                }
                String str = new String(Base64.decode(jSONObject.getString("configs"), 2));
                String str2 = "";
                String str3 = jSONObject.has("sePayConf") ? new String(Base64.decode(jSONObject.getString("sePayConf"), 2)) : "";
                if (!TextUtils.isEmpty(str3)) {
                    str2 = str3;
                }
                String k2 = com.unionpay.utils.b.k(UPUtils.d(str + str2 + c4));
                String b3 = UPUtils.b(i2, b2);
                if (!TextUtils.isEmpty(b3) && b3.equals(k2)) {
                    if (TextUtils.isEmpty(G)) {
                        X = str;
                    } else if ("04".equals(G)) {
                        a0 = str;
                    } else {
                        Z = str;
                    }
                    if (!TextUtils.isEmpty(E)) {
                        String c5 = UPUtils.c(G(), "se_configs" + E);
                        if (!TextUtils.isEmpty(c5)) {
                            t(c5);
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }
        try {
            b0 = TextUtils.isEmpty(G) ? o(new JSONArray(X), "sort") : "04".equals(G) ? o(new JSONArray(a0), "sort") : o(new JSONArray(Z), "sort");
        } catch (Exception unused3) {
        }
        W = new HandlerDelegate(c0);
        if (TextUtils.isEmpty(G) || !com.unionpay.utils.b.g()) {
            r("0");
        } else {
            n36.f fVar = new n36.f(G());
            W.sendEmptyMessageDelayed(1004, 1000L);
            fVar.m("UNIONONLINEPAY", new i());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context G() {
        WeakReference weakReference = K;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    public static int H(Context context, String str, String str2, String str3, String str4) {
        return a(context, str, str2, str3, str4, "", "");
    }

    private static int a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        K = new WeakReference(context);
        L = str3;
        M = str;
        N = str2;
        O = str4;
        G = str6;
        F = str5;
        H = TextUtils.isEmpty(str6) ? "0" : "1";
        A = null;
        B = null;
        C = null;
        E = str6;
        F();
        return 0;
    }

    static String c(Context context) {
        return e(context, true, "0");
    }

    private static String d(Context context, int i2, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("v", "1.5");
            jSONObject.put("os_name", "android");
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("tn", UPUtils.h(i2, com.unionpay.utils.b.k(str)));
            }
            try {
                jSONObject.put("terminal_version", "3.5.15");
                jSONObject.put("os_version", com.unionpay.utils.e.c());
                jSONObject.put("device_model", com.unionpay.utils.e.g());
                jSONObject.put("app_version", com.unionpay.utils.b.n(context, str2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("package_name", str2);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    private static String e(Context context, boolean z2, String str) {
        return n(context, O, z2 ? null : L, z2 ? "0" : null, str, H, E);
    }

    static void h() {
    }

    static /* synthetic */ void i(Context context, JSONArray jSONArray, int i2) {
        while (jSONArray != null && i2 < jSONArray.length()) {
            Object a2 = com.unionpay.utils.i.a(jSONArray, i2);
            if (a2 == null) {
                return;
            }
            JSONObject jSONObject = (JSONObject) a2;
            String b2 = com.unionpay.utils.i.b(jSONObject, "type");
            if ("app".equals(b2)) {
                JSONArray c2 = com.unionpay.utils.i.c(jSONObject, "package_info");
                String b3 = com.unionpay.utils.i.b(jSONObject, "app_server");
                JSONArray o2 = o(c2, "sort");
                boolean z2 = false;
                if (o2.length() > 0) {
                    int length = o2.length();
                    int i3 = 0;
                    boolean z3 = false;
                    while (true) {
                        if (i3 >= length) {
                            z2 = z3;
                            break;
                        }
                        Object a3 = com.unionpay.utils.i.a(o2, i3);
                        if (a3 != null) {
                            JSONObject jSONObject2 = (JSONObject) a3;
                            String b4 = com.unionpay.utils.i.b(jSONObject2, "schema");
                            String b5 = com.unionpay.utils.i.b(jSONObject2, "sign");
                            String b6 = com.unionpay.utils.i.b(jSONObject2, Constants.VERSION);
                            if (com.unionpay.utils.b.h(context, b4) && b5.equalsIgnoreCase(com.unionpay.utils.b.l(context, b4)) && com.unionpay.utils.b.n(context, b4).matches(b6)) {
                                try {
                                    Bundle bundle = new Bundle();
                                    k(L, bundle, O);
                                    bundle.putString(a, M);
                                    bundle.putString(d, N);
                                    bundle.putString(b, L);
                                    bundle.putString(s, F);
                                    bundle.putString(u, G);
                                    if (!TextUtils.isEmpty(G)) {
                                        bundle.putString(v, A);
                                        bundle.putString(w, B);
                                        bundle.putString(x, C);
                                        bundle.putString(y, D);
                                    }
                                    bundle.putBoolean(l, I);
                                    bundle.putString(r, b3);
                                    bundle.putString(f, null);
                                    bundle.putInt(i, 0);
                                    Intent intent = new Intent();
                                    intent.putExtras(bundle);
                                    if (o.equals(b4)) {
                                        intent.setAction(p);
                                        intent.setPackage(b4);
                                    } else {
                                        intent.setClassName(b4, n);
                                    }
                                    Context G2 = G();
                                    if (G2 != null) {
                                        if (G2 instanceof Activity) {
                                            ((Activity) G2).startActivityForResult(intent, J);
                                        } else {
                                            intent.addFlags(268435456);
                                            G2.startActivity(intent);
                                        }
                                    }
                                    try {
                                        int c3 = com.unionpay.utils.b.c(O);
                                        String k2 = UPUtils.k(c3);
                                        com.unionpay.utils.j.b("uppay", "calling app url: " + k2);
                                        V = new zj6.d(k2, (byte) 0);
                                        V.b(d(G(), c3, L, b4));
                                        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("UPPayAssistEx"), "com.unionpay.UPPayAssistEx").execute(new j());
                                        z2 = true;
                                        break;
                                    } catch (Exception e2) {
                                        e = e2;
                                        z3 = true;
                                        e.printStackTrace();
                                        i3++;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            }
                        }
                        i3++;
                    }
                }
                if (z2) {
                    return;
                }
            } else {
                String str = "";
                if ("wap".equals(b2)) {
                    if (!t.equals(F)) {
                        try {
                            str = (String) jSONObject.get("url");
                        } catch (Exception unused) {
                        }
                        l(str, "wap");
                        return;
                    }
                } else if ("link".equals(b2)) {
                    try {
                        str = jSONObject.getString("url");
                    } catch (Exception unused2) {
                    }
                    l(str, "link");
                    return;
                } else {
                    if ("wcd".equals(b2)) {
                        try {
                            str = jSONObject.getString("url");
                        } catch (Exception unused3) {
                        }
                        l(str, "wcd");
                        return;
                    }
                    context = G();
                }
            }
            jSONArray = b0;
            i2 = S + 1;
            S = i2;
        }
    }

    private static void k(String str, Bundle bundle, String str2) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        if (str.trim().charAt(0) != '<') {
            bundle.putString(q, str2);
        } else if (str2 == null || !str2.trim().equalsIgnoreCase("00")) {
            bundle.putBoolean(e, true);
        } else {
            bundle.putBoolean(e, false);
        }
    }

    private static void l(String str, String str2) {
        int i2;
        Bundle bundle = new Bundle();
        if (!"link".equals(str2)) {
            k(L, bundle, O);
            bundle.putString(a, M);
            bundle.putString(d, N);
            try {
                i2 = Integer.parseInt(O);
            } catch (Exception unused) {
                i2 = 0;
            }
            if ("wcd".equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("os", "android");
                    jSONObject.put("tn", L);
                    bundle.putString(b, UPUtils.h(i2, com.unionpay.utils.b.k(jSONObject.toString())));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                bundle.putString(b, UPUtils.h(i2, com.unionpay.utils.b.k(L)));
            }
            bundle.putString(c, L);
        }
        bundle.putString("magic_data", "949A1CC");
        bundle.putString(j, str);
        bundle.putString(k, str2);
        try {
            Context G2 = G();
            if (G2 != null) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(G2, UPPayWapActivity.class);
                if (G2 instanceof Activity) {
                    ((Activity) G2).startActivityForResult(intent, J);
                } else {
                    intent.addFlags(268435456);
                    G2.startActivity(intent);
                }
            }
        } catch (Exception unused2) {
        }
    }

    private static String n(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        int i2;
        int i3;
        Resources resources;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("v", "1.5");
            jSONObject.put("sdkVerMode", "02");
            jSONObject.put("os_name", "android");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("tn", UPUtils.h(com.unionpay.utils.b.c(str), com.unionpay.utils.b.k(str2)));
            }
            jSONObject.put("appUuId", com.unionpay.utils.e.h(context));
            try {
                jSONObject.put("locale", Locale.getDefault().toString().startsWith("zh") ? "zh_CN" : "en_US");
                jSONObject.put("terminal_version", "3.5.15");
                if (context == null || (resources = context.getResources()) == null) {
                    i2 = 0;
                    i3 = 0;
                } else {
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i2 = displayMetrics.widthPixels;
                    i3 = displayMetrics.heightPixels;
                }
                jSONObject.put("terminal_resolution", (i2 + "*" + i3).trim());
                jSONObject.put("os_version", com.unionpay.utils.e.c());
                jSONObject.put("device_model", com.unionpay.utils.e.g());
                jSONObject.put("root", new PolarisFileWrapper("/system/bin/su").exists() ? "1" : "0");
                jSONObject.put("country", com.unionpay.utils.b.o(Locale.getDefault().getCountry()));
                jSONObject.put("package", com.unionpay.utils.b.o(com.unionpay.utils.e.d(context)));
                jSONObject.put("sign", com.unionpay.utils.e.e(context, com.unionpay.utils.b.o(com.unionpay.utils.e.d(context)), "SHA256"));
                String str7 = Build.MANUFACTURER;
                if (!TextUtils.isEmpty(str7)) {
                    str7 = str7.toUpperCase();
                }
                jSONObject.put("phone_model", str7);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            jSONObject.put("vendorCapacity", str4);
            if (!TextUtils.isEmpty(null)) {
                jSONObject.put("randKey", UPUtils.h(com.unionpay.utils.b.c(str), com.unionpay.utils.b.k(null)));
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("has_sdk", str3);
            }
            if (!TextUtils.isEmpty(null)) {
                jSONObject.put("merId", (Object) null);
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject.put("isLimitSe", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                jSONObject.put("seType", com.unionpay.utils.b.m(str6));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONArray o(JSONArray jSONArray, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; jSONArray != null && i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optJSONObject(i2));
        }
        Collections.sort(arrayList, new k(str));
        JSONArray jSONArray2 = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            jSONArray2.put((JSONObject) arrayList.get(i3));
        }
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(String str) {
        int i2;
        try {
            i2 = Integer.parseInt(O);
        } catch (Exception unused) {
            i2 = 0;
        }
        String a2 = UPUtils.a(i2);
        com.unionpay.utils.j.b("uppay", "url: " + a2);
        V = new zj6.d(a2, (byte) 0);
        V.b(e(G(), false, str));
        if (W == null) {
            W = new HandlerDelegate(c0);
        }
        PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("UPPayAssistEx"), "com.unionpay.UPPayAssistEx").execute(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void t(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            A = jSONObject.getString("titleLogo");
            B = jSONObject.getString("loadingLogo");
            C = jSONObject.getString("backGroundColor");
            D = jSONObject.getString("textColor");
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ boolean z() {
        T = true;
        return true;
    }
}
