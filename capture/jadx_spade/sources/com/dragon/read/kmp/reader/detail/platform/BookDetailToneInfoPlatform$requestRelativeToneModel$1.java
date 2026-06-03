package com.dragon.read.kmp.reader.detail.platform;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.detail.platform.BookDetailToneInfoPlatform", f = "BookDetailToneInfoPlatform.android.kt", i = {0, 0, 0}, l = {40}, m = "requestRelativeToneModel", n = {"bookId", "noAudioMessage", "isLocalBook"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class BookDetailToneInfoPlatform$requestRelativeToneModel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BookDetailToneInfoPlatform this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BookDetailToneInfoPlatform$requestRelativeToneModel$1(BookDetailToneInfoPlatform bookDetailToneInfoPlatform, Continuation<? super BookDetailToneInfoPlatform$requestRelativeToneModel$1> continuation) {
        super(continuation);
        this.this$0 = bookDetailToneInfoPlatform;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, false, this);
    }
}
