package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.os.Bundle;
import android.os.Handler;
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
public class l extends BaseSmartStrategy {
    private static volatile l B;
    private static int C;
    private static int D;
    private static int E;
    private static int F;
    private static int G;
    private static int H;
    private static int I;
    private s k;
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    public Handler e = null;
    private List<Integer> f = new ArrayList();
    private int g = 5000;
    private boolean h = false;
    private final com.ss.videoarch.strategy.network.e i = new com.ss.videoarch.strategy.network.e();
    private List<VideoSurface> j = new CopyOnWriteArrayList();
    private int l = -1;
    private int m = -1;
    private double n = -1.0d;
    private double o = -1.0d;
    private long p = -1;
    private long q = -1;
    private double r = -1.0d;
    private double s = -1.0d;
    private double t = -1.0d;
    private long u = -1;
    private int v = -1;
    private int w = -1;
    private int x = 0;
    private int y = 0;
    private List<Integer> z = new ArrayList();
    private int A = -1;

    class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            l.this.b(true);
        }

        b() {
        }
    }

    public boolean e() {
        if (this.c == 1) {
            return true;
        }
        return false;
    }

    class a implements Runnable {
        final /* synthetic */ ji6.d a;
        final /* synthetic */ Bundle b;

        @Override // java.lang.Runnable
        public void run() {
            VideoSurface c = l.this.k.c(this.a, 1);
            if (c != null) {
                Log.d("SuperResolutionStrategy", "init sr in strategy sdk");
                c.setEffect(this.b);
            }
        }

        a(ji6.d dVar, Bundle bundle) {
            this.a = dVar;
            this.b = bundle;
        }
    }

    static {
        Covode.recordClassIndex(653216);
        B = null;
        C = 1;
        D = 2;
        E = 3;
        F = 4;
        G = 5;
        H = 6;
        I = 7;
    }

    public static l g() {
        if (B == null) {
            synchronized (l.class) {
                if (B == null) {
                    B = new l();
                }
            }
        }
        return B;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable_sr", this.v);
            jSONObject.put("sr_type", this.x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private l() {
        this.mStrategyName = "live_stream_strategy_super_resolution";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_super_resolution";
        }
    }

    public void h() {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        boolean z;
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null && (jSONObject = dVar.h) != null) {
            try {
                this.b = jSONObject.optInt("EnableSRAysncInit", 0);
                this.c = this.mStrategyConfigInfo.h.optInt("EnableDynamicSR", 0);
                Log.i("SuperResolutionStrategy", "enable sr async init: " + this.b + ", enable dynamic sr: " + this.c);
                if (this.b == 1 && (optJSONObject = this.mStrategyConfigInfo.h.optJSONObject("SRAysncInitConfig")) != null) {
                    int optInt = optJSONObject.optInt("ShorterSideUpperBound", 1300);
                    int optInt2 = optJSONObject.optInt("LongerSideUpperBound", 750);
                    int optInt3 = optJSONObject.optInt("SRAlgType", 0);
                    this.x = optInt3;
                    int optInt4 = optJSONObject.optInt("OpenMaliSync", 1);
                    int optInt5 = optJSONObject.optInt("EnableBMFSR");
                    int optInt6 = optJSONObject.optInt("BMFSRBackEnd");
                    int optInt7 = optJSONObject.optInt("BMFSRScaleType");
                    int optInt8 = optJSONObject.optInt("BMFSRPoolSize");
                    String str = (String) lj6.a.m().b("live_stream_strategy_sr_kernal_bin_path", "none");
                    Bundle bundle = new Bundle();
                    bundle.putInt("effect_type", 5);
                    bundle.putInt("action", 21);
                    bundle.putInt("srAlgType", optInt3);
                    bundle.putInt("srMaxSizeWidth", optInt);
                    bundle.putInt("srMaxSizeHeight", optInt2);
                    bundle.putString("kernelBinPath", str);
                    bundle.putString("oclModleName", "test");
                    bundle.putString("dspModleName", "test");
                    if (optInt4 == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bundle.putBoolean("srIsMaliSync", z);
                    bundle.putInt("enable_bmf", optInt5);
                    if (optInt5 == 1) {
                        bundle.putInt("sr_backend", optInt6);
                        bundle.putInt("scale_type", optInt7);
                        bundle.putInt("pool_size", optInt8);
                        bundle.putString("programCacheDir", str);
                    }
                    c(bundle);
                }
                if (this.c == 1) {
                    this.a = this.mStrategyConfigInfo.h.optInt("EnableSRPredictAlgorithum", 0);
                    this.o = this.mStrategyConfigInfo.h.optDouble("GpuUsageThres", -1.0d);
                    this.n = this.mStrategyConfigInfo.h.optDouble("CpuRateThres", -1.0d);
                    this.p = this.mStrategyConfigInfo.h.optLong("AvaliableMemThres", -1L);
                    this.q = this.mStrategyConfigInfo.h.optLong("TotalMemThres", -1L);
                    this.r = this.mStrategyConfigInfo.h.optDouble("BatteryLevelThres", -1.0d);
                    this.s = this.mStrategyConfigInfo.h.optDouble("TemperatureThres", -1.0d);
                    this.t = this.mStrategyConfigInfo.h.optDouble("FpsThres", -1.0d);
                    if (this.mStrategyConfigInfo.h.has("PredictTimeList") && (optJSONArray = this.mStrategyConfigInfo.h.optJSONArray("PredictTimeList")) != null) {
                        if (!this.f.isEmpty()) {
                            this.f.clear();
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            this.f.add(Integer.valueOf(optJSONArray.getInt(i)));
                        }
                    }
                    this.g = this.mStrategyConfigInfo.h.optInt("PredictMinInterval", 20000);
                }
                this.d = this.mStrategyConfigInfo.h.optInt("ScreenResControl", 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.h = true;
        }
    }

    public void b(boolean z) {
        d(z);
        if (!this.z.isEmpty()) {
            this.e.sendEmptyMessageDelayed(1025, this.z.get(0).intValue());
            this.z.remove(0);
        }
    }

    public void c(Bundle bundle) {
        if (this.k == null) {
            Log.e("SuperResolutionStrategy", "couldn't get rendererManager");
            return;
        }
        ji6.d dVar = new ji6.d(1);
        dVar.e(true);
        if (!this.k.j(dVar, 1)) {
            this.i.a(new a(dVar, bundle));
        }
    }

    public void setSupportSRScene(boolean z) {
        if (this.A == 0 && z && this.v != 0 && !this.j.isEmpty()) {
            for (VideoSurface videoSurface : this.j) {
                if (videoSurface != null) {
                    Log.d("SuperResolutionStrategy", "recover open sr mode");
                    videoSurface.setSuperResolutionMode(1);
                }
            }
        }
        this.A = z ? 1 : 0;
    }

    public void stopSession(JSONObject jSONObject) {
        if (this.h && this.c != 0 && jSONObject != null) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(1025);
            }
            Object opt = jSONObject.opt("textureSurface");
            if (opt != null && (opt instanceof VideoSurface)) {
                this.j.remove((VideoSurface) opt);
            }
        }
    }

    public void triggerSRPredict(JSONObject jSONObject) {
        Log.d("SuperResolutionStrategy", "enter triggerSRPredict, sessionInfo: " + jSONObject);
        if (this.c != 0 && jSONObject != null && this.h) {
            this.w = this.v;
            this.z.clear();
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(1025);
            }
            Object opt = jSONObject.opt("textureSurface");
            if (opt != null && (opt instanceof VideoSurface)) {
                this.j.add((VideoSurface) opt);
            }
            this.z.addAll(this.f);
            if (!this.z.isEmpty()) {
                this.y = this.z.get(0).intValue();
                this.z.remove(0);
            }
            Handler handler2 = this.e;
            if (handler2 != null) {
                if (this.y > 0) {
                    this.v = 0;
                }
                handler2.postDelayed(new b(), this.y);
            }
        }
    }

    public void d(boolean z) {
        int i;
        Log.i("SuperResolutionStrategy", "enter  asyncSRPredictTask, isFirstPredict: " + z);
        if (this.u != -1 && System.currentTimeMillis() - this.u <= this.g) {
            Log.d("SuperResolutionStrategy", "has do asyncSRPredictTask in " + this.g + ", use last predict result: " + this.w);
            this.v = this.w;
            if (!this.j.isEmpty()) {
                for (VideoSurface videoSurface : this.j) {
                    if (videoSurface != null) {
                        if (this.v != 0) {
                            videoSurface.setSuperResolutionMode(1);
                            Log.d("SuperResolutionStrategy", "change sr mode to 1");
                        } else {
                            videoSurface.setSuperResolutionMode(0);
                            Log.d("SuperResolutionStrategy", "change sr mode to 0");
                        }
                    }
                }
                return;
            }
            return;
        }
        this.u = System.currentTimeMillis();
        JSONObject runStrategy = runStrategy();
        if (runStrategy != null) {
            if (runStrategy.has("enable_sr")) {
                i = runStrategy.optInt("enable_sr");
            } else {
                i = 1;
            }
            uploadPredictValue(runStrategy);
        } else {
            i = 1;
        }
        if (!this.j.isEmpty()) {
            for (VideoSurface videoSurface2 : this.j) {
                if (this.A == 1 && i != 0) {
                    videoSurface2.setSuperResolutionMode(i);
                    Log.d("SuperResolutionStrategy", "change sr mode to 1");
                } else {
                    videoSurface2.setSuperResolutionMode(0);
                    Log.d("SuperResolutionStrategy", "change sr mode to 0");
                }
            }
        }
        this.v = i;
        Log.d("SuperResolutionStrategy", "sr predict result: " + this.v);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:7|(6:8|9|(2:15|(1:17)(4:18|(1:20)|21|(1:23)))|24|(4:26|(1:28)(1:118)|29|(1:31)(1:117))(1:119)|32)|(6:34|(1:36)(1:115)|37|(1:39)(1:114)|40|(7:42|43|44|45|(2:55|(2:57|(1:108)(8:65|66|67|(2:78|(2:83|(2:88|(3:95|(2:100|(1:102)(4:103|75|76|77))|104)(1:94))(1:87))(1:82))(1:73)|74|75|76|77))(1:109))(1:49)|50|51)(1:112))(1:116)|113|43|44|45|(1:47)|53|55|(0)(0)|50|51) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x023d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0144  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject runLocalStrategy(org.json.JSONObject r32) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.smartStrategy.l.runLocalStrategy(org.json.JSONObject):org.json.JSONObject");
    }
}
