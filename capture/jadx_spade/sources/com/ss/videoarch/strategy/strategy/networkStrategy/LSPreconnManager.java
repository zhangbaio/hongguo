package com.ss.videoarch.strategy.strategy.networkStrategy;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnDataHandle;
import com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnTask;
import com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LSPreconnManager {
    public d g;
    public e h;
    private String a = null;
    private Context b = null;
    private boolean c = false;
    private boolean d = false;
    private LSPreconnDataHandle e = new LSPreconnDataHandle();
    private final com.ss.videoarch.strategy.network.e f = new com.ss.videoarch.strategy.network.e();
    private LSPreconnTask.a i = new a();

    public interface d {
        String a(String str);
    }

    static {
        Covode.recordClassIndex(653172);
    }

    private static class c {
        private static final LSPreconnManager a;

        static {
            Covode.recordClassIndex(653174);
            a = new LSPreconnManager();
        }
    }

    public static LSPreconnManager h() {
        return c.a;
    }

    enum PROTOCOL {
        QUIC,
        H2Q;

        static {
            Covode.recordClassIndex(653176);
        }
    }

    private boolean a() {
        Boolean bool = Boolean.TRUE;
        try {
            Class q = l3.a.q("com.ss.videoarch.live.ttquic.ContextUtils");
            if (q != null) {
                Method method = q.getMethod("initApplicationContext", Context.class);
                method.setAccessible(true);
                method.invoke(null, this.b.getApplicationContext());
            }
            Class q2 = l3.a.q("com.ss.videoarch.live.ttquic.JNIUtils");
            if (q2 != null) {
                Method method2 = q2.getMethod("setClassLoader", ClassLoader.class);
                method2.setAccessible(true);
                method2.invoke(null, this.b.getClassLoader());
            }
        } catch (Throwable th) {
            Boolean bool2 = Boolean.FALSE;
            Log.e("LSPreconnManager", "disable quic cert verify, " + th.toString());
            bool = bool2;
        }
        boolean booleanValue = bool.booleanValue();
        this.c = booleanValue;
        return booleanValue;
    }

    public class b {
        private String a = "";
        private String b = "";
        PROTOCOL c;

        static {
            Covode.recordClassIndex(653173);
        }

        public b() {
        }
    }

    class a implements LSPreconnTask.a {
        a() {
        }

        @Override // com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnTask.a
        public void a(String str, String str2, int i) {
            synchronized (LSPreconnManager.class) {
                Log.d("LSPreconnManager", "connect callback host: " + str + "ip: " + str2 + " ret: " + i);
                if (!LSPreconnManager.this.d && i == 0) {
                    LSPreconnManager.this.d = true;
                }
                if (LSPreconnManager.this.h != null) {
                    LSPreconnManager.this.h.a(new e.a(str, str2, i));
                }
            }
        }
    }

    private void n(String str) {
        DnsOptimizer.O().T(str);
    }

    public void l(LSPreconnDataHandle.b bVar) {
        this.e.b(bVar);
    }

    public String g(String str) {
        String a2 = this.e.a(str);
        Log.w("LSPreconnManager", "getPreconnIp: " + str + ", " + a2);
        return a2;
    }

    public void k(Context context) {
        this.b = context;
        a();
        this.a = this.b.getFilesDir().getAbsolutePath() + "/pullstream.scfg";
    }

    public void i(String str) {
        boolean z;
        Log.d("LSPreconnManager", "setRoomInfo: type - preprocess: info size " + str.length());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b c2 = c(new JSONObject(new JSONObject(str).optString("stream_info")));
            if (TextUtils.isEmpty(c2.a)) {
                Log.e("LSPreconnManager", "preconnect: get domain failed!");
                return;
            }
            Log.d("LSPreconnManager", "preconnect: get domain successed: " + c2.a);
            d dVar = this.g;
            if (dVar == null) {
                Log.e("LSPreconnManager", "preconnect: dnsListener is null");
                return;
            }
            c2.b = dVar.a(c2.a);
            String str2 = c2.a;
            String str3 = c2.b;
            if (c2.c == PROTOCOL.QUIC) {
                z = true;
            } else {
                z = false;
            }
            b(str2, str3, z);
        } catch (JSONException e2) {
            Log.e("LSPreconnManager", "preconnect: " + e2.toString());
        }
    }

    private b c(JSONObject jSONObject) {
        JSONObject jSONObject2;
        b bVar = new b();
        JSONObject jSONObject3 = null;
        try {
            JSONObject jSONObject4 = jSONObject.getJSONObject("data");
            jSONObject2 = jSONObject4.getJSONObject("origin").getJSONObject("main");
            try {
                JSONObject jSONObject5 = new JSONObject(jSONObject2.optString("sdk_params"));
                try {
                    String optString = jSONObject5.optString("SuggestFormat");
                    String optString2 = jSONObject5.optString("SuggestProtocol");
                    Log.d("LSPreconnManager", "__getConnectionInfoFromStreamInfo resolutionList: " + jSONObject4);
                    Log.d("LSPreconnManager", "__getConnectionInfoFromStreamInfo resolutionInfo: " + jSONObject2);
                    Log.d("LSPreconnManager", "__getConnectionInfoFromStreamInfo suggestFormat: " + optString + " suggestProtocol: " + optString2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("__getConnectionInfoFromStreamInfo sdkParamsJson: ");
                    sb.append(jSONObject5);
                    Log.d("LSPreconnManager", sb.toString());
                    if (TextUtils.isEmpty(optString2) && lj6.a.m().r.e.mUseH2QByDefault == 1) {
                        optString2 = "h2q";
                    }
                    if (optString2.equals("quic")) {
                        bVar.c = PROTOCOL.QUIC;
                    } else if (optString2.equals("h2q")) {
                        bVar.c = PROTOCOL.H2Q;
                    } else {
                        Log.d("LSPreconnManager", "not quic or h2q:" + bVar.c);
                        return bVar;
                    }
                    bVar.a = new URL(jSONObject2.optString(optString)).getHost();
                    n(bVar.a);
                } catch (MalformedURLException | JSONException e2) {
                    e = e2;
                    jSONObject3 = jSONObject5;
                    Log.e("LSPreconnManager", "__getConnectionInfoFromStreamInfo urlstr:  sdkParams:" + jSONObject3 + " resInfo:" + jSONObject2);
                    e.printStackTrace();
                    return bVar;
                }
            } catch (MalformedURLException e3) {
                e = e3;
            } catch (JSONException e4) {
                e = e4;
            }
        } catch (MalformedURLException | JSONException e5) {
            e = e5;
            jSONObject2 = null;
        }
        return bVar;
    }

    public void j(String str, String str2) {
        b(str, str2, true);
    }

    public interface e {
        void a(a aVar);

        public static class a {
            public String a;
            public int b;
            public String c;

            static {
                Covode.recordClassIndex(653179);
            }

            a(String str, String str2, int i) {
                this.b = i;
                this.c = str2;
                this.a = str;
            }
        }
    }

    private int b(String str, String str2, boolean z) {
        if (!this.c && a()) {
            Log.d("LSPreconnManager", "The AccessPermission: " + this.c + " :" + this);
            return 0;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            Log.d("LSPreconnManager", "Will start to PreConnect the host: " + str + " ip:" + str2 + " scfg:" + this.a);
            this.f.a(new LSPreconnTask(this.i, str, str2, 80, this.a, z));
            return 0;
        }
        Log.d("LSPreconnManager", "The information is not complete.ip: " + str2 + " domain: " + str);
        return -1;
    }

    public void m(String str, int i, String str2) {
        JSONObject jSONObject;
        JSONException e2;
        JSONObject jSONObject2;
        boolean z;
        String str3;
        int i2;
        String str4;
        int i3;
        String str5;
        Log.i("LSPreconnManager", "networkType:" + str2 + ", suggestSendingRate:" + i);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LSPreconnDataHandle.a aVar = new LSPreconnDataHandle.a();
        aVar.e = i;
        aVar.f = str2;
        JSONObject jSONObject3 = null;
        try {
            jSONObject2 = new JSONObject(new JSONObject(str).optString("stream_info")).getJSONObject("data").getJSONObject("origin").getJSONObject("main");
            try {
                jSONObject = new JSONObject(jSONObject2.optString("sdk_params"));
                try {
                    if (jSONObject.has("EnableLiveStartingOpt")) {
                        z = true;
                        if (jSONObject.optInt("EnableLiveStartingOpt") != 1) {
                            z = false;
                        }
                    } else {
                        z = aVar.a;
                    }
                    aVar.a = z;
                    if (jSONObject.has("EnableNetworkClass")) {
                        str3 = jSONObject.optString("EnableNetworkClass");
                    } else {
                        str3 = aVar.b;
                    }
                    aVar.b = str3;
                    if (jSONObject.has("EnableSuggestSendingRate")) {
                        i2 = jSONObject.optInt("EnableSuggestSendingRate");
                    } else {
                        i2 = aVar.c;
                    }
                    aVar.c = i2;
                    if (jSONObject.has("httpx")) {
                        jSONObject3 = jSONObject.optJSONObject("httpx");
                    }
                    if (jSONObject3 != null) {
                        if (jSONObject3.has("HttpConfigJson")) {
                            str4 = jSONObject3.optString("HttpConfigJson");
                        } else {
                            str4 = aVar.d;
                        }
                        aVar.d = str4;
                        if (jSONObject3.has("UseLSQUIC")) {
                            i3 = jSONObject3.optInt("UseLSQUIC");
                        } else {
                            i3 = aVar.g;
                        }
                        aVar.g = i3;
                        if (jSONObject3.has("LSEngineParamJson")) {
                            str5 = jSONObject3.optString("LSEngineParamJson");
                        } else {
                            str5 = aVar.h;
                        }
                        aVar.h = str5;
                    }
                    this.e.c(aVar);
                    Log.i("LSPreconnManager", "enableLiveStartingOpt " + aVar.a + " EnableNetworkClass:" + aVar.b + " EnableSuggestSendingRate:" + aVar.c);
                    StringBuilder sb = new StringBuilder();
                    sb.append("HttpConfigJson ");
                    sb.append(aVar.d);
                    Log.i("LSPreconnManager", sb.toString());
                    Log.i("LSPreconnManager", "UseLSQUIC " + aVar.g);
                    Log.i("LSPreconnManager", "LSEngineParamJson " + aVar.h);
                } catch (JSONException e3) {
                    e2 = e3;
                    Log.e("LSPreconnManager", "setliveStartingTogglesFromStreamInfo  sdkParams:" + jSONObject + " resInfo:" + jSONObject2);
                    e2.printStackTrace();
                }
            } catch (JSONException e4) {
                jSONObject = null;
                e2 = e4;
            }
        } catch (JSONException e5) {
            jSONObject = null;
            e2 = e5;
            jSONObject2 = null;
        }
    }
}
