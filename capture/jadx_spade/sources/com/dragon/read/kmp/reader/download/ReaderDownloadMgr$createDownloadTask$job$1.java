package com.dragon.read.kmp.reader.download;

import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.reader.download.ReaderDownloadMgr;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr$createDownloadTask$job$1", f = "ReaderDownloadMgr.kt", i = {4, 4, 4, 4, 5, 5, 5, ConstantsAPI.COMMAND_LAUNCH_BY_WX, ConstantsAPI.COMMAND_LAUNCH_BY_WX, ConstantsAPI.COMMAND_LAUNCH_BY_WX, 7, 7, 7, ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW, ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW, ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW, 9, 9}, l = {316, 318, 322, 326, 354, 358, 364, 366, 377, 383}, m = "invokeSuspend", n = {"data", "chapterIdList", "originSize", "filterSize", "chapterIdList", "originSize", "filterSize", "chapterIdList", "originSize", "filterSize", "chapterIdList", "originSize", "filterSize", "chapterIdList", "unfinishedChapterIdSet", "filterSize", "unfinishedChapterIdSet", "filterSize"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "L$1", "I$0", "L$0", "I$0"})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class ReaderDownloadMgr$createDownloadTask$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ReaderDownloadMgr.a>, Object> {
    final /* synthetic */ boolean $autoAddShelf;
    final /* synthetic */ String $bookId;
    final /* synthetic */ n $listener;
    final /* synthetic */ boolean $showVipFailedToast;
    final /* synthetic */ String $targetUserId;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReaderDownloadMgr$createDownloadTask$job$1(String str, n nVar, boolean z, String str2, boolean z2, Continuation<? super ReaderDownloadMgr$createDownloadTask$job$1> continuation) {
        super(2, continuation);
        this.$bookId = str;
        this.$listener = nVar;
        this.$autoAddShelf = z;
        this.$targetUserId = str2;
        this.$showVipFailedToast = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReaderDownloadMgr$createDownloadTask$job$1(this.$bookId, this.$listener, this.$autoAddShelf, this.$targetUserId, this.$showVipFailedToast, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ReaderDownloadMgr.a> continuation) {
        return ((ReaderDownloadMgr$createDownloadTask$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.reader.download.ReaderDownloadMgr$createDownloadTask$job$1$1", f = "ReaderDownloadMgr.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.reader.download.ReaderDownloadMgr$createDownloadTask$job$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ig4.g.b("应版权方要求，本书仅会员才可下载全文", (ToastDuration) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x026c A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:8:0x001b, B:9:0x0268, B:11:0x026c, B:13:0x0274, B:14:0x02ef, B:17:0x02b8, B:18:0x02e6, B:20:0x002a, B:22:0x024b, B:27:0x003a, B:29:0x01ff, B:30:0x0201, B:33:0x020b, B:35:0x020f, B:36:0x0219, B:41:0x004a, B:43:0x01e7, B:45:0x005a, B:47:0x01cb, B:49:0x01d3, B:52:0x01ea, B:57:0x006e, B:59:0x01b0, B:66:0x0193, B:67:0x0078, B:68:0x0141, B:70:0x0176, B:75:0x0080, B:76:0x0103, B:79:0x0085, B:80:0x00f1, B:83:0x0089, B:85:0x00d3, B:87:0x00de, B:91:0x0095, B:93:0x00a0, B:94:0x00a3), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x02e6 A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:8:0x001b, B:9:0x0268, B:11:0x026c, B:13:0x0274, B:14:0x02ef, B:17:0x02b8, B:18:0x02e6, B:20:0x002a, B:22:0x024b, B:27:0x003a, B:29:0x01ff, B:30:0x0201, B:33:0x020b, B:35:0x020f, B:36:0x0219, B:41:0x004a, B:43:0x01e7, B:45:0x005a, B:47:0x01cb, B:49:0x01d3, B:52:0x01ea, B:57:0x006e, B:59:0x01b0, B:66:0x0193, B:67:0x0078, B:68:0x0141, B:70:0x0176, B:75:0x0080, B:76:0x0103, B:79:0x0085, B:80:0x00f1, B:83:0x0089, B:85:0x00d3, B:87:0x00de, B:91:0x0095, B:93:0x00a0, B:94:0x00a3), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0266 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0209 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0249 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d3 A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:8:0x001b, B:9:0x0268, B:11:0x026c, B:13:0x0274, B:14:0x02ef, B:17:0x02b8, B:18:0x02e6, B:20:0x002a, B:22:0x024b, B:27:0x003a, B:29:0x01ff, B:30:0x0201, B:33:0x020b, B:35:0x020f, B:36:0x0219, B:41:0x004a, B:43:0x01e7, B:45:0x005a, B:47:0x01cb, B:49:0x01d3, B:52:0x01ea, B:57:0x006e, B:59:0x01b0, B:66:0x0193, B:67:0x0078, B:68:0x0141, B:70:0x0176, B:75:0x0080, B:76:0x0103, B:79:0x0085, B:80:0x00f1, B:83:0x0089, B:85:0x00d3, B:87:0x00de, B:91:0x0095, B:93:0x00a0, B:94:0x00a3), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ea A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:8:0x001b, B:9:0x0268, B:11:0x026c, B:13:0x0274, B:14:0x02ef, B:17:0x02b8, B:18:0x02e6, B:20:0x002a, B:22:0x024b, B:27:0x003a, B:29:0x01ff, B:30:0x0201, B:33:0x020b, B:35:0x020f, B:36:0x0219, B:41:0x004a, B:43:0x01e7, B:45:0x005a, B:47:0x01cb, B:49:0x01d3, B:52:0x01ea, B:57:0x006e, B:59:0x01b0, B:66:0x0193, B:67:0x0078, B:68:0x0141, B:70:0x0176, B:75:0x0080, B:76:0x0103, B:79:0x0085, B:80:0x00f1, B:83:0x0089, B:85:0x00d3, B:87:0x00de, B:91:0x0095, B:93:0x00a0, B:94:0x00a3), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0191 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0140 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0102 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00de A[Catch: all -> 0x008f, TryCatch #2 {all -> 0x008f, blocks: (B:8:0x001b, B:9:0x0268, B:11:0x026c, B:13:0x0274, B:14:0x02ef, B:17:0x02b8, B:18:0x02e6, B:20:0x002a, B:22:0x024b, B:27:0x003a, B:29:0x01ff, B:30:0x0201, B:33:0x020b, B:35:0x020f, B:36:0x0219, B:41:0x004a, B:43:0x01e7, B:45:0x005a, B:47:0x01cb, B:49:0x01d3, B:52:0x01ea, B:57:0x006e, B:59:0x01b0, B:66:0x0193, B:67:0x0078, B:68:0x0141, B:70:0x0176, B:75:0x0080, B:76:0x0103, B:79:0x0085, B:80:0x00f1, B:83:0x0089, B:85:0x00d3, B:87:0x00de, B:91:0x0095, B:93:0x00a0, B:94:0x00a3), top: B:2:0x000a }] */
    /* JADX WARN: Type inference failed for: r15v11, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr$createDownloadTask$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
