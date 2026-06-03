package com.ss.ttvideoengine.configcenter;

import com.bytedance.covode.number.Covode;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IEngineConfig {
    public static final IEngineConfig EMPTY;

    float getFloatOption(int i);

    int getIntOption(int i);

    Map<Integer, ConfigItem> getItemMap();

    long getLongOption(int i);

    ConfigItem getOption(int i);

    String getStringOption(int i);

    boolean isKeySet(int i);

    void remove(int i);

    void reset();

    ConfigItem setFloatOption(int i, float f);

    ConfigItem setIntOption(int i, int i2);

    ConfigItem setLongOption(int i, long j);

    ConfigItem setStringOption(int i, String str);

    static {
        Covode.recordClassIndex(652411);
        EMPTY = new IEngineConfig() { // from class: com.ss.ttvideoengine.configcenter.IEngineConfig.1
            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public float getFloatOption(int i) {
                return 0.0f;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public int getIntOption(int i) {
                return 0;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public Map<Integer, ConfigItem> getItemMap() {
                return null;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public long getLongOption(int i) {
                return 0L;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public ConfigItem getOption(int i) {
                return null;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public String getStringOption(int i) {
                return null;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public boolean isKeySet(int i) {
                return false;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public void remove(int i) {
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public void reset() {
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public ConfigItem setFloatOption(int i, float f) {
                return ConfigItem.EMPTY;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public ConfigItem setIntOption(int i, int i2) {
                return ConfigItem.EMPTY;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public ConfigItem setLongOption(int i, long j) {
                return ConfigItem.EMPTY;
            }

            @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
            public ConfigItem setStringOption(int i, String str) {
                return ConfigItem.EMPTY;
            }
        };
    }
}
