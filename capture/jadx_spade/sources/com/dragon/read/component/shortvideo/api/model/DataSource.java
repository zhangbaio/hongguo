package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.b;
import com.dragon.read.component.shortvideo.data.saas.video.d;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DataSource implements Serializable {
    public static final a Companion;
    private static final long serialVersionUID = 0;
    public List<? extends d> mDataProviderList;
    public b mDetailModel;
    public String vid = "";
    public int videoPos;

    public static final class a {
        static {
            Covode.recordClassIndex(598763);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598762);
        Companion = new a(null);
    }
}
