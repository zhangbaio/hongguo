package com.dragon.read.kmp.profile.guestprofile.aicontent;

import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.rf;
import com.bytedance.kmp.reading.model.tf;
import com.bytedance.kmp.reading.rpc.DistributionApiService;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.community.api.model.SeriesAICreateEditorParams;
import com.dragon.read.kmp.community.api.model.SeriesAiInfo;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.kmp.util.kotlin.CollectionKt;
import com.dragon.read.kmp.utils.k0;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class AiGeneratedVideoViewModel extends ViewModel {
    public static final a g;
    public static final int h;
    private final MutableStateFlow<l> a;
    public final StateFlow<l> b;
    private final Lazy c;
    private l d;
    private Job e;
    private final Lazy f;

    public static final class a {
        static {
            Covode.recordClassIndex(608117);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608118);
            int[] iArr = new int[AiGeneratedVideoGenerationState.values().length];
            try {
                iArr[AiGeneratedVideoGenerationState.GENERATED_AND_PREVIEWABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AiGeneratedVideoGenerationState.GENERATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AiGeneratedVideoGenerationState.FAILED_AND_RETRYABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AiGeneratedVideoGenerationState.FAILED_AND_UN_RETRYABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AiGeneratedVideoGenerationState.GENERATING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608116);
        g = new a(null);
        h = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Random.Default i1() {
        return Random.Default;
    }

    public final void Z0() {
        j1(null);
    }

    protected void onCleared() {
        super.onCleared();
        O0();
    }

    private final void O0() {
        Job job = this.e;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.e = null;
    }

    private final String W0() {
        return (String) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Random.Default X0() {
        return (Random.Default) this.f.getValue();
    }

    private final void g1() {
        zm4.d.a.c(W0(), R0(), k0.a.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h1() {
        return zm4.e.a.a() + "://parallelWorldPreview";
    }

    private final void l1() {
        Job e;
        O0();
        e = kotlinx.coroutines.i.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AiGeneratedVideoViewModel$startProgressUpdate$1(this, null), 3, null);
        this.e = e;
    }

    private final void N0() {
        com.dragon.read.kmp.profile.guestprofile.aicontent.a aVar = this.b.getValue().p;
        aVar.f.put("is_retry", "1");
        aVar.f.put("retry_task_id", this.b.getValue().a);
    }

    public AiGeneratedVideoViewModel() {
        Lazy lazy;
        Lazy lazy2;
        MutableStateFlow<l> MutableStateFlow = StateFlowKt.MutableStateFlow(new l(null, null, null, null, false, null, null, null, null, null, false, false, false, null, 0.0f, null, false, 131071, null));
        this.a = MutableStateFlow;
        this.b = FlowKt.asStateFlow(MutableStateFlow);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String h1;
                h1 = AiGeneratedVideoViewModel.h1();
                return h1;
            }
        });
        this.c = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Random.Default i1;
                i1 = AiGeneratedVideoViewModel.i1();
                return i1;
            }
        });
        this.f = lazy2;
    }

    private final Map<String, String> R0() {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("series_id", this.b.getValue().p.a), TuplesKt.to("vid", this.b.getValue().b), TuplesKt.to("task_id", this.b.getValue().a), TuplesKt.to("video_title", this.b.getValue().c), TuplesKt.to("video_cover", this.b.getValue().i));
        return mapOf;
    }

    private final void a1() {
        Observable b2 = DistributionApiService.b(DistributionApiService.a, m.a(this.b.getValue().p), (zn0.g) null, 2, (Object) null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = b2.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit c1;
                c1 = AiGeneratedVideoViewModel.c1(AiGeneratedVideoViewModel.this, (tf) obj);
                return c1;
            }
        };
        Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AiGeneratedVideoViewModel.d1(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e1;
                e1 = AiGeneratedVideoViewModel.e1((Throwable) obj);
                return e1;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.profile.guestprofile.aicontent.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AiGeneratedVideoViewModel.b1(Function1.this, obj);
            }
        });
    }

    public final void Y0() {
        int i = b.a[this.b.getValue().n.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i == 5) {
                        b1.a.D("生成中，请耐心等待");
                        return;
                    }
                    return;
                } else {
                    N0();
                    f1();
                    j1("recreate");
                    return;
                }
            }
            N0();
            a1();
            j1("retry");
            return;
        }
        g1();
        j1("publish");
    }

    private final void f1() {
        ym4.k b2 = k0.a.b();
        b2.d("edit_page_entrance", "failed_recreate");
        b2.d("src_material_id", this.b.getValue().p.a);
        tb4.d a2 = tb4.d.d3.a();
        String str = this.b.getValue().p.a;
        List<String> list = this.b.getValue().p.b;
        String str2 = this.b.getValue().p.c;
        List<String> list2 = this.b.getValue().p.d;
        Map<String, String> map = this.b.getValue().p.e;
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.b.getValue().p.f);
        Unit unit = Unit.INSTANCE;
        a2.H7(new SeriesAICreateEditorParams(str, list, str2, list2, map, hashMap, (SeriesAiInfo) null, 64, (DefaultConstructorMarker) null), b2);
    }

    private final boolean S0(l lVar) {
        if (lVar.n == AiGeneratedVideoGenerationState.GENERATED_AND_PREVIEWABLE) {
            return true;
        }
        return false;
    }

    private final boolean T0(l lVar) {
        if (lVar.n == AiGeneratedVideoGenerationState.FAILED_AND_UN_RETRYABLE && lVar.m) {
            return true;
        }
        return false;
    }

    private final String Q0(l lVar) {
        if (b.a[lVar.n.ordinal()] == 1) {
            return "";
        }
        return lVar.j;
    }

    public final void k1(l state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.d = state;
        this.a.setValue(U0(state));
        if (state.n == AiGeneratedVideoGenerationState.GENERATING) {
            l1();
        } else {
            O0();
        }
    }

    private final String P0(l lVar) {
        boolean z;
        boolean a2 = fq4.a.a.a();
        if (lVar.n == AiGeneratedVideoGenerationState.GENERATED_AND_PREVIEWABLE) {
            if (lVar.h.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return lVar.h;
            }
        }
        if (a2) {
            return lVar.g;
        }
        return lVar.f;
    }

    private final l U0(l lVar) {
        l a2;
        a2 = lVar.a((r35 & 1) != 0 ? lVar.a : null, (r35 & 2) != 0 ? lVar.b : null, (r35 & 4) != 0 ? lVar.c : null, (r35 & 8) != 0 ? lVar.d : P0(lVar), (r35 & 16) != 0 ? lVar.e : S0(lVar), (r35 & 32) != 0 ? lVar.f : null, (r35 & 64) != 0 ? lVar.g : null, (r35 & 128) != 0 ? lVar.h : null, (r35 & 256) != 0 ? lVar.i : null, (r35 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? lVar.j : Q0(lVar), (r35 & 1024) != 0 ? lVar.k : S0(lVar), (r35 & 2048) != 0 ? lVar.l : T0(lVar), (r35 & 4096) != 0 ? lVar.m : false, (r35 & 8192) != 0 ? lVar.n : null, (r35 & 16384) != 0 ? lVar.o : 0.0f, (r35 & 32768) != 0 ? lVar.p : null, (r35 & 65536) != 0 ? lVar.q : false);
        return a2;
    }

    private final String V0(l lVar) {
        int i = b.a[lVar.n.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3 && i != 4) {
                if (i == 5) {
                    return "doing";
                }
                throw new NoWhenBranchMatchedException();
            }
            return "failed";
        }
        return "success";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(Throwable th) {
        b1.a.D("生成失败，请重试");
        com.dragon.read.kmp.base.util.b.d("AiGeneratedVideoViewModel", "handleRetryClick error: " + th);
        return Unit.INSTANCE;
    }

    private final void j1(String str) {
        String str2;
        if (str != null) {
            str2 = "ai_multiverese_video_generate_click";
        } else {
            str2 = "ai_multiverese_video_generate_status";
        }
        ym4.k b2 = k0.a.b();
        ym4.o oVar = ym4.o.a;
        ym4.a aVar = new ym4.a();
        String str3 = (String) CollectionKt.a(b2.k(), "tab_name");
        if (str3 != null) {
            aVar.g("tab_name", str3);
        }
        aVar.g("src_material_id", this.b.getValue().b);
        aVar.g("generate_result", V0(this.b.getValue()));
        aVar.g("failed_msg", this.b.getValue().j);
        if (str != null) {
            aVar.g("clicked_content", str);
        }
        Unit unit = Unit.INSTANCE;
        oVar.d(str2, aVar);
    }

    private final void m1(String str) {
        l value;
        AiGeneratedVideoGenerationState aiGeneratedVideoGenerationState;
        l a2;
        MutableStateFlow<l> mutableStateFlow = this.a;
        do {
            value = mutableStateFlow.getValue();
            aiGeneratedVideoGenerationState = AiGeneratedVideoGenerationState.GENERATING;
            a2 = r3.a((r35 & 1) != 0 ? r3.a : str, (r35 & 2) != 0 ? r3.b : null, (r35 & 4) != 0 ? r3.c : null, (r35 & 8) != 0 ? r3.d : null, (r35 & 16) != 0 ? r3.e : false, (r35 & 32) != 0 ? r3.f : null, (r35 & 64) != 0 ? r3.g : null, (r35 & 128) != 0 ? r3.h : null, (r35 & 256) != 0 ? r3.i : null, (r35 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? r3.j : "生成中", (r35 & 1024) != 0 ? r3.k : false, (r35 & 2048) != 0 ? r3.l : false, (r35 & 4096) != 0 ? r3.m : false, (r35 & 8192) != 0 ? r3.n : aiGeneratedVideoGenerationState, (r35 & 16384) != 0 ? r3.o : 0.0f, (r35 & 32768) != 0 ? r3.p : null, (r35 & 65536) != 0 ? value.q : false);
        } while (!mutableStateFlow.compareAndSet(value, a2));
        l lVar = this.d;
        if (lVar != null) {
            lVar.e(str);
            lVar.c("生成中");
            lVar.o = 0.0f;
            lVar.d(aiGeneratedVideoGenerationState);
        }
        l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(AiGeneratedVideoViewModel aiGeneratedVideoViewModel, tf tfVar) {
        String str;
        bc4.b.d(bc4.b.a, tfVar.c, tfVar.d, tfVar.a, false, 0, 24, (Object) null);
        rf rfVar = tfVar.a;
        if (rfVar != null && (str = rfVar.a) != null) {
            aiGeneratedVideoViewModel.m1(str);
        }
        b1.a.D("本次重试不消耗今日额度");
        aiGeneratedVideoViewModel.j1(null);
        return Unit.INSTANCE;
    }
}
