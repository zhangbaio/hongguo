package com.dragon.read.kmp.reader.services;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "com.dragon.read.kmp.reader.services.ReaderTtsSyncServiceImpl", f = "ReaderTtsSyncServiceImpl.android.kt", i = {}, l = {ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE}, m = "getCurrentAudioSyncReaderModel", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderTtsSyncServiceImpl$getCurrentAudioSyncReaderModel$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReaderTtsSyncServiceImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderTtsSyncServiceImpl$getCurrentAudioSyncReaderModel$1(ReaderTtsSyncServiceImpl readerTtsSyncServiceImpl, Continuation<? super ReaderTtsSyncServiceImpl$getCurrentAudioSyncReaderModel$1> continuation) {
        super(continuation);
        this.this$0 = readerTtsSyncServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
