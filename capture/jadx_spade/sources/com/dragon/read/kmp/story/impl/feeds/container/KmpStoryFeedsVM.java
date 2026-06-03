package com.dragon.read.kmp.story.impl.feeds.container;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.graphics.l0;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.GenreTypeEnum;
import com.bytedance.kmp.ugc.model.q6;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.service.j0;
import com.dragon.read.kmp.story.impl.feeds.guide.w;
import com.dragon.read.kmp.story.impl.feeds.polaris.KmpStoryPolarisTaskCoordinator;
import com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressService;
import com.dragon.read.kmp.story.impl.quality.QuaTraceStatus;
import com.dragon.read.kmp.utils.AppUtils;
import com.dragon.read.kmp.utils.k0;
import ec4.i0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import lp4.b;
import sp4.a;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpStoryFeedsVM extends ViewModel {
    public static final int A;
    public final yo4.d a;
    public final LazyListState b;
    public final float c;
    public final CoroutineScope d;
    private final tp4.b e;
    private final xm6.a f;
    private final xm6.a g;
    public final CoroutineScope h;
    private final MutableStateFlow<n> i;
    public final StateFlow<n> j;
    public final KmpStoryClient k;
    public final StateFlow<kp4.b> l;
    public final StateFlow<kp4.b> m;
    public final StateFlow<s> n;
    public final StateFlow<s> o;
    private final b p;
    private final Job q;
    private final op4.b r;
    private final StoryProgressService s;
    private boolean t;
    private Job u;
    private final com.dragon.read.kmp.story.impl.feeds.trace.b v;
    private final com.dragon.read.kmp.story.impl.feeds.trace.j w;
    public long x;
    public final w y;
    public final KmpStoryPolarisTaskCoordinator z;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(609256);
            int[] iArr = new int[LoadStatus.values().length];
            try {
                iArr[LoadStatus.Init.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadStatus.LoadMore.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadStatus.LoadNoMore.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadStatus.Error.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(609255);
        A = 8;
    }

    protected void onCleared() {
        super.onCleared();
    }

    private final void F1() {
        this.e.d("onStoryFeedsEnter");
        this.x = com.dragon.read.kmp.utils.p.a();
    }

    public final void z1() {
        Job.DefaultImpls.cancel$default(this.q, (CancellationException) null, 1, (Object) null);
        this.z.n();
    }

    public final void C1() {
        this.e.d("onPause");
        G1();
        R1();
        this.z.o();
    }

    public final void E1() {
        this.e.d("onResume");
        if (this.x > 0) {
            this.x = com.dragon.read.kmp.utils.p.a();
        }
        H1();
        this.z.q();
    }

    public final void w1() {
        if (!this.f.a(false, true)) {
            return;
        }
        kotlinx.coroutines.i.e(this.d, Dispatchers.getIO(), null, new KmpStoryFeedsVM$loadMore$1(this, null), 2, null);
    }

    public final void x1() {
        this.e.d("onBackPress");
        if (this.y.f.b()) {
            return;
        }
        zm4.d.a.b();
    }

    private final void G1() {
        this.e.d("onStoryFeedsInvisible");
        for (kp4.b bVar : this.k.k()) {
            bVar.s();
            g2(bVar);
        }
    }

    private final void H1() {
        this.e.d("onStoryFeedsVisible");
        for (kp4.b bVar : this.k.k()) {
            this.k.e(bVar.a(), bVar.d().getBookId());
            bVar.q();
        }
    }

    public final void s1() {
        n a2;
        if (this.i.getValue().g) {
            MutableStateFlow<n> mutableStateFlow = this.i;
            a2 = r2.a((r18 & 1) != 0 ? r2.a : null, (r18 & 2) != 0 ? r2.b : null, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : null, (r18 & 16) != 0 ? r2.e : false, (r18 & 32) != 0 ? r2.f : null, (r18 & 64) != 0 ? r2.g : false, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : false);
            mutableStateFlow.setValue(a2);
        }
    }

    private final void R1() {
        if (this.x == 0) {
            return;
        }
        long a2 = com.dragon.read.kmp.utils.p.a() - this.x;
        ym4.a aVar = new ym4.a();
        aVar.h(this.a.c);
        aVar.h(this.a.m);
        String str = this.a.k;
        if (str != null) {
            aVar.g("cover_id", str);
        }
        aVar.g("page_type", "post");
        new k().c(this.a, this.k.p, a2, aVar);
        this.k.h();
    }

    public final void f2() {
        n a2;
        n a3;
        if (!this.i.getValue().g) {
            MutableStateFlow<n> mutableStateFlow = this.i;
            a3 = r2.a((r18 & 1) != 0 ? r2.a : null, (r18 & 2) != 0 ? r2.b : null, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : null, (r18 & 16) != 0 ? r2.e : false, (r18 & 32) != 0 ? r2.f : null, (r18 & 64) != 0 ? r2.g : true, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : false);
            mutableStateFlow.setValue(a3);
        } else {
            MutableStateFlow<n> mutableStateFlow2 = this.i;
            a2 = r2.a((r18 & 1) != 0 ? r2.a : null, (r18 & 2) != 0 ? r2.b : null, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : null, (r18 & 16) != 0 ? r2.e : false, (r18 & 32) != 0 ? r2.f : null, (r18 & 64) != 0 ? r2.g : false, (r18 & 128) != 0 ? mutableStateFlow2.getValue().h : false);
            mutableStateFlow2.setValue(a2);
        }
    }

    public final void y1() {
        this.v.o();
        this.v.c(this.a.c);
        this.v.b("book_type", "short_story");
        this.v.b("post_inner_rank", 0);
        this.v.g();
        this.w.m();
        this.w.c(this.a.c);
        v1(this, false, 1, null);
        this.z.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L1(KmpStoryFeedsVM kmpStoryFeedsVM) {
        return kmpStoryFeedsVM.t;
    }

    public static final class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null) {
                Object obj = null;
                if (Intrinsics.areEqual(action, "action_story_page_scroll_to_target")) {
                    String stringExtra = intent.getStringExtra("book_id");
                    Iterator<T> it2 = KmpStoryFeedsVM.this.k.j().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next = it2.next();
                        if (Intrinsics.areEqual(((kp4.b) next).d().getBookId(), stringExtra)) {
                            obj = next;
                            break;
                        }
                    }
                    kp4.b bVar = (kp4.b) obj;
                    if (bVar != null) {
                        KmpStoryFeedsVM.this.k.y(bVar, false);
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(action, "action_story_text_layout_change") && !Intrinsics.areEqual(intent.getStringExtra("page_id"), KmpStoryFeedsVM.this.a.e())) {
                    KmpStoryFeedsVM.P1(KmpStoryFeedsVM.this, false, null, 3, null);
                }
            }
        }
    }

    public static final class c implements w.a {
        c() {
        }

        @Override // com.dragon.read.kmp.story.impl.feeds.guide.w.a
        public void e(kp4.b story, kp4.b nextStory, boolean z, String str, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(story, "story");
            Intrinsics.checkNotNullParameter(nextStory, "nextStory");
            KmpStoryFeedsVM.this.Y1(story, nextStory, z, str, function0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W1(KmpStoryFeedsVM kmpStoryFeedsVM) {
        kmpStoryFeedsVM.w1();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(KmpStoryFeedsVM kmpStoryFeedsVM) {
        v1(kmpStoryFeedsVM, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean X1(KmpStoryFeedsVM kmpStoryFeedsVM) {
        return kmpStoryFeedsVM.j.getValue().e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(kp4.b bVar) {
        this.s.g(bVar, this.n.getValue());
    }

    public final void I1(kp4.b story) {
        Intrinsics.checkNotNullParameter(story, "story");
        this.y.k(story);
    }

    public final void c2(kp4.b story) {
        Intrinsics.checkNotNullParameter(story, "story");
        StoryProgressService.f(this.s, story, false, 2, null);
    }

    private final void V1(String str) {
        n a2;
        MutableStateFlow<n> mutableStateFlow = this.i;
        a2 = r2.a((r18 & 1) != 0 ? r2.a : null, (r18 & 2) != 0 ? r2.b : null, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : null, (r18 & 16) != 0 ? r2.e : false, (r18 & 32) != 0 ? r2.f : str, (r18 & 64) != 0 ? r2.g : false, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : false);
        mutableStateFlow.setValue(a2);
    }

    private final void i1(LoadStatus loadStatus) {
        n a2;
        MutableStateFlow<n> mutableStateFlow = this.i;
        a2 = r2.a((r18 & 1) != 0 ? r2.a : loadStatus, (r18 & 2) != 0 ? r2.b : null, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : null, (r18 & 16) != 0 ? r2.e : false, (r18 & 32) != 0 ? r2.f : null, (r18 & 64) != 0 ? r2.g : false, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : false);
        mutableStateFlow.setValue(a2);
    }

    public final void M1(kp4.b story) {
        Intrinsics.checkNotNullParameter(story, "story");
        kotlinx.coroutines.i.e(this.h, null, null, new KmpStoryFeedsVM$recordStoryHistory$1(story, null), 3, null);
    }

    public final void Q1(kp4.b story) {
        Intrinsics.checkNotNullParameter(story, "story");
        k1(story, LoadStatus.Loading);
        kotlinx.coroutines.i.e(this.d, Dispatchers.getIO(), null, new KmpStoryFeedsVM$reloadStory$1(this, story, null), 2, null);
    }

    public final void u1(boolean z) {
        if (z) {
            i1(LoadStatus.Loading);
        }
        kotlinx.coroutines.i.e(this.d, Dispatchers.getIO(), null, new KmpStoryFeedsVM$loadData$1(this, null), 2, null);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$1", f = "KmpStoryFeedsVM.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return KmpStoryFeedsVM.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                KmpStoryFeedsVM kmpStoryFeedsVM = KmpStoryFeedsVM.this;
                StateFlow<s> stateFlow = kmpStoryFeedsVM.n;
                a aVar = new a(kmpStoryFeedsVM);
                this.label = 1;
                if (stateFlow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            throw new KotlinNothingValueException();
        }

        /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$1$a */
        static final class a<T> implements FlowCollector {
            final /* synthetic */ KmpStoryFeedsVM a;

            a(KmpStoryFeedsVM kmpStoryFeedsVM) {
                this.a = kmpStoryFeedsVM;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(s sVar, Continuation<? super Unit> continuation) {
                this.a.s.d(sVar, this.a.l.getValue());
                return Unit.INSTANCE;
            }
        }
    }

    @DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$2", f = "KmpStoryFeedsVM.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return KmpStoryFeedsVM.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                KmpStoryFeedsVM kmpStoryFeedsVM = KmpStoryFeedsVM.this;
                StateFlow<kp4.b> stateFlow = kmpStoryFeedsVM.l;
                a aVar = new a(kmpStoryFeedsVM);
                this.label = 1;
                if (stateFlow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            throw new KotlinNothingValueException();
        }

        /* renamed from: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$2$a */
        static final class a<T> implements FlowCollector {
            final /* synthetic */ KmpStoryFeedsVM a;

            a(KmpStoryFeedsVM kmpStoryFeedsVM) {
                this.a = kmpStoryFeedsVM;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(kp4.b bVar, Continuation<? super Unit> continuation) {
                String str;
                com.dragon.read.kmp.story.impl.feeds.data.e d;
                String groupId;
                com.dragon.read.kmp.story.impl.feeds.data.e d2;
                if (!com.dragon.read.kmp.story.impl.feeds.polaris.a.a.a()) {
                    return Unit.INSTANCE;
                }
                KmpStoryPolarisTaskCoordinator kmpStoryPolarisTaskCoordinator = this.a.z;
                String str2 = "";
                if (bVar == null || (d2 = bVar.d()) == null || (str = d2.getBookId()) == null) {
                    if (bVar == null) {
                        str = "";
                    } else {
                        str = bVar.a();
                    }
                }
                if (bVar != null && (d = bVar.d()) != null && (groupId = d.getGroupId()) != null) {
                    str2 = groupId;
                }
                kmpStoryPolarisTaskCoordinator.w(str, str2);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object S1(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Intent intent = new Intent("action_freeze_screen");
        intent.putExtra("page_id", this.a.e());
        Object c2 = AppUtils.a.c(intent, true, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (c2 == coroutine_suspended) {
            return c2;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object T1(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Intent intent = new Intent("action_unfreeze_screen");
        intent.putExtra("page_id", this.a.e());
        Object c2 = AppUtils.a.c(intent, true, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (c2 == coroutine_suspended) {
            return c2;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(m<kp4.b> mVar) {
        LoadStatus loadStatus;
        if (mVar.b()) {
            loadStatus = LoadStatus.Content;
        } else {
            loadStatus = LoadStatus.Error;
        }
        i1(loadStatus);
        if (mVar.a()) {
            this.v.b("status", Integer.valueOf(QuaTraceStatus.FAIL.getValue()));
            this.v.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(LoadStatus loadStatus) {
        n a2;
        MutableStateFlow<n> mutableStateFlow = this.i;
        a2 = r2.a((r18 & 1) != 0 ? r2.a : null, (r18 & 2) != 0 ? r2.b : loadStatus, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : null, (r18 & 16) != 0 ? r2.e : false, (r18 & 32) != 0 ? r2.f : null, (r18 & 64) != 0 ? r2.g : false, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : false);
        mutableStateFlow.setValue(a2);
        int i = a.a[loadStatus.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.k.e.h();
                        return;
                    }
                    return;
                }
                this.k.e.i();
                return;
            }
            this.k.e.j();
            return;
        }
        this.k.e.g();
    }

    public final void q1(kp4.b story) {
        Intrinsics.checkNotNullParameter(story, "story");
        story.e.h(false);
        story.s();
        if (this.f.c()) {
            List<kp4.b> j = this.k.j();
            if ((!j.isEmpty()) && Intrinsics.areEqual(CollectionsKt___CollectionsKt.last((List) j), story)) {
                j1(LoadStatus.LoadMore);
            }
        }
        kotlinx.coroutines.i.e(this.d, Dispatchers.getIO(), null, new KmpStoryFeedsVM$foldStory$1(this, story, null), 2, null);
    }

    public final void r1(sp4.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.e.d("handleIntent, intent is " + intent);
        if (Intrinsics.areEqual(intent, a.C0266a.a)) {
            this.v.f();
        } else {
            if (Intrinsics.areEqual(intent, a.b.a)) {
                this.v.j();
                this.v.b("status", Integer.valueOf(QuaTraceStatus.SUCCESS.getValue()));
                this.v.d();
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void t1(kp4.b story) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(story, "story");
        if (!story.d().k) {
            Integer genreType = story.d().getGenreType();
            int value = GenreTypeEnum.STORY_GENRE_TYPE.getValue();
            if (genreType != null && genreType.intValue() == value) {
                str2 = "短篇";
            } else {
                str2 = "小说";
            }
            b1.a.D((char) 35813 + str2 + "暂不支持听书");
            return;
        }
        ym4.k b2 = k0.a.b();
        j0 j0Var = j0.a;
        String bookId = story.d().getBookId();
        if (bookId == null) {
            bookId = "";
        }
        String str3 = story.d().d;
        if (str3 == null) {
            str = "";
        } else {
            str = str3;
        }
        j0.c(j0Var, bookId, "", str, "short_story_play_duration", b2, null, null, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d2(Continuation<? super m<kp4.b>> continuation) {
        Object m773constructorimpl;
        up4.a aVar;
        zo4.a a2;
        try {
            Result.Companion companion = Result.Companion;
            aVar = up4.a.a;
            a2 = aVar.a();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (a2 != null) {
            if (Intrinsics.areEqual(a2.d, this.a.e)) {
                com.dragon.read.kmp.story.impl.feeds.data.e b2 = aVar.b();
                if (b2 != null) {
                    aVar.d();
                    if (i0.Companion.a().a) {
                        com.dragon.read.kmp.story.impl.feeds.data.f fVar = b2.c;
                        fVar.b = true;
                        fVar.c = true;
                        m773constructorimpl = Result.m773constructorimpl(new m(LoadStatus.Content, m1(op4.b.b(this.r, b2, false, 2, null), "forum"), null, 4, null));
                        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
                        if (m776exceptionOrNullimpl != null) {
                            return new m(LoadStatus.Error, null, m776exceptionOrNullimpl, 2, null);
                        }
                        return m773constructorimpl;
                    }
                    throw new IllegalStateException("Preload disabled");
                }
                throw new IllegalStateException("No preload data");
            }
            throw new IllegalStateException("Preload id mismatch");
        }
        throw new IllegalStateException("No preload story");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|7|(1:(1:(13:11|12|13|14|(1:16)(1:33)|17|18|(6:27|28|21|(1:23)|24|25)|20|21|(0)|24|25)(2:34|35))(2:36|37))(3:42|43|(1:45)(1:46))|38|(1:40)(11:41|14|(0)(0)|17|18|(0)|20|21|(0)|24|25)))|49|6|7|(0)(0)|38|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ee, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ef, code lost:
    
        r2 = kotlin.Result.Companion;
        r0 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00b4 A[Catch: all -> 0x00ee, TryCatch #1 {all -> 0x00ee, blocks: (B:12:0x0035, B:14:0x00b0, B:16:0x00b4, B:17:0x00cc, B:33:0x00c5, B:37:0x0047, B:38:0x007c, B:43:0x006c), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5 A[Catch: all -> 0x00ee, TryCatch #1 {all -> 0x00ee, blocks: (B:12:0x0035, B:14:0x00b0, B:16:0x00b4, B:17:0x00cc, B:33:0x00c5, B:37:0x0047, B:38:0x007c, B:43:0x006c), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object A1(kotlin.coroutines.Continuation<? super com.dragon.read.kmp.story.impl.feeds.container.m<kp4.b>> r18) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.A1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054 A[Catch: all -> 0x014e, TryCatch #1 {all -> 0x014e, blocks: (B:11:0x0029, B:12:0x0137, B:18:0x003f, B:20:0x0048, B:25:0x0054, B:26:0x0088, B:34:0x00db, B:29:0x010f, B:37:0x00f0, B:38:0x0067, B:40:0x006d, B:43:0x0076, B:44:0x0146, B:45:0x014d), top: B:7:0x0021, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0135 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[Catch: all -> 0x014e, TryCatch #1 {all -> 0x014e, blocks: (B:11:0x0029, B:12:0x0137, B:18:0x003f, B:20:0x0048, B:25:0x0054, B:26:0x0088, B:34:0x00db, B:29:0x010f, B:37:0x00f0, B:38:0x0067, B:40:0x006d, B:43:0x0076, B:44:0x0146, B:45:0x014d), top: B:7:0x0021, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B1(kotlin.coroutines.Continuation<? super kotlin.Result<com.dragon.read.kmp.story.impl.feeds.data.g>> r12) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.B1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b2(Function1 function1, kp4.b story) {
        Intrinsics.checkNotNullParameter(story, "story");
        function1.invoke(story);
        return Unit.INSTANCE;
    }

    private final void h2(boolean z, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        kotlinx.coroutines.i.e(this.d, null, null, new KmpStoryFeedsVM$withFrozenScreen$1(z, this, function1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(kp4.b bVar, LoadStatus loadStatus) {
        np4.e f = bVar.f();
        if (f != null) {
            f.j(loadStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kp4.b m1(com.dragon.read.kmp.story.impl.feeds.data.b bVar, String str) {
        return new kp4.b(bVar.a.a, bVar, n1(bVar, str), this.a);
    }

    public final void O1(boolean z, Function0<Unit> function0) {
        h2(z, new KmpStoryFeedsVM$relayoutAllStories$1(this, function0, null));
    }

    private final void U1(boolean z, q6 q6Var) {
        n a2;
        MutableStateFlow<n> mutableStateFlow = this.i;
        a2 = r2.a((r18 & 1) != 0 ? r2.a : null, (r18 & 2) != 0 ? r2.b : null, (r18 & 4) != 0 ? r2.c : null, (r18 & 8) != 0 ? r2.d : q6Var, (r18 & 16) != 0 ? r2.e : z, (r18 & 32) != 0 ? r2.f : null, (r18 & 64) != 0 ? r2.g : false, (r18 & 128) != 0 ? mutableStateFlow.getValue().h : false);
        mutableStateFlow.setValue(a2);
    }

    private final kp4.d n1(com.dragon.read.kmp.story.impl.feeds.data.b bVar, String str) {
        kp4.d dVar = new kp4.d(str);
        if (bVar.a.c.b) {
            l.b(dVar.g, this.a.m);
        }
        return dVar;
    }

    public final void o1(kp4.b story, Function1<? super kp4.b, Unit> function1) {
        Intrinsics.checkNotNullParameter(story, "story");
        story.e.h(true);
        b.a.a(story.f.a, null, 1, null);
        story.q();
        kotlinx.coroutines.i.e(this.d, Dispatchers.getIO(), null, new KmpStoryFeedsVM$expandStory$1(story, this, function1, null), 2, null);
        M1(story);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J1(com.dragon.read.kmp.story.impl.feeds.data.g r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$1
            if (r0 == 0) goto L13
            r0 = r9
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$1 r0 = (com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$1 r0 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L73
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            java.lang.Object r8 = r0.L$0
            com.dragon.read.kmp.story.impl.feeds.data.g r8 = (com.dragon.read.kmp.story.impl.feeds.data.g) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L53
        L3d:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.List<com.dragon.read.kmp.story.impl.feeds.data.e> r9 = r8.a
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$2 r2 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$2
            r6 = 3
            r2.<init>(r9, r6, r7, r5)
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = kotlinx.coroutines.SupervisorKt.supervisorScope(r2, r0)
            if (r9 != r1) goto L53
            return r1
        L53:
            boolean r9 = r8.c
            com.bytedance.kmp.ugc.model.q6 r2 = r8.b
            r7.U1(r9, r2)
            java.lang.String r9 = r8.d
            r7.V1(r9)
            kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getMain()
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$3 r2 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processMoreData$3
            r2.<init>(r7, r8, r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r9, r2, r0)
            if (r8 != r1) goto L73
            return r1
        L73:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.J1(com.dragon.read.kmp.story.impl.feeds.data.g, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l1(kp4.b r6, kotlin.coroutines.Continuation<? super kp4.b> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$commitOrRefreshFirstStory$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$commitOrRefreshFirstStory$1 r0 = (com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$commitOrRefreshFirstStory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$commitOrRefreshFirstStory$1 r0 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$commitOrRefreshFirstStory$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$commitOrRefreshFirstStory$committedStory$1 r2 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$commitOrRefreshFirstStory$committedStory$1
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            kp4.b r7 = (kp4.b) r7
            xm6.a r6 = r5.g
            r0 = 0
            boolean r6 = r6.a(r0, r3)
            if (r6 == 0) goto L69
            r5.M1(r7)
            r5.F1()
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource r6 = com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource.a
            com.dragon.read.kmp.story.impl.feeds.data.e r0 = r7.d()
            java.lang.String r0 = r0.getBookId()
            if (r0 != 0) goto L66
            java.lang.String r0 = ""
        L66:
            r6.f(r0)
        L69:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.l1(kp4.b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K1(kotlinx.coroutines.Deferred<kotlin.Result<com.dragon.read.kmp.story.impl.feeds.data.g>> r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processRecommendationList$1
            if (r2 == 0) goto L17
            r2 = r1
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processRecommendationList$1 r2 = (com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processRecommendationList$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processRecommendationList$1 r2 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processRecommendationList$1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 3
            r6 = 1
            r7 = 2
            if (r4 == 0) goto L46
            if (r4 == r6) goto L42
            if (r4 == r7) goto L3c
            if (r4 != r5) goto L34
            kotlin.ResultKt.throwOnFailure(r1)
            goto Lc6
        L34:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3c:
            java.lang.Object r4 = r2.L$0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L78
        L42:
            kotlin.ResultKt.throwOnFailure(r1)
            goto L54
        L46:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.label = r6
            r1 = r20
            java.lang.Object r1 = r1.await(r2)
            if (r1 != r3) goto L54
            return r3
        L54:
            kotlin.Result r1 = (kotlin.Result) r1
            java.lang.Object r4 = r1.m782unboximpl()
            boolean r1 = kotlin.Result.m780isSuccessimpl(r4)
            if (r1 == 0) goto L95
            r1 = r4
            com.dragon.read.kmp.story.impl.feeds.data.g r1 = (com.dragon.read.kmp.story.impl.feeds.data.g) r1
            com.dragon.read.kmp.story.impl.feeds.trace.j r6 = r0.w
            r6.i()
            com.dragon.read.kmp.story.impl.feeds.trace.j r6 = r0.w
            r6.g()
            r2.L$0 = r4
            r2.label = r7
            java.lang.Object r1 = r0.J1(r1, r2)
            if (r1 != r3) goto L78
            return r3
        L78:
            kotlinx.coroutines.flow.MutableStateFlow<com.dragon.read.kmp.story.impl.feeds.container.n> r1 = r0.i
            java.lang.Object r6 = r1.getValue()
            r8 = r6
            com.dragon.read.kmp.story.impl.feeds.container.n r8 = (com.dragon.read.kmp.story.impl.feeds.container.n) r8
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 127(0x7f, float:1.78E-43)
            r18 = 0
            com.dragon.read.kmp.story.impl.feeds.container.n r6 = com.dragon.read.kmp.story.impl.feeds.container.n.b(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r1.setValue(r6)
        L95:
            java.lang.Throwable r1 = kotlin.Result.m776exceptionOrNullimpl(r4)
            if (r1 == 0) goto Lc6
            tp4.b r6 = r0.e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "processRecommendationList failed, throwable is "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            r8 = 0
            tp4.b.c(r6, r1, r8, r7, r8)
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processRecommendationList$3$1 r6 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$processRecommendationList$3$1
            r6.<init>(r0, r8)
            r2.L$0 = r4
            r2.label = r5
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r6, r2)
            if (r1 != r3) goto Lc6
            return r3
        Lc6:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.K1(kotlinx.coroutines.Deferred, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:0|1|(2:3|(12:5|6|7|(1:(3:10|11|12)(2:29|30))(3:31|32|(1:34)(1:35))|13|14|(6:23|24|17|(1:19)|20|21)|16|17|(0)|20|21))|38|6|7|(0)(0)|13|14|(0)|16|17|(0)|20|21) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a9, code lost:
    
        r14 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
    
        r15 = kotlin.Result.Companion;
        r14 = kotlin.Result.m773constructorimpl(kotlin.ResultKt.createFailure(r14));
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D1(kp4.b r14, kotlin.coroutines.Continuation<? super com.dragon.read.kmp.story.impl.feeds.container.m<com.dragon.read.kmp.story.impl.feeds.data.b>> r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.D1(kp4.b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N1(kp4.b r6, com.dragon.read.kmp.story.impl.feeds.data.b r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$refreshStory$1
            if (r0 == 0) goto L13
            r0 = r8
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$refreshStory$1 r0 = (com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$refreshStory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$refreshStory$1 r0 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$refreshStory$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.L$0
            kp4.b r6 = (kp4.b) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4d
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
            com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$refreshStory$2 r2 = new com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM$refreshStory$2
            r4 = 0
            r2.<init>(r5, r6, r7, r4)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource r7 = com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource.a
            com.dragon.read.kmp.story.impl.feeds.data.e r6 = r6.d()
            java.lang.String r6 = r6.getBookId()
            if (r6 != 0) goto L5b
            java.lang.String r6 = ""
        L5b:
            r7.f(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.container.KmpStoryFeedsVM.N1(kp4.b, com.dragon.read.kmp.story.impl.feeds.data.b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void v1(KmpStoryFeedsVM kmpStoryFeedsVM, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        kmpStoryFeedsVM.u1(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a2(kp4.b bVar, Function0 function0, KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b nextStory) {
        Intrinsics.checkNotNullParameter(nextStory, "nextStory");
        bVar.s();
        if (function0 != null) {
            function0.invoke();
        }
        kmpStoryFeedsVM.k.y(nextStory, false);
        return Unit.INSTANCE;
    }

    public KmpStoryFeedsVM(yo4.d clientParam, LazyListState lazyListState, float f, CoroutineScope composeContext) {
        Job e;
        Intrinsics.checkNotNullParameter(clientParam, "clientParam");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(composeContext, "composeContext");
        this.a = clientParam;
        this.b = lazyListState;
        this.c = f;
        this.d = composeContext;
        this.e = new tp4.b("KmpStoryFeedsVM");
        this.f = xm6.b.a(false);
        this.g = xm6.b.a(false);
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        this.h = viewModelScope;
        MutableStateFlow<n> MutableStateFlow = StateFlowKt.MutableStateFlow(new n(null, null, new mg4.b((String) null, new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.container.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit K0;
                K0 = KmpStoryFeedsVM.K0(KmpStoryFeedsVM.this);
                return K0;
            }
        }, (String) null, (Function0) null, (l0) null, 29, (DefaultConstructorMarker) null), null, false, null, false, false, 251, null));
        this.i = MutableStateFlow;
        this.j = FlowKt.asStateFlow(MutableStateFlow);
        KmpStoryClient kmpStoryClient = new KmpStoryClient(lazyListState, new com.dragon.read.kmp.story.impl.feeds.list.c(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.container.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit W1;
                W1 = KmpStoryFeedsVM.W1(KmpStoryFeedsVM.this);
                return W1;
            }
        }, new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.container.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean X1;
                X1 = KmpStoryFeedsVM.X1(KmpStoryFeedsVM.this);
                return Boolean.valueOf(X1);
            }
        }), composeContext);
        this.k = kmpStoryClient;
        this.l = kmpStoryClient.g;
        this.m = kmpStoryClient.i;
        this.n = kmpStoryClient.k;
        this.o = kmpStoryClient.m;
        this.p = new b();
        e = kotlinx.coroutines.i.e(ViewModelKt.getViewModelScope(this), null, null, new KmpStoryFeedsVM$receiverJob$1(this, null), 3, null);
        this.q = e;
        b1 b1Var = b1.a;
        this.r = new op4.b(f, b1Var.q(), b1Var.o());
        this.s = new StoryProgressService(f, kmpStoryClient, composeContext, new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.container.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean L1;
                L1 = KmpStoryFeedsVM.L1(KmpStoryFeedsVM.this);
                return Boolean.valueOf(L1);
            }
        });
        this.v = new com.dragon.read.kmp.story.impl.feeds.trace.b(clientParam);
        this.w = new com.dragon.read.kmp.story.impl.feeds.trace.j();
        this.y = new w(ec4.l0.Companion.a(), clientParam, f, kmpStoryClient, new c());
        this.z = new KmpStoryPolarisTaskCoordinator();
        kotlinx.coroutines.i.e(viewModelScope, null, null, new AnonymousClass1(null), 3, null);
        kotlinx.coroutines.i.e(viewModelScope, null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void P1(KmpStoryFeedsVM kmpStoryFeedsVM, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        kmpStoryFeedsVM.O1(z, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void p1(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        kmpStoryFeedsVM.o1(bVar, function1);
    }

    public final void Y1(final kp4.b story, kp4.b nextStory, boolean z, String str, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(story, "story");
        Intrinsics.checkNotNullParameter(nextStory, "nextStory");
        nextStory.c.f = str;
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.container.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit a2;
                a2 = KmpStoryFeedsVM.a2(kp4.b.this, function0, this, (kp4.b) obj);
                return a2;
            }
        };
        if (z) {
            o1(nextStory, new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.container.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit b2;
                    b2 = KmpStoryFeedsVM.b2(Function1.this, (kp4.b) obj);
                    return b2;
                }
            });
        } else {
            function1.invoke(nextStory);
        }
    }

    public static /* synthetic */ void Z1(KmpStoryFeedsVM kmpStoryFeedsVM, kp4.b bVar, kp4.b bVar2, boolean z, String str, Function0 function0, int i, Object obj) {
        String str2;
        Function0 function02;
        if ((i & 8) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 16) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        kmpStoryFeedsVM.Y1(bVar, bVar2, z, str2, function02);
    }
}
