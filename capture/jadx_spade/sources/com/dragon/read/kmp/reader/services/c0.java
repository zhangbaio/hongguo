package com.dragon.read.kmp.reader.services;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.download.ReaderDownloadMgr;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c0 implements l {
    public static final c0 a;

    static {
        Covode.recordClassIndex(608559);
        a = new c0();
    }

    private c0() {
    }

    @Override // com.dragon.read.kmp.reader.services.l
    public void c() {
        ReaderDownloadMgr.a.A();
    }

    @Override // com.dragon.read.kmp.reader.services.l
    public void f(boolean z) {
        ReaderDownloadMgr.a.y(z);
    }

    @Override // com.dragon.read.kmp.reader.services.l
    public void d(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        ReaderDownloadMgr.a.Z(bookId);
    }

    @Override // com.dragon.read.kmp.reader.services.l
    public Object g(String str, Continuation<? super Unit> continuation) {
        tm4.a.a.b(str);
        return Unit.INSTANCE;
    }

    @Override // com.dragon.read.kmp.reader.services.l
    public Object i(String str, Continuation<? super Long> continuation) {
        return ReaderDownloadMgr.a.s(str, continuation);
    }

    @Override // com.dragon.read.kmp.reader.services.l
    public Object h(List<String> list, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object e0 = ReaderDownloadMgr.a.e0(list, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (e0 == coroutine_suspended) {
            return e0;
        }
        return Unit.INSTANCE;
    }

    @Override // com.dragon.read.kmp.reader.services.l
    public void j(List<String> bookId, String cause) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(cause, "cause");
        ReaderDownloadMgr.a.C(bookId, cause);
    }

    @Override // com.dragon.read.kmp.reader.services.l
    public void e(String targetUserId, List<String> bookIds) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        ReaderDownloadMgr.a.G(targetUserId, bookIds);
    }

    @Override // com.dragon.read.kmp.reader.services.l
    public void k(String userId, String bookId, boolean z, boolean z2, com.dragon.read.kmp.reader.download.n nVar) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        ReaderDownloadMgr.a.b0(userId, bookId, z, z2, nVar);
    }
}
