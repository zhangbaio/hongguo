package com.dragon.read.kmp.service;

import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface p extends eo0.a {
    void A4(String str, BookType bookType);

    Object V8(String str, BookType bookType, Continuation<? super Boolean> continuation);

    void W4(String[] strArr);

    Object ma(String str, BookType bookType, boolean z, Continuation<? super Boolean> continuation);
}
