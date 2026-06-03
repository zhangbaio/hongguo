package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasClipVideoHighlight implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;

    @SerializedName("length_time_in_millisecond")
    private int lengthTimeInMillisecond;

    @SerializedName("start_time_in_millisecond")
    private int startTimeInMillisecond;
    private long vid;

    public static final class a {
        static {
            Covode.recordClassIndex(599092);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599091);
        Companion = new a(null);
    }

    public final int getLengthTimeInMillisecond() {
        return this.lengthTimeInMillisecond;
    }

    public final int getStartTimeInMillisecond() {
        return this.startTimeInMillisecond;
    }

    public final long getVid() {
        return this.vid;
    }

    public String toString() {
        return "SaasClipVideoHighlight(startTimeInMillisecond=" + this.startTimeInMillisecond + ", lengthTimeInMillisecond=" + this.lengthTimeInMillisecond + ", vid=" + this.vid + ')';
    }

    public final void setLengthTimeInMillisecond(int i) {
        this.lengthTimeInMillisecond = i;
    }

    public final void setStartTimeInMillisecond(int i) {
        this.startTimeInMillisecond = i;
    }

    public final void setVid(long j) {
        this.vid = j;
    }
}
