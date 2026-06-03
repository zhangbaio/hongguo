package com.ss.ttvideoengine.configcenter;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class EngineConfig implements IEngineConfig {
    private static final Map<Integer, Object> defaultValueMap;
    private final ConfigItemFactory configItemFactory;
    private final boolean enableDiffCheck;
    private final Map<Integer, ConfigItem> itemMap;

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public Map<Integer, ConfigItem> getItemMap() {
        return this.itemMap;
    }

    public final class Builder {
        private final Map<Integer, ConfigItem> builderMap = new HashMap();

        static {
            Covode.recordClassIndex(652409);
        }

        public EngineConfig build() {
            return new EngineConfig(this.builderMap);
        }

        public Builder() {
        }

        public Builder setFloatOption(int i, float f) {
            this.builderMap.put(Integer.valueOf(i), EngineConfig.this.configItemFactory.createFloatOption(i, f));
            return this;
        }

        public Builder setIntOption(int i, int i2) {
            this.builderMap.put(Integer.valueOf(i), EngineConfig.this.configItemFactory.createIntOption(i, i2));
            return this;
        }

        public Builder setLongOption(int i, int i2) {
            this.builderMap.put(Integer.valueOf(i), EngineConfig.this.configItemFactory.createIntOption(i, i2));
            return this;
        }

        public Builder setStringOption(int i, String str) {
            this.builderMap.put(Integer.valueOf(i), EngineConfig.this.configItemFactory.createStringOption(i, str));
            return this;
        }
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public void reset() {
        this.itemMap.clear();
    }

    static {
        Covode.recordClassIndex(652408);
        HashMap hashMap = new HashMap();
        defaultValueMap = hashMap;
        hashMap.put(963, 1);
        hashMap.put(5, 3);
        hashMap.put(11, 30);
        hashMap.put(12, 5000000);
        hashMap.put(612, 1);
        hashMap.put(85, -1);
        hashMap.put(28, 30);
        hashMap.put(100, 1);
        hashMap.put(160, Integer.valueOf(EngineGlobalConfig.getInstance().isOnlyUseMediaLoader() ? 1 : 0));
        hashMap.put(110, -1);
        hashMap.put(310, -1);
        hashMap.put(675, -1);
        hashMap.put(956, -1);
        hashMap.put(1406, -1);
        hashMap.put(183, 1);
        hashMap.put(184, 1);
        hashMap.put(201, 500);
        hashMap.put(202, 5000);
        hashMap.put(851, 10);
        hashMap.put(852, 300);
        hashMap.put(853, 3);
        hashMap.put(862, 10);
        hashMap.put(863, 300);
        hashMap.put(864, 3);
        hashMap.put(950, 500);
        hashMap.put(207, 2);
        hashMap.put(208, 1);
        hashMap.put(215, 1);
        hashMap.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_DEFAULT_RENDER_TYPE), 3);
        hashMap.put(37, 1);
        hashMap.put(417, 1);
        hashMap.put(498, 1);
        hashMap.put(422, 1048576);
        hashMap.put(423, 409600);
        hashMap.put(474, 5000);
        hashMap.put(475, 10000);
        hashMap.put(424, 2);
        hashMap.put(427, 1);
        hashMap.put(430, -1);
        hashMap.put(476, 2);
        hashMap.put(500, 500);
        hashMap.put(504, 1);
        hashMap.put(574, 4);
        hashMap.put(506, 2);
        Resolution resolution = Resolution.Undefine;
        hashMap.put(502, Integer.valueOf(resolution.getIndex()));
        hashMap.put(544, Integer.valueOf(resolution.getIndex()));
        Resolution resolution2 = Resolution.SuperHigh;
        hashMap.put(536, Integer.valueOf(resolution2.getIndex()));
        hashMap.put(537, Integer.valueOf(resolution2.getIndex()));
        hashMap.put(334, -1);
        hashMap.put(335, -1);
        hashMap.put(341, -1);
        hashMap.put(342, -1);
        hashMap.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_SET_NETSPEED_LEVEL), -1);
        hashMap.put(489, 2);
        hashMap.put(491, 1000);
        hashMap.put(492, 1);
        hashMap.put(495, 1);
        hashMap.put(496, 1);
        hashMap.put(568, -1);
        hashMap.put(517, -3);
        hashMap.put(607, 5000000);
        hashMap.put(610, 1);
        hashMap.put(657, 300);
        hashMap.put(558, 1);
        hashMap.put(670, 1);
        hashMap.put(255, 3);
        hashMap.put(700, -1);
        hashMap.put(572, 1);
        hashMap.put(721, 1);
        hashMap.put(578, 1);
        hashMap.put(742, 1);
        hashMap.put(801, -1);
        hashMap.put(744, -1);
        hashMap.put(1219, 60);
        hashMap.put(325, Float.valueOf(0.25f));
        hashMap.put(326, Float.valueOf(-18.0f));
        hashMap.put(327, Float.valueOf(8.0f));
        hashMap.put(328, Float.valueOf(0.007f));
        hashMap.put(348, Float.valueOf(200.0f));
        hashMap.put(349, Float.valueOf(3.0f));
        hashMap.put(359, Float.valueOf(50.0f));
        hashMap.put(526, Float.valueOf(0.9f));
        hashMap.put(527, Float.valueOf(9.0f));
        hashMap.put(528, Float.valueOf(2.0f));
        hashMap.put(529, Float.valueOf(1.0f));
        hashMap.put(531, "");
        hashMap.put(355, "");
        hashMap.put(Integer.valueOf(TTVideoEngineInterface.PLAYER_OPTION_SUB_LANG_IDS), "");
        hashMap.put(546, "");
        hashMap.put(547, "");
        hashMap.put(1000, "h264");
        hashMap.put(4024, 4);
        hashMap.put(571, 1);
    }

    public EngineConfig(Map<Integer, ConfigItem> map) {
        this(false, map);
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem getOption(int i) {
        return this.itemMap.get(Integer.valueOf(i));
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public boolean isKeySet(int i) {
        return this.itemMap.containsKey(Integer.valueOf(i));
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public void remove(int i) {
        this.itemMap.remove(Integer.valueOf(i));
    }

    private Object getConfigItemValueOrDefault(int i) {
        try {
            if (this.itemMap.containsKey(Integer.valueOf(i))) {
                return this.itemMap.get(Integer.valueOf(i)).getValue();
            }
            return defaultValueMap.get(Integer.valueOf(i));
        } catch (Exception e) {
            TTVideoEngineLog.e("EngineConfig", e.getMessage());
            return null;
        }
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public float getFloatOption(int i) {
        Object configItemValueOrDefault = getConfigItemValueOrDefault(i);
        if (configItemValueOrDefault == null) {
            return 0.0f;
        }
        try {
            return ((Float) configItemValueOrDefault).floatValue();
        } catch (Exception e) {
            TTVideoEngineLog.e("EngineConfig", "key: " + i + ", " + e.getMessage());
            return 0.0f;
        }
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public int getIntOption(int i) {
        Object configItemValueOrDefault = getConfigItemValueOrDefault(i);
        if (configItemValueOrDefault == null) {
            return 0;
        }
        try {
            return ((Integer) configItemValueOrDefault).intValue();
        } catch (Exception e) {
            TTVideoEngineLog.e("EngineConfig", "key: " + i + ", " + e.getMessage());
            return 0;
        }
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public long getLongOption(int i) {
        Object configItemValueOrDefault = getConfigItemValueOrDefault(i);
        if (configItemValueOrDefault == null) {
            return 0L;
        }
        try {
            return ((Long) configItemValueOrDefault).longValue();
        } catch (Exception e) {
            TTVideoEngineLog.e("EngineConfig", "key: " + i + ", " + e.getMessage());
            return 0L;
        }
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public String getStringOption(int i) {
        Object configItemValueOrDefault = getConfigItemValueOrDefault(i);
        if (configItemValueOrDefault == null) {
            return "";
        }
        try {
            return (String) configItemValueOrDefault;
        } catch (Exception e) {
            TTVideoEngineLog.e("EngineConfig", "key: " + i + ", " + e.getMessage());
            return null;
        }
    }

    private boolean isSameString(String str, String str2) {
        return Objects.equals(str, str2);
    }

    public EngineConfig(boolean z, Map<Integer, ConfigItem> map) {
        this.configItemFactory = new ConfigItemFactory();
        this.enableDiffCheck = z;
        this.itemMap = map;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem setFloatOption(int i, float f) {
        if (this.enableDiffCheck && f == getFloatOption(i)) {
            TTVideoEngineLog.i("EngineConfig", "option value not changed");
            return null;
        }
        ConfigItem createFloatOption = this.configItemFactory.createFloatOption(i, f);
        if (createFloatOption != null) {
            this.itemMap.put(Integer.valueOf(i), createFloatOption);
        }
        return createFloatOption;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem setIntOption(int i, int i2) {
        if (this.enableDiffCheck && i2 == getIntOption(i)) {
            TTVideoEngineLog.i("EngineConfig", "option value not changed");
            return null;
        }
        ConfigItem createIntOption = this.configItemFactory.createIntOption(i, i2);
        if (createIntOption != null) {
            this.itemMap.put(Integer.valueOf(i), createIntOption);
        }
        return createIntOption;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem setLongOption(int i, long j) {
        if (this.enableDiffCheck && j == getLongOption(i)) {
            TTVideoEngineLog.i("EngineConfig", "option value not changed");
            return null;
        }
        ConfigItem createLongOption = this.configItemFactory.createLongOption(i, j);
        if (createLongOption != null) {
            this.itemMap.put(Integer.valueOf(i), createLongOption);
        }
        return createLongOption;
    }

    @Override // com.ss.ttvideoengine.configcenter.IEngineConfig
    public ConfigItem setStringOption(int i, String str) {
        if (this.enableDiffCheck && isSameString(str, getStringOption(i))) {
            TTVideoEngineLog.i("EngineConfig", "option value not changed");
            return null;
        }
        ConfigItem createStringOption = this.configItemFactory.createStringOption(i, str);
        if (createStringOption != null) {
            this.itemMap.put(Integer.valueOf(i), createStringOption);
        }
        return createStringOption;
    }
}
