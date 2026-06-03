package com.dragon.read.kmp.story.impl.feeds.guide;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import lp4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpNextStoryBottomGuideHelper {
    public static final int p;
    public final KmpStoryFeedsVM a;
    public MutableState<Boolean> b;
    public MutableState<String> c;
    private boolean d;
    private String e;
    private kp4.b f;
    private kp4.b g;
    private String h;
    private Job i;
    private final float j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final tp4.b o;

    static {
        Covode.recordClassIndex(609289);
        p = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper, int i, Composer composer, int i2) {
        kmpNextStoryBottomGuideHelper.e(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper, int i, Composer composer, int i2) {
        kmpNextStoryBottomGuideHelper.l(composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        this.b.setValue(Boolean.FALSE);
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public final void L() {
        kp4.b bVar;
        kp4.b bVar2 = this.f;
        if (bVar2 != null && (bVar = this.g) != null) {
            b.a.b(bVar2.f.a, this.h, bVar.a(), "bar", "read", 0, 16, null);
            ym4.a aVar = new ym4.a();
            aVar.g("page_name", "bar");
            aVar.g("bar_type", "bar");
            aVar.g("from_post_id", bVar2.d().getPostId());
            aVar.g("from_book_id", bVar2.d().getBookId());
            bVar.f.a.k(aVar);
            bVar.c.g.j(aVar);
            KmpStoryFeedsVM.Z1(this.a, bVar2, bVar, false, null, new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit M;
                    M = KmpNextStoryBottomGuideHelper.M(KmpNextStoryBottomGuideHelper.this);
                    return M;
                }
            }, 8, null);
            J();
            Job job = this.i;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp4.b g(State<kp4.b> state) {
        return (kp4.b) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp4.b h(State<kp4.b> state) {
        return (kp4.b) state.getValue();
    }

    private static final com.dragon.read.kmp.story.impl.feeds.container.n i(State<com.dragon.read.kmp.story.impl.feeds.container.n> state) {
        return (com.dragon.read.kmp.story.impl.feeds.container.n) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(State state) {
        return i(state).h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp4.b m(State<kp4.b> state) {
        return (kp4.b) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kp4.b n(State<kp4.b> state) {
        return (kp4.b) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(KmpNextStoryBottomGuideHelper kmpNextStoryBottomGuideHelper) {
        kmpNextStoryBottomGuideHelper.a.a.f("page_name", "bar");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    private final String K(kp4.b bVar) {
        if (bVar != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("下篇：");
            String j = bVar.j();
            if (j == null) {
                j = "";
            }
            sb.append(j);
            return sb.toString();
        }
        return null;
    }

    public KmpNextStoryBottomGuideHelper(KmpStoryFeedsVM viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.a = viewModel;
        this.b = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.c = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.h = "";
        this.j = 0.85f;
        this.k = 1;
        this.l = 1000000;
        this.m = 2;
        this.n = 2;
        this.o = new tp4.b("KmpNextStoryBottomGuideHelper");
        com.dragon.read.kmp.story.impl.feeds.o.a.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(kp4.b bVar, kp4.b bVar2) {
        if (bVar != null && bVar2 != null && !Intrinsics.areEqual(bVar.d().a, bVar2.d().a)) {
            com.dragon.read.kmp.story.impl.feeds.o.a.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean O(kp4.b bVar, kp4.b bVar2) {
        if (bVar != null && bVar2 != null) {
            if (!bVar.m()) {
                this.o.a("新用户内流引导：当前篇" + bVar.d().a + " 未展开，不展示引导");
                return false;
            }
            if (!Intrinsics.areEqual(bVar.d().a, bVar2.d().a)) {
                this.o.a("新用户内流引导：当前篇" + bVar.d().a + " 底部另一篇故事" + bVar2.d().a + "出现，不展示引导");
                return false;
            }
            if (this.a.y.j(bVar2.d().a)) {
                this.o.a("当前篇" + bVar.d().a + " 下一篇" + bVar2.d().a + " 已曝光过，不展示引导");
                return false;
            }
            return com.dragon.read.kmp.story.impl.feeds.o.a.d(bVar.d().a, this.m, this.k, this.n);
        }
        this.o.a("新用户内流引导：当前或下篇故事不存在，不展示引导");
        return false;
    }

    public final void e(Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1945563490);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(this)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1945563490, i2, -1, "com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper.ObserveFeedDataStatus (KmpNextStoryBottomGuideHelper.kt:115)");
            }
            State collectAsState = SnapshotStateKt.collectAsState(this.a.l, (CoroutineContext) null, startRestartGroup, 0, 1);
            State collectAsState2 = SnapshotStateKt.collectAsState(this.a.m, (CoroutineContext) null, startRestartGroup, 0, 1);
            final State collectAsState3 = SnapshotStateKt.collectAsState(this.a.j, (CoroutineContext) null, startRestartGroup, 0, 1);
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean j;
                        j = KmpNextStoryBottomGuideHelper.j(collectAsState3);
                        return Boolean.valueOf(j);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            State state = (State) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1849434622);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            Boolean valueOf = Boolean.valueOf(k(state));
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changedInstance = startRestartGroup.changedInstance(this) | startRestartGroup.changed(collectAsState) | startRestartGroup.changed(collectAsState2);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new KmpNextStoryBottomGuideHelper$ObserveFeedDataStatus$1$1(mutableState, this, state, collectAsState, collectAsState2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = KmpNextStoryBottomGuideHelper.f(KmpNextStoryBottomGuideHelper.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }

    public final void l(Composer composer, final int i) {
        int i2;
        boolean z;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-1708223655);
        if ((i & 6) == 0) {
            if (startRestartGroup.changedInstance(this)) {
                i3 = 4;
            } else {
                i3 = 2;
            }
            i2 = i3 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1708223655, i2, -1, "com.dragon.read.kmp.story.impl.feeds.guide.KmpNextStoryBottomGuideHelper.ObserveReadProgress (KmpNextStoryBottomGuideHelper.kt:58)");
            }
            State collectAsState = SnapshotStateKt.collectAsState(this.a.l, (CoroutineContext) null, startRestartGroup, 0, 1);
            State collectAsState2 = SnapshotStateKt.collectAsState(this.a.m, (CoroutineContext) null, startRestartGroup, 0, 1);
            LazyListState lazyListState = this.a.b;
            startRestartGroup.startReplaceGroup(-1224400529);
            boolean changed = startRestartGroup.changed(lazyListState) | startRestartGroup.changedInstance(this) | startRestartGroup.changed(collectAsState) | startRestartGroup.changed(collectAsState2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new KmpNextStoryBottomGuideHelper$ObserveReadProgress$1$1(lazyListState, this, collectAsState, collectAsState2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(lazyListState, (Function2) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.feeds.guide.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit o;
                    o = KmpNextStoryBottomGuideHelper.o(KmpNextStoryBottomGuideHelper.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return o;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(String str, kp4.b bVar, kp4.b bVar2) {
        this.h = str;
        this.b.setValue(Boolean.TRUE);
        this.e = bVar.d().a;
        MutableState<String> mutableState = this.c;
        String K = K(bVar2);
        if (K == null) {
            K = "";
        }
        mutableState.setValue(K);
        this.a.y.k(bVar2);
        b.a.e(bVar.f.a, this.h, bVar2.a(), "bar", 0, 8, null);
        ym4.a aVar = new ym4.a();
        aVar.g("page_name", "bar");
        aVar.g("bar_type", "bar");
        aVar.g("from_post_id", bVar.d().getPostId());
        aVar.g("from_book_id", bVar.d().getBookId());
        bVar2.f.a.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N(kp4.b bVar, kp4.b bVar2, List<? extends androidx.compose.foundation.lazy.o> list) {
        Object lastOrNull;
        gp4.b bVar3;
        Object obj;
        boolean z;
        if (bVar != null && bVar2 != null) {
            if (!bVar.m()) {
                this.o.a("当前篇" + bVar.d().a + " 未展开，不展示引导");
                return false;
            }
            if (!Intrinsics.areEqual(bVar.d().a, bVar2.d().a)) {
                this.o.a("当前篇" + bVar.d().a + " 底部另一篇故事" + bVar2.d().a + "出现，隐藏引导");
                return false;
            }
            String str = this.e;
            if (str != null && !Intrinsics.areEqual(str, bVar.d().a)) {
                this.o.a("正在展示的故事" + bVar.d().a + " 不是引导出现的故事" + str + "，隐藏引导");
                return false;
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
            androidx.compose.foundation.lazy.o oVar = (androidx.compose.foundation.lazy.o) lastOrNull;
            if (oVar == null) {
                this.o.a("当前篇" + bVar.d().a + " 最后可见item为空，不展示引导");
                return false;
            }
            Object orNull = CollectionsKt___CollectionsKt.getOrNull(this.a.k.e.b, oVar.getIndex());
            if (orNull instanceof gp4.b) {
                bVar3 = (gp4.b) orNull;
            } else {
                bVar3 = null;
            }
            if (bVar3 == null) {
                this.o.a("当前篇" + bVar.d().a + " 最后可见item对应的page不是文本页(计算需要)，不展示引导");
                return false;
            }
            if (!((Boolean) this.b.getValue()).booleanValue()) {
                if (com.dragon.read.kmp.story.impl.feeds.o.a.k(bVar.d().a, this.k, this.l)) {
                    this.o.a("当前篇" + bVar.d().a + " 已展示引导次数超过次数限制，不展示引导");
                    return false;
                }
                Float a = com.dragon.read.kmp.story.impl.feeds.progress.b.a(bVar, bVar3, oVar.getSize() + oVar.getOffset());
                if (a != null && a.floatValue() > this.j) {
                    kp4.b h = this.a.y.h();
                    if (h == null) {
                        this.o.a("当前篇" + bVar.d().a + " 下一篇未展现内容为空，不展示引导");
                        return false;
                    }
                    if (this.a.y.j(h.d().a)) {
                        this.o.a("当前篇" + bVar.d().a + " 下一篇" + h.d().a + " 已曝光过，不展示引导");
                        return false;
                    }
                    String K = K(h);
                    if (K != null && K.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        this.o.a("当前篇" + bVar.d().a + " 下一篇" + h.d().a + " 标题为空，不展示引导");
                        return false;
                    }
                } else {
                    tp4.b bVar4 = this.o;
                    StringBuilder sb = new StringBuilder();
                    sb.append("当前篇");
                    sb.append(bVar.d().a);
                    sb.append(" 已读进度为");
                    if (a != null) {
                        obj = Float.valueOf(a.floatValue() * 100);
                    } else {
                        obj = 0;
                    }
                    sb.append(obj);
                    sb.append("%，未超过");
                    sb.append(this.j * 100);
                    sb.append("%，不展示引导");
                    bVar4.a(sb.toString());
                    return false;
                }
            }
            return true;
        }
        this.o.a("当前或下篇故事不存在，不展示引导");
        return false;
    }
}
