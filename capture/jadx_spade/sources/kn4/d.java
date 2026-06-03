package kn4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.search.feed.holder.h2;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d implements a {
    public static final d b;
    public static final int c;
    private final /* synthetic */ a a;

    static {
        Covode.recordClassIndex(608799);
        b = new d();
        c = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(d dVar, h2 h2Var, int i, Composer composer, int i2) {
        dVar.q9(h2Var, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    @Override // kn4.a
    public int A8() {
        return this.a.A8();
    }

    @Override // kn4.a
    public int D6() {
        return this.a.D6();
    }

    @Override // kn4.a
    public String F9(int i) {
        return this.a.F9(i);
    }

    @Override // kn4.a
    public int Z2() {
        return this.a.Z2();
    }

    @Override // kn4.a
    public int Z8() {
        return this.a.Z8();
    }

    @Override // kn4.a
    public boolean a0() {
        return this.a.a0();
    }

    @Override // kn4.a
    public String getDesc() {
        return this.a.getDesc();
    }

    @Override // kn4.a
    public int l8() {
        return this.a.l8();
    }

    @Override // kn4.a
    public void q9(final h2 data, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(1144363139);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(data) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(this) : startRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1144363139, i2, -1, "com.dragon.read.kmp.search.service.KmpSearchBs.SearchEmptyButton (SearchBs.kt:0)");
            }
            this.a.q9(data, startRestartGroup, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: kn4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit F0;
                    F0 = d.F0(d.this, data, i, (Composer) obj, ((Integer) obj2).intValue());
                    return F0;
                }
            });
        }
    }

    private d() {
        eo0.a a = eo0.c.a.a(Reflection.getOrCreateKotlinClass(a.class));
        Intrinsics.checkNotNull(a);
        this.a = (a) a;
    }
}
