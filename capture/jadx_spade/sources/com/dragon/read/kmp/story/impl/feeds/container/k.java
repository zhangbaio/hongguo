package com.dragon.read.kmp.story.impl.feeds.container;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    static {
        Covode.recordClassIndex(609258);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence d(Pair it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        String str = (String) it2.getSecond();
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence e(Pair it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return (CharSequence) it2.getFirst();
    }

    public final void c(yo4.d clientParams, List<Pair<String, String>> list, long j, ym4.a extraArgs) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(clientParams, "clientParams");
        Intrinsics.checkNotNullParameter(extraArgs, "extraArgs");
        if (list != null && !list.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        ym4.a aVar = new ym4.a();
        aVar.j(extraArgs);
        aVar.g("book_id_first", clientParams.b());
        aVar.g("post_id_first", clientParams.c());
        aVar.g("post_type", "story_post");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            CharSequence charSequence = (CharSequence) ((Pair) obj).getSecond();
            if (charSequence != null && charSequence.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                arrayList.add(obj);
            }
        }
        aVar.g("book_id_link_list", CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.container.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                CharSequence d;
                d = k.d((Pair) obj2);
                return d;
            }
        }, 30, null));
        aVar.g("post_id_link_cnt", Integer.valueOf(list.size()));
        aVar.g("post_id_link_list", CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1() { // from class: com.dragon.read.kmp.story.impl.feeds.container.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                CharSequence e;
                e = k.e((Pair) obj2);
                return e;
            }
        }, 30, null));
        aVar.g("stay_time", Long.valueOf(j));
        l.b(aVar, clientParams.m);
        zp4.a.b(zp4.a.a, "stay_post_page_link", aVar, false, null, 12, null);
    }
}
