package com.dragon.read.kmp.reader.font.manager;

import com.bytedance.kmp.file.impl.a;
import com.dragon.read.kmp.reader.services.x;
import com.ss.kmp.ugc.aweme.concurrent.lock.ReentrantReadWriteLock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;

@DebugMetadata(c = "com.dragon.read.kmp.reader.font.manager.FontDownloadManager$unZip$2", f = "FontDownloadManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: D:\code\hongguo\capture\classes6.dex */
final class FontDownloadManager$unZip$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ rn0.c $sourceFile;
    final /* synthetic */ String $sourceFilePath;
    final /* synthetic */ String $targetDir;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontDownloadManager$unZip$2(String str, String str2, rn0.c cVar, Continuation<? super FontDownloadManager$unZip$2> continuation) {
        super(2, continuation);
        this.$sourceFilePath = str;
        this.$targetDir = str2;
        this.$sourceFile = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FontDownloadManager$unZip$2(this.$sourceFilePath, this.$targetDir, this.$sourceFile, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FontDownloadManager$unZip$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ReentrantReadWriteLock reentrantReadWriteLock;
        boolean contains$default;
        boolean z;
        boolean contains$default2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FontDownloadManager.b.d("开始解压: " + this.$sourceFilePath);
            com.dragon.read.kmp.reader.utils.e.a(new rn0.c(this.$targetDir));
            reentrantReadWriteLock = FontDownloadManager.g;
            rn0.c cVar = this.$sourceFile;
            String str = this.$targetDir;
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.c;
            writeLock.lock();
            try {
                FileSystem a = com.bytedance.kmp.file.impl.a.b.a();
                Path.Companion companion = Path.Companion;
                FileSystem openZip = Okio.openZip(a, Path.Companion.get$default(companion, cVar.getPath(), false, 1, (Object) null));
                for (Path path : openZip.listRecursively(Path.Companion.get$default(companion, "/", false, 1, (Object) null))) {
                    String path2 = path.toString();
                    Path path3 = Path.Companion.get$default(Path.Companion, str + rn0.c.c.a() + path2, false, 1, (Object) null);
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) path2, (CharSequence) "../", false, 2, (Object) null);
                    if (contains$default) {
                        com.dragon.read.kmp.i.c(FontDownloadManager.b, "文件名不安全，fileName=" + path.name(), (Throwable) null, 2, (Object) null);
                        z = false;
                    } else {
                        z = true;
                    }
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) path2, (CharSequence) "_MACOSX", false, 2, (Object) null);
                    if (contains$default2) {
                        z = false;
                    }
                    if (z) {
                        if (openZip.metadata(path).isDirectory()) {
                            a.a aVar = com.bytedance.kmp.file.impl.a.b;
                            if (!aVar.a().exists(path3)) {
                                aVar.a().createDirectories(path3);
                            }
                        } else {
                            Path parent = path3.parent();
                            if (parent != null) {
                                a.a aVar2 = com.bytedance.kmp.file.impl.a.b;
                                if (!aVar2.a().exists(parent)) {
                                    aVar2.a().createDirectories(parent);
                                }
                            }
                            rn0.c cVar2 = new rn0.c(path3.toString());
                            if (cVar2.exists()) {
                                continue;
                            } else {
                                try {
                                    Source source = openZip.source(path);
                                    byte[] readByteArray = Okio.buffer(source).readByteArray();
                                    rn0.c cVar3 = new rn0.c(path3 + ".tmp");
                                    rn0.d.d(cVar3, readByteArray);
                                    source.close();
                                    String path4 = cVar2.getPath();
                                    if (x.a.e().k3(cVar2.name(), cVar3.getPath())) {
                                        rn0.d.a(cVar3, path3.toString());
                                        FontDownloadManager.b.d("写入文件成功. " + path4);
                                    } else {
                                        throw new IllegalArgumentException("字体文件格式异常:" + path4);
                                    }
                                } catch (Exception e) {
                                    try {
                                        cVar2.delete();
                                    } catch (Throwable unused) {
                                    }
                                    throw e;
                                }
                            }
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                writeLock.unlock();
                try {
                    rn0.c cVar4 = new rn0.c(this.$sourceFilePath);
                    if (cVar4.exists()) {
                        cVar4.delete();
                        Unit unit2 = Unit.INSTANCE;
                        FontDownloadManager.b.d("删除源文件结果: " + unit2 + ", file = " + this.$sourceFilePath + '.');
                    }
                } catch (Exception e2) {
                    com.dragon.read.kmp.i.c(FontDownloadManager.b, "删除源文件失败: " + e2 + '.', (Throwable) null, 2, (Object) null);
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                writeLock.unlock();
                throw th;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
