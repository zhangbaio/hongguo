package com.dragon.read.kmp.story.impl.feeds.progress;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import com.dragon.read.kmp.progress.BookProgressManagerAdapter;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import mn0.g;
import mn0.j;
import np4.c;
import np4.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryProgressManager {
    public static final StoryProgressManager a;
    private static final tp4.b b;

    private StoryProgressManager() {
    }

    static {
        Covode.recordClassIndex(609340);
        a = new StoryProgressManager();
        b = new tp4.b("StoryProgressManager");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kp4.b r6, kotlin.coroutines.Continuation<? super com.dragon.read.kmp.story.impl.feeds.progress.a> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressManager$getStoryProgress$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressManager$getStoryProgress$1 r0 = (com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressManager$getStoryProgress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressManager$getStoryProgress$1 r0 = new com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressManager$getStoryProgress$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4b
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            com.dragon.read.kmp.story.impl.feeds.data.e r6 = r6.d()
            java.lang.String r6 = r6.getBookId()
            if (r6 != 0) goto L40
            return r3
        L40:
            com.dragon.read.kmp.progress.BookProgressManagerAdapter r7 = com.dragon.read.kmp.progress.BookProgressManagerAdapter.a
            r0.label = r4
            java.lang.Object r7 = r7.b(r6, r0)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            lr4.c1 r7 = (lr4.c1) r7
            if (r7 != 0) goto L50
            return r3
        L50:
            com.dragon.read.kmp.story.impl.feeds.progress.a r6 = com.dragon.read.kmp.story.impl.feeds.progress.b.c(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.progress.StoryProgressManager.a(kp4.b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object b(kp4.b bVar, c cVar, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        String bookId = bVar.d().getBookId();
        if (bookId == null) {
            return Unit.INSTANCE;
        }
        String chapterId = cVar.getChapterId();
        BookType bookType = BookType.READ;
        int c = bVar.b.c(chapterId);
        String d = bVar.b.d(chapterId);
        if (d == null) {
            d = "";
        }
        Object c2 = BookProgressManagerAdapter.a.c(b.b(new a(bookId, bookType, chapterId, c, d, 0, 0.01f, -1, 0, -1, -1, -1, 256, null)), "story_reset_book_progress", continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (c2 == coroutine_suspended) {
            return c2;
        }
        return Unit.INSTANCE;
    }

    public final Object c(kp4.b bVar, e eVar, float f, Continuation<? super Unit> continuation) {
        float f2;
        Object coroutine_suspended;
        g gVar = new g(eVar.b(), 0.0f, -f);
        tp4.b bVar2 = b;
        bVar2.a("updateStoryProgress, pagePos = " + gVar);
        j q = eVar.e.q(gVar);
        if (q == null) {
            return Unit.INSTANCE;
        }
        bVar2.a("updateStoryProgress, elementPos = " + q);
        String bookId = bVar.d().getBookId();
        if (bookId == null) {
            return Unit.INSTANCE;
        }
        String chapterId = eVar.getChapterId();
        BookType bookType = BookType.READ;
        int c = bVar.b.c(chapterId);
        String d = bVar.b.d(chapterId);
        if (d == null) {
            d = "";
        }
        String str = d;
        int b2 = eVar.b();
        Float a2 = b.a(bVar, eVar, f);
        if (a2 != null) {
            f2 = a2.floatValue();
        } else {
            f2 = -1.0f;
        }
        int i = q.a;
        a aVar = new a(bookId, bookType, chapterId, c, str, b2, f2, i, 0, i, q.b, q.c, 256, null);
        bVar2.a("updateStoryProgress, progress = " + aVar);
        Object c2 = BookProgressManagerAdapter.a.c(b.b(aVar), "story_update_book_progress", continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (c2 == coroutine_suspended) {
            return c2;
        }
        return Unit.INSTANCE;
    }
}
