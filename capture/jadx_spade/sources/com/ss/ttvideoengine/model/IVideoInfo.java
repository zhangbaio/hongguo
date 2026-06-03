package com.ss.ttvideoengine.model;

import com.ss.ttvideoengine.Resolution;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IVideoInfo {
    int fromMediaInfoJsonObject(JSONObject jSONObject);

    MediaBitrateFitterInfo getBitrateFitterInfo();

    int getMediatype();

    Resolution getResolution();

    boolean getValueBool(int i);

    float getValueFloat(int i);

    int getValueInt(int i);

    long getValueLong(int i);

    String getValueStr(int i);

    String[] getValueStrArr(int i);

    JSONObject toBashJsonObject();

    Map<String, Object> toMediaInfo();
}
