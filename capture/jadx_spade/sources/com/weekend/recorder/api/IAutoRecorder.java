package com.weekend.recorder.api;

import android.content.Context;
import dk6.a;
import dk6.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IAutoRecorder {
    boolean getWeekEndRecorderSwitch(Context context);

    void init(String str, String str2, b bVar, a aVar);

    void switchEnable(Context context, boolean z);
}
