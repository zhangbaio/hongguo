package com.dragon.read.kmp.story.impl.feeds.container;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpStoryClient implements com.dragon.read.kmp.story.impl.feeds.list.b {
    public static final int r;
    private final LazyListState a;
    private final com.dragon.read.kmp.story.impl.feeds.list.c b;
    private final CoroutineScope c;
    private final Lazy d;
    public final r e;
    private final MutableStateFlow<kp4.b> f;
    public final StateFlow<kp4.b> g;
    private final MutableStateFlow<kp4.b> h;
    public final StateFlow<kp4.b> i;
    private final MutableStateFlow<s> j;
    public final StateFlow<s> k;
    private final MutableStateFlow<s> l;
    public final StateFlow<s> m;
    private final SnapshotStateList<kp4.b> n;
    private final Map<String, kp4.b> o;
    public final List<Pair<String, String>> p;
    private final List<ap4.a> q;

    static {
        Covode.recordClassIndex(609254);
        r = 8;
    }

    public final List<kp4.b> j() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b r() {
        return new tp4.b("KmpStoryClient");
    }

    public final void h() {
        this.p.clear();
    }

    private final tp4.b m() {
        return (tp4.b) this.d.getValue();
    }

    public final kp4.b l() {
        return this.f.getValue();
    }

    public final List<kp4.b> k() {
        List<kp4.b> distinct;
        List h = this.a.x().h();
        ArrayList arrayList = new ArrayList();
        Iterator it2 = h.iterator();
        while (it2.hasNext()) {
            kp4.b first = i(((androidx.compose.foundation.lazy.o) it2.next()).getIndex(), this.n).getFirst();
            if (first != null) {
                arrayList.add(first);
            }
        }
        distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
        return distinct;
    }

    public kp4.b n(String str) {
        return this.o.get(str);
    }

    public final int o(String storyId) {
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Iterator it2 = this.n.iterator();
        int i = 0;
        while (it2.hasNext()) {
            int i2 = i + 1;
            if (Intrinsics.areEqual(((kp4.b) it2.next()).a(), storyId)) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    public final androidx.compose.foundation.lazy.o p(yo4.c page) {
        Object obj;
        Intrinsics.checkNotNullParameter(page, "page");
        int indexOf = this.e.b.indexOf(page);
        Iterator it2 = this.a.x().h().iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((androidx.compose.foundation.lazy.o) obj).getKey(), page.a(indexOf))) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (androidx.compose.foundation.lazy.o) obj;
    }

    public final void s(kp4.b newStory) {
        Intrinsics.checkNotNullParameter(newStory, "newStory");
        this.h.setValue(newStory);
        m().d("onBottomStoryChanged: " + newStory.g());
    }

    public final void u(kp4.b newStory) {
        Intrinsics.checkNotNullParameter(newStory, "newStory");
        this.f.setValue(newStory);
        Iterator<ap4.a> it2 = this.q.iterator();
        while (it2.hasNext()) {
            it2.next().a(newStory);
        }
    }

    public final void f(List<kp4.b> appendStoryList) {
        Intrinsics.checkNotNullParameter(appendStoryList, "appendStoryList");
        ArrayList arrayList = new ArrayList();
        for (kp4.b bVar : appendStoryList) {
            if (!this.o.containsKey(bVar.a())) {
                arrayList.addAll(bVar.h());
                bVar.c.b = this.n.size();
                this.n.add(bVar);
                this.o.put(bVar.a(), bVar);
            }
        }
        this.e.a(arrayList);
    }

    public final int g(kp4.b targetStory) {
        Intrinsics.checkNotNullParameter(targetStory, "targetStory");
        Iterator it2 = this.n.iterator();
        int i = 0;
        while (it2.hasNext()) {
            kp4.b bVar = (kp4.b) it2.next();
            if (Intrinsics.areEqual(bVar.a(), targetStory.a())) {
                break;
            }
            i += Math.max(0, bVar.h().size());
        }
        return Math.min(i, this.e.b.size() - 1);
    }

    public final void t(kp4.b story) {
        Intrinsics.checkNotNullParameter(story, "story");
        story.c.b = 0;
        this.n.add(story);
        this.o.put(story.a(), story);
        com.dragon.read.kmp.story.impl.feeds.list.a.c(this.e, story.h(), false, 2, null);
        m().d("onFirstStoryCreated: " + story.g());
    }

    public final void x(int i, boolean z) {
        kotlinx.coroutines.i.e(this.c, Dispatchers.getMain(), null, new KmpStoryClient$scrollToPosition$1(z, this, i, null), 2, null);
    }

    public final void e(String storyId, String str) {
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        List<Pair<String, String>> list = this.p;
        boolean z = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual(((Pair) it2.next()).getFirst(), storyId)) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            this.p.add(TuplesKt.to(storyId, str));
        }
    }

    public final void y(kp4.b targetStory, boolean z) {
        Intrinsics.checkNotNullParameter(targetStory, "targetStory");
        Iterator it2 = this.n.iterator();
        int i = 0;
        while (it2.hasNext()) {
            kp4.b bVar = (kp4.b) it2.next();
            if (Intrinsics.areEqual(bVar.a(), targetStory.a())) {
                x(i, z);
                return;
            }
            i += bVar.h().size();
        }
    }

    public final Pair<kp4.b, Integer> i(int i, List<kp4.b> storyList) {
        Intrinsics.checkNotNullParameter(storyList, "storyList");
        if (i >= 0 && !storyList.isEmpty()) {
            int i2 = 0;
            int i3 = 0;
            for (kp4.b bVar : storyList) {
                int i4 = i2 + 1;
                boolean z = true;
                int size = (bVar.h().size() + i3) - 1;
                if (i3 > i || i > size) {
                    z = false;
                }
                if (z) {
                    return new Pair<>(bVar, Integer.valueOf(i2));
                }
                i3 += bVar.h().size();
                i2 = i4;
            }
            return new Pair<>(null, -1);
        }
        return new Pair<>(null, -1);
    }

    public final kp4.b q(kp4.b newStory, kp4.b positionStory) {
        Intrinsics.checkNotNullParameter(newStory, "newStory");
        Intrinsics.checkNotNullParameter(positionStory, "positionStory");
        if (this.o.containsKey(newStory.a())) {
            kp4.b w = w(newStory.a(), positionStory);
            if (w != null) {
                return w;
            }
            return newStory;
        }
        Iterator it2 = this.n.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            i++;
            kp4.b bVar = (kp4.b) it2.next();
            i2 += bVar.h().size();
            if (Intrinsics.areEqual(bVar.a(), positionStory.a())) {
                this.n.add(i, newStory);
                SnapshotStateList<yo4.c> snapshotStateList = this.e.b;
                int size = positionStory.h().size() + i2;
                if (i2 >= 0 && i2 <= snapshotStateList.size() && i2 <= size) {
                    snapshotStateList.addAll(i2, newStory.h());
                }
                this.o.put(newStory.a(), newStory);
            }
        }
        return newStory;
    }

    public final kp4.b w(String storyId, kp4.b positionStory) {
        Object firstOrNull;
        int indexOf;
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(positionStory, "positionStory");
        kp4.b bVar = this.o.get(storyId);
        if (bVar == null) {
            return null;
        }
        if (Intrinsics.areEqual(bVar, positionStory)) {
            return bVar;
        }
        int indexOf2 = this.n.indexOf(bVar);
        int indexOf3 = this.n.indexOf(positionStory);
        if (indexOf2 != -1 && indexOf3 != -1) {
            Iterator it2 = this.n.iterator();
            int i = 0;
            int i2 = 0;
            while (it2.hasNext()) {
                int i3 = i + 1;
                i2 += ((kp4.b) it2.next()).h().size();
                if (i == indexOf3) {
                    break;
                }
                i = i3;
            }
            int size = bVar.h().size();
            if (indexOf2 < indexOf3) {
                i2 -= size;
            }
            this.n.remove(indexOf2);
            if (indexOf2 >= indexOf3) {
                indexOf3++;
            }
            this.n.add(indexOf3, bVar);
            SnapshotStateList<yo4.c> snapshotStateList = this.e.b;
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bVar.h());
            indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends Object>) snapshotStateList, firstOrNull);
            int size2 = bVar.h().size() + indexOf;
            if (indexOf >= 0 && size2 <= snapshotStateList.size() && indexOf <= size2) {
                snapshotStateList.removeRange(indexOf, size2);
            }
            int size3 = positionStory.h().size() + i2;
            if (i2 >= 0 && i2 <= snapshotStateList.size() && i2 <= size3) {
                snapshotStateList.addAll(i2, bVar.h());
            }
        }
        return bVar;
    }

    public final void v(kp4.b targetStory, com.dragon.read.kmp.story.impl.feeds.data.b newContent) {
        kp4.b bVar;
        Intrinsics.checkNotNullParameter(targetStory, "targetStory");
        Intrinsics.checkNotNullParameter(newContent, "newContent");
        int size = targetStory.h().size();
        Iterator it2 = this.n.iterator();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (it2.hasNext()) {
                int i3 = i + 1;
                bVar = (kp4.b) it2.next();
                m().d("refreshStory, story " + i + ": " + bVar.g());
                if (Intrinsics.areEqual(bVar, targetStory)) {
                    break;
                }
                i2 += bVar.h().size();
                i = i3;
            } else {
                bVar = null;
                i = -1;
                break;
            }
        }
        if (bVar != null && i != -1) {
            int size2 = newContent.c.size();
            m().d("refreshStory, startIndex = " + i2 + ", oldPageCount = " + size + ", newPageCount = " + size2);
            targetStory.t(newContent);
            targetStory.e.f.setValue(Boolean.valueOf(newContent.a.k));
            SnapshotStateList<yo4.c> snapshotStateList = this.e.b;
            int i4 = size + i2;
            if (i2 >= 0 && i4 <= snapshotStateList.size() && i2 <= i4) {
                snapshotStateList.removeRange(i2, i4);
                snapshotStateList.addAll(i2, targetStory.h());
            } else {
                tp4.b.c(m(), "refreshStory failed, index out of bounds. fromIndex: " + i2 + ", toIndex: " + i4 + ", size: " + snapshotStateList.size(), null, 2, null);
            }
            m().d("refreshStory, startIndex = " + i2 + ", newStory is " + targetStory.g());
            return;
        }
        tp4.b.c(m(), "refreshStory, data dirty, can not find old story, newStory is " + targetStory.g(), null, 2, null);
    }

    @Override // com.dragon.read.kmp.story.impl.feeds.list.b
    public void b(yo4.c page, int i, int i2) {
        String str;
        Intrinsics.checkNotNullParameter(page, "page");
        m().a("onLastVisiblePageChanged: " + Reflection.getOrCreateKotlinClass(page.getClass()).getSimpleName() + ", adapterIndex=" + i2);
        yo4.c cVar = this.l.getValue().a;
        if (cVar != null) {
            str = cVar.c();
        } else {
            str = null;
        }
        String c = page.c();
        kp4.b bVar = this.o.get(c);
        MutableStateFlow<s> mutableStateFlow = this.l;
        mutableStateFlow.setValue(mutableStateFlow.getValue().a(page, i2, i));
        if (bVar != null && !Intrinsics.areEqual(str, c)) {
            s(bVar);
        }
    }

    public final void z(yo4.c targetPage, int i, boolean z) {
        Intrinsics.checkNotNullParameter(targetPage, "targetPage");
        int indexOf = this.e.b.indexOf(targetPage);
        if (indexOf < 0) {
            tp4.b.c(m(), "scrollToTargetStoryPage, target page not found: " + Reflection.getOrCreateKotlinClass(targetPage.getClass()).getSimpleName(), null, 2, null);
            return;
        }
        kp4.b first = i(indexOf, this.n).getFirst();
        if (first != null) {
            first.h = targetPage;
        }
        kotlinx.coroutines.i.e(this.c, Dispatchers.getMain(), null, new KmpStoryClient$scrollToTargetStoryPage$2(z, this, indexOf, i, null), 2, null);
    }

    public KmpStoryClient(LazyListState lazyListState, com.dragon.read.kmp.story.impl.feeds.list.c loadMoreConfig, CoroutineScope composeContext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(loadMoreConfig, "loadMoreConfig");
        Intrinsics.checkNotNullParameter(composeContext, "composeContext");
        this.a = lazyListState;
        this.b = loadMoreConfig;
        this.c = composeContext;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.container.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tp4.b r2;
                r2 = KmpStoryClient.r();
                return r2;
            }
        });
        this.d = lazy;
        this.e = new r(loadMoreConfig);
        MutableStateFlow<kp4.b> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.f = MutableStateFlow;
        this.g = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<kp4.b> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.h = MutableStateFlow2;
        this.i = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<s> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new s(null, 0, 0, 7, null));
        this.j = MutableStateFlow3;
        this.k = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<s> MutableStateFlow4 = StateFlowKt.MutableStateFlow(new s(null, 0, 0, 7, null));
        this.l = MutableStateFlow4;
        this.m = FlowKt.asStateFlow(MutableStateFlow4);
        this.n = SnapshotStateKt.mutableStateListOf();
        this.o = new HashMap();
        this.p = new ArrayList();
        this.q = new ArrayList();
    }

    @Override // com.dragon.read.kmp.story.impl.feeds.list.b
    public void a(yo4.c page, int i, int i2) {
        String str;
        Intrinsics.checkNotNullParameter(page, "page");
        m().a("onFirstVisiblePageChanged: " + Reflection.getOrCreateKotlinClass(page.getClass()).getSimpleName() + ", adapterIndex=" + i2);
        yo4.c cVar = this.j.getValue().a;
        if (cVar != null) {
            str = cVar.c();
        } else {
            str = null;
        }
        String c = page.c();
        kp4.b bVar = this.o.get(c);
        MutableStateFlow<s> mutableStateFlow = this.j;
        mutableStateFlow.setValue(mutableStateFlow.getValue().a(page, i2, i));
        if (bVar != null) {
            bVar.h = page;
        }
        if (bVar != null && !Intrinsics.areEqual(str, c)) {
            u(bVar);
        }
        Iterator<ap4.a> it2 = this.q.iterator();
        while (it2.hasNext()) {
            it2.next().b(page, i, i2);
        }
    }

    public static /* synthetic */ void A(KmpStoryClient kmpStoryClient, yo4.c cVar, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = true;
        }
        kmpStoryClient.z(cVar, i, z);
    }
}
