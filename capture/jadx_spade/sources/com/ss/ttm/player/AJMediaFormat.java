package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AJMediaFormat {
    public int channelCount;
    public int colorFormat;
    public int colorTrans;
    public int height;
    public int sampleRate;
    public int sliceHeight;
    public int stride;
    public int width;
    private android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
    private Map<String, Object> map = new HashMap();

    static {
        Covode.recordClassIndex(652070);
    }

    public Map<String, Object> getMap() {
        return this.map;
    }

    public android.media.MediaFormat getMediaFormat() {
        return this.mediaFormat;
    }

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.sampleRate = 0;
        this.channelCount = 0;
        this.colorFormat = 0;
        this.colorTrans = 0;
        this.sliceHeight = 0;
        this.stride = 0;
    }

    public String getString(String str) {
        return this.mediaFormat.getString(str);
    }

    public void setByteBuffer(String str, ByteBuffer byteBuffer) {
        this.mediaFormat.setByteBuffer(str, byteBuffer);
        this.map.put(str, byteBuffer);
    }

    public void setInteger(String str, int i) {
        this.mediaFormat.setInteger(str, i);
        this.map.put(str, Integer.valueOf(i));
    }

    public void setString(String str, String str2) {
        this.mediaFormat.setString(str, str2);
        this.map.put(str, str2);
    }

    public void setFeatureEnabled(String str, boolean z) {
        setInteger("feature-" + str, z ? 1 : 0);
    }

    public void getOptions(String[] strArr, Object[] objArr) {
        int i = 0;
        for (Map.Entry<String, Object> entry : this.map.entrySet()) {
            strArr[i] = entry.getKey();
            objArr[i] = entry.getValue();
            i++;
        }
    }
}
