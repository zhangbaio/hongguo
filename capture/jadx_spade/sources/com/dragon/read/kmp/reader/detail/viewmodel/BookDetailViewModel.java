package com.dragon.read.kmp.reader.detail.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.pg;
import com.bytedance.kmp.reading.model.t3;
import com.dragon.read.kmp.reader.detail.a;
import com.dragon.read.kmp.reader.detail.b;
import com.dragon.read.kmp.reader.detail.catalog.s;
import com.dragon.read.kmp.reader.detail.n2;
import com.dragon.read.kmp.reader.detail.repo.BookDetailRepository;
import com.dragon.read.kmp.utils.e;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.kmp.widget.w;
import com.ss.ttm.player.MediaPlayer;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.i;
import zm4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookDetailViewModel extends ViewModel {
    public static final int g;
    private final MutableStateFlow<n2> a;
    public final StateFlow<n2> b;
    private final MutableSharedFlow<com.dragon.read.kmp.reader.detail.a> c;
    public final SharedFlow<com.dragon.read.kmp.reader.detail.a> d;
    private final BookDetailRepository e;
    private Job f;

    static {
        Covode.recordClassIndex(608396);
        g = 8;
    }

    public final void S0() {
        T0();
    }

    private final void J0() {
        n2 value;
        n2 b;
        MutableStateFlow<n2> mutableStateFlow = this.a;
        do {
            value = mutableStateFlow.getValue();
            n2 n2Var = value;
            b = n2Var.b((r34 & 1) != 0 ? n2Var.a : null, (r34 & 2) != 0 ? n2Var.b : false, (r34 & 4) != 0 ? n2Var.c : false, (r34 & 8) != 0 ? n2Var.d : s.b(n2Var.d, false, false, null, 6, null), (r34 & 16) != 0 ? n2Var.e : null, (r34 & 32) != 0 ? n2Var.f : null, (r34 & 64) != 0 ? n2Var.g : null, (r34 & 128) != 0 ? n2Var.h : null, (r34 & 256) != 0 ? n2Var.i : null, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? n2Var.j : null, (r34 & 1024) != 0 ? n2Var.k : false, (r34 & 2048) != 0 ? n2Var.l : false, (r34 & 4096) != 0 ? n2Var.m : null, (r34 & 8192) != 0 ? n2Var.n : null, (r34 & 16384) != 0 ? n2Var.o : null, (r34 & 32768) != 0 ? n2Var.p : false);
        } while (!mutableStateFlow.compareAndSet(value, b));
    }

    private final void P0() {
        String str;
        boolean z;
        t3 t3Var = this.a.getValue().a;
        String str2 = null;
        if (t3Var != null) {
            str = t3Var.e;
        } else {
            str = null;
        }
        if (t3Var != null) {
            str2 = t3Var.f;
        }
        boolean z2 = false;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            if (str2 == null || str2.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                M0(new a.d(str2));
            }
        }
    }

    private final void U0() {
        n2 value;
        n2 b;
        MutableStateFlow<n2> mutableStateFlow = this.a;
        do {
            value = mutableStateFlow.getValue();
            b = r3.b((r34 & 1) != 0 ? r3.a : null, (r34 & 2) != 0 ? r3.b : false, (r34 & 4) != 0 ? r3.c : !r3.c, (r34 & 8) != 0 ? r3.d : null, (r34 & 16) != 0 ? r3.e : null, (r34 & 32) != 0 ? r3.f : null, (r34 & 64) != 0 ? r3.g : null, (r34 & 128) != 0 ? r3.h : null, (r34 & 256) != 0 ? r3.i : null, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? r3.j : null, (r34 & 1024) != 0 ? r3.k : false, (r34 & 2048) != 0 ? r3.l : false, (r34 & 4096) != 0 ? r3.m : null, (r34 & 8192) != 0 ? r3.n : null, (r34 & 16384) != 0 ? r3.o : null, (r34 & 32768) != 0 ? value.p : false);
        } while (!mutableStateFlow.compareAndSet(value, b));
    }

    public BookDetailViewModel() {
        MutableStateFlow<n2> MutableStateFlow = StateFlowKt.MutableStateFlow(new n2(null, false, false, null, null, null, null, null, null, null, false, false, null, null, null, false, 65535, null));
        this.a = MutableStateFlow;
        this.b = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<com.dragon.read.kmp.reader.detail.a> MutableSharedFlow = SharedFlowKt.MutableSharedFlow(0, 1, BufferOverflow.DROP_OLDEST);
        this.c = MutableSharedFlow;
        this.d = FlowKt.asSharedFlow(MutableSharedFlow);
        this.e = new BookDetailRepository();
    }

    private final void T0() {
        n2 value;
        n2 b;
        s sVar = this.a.getValue().d;
        if (sVar.c.isEmpty()) {
            return;
        }
        boolean z = !sVar.b;
        MutableStateFlow<n2> mutableStateFlow = this.a;
        do {
            value = mutableStateFlow.getValue();
            b = r11.b((r34 & 1) != 0 ? r11.a : null, (r34 & 2) != 0 ? r11.b : false, (r34 & 4) != 0 ? r11.c : false, (r34 & 8) != 0 ? r11.d : s.b(sVar, false, z, this.e.u(z), 1, null), (r34 & 16) != 0 ? r11.e : null, (r34 & 32) != 0 ? r11.f : null, (r34 & 64) != 0 ? r11.g : null, (r34 & 128) != 0 ? r11.h : null, (r34 & 256) != 0 ? r11.i : null, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? r11.j : null, (r34 & 1024) != 0 ? r11.k : false, (r34 & 2048) != 0 ? r11.l : false, (r34 & 4096) != 0 ? r11.m : null, (r34 & 8192) != 0 ? r11.n : null, (r34 & 16384) != 0 ? r11.o : null, (r34 & 32768) != 0 ? value.p : false);
        } while (!mutableStateFlow.compareAndSet(value, b));
    }

    private final void I0(String str) {
        i.e(ViewModelKt.getViewModelScope(this), null, null, new BookDetailViewModel$addBookshelf$1(str, null), 3, null);
    }

    private final void M0(com.dragon.read.kmp.reader.detail.a aVar) {
        i.e(ViewModelKt.getViewModelScope(this), null, null, new BookDetailViewModel$emitEffect$1(this, aVar, null), 3, null);
    }

    private final void Q0(String str) {
        i.e(ViewModelKt.getViewModelScope(this), null, null, new BookDetailViewModel$refreshAlsoReadItems$1(this, str, null), 3, null);
    }

    public final void V0(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        i.e(ViewModelKt.getViewModelScope(this), null, null, new BookDetailViewModel$updateBookshelfState$1(this, bookId, null), 3, null);
    }

    public final void R0(String bookId) {
        n2 value;
        n2 b;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        MutableStateFlow<n2> mutableStateFlow = this.a;
        do {
            value = mutableStateFlow.getValue();
            n2 n2Var = value;
            b = n2Var.b((r34 & 1) != 0 ? n2Var.a : null, (r34 & 2) != 0 ? n2Var.b : false, (r34 & 4) != 0 ? n2Var.c : false, (r34 & 8) != 0 ? n2Var.d : s.b(n2Var.d, true, false, null, 6, null), (r34 & 16) != 0 ? n2Var.e : null, (r34 & 32) != 0 ? n2Var.f : null, (r34 & 64) != 0 ? n2Var.g : null, (r34 & 128) != 0 ? n2Var.h : null, (r34 & 256) != 0 ? n2Var.i : null, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? n2Var.j : null, (r34 & 1024) != 0 ? n2Var.k : false, (r34 & 2048) != 0 ? n2Var.l : false, (r34 & 4096) != 0 ? n2Var.m : null, (r34 & 8192) != 0 ? n2Var.n : null, (r34 & 16384) != 0 ? n2Var.o : null, (r34 & 32768) != 0 ? n2Var.p : false);
        } while (!mutableStateFlow.compareAndSet(value, b));
    }

    public final void K0(b intent) {
        String str;
        String str2;
        pg pgVar;
        e90 e90Var;
        String str3;
        String str4;
        boolean z;
        Intrinsics.checkNotNullParameter(intent, "intent");
        t3 t3Var = this.a.getValue().a;
        String str5 = "";
        if (t3Var == null || (str = t3Var.e) == null) {
            str = "";
        }
        t3 t3Var2 = this.a.getValue().a;
        if (t3Var2 == null || (str2 = t3Var2.f) == null) {
            str2 = "";
        }
        if (Intrinsics.areEqual(intent, b.d.a)) {
            M0(new a.C0046a(str));
            return;
        }
        if (Intrinsics.areEqual(intent, b.a.a)) {
            I0(str);
            return;
        }
        if (Intrinsics.areEqual(intent, b.o.a)) {
            M0(new a.g(str, new e() { // from class: com.dragon.read.kmp.reader.detail.viewmodel.a
                @Override // com.dragon.read.kmp.utils.e
                public final void callback(Object obj) {
                    BookDetailViewModel.L0(BookDetailViewModel.this, ((Boolean) obj).booleanValue());
                }
            }));
            return;
        }
        if (Intrinsics.areEqual(intent, b.l.a)) {
            M0(new a.f(str));
            return;
        }
        if (Intrinsics.areEqual(intent, b.q.a)) {
            U0();
            return;
        }
        if (Intrinsics.areEqual(intent, b.j.a)) {
            R0(str);
            return;
        }
        if (Intrinsics.areEqual(intent, b.f.a)) {
            J0();
            return;
        }
        if (Intrinsics.areEqual(intent, b.p.a)) {
            S0();
            return;
        }
        if (Intrinsics.areEqual(intent, b.h.a)) {
            n2 value = this.a.getValue();
            if (!value.k) {
                return;
            }
            M0(new a.c(str, str2, value.m));
            return;
        }
        if (!Intrinsics.areEqual(intent, b.g.a)) {
            String str6 = null;
            if (Intrinsics.areEqual(intent, b.k.a)) {
                t3 t3Var3 = this.a.getValue().a;
                if (t3Var3 != null) {
                    str6 = t3Var3.M;
                }
                M0(new a.e(str, str2, str6));
                return;
            }
            if (Intrinsics.areEqual(intent, b.c.a)) {
                t3 t3Var4 = this.a.getValue().a;
                if (t3Var4 != null) {
                    str6 = t3Var4.e;
                }
                Intrinsics.checkNotNull(str6);
                Q0(str6);
                return;
            }
            if (Intrinsics.areEqual(intent, b.C0047b.a)) {
                P0();
                return;
            }
            if (Intrinsics.areEqual(intent, b.m.a)) {
                String str7 = this.a.getValue().n;
                if (str7 != null && !StringsKt__StringsKt.isBlank(str7)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    M0(new a.h(str7));
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(intent, b.n.a)) {
                t3 t3Var5 = this.a.getValue().a;
                if (t3Var5 != null && (str4 = t3Var5.c1) != null) {
                    str5 = str4;
                } else {
                    t3 t3Var6 = this.a.getValue().a;
                    if (t3Var6 != null) {
                        str6 = t3Var6.J0;
                    }
                    if (str6 != null) {
                        str5 = str6;
                    }
                }
                if (!StringsKt__StringsKt.isBlank(str5)) {
                    M0(new a.h(str5));
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(intent, b.i.a)) {
                t3 t3Var7 = this.a.getValue().a;
                if (t3Var7 != null && (pgVar = t3Var7.u1) != null && (e90Var = pgVar.b) != null && (str3 = e90Var.f) != null) {
                    d.a.c(str3, null, k0.a.b().d("from_page", "书籍详情页").d("module_name", "排行榜").d("tag_position", "书籍详情页"));
                    return;
                }
                return;
            }
            if (intent instanceof b.e) {
                b.e eVar = (b.e) intent;
                M0(new a.b(eVar.getContext(), eVar.b, eVar.c, eVar.d, eVar.e));
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class a implements ViewModelProvider.Factory {
        static {
            Covode.recordClassIndex(608397);
        }

        public /* synthetic */ ViewModel create(Class cls) {
            return ViewModelProvider.Factory.-CC.$default$create(this, cls);
        }

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
        }

        public <T extends ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return new BookDetailViewModel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(BookDetailViewModel bookDetailViewModel, boolean z) {
        n2 value;
        n2 b;
        MutableStateFlow<n2> mutableStateFlow = bookDetailViewModel.a;
        do {
            value = mutableStateFlow.getValue();
            b = r2.b((r34 & 1) != 0 ? r2.a : null, (r34 & 2) != 0 ? r2.b : z, (r34 & 4) != 0 ? r2.c : false, (r34 & 8) != 0 ? r2.d : null, (r34 & 16) != 0 ? r2.e : null, (r34 & 32) != 0 ? r2.f : null, (r34 & 64) != 0 ? r2.g : null, (r34 & 128) != 0 ? r2.h : null, (r34 & 256) != 0 ? r2.i : null, (r34 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? r2.j : null, (r34 & 1024) != 0 ? r2.k : false, (r34 & 2048) != 0 ? r2.l : false, (r34 & 4096) != 0 ? r2.m : null, (r34 & 8192) != 0 ? r2.n : null, (r34 & 16384) != 0 ? r2.o : null, (r34 & 32768) != 0 ? value.p : false);
        } while (!mutableStateFlow.compareAndSet(value, b));
    }

    public final void N0(com.dragon.read.kmp.reader.detail.d args, Function1<? super com.dragon.read.kmp.reader.detail.repo.b, Unit> resolve, Function1<? super w, Unit> reject) {
        Job e;
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        Job job = this.f;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        e = i.e(ViewModelKt.getViewModelScope(this), null, null, new BookDetailViewModel$load$1(reject, this, resolve, args, null), 3, null);
        this.f = e;
    }

    public final void O0(String bookId, Function1<? super com.dragon.read.kmp.reader.detail.catalog.b, Unit> resolve, Function1<? super w, Unit> reject) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        i.e(ViewModelKt.getViewModelScope(this), null, null, new BookDetailViewModel$loadCatalog$1(reject, this, resolve, bookId, null), 3, null);
    }
}
