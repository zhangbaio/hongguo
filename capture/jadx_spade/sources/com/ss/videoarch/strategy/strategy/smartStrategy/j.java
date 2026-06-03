package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.util.Log;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class j extends BaseSmartStrategy {
    private static volatile j p;
    public static int q;
    public static int r;
    public static int s;
    public static double t;
    public static double u;
    public static double v;
    public static long w;
    public static long x;
    int a = 0;
    private int b = q;
    private int c = r;
    private double d = t;
    private int e = 1000;
    private int[] f = {8, 7, 6, 5, 4, 3, 2};
    private ConcurrentHashMap<Integer, Pair> g = new ConcurrentHashMap<>();
    public String h = null;
    public JSONObject i = null;
    private double j = u;
    private double k = v;
    private long l = w;
    private long m = x;
    private int[] n = {1, 2, 3, 4, 5, 6, 7, 8};
    public JSONObject o = new JSONObject();

    public static j b() {
        if (p == null) {
            synchronized (j.class) {
                if (p == null) {
                    p = new j();
                }
            }
        }
        return p;
    }

    static {
        Covode.recordClassIndex(653214);
        p = null;
        q = 600;
        r = 1000;
        s = 20;
        t = 0.1d;
        u = 1.05d;
        v = 15.0d;
        w = 0L;
        x = 80000L;
    }

    private j() {
        this.mStrategyName = "live_stream_strategy_start_play_buffer";
        this.mProjectKey = "2";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_start_play_buffer";
            dVar.m = new JSONArray().put("NETWORK-NetworkLevel").put("PLAY-RetryTotalCount").put("PLAY-StallTotalCount").put("PLAY-LastRetryTotalCount").put("PLAY-LastStallTotalCount").put("PLAY-LastEndTS");
        }
    }

    public void a() {
        int[] iArr;
        JSONObject jSONObject = this.mStrategyConfigInfo.h;
        if (jSONObject != null) {
            this.b = jSONObject.optInt("MinStartPlayBuffer", this.b);
            this.c = this.mStrategyConfigInfo.h.optInt("MaxStartPlayBuffer", this.c);
            this.d = this.mStrategyConfigInfo.h.optDouble("AttenuationCoefficient", this.d);
            this.e = this.mStrategyConfigInfo.h.optInt("AttenuationTimeOffset", this.e);
        }
        Log.d("StartPlayBufferStrategy", "mMinStartPlayBuffer:" + this.b + " mMaxStartPlayBuffer:" + this.c + " mCoefficient:" + this.d + " mAttenuationTimeOffset:" + this.e);
        double d = 0.0d;
        int i = 0;
        double d2 = 0.0d;
        while (true) {
            if (i >= this.f.length) {
                break;
            }
            d2 += Math.cbrt(8 - r7[i]);
            i++;
        }
        int i2 = this.c;
        int i3 = this.b;
        int i4 = i2 - i3;
        Log.d("StartPlayBufferStrategy", "denominator:" + d2 + " offset:" + i4);
        int i5 = 1;
        while (true) {
            iArr = this.f;
            if (i5 >= iArr.length) {
                break;
            }
            Log.d("StartPlayBufferStrategy", "network type:" + this.f[i5]);
            d += Math.cbrt((double) (8 - this.f[i5]));
            int i6 = i5;
            int i7 = (int) (((double) this.b) + ((d / d2) * ((double) i4)));
            Log.d("StartPlayBufferStrategy", "level:" + i7);
            this.g.put(Integer.valueOf(this.f[i6 + (-1)]), new Pair(Integer.valueOf(i3), Integer.valueOf(i7)));
            Log.d("StartPlayBufferStrategy", "first: " + i3 + " second: " + i7);
            i5 = i6 + 1;
            i3 = i7;
        }
        int i8 = i5;
        if (i8 == iArr.length) {
            this.g.put(Integer.valueOf(this.f[i8 - 1]), new Pair(Integer.valueOf(i3), Integer.valueOf(this.c)));
            Log.d("StartPlayBufferStrategy", "first: " + i3 + " second: " + this.c);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:14|(1:16)(1:49)|17|(1:19)(1:48)|20|(6:22|(1:26)|27|(1:31)|32|(7:36|37|(1:39)|40|41|42|43))|47|37|(0)|40|41|42|43) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0129, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012a, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e1  */
    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject runLocalStrategy(org.json.JSONObject r14) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.smartStrategy.j.runLocalStrategy(org.json.JSONObject):org.json.JSONObject");
    }
}
