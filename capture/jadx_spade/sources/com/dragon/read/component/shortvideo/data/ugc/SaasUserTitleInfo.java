package com.dragon.read.component.shortvideo.data.ugc;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SaasUserTitleInfo implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    private String enTitle;
    private String label;
    private String zhTitle;

    public static final class a {
        static {
            Covode.recordClassIndex(599143);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(599142);
        Companion = new a(null);
    }

    public final String getEnTitle() {
        return this.enTitle;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getZhTitle() {
        return this.zhTitle;
    }

    public final void setEnTitle(String str) {
        this.enTitle = str;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final void setZhTitle(String str) {
        this.zhTitle = str;
    }
}
