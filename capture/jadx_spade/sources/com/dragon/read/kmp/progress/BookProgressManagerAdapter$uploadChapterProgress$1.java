package com.dragon.read.kmp.progress;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.progress.BookProgressManagerAdapter", f = "BookProgressManagerAdapter.android.kt", i = {}, l = {ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT}, m = "uploadChapterProgress", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookProgressManagerAdapter$uploadChapterProgress$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BookProgressManagerAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookProgressManagerAdapter$uploadChapterProgress$1(BookProgressManagerAdapter bookProgressManagerAdapter, Continuation<? super BookProgressManagerAdapter$uploadChapterProgress$1> continuation) {
        super(continuation);
        this.this$0 = bookProgressManagerAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
