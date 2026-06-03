package com.dragon.read.kmp.reader.font.manager;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import lr4.r0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j implements h {
    public static final j a;

    static {
        Covode.recordClassIndex(608450);
        a = new j();
    }

    private j() {
    }

    @Override // com.dragon.read.kmp.reader.font.manager.h
    public Object b(Continuation<? super List<com.dragon.read.kmp.reader.font.h>> continuation) {
        boolean z;
        List<r0> b = qr4.d.a.b();
        if (b != null && !b.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (true ^ z) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = b.iterator();
            while (it2.hasNext()) {
                arrayList.add(new com.dragon.read.kmp.reader.font.h((r0) it2.next()));
            }
            return arrayList;
        }
        throw new IllegalArgumentException("本地无字体列表数据缓存".toString());
    }

    @Override // com.dragon.read.kmp.reader.font.manager.h
    public Object a(List<com.dragon.read.kmp.reader.font.h> list, Continuation<? super Unit> continuation) {
        qr4.d dVar = qr4.d.a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((com.dragon.read.kmp.reader.font.h) it2.next()).n());
        }
        dVar.a(arrayList);
        return Unit.INSTANCE;
    }
}
