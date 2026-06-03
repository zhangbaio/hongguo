package com.dragon.read.kmp.story.impl.feeds.progress;

import androidx.compose.foundation.lazy.o;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import com.dragon.read.kmp.story.impl.feeds.container.s;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.i;
import np4.e;
import yo4.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryProgressService {
    public static final int f;
    private final float a;
    private final KmpStoryClient b;
    private final CoroutineScope c;
    private final Function0<Boolean> d;
    private final tp4.b e;

    static {
        Covode.recordClassIndex(609342);
        f = 8;
    }

    public final void e(kp4.b story, boolean z) {
        Intrinsics.checkNotNullParameter(story, "story");
        if (!story.m()) {
            this.e.a("syncStoryProgress: story not in real expand state");
        } else {
            i.e(this.c, Dispatchers.getIO(), null, new StoryProgressService$syncStoryProgress$1(story, this, z, null), 2, null);
        }
    }

    public final void d(s pageInfo, kp4.b bVar) {
        o p;
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        if (this.d.invoke().booleanValue()) {
            this.e.a("onPageChanged: progress update paused, skip");
            return;
        }
        if (bVar == null) {
            return;
        }
        if (!bVar.k()) {
            this.e.a("updateStoryProgress: story data not in full state");
            return;
        }
        if (!bVar.m()) {
            this.e.a("updateStoryProgress: story not in real expand state");
            return;
        }
        c cVar = pageInfo.a;
        if (cVar == null || !(cVar instanceof e) || !Intrinsics.areEqual(bVar.a(), ((e) cVar).c()) || (p = this.b.p(cVar)) == null) {
            return;
        }
        i.e(this.c, Dispatchers.getIO(), null, new StoryProgressService$onPageChanged$1(this, bVar, cVar, p, null), 2, null);
    }

    public final void g(kp4.b story, s pageInfo) {
        o p;
        Intrinsics.checkNotNullParameter(story, "story");
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        if (this.d.invoke().booleanValue()) {
            this.e.a("tryUpdateProgressForStory: progress update paused, skip");
            return;
        }
        c cVar = pageInfo.a;
        if (cVar == null || (p = this.b.p(cVar)) == null) {
            return;
        }
        int offset = p.getOffset();
        if (!Intrinsics.areEqual(cVar.c(), story.a())) {
            return;
        }
        i.e(this.c, Dispatchers.getIO(), null, new StoryProgressService$tryUpdateProgressForStory$1(this, story, cVar, offset, null), 2, null);
    }

    public StoryProgressService(float f2, KmpStoryClient storyClient, CoroutineScope composeScope, Function0<Boolean> shouldPauseUpdate) {
        Intrinsics.checkNotNullParameter(storyClient, "storyClient");
        Intrinsics.checkNotNullParameter(composeScope, "composeScope");
        Intrinsics.checkNotNullParameter(shouldPauseUpdate, "shouldPauseUpdate");
        this.a = f2;
        this.b = storyClient;
        this.c = composeScope;
        this.d = shouldPauseUpdate;
        this.e = new tp4.b("StoryProgressService");
    }

    public final Object h(kp4.b bVar, c cVar, int i, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        float f2 = this.a;
        if (f2 <= 0.0f) {
            tp4.b.f(this.e, "updateStoryProgress: invalid density " + this.a, null, 2, null);
            return Unit.INSTANCE;
        }
        float f3 = i / f2;
        if (cVar instanceof np4.c) {
            this.e.a("resetStoryProgress: page type=" + Reflection.getOrCreateKotlinClass(cVar.getClass()).getSimpleName());
            Object b = StoryProgressManager.a.b(bVar, (np4.c) cVar, continuation);
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (b == coroutine_suspended2) {
                return b;
            }
            return Unit.INSTANCE;
        }
        if (cVar instanceof e) {
            Object c = StoryProgressManager.a.c(bVar, (e) cVar, f3, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (c == coroutine_suspended) {
                return c;
            }
            return Unit.INSTANCE;
        }
        tp4.b.f(this.e, "updateStoryProgress: skip page type=" + Reflection.getOrCreateKotlinClass(cVar.getClass()).getSimpleName(), null, 2, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void f(StoryProgressService storyProgressService, kp4.b bVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        storyProgressService.e(bVar, z);
    }
}
