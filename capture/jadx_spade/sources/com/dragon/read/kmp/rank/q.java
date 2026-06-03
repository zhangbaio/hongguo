package com.dragon.read.kmp.rank;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.x7;
import com.dragon.read.kmp.basenovel.ui.widget.staggered.RecyclerHolder;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q extends yh4.g<re4.e> {
    public static final int o;
    private final r m;
    private uh4.a n;

    static {
        Covode.recordClassIndex(608229);
        o = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(q qVar, re4.e eVar, int i, int i2, Composer composer, int i3) {
        qVar.H(eVar, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    public void Z() {
        super.Z();
        r rVar = this.m;
        if (rVar != null) {
            r.V0(rVar, false, null, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(wh4.i depend) {
        super(depend);
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.m = new r();
    }

    private final String t0(String str) {
        boolean z;
        boolean contains$default;
        com.dragon.read.kmp.base.l a;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "sub_selected_items", false, 2, (Object) null);
        if (!contains$default || (a = com.dragon.read.kmp.base.m.a(str)) == null) {
            return null;
        }
        return a.d("sub_selected_items");
    }

    private final ym4.a s0(int i) {
        int i2;
        String str;
        x7 x7Var;
        ym4.a aVar = new ym4.a();
        aVar.g("unlimited_content_type", "ranking_list");
        aVar.g("card_left_right_position", Q());
        uh4.a aVar2 = this.n;
        if (aVar2 != null) {
            i2 = aVar2.a(i);
        } else {
            i2 = 1;
        }
        aVar.g("rank", Integer.valueOf(i2));
        aVar.g("unlimited_content_ranking_list_type", this.m.a.a);
        aVar.g("display_card", "dual_column_card");
        re4.e eVar = (re4.e) ((RecyclerHolder) this).d;
        if (eVar != null && (x7Var = ((yh4.b) eVar).d) != null) {
            str = x7Var.g;
        } else {
            str = null;
        }
        aVar.g("unlimited_content_ranking_list_sub_type", t0(str));
        aVar.g("is_quick_respond_card", "1");
        aVar.g("responded_src_material_id", this.m.L0());
        aVar.g("category_tab_type", Integer.valueOf(zh4.a.a(((yh4.g) this).g)));
        aVar.g("module_name", "无限流");
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ym4.a p0(q qVar, int i) {
        return qVar.s0(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(q qVar, int i, re4.e eVar) {
        qVar.X(i, eVar);
        return Unit.INSTANCE;
    }

    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void H(final re4.e data, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        boolean changedInstance;
        int i6;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(-1082033822);
        if ((i2 & 6) == 0) {
            if ((i2 & 8) == 0) {
                changedInstance = startRestartGroup.changed(data);
            } else {
                changedInstance = startRestartGroup.changedInstance(data);
            }
            if (changedInstance) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(i)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changedInstance(this)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        boolean z4 = true;
        if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1082033822, i3, -1, "com.dragon.read.kmp.rank.KmpRank2ColViewHolder.bindContent (KmpRank2ColViewHolder.kt:21)");
            }
            this.n = (uh4.a) startRestartGroup.consume(ve4.b.c());
            this.m.E0(data);
            uh4.a aVar = this.n;
            if (aVar != null) {
                aVar.b(i);
            }
            r rVar = this.m;
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance2 = startRestartGroup.changedInstance(this);
            int i7 = i3 & 112;
            if (i7 == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z5 = changedInstance2 | z2;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: com.dragon.read.kmp.rank.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        ym4.a p0;
                        p0 = q.p0(q.this, i);
                        return p0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            rVar.Y0((Function0) rememberedValue);
            r rVar2 = this.m;
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changedInstance3 = startRestartGroup.changedInstance(this);
            if (i7 == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z6 = changedInstance3 | z3;
            if ((i3 & 14) != 4 && ((i3 & 8) == 0 || !startRestartGroup.changedInstance(data))) {
                z4 = false;
            }
            boolean z7 = z6 | z4;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.rank.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit q0;
                        q0 = q.q0(q.this, i, data);
                        return q0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            rVar2.Z0((Function0) rememberedValue2);
            r rVar3 = this.m;
            m.l(rVar3, rVar3.a, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.rank.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit r0;
                    r0 = q.r0(q.this, data, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return r0;
                }
            });
        }
    }
}
