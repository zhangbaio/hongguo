package com.dragon.read.kmp.service;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpBookshelfService {
    public static final KmpBookshelfService a;

    static {
        Covode.recordClassIndex(608877);
        a = new KmpBookshelfService();
    }

    private KmpBookshelfService() {
    }

    public final void d(String[] bookIds) {
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        p pVar = (p) eo0.c.a.a(Reflection.getOrCreateKotlinClass(p.class));
        if (pVar != null) {
            pVar.W4(bookIds);
        }
    }

    public final void a(String str, BookType bookType) {
        Intrinsics.checkNotNullParameter(bookType, "bookType");
        p pVar = (p) eo0.c.a.a(Reflection.getOrCreateKotlinClass(p.class));
        if (pVar != null) {
            pVar.A4(str, bookType);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r5, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.service.KmpBookshelfService$isInBookshelf$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.service.KmpBookshelfService$isInBookshelf$1 r0 = (com.dragon.read.kmp.service.KmpBookshelfService$isInBookshelf$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.service.KmpBookshelfService$isInBookshelf$1 r0 = new com.dragon.read.kmp.service.KmpBookshelfService$isInBookshelf$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            eo0.c r7 = eo0.c.a
            java.lang.Class<com.dragon.read.kmp.service.p> r2 = com.dragon.read.kmp.service.p.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            eo0.a r7 = r7.a(r2)
            com.dragon.read.kmp.service.p r7 = (com.dragon.read.kmp.service.p) r7
            if (r7 == 0) goto L54
            r0.label = r3
            java.lang.Object r7 = r7.V8(r5, r6, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r5 = r7.booleanValue()
            goto L55
        L54:
            r5 = 0
        L55:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.service.KmpBookshelfService.c(java.lang.String, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r5, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType r6, boolean r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.dragon.read.kmp.service.KmpBookshelfService$addToBookshelf$1
            if (r0 == 0) goto L13
            r0 = r8
            com.dragon.read.kmp.service.KmpBookshelfService$addToBookshelf$1 r0 = (com.dragon.read.kmp.service.KmpBookshelfService$addToBookshelf$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.service.KmpBookshelfService$addToBookshelf$1 r0 = new com.dragon.read.kmp.service.KmpBookshelfService$addToBookshelf$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            eo0.c r8 = eo0.c.a
            java.lang.Class<com.dragon.read.kmp.service.p> r2 = com.dragon.read.kmp.service.p.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            eo0.a r8 = r8.a(r2)
            com.dragon.read.kmp.service.p r8 = (com.dragon.read.kmp.service.p) r8
            if (r8 == 0) goto L54
            r0.label = r3
            java.lang.Object r8 = r8.ma(r5, r6, r7, r0)
            if (r8 != r1) goto L4d
            return r1
        L4d:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r5 = r8.booleanValue()
            goto L55
        L54:
            r5 = 0
        L55:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.service.KmpBookshelfService.b(java.lang.String, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
