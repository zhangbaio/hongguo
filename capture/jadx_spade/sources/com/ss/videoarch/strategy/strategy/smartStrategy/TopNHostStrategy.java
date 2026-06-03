package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.utils.JNINamespace;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("jni")
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TopNHostStrategy extends BaseSmartStrategy {
    private static volatile TopNHostStrategy i;
    public nj6.e b;
    private Map<String, Integer> a = new ConcurrentHashMap();
    private long c = 0;
    private String d = "";
    private boolean e = false;
    public int f = -1;
    public int g = 0;
    public String h = "";

    private native void nativeAddDomainUsedCount(String str, int i2);

    private native void nativeClearRecords();

    private native String nativeRunStrategy();

    private JSONObject c() {
        return super.runStrategy();
    }

    static {
        Covode.recordClassIndex(653217);
        i = null;
    }

    public static TopNHostStrategy f() {
        if (i == null) {
            synchronized (TopNHostStrategy.class) {
                if (i == null) {
                    i = new TopNHostStrategy();
                }
            }
        }
        return i;
    }

    public void e() {
        if (lj6.a.m().R == 1) {
            if (com.ss.videoarch.strategy.utils.b.a()) {
                nativeClearRecords();
            }
        } else {
            this.a.clear();
            this.e = true;
        }
    }

    private TopNHostStrategy() {
        this.mStrategyName = "live_stream_strategy_topn_host";
        mj6.d dVar = this.mStrategyConfigInfo;
        if (dVar != null) {
            dVar.b = "live_stream_strategy_topn_host";
        }
        this.mProjectKey = "2";
        this.b = new nj6.e();
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runStrategy() {
        JSONObject c;
        if (lj6.a.m().R == 1) {
            c = null;
            if (com.ss.videoarch.strategy.utils.b.a()) {
                Log.d("TopNHostStrategy", "mEnableMgrTopN");
                String nativeRunStrategy = nativeRunStrategy();
                Log.d("TopNHostStrategy", "nativeRunStrategy result:" + nativeRunStrategy);
                if (!TextUtils.isEmpty(nativeRunStrategy) && !Objects.equals(nativeRunStrategy, "none")) {
                    try {
                        c = new JSONObject(nativeRunStrategy);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            Log.d("TopNHostStrategy", "disable mEnableMgrTopN");
            c = c();
        }
        Log.d("TopNHostStrategy", "runStrategy result:" + c);
        return c;
    }

    class a implements Comparator<Map.Entry<String, Integer>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return -entry.getValue().compareTo(entry2.getValue());
        }
    }

    private JSONObject b(JSONObject jSONObject) {
        return super.runSmartStrategy(jSONObject);
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runSmartStrategy(JSONObject jSONObject) {
        if (lj6.a.m().R == 1) {
            Log.e("TopNHostStrategy", "should not be here");
            return null;
        }
        return b(jSONObject);
    }

    public Set<String> g(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        if (jSONObject.has("host_name") && (optJSONArray = jSONObject.optJSONArray("host_name")) != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                hashSet.add(optJSONArray.optString(i2));
            }
        }
        return hashSet;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject jSONObject) {
        JSONObject a2;
        if (lj6.a.m().R == 1) {
            Log.e("TopNHostStrategy", "should not be here");
            a2 = null;
        } else {
            a2 = a(jSONObject);
        }
        Log.d("TopNHostStrategy", "runlocalstartegy:" + a2);
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0103, code lost:
    
        if (r7 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0105, code lost:
    
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0110, code lost:
    
        if (r7 != null) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject a(org.json.JSONObject r18) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.strategy.smartStrategy.TopNHostStrategy.a(org.json.JSONObject):org.json.JSONObject");
    }

    public void d(String str, int i2) {
        Integer num;
        if (lj6.a.m().R == 1) {
            if (com.ss.videoarch.strategy.utils.b.a()) {
                nativeAddDomainUsedCount(str, i2);
            }
        } else {
            if (this.a.containsKey(str) && (num = this.a.get(str)) != null) {
                i2 += num.intValue();
            }
            this.a.put(str, Integer.valueOf(i2));
        }
    }
}
