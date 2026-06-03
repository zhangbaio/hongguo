package com.ss.ttvideoengine.portrait;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LabelUsage {
    private final ConcurrentHashMap<String, Object> mLabelUsage = new ConcurrentHashMap<>(3);

    static {
        Covode.recordClassIndex(652604);
    }

    public void addUsage(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            this.mLabelUsage.putAll(map);
        }
    }

    private Map<String, Object> jsonToMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt != null) {
                hashMap.put(next, opt);
            }
        }
        return hashMap;
    }

    public void updateByVideoModel(IVideoModel iVideoModel) {
        String videoRefStr = iVideoModel.getVideoRefStr(245);
        if (!TextUtils.isEmpty(videoRefStr)) {
            try {
                this.mLabelUsage.putAll(jsonToMap(new JSONObject(videoRefStr)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public HashMap<String, Object> get(Map<String, Object> map) {
        Map<String, Object> map2;
        HashMap<String, Object> hashMap = new HashMap<>(this.mLabelUsage);
        if (map.containsKey("label_usage")) {
            try {
                Object obj = map.get("label_usage");
                if (obj instanceof JSONObject) {
                    map2 = jsonToMap((JSONObject) obj);
                } else if (obj instanceof Map) {
                    map2 = (Map) obj;
                } else {
                    TTVideoEngineLog.e("LabelUsage", "invalid parameter type");
                    map2 = null;
                }
                if (map2 != null) {
                    hashMap.putAll(map2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}
