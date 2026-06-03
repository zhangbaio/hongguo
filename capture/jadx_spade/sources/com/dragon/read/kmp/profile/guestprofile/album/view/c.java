package com.dragon.read.kmp.profile.guestprofile.album.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.e2;
import androidx.compose.ui.graphics.f2;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.text.l0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SeriesStatus;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.bn0;
import com.bytedance.kmp.reading.model.d1;
import com.bytedance.kmp.reading.model.d6;
import com.bytedance.kmp.reading.model.e50;
import com.bytedance.kmp.reading.model.f0;
import com.bytedance.kmp.reading.model.jm0;
import com.bytedance.kmp.reading.model.jn0;
import com.bytedance.kmp.reading.model.km0;
import com.bytedance.kmp.reading.model.n2;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.q20;
import com.bytedance.kmp.reading.model.qn0;
import com.bytedance.kmp.reading.model.r50;
import com.bytedance.kmp.reading.model.rm0;
import com.bytedance.kmp.reading.model.vd0;
import com.bytedance.kmp.reading.model.xm0;
import com.bytedance.kmp.reading.model.zm0;
import com.dragon.read.kmp.utils.g0;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(608128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(com.dragon.read.rpc.kmp.community.model.z zVar, boolean z, Function0 function0, int i, Composer composer, int i2) {
        c(zVar, z, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final om0 f(com.dragon.read.rpc.kmp.community.model.z zVar) {
        String str;
        String str2 = zVar.a;
        String str3 = zVar.b;
        String str4 = "";
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        int value = VideoContentType.Album.getValue();
        String str5 = zVar.d;
        if (str5 != null) {
            str4 = str5;
        }
        return new om0((String) null, str4, (Long) null, (d1) null, str, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (f0) null, (String) null, str2, (Long) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, Integer.valueOf(value), (String) null, (String) null, (Boolean) null, (Long) null, (Boolean) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, Long.valueOf(g0.c(zVar.g)), (Boolean) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Map) null, (Integer) null, (String) null, (String) null, (List) null, (Integer) null, (Integer) null, (Long) null, (Boolean) null, (String) null, (Long) null, (String) null, (rm0) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (xm0) null, (String) null, Integer.valueOf(SeriesStatus.SeriesUpdating.getValue()), (List) null, (List) null, (bn0) null, (String) null, (Long) null, (String) null, (qn0) null, (String) null, (Long) null, (List) null, (List) null, (Boolean) null, (List) null, (List) null, (Integer) null, (qn0) null, (d6) null, (Boolean) null, (String) null, (String) null, (String) null, (e50) null, (String) null, (Boolean) null, (Boolean) null, (jm0) null, (Integer) null, (Boolean) null, (Boolean) null, (String) null, (zm0) null, (vd0) null, (String) null, (String) null, (List) null, (q20) null, (List) null, (Integer) null, (n2) null, (String) null, (List) null, (r50) null, (km0) null, (jn0) null, (Long) null, (String) null, (Long) null, (List) null, (String) null, (Boolean) null, (Boolean) null, -16810003, -129, -33, 33554431, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(com.dragon.read.rpc.kmp.community.model.z zVar, Function0 function0) {
        kd4.c.a(f(zVar), "", false);
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void c(final com.dragon.read.rpc.kmp.community.model.z albumData, final boolean z, final Function0<Unit> click, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        String str;
        long o;
        long T2;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(albumData, "albumData");
        Intrinsics.checkNotNullParameter(click, "click");
        Composer startRestartGroup = composer.startRestartGroup(-2017782881);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(albumData)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(click)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        boolean z3 = true;
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2017782881, i2, -1, "com.dragon.read.kmp.profile.guestprofile.album.view.AlbumCollectionButton (AlbumCollectionButton.kt:40)");
            }
            if (z) {
                str = "已收藏";
            } else {
                str = "收藏";
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = Boolean.valueOf(il4.a.Companion.a().b);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            boolean booleanValue = ((Boolean) rememberedValue).booleanValue();
            startRestartGroup.endReplaceGroup();
            Modifier c = ig4.i.c(SizeKt.u(Modifier.Companion, x0.i.g(60), x0.i.g(28)), x0.i.d(x0.i.g(8)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
            if (booleanValue) {
                startRestartGroup.startReplaceGroup(592916137);
                if (z) {
                    startRestartGroup.startReplaceGroup(592949400);
                    o = og4.a.a.h(startRestartGroup, og4.a.b).o();
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(593028977);
                    o = og4.a.a.h(startRestartGroup, og4.a.b).x();
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(593133664);
                o = og4.a.a.h(startRestartGroup, og4.a.b).o();
                startRestartGroup.endReplaceGroup();
            }
            Modifier d = BackgroundKt.d(c, o, (f2) null, 2, (Object) null);
            float f = 1.0f;
            if (!booleanValue && z) {
                f = 0.5f;
            }
            Modifier t = androidx.compose.foundation.layout.f2.t(androidx.compose.ui.draw.a.a(d, f), 0.0f, x0.i.g(6), 1, (Object) null);
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changedInstance = startRestartGroup.changedInstance(albumData);
            if ((i2 & 896) != 256) {
                z3 = false;
            }
            boolean z4 = changedInstance | z3;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit d2;
                        d2 = c.d(albumData, click);
                        return d2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(t, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null);
            p0 i6 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.e(), false);
            int a = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a2 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a2);
            } else {
                startRestartGroup.useNode();
            }
            Composer b = g5.b(startRestartGroup);
            g5.e(b, i6, companion2.c());
            g5.e(b, currentCompositionLocalMap, companion2.e());
            Function2 b2 = companion2.b();
            if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                b.updateRememberedValue(Integer.valueOf(a));
                b.apply(Integer.valueOf(a), b2);
            }
            g5.e(b, e, companion2.d());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
            long h = x0.x.h(12);
            long h2 = x0.x.h(16);
            if (booleanValue) {
                startRestartGroup.startReplaceGroup(-848389803);
                if (z) {
                    startRestartGroup.startReplaceGroup(-848353967);
                    T2 = og4.a.a.h(startRestartGroup, og4.a.b).T2();
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-848261711);
                    T2 = og4.a.a.h(startRestartGroup, og4.a.b).f();
                    startRestartGroup.endReplaceGroup();
                }
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-848147879);
                T2 = og4.a.a.h(startRestartGroup, og4.a.b).T2();
                startRestartGroup.endReplaceGroup();
            }
            composer2 = startRestartGroup;
            String str2 = str;
            a6.j(str2, (Modifier) null, 0L, 0L, (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, w0.h.h(w0.h.b.a()), 0L, w0.s.b.b(), false, 1, 0, (Function1) null, new g3(T2, h, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, h2, (w0.q) null, (l0) null, (w0.g) null, 0, 0, (w0.r) null, 16646140, (DefaultConstructorMarker) null), composer2, 196608, 3120, 54750);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.album.view.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit e2;
                    e2 = c.e(albumData, z, click, i, (Composer) obj, ((Integer) obj2).intValue());
                    return e2;
                }
            });
        }
    }
}
