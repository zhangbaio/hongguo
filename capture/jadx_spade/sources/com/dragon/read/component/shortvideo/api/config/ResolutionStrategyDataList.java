package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ResolutionStrategyDataList {

    @SerializedName("resolution_strategy_list")
    public final List<ResolutionStrategyData> list;

    static {
        Covode.recordClassIndex(598249);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResolutionStrategyDataList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResolutionStrategyDataList) && Intrinsics.areEqual(this.list, ((ResolutionStrategyDataList) obj).list);
    }

    public int hashCode() {
        List<ResolutionStrategyData> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "ResolutionStrategyDataList(list=" + this.list + ')';
    }

    public ResolutionStrategyDataList(List<ResolutionStrategyData> list) {
        this.list = list;
    }

    public /* synthetic */ ResolutionStrategyDataList(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }
}
