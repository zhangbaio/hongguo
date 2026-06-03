package com.dragon.read.kmp.profile.guestprofile.view;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.e;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.c0;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserRelationType;
import com.bytedance.kmp.reading.model.cj0;
import com.bytedance.kmp.reading.model.eo;
import com.bytedance.kmp.reading.model.ok0;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    static {
        Covode.recordClassIndex(608169);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(GuestProfileViewModel guestProfileViewModel, Modifier modifier, eo eoVar, int i, int i2, Composer composer, int i3) {
        j(guestProfileViewModel, modifier, eoVar, composer, androidx.compose.runtime.x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(d dVar, String str, Function0 function0, boolean z, int i, Composer composer, int i2) {
        o(dVar, str, function0, z, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(GuestProfileViewModel guestProfileViewModel, boolean z, Function0 function0, int i, Composer composer, int i2) {
        r(guestProfileViewModel, z, function0, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(GuestProfileViewModel guestProfileViewModel, boolean z, Function0 function0, int i, Composer composer, int i2) {
        r(guestProfileViewModel, z, function0, composer, androidx.compose.runtime.x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final String x(double d) {
        String dropLast;
        String valueOf = String.valueOf(((int) (d * r0)) / 10);
        if (StringsKt__StringsJVMKt.endsWith$default(valueOf, ".0", false, 2, null)) {
            dropLast = StringsKt___StringsKt.dropLast(valueOf, 2);
            return dropLast;
        }
        return valueOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final boolean y(com.bytedance.kmp.reading.model.cj0 r6) {
        /*
            r0 = 0
            if (r6 == 0) goto L11
            com.bytedance.kmp.reading.model.ok0 r2 = r6.b
            if (r2 == 0) goto L11
            java.lang.Long r2 = r2.l
            if (r2 == 0) goto L11
            long r2 = r2.longValue()
            goto L12
        L11:
            r2 = r0
        L12:
            r4 = 0
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 <= 0) goto L35
            r0 = 1
            if (r6 == 0) goto L31
            com.bytedance.kmp.reading.model.tl0 r6 = r6.d
            if (r6 == 0) goto L31
            java.lang.Integer r6 = r6.j
            com.bytedance.kmp.reading.model.UgcActorType r1 = com.bytedance.kmp.reading.model.UgcActorType.Registered
            int r1 = r1.getValue()
            if (r6 != 0) goto L29
            goto L31
        L29:
            int r6 = r6.intValue()
            if (r6 != r1) goto L31
            r6 = 1
            goto L32
        L31:
            r6 = 0
        L32:
            if (r6 != 0) goto L35
            r4 = 1
        L35:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.p.y(com.bytedance.kmp.reading.model.cj0):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(eo eoVar, GuestProfileViewModel guestProfileViewModel, cj0 cj0Var, androidx.compose.foundation.layout.v2 v2Var) {
        String str;
        String str2;
        String str3;
        ok0 ok0Var;
        Map map;
        if (eoVar != null && (map = eoVar.c) != null) {
            str = (String) map.get("person_follows_list_switcher");
        } else {
            str = null;
        }
        if (!(!Intrinsics.areEqual("on", str))) {
            com.dragon.read.kmp.i.f(guestProfileViewModel.b, "clickFollowStat canJump is false", (Throwable) null, 2, (Object) null);
            ig4.g.b("该用户已设置隐藏关注列表", (ToastDuration) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
        com.dragon.read.kmp.service.e1 e1Var = com.dragon.read.kmp.service.e1.a;
        if (cj0Var != null) {
            str2 = cj0Var.a;
        } else {
            str2 = null;
        }
        if (cj0Var == null || (ok0Var = cj0Var.b) == null || (str3 = ok0Var.b) == null) {
            str3 = "";
        }
        String d = e1Var.d(str2, str3);
        if (d != null) {
            guestProfileViewModel.x0(d, com.dragon.read.kmp.utils.k0.a.b());
        } else {
            com.dragon.read.kmp.i.f(guestProfileViewModel.b, "getTargetUserFollowPageUrl is empty", (Throwable) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(eo eoVar, GuestProfileViewModel guestProfileViewModel, cj0 cj0Var, androidx.compose.foundation.layout.v2 v2Var) {
        String str;
        String str2;
        String str3;
        ok0 ok0Var;
        Map map;
        if (eoVar != null && (map = eoVar.c) != null) {
            str = (String) map.get("person_fans_list_switcher");
        } else {
            str = null;
        }
        if (!(!Intrinsics.areEqual("on", str))) {
            com.dragon.read.kmp.i.f(guestProfileViewModel.b, "clickFansStat canJump is false", (Throwable) null, 2, (Object) null);
            ig4.g.b("该用户已设置隐藏粉丝列表", (ToastDuration) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
        ym4.k b = com.dragon.read.kmp.utils.k0.a.b();
        com.dragon.read.kmp.service.e1 e1Var = com.dragon.read.kmp.service.e1.a;
        if (cj0Var != null) {
            str2 = cj0Var.a;
        } else {
            str2 = null;
        }
        if (cj0Var == null || (ok0Var = cj0Var.b) == null || (str3 = ok0Var.b) == null) {
            str3 = "";
        }
        String c = e1Var.c(str2, str3);
        if (c != null) {
            guestProfileViewModel.x0(c, b);
        } else {
            com.dragon.read.kmp.i.f(guestProfileViewModel.b, "getTargetUserFansPageUrl is empty", (Throwable) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    public static final p3 z(Integer num, Theme theme, androidx.compose.ui.graphics.c0 c0Var, boolean z) {
        boolean z2;
        long f;
        p3 p3Var;
        long h;
        org.jetbrains.compose.resources.b S;
        androidx.compose.ui.graphics.m0 m0Var;
        long h2;
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (com.dragon.read.kmp.u.o() && !z) {
            z2 = true;
        } else {
            z2 = false;
        }
        qg4.n i = og4.a.a.i(theme);
        if (z2) {
            f = i.r();
        } else {
            f = i.f();
        }
        int value = UserRelationType.Follow.getValue();
        if (num != null && num.intValue() == value) {
            if (z2) {
                h2 = og4.a.a.i(theme).T2();
            } else {
                h2 = og4.a.a.d().h();
            }
            return new p3("已关注", h2, null, null, null, 16, null);
        }
        int value2 = UserRelationType.MutualFollow.getValue();
        if (num != null && num.intValue() == value2) {
            og4.a aVar = og4.a.a;
            if (z2) {
                h = aVar.i(theme).T2();
            } else {
                h = aVar.d().h();
            }
            long j = h;
            d4 d4Var = d4.a;
            if (z2) {
                S = b4.T(d4Var);
            } else {
                S = b4.S(d4Var);
            }
            org.jetbrains.compose.resources.b bVar = S;
            if (z2) {
                m0Var = m0.a.c(androidx.compose.ui.graphics.m0.b, og4.a.a.i(theme).T2(), 0, 2, (Object) null);
            } else {
                m0Var = null;
            }
            return new p3("关注", j, bVar, m0Var, null, 16, null);
        }
        int value3 = UserRelationType.Followed.getValue();
        if (num != null && num.intValue() == value3) {
            p3Var = new p3("回关", f, b4.U(d4.a), m0.a.c(androidx.compose.ui.graphics.m0.b, f, 0, 2, (Object) null), c0Var, null);
        } else {
            p3Var = new p3("关注", f, b4.U(d4.a), m0.a.c(androidx.compose.ui.graphics.m0.b, f, 0, 2, (Object) null), c0Var, null);
        }
        return p3Var;
    }

    public static final d v(long j, boolean z, String tenThousandsUnit, String tenThousandsPlusUnit, String hundredMillionUnit) {
        boolean z2;
        String x;
        d dVar;
        String x2;
        boolean z3;
        String x3;
        Intrinsics.checkNotNullParameter(tenThousandsUnit, "tenThousandsUnit");
        Intrinsics.checkNotNullParameter(tenThousandsPlusUnit, "tenThousandsPlusUnit");
        Intrinsics.checkNotNullParameter(hundredMillionUnit, "hundredMillionUnit");
        long max = Math.max(0L, j);
        if (max < 10000) {
            return new d(String.valueOf(max), null);
        }
        if (z) {
            if (max < 100000000) {
                double min = Math.min(99999000L, max) / 10000;
                if (min % 1.0d == 0.0d) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    x3 = String.valueOf((int) min);
                } else {
                    x3 = x(min);
                }
                dVar = new d(x3, tenThousandsUnit);
            } else {
                if (max < 1000000000) {
                    long j2 = max / 10000000;
                    long j3 = 10;
                    if (j2 % j3 == 0) {
                        x2 = String.valueOf(j2 / j3);
                    } else {
                        x2 = x(j2 / 10.0f);
                    }
                    return new d(x2, hundredMillionUnit);
                }
                return new d(String.valueOf(max / 100000000), hundredMillionUnit);
            }
        } else {
            if (max > 99999000) {
                return new d("9999", tenThousandsPlusUnit);
            }
            double min2 = Math.min(99999000L, max) / 10000;
            if (min2 % 1.0d == 0.0d) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                x = String.valueOf((int) min2);
            } else {
                x = x(min2);
            }
            dVar = new d(x, tenThousandsUnit);
        }
        return dVar;
    }

    public static final void r(final GuestProfileViewModel viewModel, final boolean z, final Function0<Unit> clickCallback, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        Integer num;
        float f;
        Modifier d;
        boolean z3;
        int i3;
        long h;
        long r;
        List listOf;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        Composer startRestartGroup = composer.startRestartGroup(491181676);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(viewModel)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(z)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(clickCallback)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(491181676, i2, -1, "com.dragon.read.kmp.profile.guestprofile.view.SubscribeButton (ProfileRelationStats.kt:70)");
            }
            if (viewModel.l.getValue().d) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                t3 endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit s;
                            s = p.s(GuestProfileViewModel.this, z, clickCallback, i, (Composer) obj, ((Integer) obj2).intValue());
                            return s;
                        }
                    });
                    return;
                }
                return;
            }
            com.dragon.read.kmp.profile.guestprofile.viewmodel.g0 g0Var = (com.dragon.read.kmp.profile.guestprofile.viewmodel.g0) viewModel.j.getValue();
            if (g0Var != null) {
                num = g0Var.d;
            } else {
                num = null;
            }
            og4.a aVar = og4.a.a;
            int i7 = og4.a.b;
            Theme e = aVar.e(startRestartGroup, i7);
            long a = aVar.h(startRestartGroup, i7).a();
            long e2 = aVar.h(startRestartGroup, i7).e();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                c0.a aVar2 = androidx.compose.ui.graphics.c0.b;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new androidx.compose.ui.graphics.l0[]{androidx.compose.ui.graphics.l0.j(a), androidx.compose.ui.graphics.l0.j(e2)});
                rememberedValue = c0.a.d(aVar2, listOf, 0.0f, 0.0f, 0, 14, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            androidx.compose.ui.graphics.c0 c0Var = (androidx.compose.ui.graphics.c0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1633490746);
            boolean changed = startRestartGroup.changed(num) | startRestartGroup.changed(e.ordinal());
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = A(num, e, c0Var, false, 8, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            p3 p3Var = (p3) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            if (z) {
                f = 6;
            } else {
                f = 8;
            }
            float g = x0.i.g(f);
            e.f d2 = androidx.compose.foundation.layout.e.a.d();
            e.c i8 = androidx.compose.ui.e.a.i();
            Modifier.a aVar3 = Modifier.Companion;
            Modifier c = ig4.i.c(aVar3, x0.i.d(x0.i.g(8)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null);
            if (com.dragon.read.kmp.u.o()) {
                startRestartGroup.startReplaceGroup(-159294850);
                androidx.compose.ui.graphics.c0 c0Var2 = p3Var.e;
                if (c0Var2 != null) {
                    d = BackgroundKt.b(aVar3, c0Var2, (androidx.compose.ui.graphics.f2) null, 0.0f, 6, (Object) null);
                } else {
                    if (com.dragon.read.kmp.service.d1.d(e)) {
                        startRestartGroup.startReplaceGroup(-420773988);
                        r = aVar.h(startRestartGroup, i7).I();
                    } else {
                        startRestartGroup.startReplaceGroup(-420772623);
                        r = aVar.h(startRestartGroup, i7).r();
                    }
                    startRestartGroup.endReplaceGroup();
                    d = BackgroundKt.d(aVar3, r, (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                }
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-159019105);
                d = BackgroundKt.d(aVar3, aVar.h(startRestartGroup, i7).r(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null);
                startRestartGroup.endReplaceGroup();
            }
            Modifier then = c.then(d);
            startRestartGroup.startReplaceGroup(5004770);
            if ((i2 & 896) == 256) {
                z3 = true;
            } else {
                z3 = false;
            }
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.view.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit t;
                        t = p.t(Function0.this);
                        return t;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            float f2 = 12;
            Modifier u = androidx.compose.foundation.layout.f2.u(ClickableKt.clickable-oSLSa3U$default(then, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue3, 15, (Object) null), x0.i.g(f2), g, x0.i.g(f2), g);
            androidx.compose.ui.layout.p0 b = androidx.compose.foundation.layout.r2.b(d2, i8, startRestartGroup, 54);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            androidx.compose.runtime.e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e3 = ComposedModifierKt.e(startRestartGroup, u);
            ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
            Function0 a3 = companion2.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a3);
            } else {
                startRestartGroup.useNode();
            }
            Composer b2 = g5.b(startRestartGroup);
            g5.e(b2, b, companion2.c());
            g5.e(b2, currentCompositionLocalMap, companion2.e());
            Function2 b3 = companion2.b();
            if (b2.getInserting() || !Intrinsics.areEqual(b2.rememberedValue(), Integer.valueOf(a2))) {
                b2.updateRememberedValue(Integer.valueOf(a2));
                b2.apply(Integer.valueOf(a2), b3);
            }
            g5.e(b2, e3, companion2.d());
            androidx.compose.foundation.layout.w2 w2Var = androidx.compose.foundation.layout.w2.b;
            org.jetbrains.compose.resources.b bVar = p3Var.c;
            startRestartGroup.startReplaceGroup(-564102168);
            if (bVar == null) {
                composer2 = startRestartGroup;
                i3 = 12;
            } else {
                i3 = 12;
                composer2 = startRestartGroup;
                androidx.compose.foundation.z0.g(org.jetbrains.compose.resources.c.a(bVar, startRestartGroup, 0), "关注", (Modifier) null, (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, p3Var.d, 0, startRestartGroup, 48, 188);
            }
            composer2.endReplaceGroup();
            String str = p3Var.a;
            long j = p3Var.b;
            if (z) {
                h = x0.x.h(i3);
            } else {
                h = x0.x.h(14);
            }
            a6.j(str, BackgroundKt.d(aVar3, androidx.compose.ui.graphics.l0.b.g(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), j, h, (androidx.compose.ui.text.font.y) null, androidx.compose.ui.text.font.c0.b.i(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (androidx.compose.ui.text.g3) null, composer2, 196656, 0, 131024);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.a(new Function2() { // from class: com.dragon.read.kmp.profile.guestprofile.view.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit u2;
                    u2 = p.u(GuestProfileViewModel.this, z, clickCallback, i, (Composer) obj, ((Integer) obj2).intValue());
                    return u2;
                }
            });
        }
    }

    public static /* synthetic */ p3 A(Integer num, Theme theme, androidx.compose.ui.graphics.c0 c0Var, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            c0Var = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return z(num, theme, c0Var, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel r38, androidx.compose.ui.Modifier r39, final com.bytedance.kmp.reading.model.eo r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.p.j(com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel, androidx.compose.ui.Modifier, com.bytedance.kmp.reading.model.eo, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
    
        if (r0 == null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void o(final com.dragon.read.kmp.profile.guestprofile.view.d r36, final java.lang.String r37, final kotlin.jvm.functions.Function0<kotlin.Unit> r38, final boolean r39, androidx.compose.runtime.Composer r40, final int r41) {
        /*
            Method dump skipped, instructions count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.guestprofile.view.p.o(com.dragon.read.kmp.profile.guestprofile.view.d, java.lang.String, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int):void");
    }

    public static /* synthetic */ d w(long j, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "万";
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = "万+";
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = "亿";
        }
        return v(j, z, str4, str5, str3);
    }
}
