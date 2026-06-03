package com.dragon.read.component.shortvideo.api.config;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ResolutionStrategyData {

    @SerializedName("ignore_peak")
    public final boolean ignorePeak;

    @SerializedName("keep_alive_duration")
    public final int keepAliveDuration;

    @SerializedName("limit_condition")
    public final ResolutionStrategyLimitCondition limitCondition;

    @SerializedName("suggest_resolution_type")
    public final String resolution;

    static {
        Covode.recordClassIndex(598248);
    }

    public ResolutionStrategyData() {
        this(null, false, null, 0, 15, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolutionStrategyData)) {
            return false;
        }
        ResolutionStrategyData resolutionStrategyData = (ResolutionStrategyData) obj;
        return Intrinsics.areEqual(this.resolution, resolutionStrategyData.resolution) && this.ignorePeak == resolutionStrategyData.ignorePeak && Intrinsics.areEqual(this.limitCondition, resolutionStrategyData.limitCondition) && this.keepAliveDuration == resolutionStrategyData.keepAliveDuration;
    }

    public int hashCode() {
        String str = this.resolution;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + m.a(this.ignorePeak)) * 31;
        ResolutionStrategyLimitCondition resolutionStrategyLimitCondition = this.limitCondition;
        return ((hashCode + (resolutionStrategyLimitCondition != null ? resolutionStrategyLimitCondition.hashCode() : 0)) * 31) + this.keepAliveDuration;
    }

    public String toString() {
        return "ResolutionStrategyData(resolution=" + this.resolution + ", ignorePeak=" + this.ignorePeak + ", limitCondition=" + this.limitCondition + ", keepAliveDuration=" + this.keepAliveDuration + ')';
    }

    public ResolutionStrategyData(String str, boolean z, ResolutionStrategyLimitCondition resolutionStrategyLimitCondition, int i) {
        this.resolution = str;
        this.ignorePeak = z;
        this.limitCondition = resolutionStrategyLimitCondition;
        this.keepAliveDuration = i;
    }

    public /* synthetic */ ResolutionStrategyData(String str, boolean z, ResolutionStrategyLimitCondition resolutionStrategyLimitCondition, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : resolutionStrategyLimitCondition, (i2 & 8) != 0 ? 0 : i);
    }
}
