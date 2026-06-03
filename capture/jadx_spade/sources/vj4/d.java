package vj4;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.f;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.y1;
import androidx.compose.material.TabRowDefaults;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.i;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.uicontext.appstyle.ThemeType;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.mine.model.h;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pg4.p;
import vj4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(607685);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Modifier modifier, List list, vj4.a aVar, Function1 function1, int i, int i2, Composer composer, int i3) {
        b(modifier, list, aVar, function1, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Modifier a;
        final /* synthetic */ List<h> b;
        final /* synthetic */ Function1<h, Unit> c;
        final /* synthetic */ vj4.a d;

        /* JADX WARN: Multi-variable type inference failed */
        a(Modifier modifier, List<h> list, Function1<? super h, Unit> function1, vj4.a aVar) {
            this.a = modifier;
            this.b = list;
            this.c = function1;
            this.d = aVar;
        }

        /* renamed from: vj4.d$a$a, reason: collision with other inner class name */
        static final class C0279a implements Function0<Unit> {
            final /* synthetic */ Function1<h, Unit> a;
            final /* synthetic */ h b;

            /* JADX WARN: Multi-variable type inference failed */
            C0279a(Function1<? super h, Unit> function1, h hVar) {
                this.a = function1;
                this.b = hVar;
            }

            public final void a() {
                this.a.invoke(this.b);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public static final class b implements Function1<Integer, Object> {
            final /* synthetic */ List a;

            public b(List list) {
                this.a = list;
            }

            public final Object a(int i) {
                this.a.get(i);
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return a(num.intValue());
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            b(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2010476940, i, -1, "com.dragon.read.kmp.mine.login.SelectPhoneCodeList.<anonymous> (SelectPhoneCodeList.kt:30)");
                }
                Modifier modifier = this.a;
                final List<h> list = this.b;
                final Function1<h, Unit> function1 = this.c;
                final vj4.a aVar = this.d;
                p0 a = x.a(e.a.i(), androidx.compose.ui.e.a.k(), composer, 0);
                int a2 = j.a(i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, modifier);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a3 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a3);
                } else {
                    composer.useNode();
                }
                Composer b2 = g5.b(composer);
                g5.e(b2, a, companion.c());
                g5.e(b2, currentCompositionLocalMap, companion.e());
                Function2 b3 = companion.b();
                if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                    b2.updateRememberedValue(Integer.valueOf(a2));
                    b2.apply(Integer.valueOf(a2), b3);
                }
                g5.e(b2, e, companion.d());
                c0 c0Var = c0.b;
                composer.startReplaceGroup(-1746271574);
                boolean changedInstance = composer.changedInstance(list) | composer.changed(function1) | composer.changed(aVar);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: vj4.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit c2;
                            c2 = d.a.c(list, function1, aVar, (o0) obj);
                            return c2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                androidx.compose.foundation.lazy.d.c((Modifier) null, (LazyListState) null, (i2) null, false, (e.m) null, (e.b) null, (l1) null, false, (y1) null, (Function1) rememberedValue, composer, 0, MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        public static final class c implements Function4<f, Integer, Composer, Integer, Unit> {
            final /* synthetic */ List a;
            final /* synthetic */ Function1 b;
            final /* synthetic */ List c;
            final /* synthetic */ vj4.a d;

            public c(List list, Function1 function1, List list2, vj4.a aVar) {
                this.a = list;
                this.b = function1;
                this.c = list2;
                this.d = aVar;
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(f fVar, Integer num, Composer composer, Integer num2) {
                a(fVar, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void a(f fVar, int i, Composer composer, int i2) {
                int i3;
                boolean z;
                int i4;
                int i5;
                if ((i2 & 6) == 0) {
                    if (composer.changed(fVar)) {
                        i5 = 4;
                    } else {
                        i5 = 2;
                    }
                    i3 = i2 | i5;
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composer.changed(i)) {
                        i4 = 32;
                    } else {
                        i4 = 16;
                    }
                    i3 |= i4;
                }
                boolean z2 = true;
                if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i3 & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    int i6 = (i3 & 112) | (i3 & 14);
                    h hVar = (h) this.a.get(i);
                    composer.startReplaceGroup(1171594542);
                    Modifier.a aVar = Modifier.Companion;
                    Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                    composer.startReplaceGroup(-1633490746);
                    boolean changed = composer.changed(this.b);
                    if ((((i6 & 896) ^ 384) <= 256 || !composer.changed(hVar)) && (i6 & 384) != 256) {
                        z2 = false;
                    }
                    boolean z3 = changed | z2;
                    Object rememberedValue = composer.rememberedValue();
                    if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new C0279a(this.b, hVar);
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    float f = 16;
                    Modifier s = f2.s(ClickableKt.clickable-oSLSa3U$default(h, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null), x0.i.g(f), x0.i.g(f));
                    p0 b = r2.b(androidx.compose.foundation.layout.e.a.h(), androidx.compose.ui.e.a.i(), composer, 48);
                    int a = j.a(i.b(composer, 0));
                    e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer, s);
                    ComposeUiNode.Companion companion = ComposeUiNode.o0;
                    Function0 a2 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a2);
                    } else {
                        composer.useNode();
                    }
                    Composer b2 = g5.b(composer);
                    g5.e(b2, b, companion.c());
                    g5.e(b2, currentCompositionLocalMap, companion.e());
                    Function2 b3 = companion.b();
                    if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a))) {
                        b2.updateRememberedValue(Integer.valueOf(a));
                        b2.apply(Integer.valueOf(a), b3);
                    }
                    g5.e(b2, e, companion.d());
                    w2 w2Var = w2.b;
                    String str = hVar.b;
                    Modifier a3 = u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null);
                    androidx.compose.ui.text.font.c0 c0Var = this.d.a;
                    long h2 = x0.x.h(14);
                    og4.a aVar2 = og4.a.a;
                    int i7 = og4.a.b;
                    a6.j(str, a3, aVar2.h(composer, i7).k(), h2, (y) null, c0Var, (j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131024);
                    a6.j('+' + hVar.a, (Modifier) null, aVar2.h(composer, i7).h(), x0.x.h(14), (y) null, (androidx.compose.ui.text.font.c0) null, (j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                    composer.endNode();
                    composer.startReplaceGroup(869106443);
                    if (i != CollectionsKt__CollectionsKt.getLastIndex(this.c)) {
                        TabRowDefaults.a.c(f2.t(aVar, x0.i.g(f), 0.0f, 2, (Object) null), x0.i.g((float) 0.5d), aVar2.h(composer, i7).t(), composer, (TabRowDefaults.e << 9) | 54, 0);
                    }
                    composer.endReplaceGroup();
                    composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(List list, Function1 function1, vj4.a aVar, o0 LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            LazyColumn.f(list.size(), (Function1) null, new b(list), t.c(2039820996, true, new c(list, function1, list, aVar)));
            return Unit.INSTANCE;
        }
    }

    public static final void b(Modifier modifier, final List<h> list, vj4.a aVar, final Function1<? super h, Unit> onItemClick, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        vj4.a aVar2;
        int i6;
        boolean z;
        Modifier modifier3;
        int i7;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Composer startRestartGroup = composer.startRestartGroup(140586203);
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i3 = i4 | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(list)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                aVar2 = aVar;
                if (startRestartGroup.changed(aVar2)) {
                    i7 = 256;
                    i3 |= i7;
                }
            } else {
                aVar2 = aVar;
            }
            i7 = 128;
            i3 |= i7;
        } else {
            aVar2 = aVar;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(onItemClick)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i3 & 1)) {
            startRestartGroup.startDefaults();
            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                modifier3 = modifier2;
            } else {
                if (i8 != 0) {
                    modifier3 = SizeKt.f(Modifier.Companion, 0.0f, 1, (Object) null);
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    aVar2 = new vj4.a(null, 1, null);
                }
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(140586203, i3, -1, "com.dragon.read.kmp.mine.login.SelectPhoneCodeList (SelectPhoneCodeList.kt:28)");
            }
            p.f(new pg4.i((pg4.a) null, (ThemeType) null, (Theme) null, 7, (DefaultConstructorMarker) null), t.e(2010476940, true, new a(modifier3, list, onItemClick, aVar2), startRestartGroup, 54), startRestartGroup, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final vj4.a aVar3 = aVar2;
            endRestartGroup.a(new Function2() { // from class: vj4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c;
                    c = d.c(modifier4, list, aVar3, onItemClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return c;
                }
            });
        }
    }
}
