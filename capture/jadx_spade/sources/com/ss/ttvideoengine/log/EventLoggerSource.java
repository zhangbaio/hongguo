package com.ss.ttvideoengine.log;

import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface EventLoggerSource {
    Map<String, Long> bytesInfo();

    ArrayList forebackSwitchList();

    float getLogValueFloat(int i);

    int getLogValueInt(int i);

    long getLogValueLong(int i);

    Map<String, Object> getLogValueMap(int i);

    String getLogValueStr(int i);

    String getMediaLoaderInfo();

    void onInfo(int i, Map map);

    Map<String, String> versionInfo();
}
