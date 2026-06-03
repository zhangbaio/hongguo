package com.dragon.read.kmp.reader.services;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface l {
    void c();

    void d(String str);

    void e(String str, List<String> list);

    void f(boolean z);

    Object g(String str, Continuation<? super Unit> continuation);

    Object h(List<String> list, Continuation<? super Unit> continuation);

    Object i(String str, Continuation<? super Long> continuation);

    void j(List<String> list, String str);

    void k(String str, String str2, boolean z, boolean z2, com.dragon.read.kmp.reader.download.n nVar);
}
