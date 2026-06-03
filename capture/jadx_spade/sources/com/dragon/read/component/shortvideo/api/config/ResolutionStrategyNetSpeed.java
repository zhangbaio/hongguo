package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ResolutionStrategyNetSpeed {

    @SerializedName("check_net_type")
    public final int checkNetType;

    @SerializedName("network_speed")
    public final int networkSpeed;

    static {
        Covode.recordClassIndex(598251);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ResolutionStrategyNetSpeed() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ResolutionStrategyNetSpeed.<init>():void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolutionStrategyNetSpeed)) {
            return false;
        }
        ResolutionStrategyNetSpeed resolutionStrategyNetSpeed = (ResolutionStrategyNetSpeed) obj;
        return this.checkNetType == resolutionStrategyNetSpeed.checkNetType && this.networkSpeed == resolutionStrategyNetSpeed.networkSpeed;
    }

    public int hashCode() {
        return (this.checkNetType * 31) + this.networkSpeed;
    }

    public String toString() {
        return "ResolutionStrategyNetSpeed(checkNetType=" + this.checkNetType + ", networkSpeed=" + this.networkSpeed + ')';
    }

    public ResolutionStrategyNetSpeed(int i, int i2) {
        this.checkNetType = i;
        this.networkSpeed = i2;
    }

    public /* synthetic */ ResolutionStrategyNetSpeed(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
