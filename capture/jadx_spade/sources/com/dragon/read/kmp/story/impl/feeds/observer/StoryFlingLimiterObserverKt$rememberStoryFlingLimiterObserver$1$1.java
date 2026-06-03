package com.dragon.read.kmp.story.impl.feeds.observer;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.nestedscroll.d;
import com.dragon.read.kmp.story.impl.feeds.container.KmpStoryClient;
import java.util.List;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import x0.z;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1 implements androidx.compose.ui.input.nestedscroll.b {
    final /* synthetic */ tp4.b a;
    final /* synthetic */ MutableState<String> b;
    final /* synthetic */ KmpStoryClient c;
    final /* synthetic */ MutableState<Integer> d;
    final /* synthetic */ MutableState<Boolean> e;
    final /* synthetic */ CoroutineScope f;
    final /* synthetic */ List<yo4.c> g;
    final /* synthetic */ LazyListState h;
    final /* synthetic */ int i;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(MutableState mutableState, np4.c titlePage) {
        Intrinsics.checkNotNullParameter(titlePage, "titlePage");
        return !Intrinsics.areEqual(titlePage.c(), mutableState.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(kp4.b bVar, np4.c page) {
        Intrinsics.checkNotNullParameter(page, "page");
        return Intrinsics.areEqual(page.c(), bVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(MutableState mutableState, np4.c titlePage) {
        Intrinsics.checkNotNullParameter(titlePage, "titlePage");
        return !Intrinsics.areEqual(titlePage.c(), mutableState.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(MutableState mutableState, np4.c page) {
        Intrinsics.checkNotNullParameter(page, "page");
        return Intrinsics.areEqual(page.c(), mutableState.getValue());
    }

    public long Y1(long j, int i) {
        Pair f;
        Pair f2;
        String str;
        boolean z;
        int i2;
        String str2;
        this.a.a("onPreScroll available:" + ((Object) a0.f.s(j)) + " source:" + ((Object) androidx.compose.ui.input.nestedscroll.d.g(i)));
        d.a aVar = androidx.compose.ui.input.nestedscroll.d.a;
        if (androidx.compose.ui.input.nestedscroll.d.f(i, aVar.a())) {
            if (this.b.getValue() == null) {
                MutableState<String> mutableState = this.b;
                kp4.b l = this.c.l();
                if (l != null) {
                    str2 = l.a();
                } else {
                    str2 = null;
                }
                mutableState.setValue(str2);
            }
            int i3 = (int) (j & 4294967295L);
            if (Float.intBitsToFloat(i3) == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                MutableState<Integer> mutableState2 = this.d;
                if (Float.intBitsToFloat(i3) < 0.0f) {
                    i2 = 1;
                } else {
                    i2 = -1;
                }
                mutableState2.setValue(Integer.valueOf(i2));
            }
        }
        if (!androidx.compose.ui.input.nestedscroll.d.f(i, aVar.b())) {
            tp4.b bVar = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("onPreScroll 非fling，不处理 direction:");
            if (((Number) this.d.getValue()).intValue() == 1) {
                str = "next";
            } else {
                str = "prev";
            }
            sb.append(str);
            bVar.a(sb.toString());
            return androidx.compose.ui.input.nestedscroll.a.d(this, j, i);
        }
        if (((Boolean) this.e.getValue()).booleanValue()) {
            this.a.a("onPreScroll -- 终止当次滑动");
            kotlinx.coroutines.i.e(this.f, null, null, new StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1$onPreScroll$1(this.h, null), 3, null);
            StoryFlingLimiterObserverKt.l(this.a, this.c, this.b, this.e);
            return j;
        }
        if (((Number) this.d.getValue()).intValue() == 1) {
            kp4.b n = this.c.n((String) this.b.getValue());
            if (n == null) {
                return androidx.compose.ui.input.nestedscroll.a.d(this, j, i);
            }
            this.a.a("FLING--处理上滑--切下篇意图 cur title:" + n.j());
            if (n.m()) {
                this.a.a("FLING--处理上滑--切下篇意图 开始拖拽篇是展开态");
                List<yo4.c> list = this.g;
                LazyListState lazyListState = this.h;
                final MutableState<String> mutableState3 = this.b;
                f2 = StoryFlingLimiterObserverKt.f(list, lazyListState, new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean g;
                        g = StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1.g(mutableState3, (np4.c) obj);
                        return Boolean.valueOf(g);
                    }
                });
                if (f2 == null) {
                    return androidx.compose.ui.input.nestedscroll.a.d(this, j, i);
                }
                float offset = (this.i - ((androidx.compose.foundation.lazy.o) f2.getFirst()).getOffset()) / this.i;
                int i4 = (int) (j & 4294967295L);
                float offset2 = ((androidx.compose.foundation.lazy.o) f2.getFirst()).getOffset() + Float.intBitsToFloat(i4);
                int i5 = this.i;
                float f3 = (i5 - offset2) / i5;
                this.a.a("FLING--处理上滑--切下篇意图 下篇标题可见：" + ((np4.c) f2.getSecond()).d + " offset:" + ((androidx.compose.foundation.lazy.o) f2.getFirst()).getOffset() + " screenHeight:" + this.i + " ratio:" + offset + " nextOffset:" + offset2 + " nextRatio:" + f3);
                if (offset >= 0.4f) {
                    this.a.a("FLING--处理上滑--切下篇意图 下篇标题达到35%展示");
                    this.e.setValue(Boolean.TRUE);
                    return j;
                }
                if (f3 >= 0.4f) {
                    float offset3 = ((androidx.compose.foundation.lazy.o) f2.getFirst()).getOffset() - (this.i * 0.6f);
                    float intBitsToFloat = Float.intBitsToFloat(i4) + offset3;
                    this.a.a("FLING--处理上滑--切下篇意图 下篇标题即将达到35%展示 needConsumeOffsetY:" + offset3 + " availableY:" + intBitsToFloat);
                    this.e.setValue(Boolean.TRUE);
                    return a0.f.e((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
                }
            }
        } else {
            kp4.b n2 = this.c.n((String) this.b.getValue());
            if (n2 == null) {
                return androidx.compose.ui.input.nestedscroll.a.d(this, j, i);
            }
            this.a.a("FLING--处理下滑--切上篇意图 cur title:" + n2.j());
            if (n2.m()) {
                this.a.a("FLING--处理下滑--切上篇意图 开始拖拽篇是展开态");
                List<yo4.c> list2 = this.g;
                LazyListState lazyListState2 = this.h;
                final MutableState<String> mutableState4 = this.b;
                f = StoryFlingLimiterObserverKt.f(list2, lazyListState2, new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.observer.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean h;
                        h = StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1.h(mutableState4, (np4.c) obj);
                        return Boolean.valueOf(h);
                    }
                });
                if (f != null) {
                    this.a.a("FLING--处理下滑--切上篇意图 开始拖拽篇是展开态 -- 出现标题：" + ((np4.c) f.getSecond()).d + " offset:" + ((androidx.compose.foundation.lazy.o) f.getFirst()).getOffset());
                    if (((androidx.compose.foundation.lazy.o) f.getFirst()).getOffset() > 0) {
                        MutableState<Boolean> mutableState5 = this.e;
                        Boolean bool = Boolean.TRUE;
                        mutableState5.setValue(bool);
                        this.a.a("FLING--处理下滑--切上篇意图 开始拖拽篇是展开态 -- 标题到顶：" + ((np4.c) f.getSecond()).d + " offset:" + ((androidx.compose.foundation.lazy.o) f.getFirst()).getOffset());
                        this.e.setValue(bool);
                        return j;
                    }
                    int i6 = (int) (j & 4294967295L);
                    if (Float.intBitsToFloat(i6) + ((androidx.compose.foundation.lazy.o) f.getFirst()).getOffset() > 0.0f) {
                        float intBitsToFloat2 = Float.intBitsToFloat(i6) + ((androidx.compose.foundation.lazy.o) f.getFirst()).getOffset();
                        this.a.a("FLING--处理下滑--切上篇意图 开始拖拽篇是展开态 -- 标题即将到顶：" + ((np4.c) f.getSecond()).d + " offset:" + ((androidx.compose.foundation.lazy.o) f.getFirst()).getOffset());
                        this.e.setValue(Boolean.TRUE);
                        return a0.f.e((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
                    }
                }
            }
        }
        this.a.a("兜底返回super");
        return androidx.compose.ui.input.nestedscroll.a.d(this, j, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x012f, code lost:
    
        r1 = com.dragon.read.kmp.story.impl.feeds.observer.StoryFlingLimiterObserverKt.h(((java.lang.Number) r4.getValue()).intValue(), (java.lang.String) r5.getValue(), r6, r7, r14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k0(long r17, kotlin.coroutines.Continuation<? super x0.z> r19) {
        /*
            Method dump skipped, instructions count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.observer.StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1.k0(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public long Y(long j, long j2, int i) {
        this.a.a("onPostScroll consumed：" + ((Object) a0.f.s(j)) + " available:" + ((Object) a0.f.s(j2)) + " source:" + ((Object) androidx.compose.ui.input.nestedscroll.d.g(i)));
        return androidx.compose.ui.input.nestedscroll.a.b(this, j, j2, i);
    }

    public Object a1(long j, long j2, Continuation<? super z> continuation) {
        this.a.a("onPostFling consumed：" + ((Object) z.n(j)) + " available:" + ((Object) z.n(j2)) + ' ');
        StoryFlingLimiterObserverKt.l(this.a, this.c, this.b, this.e);
        return androidx.compose.ui.input.nestedscroll.a.a(this, j, j2, continuation);
    }

    StoryFlingLimiterObserverKt$rememberStoryFlingLimiterObserver$1$1(tp4.b bVar, MutableState<String> mutableState, KmpStoryClient kmpStoryClient, MutableState<Integer> mutableState2, MutableState<Boolean> mutableState3, CoroutineScope coroutineScope, List<yo4.c> list, LazyListState lazyListState, int i) {
        this.a = bVar;
        this.b = mutableState;
        this.c = kmpStoryClient;
        this.d = mutableState2;
        this.e = mutableState3;
        this.f = coroutineScope;
        this.g = list;
        this.h = lazyListState;
        this.i = i;
    }
}
