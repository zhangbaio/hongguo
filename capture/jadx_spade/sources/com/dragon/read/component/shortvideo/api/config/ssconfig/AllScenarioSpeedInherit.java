package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AllScenarioSpeedInherit {
    public static final a a;
    private static final Lazy<AllScenarioSpeedInherit> b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("persistent")
    public final boolean persistent;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AllScenarioSpeedInherit() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.AllScenarioSpeedInherit.<init>():void");
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598318);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AllScenarioSpeedInherit a() {
            return (AllScenarioSpeedInherit) AllScenarioSpeedInherit.b.getValue();
        }
    }

    static {
        Lazy<AllScenarioSpeedInherit> lazy;
        Covode.recordClassIndex(598317);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AllScenarioSpeedInherit c;
                c = AllScenarioSpeedInherit.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AllScenarioSpeedInherit c() {
        boolean z = false;
        return (AllScenarioSpeedInherit) qq3.a.c("all_scenario_speed_inherit_opt_v663", new AllScenarioSpeedInherit(z, z, 3, null), false, 4, null);
    }

    public AllScenarioSpeedInherit(boolean z, boolean z2) {
        this.enable = z;
        this.persistent = z2;
    }

    public /* synthetic */ AllScenarioSpeedInherit(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
