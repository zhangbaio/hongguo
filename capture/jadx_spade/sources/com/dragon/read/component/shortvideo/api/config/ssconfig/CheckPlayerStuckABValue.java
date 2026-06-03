package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CheckPlayerStuckABValue {
    public static final a a;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("prepare_timeout")
    public final int prepareTimeOut;

    @SerializedName("replay_when_state_err")
    public final boolean retryWhenStateErr;

    @SerializedName("stuck_timeout")
    public final int stuckTimeOut;

    public static final class a {
        static {
            Covode.recordClassIndex(598325);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598324);
        a = new a(null);
    }

    public CheckPlayerStuckABValue() {
        this(false, 0, 0, false, 15, null);
    }

    public CheckPlayerStuckABValue(boolean z, int i, int i2, boolean z2) {
        this.enable = z;
        this.prepareTimeOut = i;
        this.stuckTimeOut = i2;
        this.retryWhenStateErr = z2;
    }

    public /* synthetic */ CheckPlayerStuckABValue(boolean z, int i, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 2000 : i, (i3 & 4) != 0 ? 10000 : i2, (i3 & 8) != 0 ? false : z2);
    }
}
