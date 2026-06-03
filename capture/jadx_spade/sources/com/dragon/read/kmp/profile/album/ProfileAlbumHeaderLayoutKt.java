package com.dragon.read.kmp.profile.album;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.w;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.c0;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.layout.x;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.y1;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.graphics.n2;
import androidx.compose.ui.layout.d1;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.album.ProfileAlbumHeaderLayoutKt;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.utils.k0;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import jg4.u;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProfileAlbumHeaderLayoutKt {

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608027);
            int[] iArr = new int[ProfileAlbumHolderType.values().length];
            try {
                iArr[ProfileAlbumHolderType.NormalAlbum.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileAlbumHolderType.MoreAlbum.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608026);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(boolean z, MutableState mutableState, Function0 function0, float f, int i, Function2 function2, int i2, int i3, Composer composer, int i4) {
        w(z, mutableState, function0, f, i, function2, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(g gVar, boolean z, FilterOptionHeaderType filterOptionHeaderType, Function2 function2, int i, int i2, Composer composer, int i3) {
        C(gVar, z, filterOptionHeaderType, function2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(g gVar, boolean z, FilterOptionHeaderType filterOptionHeaderType, Function2 function2, int i, int i2, Composer composer, int i3) {
        C(gVar, z, filterOptionHeaderType, function2, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(t tVar, String str, boolean z, int i, Composer composer, int i2) {
        k(tVar, str, z, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(FilterOptionHeaderType filterOptionHeaderType, Function2 function2, int i, Composer composer, int i2) {
        n(filterOptionHeaderType, function2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ MutableState<FilterOptionHeaderType> b;
        final /* synthetic */ Function2<FilterOptionHeaderType, FilterOptionHeaderType, Unit> c;
        final /* synthetic */ MutableState<Boolean> d;

        /* JADX WARN: Multi-variable type inference failed */
        a(float f, MutableState<FilterOptionHeaderType> mutableState, Function2<? super FilterOptionHeaderType, ? super FilterOptionHeaderType, Unit> function2, MutableState<Boolean> mutableState2) {
            this.a = f;
            this.b = mutableState;
            this.c = function2;
            this.d = mutableState2;
        }

        /* renamed from: com.dragon.read.kmp.profile.album.ProfileAlbumHeaderLayoutKt$a$a, reason: collision with other inner class name */
        static final class C0024a implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
            final /* synthetic */ MutableState<FilterOptionHeaderType> a;
            final /* synthetic */ Function2<FilterOptionHeaderType, FilterOptionHeaderType, Unit> b;
            final /* synthetic */ MutableState<Boolean> c;

            /* JADX WARN: Multi-variable type inference failed */
            C0024a(MutableState<FilterOptionHeaderType> mutableState, Function2<? super FilterOptionHeaderType, ? super FilterOptionHeaderType, Unit> function2, MutableState<Boolean> mutableState2) {
                this.a = mutableState;
                this.b = function2;
                this.c = mutableState2;
            }

            /* renamed from: com.dragon.read.kmp.profile.album.ProfileAlbumHeaderLayoutKt$a$a$a, reason: collision with other inner class name */
            public static final class C0025a implements Function0<Unit> {
                final /* synthetic */ FilterOptionHeaderType a;
                final /* synthetic */ Function2 b;
                final /* synthetic */ MutableState c;
                final /* synthetic */ MutableState d;

                public C0025a(FilterOptionHeaderType filterOptionHeaderType, Function2 function2, MutableState mutableState, MutableState mutableState2) {
                    this.a = filterOptionHeaderType;
                    this.b = function2;
                    this.c = mutableState;
                    this.d = mutableState2;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    a();
                    return Unit.INSTANCE;
                }

                public final void a() {
                    FilterOptionHeaderType filterOptionHeaderType = this.a;
                    this.b.invoke(ProfileAlbumHeaderLayoutKt.o(this.c), filterOptionHeaderType);
                    ProfileAlbumHeaderLayoutKt.p(this.c, filterOptionHeaderType);
                    ProfileAlbumHeaderLayoutKt.r(this.d, false);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
                a(rVar, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void a(androidx.compose.foundation.layout.r ShadowContainer, Composer composer, int i) {
                boolean z;
                long k;
                Modifier modifier;
                Object obj;
                Composer composer2 = composer;
                Intrinsics.checkNotNullParameter(ShadowContainer, "$this$ShadowContainer");
                int i2 = 0;
                int i3 = 1;
                if ((i & 17) != 16) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer2.shouldExecute(z, i & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1817805192, i, -1, "com.dragon.read.kmp.profile.album.AlbumOptionLayout.<anonymous>.<anonymous>.<anonymous> (ProfileAlbumHeaderLayout.kt:290)");
                    }
                    Object obj2 = null;
                    Modifier t = f2.t(BackgroundKt.d(SizeKt.h(ig4.i.c(Modifier.Companion, x0.i.d(x0.i.g(8)), 0.0f, 0.0f, 0.0f, 0.0f, 30, (Object) null), 0.0f, 1, (Object) null), og4.a.a.h(composer2, og4.a.b).D(), (androidx.compose.ui.graphics.f2) null, 2, (Object) null), x0.i.g(16), 0.0f, 2, (Object) null);
                    MutableState<FilterOptionHeaderType> mutableState = this.a;
                    Function2<FilterOptionHeaderType, FilterOptionHeaderType, Unit> function2 = this.b;
                    MutableState<Boolean> mutableState2 = this.c;
                    p0 a = x.a(androidx.compose.foundation.layout.e.a.i(), androidx.compose.ui.e.a.k(), composer2, 0);
                    int a2 = j.a(androidx.compose.runtime.i.b(composer2, 0));
                    e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                    Modifier e = ComposedModifierKt.e(composer2, t);
                    ComposeUiNode.Companion companion = ComposeUiNode.o0;
                    Function0 a3 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer2.createNode(a3);
                    } else {
                        composer.useNode();
                    }
                    Composer b = g5.b(composer);
                    g5.e(b, a, companion.c());
                    g5.e(b, currentCompositionLocalMap, companion.e());
                    Function2 b2 = companion.b();
                    if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                        b.updateRememberedValue(Integer.valueOf(a2));
                        b.apply(Integer.valueOf(a2), b2);
                    }
                    g5.e(b, e, companion.d());
                    c0 c0Var = c0.b;
                    composer2.startReplaceGroup(1849434622);
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = CollectionsKt__CollectionsKt.listOf((Object[]) new FilterOptionHeaderType[]{FilterOptionHeaderType.LATEST_TYPE, FilterOptionHeaderType.HOTTEST_TYPE});
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    List list = (List) rememberedValue;
                    composer.endReplaceGroup();
                    composer2.startReplaceGroup(-494828064);
                    int i4 = 0;
                    for (Object obj3 : list) {
                        int i5 = i4 + 1;
                        if (i4 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        FilterOptionHeaderType filterOptionHeaderType = (FilterOptionHeaderType) obj3;
                        FilterOptionHeaderType o = ProfileAlbumHeaderLayoutKt.o(mutableState);
                        composer2.startReplaceGroup(-263774014);
                        Modifier modifier2 = Modifier.Companion;
                        Modifier modifier3 = ClickableKt.clickable-oSLSa3U$default(SizeKt.i(SizeKt.h(modifier2, 0.0f, i3, obj2), x0.i.g(52)), false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, new C0025a(filterOptionHeaderType, function2, mutableState, mutableState2), 15, (Object) null);
                        p0 b3 = r2.b(androidx.compose.foundation.layout.e.a.f(), androidx.compose.ui.e.a.i(), composer2, 54);
                        int a4 = j.a(androidx.compose.runtime.i.b(composer2, i2));
                        e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                        Modifier e2 = ComposedModifierKt.e(composer2, modifier3);
                        ComposeUiNode.Companion companion2 = ComposeUiNode.o0;
                        Function0 a5 = companion2.a();
                        if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                            androidx.compose.runtime.i.d();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer2.createNode(a5);
                        } else {
                            composer.useNode();
                        }
                        Composer b4 = g5.b(composer);
                        g5.e(b4, b3, companion2.c());
                        g5.e(b4, currentCompositionLocalMap2, companion2.e());
                        Function2 b5 = companion2.b();
                        if (b4.getInserting() || !Intrinsics.areEqual(b4.rememberedValue(), Integer.valueOf(a4))) {
                            b4.updateRememberedValue(Integer.valueOf(a4));
                            b4.apply(Integer.valueOf(a4), b5);
                        }
                        g5.e(b4, e2, companion2.d());
                        w2 w2Var = w2.b;
                        String a6 = el4.a.a(filterOptionHeaderType);
                        if (filterOptionHeaderType == o) {
                            composer2.startReplaceGroup(322859945);
                            k = og4.a.a.h(composer2, og4.a.b).f();
                        } else {
                            composer2.startReplaceGroup(322861155);
                            k = og4.a.a.h(composer2, og4.a.b).k();
                        }
                        composer.endReplaceGroup();
                        MutableState<Boolean> mutableState3 = mutableState2;
                        Function2<FilterOptionHeaderType, FilterOptionHeaderType, Unit> function22 = function2;
                        MutableState<FilterOptionHeaderType> mutableState4 = mutableState;
                        int i6 = i4;
                        a6.j(a6, (Modifier) null, k, x0.x.h(14), (y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, composer, 3072, 0, 131058);
                        composer.startReplaceGroup(322863184);
                        if (o == filterOptionHeaderType) {
                            modifier = modifier2;
                            z0.g(org.jetbrains.compose.resources.c.a(b4.A(d4.a), composer, 0), "", SizeKt.s(modifier, x0.i.g(20)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, (m0) null, 0, composer, 432, 248);
                        } else {
                            modifier = modifier2;
                        }
                        composer.endReplaceGroup();
                        composer.endNode();
                        composer.endReplaceGroup();
                        composer.startReplaceGroup(-494812245);
                        if (i6 < list.size() - 1) {
                            obj = null;
                            androidx.compose.material.p0.b(SizeKt.h(modifier, 0.0f, 1, (Object) null), og4.a.a.h(composer, og4.a.b).t(), x0.i.g((float) 0.5d), 0.0f, composer, 390, 8);
                        } else {
                            obj = null;
                        }
                        composer.endReplaceGroup();
                        obj2 = obj;
                        composer2 = composer;
                        i4 = i5;
                        mutableState2 = mutableState3;
                        function2 = function22;
                        mutableState = mutableState4;
                        i2 = 0;
                        i3 = 1;
                    }
                    composer.endReplaceGroup();
                    composer.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2050968279, i, -1, "com.dragon.read.kmp.profile.album.AlbumOptionLayout.<anonymous> (ProfileAlbumHeaderLayout.kt:286)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier x = SizeKt.x(aVar, this.a);
                MutableState<FilterOptionHeaderType> mutableState = this.b;
                Function2<FilterOptionHeaderType, FilterOptionHeaderType, Unit> function2 = this.c;
                MutableState<Boolean> mutableState2 = this.d;
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i2 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, x);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a2);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                u.b(SizeKt.h(aVar, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0L, androidx.compose.runtime.internal.t.e(-1817805192, true, new C0024a(mutableState, function2, mutableState2), composer, 54), composer, 24582, 14);
                z0.g(org.jetbrains.compose.resources.c.a(b4.n0(d4.a), composer, 0), "", androidx.compose.ui.o.a(SizeKt.i(SizeKt.x(f2.v(boxScopeInstance.b(aVar, aVar2.n()), 0.0f, x0.i.g(4), x0.i.g(25), 0.0f, 9, (Object) null), x0.i.g(11)), x0.i.g(6)), 1.0f), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(og4.a.a.h(composer, og4.a.b).D()), 0, composer, 48, 184);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ MutableState<List<Object>> a;
        final /* synthetic */ g b;

        c(MutableState<List<Object>> mutableState, g gVar) {
            this.a = mutableState;
            this.b = gVar;
        }

        public static final class a implements Function1<Integer, Object> {
            final /* synthetic */ List a;

            public a(List list) {
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
                    ComposerKt.traceEventStart(2055040179, i, -1, "com.dragon.read.kmp.profile.album.ProfileAlbumHeaderLayout.<anonymous>.<anonymous> (ProfileAlbumHeaderLayout.kt:105)");
                }
                e.f p = androidx.compose.foundation.layout.e.a.p(x0.i.g(10));
                float f = 16;
                i2 j = f2.j(x0.i.g(f), 0.0f, x0.i.g(f), 0.0f, 10, (Object) null);
                composer.startReplaceGroup(-1633490746);
                boolean changed = composer.changed(this.a) | composer.changed(this.b);
                final MutableState<List<Object>> mutableState = this.a;
                final g gVar = this.b;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.profile.album.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit c;
                            c = ProfileAlbumHeaderLayoutKt.c.c(mutableState, gVar, (o0) obj);
                            return c;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                androidx.compose.foundation.lazy.d.e((Modifier) null, (LazyListState) null, j, false, p, (e.c) null, (l1) null, false, (y1) null, (Function1) rememberedValue, composer, 24960, 491);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(MutableState mutableState, g gVar, o0 LazyRow) {
            Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
            List list = (List) mutableState.getValue();
            LazyRow.f(list.size(), (Function1) null, new a(list), androidx.compose.runtime.internal.t.c(2039820996, true, new b(list, gVar)));
            return Unit.INSTANCE;
        }

        public static final class b implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
            final /* synthetic */ List a;
            final /* synthetic */ g b;

            public b(List list, g gVar) {
                this.a = list;
                this.b = gVar;
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
                a(fVar, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
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
                    i3 = i5 | i2;
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
                if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                    z = true;
                } else {
                    z = false;
                }
                if (composer.shouldExecute(z, i3 & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    Object obj = this.a.get(i);
                    composer.startReplaceGroup(-1304163595);
                    composer.startReplaceGroup(-596259122);
                    if (obj instanceof t) {
                        t tVar = (t) obj;
                        g gVar = this.b;
                        ProfileAlbumHeaderLayoutKt.k(tVar, gVar.a, gVar.b, composer, 0);
                        if (!tVar.c) {
                            tVar.c = true;
                            ym4.o.a.d("show_playlist", ProfileAlbumHeaderLayoutKt.P(tVar, this.b.b));
                        }
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FilterOptionHeaderType o(MutableState<FilterOptionHeaderType> mutableState) {
        return (FilterOptionHeaderType) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState) {
        r(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MutableState mutableState) {
        r(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final boolean q(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final boolean x(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(MutableState<FilterOptionHeaderType> mutableState, FilterOptionHeaderType filterOptionHeaderType) {
        mutableState.setValue(filterOptionHeaderType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int a;
        final /* synthetic */ w b;
        final /* synthetic */ MutableState<Boolean> c;
        final /* synthetic */ Function2<Composer, Integer, Unit> d;

        b(int i, w wVar, MutableState<Boolean> mutableState, Function2<? super Composer, ? super Integer, Unit> function2) {
            this.a = i;
            this.b = wVar;
            this.c = mutableState;
            this.d = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-186061029, i, -1, "com.dragon.read.kmp.profile.album.FilterOptionPopupMenu.<anonymous> (ProfileAlbumHeaderLayout.kt:436)");
                }
                AnimatedVisibilityKt.j(ProfileAlbumHeaderLayoutKt.z(this.c), (Modifier) null, EnterExitTransitionKt.o(androidx.compose.animation.core.j.n(this.a, 0, this.b, 2, (Object) null), 0.0f, 2, (Object) null).c(EnterExitTransitionKt.r(androidx.compose.animation.core.j.n(this.a, 0, this.b, 2, (Object) null), 0.6f, n2.a(0.85f, 0.0f))), EnterExitTransitionKt.q(androidx.compose.animation.core.j.n(this.a, 0, this.b, 2, (Object) null), 0.0f, 2, (Object) null).c(EnterExitTransitionKt.t(androidx.compose.animation.core.j.n(this.a, 0, this.b, 2, (Object) null), 0.6f, n2.a(0.85f, 0.0f))), (String) null, androidx.compose.runtime.internal.t.e(-427999421, true, new a(this.d), composer, 54), composer, 196608, 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        static final class a implements Function3<androidx.compose.animation.e, Composer, Integer, Unit> {
            final /* synthetic */ Function2<Composer, Integer, Unit> a;

            a(Function2<? super Composer, ? super Integer, Unit> function2) {
                this.a = function2;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.e eVar, Composer composer, Integer num) {
                a(eVar, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void a(androidx.compose.animation.e AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-427999421, i, -1, "com.dragon.read.kmp.profile.album.FilterOptionPopupMenu.<anonymous>.<anonymous> (ProfileAlbumHeaderLayout.kt:453)");
                }
                Modifier x = SizeKt.x(Modifier.Companion, x0.i.g(136));
                Function2<Composer, Integer, Unit> function2 = this.a;
                p0 i2 = androidx.compose.foundation.layout.m.i(androidx.compose.ui.e.a.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, x);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a2);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, i2, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                function2.invoke(composer, 0);
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(FilterOptionHeaderType filterOptionHeaderType, FilterOptionHeaderType filterOptionHeaderType2) {
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "<unused var>");
        Intrinsics.checkNotNullParameter(filterOptionHeaderType2, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState, androidx.compose.ui.layout.w it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        mutableState.setValue(it2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ym4.a P(t tVar, boolean z) {
        String str;
        ym4.k b2 = k0.a.b();
        ym4.a aVar = new ym4.a();
        aVar.h(b2.i());
        if (tVar.b == ProfileAlbumHolderType.NormalAlbum) {
            com.dragon.read.kmp.profile.album.b bVar = tVar.a;
            if (bVar != null) {
                str = bVar.b;
            } else {
                str = null;
            }
            aVar.g("playlist_id", str);
        }
        if (z) {
            aVar.g("profile_tab_name", "profile_post");
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(t tVar, String str, boolean z, Context context) {
        O(tVar, str, z, context);
        return Unit.INSTANCE;
    }

    private static final void O(t tVar, String str, boolean z, Context context) {
        String str2;
        ProfileAlbumHolderType profileAlbumHolderType = tVar.b;
        if (profileAlbumHolderType == ProfileAlbumHolderType.NormalAlbum) {
            ym4.o.a.d("click_playlist", P(tVar, z));
        } else if (profileAlbumHolderType == ProfileAlbumHolderType.CreateAlbum) {
            ym4.o.a.d("click_module", P(tVar, z));
        }
        int i = d.a[tVar.b.ordinal()];
        if (i != 1) {
            if (i == 2) {
                ym4.k b2 = k0.a.b();
                if (z) {
                    b2.d("profile_tab_name", "profile_post");
                }
                com.dragon.read.kmp.u.m(z, str, b2, context);
                return;
            }
            return;
        }
        if (z) {
            ym4.k d2 = k0.a.b().d("profile_user_id", str);
            com.dragon.read.kmp.profile.album.b bVar = tVar.a;
            if (bVar != null) {
                str2 = bVar.b;
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            com.dragon.read.kmp.u.l(str2, d2, context, (String) null, 8, (Object) null);
        }
    }

    private static final void n(final FilterOptionHeaderType filterOptionHeaderType, final Function2<? super FilterOptionHeaderType, ? super FilterOptionHeaderType, Unit> function2, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        final MutableState mutableState;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-284388123);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(filterOptionHeaderType.ordinal())) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            i2 = i4 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                i3 = 32;
            } else {
                i3 = 16;
            }
            i2 |= i3;
        }
        if ((i2 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-284388123, i2, -1, "com.dragon.read.kmp.profile.album.AlbumOptionLayout (ProfileAlbumHeaderLayout.kt:242)");
            }
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateOf$default(filterOptionHeaderType, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState2 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            e.c l = androidx.compose.ui.e.a.l();
            Modifier.a aVar = Modifier.Companion;
            float f = 4;
            Modifier v = f2.v(SizeKt.F(SizeKt.d(aVar, 0.0f, 1, (Object) null), (e.b) null, false, 3, (Object) null), x0.i.g(8), x0.i.g(f), x0.i.g(16), 0.0f, 8, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.dragon.read.kmp.profile.album.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit s;
                        s = ProfileAlbumHeaderLayoutKt.s(mutableState3);
                        return s;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Modifier modifier = ClickableKt.clickable-oSLSa3U$default(v, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue4, 15, (Object) null);
            p0 b2 = r2.b(androidx.compose.foundation.layout.e.a.h(), l, startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, modifier);
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
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion2.c());
            g5.e(b3, currentCompositionLocalMap, companion2.e());
            Function2 b4 = companion2.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                b3.updateRememberedValue(Integer.valueOf(a2));
                b3.apply(Integer.valueOf(a2), b4);
            }
            g5.e(b3, e, companion2.d());
            w2 w2Var = w2.b;
            String a4 = el4.a.a(o(mutableState2));
            og4.a aVar2 = og4.a.a;
            int i5 = og4.a.b;
            long j = aVar2.h(startRestartGroup, i5).j();
            long h = x0.x.h(14);
            Modifier v2 = f2.v(aVar, 0.0f, 0.0f, x0.i.g(2), 0.0f, 11, (Object) null);
            startRestartGroup.startReplaceGroup(5004770);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: com.dragon.read.kmp.profile.album.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit t;
                        t = ProfileAlbumHeaderLayoutKt.t(mutableState4, (androidx.compose.ui.layout.w) obj);
                        return t;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            a6.j(a4, d1.a(v2, (Function1) rememberedValue5), j, h, (y) null, (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, 3120, 0, 131056);
            composer2 = startRestartGroup;
            z0.g(org.jetbrains.compose.resources.c.a(b4.i(d4.a), composer2, 0), "", SizeKt.s(f2.v(aVar, 0.0f, x0.i.g(f), 0.0f, 0.0f, 13, (Object) null), x0.i.g(12)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, ig4.i.d(aVar2.h(composer2, i5).j()), 0, composer2, 432, 184);
            composer2.endNode();
            float g = x0.i.g(126);
            boolean q = q(mutableState3);
            float g2 = x0.i.g(g - x0.i.g(22));
            composer2.startReplaceGroup(5004770);
            Object rememberedValue6 = composer2.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                mutableState = mutableState3;
                rememberedValue6 = new Function0() { // from class: com.dragon.read.kmp.profile.album.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit u;
                        u = ProfileAlbumHeaderLayoutKt.u(mutableState);
                        return u;
                    }
                };
                composer2.updateRememberedValue(rememberedValue6);
            } else {
                mutableState = mutableState3;
            }
            composer2.endReplaceGroup();
            w(q, mutableState4, (Function0) rememberedValue6, g2, 0, androidx.compose.runtime.internal.t.e(2050968279, true, new a(g, mutableState2, function2, mutableState), composer2, 54), composer2, 200112, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.profile.album.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit v3;
                    v3 = ProfileAlbumHeaderLayoutKt.v(FilterOptionHeaderType.this, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return v3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void k(final com.dragon.read.kmp.profile.album.t r33, final java.lang.String r34, final boolean r35, androidx.compose.runtime.Composer r36, final int r37) {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.album.ProfileAlbumHeaderLayoutKt.k(com.dragon.read.kmp.profile.album.t, java.lang.String, boolean, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void C(final com.dragon.read.kmp.profile.album.g r22, boolean r23, com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType r24, kotlin.jvm.functions.Function2<? super com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType, ? super com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.album.ProfileAlbumHeaderLayoutKt.C(com.dragon.read.kmp.profile.album.g, boolean, com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void w(final boolean r20, final androidx.compose.runtime.MutableState<androidx.compose.ui.layout.w> r21, final kotlin.jvm.functions.Function0<kotlin.Unit> r22, float r23, int r24, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.profile.album.ProfileAlbumHeaderLayoutKt.w(boolean, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function0, float, int, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
