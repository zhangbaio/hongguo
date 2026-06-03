package com.dragon.read.kmp.reader.ui.menu.moresettings.model;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class v extends sm4.d {
    public final String f;
    public final List<sm4.h> g;
    public int h;
    public int i;
    private String j;
    public com.dragon.read.kmp.reader.ui.menu.ui.c k;

    static {
        Covode.recordClassIndex(608634);
    }

    @Override // sm4.d
    public String d() {
        return this.j;
    }

    public final void h(cm4.i reader) {
        ArrayList arrayListOf;
        cm4.l lVar;
        cm4.f fVar;
        qm4.b g;
        Intrinsics.checkNotNullParameter(reader, "reader");
        w.a(this, reader);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("one_hand", "highlight", "bottom_info", "intelligent_theme", "bookmark", "status_bar", "auto_listen_read", "left_swipe_exit", "content_picture", "turn_page", "read_progress", "lock_time", "read_status");
        if (reader instanceof cm4.l) {
            lVar = (cm4.l) reader;
        } else {
            lVar = null;
        }
        if (lVar != null && (fVar = lVar.h) != null && (g = fVar.g()) != null) {
            g.a(reader, this.g, arrayListOf);
        }
        List<sm4.h> list = this.g;
        if (list.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(list, new a(arrayListOf));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(String bookId, sm4.b listener) {
        super(listener);
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f = bookId;
        this.g = new ArrayList();
        this.j = "more_setting";
    }

    public static final class a<T> implements Comparator {
        final /* synthetic */ ArrayList a;

        public a(ArrayList arrayList) {
            this.a = arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compareValues;
            int indexOf = this.a.indexOf(((sm4.h) t).getType());
            int i = Integer.MAX_VALUE;
            if (indexOf < 0) {
                indexOf = Integer.MAX_VALUE;
            }
            Integer valueOf = Integer.valueOf(indexOf);
            int indexOf2 = this.a.indexOf(((sm4.h) t2).getType());
            if (indexOf2 >= 0) {
                i = indexOf2;
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
            return compareValues;
        }
    }
}
