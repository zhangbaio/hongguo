package com.dragon.read.kmp.story.impl.album.viewmodel;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.dragon.community.base.sdk.load.KmpCSSLoadStatus;
import com.dragon.read.kmp.story.impl.album.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import yw1.l;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryAlbumViewModel extends ViewModel {
    public static final int m;
    private final ep4.a a;
    public final LazyListState b;
    private final com.dragon.read.kmp.story.impl.album.a c;
    private final dp4.a d;
    private final Lazy e;
    private final MutableStateFlow<a> f;
    public final StateFlow<a> g;
    private final c h;
    private CoroutineScope i;
    private final HashSet<String> j;
    private final Function1<com.dragon.read.kmp.story.impl.album.base.b, Unit> k;
    private boolean l;

    static {
        Covode.recordClassIndex(609224);
        m = 8;
    }

    public final void a1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b T0() {
        return new tp4.b("StoryAlbumViewModel");
    }

    public final SnapshotStateList<com.dragon.read.kmp.story.impl.album.base.a> L0() {
        return this.h.f();
    }

    public final void V0() {
        this.d.f(this.k);
    }

    public final void W0() {
        this.j.clear();
    }

    public final void Y0() {
        if (this.l) {
            return;
        }
        this.l = true;
    }

    public void a() {
        a a;
        MutableStateFlow<a> mutableStateFlow = this.f;
        a = r2.a((r18 & 1) != 0 ? r2.a : null, (r18 & 2) != 0 ? r2.b : KmpCSSLoadStatus.LoadMore, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : false, (r18 & 16) != 0 ? r2.e : false, (r18 & 32) != 0 ? r2.f : null, (r18 & 64) != 0 ? r2.g : null, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : 0);
        mutableStateFlow.setValue(a);
    }

    private final void d1() {
        KmpCSSLoadStatus kmpCSSLoadStatus;
        a a;
        MutableStateFlow<a> mutableStateFlow = this.f;
        a value = mutableStateFlow.getValue();
        boolean k = this.d.k();
        boolean b = this.d.b();
        if (!this.h.f().isEmpty()) {
            kmpCSSLoadStatus = KmpCSSLoadStatus.Content;
        } else {
            kmpCSSLoadStatus = KmpCSSLoadStatus.Empty;
        }
        a = value.a((r18 & 1) != 0 ? value.a : kmpCSSLoadStatus, (r18 & 2) != 0 ? value.b : null, (r18 & 4) != 0 ? value.c : null, (r18 & 8) != 0 ? value.d : k, (r18 & 16) != 0 ? value.e : b, (r18 & 32) != 0 ? value.f : null, (r18 & 64) != 0 ? value.g : null, (r18 & 128) != 0 ? value.h : 0);
        mutableStateFlow.setValue(a);
    }

    public final void N0() {
        if (this.g.getValue().b == KmpCSSLoadStatus.Loading) {
            return;
        }
        a();
        this.d.a(new Function1() { // from class: com.dragon.read.kmp.story.impl.album.viewmodel.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit O0;
                O0 = StoryAlbumViewModel.O0((com.dragon.read.kmp.story.impl.album.base.b) obj);
                return O0;
            }
        }, new Function1() { // from class: com.dragon.read.kmp.story.impl.album.viewmodel.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit P0;
                P0 = StoryAlbumViewModel.P0(StoryAlbumViewModel.this, (Throwable) obj);
                return P0;
            }
        });
    }

    public final void Q0() {
        a a;
        KmpCSSLoadStatus kmpCSSLoadStatus = this.g.getValue().c;
        KmpCSSLoadStatus kmpCSSLoadStatus2 = KmpCSSLoadStatus.Loading;
        if (kmpCSSLoadStatus == kmpCSSLoadStatus2) {
            return;
        }
        MutableStateFlow<a> mutableStateFlow = this.f;
        a = r1.a((r18 & 1) != 0 ? r1.a : null, (r18 & 2) != 0 ? r1.b : null, (r18 & 4) != 0 ? r1.c : kmpCSSLoadStatus2, (r18 & 8) != 0 ? r1.d : false, (r18 & 16) != 0 ? r1.e : false, (r18 & 32) != 0 ? r1.f : null, (r18 & 64) != 0 ? r1.g : null, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : 0);
        mutableStateFlow.setValue(a);
        this.d.g(new Function1() { // from class: com.dragon.read.kmp.story.impl.album.viewmodel.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = StoryAlbumViewModel.R0(StoryAlbumViewModel.this, (com.dragon.read.kmp.story.impl.album.base.b) obj);
                return R0;
            }
        }, new Function1() { // from class: com.dragon.read.kmp.story.impl.album.viewmodel.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit S0;
                S0 = StoryAlbumViewModel.S0(StoryAlbumViewModel.this, (Throwable) obj);
                return S0;
            }
        });
    }

    public final void Z0() {
        a a;
        b1();
        MutableStateFlow<a> mutableStateFlow = this.f;
        a = r2.a((r18 & 1) != 0 ? r2.a : null, (r18 & 2) != 0 ? r2.b : null, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : false, (r18 & 16) != 0 ? r2.e : false, (r18 & 32) != 0 ? r2.f : null, (r18 & 64) != 0 ? r2.g : null, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : this.c.getTheme());
        mutableStateFlow.setValue(a);
    }

    private final void b1() {
        a a;
        boolean z;
        String d = this.c.d();
        MutableStateFlow<a> mutableStateFlow = this.f;
        a = r1.a((r18 & 1) != 0 ? r1.a : null, (r18 & 2) != 0 ? r1.b : null, (r18 & 4) != 0 ? r1.c : null, (r18 & 8) != 0 ? r1.d : false, (r18 & 16) != 0 ? r1.e : false, (r18 & 32) != 0 ? r1.f : null, (r18 & 64) != 0 ? r1.g : d, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : 0);
        mutableStateFlow.setValue(a);
        int i = 0;
        if (d != null && d.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        Iterator it2 = this.h.f().iterator();
        while (true) {
            if (it2.hasNext()) {
                if (Intrinsics.areEqual(((com.dragon.read.kmp.story.impl.album.base.a) it2.next()).b(), d)) {
                    break;
                } else {
                    i++;
                }
            } else {
                i = -1;
                break;
            }
        }
        if (i < 0) {
            return;
        }
        kotlinx.coroutines.i.e(this.i, null, null, new StoryAlbumViewModel$scrollToCurrentStory$1(this, i, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(com.dragon.read.kmp.story.impl.album.base.b it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Unit.INSTANCE;
    }

    public void k(List<? extends com.dragon.read.kmp.story.impl.album.base.a> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        N(dataList, true);
        d1();
        b1();
    }

    public void A(Throwable th) {
        a a;
        MutableStateFlow<a> mutableStateFlow = this.f;
        a = r1.a((r18 & 1) != 0 ? r1.a : null, (r18 & 2) != 0 ? r1.b : KmpCSSLoadStatus.Error, (r18 & 4) != 0 ? r1.c : null, (r18 & 8) != 0 ? r1.d : false, (r18 & 16) != 0 ? r1.e : false, (r18 & 32) != 0 ? r1.f : null, (r18 & 64) != 0 ? r1.g : null, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : 0);
        mutableStateFlow.setValue(a);
    }

    public void q(boolean z) {
        a a;
        MutableStateFlow<a> mutableStateFlow = this.f;
        a = r1.a((r18 & 1) != 0 ? r1.a : null, (r18 & 2) != 0 ? r1.b : KmpCSSLoadStatus.Content, (r18 & 4) != 0 ? r1.c : null, (r18 & 8) != 0 ? r1.d : false, (r18 & 16) != 0 ? r1.e : false, (r18 & 32) != 0 ? r1.f : null, (r18 & 64) != 0 ? r1.g : null, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : 0);
        mutableStateFlow.setValue(a);
    }

    public final void U0(CoroutineScope composeContext) {
        com.dragon.read.kmp.story.impl.album.c e;
        Intrinsics.checkNotNullParameter(composeContext, "composeContext");
        this.i = composeContext;
        this.d.h(this.k);
        ArrayList arrayList = new ArrayList();
        com.dragon.read.kmp.story.impl.album.base.b c = this.d.c(this.a);
        if (!c.d && (e = this.d.e(this.a.a)) != null) {
            arrayList.add(e);
        }
        arrayList.addAll(c.a);
        k(arrayList);
    }

    private final void c1(List<? extends com.dragon.read.kmp.story.impl.album.base.a> list) {
        SnapshotStateList<com.dragon.read.kmp.story.impl.album.base.a> f = this.h.f();
        for (com.dragon.read.kmp.story.impl.album.base.a aVar : list) {
            Iterator it2 = f.iterator();
            int i = 0;
            while (true) {
                if (it2.hasNext()) {
                    if (Intrinsics.areEqual(((com.dragon.read.kmp.story.impl.album.base.a) it2.next()).b(), aVar.b())) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i >= 0) {
                this.h.h(i, aVar);
            }
        }
    }

    private final void M0(com.dragon.read.kmp.story.impl.album.base.b bVar) {
        Object firstOrNull;
        int coerceAtLeast;
        boolean z;
        a a;
        com.dragon.read.kmp.story.impl.album.c e;
        int size = bVar.a.size();
        int u = this.b.u();
        int v = this.b.v();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.h.f());
        boolean z2 = firstOrNull instanceof com.dragon.read.kmp.story.impl.album.c;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(bVar.b, 0);
        int i = coerceAtLeast + (z2 ? 1 : 0);
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        if (size > 0) {
            this.h.b(bVar.a, Integer.valueOf(i));
            if (i <= u) {
                ref$IntRef.element += size;
            }
        }
        if (!z2 && !bVar.d) {
            z = true;
        } else {
            z = false;
        }
        if (z && (e = this.d.e(this.a.a)) != null) {
            this.h.c(e, 0);
            ref$IntRef.element++;
        }
        if (ref$IntRef.element > 0) {
            kotlinx.coroutines.i.e(this.i, null, null, new StoryAlbumViewModel$handlePrependResult$1(this, u, ref$IntRef, v, null), 3, null);
        }
        MutableStateFlow<a> mutableStateFlow = this.f;
        a = r1.a((r18 & 1) != 0 ? r1.a : null, (r18 & 2) != 0 ? r1.b : null, (r18 & 4) != 0 ? r1.c : KmpCSSLoadStatus.Init, (r18 & 8) != 0 ? r1.d : false, (r18 & 16) != 0 ? r1.e : false, (r18 & 32) != 0 ? r1.f : null, (r18 & 64) != 0 ? r1.g : null, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : 0);
        mutableStateFlow.setValue(a);
        d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(StoryAlbumViewModel storyAlbumViewModel, Throwable th) {
        if (th != null) {
            storyAlbumViewModel.A(th);
        } else {
            storyAlbumViewModel.q(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(StoryAlbumViewModel storyAlbumViewModel, com.dragon.read.kmp.story.impl.album.base.b result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.e) {
            storyAlbumViewModel.c1(result.a);
        } else if (result.b >= 0) {
            storyAlbumViewModel.M0(result);
        } else {
            storyAlbumViewModel.N(result.a, false);
            storyAlbumViewModel.q(true);
            storyAlbumViewModel.d1();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(StoryAlbumViewModel storyAlbumViewModel, com.dragon.read.kmp.story.impl.album.base.b result) {
        a a;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.a.isEmpty()) {
            MutableStateFlow<a> mutableStateFlow = storyAlbumViewModel.f;
            a = r1.a((r18 & 1) != 0 ? r1.a : null, (r18 & 2) != 0 ? r1.b : null, (r18 & 4) != 0 ? r1.c : KmpCSSLoadStatus.Init, (r18 & 8) != 0 ? r1.d : false, (r18 & 16) != 0 ? r1.e : false, (r18 & 32) != 0 ? r1.f : null, (r18 & 64) != 0 ? r1.g : null, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : 0);
            mutableStateFlow.setValue(a);
            storyAlbumViewModel.d1();
        }
        return Unit.INSTANCE;
    }

    public void N(List<? extends com.dragon.read.kmp.story.impl.album.base.a> dataList, boolean z) {
        a a;
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        MutableStateFlow<a> mutableStateFlow = this.f;
        a = r2.a((r18 & 1) != 0 ? r2.a : null, (r18 & 2) != 0 ? r2.b : null, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : this.d.k(), (r18 & 16) != 0 ? r2.e : false, (r18 & 32) != 0 ? r2.f : null, (r18 & 64) != 0 ? r2.g : null, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : 0);
        mutableStateFlow.setValue(a);
        this.g.getValue().f.d(dataList, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(StoryAlbumViewModel storyAlbumViewModel, Throwable th) {
        a a;
        a a2;
        if (th != null) {
            MutableStateFlow<a> mutableStateFlow = storyAlbumViewModel.f;
            a2 = r0.a((r18 & 1) != 0 ? r0.a : null, (r18 & 2) != 0 ? r0.b : null, (r18 & 4) != 0 ? r0.c : KmpCSSLoadStatus.Error, (r18 & 8) != 0 ? r0.d : false, (r18 & 16) != 0 ? r0.e : false, (r18 & 32) != 0 ? r0.f : null, (r18 & 64) != 0 ? r0.g : null, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : 0);
            mutableStateFlow.setValue(a2);
        } else {
            MutableStateFlow<a> mutableStateFlow2 = storyAlbumViewModel.f;
            a = r1.a((r18 & 1) != 0 ? r1.a : null, (r18 & 2) != 0 ? r1.b : null, (r18 & 4) != 0 ? r1.c : KmpCSSLoadStatus.Init, (r18 & 8) != 0 ? r1.d : false, (r18 & 16) != 0 ? r1.e : false, (r18 & 32) != 0 ? r1.f : null, (r18 & 64) != 0 ? r1.g : null, (r18 & 128) != 0 ? mutableStateFlow2.getValue().h : 0);
            mutableStateFlow2.setValue(a);
            storyAlbumViewModel.d1();
        }
        return Unit.INSTANCE;
    }

    public final void X0(ep4.b contentData, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        String str = this.a.g;
        boolean z2 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (r.a.c(str, contentData.b())) {
                return;
            }
        } else if (this.j.contains(contentData.b())) {
            return;
        }
        kx1.c cVar = new kx1.c();
        cVar.j(this.a.f);
        cVar.g("album_inner_rank", Integer.valueOf(i));
        r rVar = r.a;
        rVar.f(contentData, cVar);
        if (str == null || str.length() == 0) {
            z2 = true;
        }
        if (!z2) {
            rVar.d(str, contentData.b());
        }
        this.j.add(contentData.b());
    }

    public StoryAlbumViewModel(ep4.a storyAlbumParam, LazyListState lazyListState, com.dragon.read.kmp.story.impl.album.a depend, dp4.a dataProvider) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(storyAlbumParam, "storyAlbumParam");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(depend, "depend");
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        this.a = storyAlbumParam;
        this.b = lazyListState;
        this.c = depend;
        this.d = dataProvider;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.story.impl.album.viewmodel.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tp4.b T0;
                T0 = StoryAlbumViewModel.T0();
                return T0;
            }
        });
        this.e = lazy;
        MutableStateFlow<a> MutableStateFlow = StateFlowKt.MutableStateFlow(new a(null, null, null, false, false, null, null, 0, 255, null));
        this.f = MutableStateFlow;
        StateFlow<a> asStateFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.g = asStateFlow;
        this.h = asStateFlow.getValue().f;
        this.i = l.a;
        this.j = new HashSet<>();
        this.k = new Function1() { // from class: com.dragon.read.kmp.story.impl.album.viewmodel.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K0;
                K0 = StoryAlbumViewModel.K0(StoryAlbumViewModel.this, (com.dragon.read.kmp.story.impl.album.base.b) obj);
                return K0;
            }
        };
    }
}
