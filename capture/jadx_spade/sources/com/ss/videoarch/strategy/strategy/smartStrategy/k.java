package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.texturerender.VideoSurface;
import com.ss.texturerender.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class k extends BaseSmartStrategy {
    private static volatile k J;
    private s o;
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    public Handler e = null;
    private List<Integer> f = new ArrayList();
    private int g = 5000;
    private int h = 1280;
    private int i = 600;
    private int j = 0;
    private int k = 0;
    private boolean l = false;
    private final com.ss.videoarch.strategy.network.e m = new com.ss.videoarch.strategy.network.e();
    private List<VideoSurface> n = new CopyOnWriteArrayList();
    private int p = -1;
    private int q = -1;
    private double r = -1.0d;
    private double s = -1.0d;
    private long t = -1;
    private long u = -1;
    private long v = -1;
    private long w = -1;
    private int x = -1;
    private int y = -1;
    private double z = -1.0d;
    private double A = -1.0d;
    private long B = -1;
    private int C = -1;
    private int D = -1;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private List<Integer> H = new ArrayList();
    private int I = -1;

    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            k.this.b(true);
        }

        b() {
        }
    }

    static {
        Covode.recordClassIndex(653215);
        J = null;
    }

    public static k g() {
        if (J == null) {
            synchronized (k.class) {
                if (J == null) {
                    J = new k();
                }
            }
        }
        return J;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable_sr", this.C);
            jSONObject.put("sr_type", this.E);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ ji6.d f;

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Bundle bundle = new Bundle();
            bundle.putInt("effect_type", 5);
            bundle.putInt("action", 21);
            bundle.putInt("srAlgType", this.a);
            bundle.putInt("srMaxSizeWidth", this.b);
            bundle.putInt("srMaxSizeHeight", this.c);
            bundle.putString("kernelBinPath", this.d);
            bundle.putString("oclModleName", "test");
            bundle.putString("dspModleName", "test");
            if (this.e == 1) {
                z = true;
            } else {
                z = false;
            }
            bundle.putBoolean("srIsMaliSync", z);
            VideoSurface c = k.this.o.c(this.f, 1);
            if (c != null) {
                Log.d("DynamicSRPredictEngine", "init sr in strategy sdk");
                c.setEffect(bundle);
            }
        }

        a(int i, int i2, int i3, String str, int i4, ji6.d dVar) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = str;
            this.e = i4;
            this.f = dVar;
        }
    }

    public void i() {
        JSONObject jSONObject = lj6.a.m().b;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("BatchSettingsParams")) {
                    String optString = jSONObject.optJSONObject("BatchSettingsParams").optJSONObject("live_stream_strategy_engine").optString("2");
                    if (optString != null && optString.startsWith("\ufeff")) {
                        optString = optString.substring(1);
                    }
                    JSONObject optJSONObject = new JSONObject(optString).optJSONObject("SRConfig");
                    if (optJSONObject != null) {
                        h(optJSONObject);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void f() {
        String str = (String) lj6.a.m().b("SCREEN_RESOLTION", "{}");
        Log.d("DynamicSRPredictEngine", "screenInfo: " + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.p = jSONObject.optInt("width");
                this.q = jSONObject.optInt("height");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.b = ((Integer) lj6.a.m().b("live_stream_strategy_enable_sr_asyncinit", 0)).intValue();
        this.c = ((Integer) lj6.a.m().b("live_stream_strategy_enable_dynamic_sr", 0)).intValue();
        String str2 = (String) lj6.a.m().b("live_stream_strategy_sr_config", "{}");
        Log.d("DynamicSRPredictEngine", "enable sr async init: " + this.b + ", enable dynamic sr: " + this.c + ", srConfig: " + str2);
        try {
            if (!TextUtils.isEmpty(str2)) {
                h(new JSONObject(str2));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.b == 1) {
            String str3 = (String) lj6.a.m().b("live_stream_strategy_sr_kernal_bin_path", "none");
            Log.d("DynamicSRPredictEngine", "sr kernal bin path: " + str3);
            this.o = s.h();
            c(this.j, str3, this.h, this.i, this.k);
        }
        this.l = true;
    }

    public void b(boolean z) {
        d(z);
        if (!this.H.isEmpty()) {
            this.e.sendEmptyMessageDelayed(1025, this.H.get(0).intValue() * 1000);
            this.H.remove(0);
        }
    }

    public void setSupportSRScene(boolean z) {
        if (this.I == 0 && z && this.C != 0 && !this.n.isEmpty()) {
            for (VideoSurface videoSurface : this.n) {
                if (videoSurface != null) {
                    Log.d("DynamicSRPredictEngine", "recover open sr mode");
                    videoSurface.setSuperResolutionMode(1);
                }
            }
        }
        this.I = z ? 1 : 0;
    }

    public void stopSession(JSONObject jSONObject) {
        if (this.l && this.c != 0 && jSONObject != null) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(1025);
            }
            Object opt = jSONObject.opt("textureSurface");
            if (opt != null && (opt instanceof VideoSurface)) {
                this.n.remove((VideoSurface) opt);
            }
        }
    }

    public void h(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Log.d("DynamicSRPredictEngine", "parse dynamic sr config json: " + jSONObject);
        try {
            if (jSONObject.has("EnableSRAsyncInit")) {
                this.b = jSONObject.optInt("EnableSRAsyncInit", 0);
            }
            if (this.b == 1) {
                this.h = jSONObject.optInt("MaxTextureWidth", 1280);
                this.i = jSONObject.optInt("MaxTextureHeight", 600);
                this.j = jSONObject.optInt("MaxAlgorithumType", 0);
                this.k = jSONObject.optInt("OpenMaliSync", 1);
            }
            if (jSONObject.has("EnableDynamicSRPredict")) {
                this.c = jSONObject.optInt("EnableDynamicSRPredict", 0);
            }
            if (this.c == 1) {
                this.a = jSONObject.optInt("EnableSRPredictAlgorithum", 0);
                this.r = jSONObject.optDouble("HighCpuRate", -1.0d);
                this.s = jSONObject.optDouble("LowCpuRate", -1.0d);
                this.t = jSONObject.optLong("HighAvaliableMem", -1L);
                this.u = jSONObject.optLong("LowAvaliableMem", -1L);
                this.v = jSONObject.optLong("HighTotalMem", -1L);
                this.w = jSONObject.optLong("LowTotalMem", -1L);
                this.x = jSONObject.optInt("HighBatteryLevel", -1);
                this.y = jSONObject.optInt("LowBatteryLevel", -1);
                this.z = jSONObject.optDouble("HighTemperature", -1.0d);
                this.A = jSONObject.optDouble("LowTemperature", -1.0d);
                if (jSONObject.has("PredictTimeList") && (optJSONArray = jSONObject.optJSONArray("PredictTimeList")) != null) {
                    if (!this.f.isEmpty()) {
                        this.f.clear();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.f.add(Integer.valueOf(optJSONArray.getInt(i)));
                    }
                }
                this.g = jSONObject.optInt("PredictMinInterval", 5000);
            }
            this.d = jSONObject.optInt("ScreenResControl", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void triggerSRPredict(JSONObject jSONObject) {
        Log.d("DynamicSRPredictEngine", "enter triggerSRPredict, sessionInfo: " + jSONObject);
        if (this.c != 0 && jSONObject != null && this.l) {
            this.D = this.C;
            this.H.clear();
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(1025);
            }
            Object opt = jSONObject.opt("textureSurface");
            if (opt != null && (opt instanceof VideoSurface)) {
                this.n.add((VideoSurface) opt);
            }
            this.F = this.j;
            if (this.d == 1) {
                if (this.p <= 0 || this.q <= 0) {
                    String str = (String) lj6.a.m().b("SCREEN_RESOLTION", "{}");
                    Log.d("DynamicSRPredictEngine", "screenInfo: " + str);
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(str);
                            this.p = jSONObject2.optInt("width");
                            this.q = jSONObject2.optInt("height");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (this.p > 0 && this.q > 0) {
                    int optInt = jSONObject.optInt("width");
                    int optInt2 = jSONObject.optInt("height");
                    if (optInt > 0 && optInt2 > 0) {
                        int i = this.j;
                        if (i == 0) {
                            if (optInt * 2 > this.p || optInt2 * 2 > this.q) {
                                this.C = 0;
                                Log.d("DynamicSRPredictEngine", "screen resolution not support open sr, close sr");
                                return;
                            }
                        } else if (i == 4 && ((optInt * 3) / 2 > this.p || (optInt2 * 3) / 2 > this.q)) {
                            this.C = 0;
                            Log.d("DynamicSRPredictEngine", "screen resolution not support open 1.5x, close sr");
                            return;
                        }
                    }
                }
            }
            this.H.addAll(this.f);
            if (!this.H.isEmpty()) {
                this.G = this.H.get(0).intValue();
                this.H.remove(0);
            }
            Handler handler2 = this.e;
            if (handler2 != null) {
                if (this.G > 0) {
                    this.C = 0;
                }
                handler2.postDelayed(new b(), this.G * 1000);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x018f, code lost:
    
        if (r18 < r24.r) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0290 A[Catch: JSONException -> 0x034b, TryCatch #0 {JSONException -> 0x034b, blocks: (B:31:0x00ae, B:33:0x00c2, B:35:0x00cd, B:36:0x00d4, B:38:0x00da, B:39:0x00e6, B:41:0x00f4, B:43:0x00ff, B:44:0x0106, B:46:0x010c, B:47:0x0119, B:49:0x0125, B:51:0x0130, B:52:0x0137, B:54:0x0143, B:56:0x014e, B:61:0x02d1, B:63:0x030a, B:64:0x0310, B:66:0x0316, B:73:0x0322, B:69:0x032c, B:76:0x0336, B:85:0x016e, B:87:0x0173, B:91:0x017c, B:96:0x018b, B:99:0x01b2, B:101:0x01c2, B:103:0x01c8, B:107:0x01d2, B:109:0x01d8, B:111:0x01dc, B:113:0x0288, B:115:0x0290, B:116:0x0296, B:118:0x029c, B:126:0x02aa, B:122:0x02b1, B:130:0x02b9, B:135:0x01bc, B:137:0x0191, B:139:0x0197, B:143:0x01a1, B:145:0x01a7, B:147:0x01ab, B:153:0x01ea, B:155:0x01fa, B:157:0x0200, B:161:0x020a, B:163:0x0210, B:165:0x0214, B:168:0x01f4, B:170:0x0218, B:174:0x0223, B:176:0x0233, B:178:0x0239, B:182:0x0243, B:184:0x0249, B:186:0x024d, B:189:0x022d, B:195:0x0259, B:197:0x0269, B:199:0x026f, B:203:0x0279, B:205:0x027f, B:207:0x0283, B:210:0x0263), top: B:30:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0218 A[Catch: JSONException -> 0x034b, TryCatch #0 {JSONException -> 0x034b, blocks: (B:31:0x00ae, B:33:0x00c2, B:35:0x00cd, B:36:0x00d4, B:38:0x00da, B:39:0x00e6, B:41:0x00f4, B:43:0x00ff, B:44:0x0106, B:46:0x010c, B:47:0x0119, B:49:0x0125, B:51:0x0130, B:52:0x0137, B:54:0x0143, B:56:0x014e, B:61:0x02d1, B:63:0x030a, B:64:0x0310, B:66:0x0316, B:73:0x0322, B:69:0x032c, B:76:0x0336, B:85:0x016e, B:87:0x0173, B:91:0x017c, B:96:0x018b, B:99:0x01b2, B:101:0x01c2, B:103:0x01c8, B:107:0x01d2, B:109:0x01d8, B:111:0x01dc, B:113:0x0288, B:115:0x0290, B:116:0x0296, B:118:0x029c, B:126:0x02aa, B:122:0x02b1, B:130:0x02b9, B:135:0x01bc, B:137:0x0191, B:139:0x0197, B:143:0x01a1, B:145:0x01a7, B:147:0x01ab, B:153:0x01ea, B:155:0x01fa, B:157:0x0200, B:161:0x020a, B:163:0x0210, B:165:0x0214, B:168:0x01f4, B:170:0x0218, B:174:0x0223, B:176:0x0233, B:178:0x0239, B:182:0x0243, B:184:0x0249, B:186:0x024d, B:189:0x022d, B:195:0x0259, B:197:0x0269, B:199:0x026f, B:203:0x0279, B:205:0x027f, B:207:0x0283, B:210:0x0263), top: B:30:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0143 A[Catch: JSONException -> 0x034b, TryCatch #0 {JSONException -> 0x034b, blocks: (B:31:0x00ae, B:33:0x00c2, B:35:0x00cd, B:36:0x00d4, B:38:0x00da, B:39:0x00e6, B:41:0x00f4, B:43:0x00ff, B:44:0x0106, B:46:0x010c, B:47:0x0119, B:49:0x0125, B:51:0x0130, B:52:0x0137, B:54:0x0143, B:56:0x014e, B:61:0x02d1, B:63:0x030a, B:64:0x0310, B:66:0x0316, B:73:0x0322, B:69:0x032c, B:76:0x0336, B:85:0x016e, B:87:0x0173, B:91:0x017c, B:96:0x018b, B:99:0x01b2, B:101:0x01c2, B:103:0x01c8, B:107:0x01d2, B:109:0x01d8, B:111:0x01dc, B:113:0x0288, B:115:0x0290, B:116:0x0296, B:118:0x029c, B:126:0x02aa, B:122:0x02b1, B:130:0x02b9, B:135:0x01bc, B:137:0x0191, B:139:0x0197, B:143:0x01a1, B:145:0x01a7, B:147:0x01ab, B:153:0x01ea, B:155:0x01fa, B:157:0x0200, B:161:0x020a, B:163:0x0210, B:165:0x0214, B:168:0x01f4, B:170:0x0218, B:174:0x0223, B:176:0x0233, B:178:0x0239, B:182:0x0243, B:184:0x0249, B:186:0x024d, B:189:0x022d, B:195:0x0259, B:197:0x0269, B:199:0x026f, B:203:0x0279, B:205:0x027f, B:207:0x0283, B:210:0x0263), top: B:30:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0173 A[Catch: JSONException -> 0x034b, TryCatch #0 {JSONException -> 0x034b, blocks: (B:31:0x00ae, B:33:0x00c2, B:35:0x00cd, B:36:0x00d4, B:38:0x00da, B:39:0x00e6, B:41:0x00f4, B:43:0x00ff, B:44:0x0106, B:46:0x010c, B:47:0x0119, B:49:0x0125, B:51:0x0130, B:52:0x0137, B:54:0x0143, B:56:0x014e, B:61:0x02d1, B:63:0x030a, B:64:0x0310, B:66:0x0316, B:73:0x0322, B:69:0x032c, B:76:0x0336, B:85:0x016e, B:87:0x0173, B:91:0x017c, B:96:0x018b, B:99:0x01b2, B:101:0x01c2, B:103:0x01c8, B:107:0x01d2, B:109:0x01d8, B:111:0x01dc, B:113:0x0288, B:115:0x0290, B:116:0x0296, B:118:0x029c, B:126:0x02aa, B:122:0x02b1, B:130:0x02b9, B:135:0x01bc, B:137:0x0191, B:139:0x0197, B:143:0x01a1, B:145:0x01a7, B:147:0x01ab, B:153:0x01ea, B:155:0x01fa, B:157:0x0200, B:161:0x020a, B:163:0x0210, B:165:0x0214, B:168:0x01f4, B:170:0x0218, B:174:0x0223, B:176:0x0233, B:178:0x0239, B:182:0x0243, B:184:0x0249, B:186:0x024d, B:189:0x022d, B:195:0x0259, B:197:0x0269, B:199:0x026f, B:203:0x0279, B:205:0x027f, B:207:0x0283, B:210:0x0263), top: B:30:0x00ae }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(boolean r25) {
        /*
            Method dump skipped, instructions count: 848
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.smartStrategy.k.d(boolean):void");
    }

    public void c(int i, String str, int i2, int i3, int i4) {
        if (this.o == null) {
            Log.e("DynamicSRPredictEngine", "couldn't get rendererManager");
            return;
        }
        ji6.d dVar = new ji6.d(1);
        dVar.e(true);
        if (!this.o.j(dVar, 1)) {
            this.m.a(new a(i, i2, i3, str, i4, dVar));
        }
    }
}
