package com.ss.ttvideoengine.configcenter;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class OptionHolder {
    private final Map<Integer, Integer> mIntMap = new ConcurrentHashMap();
    private final Map<Integer, Long> mLongMap = new ConcurrentHashMap();
    private final Map<Integer, Float> mFloatMap = new ConcurrentHashMap();
    private final Map<Integer, String> mStringMap = new ConcurrentHashMap();

    static {
        Covode.recordClassIndex(652412);
    }

    public void apply(MediaPlayer mediaPlayer) {
        if (mediaPlayer == null) {
            return;
        }
        try {
            for (Map.Entry<Integer, Integer> entry : this.mIntMap.entrySet()) {
                mediaPlayer.setIntOption(entry.getKey().intValue(), entry.getValue().intValue());
            }
            for (Map.Entry<Integer, Long> entry2 : this.mLongMap.entrySet()) {
                mediaPlayer.setLongOption(entry2.getKey().intValue(), entry2.getValue().longValue());
            }
            for (Map.Entry<Integer, Float> entry3 : this.mFloatMap.entrySet()) {
                mediaPlayer.setFloatOption(entry3.getKey().intValue(), entry3.getValue().floatValue());
            }
            for (Map.Entry<Integer, String> entry4 : this.mStringMap.entrySet()) {
                mediaPlayer.setStringOption(entry4.getKey().intValue(), entry4.getValue());
            }
        } catch (Exception e) {
            TTVideoEngineLog.e("OptionHolder", e.getMessage());
        }
    }

    public void setFloatOption(int i, float f) {
        this.mFloatMap.put(Integer.valueOf(i), Float.valueOf(f));
    }

    public void setIntOption(int i, int i2) {
        this.mIntMap.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void setLongOption(int i, long j) {
        this.mLongMap.put(Integer.valueOf(i), Long.valueOf(j));
    }

    public void setStringOption(int i, String str) {
        this.mStringMap.put(Integer.valueOf(i), str);
    }

    public int getIntOption(int i, int i2) {
        Integer num;
        if (this.mIntMap.containsKey(Integer.valueOf(i)) && (num = this.mIntMap.get(Integer.valueOf(i))) != null) {
            return num.intValue();
        }
        return i2;
    }
}
