package com.xiaomi;

import com.bytedance.push.settings.ILocalSettings;
import com.bytedance.push.settings.annotation.Settings;

@Settings(storageKey = "push_multi_process_config", supportMultiProcess = true)
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface MiPushSettings extends ILocalSettings {
    boolean A0();

    void Z1(boolean z);
}
