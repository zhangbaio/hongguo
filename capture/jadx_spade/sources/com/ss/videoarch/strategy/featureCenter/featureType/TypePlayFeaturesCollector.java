package com.ss.videoarch.strategy.featureCenter.featureType;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.IAppInfoBundle;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.SessionCacheInfos;
import com.ss.videoarch.strategy.strategy.smartStrategy.TopNHostStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TypePlayFeaturesCollector extends a {
    private static volatile TypePlayFeaturesCollector r;
    public final Map<String, SessionCacheInfos> c = new LinkedHashMap<String, SessionCacheInfos>() { // from class: com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, SessionCacheInfos> entry) {
            if (size() > 20) {
                return true;
            }
            return false;
        }
    };
    public String d = "";
    public JSONObject e = new JSONObject();
    public List<Long> f = new LinkedList();
    public int g = 10;
    public int h = 4000;
    private JSONObject i = null;
    private ReentrantLock j = new ReentrantLock();
    private final int k = 0;
    private final int l = 1;
    private final String m = "bundle";
    private ReentrantReadWriteLock n = new ReentrantReadWriteLock(false);
    private JSONArray o = new JSONArray();
    private JSONObject p = new JSONObject();
    private JSONObject q = null;

    static {
        Covode.recordClassIndex(653137);
        r = null;
    }

    public static TypePlayFeaturesCollector h() {
        if (r == null) {
            synchronized (TypePlayFeaturesCollector.class) {
                if (r == null) {
                    r = new TypePlayFeaturesCollector();
                }
            }
        }
        return r;
    }

    private TypePlayFeaturesCollector() {
        this.a = "TypePlayFeature";
        mj6.b bVar = this.b;
        if (bVar != null) {
            bVar.a = "TypePlayFeature";
        }
        this.o.put("PLAY-VideoBuffer").put("PLAY-AudioBuffer");
    }

    public void f() {
        for (Map.Entry<String, IAppInfoBundle> entry : LiveStrategyManager.inst().mListenerMap.entrySet()) {
            String key = entry.getKey();
            IAppInfoBundle value = entry.getValue();
            if (value != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    value.getAppInfoForKey("bundle", new JSONObject().put("featuresBundleList", this.o).put("featuresData", jSONObject));
                    jSONObject.put("PLAY-SessionID", key);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                k(jSONObject);
                Log.d("PlayFeaturesCollector", "Clock Context,  Session ID : " + key + "   JSONObject: " + jSONObject);
            }
        }
    }

    public void i(JSONObject jSONObject) {
        this.j.lock();
        this.i = jSONObject;
        this.j.unlock();
    }

    public long g(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        Iterator<Long> it2 = list.iterator();
        long j = 0;
        while (it2.hasNext()) {
            long longValue = it2.next().longValue();
            if (longValue != 0) {
                j += 1 / longValue;
            }
        }
        if (j <= 0) {
            return 0L;
        }
        return list.size() / j;
    }

    public void k(JSONObject jSONObject) {
        SessionCacheInfos sessionCacheInfos;
        long j;
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("PLAY-SessionID", "");
                if (optString.length() == 0) {
                    return;
                }
                synchronized (this.c) {
                    if (this.c.containsKey(optString)) {
                        sessionCacheInfos = this.c.get(optString);
                    } else {
                        sessionCacheInfos = new SessionCacheInfos();
                        sessionCacheInfos.mSessionId = optString;
                    }
                }
                sessionCacheInfos.isValid = true;
                long j2 = -1;
                if (jSONObject.has("PLAY-VideoBuffer")) {
                    j = jSONObject.optLong("PLAY-VideoBuffer");
                } else {
                    j = -1;
                }
                if (jSONObject.has("PLAY-AudioBuffer")) {
                    j2 = jSONObject.optLong("PLAY-AudioBuffer");
                }
                sessionCacheInfos.mVideoBuffer = j;
                sessionCacheInfos.mAudioBuffer = j2;
                sessionCacheInfos.mVideoBufferList.add(Long.valueOf(j));
                if (sessionCacheInfos.mVideoBufferList.size() > 200) {
                    sessionCacheInfos.mVideoBufferList.remove();
                }
                sessionCacheInfos.mAudioBufferList.add(Long.valueOf(j2));
                if (sessionCacheInfos.mAudioBufferList.size() > 200) {
                    sessionCacheInfos.mAudioBufferList.remove();
                }
                synchronized (this.c) {
                    this.c.put(optString, sessionCacheInfos);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T e(java.lang.String r7, T r8) {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r6.j
            r0.lock()
            org.json.JSONObject r0 = r6.i
            if (r0 == 0) goto Lb8
            r7.hashCode()
            int r0 = r7.hashCode()
            java.lang.String r1 = "is_preview"
            java.lang.String r2 = "neptuneName"
            java.lang.String r3 = "stream_session_vv_id"
            java.lang.String r4 = "enter_from"
            r5 = -1
            switch(r0) {
                case -818786127: goto L38;
                case 855771538: goto L2f;
                case 970568508: goto L26;
                case 1182125491: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L40
        L1d:
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L24
            goto L40
        L24:
            r5 = 3
            goto L40
        L26:
            boolean r7 = r7.equals(r2)
            if (r7 != 0) goto L2d
            goto L40
        L2d:
            r5 = 2
            goto L40
        L2f:
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L36
            goto L40
        L36:
            r5 = 1
            goto L40
        L38:
            boolean r7 = r7.equals(r4)
            if (r7 != 0) goto L3f
            goto L40
        L3f:
            r5 = 0
        L40:
            switch(r5) {
                case 0: goto L9c;
                case 1: goto L80;
                case 2: goto L44;
                case 3: goto L60;
                default: goto L43;
            }
        L43:
            goto Lb8
        L44:
            java.lang.Class r7 = r8.getClass()
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r7 != r0) goto L60
            org.json.JSONObject r7 = r6.i
            boolean r7 = r7.has(r2)
            if (r7 == 0) goto L60
            org.json.JSONObject r7 = r6.i
            java.lang.String r7 = r7.optString(r2)
            java.util.concurrent.locks.ReentrantLock r8 = r6.j
            r8.unlock()
            return r7
        L60:
            java.lang.Class r7 = r8.getClass()
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            if (r7 != r0) goto L80
            org.json.JSONObject r7 = r6.i
            boolean r7 = r7.has(r1)
            if (r7 == 0) goto L80
            org.json.JSONObject r7 = r6.i
            int r7 = r7.optInt(r1)
            java.util.concurrent.locks.ReentrantLock r8 = r6.j
            r8.unlock()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            return r7
        L80:
            java.lang.Class r7 = r8.getClass()
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r7 != r0) goto L9c
            org.json.JSONObject r7 = r6.i
            boolean r7 = r7.has(r3)
            if (r7 == 0) goto L9c
            org.json.JSONObject r7 = r6.i
            java.lang.String r7 = r7.optString(r3)
            java.util.concurrent.locks.ReentrantLock r8 = r6.j
            r8.unlock()
            return r7
        L9c:
            java.lang.Class r7 = r8.getClass()
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r7 != r0) goto Lb8
            org.json.JSONObject r7 = r6.i
            boolean r7 = r7.has(r4)
            if (r7 == 0) goto Lb8
            org.json.JSONObject r7 = r6.i
            java.lang.String r7 = r7.optString(r4)
            java.util.concurrent.locks.ReentrantLock r8 = r6.j
            r8.unlock()
            return r7
        Lb8:
            java.util.concurrent.locks.ReentrantLock r7 = r6.j
            r7.unlock()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector.e(java.lang.String, java.lang.Object):java.lang.Object");
    }

    public void j(int i, JSONObject jSONObject) {
        SessionCacheInfos sessionCacheInfos;
        String optString = jSONObject.optString("PLAY-SessionID", "");
        if (optString.length() == 0) {
            return;
        }
        synchronized (this.c) {
            if (!this.c.containsKey(optString)) {
                sessionCacheInfos = new SessionCacheInfos();
                sessionCacheInfos.mSessionId = optString;
            } else {
                sessionCacheInfos = this.c.get(optString);
            }
        }
        switch (i) {
            case 60:
                sessionCacheInfos.isValid = true;
                sessionCacheInfos.mStartTs = System.currentTimeMillis();
                break;
            case 61:
                sessionCacheInfos.isValid = true;
                sessionCacheInfos.mFirstFrameVideoBuffer = jSONObject.optInt("PLAY-FirstFrameVideoBuffer");
                sessionCacheInfos.mFirstFrameAudioBuffer = jSONObject.optInt("PLAY-FirstFrameAudioBuffer");
                sessionCacheInfos.mFirstFrameDownloadSpeed = jSONObject.optInt("PLAY-FirstFrameDownloadSpeed");
                sessionCacheInfos.mProtocol = jSONObject.optString("PLAY-Protocol");
                sessionCacheInfos.mFirstFrame = jSONObject.optInt("PLAY-FirstFrame");
                sessionCacheInfos.mSuccess = jSONObject.optInt("PLAY-Success");
                sessionCacheInfos.m302 = jSONObject.optInt("PLAY-302");
                sessionCacheInfos.mConnectCost = jSONObject.optInt("PLAY-ConnectCost");
                sessionCacheInfos.mEnterMethod = jSONObject.optString("PLAY-EnterMethod");
                sessionCacheInfos.mEnterAction = jSONObject.optString("PLAY-EnterAction");
                sessionCacheInfos.mStreamSuffix = jSONObject.optString("PLAY-StreamSuffix");
                sessionCacheInfos.mNeptuneName = jSONObject.optString("PLAY-NeptuneName");
                sessionCacheInfos.mIsPreview = jSONObject.optInt("PLAY-IsPreview");
                sessionCacheInfos.mFPS = (float) jSONObject.optDouble("PLAY-FPS");
                sessionCacheInfos.mBufferDataSeconds = jSONObject.optInt("PLAY-BufferDataSeconds");
                sessionCacheInfos.mDoubleBufferDataSeconds = jSONObject.optInt("PLAY-BufferDataSeconds");
                break;
            case 62:
                sessionCacheInfos.isValid = true;
                String optString2 = jSONObject.optString("event_key");
                if (optString2.equals("stall")) {
                    long optLong = jSONObject.optLong("PLAY-StallTime");
                    sessionCacheInfos.mStallTime = optLong;
                    sessionCacheInfos.mStallTotalTime += optLong;
                    sessionCacheInfos.mStallTotalCount++;
                    sessionCacheInfos.mStallSeries.add(Long.valueOf(optLong));
                    int i2 = sessionCacheInfos.mDoubleBufferDataSeconds;
                    if (i2 > 0 && i2 < 1500) {
                        sessionCacheInfos.mDoubleBufferDataSeconds = i2 * 2;
                    }
                    if (sessionCacheInfos.mStallSeries.size() > 200) {
                        sessionCacheInfos.mStallSeries.remove();
                        break;
                    }
                } else if (optString2.equals("render_stall")) {
                    int optInt = jSONObject.optInt("PLAY-StallType");
                    sessionCacheInfos.mStallType = optInt;
                    long optLong2 = jSONObject.optLong("PLAY-StallTime");
                    if (optInt == 0) {
                        sessionCacheInfos.mRenderVideoSeries.add(Long.valueOf(optLong2));
                        if (sessionCacheInfos.mRenderVideoSeries.size() > 200) {
                            sessionCacheInfos.mRenderVideoSeries.remove();
                            break;
                        }
                    } else if (optInt == 1) {
                        sessionCacheInfos.mRenderAudioSeries.add(Long.valueOf(optLong2));
                        if (sessionCacheInfos.mRenderAudioSeries.size() > 200) {
                            sessionCacheInfos.mRenderAudioSeries.remove();
                            break;
                        }
                    }
                }
                break;
            case 63:
                sessionCacheInfos.isValid = true;
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis - sessionCacheInfos.mStartTs;
                sessionCacheInfos.mEndTs = System.currentTimeMillis();
                LiveStrategyManager.inst().mLastEndTS = currentTimeMillis;
                sessionCacheInfos.mDuration = currentTimeMillis - sessionCacheInfos.mStartTs;
                f.a().b(j);
                if (this.q != null) {
                    for (int i3 = 9; i3 > 0; i3--) {
                        try {
                            this.q.put(String.valueOf(i3), this.q.optLong(String.valueOf(i3 - 1), -1L));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    this.q.put(String.valueOf(0), j);
                }
                this.d = optString;
                String optString3 = jSONObject.optString("domain");
                sessionCacheInfos.mRetryTotalCount = jSONObject.optInt("retryTotalCount");
                sessionCacheInfos.mDomain = optString3;
                sessionCacheInfos.mStopTimestamp = System.currentTimeMillis();
                int a = a(jSONObject.optString("nqeInfo"));
                long optLong3 = jSONObject.optLong("firstFrameDownloadSpeed");
                if (lj6.a.m().s.b == 1 && lj6.a.m().s.f == 1) {
                    sessionCacheInfos.mPlayTime = jSONObject.optLong("playTime");
                    sessionCacheInfos.mNetwork = String.valueOf(a);
                    sessionCacheInfos.mDownloadSpeed = optLong3;
                    sessionCacheInfos.mUpdate = nj6.a.c();
                    nj6.c.e.put(optString, sessionCacheInfos);
                    if (nj6.c.e.size() == lj6.a.m().s.g) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<Map.Entry<String, SessionCacheInfos>> it2 = nj6.c.e.entrySet().iterator();
                        while (it2.hasNext()) {
                            arrayList.add(it2.next().getValue());
                        }
                        nj6.c.i(arrayList);
                        nj6.c.g();
                        TopNHostStrategy.f().e();
                    } else {
                        nj6.c.f(sessionCacheInfos);
                        TopNHostStrategy.f().d(optString3, 1);
                    }
                }
                if (lj6.a.m().S == 1 && lj6.a.m().R == 1) {
                    TopNHostStrategy.f().d(optString3, 1);
                }
                if (lj6.a.m().r.e.mEnableBandWidthAvg == 1) {
                    JSONObject jSONObject2 = this.e;
                    if (jSONObject2 != null && jSONObject2.has(String.valueOf(a))) {
                        optLong3 = (this.e.optLong(String.valueOf(a)) + optLong3) / 2;
                    }
                } else {
                    JSONObject jSONObject3 = this.e;
                    if (jSONObject3 != null && jSONObject3.has(String.valueOf(a)) && this.e.optLong(String.valueOf(a)) >= optLong3) {
                        return;
                    }
                }
                try {
                    JSONObject jSONObject4 = this.e;
                    if (jSONObject4 != null) {
                        jSONObject4.put(String.valueOf(a), optLong3);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (j >= this.h && jSONObject.has("estimated_bandwidth")) {
                    long optLong4 = jSONObject.optLong("estimated_bandwidth");
                    jSONObject.optLong("sd_samples");
                    long optLong5 = jSONObject.optLong("avg_estimated");
                    long optLong6 = jSONObject.optLong("sd_estimated");
                    List<Long> list = this.f;
                    if (list != null) {
                        if (list.size() >= this.g) {
                            this.f.remove(0);
                        }
                    } else {
                        this.f = new LinkedList();
                    }
                    if (optLong6 >= 0 && optLong5 > 0 && optLong6 <= optLong5 / 10) {
                        this.f.add(Long.valueOf(optLong5));
                    } else if (optLong4 > 0) {
                        this.f.add(Long.valueOf(optLong4));
                    }
                    sessionCacheInfos.mEstimatedBandwidth = g(this.f);
                    break;
                }
                break;
            default:
                if (sessionCacheInfos != null && !sessionCacheInfos.isValid) {
                    synchronized (this.c) {
                        this.c.remove(optString);
                    }
                    break;
                }
                break;
        }
        if (sessionCacheInfos != null && sessionCacheInfos.isValid) {
            synchronized (this.c) {
                this.c.put(optString, sessionCacheInfos);
            }
        }
    }

    public JSONObject d(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, JSONObject jSONObject2) {
        JSONObject jSONObject3 = this.i;
        if (jSONObject3 != null) {
            String optString = jSONObject3.optString("stream_session_vv_id", "");
            if (optString.length() != 0) {
                try {
                    JSONObject put = new JSONObject().put("featuresBundleList", jSONArray).put("featuresData", jSONObject);
                    IAppInfoBundle iAppInfoBundle = LiveStrategyManager.inst().mListenerMap.get(optString);
                    if (iAppInfoBundle != null) {
                        iAppInfoBundle.getAppInfoForKey("bundle", put);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x02d1, code lost:
    
        if (r14 == 0) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02d3, code lost:
    
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02d7, code lost:
    
        if (r14 == 0) goto L302;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02bd A[Catch: all -> 0x02ca, Exception -> 0x02d1, TRY_LEAVE, TryCatch #23 {Exception -> 0x02d1, all -> 0x02ca, blocks: (B:44:0x029b, B:77:0x02bd), top: B:43:0x029b }] */
    /* JADX WARN: Type inference failed for: r14v9, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r26v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v28, types: [int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject c(org.json.JSONObject r26, org.json.JSONArray r27, java.lang.String r28, java.lang.String r29, org.json.JSONObject r30) {
        /*
            Method dump skipped, instructions count: 1366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector.c(org.json.JSONObject, org.json.JSONArray, java.lang.String, java.lang.String, org.json.JSONObject):org.json.JSONObject");
    }
}
