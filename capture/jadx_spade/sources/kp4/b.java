package kp4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.GenreTypeEnum;
import com.dragon.read.kmp.story.impl.feeds.data.e;
import com.dragon.read.kmp.utils.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends gp4.a {
    public static final int i;
    public com.dragon.read.kmp.story.impl.feeds.data.b b;
    public final d c;
    private final Lazy d;
    public final com.dragon.read.kmp.story.impl.feeds.data.d e;
    public final c f;
    private long g;
    public yo4.c h;

    static {
        Covode.recordClassIndex(609302);
        i = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b p() {
        return new tp4.b("KmpStory");
    }

    public final e d() {
        return this.b.a;
    }

    public List<yo4.c> h() {
        return this.b.c;
    }

    public final String j() {
        return this.b.a.d;
    }

    public final boolean m() {
        return this.e.e();
    }

    public final void r() {
        this.f.a.a();
    }

    public final String e() {
        yo4.c cVar = this.h;
        if (cVar != null) {
            return cVar.getChapterId();
        }
        return null;
    }

    public boolean k() {
        return this.b.a.g();
    }

    public final boolean l() {
        return d().c.b;
    }

    public boolean o() {
        return this.b.a.i();
    }

    public final List<np4.e> i() {
        List<op4.c> list = this.b.d;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((op4.c) it2.next()).c);
        }
        return arrayList;
    }

    public final boolean n() {
        Integer genreType = d().getGenreType();
        int value = GenreTypeEnum.STORY_GENRE_TYPE.getValue();
        if (genreType != null && genreType.intValue() == value) {
            return true;
        }
        return false;
    }

    public final np4.e f() {
        bp4.a aVar;
        List<bp4.a> list = this.b.c;
        ListIterator<bp4.a> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                aVar = listIterator.previous();
                if (aVar instanceof np4.e) {
                    break;
                }
            } else {
                aVar = null;
                break;
            }
        }
        if (!(aVar instanceof np4.e)) {
            return null;
        }
        return (np4.e) aVar;
    }

    public final String g() {
        return "story: (storyId = " + a() + ", title = " + j() + ", pageCount = " + this.b.c.size() + " )";
    }

    public final void q() {
        if (!this.e.e() || this.g != 0) {
            return;
        }
        this.g = p.a();
        ym4.a aVar = new ym4.a();
        aVar.g("status", "read");
        this.f.a.i(aVar);
    }

    public final void s() {
        if (this.g == 0) {
            return;
        }
        long a = p.a() - this.g;
        int i2 = (int) (this.c.d * 100);
        String e = e();
        if (e == null) {
            e = "";
        }
        int a2 = this.c.a(e);
        int c = this.b.c(e);
        int b = this.b.b();
        ym4.a aVar = new ym4.a();
        aVar.g("status", "read");
        aVar.g("group_index", Integer.valueOf(c));
        aVar.g("total_group_num", Integer.valueOf(b));
        aVar.g("percent", Integer.valueOf(i2));
        this.f.a.m(a, i2, a2, false, aVar);
        this.g = 0L;
    }

    public final void t(com.dragon.read.kmp.story.impl.feeds.data.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.b = bVar;
    }

    public final void u(float f) {
        this.c.b(f);
    }

    public final op4.c c(String chapterId) {
        Intrinsics.checkNotNullParameter(chapterId, "chapterId");
        return this.b.a(chapterId);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String storyId, com.dragon.read.kmp.story.impl.feeds.data.b content, d extra, yo4.d clientParam) {
        super(storyId);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(clientParam, "clientParam");
        this.b = content;
        this.c = extra;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: kp4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tp4.b p;
                p = b.p();
                return p;
            }
        });
        this.d = lazy;
        com.dragon.read.kmp.story.impl.feeds.data.d dVar = new com.dragon.read.kmp.story.impl.feeds.data.d();
        com.dragon.read.kmp.story.impl.feeds.data.d dVar2 = this.b.b;
        dVar.b = dVar2.b;
        dVar.h(dVar2.c());
        com.dragon.read.kmp.story.impl.feeds.data.b bVar = this.b;
        dVar.c = bVar.b.c;
        dVar.f.setValue(Boolean.valueOf(bVar.a.k));
        this.e = dVar;
        this.f = new c(this, clientParam);
    }
}
