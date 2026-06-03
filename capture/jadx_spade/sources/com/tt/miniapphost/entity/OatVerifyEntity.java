package com.tt.miniapphost.entity;

import androidx.compose.animation.m;
import androidx.compose.ui.graphics.colorspace.f0;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class OatVerifyEntity {
    private final double oatVerifyDuration;
    private final String oatVerifyResult;
    private final boolean switchToHost;

    static {
        Covode.recordClassIndex(654127);
    }

    public OatVerifyEntity() {
        this(0.0d, null, false, 7, null);
    }

    public static /* synthetic */ OatVerifyEntity copy$default(OatVerifyEntity oatVerifyEntity, double d, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            d = oatVerifyEntity.oatVerifyDuration;
        }
        if ((i & 2) != 0) {
            str = oatVerifyEntity.oatVerifyResult;
        }
        if ((i & 4) != 0) {
            z = oatVerifyEntity.switchToHost;
        }
        return oatVerifyEntity.copy(d, str, z);
    }

    public final double component1() {
        return this.oatVerifyDuration;
    }

    public final String component2() {
        return this.oatVerifyResult;
    }

    public final boolean component3() {
        return this.switchToHost;
    }

    public final OatVerifyEntity copy(double d, String oatVerifyResult, boolean z) {
        Intrinsics.checkNotNullParameter(oatVerifyResult, "oatVerifyResult");
        return new OatVerifyEntity(d, oatVerifyResult, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OatVerifyEntity)) {
            return false;
        }
        OatVerifyEntity oatVerifyEntity = (OatVerifyEntity) obj;
        return Double.compare(this.oatVerifyDuration, oatVerifyEntity.oatVerifyDuration) == 0 && Intrinsics.areEqual(this.oatVerifyResult, oatVerifyEntity.oatVerifyResult) && this.switchToHost == oatVerifyEntity.switchToHost;
    }

    public int hashCode() {
        return (((f0.a(this.oatVerifyDuration) * 31) + this.oatVerifyResult.hashCode()) * 31) + m.a(this.switchToHost);
    }

    public final double getOatVerifyDuration() {
        return this.oatVerifyDuration;
    }

    public final String getOatVerifyResult() {
        return this.oatVerifyResult;
    }

    public final boolean getSwitchToHost() {
        return this.switchToHost;
    }

    public String toString() {
        return "{duration=" + this.oatVerifyDuration + "ms, result=" + this.oatVerifyResult + ", switchToHost=" + this.switchToHost + '}';
    }

    public OatVerifyEntity(double d, String oatVerifyResult, boolean z) {
        Intrinsics.checkNotNullParameter(oatVerifyResult, "oatVerifyResult");
        this.oatVerifyDuration = d;
        this.oatVerifyResult = oatVerifyResult;
        this.switchToHost = z;
    }

    public /* synthetic */ OatVerifyEntity(double d, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1.0d : d, (i & 2) != 0 ? "NO_NEED" : str, (i & 4) != 0 ? false : z);
    }
}
