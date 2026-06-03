package com.ss.videoarch.strategy.featureCenter.featureType;

import android.os.BatteryManager;
import android.util.Log;
import com.bytedance.apm.perf.PerfCollectUtils;
import com.bytedance.apm.perf.entity.MemoryInfo;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.common.graphics.GraphicsMonitor;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.LiveStrategyManager;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends com.ss.videoarch.strategy.featureCenter.featureType.a {
    private static volatile b p;
    private double c = -1.0d;
    private long d = 0;
    private double e = -1.0d;
    private long f = 0;
    private double g = -1.0d;
    private long h = 0;
    public double i = -1.0d;
    private JSONObject j = new JSONObject();
    private long k = 0;
    private JSONObject l = new JSONObject();
    private long m = 0;
    public ConcurrentHashMap<String, FpsTracer> n = new ConcurrentHashMap<>();
    public boolean o = false;

    static {
        Covode.recordClassIndex(653135);
        p = null;
    }

    public static b f() {
        if (p == null) {
            synchronized (b.class) {
                if (p == null) {
                    p = new b();
                }
            }
        }
        return p;
    }

    public void e() {
        if (lj6.a.m().r.e.mEnableDeviceFeatureData == 1 && !this.o) {
            GraphicsMonitor.init();
            GraphicsMonitor.start();
            this.o = true;
        }
    }

    private b() {
        this.a = "TypeDeviceFeature";
        mj6.b bVar = this.b;
        if (bVar != null) {
            bVar.a = "TypeDeviceFeature";
        }
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        if (LiveStrategyManager.inst().mBatteryIntent != null) {
            float intExtra = LiveStrategyManager.inst().mBatteryIntent.getIntExtra("temperature", 0) / 10;
            try {
                BatteryManager batteryManager = (BatteryManager) LiveStrategyManager.inst().mContext.getSystemService("batterymanager");
                if (batteryManager != null) {
                    jSONObject.put("battery_percentage", batteryManager.getIntProperty(4)).put("battery_status", batteryManager.getIntProperty(6)).put("battery_temperature", intExtra);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    class a implements FpsTracer.IFPSCallBack {
        a() {
        }

        public void fpsCallBack(double d) {
            Log.d("TypeDeviceFeatures", "fps call back:" + d);
            b.this.i = d;
        }
    }

    public void g(JSONObject jSONObject) {
        String str;
        if (jSONObject != null) {
            str = jSONObject.optString("PLAY-SessionID");
        } else {
            str = "";
        }
        FpsTracer fpsTracer = new FpsTracer(str);
        fpsTracer.setIFPSCallBack(new a());
        this.n.put(str, fpsTracer);
        fpsTracer.start();
        Log.d("TypeDeviceFeatures", "fps tracer start");
    }

    public void h(JSONObject jSONObject) {
        String str;
        FpsTracer fpsTracer;
        if (jSONObject != null) {
            str = jSONObject.optString("PLAY-SessionID");
        } else {
            str = "";
        }
        ConcurrentHashMap<String, FpsTracer> concurrentHashMap = this.n;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str) && (fpsTracer = this.n.get(str)) != null) {
            fpsTracer.stop();
            this.n.remove(str);
            Log.d("TypeDeviceFeatures", "fps map size:" + this.n.size());
        }
    }

    public JSONObject c(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, JSONObject jSONObject2) {
        char c;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            try {
                switch (optString.hashCode()) {
                    case -1095838600:
                        if (optString.equals("DEVICE-Memory")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -891779722:
                        if (optString.equals("DEVICE-Battery")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 293563702:
                        if (optString.equals("DEVICE-CpuSpeed")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 425068049:
                        if (optString.equals("DEVICE-CpuRate")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1266057426:
                        if (optString.equals("DEVICE-Fps")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1266058389:
                        if (optString.equals("DEVICE-Gpu")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (c != 4) {
                                    if (c != 5) {
                                        Map<String, Object> map = lj6.a.m().l;
                                        String[] split = optString.split("-", 2);
                                        if (split.length == 2) {
                                            String lowerCase = split[1].toLowerCase();
                                            if (map.containsKey(lowerCase)) {
                                                jSONObject.put(optString, map.get(lowerCase));
                                            } else {
                                                jSONObject.put(optString, "none");
                                            }
                                        }
                                    } else if (currentTimeMillis - this.m < lj6.a.m().r.e.mDeviceFeatureEffectiveTime) {
                                        jSONObject.put(optString, this.l);
                                    } else {
                                        JSONObject d = d();
                                        this.l = d;
                                        this.m = currentTimeMillis;
                                        jSONObject.put(optString, d);
                                    }
                                } else {
                                    jSONObject.put(optString, this.i);
                                }
                            } else if (currentTimeMillis - this.k < lj6.a.m().r.e.mDeviceFeatureEffectiveTime) {
                                jSONObject.put(optString, this.j);
                            } else {
                                JSONObject jSONObject3 = new JSONObject();
                                MemoryInfo memory = PerfCollectUtils.getMemory(LiveStrategyManager.inst().mContext);
                                if (memory != null) {
                                    jSONObject3.put("mem_java_total", memory.javaTotalMemory);
                                    jSONObject3.put("mem_java_free", memory.javaFreeMemory);
                                    jSONObject3.put("mem_java_used", memory.javaUsedMemory);
                                    jSONObject3.put("mem_pss_dalvik", memory.pssDalvik);
                                    jSONObject3.put("mem_pss_native", memory.pssNative);
                                    jSONObject3.put("mem_pss_total", memory.pssTotal);
                                    jSONObject3.put("mem_graphics", memory.graphics);
                                    jSONObject3.put("mem_vmsize", memory.vmSize);
                                    this.j = jSONObject3;
                                    this.k = currentTimeMillis;
                                }
                                jSONObject.put(optString, jSONObject3);
                            }
                        } else if (currentTimeMillis - this.h < lj6.a.m().r.e.mDeviceFeatureEffectiveTime) {
                            jSONObject.put(optString, this.g);
                        } else {
                            double byteGpu = GraphicsMonitor.getByteGpu();
                            this.g = byteGpu;
                            this.h = currentTimeMillis;
                            jSONObject.put(optString, byteGpu);
                        }
                    } else if (currentTimeMillis - this.f < lj6.a.m().r.e.mDeviceFeatureEffectiveTime) {
                        jSONObject.put(optString, this.e);
                    } else {
                        double d2 = ApmCpuManager.getInstance().getCurrentCpuRate().cpuAppSpeed;
                        this.e = d2;
                        this.f = currentTimeMillis;
                        jSONObject.put(optString, d2);
                    }
                } else if (currentTimeMillis - this.d < lj6.a.m().r.e.mDeviceFeatureEffectiveTime) {
                    jSONObject.put(optString, this.c);
                } else {
                    double d3 = ApmCpuManager.getInstance().getCurrentCpuRate().cpuAppRate;
                    this.c = d3;
                    this.d = currentTimeMillis;
                    jSONObject.put(optString, d3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
