package com.ss.ttvideoengine.strategrycenter;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class StrategyEvent {
    private final ConcurrentMap<String, ConcurrentMap<String, Object>> mVidMap = new ConcurrentHashMap();
    private final ConcurrentMap<String, Object> mNoVidMap = new ConcurrentHashMap();
    private final Queue<Map<String, Object>> mUnexpectedThrowables = new ConcurrentLinkedQueue();

    static {
        Covode.recordClassIndex(652715);
    }

    public void removeLogData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mVidMap.remove(str);
    }

    private static Map<String, Object> convertCounterMap(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof Map) {
                hashMap.put(entry.getKey(), convertCounterMap((Map) entry.getValue()));
            } else if (entry.getValue() instanceof AtomicInteger) {
                hashMap.put(entry.getKey(), Integer.valueOf(((AtomicInteger) entry.getValue()).get()));
            } else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    public Map<String, Object> getLogData(String str) {
        Map hashMap;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentMap<String, Object> concurrentMap = this.mVidMap.get(str);
        if (concurrentMap != null) {
            hashMap = convertCounterMap(concurrentMap);
        } else {
            hashMap = new HashMap();
        }
        hashMap.putAll(this.mNoVidMap);
        String p = StrategyHelper.helper().getCenter().p(31301, str);
        if (!TextUtils.isEmpty(p)) {
            hashMap.put("st_preload_sc_info", p);
        }
        if (!this.mUnexpectedThrowables.isEmpty()) {
            hashMap.put("st_throws", this.mUnexpectedThrowables);
            this.mUnexpectedThrowables.clear();
        }
        TTVideoEngineLog.i("StrategyEvent", "vid: " + str + ", gotten log data: " + hashMap);
        return hashMap;
    }

    private static ConcurrentMap<String, Object> putIfAbsentAndGetMap(ConcurrentMap<String, Object> concurrentMap, String str) {
        concurrentMap.putIfAbsent(str, new ConcurrentHashMap());
        return (ConcurrentMap) concurrentMap.get(str);
    }

    public Map<String, Object> getLogData(String str, String str2) {
        Map map;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str2.equals("st_play_task_op") || (map = (Map) this.mVidMap.get(str).get(str2)) == null) {
            return null;
        }
        return convertCounterMap(map);
    }

    public Map<String, Object> popLogData(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject(StrategyHelper.helper().getCenter().v(i, str));
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next));
            }
            TTVideoEngineLog.i("StrategyEvent", "traceId: " + str + ", type: " + i + ", gotten log data: " + hashMap);
            return hashMap;
        } catch (JSONException e) {
            TTVideoEngineLog.e("StrategyEvent", "event log parse failed: " + e);
            return null;
        }
    }

    public void event(String str, int i, int i2, String str2) {
        try {
            eventImpl(str, i, i2, str2);
        } catch (Throwable th) {
            this.mUnexpectedThrowables.add(new HashMap<String, Object>(str, i, i2, str2, th) { // from class: com.ss.ttvideoengine.strategrycenter.StrategyEvent.1
                final /* synthetic */ Throwable val$e;
                final /* synthetic */ String val$id;
                final /* synthetic */ int val$key;
                final /* synthetic */ String val$logInfo;
                final /* synthetic */ int val$value;

                {
                    this.val$id = str;
                    this.val$key = i;
                    this.val$value = i2;
                    this.val$logInfo = str2;
                    this.val$e = th;
                    put("id", str);
                    put("key", Integer.valueOf(i));
                    put("value", Integer.valueOf(i2));
                    put("logInfo", str2);
                    put("throwable", th.toString());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:199:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void eventImpl(java.lang.String r23, int r24, int r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 1068
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.strategrycenter.StrategyEvent.eventImpl(java.lang.String, int, int, java.lang.String):void");
    }
}
