package com.dragon.read.kmp.story.impl.feeds.list;

import androidx.compose.foundation.gestures.l1;
import androidx.compose.foundation.layout.e;
import androidx.compose.foundation.layout.i2;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.n0;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.y1;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState;
import com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryLazyColumnKt {

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609301);
            int[] iArr = new int[FootLoadingState.values().length];
            try {
                iArr[FootLoadingState.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FootLoadingState.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FootLoadingState.NOT_MORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FootLoadingState.GONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FootLoadingState.INIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(609300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(FootLoadingState footLoadingState, Function0 function0, Modifier modifier, g3 g3Var, int i, int i2, Composer composer, int i3) {
        e(footLoadingState, function0, modifier, g3Var, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(LazyListState lazyListState, Modifier modifier, com.dragon.read.kmp.story.impl.feeds.list.a aVar, int i, i2 i2Var, Function2 function2, Function3 function3, Function4 function4, int i2, int i3, Composer composer, int i4) {
        h(lazyListState, modifier, aVar, i, i2Var, function2, function3, function4, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b i() {
        return new tp4.b("StoryLazyColumn");
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Modifier a;
        final /* synthetic */ LazyListState b;
        final /* synthetic */ i2 c;
        final /* synthetic */ Function2<Composer, Integer, Unit> d;
        final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.list.a e;
        final /* synthetic */ Function4<Integer, yo4.c, Composer, Integer, Unit> f;
        final /* synthetic */ Function3<FootLoadingState, Composer, Integer, Unit> g;

        /* JADX WARN: Multi-variable type inference failed */
        a(Modifier modifier, LazyListState lazyListState, i2 i2Var, Function2<? super Composer, ? super Integer, Unit> function2, com.dragon.read.kmp.story.impl.feeds.list.a aVar, Function4<? super Integer, ? super yo4.c, ? super Composer, ? super Integer, Unit> function4, Function3<? super FootLoadingState, ? super Composer, ? super Integer, Unit> function3) {
            this.a = modifier;
            this.b = lazyListState;
            this.c = i2Var;
            this.d = function2;
            this.e = aVar;
            this.f = function4;
            this.g = function3;
        }

        public static final class d implements Function1<Integer, Object> {
            final /* synthetic */ List a;

            public d(List list) {
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

        public static final class c implements Function1<Integer, Object> {
            final /* synthetic */ Function2 a;
            final /* synthetic */ List b;

            public c(Function2 function2, List list) {
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
        public static final Object e(int i, yo4.c data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return data.a(i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            c(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void c(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580104499, i, -1, "com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumn.<anonymous> (StoryLazyColumn.kt:104)");
                }
                Modifier modifier = this.a;
                LazyListState lazyListState = this.b;
                i2 i2Var = this.c;
                composer.startReplaceGroup(-1224400529);
                boolean changed = composer.changed(this.d) | composer.changedInstance(this.e) | composer.changed(this.f) | composer.changed(this.g);
                final Function2<Composer, Integer, Unit> function2 = this.d;
                final com.dragon.read.kmp.story.impl.feeds.list.a aVar = this.e;
                final Function3<FootLoadingState, Composer, Integer, Unit> function3 = this.g;
                final Function4<Integer, yo4.c, Composer, Integer, Unit> function4 = this.f;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.list.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit d2;
                            d2 = StoryLazyColumnKt.a.d(Function2.this, aVar, function3, function4, (o0) obj);
                            return d2;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                androidx.compose.foundation.lazy.d.c(modifier, lazyListState, i2Var, false, (e.m) null, (e.b) null, (l1) null, false, (y1) null, (Function1) rememberedValue, composer, 0, 504);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* renamed from: com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt$a$a, reason: collision with other inner class name */
        static final class C0076a implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
            final /* synthetic */ Function2<Composer, Integer, Unit> a;

            C0076a(Function2<? super Composer, ? super Integer, Unit> function2) {
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
                        ComposerKt.traceEventStart(1714543576, i, -1, "com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StoryLazyColumn.kt:115)");
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

        static final class b implements Function3<androidx.compose.foundation.lazy.f, Composer, Integer, Unit> {
            final /* synthetic */ Function3<FootLoadingState, Composer, Integer, Unit> a;
            final /* synthetic */ com.dragon.read.kmp.story.impl.feeds.list.a b;

            b(Function3<? super FootLoadingState, ? super Composer, ? super Integer, Unit> function3, com.dragon.read.kmp.story.impl.feeds.list.a aVar) {
                this.a = function3;
                this.b = aVar;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Composer composer, Integer num) {
                a(fVar, composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
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
                        ComposerKt.traceEventStart(-572747773, i, -1, "com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumn.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StoryLazyColumn.kt:132)");
                    }
                    this.a.invoke(this.b.g.getValue(), composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }

        public static final class e implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
            final /* synthetic */ List a;
            final /* synthetic */ Function4 b;

            public e(List list, Function4 function4) {
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
                    yo4.c cVar = (yo4.c) this.a.get(i);
                    composer.startReplaceGroup(-665435501);
                    int i6 = ((i3 & 112) | (i3 & 14)) >> 3;
                    this.b.invoke(Integer.valueOf(i), cVar, composer, Integer.valueOf((i6 & 112) | (i6 & 14)));
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
        public static final Unit d(Function2 function2, com.dragon.read.kmp.story.impl.feeds.list.a aVar, Function3 function3, Function4 function4, o0 LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            if (function2 != null) {
                aVar.d = true;
                n0.a(LazyColumn, "header_view", (Object) null, t.c(1714543576, true, new C0076a(function2)), 2, (Object) null);
            }
            SnapshotStateList<yo4.c> snapshotStateList = aVar.b;
            LazyColumn.f(snapshotStateList.size(), new c(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.list.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Object e2;
                    e2 = StoryLazyColumnKt.a.e(((Integer) obj).intValue(), (yo4.c) obj2);
                    return e2;
                }
            }, snapshotStateList), new d(snapshotStateList), t.c(2039820996, true, new e(snapshotStateList, function4)));
            if (function3 != null) {
                aVar.c = true;
                n0.a(LazyColumn, "foot_view", (Object) null, t.c(-572747773, true, new b(function3, aVar)), 2, (Object) null);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b j(Lazy<tp4.b> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0) {
        com.dragon.read.kmp.j.a.d("DefaultFootView", "on retry view");
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState r51, kotlin.jvm.functions.Function0<kotlin.Unit> r52, androidx.compose.ui.Modifier r53, androidx.compose.ui.text.g3 r54, androidx.compose.runtime.Composer r55, final int r56, final int r57) {
        /*
            Method dump skipped, instructions count: 1017
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt.e(com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.text.g3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(androidx.compose.foundation.lazy.LazyListState r23, androidx.compose.ui.Modifier r24, final com.dragon.read.kmp.story.impl.feeds.list.a r25, int r26, androidx.compose.foundation.layout.i2 r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, kotlin.jvm.functions.Function3<? super com.dragon.read.kmp.basenovel.ui.ui.FootLoadingState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, final kotlin.jvm.functions.Function4<? super java.lang.Integer, ? super yo4.c, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.list.StoryLazyColumnKt.h(androidx.compose.foundation.lazy.LazyListState, androidx.compose.ui.Modifier, com.dragon.read.kmp.story.impl.feeds.list.a, int, androidx.compose.foundation.layout.i2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
