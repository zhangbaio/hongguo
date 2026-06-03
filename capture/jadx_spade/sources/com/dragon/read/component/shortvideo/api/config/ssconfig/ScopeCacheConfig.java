package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ScopeCacheConfig {

    @SerializedName("ghost_size")
    public final int ghostSize;

    @SerializedName("max_entries")
    public final int maxEntries;

    @SerializedName("protected_ratio")
    public final float protectedRatio;

    @SerializedName("ttl_seconds")
    public final int ttlSeconds;

    static {
        Covode.recordClassIndex(598467);
    }

    public ScopeCacheConfig() {
        this(0, 0, 0.0f, 0, 15, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScopeCacheConfig)) {
            return false;
        }
        ScopeCacheConfig scopeCacheConfig = (ScopeCacheConfig) obj;
        return this.maxEntries == scopeCacheConfig.maxEntries && this.ttlSeconds == scopeCacheConfig.ttlSeconds && Float.compare(this.protectedRatio, scopeCacheConfig.protectedRatio) == 0 && this.ghostSize == scopeCacheConfig.ghostSize;
    }

    public int hashCode() {
        return (((((this.maxEntries * 31) + this.ttlSeconds) * 31) + Float.floatToIntBits(this.protectedRatio)) * 31) + this.ghostSize;
    }

    public String toString() {
        return "ScopeCacheConfig(maxEntries=" + this.maxEntries + ", ttlSeconds=" + this.ttlSeconds + ", protectedRatio=" + this.protectedRatio + ", ghostSize=" + this.ghostSize + ')';
    }

    public ScopeCacheConfig(int i, int i2, float f, int i3) {
        this.maxEntries = i;
        this.ttlSeconds = i2;
        this.protectedRatio = f;
        this.ghostSize = i3;
    }

    public /* synthetic */ ScopeCacheConfig(int i, int i2, float f, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? Integer.MAX_VALUE : i, (i4 & 2) != 0 ? Integer.MAX_VALUE : i2, (i4 & 4) != 0 ? 0.5f : f, (i4 & 8) != 0 ? Integer.MAX_VALUE : i3);
    }
}
