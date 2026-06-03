package com.ss.ttvideoengine.portrait;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PortraitEngine {
    private final ConcurrentHashMap<String, Object> mLabelMap = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<PortraitChangeListener> mListeners = new CopyOnWriteArrayList<>();
    private final IPortrait mPortraitNetwork = PortraitNetworkScore.getInstance();

    static {
        Covode.recordClassIndex(652608);
    }

    private static class Holder {
        private static final PortraitEngine Instance;

        private Holder() {
        }

        static {
            Covode.recordClassIndex(652609);
            Instance = new PortraitEngine();
        }
    }

    public static PortraitEngine getInstance() {
        return Holder.Instance;
    }

    public Map<String, Object> getAllLabels() {
        return new HashMap(this.mLabelMap);
    }

    public void addPortraitListener(PortraitChangeListener portraitChangeListener) {
        this.mListeners.add(portraitChangeListener);
    }

    public Object getLabel(String str) {
        return this.mLabelMap.get(str);
    }

    public void removePortraitListener(PortraitChangeListener portraitChangeListener) {
        this.mListeners.remove(portraitChangeListener);
    }

    public IPortrait getPortrait(int i) {
        if (i == 1) {
            return this.mPortraitNetwork;
        }
        return IPortrait.EMPTY;
    }

    private void notifyPortraitChange(String str, Object obj) {
        Iterator<PortraitChangeListener> it2 = this.mListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onPortraitChange(str, obj);
        }
    }

    public void setLabel(String str, Object obj) {
        if (this.mLabelMap.containsKey(str) && this.mLabelMap.get(str) != null && !this.mLabelMap.get(str).equals(obj)) {
            notifyPortraitChange(str, obj);
        } else if (!this.mLabelMap.containsKey(str)) {
            notifyPortraitChange(str, obj);
        } else {
            TTVideoEngineLog.d("PortraitEngine", "same label");
        }
        this.mLabelMap.put(str, obj);
    }

    public void updateLabelBySettings(String str, String str2) {
        JSONObject optJSONObject;
        if (!TextUtils.isEmpty(str) && str.equals("vod")) {
            TTVideoEngineLog.d("PortraitEngine", "updateLabelBySettings key: " + str + "value: " + str2);
            if (!TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has("portrait_engine") && (optJSONObject = jSONObject.optJSONObject("portrait_engine")) != null) {
                        if (optJSONObject.has("clinet_quality_speed")) {
                            setLabel("clinet_quality_speed", Integer.valueOf(optJSONObject.optInt("clinet_quality_speed")));
                        }
                        if (optJSONObject.has("clinet_quality_stability")) {
                            setLabel("clinet_quality_stability", Integer.valueOf(optJSONObject.optInt("clinet_quality_stability")));
                        }
                        if (optJSONObject.has("rebuf_label")) {
                            setLabel("rebuf_label", Integer.valueOf(optJSONObject.optInt("rebuf_label")));
                        }
                        if (optJSONObject.has("ff_label")) {
                            setLabel("ff_label", Integer.valueOf(optJSONObject.optInt("ff_label")));
                        }
                        if (optJSONObject.has("seek_label")) {
                            setLabel("seek_label", Integer.valueOf(optJSONObject.optInt("seek_label")));
                        }
                        if (optJSONObject.has("watch_duration")) {
                            setLabel("watch_duration", Integer.valueOf(optJSONObject.optInt("watch_duration")));
                        }
                        if (optJSONObject.has("first_frame")) {
                            setLabel("first_frame", Integer.valueOf(optJSONObject.optInt("first_frame")));
                        }
                        if (optJSONObject.has("rebuffering")) {
                            setLabel("rebuffering", Integer.valueOf(optJSONObject.optInt("rebuffering")));
                        }
                        if (optJSONObject.has("user_enter_full_screen")) {
                            setLabel("user_enter_full_screen", Integer.valueOf(optJSONObject.optInt("user_enter_full_screen")));
                        }
                        if (optJSONObject.has("scene_count_per_100vv")) {
                            setLabel("scene_count_per_100vv", Double.valueOf(optJSONObject.optDouble("scene_count_per_100vv")));
                        }
                        if (optJSONObject.has("user_quality_sensitivity")) {
                            setLabel("user_quality_sensitivity", Double.valueOf(optJSONObject.optDouble("user_quality_sensitivity")));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
