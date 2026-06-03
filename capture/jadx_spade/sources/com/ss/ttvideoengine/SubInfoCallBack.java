package com.ss.ttvideoengine;

import com.ss.ttvideoengine.utils.Error;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface SubInfoCallBack {
    void onSubInfoCallback(int i, String str);

    void onSubLoadFinished(int i);

    void onSubLoadFinished2(int i, String str);

    void onSubPathInfo(String str, Error error);

    void onSubSwitchCompleted(int i, int i2);
}
