package com.ss.ttvideoengine.configcenter;

import com.bytedance.covode.number.Covode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ConfigItem {
    public static final ConfigItem EMPTY;
    protected final int configKey;
    protected final Object itemValue;
    protected final int moduleType;
    protected final int priority;
    protected final int valueType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ModuleType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ValueType {
    }

    public int getPriority() {
        return this.priority;
    }

    public Object getValue() {
        return this.itemValue;
    }

    static {
        Covode.recordClassIndex(652404);
        EMPTY = new ConfigItem(-1, null, 0, 1, 0);
    }

    public ConfigItem(int i, Object obj, int i2, int i3, int i4) {
        this.configKey = i;
        this.itemValue = obj;
        this.valueType = i3;
        this.moduleType = i4;
        this.priority = i2;
    }
}
