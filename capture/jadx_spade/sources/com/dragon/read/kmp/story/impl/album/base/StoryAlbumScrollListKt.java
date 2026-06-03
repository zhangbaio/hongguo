package com.dragon.read.kmp.story.impl.album.base;

import androidx.compose.animation.core.m0;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.n0;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import com.bytedance.covode.number.Covode;
import com.dragon.community.base.sdk.load.KmpCSSLoadStatus;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryAlbumScrollListKt {
    private static int a;

    public /* synthetic */ class h {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609211);
            int[] iArr = new int[KmpCSSLoadStatus.values().length];
            try {
                iArr[KmpCSSLoadStatus.Loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KmpCSSLoadStatus.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(609210);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(KmpCSSLoadStatus kmpCSSLoadStatus, boolean z, Function0 function0, int i, Composer composer, int i2) {
        g(kmpCSSLoadStatus, z, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Modifier modifier, String str, long j, float f2, Function0 function0, int i, int i2, Composer composer, int i3) {
        i(modifier, str, j, f2, function0, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(SnapshotStateList snapshotStateList, LazyListState lazyListState, Function0 function0, KmpCSSLoadStatus kmpCSSLoadStatus, boolean z, int i, Function0 function02, KmpCSSLoadStatus kmpCSSLoadStatus2, boolean z2, int i2, Function2 function2, Function4 function4, Function2 function22, i2 i2Var, float f2, float f3, Function4 function42, int i3, int i4, int i5, Composer composer, int i6) {
        l(snapshotStateList, lazyListState, function0, kmpCSSLoadStatus, z, i, function02, kmpCSSLoadStatus2, z2, i2, function2, function4, function22, i2Var, f2, f3, function42, composer, x2.a(i3 | 1), x2.a(i4), i5);
        return Unit.INSTANCE;
    }

    public static final class g implements DisposableEffectResult {
        public void dispose() {
            StoryAlbumScrollListKt.a = 0;
        }
    }

    public static final class e implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public e(List list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final class d implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public d(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }

        public final Object a(int i) {
            return this.a.invoke(Integer.valueOf(i), this.b.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static final class a implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
        final /* synthetic */ String a;
        final /* synthetic */ float b;
        final /* synthetic */ KmpCSSLoadStatus c;
        final /* synthetic */ Function0<Unit> d;

        a(String str, float f, KmpCSSLoadStatus kmpCSSLoadStatus, Function0<Unit> function0) {
            this.a = str;
            this.b = f;
            this.c = kmpCSSLoadStatus;
            this.d = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
            a(fVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f item, Composer composer, int i) {
            boolean z;
            Function0<Unit> function0;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(631146234, i, -1, "com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StoryAlbumScrollList.kt:171)");
                }
                String str = this.a;
                float f = this.b;
                if (this.c == KmpCSSLoadStatus.Error) {
                    function0 = this.d;
                } else {
                    function0 = null;
                }
                StoryAlbumScrollListKt.i(null, str, 0L, f, function0, composer, 3072, 5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> a;

        b(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.a = function2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
            a(fVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-239344527, i, -1, "com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StoryAlbumScrollList.kt:180)");
                }
                this.a.invoke(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class c implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ KmpCSSLoadStatus b;
        final /* synthetic */ boolean c;
        final /* synthetic */ Function0<Unit> d;

        c(float f, KmpCSSLoadStatus kmpCSSLoadStatus, boolean z, Function0<Unit> function0) {
            this.a = f;
            this.b = kmpCSSLoadStatus;
            this.c = z;
            this.d = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
            a(fVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f item, Composer composer, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 17) != 16) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1014440078, i, -1, "com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StoryAlbumScrollList.kt:195)");
                }
                Modifier v = f2.v(Modifier.Companion, 0.0f, 0.0f, 0.0f, x0.i.g(this.a), 7, (Object) null);
                KmpCSSLoadStatus kmpCSSLoadStatus = this.b;
                boolean z2 = this.c;
                Function0<Unit> function0 = this.d;
                p0 i2 = m.i(androidx.compose.ui.e.a.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, v);
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
                StoryAlbumScrollListKt.g(kmpCSSLoadStatus, z2, function0, composer, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult s(MutableState mutableState, MutableState mutableState2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        a = 0;
        p(mutableState, false);
        r(mutableState2, false);
        return new g();
    }

    public static final class f implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ Function4 b;

        public f(List list, Function4 function4) {
            this.a = list;
            this.b = function4;
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
                int i6 = (i3 & 112) | (i3 & 14);
                composer.startReplaceGroup(948441998);
                Modifier a = fVar.a(Modifier.Companion, androidx.compose.animation.core.j.n(200, 0, m0.d(), 2, (Object) null));
                p0 i7 = m.i(androidx.compose.ui.e.a.o(), false);
                int a2 = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, a);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a3 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a3);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, i7, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a2))) {
                    b.updateRememberedValue(Integer.valueOf(a2));
                    b.apply(Integer.valueOf(a2), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                this.b.invoke(obj, Integer.valueOf(i), composer, Integer.valueOf((i6 & 112) | ((i6 >> 6) & 14)));
                composer.endNode();
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

    public static final void g(final KmpCSSLoadStatus loadingStatus, final boolean z, final Function0<Unit> onLoadMore, Composer composer, final int i) {
        int i2;
        boolean z2;
        String str;
        Function0<Unit> function0;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(loadingStatus, "loadingStatus");
        Intrinsics.checkNotNullParameter(onLoadMore, "onLoadMore");
        Composer startRestartGroup = composer.startRestartGroup(460974764);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(loadingStatus.ordinal())) {
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
            if (startRestartGroup.changedInstance(onLoadMore)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        if ((i2 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (startRestartGroup.shouldExecute(z2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(460974764, i2, -1, "com.dragon.read.kmp.story.impl.album.base.Footer (StoryAlbumScrollList.kt:205)");
            }
            if (loadingStatus == KmpCSSLoadStatus.LoadMore) {
                str = "加载中...";
            } else if (loadingStatus == KmpCSSLoadStatus.Error) {
                str = "加载失败，点击重试";
            } else {
                str = "";
                if ((!z || loadingStatus == KmpCSSLoadStatus.LoadNoMore) && a >= 2) {
                    str = "—— 已显示全部内容 ——";
                }
            }
            String str2 = str;
            if (loadingStatus == KmpCSSLoadStatus.Error) {
                function0 = onLoadMore;
            } else {
                function0 = null;
            }
            i(null, str2, 0L, 0.0f, function0, startRestartGroup, 0, 13);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.album.base.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h2;
                    h2 = StoryAlbumScrollListKt.h(loadingStatus, z, onLoadMore, i, (Composer) obj, ((Integer) obj2).intValue());
                    return h2;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(androidx.compose.ui.Modifier r35, java.lang.String r36, long r37, float r39, kotlin.jvm.functions.Function0<kotlin.Unit> r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt.i(androidx.compose.ui.Modifier, java.lang.String, long, float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(boolean z, Function2 function2, SnapshotStateList snapshotStateList, Function2 function22, KmpCSSLoadStatus kmpCSSLoadStatus, String str, float f2, KmpCSSLoadStatus kmpCSSLoadStatus2, Function0 function0, Function4 function4, float f3, boolean z2, Function0 function02, o0 NoOverscrollLazyColumn) {
        d dVar;
        Intrinsics.checkNotNullParameter(NoOverscrollLazyColumn, "$this$NoOverscrollLazyColumn");
        if (z) {
            n0.a(NoOverscrollLazyColumn, (Object) null, (Object) null, t.c(631146234, true, new a(str, f2, kmpCSSLoadStatus2, function0)), 3, (Object) null);
        }
        if (function2 != null) {
            n0.a(NoOverscrollLazyColumn, (Object) null, "infinite_scroll_list_header", t.c(-239344527, true, new b(function2)), 1, (Object) null);
        }
        int size = snapshotStateList.size();
        if (function22 != null) {
            dVar = new d(function22, snapshotStateList);
        } else {
            dVar = null;
        }
        NoOverscrollLazyColumn.f(size, dVar, new e(snapshotStateList), t.c(2039820996, true, new f(snapshotStateList, function4)));
        if (kmpCSSLoadStatus != KmpCSSLoadStatus.HIDE) {
            n0.a(NoOverscrollLazyColumn, (Object) null, (Object) null, t.c(-1014440078, true, new c(f3, kmpCSSLoadStatus, z2, function02)), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0233  */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> void l(final androidx.compose.runtime.snapshots.SnapshotStateList<T> r39, androidx.compose.foundation.lazy.LazyListState r40, final kotlin.jvm.functions.Function0<kotlin.Unit> r41, final com.dragon.community.base.sdk.load.KmpCSSLoadStatus r42, final boolean r43, int r44, kotlin.jvm.functions.Function0<kotlin.Unit> r45, com.dragon.community.base.sdk.load.KmpCSSLoadStatus r46, boolean r47, int r48, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.lazy.LazyListState, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, ? extends java.lang.Object> r51, androidx.compose.foundation.layout.i2 r52, float r53, float r54, final kotlin.jvm.functions.Function4<? super T, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.runtime.Composer r56, final int r57, final int r58, final int r59) {
        /*
            Method dump skipped, instructions count: 1668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.album.base.StoryAlbumScrollListKt.l(androidx.compose.runtime.snapshots.SnapshotStateList, androidx.compose.foundation.lazy.LazyListState, kotlin.jvm.functions.Function0, com.dragon.community.base.sdk.load.KmpCSSLoadStatus, boolean, int, kotlin.jvm.functions.Function0, com.dragon.community.base.sdk.load.KmpCSSLoadStatus, boolean, int, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function4, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.i2, float, float, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
