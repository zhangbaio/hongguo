package com.dragon.read.kmp.reader.detail;

import android.content.Context;
import androidx.compose.runtime.State;
import com.bytedance.kmp.reading.model.t3;
import com.dragon.read.kmp.reader.detail.a;
import com.dragon.read.kmp.reader.detail.viewmodel.BookDetailViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailPageKt$BookDetailPage$6$1", f = "BookDetailPage.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailPageKt$BookDetailPage$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $args;
    final /* synthetic */ State<n2> $state$delegate;
    final /* synthetic */ BookDetailViewModel $vm;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailPageKt$BookDetailPage$6$1(BookDetailViewModel bookDetailViewModel, d dVar, State<n2> state, Continuation<? super BookDetailPageKt$BookDetailPage$6$1> continuation) {
        super(2, continuation);
        this.$vm = bookDetailViewModel;
        this.$args = dVar;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailPageKt$BookDetailPage$6$1(this.$vm, this.$args, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailPageKt$BookDetailPage$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            SharedFlow<com.dragon.read.kmp.reader.detail.a> sharedFlow = this.$vm.d;
            a aVar = new a(this.$args, this.$state$delegate);
            this.label = 1;
            if (sharedFlow.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        throw new KotlinNothingValueException();
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ d a;
        final /* synthetic */ State<n2> b;

        a(d dVar, State<n2> state) {
            this.a = dVar;
            this.b = state;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v20, types: [java.lang.CharSequence, java.lang.String] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(com.dragon.read.kmp.reader.detail.a aVar, Continuation<? super Unit> continuation) {
            n2 l;
            n2 l2;
            n2 l3;
            v2 v2Var;
            if (aVar instanceof a.C0046a) {
                v2 v2Var2 = this.a.d;
                if (v2Var2 != null) {
                    v2Var2.onClose();
                }
            } else {
                ym4.k kVar = null;
                boolean z = true;
                if (aVar instanceof a.e) {
                    l3 = BookDetailPageKt.l(this.b);
                    String q = l3.q(this.a.f);
                    Context b = ig4.f.b();
                    a.e eVar = (a.e) aVar;
                    String str = eVar.a;
                    String str2 = eVar.b;
                    if (StringsKt__StringsKt.isBlank(q)) {
                        String str3 = eVar.c;
                        if (str3 == null) {
                            str3 = "";
                        }
                        q = str3;
                    }
                    com.dragon.read.kmp.reader.utils.o oVar = new com.dragon.read.kmp.reader.utils.o(b, str, str2, q);
                    ?? r8 = this.a.e;
                    if (r8 != 0) {
                        if (!StringsKt__StringsKt.isBlank(r8)) {
                            kVar = r8;
                        }
                        if (kVar != null) {
                            oVar.e("alias_name", kVar);
                        }
                    }
                    if (this.a.c) {
                        oVar.g(true).d(6);
                    }
                    oVar.a();
                    d dVar = this.a;
                    if (dVar.c && (v2Var = dVar.d) != null) {
                        v2Var.onClose();
                    }
                } else if (aVar instanceof a.c) {
                    a.c cVar = (a.c) aVar;
                    String str4 = cVar.c;
                    if (str4 != null && str4.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        com.dragon.read.kmp.service.b1.a.D(str4);
                    } else {
                        b55.a aVar2 = new b55.a(cVar.a);
                        aVar2.d = "read_page";
                        Context b2 = ig4.f.b();
                        if (b2 != null) {
                            kVar = com.dragon.read.kmp.utils.m0.b(b2);
                        }
                        aVar2.c = kVar;
                        ct2.n.Z0.P2().E(aVar2);
                    }
                } else if (aVar instanceof a.g) {
                    com.dragon.read.kmp.reader.detail.platform.j jVar = com.dragon.read.kmp.reader.detail.platform.j.a;
                    String str5 = ((a.g) aVar).a;
                    l = BookDetailPageKt.l(this.b);
                    t3 t3Var = l.a;
                    Intrinsics.checkNotNull(t3Var);
                    l2 = BookDetailPageKt.l(this.b);
                    jVar.j(str5, t3Var, l2.b);
                } else if (aVar instanceof a.h) {
                    zm4.d.d(zm4.d.a, ((a.h) aVar).a, null, null, 6, null);
                } else if (aVar instanceof a.d) {
                    ym4.k b3 = com.dragon.read.kmp.utils.k0.a.b();
                    b3.d("conversation_position", "book_detail_page").d("book_id", this.a.a).d("ai_conversation_type", "ai_search_book").d("if_push_book_ai", "1").d("conversation_type", "single_chat").d("from_book_id", this.a.a);
                    com.dragon.read.kmp.reader.detail.platform.a.a.c("book_detail_page", "读《" + ((a.d) aVar).a + "》的人还在读什么？", b3);
                } else if (aVar instanceof a.f) {
                    com.dragon.read.kmp.service.b1.a.D("全部书评入口暂未接入");
                } else if (aVar instanceof a.b) {
                    BookDetailPageKt.F((a.b) aVar);
                }
            }
            return Unit.INSTANCE;
        }
    }
}
