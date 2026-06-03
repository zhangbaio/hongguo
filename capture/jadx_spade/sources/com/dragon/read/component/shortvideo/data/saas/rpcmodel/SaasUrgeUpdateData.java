package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasUrgeUpdateData implements Serializable {
    public static final a Companion;
    public static final long serialVersionUID = 0;

    @SerializedName("is_user_urged")
    private boolean isUserUrged;

    @SerializedName("show_urge_button")
    private boolean showUrgeButton;

    @SerializedName("total_cnt")
    private long totalCnt;

    public static final class a {
        static {
            Covode.recordClassIndex(599106);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599105);
        Companion = new a(null);
    }

    public static /* synthetic */ SaasUrgeUpdateData copy$default(SaasUrgeUpdateData saasUrgeUpdateData, boolean z, boolean z2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = saasUrgeUpdateData.showUrgeButton;
        }
        if ((i & 2) != 0) {
            z2 = saasUrgeUpdateData.isUserUrged;
        }
        if ((i & 4) != 0) {
            j = saasUrgeUpdateData.totalCnt;
        }
        return saasUrgeUpdateData.copy(z, z2, j);
    }

    public final boolean component1() {
        return this.showUrgeButton;
    }

    public final boolean component2() {
        return this.isUserUrged;
    }

    public final long component3() {
        return this.totalCnt;
    }

    public final SaasUrgeUpdateData copy(boolean z, boolean z2, long j) {
        return new SaasUrgeUpdateData(z, z2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SaasUrgeUpdateData)) {
            return false;
        }
        SaasUrgeUpdateData saasUrgeUpdateData = (SaasUrgeUpdateData) obj;
        return this.showUrgeButton == saasUrgeUpdateData.showUrgeButton && this.isUserUrged == saasUrgeUpdateData.isUserUrged && this.totalCnt == saasUrgeUpdateData.totalCnt;
    }

    public int hashCode() {
        return (((m.a(this.showUrgeButton) * 31) + m.a(this.isUserUrged)) * 31) + j.a(this.totalCnt);
    }

    public String toString() {
        return "SaasUrgeUpdateData(showUrgeButton=" + this.showUrgeButton + ", isUserUrged=" + this.isUserUrged + ", totalCnt=" + this.totalCnt + ')';
    }

    public final boolean getShowUrgeButton() {
        return this.showUrgeButton;
    }

    public final long getTotalCnt() {
        return this.totalCnt;
    }

    public final boolean isUserUrged() {
        return this.isUserUrged;
    }

    public final void setShowUrgeButton(boolean z) {
        this.showUrgeButton = z;
    }

    public final void setTotalCnt(long j) {
        this.totalCnt = j;
    }

    public final void setUserUrged(boolean z) {
        this.isUserUrged = z;
    }

    public SaasUrgeUpdateData(boolean z, boolean z2, long j) {
        this.showUrgeButton = z;
        this.isUserUrged = z2;
        this.totalCnt = j;
    }
}
