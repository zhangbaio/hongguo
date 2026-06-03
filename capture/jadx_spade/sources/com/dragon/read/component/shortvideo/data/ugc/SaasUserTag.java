package com.dragon.read.component.shortvideo.data.ugc;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasUserTag implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private Integer creatorType;
    private Boolean isTopConsume = Boolean.FALSE;
    private List<SaasUserTitleInfo> userTitleInfo;

    public static final class a {
        static {
            Covode.recordClassIndex(599141);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599140);
        Companion = new a(null);
    }

    public final Integer getCreatorType() {
        return this.creatorType;
    }

    public final List<SaasUserTitleInfo> getUserTitleInfo() {
        return this.userTitleInfo;
    }

    public final Boolean isTopConsume() {
        return this.isTopConsume;
    }

    public final void setCreatorType(Integer num) {
        this.creatorType = num;
    }

    public final void setTopConsume(Boolean bool) {
        this.isTopConsume = bool;
    }

    public final void setUserTitleInfo(List<SaasUserTitleInfo> list) {
        this.userTitleInfo = list;
    }
}
