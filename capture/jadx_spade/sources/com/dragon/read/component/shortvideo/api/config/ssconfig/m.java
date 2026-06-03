package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ssconfig.SsConfigMgr;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m extends EnableShortSeriesGuideAnimABValue {
    public static final a c;
    public static final int d;
    private static final m e;

    public static final class a {
        static {
            Covode.recordClassIndex(598342);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public m() {
        super(false, 1, null);
    }

    static {
        Covode.recordClassIndex(598341);
        c = new a(null);
        d = 8;
        SsConfigMgr.prepareAB("enable_short_series_guide_anim_v657", m.class, IEnableShortSeriesGuideAnim.class);
        e = new m();
    }
}
