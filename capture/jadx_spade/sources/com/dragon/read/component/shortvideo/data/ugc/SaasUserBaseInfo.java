package com.dragon.read.component.shortvideo.data.ugc;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasUserBaseInfo implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private Long actorID;

    public static final class a {
        static {
            Covode.recordClassIndex(599139);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599138);
        Companion = new a(null);
    }

    public final Long getActorID() {
        return this.actorID;
    }

    public final void setActorID(Long l) {
        this.actorID = l;
    }
}
