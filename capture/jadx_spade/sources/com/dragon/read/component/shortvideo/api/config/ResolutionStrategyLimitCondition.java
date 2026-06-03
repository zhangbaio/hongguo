package com.dragon.read.component.shortvideo.api.config;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ResolutionStrategyLimitCondition {

    @SerializedName("check_net_speed")
    public final boolean checkNetSpeed;

    @SerializedName("is_wifi")
    public final boolean isWifi;

    @SerializedName("net_speed")
    public final ResolutionStrategyNetSpeed netSpeed;

    @SerializedName("period_type")
    public final String periodType;

    static {
        Covode.recordClassIndex(598250);
    }

    public ResolutionStrategyLimitCondition() {
        this(false, null, false, null, 15, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolutionStrategyLimitCondition)) {
            return false;
        }
        ResolutionStrategyLimitCondition resolutionStrategyLimitCondition = (ResolutionStrategyLimitCondition) obj;
        return this.isWifi == resolutionStrategyLimitCondition.isWifi && Intrinsics.areEqual(this.periodType, resolutionStrategyLimitCondition.periodType) && this.checkNetSpeed == resolutionStrategyLimitCondition.checkNetSpeed && Intrinsics.areEqual(this.netSpeed, resolutionStrategyLimitCondition.netSpeed);
    }

    public int hashCode() {
        int a = ((((m.a(this.isWifi) * 31) + this.periodType.hashCode()) * 31) + m.a(this.checkNetSpeed)) * 31;
        ResolutionStrategyNetSpeed resolutionStrategyNetSpeed = this.netSpeed;
        return a + (resolutionStrategyNetSpeed == null ? 0 : resolutionStrategyNetSpeed.hashCode());
    }

    public String toString() {
        return "ResolutionStrategyLimitCondition(isWifi=" + this.isWifi + ", periodType=" + this.periodType + ", checkNetSpeed=" + this.checkNetSpeed + ", netSpeed=" + this.netSpeed + ')';
    }

    public ResolutionStrategyLimitCondition(boolean z, String periodType, boolean z2, ResolutionStrategyNetSpeed resolutionStrategyNetSpeed) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        this.isWifi = z;
        this.periodType = periodType;
        this.checkNetSpeed = z2;
        this.netSpeed = resolutionStrategyNetSpeed;
    }

    public /* synthetic */ ResolutionStrategyLimitCondition(boolean z, String str, boolean z2, ResolutionStrategyNetSpeed resolutionStrategyNetSpeed, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "0" : str, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : resolutionStrategyNetSpeed);
    }
}
