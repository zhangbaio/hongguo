package com.dragon.read.kmp.story.impl.feeds.guide;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.SourcePageType;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import com.dragon.read.kmp.story.impl.feeds.guide.a;
import ec4.l0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class w {
    public static final int j;
    private final l0 a;
    private final yo4.d b;
    private final float c;
    private final KmpStoryClient d;
    private final a e;
    public final KmpBaseStoryExitAlertHelper f;
    private int g;
    private HashSet<String> h;
    private List<String> i;

    public interface a {
        void e(kp4.b bVar, kp4.b bVar2, boolean z, String str, Function0<Unit> function0);
    }

    static {
        Covode.recordClassIndex(609294);
        j = 8;
    }

    public static final class b implements a.InterfaceC0074a {
        @Override // com.dragon.read.kmp.story.impl.feeds.guide.a.InterfaceC0074a
        public kp4.b f() {
            return w.this.g();
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.guide.a.InterfaceC0074a
        public List<kp4.b> g() {
            return w.this.i();
        }

        b() {
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.guide.a.InterfaceC0074a
        public void a(String storyId) {
            Intrinsics.checkNotNullParameter(storyId, "storyId");
            w.this.i.add(storyId);
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.guide.a.InterfaceC0074a
        public void b(String storyId) {
            Intrinsics.checkNotNullParameter(storyId, "storyId");
            w.this.h.add(storyId);
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.guide.a.InterfaceC0074a
        public boolean c(String storyId) {
            Intrinsics.checkNotNullParameter(storyId, "storyId");
            return w.this.j(storyId);
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.guide.a.InterfaceC0074a
        public boolean d(String storyId) {
            Intrinsics.checkNotNullParameter(storyId, "storyId");
            return w.this.i.contains(storyId);
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.guide.a.InterfaceC0074a
        public kp4.b h(kp4.b newStory, kp4.b positionStory) {
            Intrinsics.checkNotNullParameter(newStory, "newStory");
            Intrinsics.checkNotNullParameter(positionStory, "positionStory");
            return w.this.d.q(newStory, positionStory);
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.guide.a.InterfaceC0074a
        public void e(kp4.b story, kp4.b nextStory, boolean z, String str, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(story, "story");
            Intrinsics.checkNotNullParameter(nextStory, "nextStory");
            w.this.e.e(story, nextStory, z, str, function0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kp4.b g() {
        return this.d.l();
    }

    public final kp4.b h() {
        Object firstOrNull;
        List<kp4.b> i = i();
        if (i != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) i);
            return (kp4.b) firstOrNull;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<kp4.b> i() {
        List<kp4.b> j2 = this.d.j();
        kp4.b l = this.d.l();
        if (l != null) {
            return l(j2, j2.indexOf(l) + 1, j2.size());
        }
        return null;
    }

    private final void m(int i) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, this.g);
        this.g = coerceAtLeast;
    }

    public final boolean j(String storyId) {
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        return this.h.contains(storyId);
    }

    public final void k(kp4.b story) {
        Intrinsics.checkNotNullParameter(story, "story");
        m(this.d.j().indexOf(story) + 1);
        this.h.add(story.a());
    }

    private final <T> List<T> l(List<? extends T> list, int i, int i2) {
        int coerceAtLeast;
        int coerceAtMost;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, 0);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, list.size());
        if (coerceAtLeast > coerceAtMost) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list.subList(coerceAtLeast, coerceAtMost);
    }

    public w(l0 strategy, yo4.d clientParam, float f, KmpStoryClient client, a depend) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(clientParam, "clientParam");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(depend, "depend");
        this.a = strategy;
        this.b = clientParam;
        this.c = f;
        this.d = client;
        this.e = depend;
        this.g = 1;
        this.h = new HashSet<>();
        this.i = new ArrayList();
        j jVar = new j(clientParam, f, strategy, new b());
        this.f = jVar;
        if (clientParam.f != SourcePageType.SearchPage.getValue()) {
            jVar.i();
        }
    }
}
