package com.dragon.read.kmp.reader.font.manager;

import com.dragon.read.kmp.reader.font.manager.d;
import com.dragon.read.kmp.reader.font.x0;
import com.ss.kmp.ugc.aweme.concurrent.lock.ReentrantReadWriteLock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$DoubleRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDownloadManager$deleteFont$1", f = "FontDownloadManager.kt", i = {}, l = {355}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDownloadManager$deleteFont$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ x0 $deleteListener;
    final /* synthetic */ String $fileName;
    final /* synthetic */ String $fontFamily;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontDownloadManager$deleteFont$1(String str, x0 x0Var, String str2, Continuation<? super FontDownloadManager$deleteFont$1> continuation) {
        super(2, continuation);
        this.$fileName = str;
        this.$deleteListener = x0Var;
        this.$fontFamily = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontDownloadManager$deleteFont$1(this.$fileName, this.$deleteListener, this.$fontFamily, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FontDownloadManager$deleteFont$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDownloadManager$deleteFont$1$1", f = "FontDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.dragon.read.kmp.reader.font.manager.FontDownloadManager$deleteFont$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileName;
        final /* synthetic */ String $fontFamily;
        final /* synthetic */ rn0.c $fontFile;
        final /* synthetic */ String $fontFilePath;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, rn0.c cVar, String str3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$fontFilePath = str;
            this.$fileName = str2;
            this.$fontFile = cVar;
            this.$fontFamily = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$fontFilePath, this.$fileName, this.$fontFile, this.$fontFamily, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDownloadManager$deleteFont$1$1$2", f = "FontDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.dragon.read.kmp.reader.font.manager.FontDownloadManager$deleteFont$1$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $errorMsg;
            final /* synthetic */ String $fileName;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(String str, String str2, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$fileName = str;
                this.$errorMsg = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$fileName, this.$errorMsg, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    d.c.a().onFailed(this.$fileName, this.$errorMsg);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            di6.e eVar;
            ReentrantReadWriteLock reentrantReadWriteLock;
            rn0.c cVar;
            String str;
            String str2;
            String str3;
            ReentrantReadWriteLock.WriteLock writeLock;
            di6.e eVar2;
            FontDownloadManager fontDownloadManager;
            di6.e eVar3;
            di6.e eVar4;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref$DoubleRef ref$DoubleRef = new Ref$DoubleRef();
                try {
                    reentrantReadWriteLock = FontDownloadManager.g;
                    cVar = this.$fontFile;
                    str = this.$fileName;
                    str2 = this.$fontFilePath;
                    str3 = this.$fontFamily;
                    writeLock = reentrantReadWriteLock.c;
                    writeLock.lock();
                    try {
                        long size = cVar.size();
                        ref$DoubleRef.element = size / 1048576.0d;
                        eVar2 = FontDownloadManager.f;
                        Intrinsics.checkNotNull(str);
                        eVar2.put(str, Boxing.boxLong(size));
                        fontDownloadManager = FontDownloadManager.a;
                    } finally {
                        writeLock.unlock();
                    }
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("删除过程异常：");
                    String message = e.getMessage();
                    if (message == null) {
                        message = "未知错误";
                    }
                    sb.append(message);
                    String sb2 = sb.toString();
                    com.dragon.read.kmp.i.c(FontDownloadManager.b, "字体删除失败：" + this.$fontFilePath + "，原因:" + sb2, (Throwable) null, 2, (Object) null);
                    kotlinx.coroutines.i.e(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass2(this.$fileName, sb2, null), 2, null);
                    eVar = FontDownloadManager.f;
                    TypeIntrinsics.asMutableMap(eVar).remove(this.$fileName);
                }
                if (!fontDownloadManager.l(cVar)) {
                    com.dragon.read.kmp.i.c(FontDownloadManager.b, "字体删除失败：" + str, (Throwable) null, 2, (Object) null);
                    kotlinx.coroutines.i.e(coroutineScope, Dispatchers.getMain(), null, new FontDownloadManager$deleteFont$1$1$1$1(str, null), 2, null);
                    eVar4 = FontDownloadManager.f;
                    eVar4.remove(str);
                    return Unit.INSTANCE;
                }
                FontDownloadManager.b.d("字体文件删除成功：" + str + "，释放空间：" + ref$DoubleRef.element + " MB");
                kotlinx.coroutines.i.e(coroutineScope, Dispatchers.getMain(), null, new FontDownloadManager$deleteFont$1$1$1$2(str, ref$DoubleRef, null), 2, null);
                eVar3 = FontDownloadManager.f;
                eVar3.remove(str);
                rn0.c cVar2 = new rn0.c(str2 + ".tmp");
                if (cVar2.exists()) {
                    FontDownloadManager.b.d("删除字体临时文件：" + cVar2.getPath());
                    fontDownloadManager.l(cVar2);
                }
                rn0.c cVar3 = new rn0.c(fontDownloadManager.p(str3) + ".zip");
                if (cVar3.exists()) {
                    FontDownloadManager.b.d("删除字体zip文件：" + cVar3.getPath());
                    fontDownloadManager.l(cVar3);
                }
                Unit unit = Unit.INSTANCE;
                writeLock.unlock();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FontDownloadManager fontDownloadManager = FontDownloadManager.a;
            if (!fontDownloadManager.q(this.$fileName)) {
                d.c.a().onFailed(this.$fileName, "不存在目标文件" + this.$fileName + "，无法删除");
                return Unit.INSTANCE;
            }
            String p = fontDownloadManager.p(this.$fileName);
            rn0.c cVar = new rn0.c(p);
            d.a aVar = d.c;
            aVar.a().d(this.$fileName, this.$deleteListener);
            if (fontDownloadManager.r(this.$fileName)) {
                com.dragon.read.kmp.i.c(FontDownloadManager.b, "删除任务进行中，fileName=" + this.$fileName, (Throwable) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
            aVar.a().onStart(this.$fileName);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(p, this.$fileName, cVar, this.$fontFamily, null);
            this.label = 1;
            if (BuildersKt.withContext(io2, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
