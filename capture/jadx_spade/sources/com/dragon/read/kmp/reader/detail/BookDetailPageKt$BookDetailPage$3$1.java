package com.dragon.read.kmp.reader.detail;

import android.content.Intent;
import com.dragon.read.kmp.kmp_compat.com.ss.android.messagebus.BusProvider;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.BookDetailPageKt$BookDetailPage$3$1", f = "BookDetailPage.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailPageKt$BookDetailPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $args;
    final /* synthetic */ BookDetailViewModel $vm;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailPageKt$BookDetailPage$3$1(BookDetailViewModel bookDetailViewModel, d dVar, Continuation<? super BookDetailPageKt$BookDetailPage$3$1> continuation) {
        super(2, continuation);
        this.$vm = bookDetailViewModel;
        this.$args = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BookDetailPageKt$BookDetailPage$3$1(this.$vm, this.$args, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookDetailPageKt$BookDetailPage$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            SharedFlow b = BusProvider.a.b();
            a aVar = new a(this.$vm, this.$args);
            this.label = 1;
            if (b.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        throw new KotlinNothingValueException();
    }

    static final class a<T> implements FlowCollector {
        final /* synthetic */ BookDetailViewModel a;
        final /* synthetic */ d b;

        a(BookDetailViewModel bookDetailViewModel, d dVar) {
            this.a = bookDetailViewModel;
            this.b = dVar;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object obj, Continuation<? super Unit> continuation) {
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                if (Intrinsics.areEqual(intent.getAction(), "action_add_bookshelf_complete") || Intrinsics.areEqual(intent.getAction(), "action_remove_bookshelf_complete")) {
                    this.a.V0(this.b.a);
                }
            }
            return Unit.INSTANCE;
        }
    }
}
