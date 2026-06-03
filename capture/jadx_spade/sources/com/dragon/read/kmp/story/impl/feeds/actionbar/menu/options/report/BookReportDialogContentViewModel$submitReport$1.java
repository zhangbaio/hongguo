package com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report;

import com.bytedance.kmp.reading.model.bp0;
import com.bytedance.kmp.reading.model.g8;
import com.bytedance.kmp.reading.model.h8;
import com.bytedance.kmp.reading.rpc.ReaderApiService;
import com.dragon.read.kmp.utils.h0;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@DebugMetadata(c = "com.dragon.read.kmp.story.impl.feeds.actionbar.menu.options.report.BookReportDialogContentViewModel$submitReport$1", f = "BookReportOption.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookReportDialogContentViewModel$submitReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BookReportDialogContentViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookReportDialogContentViewModel$submitReport$1(BookReportDialogContentViewModel bookReportDialogContentViewModel, Continuation<? super BookReportDialogContentViewModel$submitReport$1> continuation) {
        super(2, continuation);
        this.this$0 = bookReportDialogContentViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BookReportDialogContentViewModel$submitReport$1 bookReportDialogContentViewModel$submitReport$1 = new BookReportDialogContentViewModel$submitReport$1(this.this$0, continuation);
        bookReportDialogContentViewModel$submitReport$1.L$0 = obj;
        return bookReportDialogContentViewModel$submitReport$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BookReportDialogContentViewModel$submitReport$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object m773constructorimpl;
        Long l;
        Long l2;
        String str;
        Object b;
        BookReportDialogContentViewModel bookReportDialogContentViewModel;
        Integer num;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    bookReportDialogContentViewModel = (BookReportDialogContentViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    b = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                BookReportDialogContentViewModel bookReportDialogContentViewModel2 = this.this$0;
                Result.Companion companion = Result.Companion;
                ReaderApiService readerApiService = ReaderApiService.a;
                String bookId = bookReportDialogContentViewModel2.j.d().getBookId();
                long j = 0;
                if (bookId != null) {
                    l = Boxing.boxLong(h0.k(bookId, 0L));
                } else {
                    l = null;
                }
                String groupId = bookReportDialogContentViewModel2.j.d().getGroupId();
                if (groupId != null) {
                    l2 = Boxing.boxLong(h0.k(groupId, 0L));
                } else {
                    l2 = null;
                }
                com.dragon.read.kmp.community.common.dialog.report.f fVar = (com.dragon.read.kmp.community.common.dialog.report.f) ((com.dragon.read.kmp.community.common.dialog.report.a) bookReportDialogContentViewModel2).f.getValue();
                if (fVar != null) {
                    j = fVar.a;
                }
                com.dragon.read.kmp.community.common.dialog.report.f fVar2 = (com.dragon.read.kmp.community.common.dialog.report.f) ((com.dragon.read.kmp.community.common.dialog.report.a) bookReportDialogContentViewModel2).f.getValue();
                if (fVar2 != null) {
                    str = fVar2.b;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                g8 g8Var = new g8(l, l2, Boxing.boxLong(j), (String) ((com.dragon.read.kmp.community.common.dialog.report.a) bookReportDialogContentViewModel2).g.getValue(), str, (bp0) null, (Long) null, (List) null, (String) null, 480, (DefaultConstructorMarker) null);
                this.L$0 = bookReportDialogContentViewModel2;
                this.label = 1;
                b = ReaderApiService.b(readerApiService, g8Var, (zn0.g) null, this, 2, (Object) null);
                if (b == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bookReportDialogContentViewModel = bookReportDialogContentViewModel2;
            }
            h8 h8Var = (h8) b;
            bc4.b bVar = bc4.b.a;
            if (h8Var != null) {
                num = h8Var.a;
            } else {
                num = null;
            }
            if (h8Var != null) {
                str2 = h8Var.b;
            } else {
                str2 = null;
            }
            bc4.b.d(bVar, num, str2, (Object) null, false, 0, 8, (Object) null);
            ((com.dragon.read.kmp.community.common.dialog.report.a) bookReportDialogContentViewModel).e = false;
            m773constructorimpl = Result.m773constructorimpl(h8Var);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        BookReportDialogContentViewModel bookReportDialogContentViewModel3 = this.this$0;
        if (Result.m780isSuccessimpl(m773constructorimpl)) {
            kotlinx.coroutines.i.e(((com.dragon.read.kmp.community.common.dialog.report.a) bookReportDialogContentViewModel3).c, Dispatchers.getMain(), null, new BookReportDialogContentViewModel$submitReport$1$2$1(bookReportDialogContentViewModel3, null), 2, null);
        }
        BookReportDialogContentViewModel bookReportDialogContentViewModel4 = this.this$0;
        if (Result.m776exceptionOrNullimpl(m773constructorimpl) != null) {
            kotlinx.coroutines.i.e(((com.dragon.read.kmp.community.common.dialog.report.a) bookReportDialogContentViewModel4).c, Dispatchers.getMain(), null, new BookReportDialogContentViewModel$submitReport$1$3$1(null), 2, null);
        }
        return Unit.INSTANCE;
    }
}
