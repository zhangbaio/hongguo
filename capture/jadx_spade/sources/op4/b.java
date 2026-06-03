package op4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.GenreTypeEnum;
import com.bytedance.kmp.ugc.model.us;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.story.impl.feeds.config.KmpCssManager;
import com.dragon.read.kmp.story.impl.feeds.enums.PageShadeStyle;
import com.dragon.read.kmp.story.impl.feeds.uicontext.KmpStoryReadingSettingManager;
import com.dragon.read.kmp.utils.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt__GroupingJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    private final float a;
    private final int b;
    private final int c;
    private final tp4.b d = new tp4.b("KmpStoryFactory");
    private final int e;

    static {
        Covode.recordClassIndex(609332);
    }

    public static final class a implements Grouping<bp4.a, String> {
        final /* synthetic */ Iterable a;

        @Override // kotlin.collections.Grouping
        public Iterator<bp4.a> sourceIterator() {
            return this.a.iterator();
        }

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // kotlin.collections.Grouping
        public String keyOf(bp4.a aVar) {
            return Reflection.getOrCreateKotlinClass(aVar.getClass()).getSimpleName();
        }
    }

    private final nn0.d d() {
        float f = this.b;
        float f2 = this.c;
        KmpStoryReadingSettingManager kmpStoryReadingSettingManager = KmpStoryReadingSettingManager.a;
        return nn0.c.i.a().l(f).j(com.dragon.read.kmp.story.impl.feeds.config.b.a.a((int) f2)).s(f2).b(true).u(kmpStoryReadingSettingManager.e()).q(kmpStoryReadingSettingManager.h().b).i(0.0f).n(0.0f).r(KmpCssManager.a.H2()).e(this.a).p(new op4.a()).g(true);
    }

    public final com.dragon.read.kmp.story.impl.feeds.data.b a(com.dragon.read.kmp.story.impl.feeds.data.e storyData, boolean z) {
        Intrinsics.checkNotNullParameter(storyData, "storyData");
        if (!storyData.f.isEmpty()) {
            nn0.d d = d();
            if (z) {
                d.m(2);
            }
            nn0.c c = d.c();
            long a2 = wf4.e.a.a();
            List<com.dragon.read.kmp.story.impl.feeds.data.a> list = storyData.f;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(f(this, storyData.a, (com.dragon.read.kmp.story.impl.feeds.data.a) it2.next(), c, null, 8, null));
            }
            long a3 = wf4.e.a.a() - a2;
            this.d.d("buildRichTextChapter, cost " + a3 + "ms for storyId=" + storyData.a + ", wordNum=" + storyData.f());
            g gVar = new g();
            com.dragon.read.kmp.story.impl.feeds.data.f fVar = storyData.c;
            gVar.e = fVar.b;
            gVar.b = fVar.c;
            com.dragon.read.kmp.story.impl.feeds.data.b g = g(storyData, arrayList, gVar);
            g.d.addAll(arrayList);
            return g;
        }
        throw new Error("chapterInfoList is empty");
    }

    public b(float f, int i, int i2) {
        this.a = f;
        this.b = i;
        this.c = i2;
        this.e = (int) (i2 * 0.61f);
    }

    private final void c(com.dragon.read.kmp.story.impl.feeds.data.e eVar, c cVar, g gVar) {
        Object lastOrNull;
        LoadStatus loadStatus;
        PageShadeStyle pageShadeStyle;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) cVar.c);
        np4.e eVar2 = (np4.e) lastOrNull;
        if (eVar2 != null) {
            if (gVar.b) {
                if (eVar.g() && !gVar.a) {
                    loadStatus = LoadStatus.Content;
                } else {
                    loadStatus = LoadStatus.Loading;
                }
            } else if (eVar.c.a) {
                loadStatus = LoadStatus.Error;
            } else if (!eVar.g()) {
                loadStatus = LoadStatus.Loading;
            } else {
                loadStatus = LoadStatus.Content;
            }
            eVar2.j(loadStatus);
            if (eVar2.d() == LoadStatus.Content) {
                pageShadeStyle = PageShadeStyle.None;
            } else {
                pageShadeStyle = PageShadeStyle.Load;
            }
            eVar2.l(pageShadeStyle);
        }
    }

    private final com.dragon.read.kmp.story.impl.feeds.data.b g(com.dragon.read.kmp.story.impl.feeds.data.e eVar, List<c> list, g gVar) {
        Object firstOrNull;
        String str;
        Object lastOrNull;
        String str2;
        Object lastOrNull2;
        String str3;
        boolean z;
        Map eachCount;
        boolean z2;
        boolean z3;
        int coerceAtLeast;
        boolean z4;
        int i;
        int i2;
        int coerceAtLeast2;
        String str4 = eVar.a;
        com.dragon.read.kmp.story.impl.feeds.data.b bVar = new com.dragon.read.kmp.story.impl.feeds.data.b(eVar);
        ArrayList arrayList = new ArrayList();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        c cVar = (c) firstOrNull;
        String str5 = "";
        if (cVar == null || (str = cVar.a()) == null) {
            str = "";
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
        c cVar2 = (c) lastOrNull;
        if (cVar2 == null || (str2 = cVar2.a()) == null) {
            str2 = "";
        }
        lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list);
        c cVar3 = (c) lastOrNull2;
        if (cVar3 != null) {
            c(eVar, cVar3, gVar);
        }
        int i3 = this.e;
        if (!eVar.c.b) {
            arrayList.add(new np4.b(str4, str));
        }
        np4.c cVar4 = new np4.c(eVar.a, str);
        String str6 = eVar.d;
        if (str6 == null) {
            str6 = "";
        }
        cVar4.b(str6);
        List<us> list2 = cVar4.e;
        List<us> list3 = eVar.e;
        if (list3 == null) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        }
        list2.addAll(list3);
        this.d.a("pagingStory, storyId = " + str4 + ", ContentTitlePage height = " + cVar4.i());
        int i4 = i3 - cVar4.i();
        arrayList.add(cVar4);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(((c) it2.next()).c);
        }
        if (!gVar.g) {
            str3 = "";
            z = false;
        } else {
            Boolean bool = gVar.d;
            if (bool != null) {
                z3 = Intrinsics.areEqual(bool, Boolean.TRUE);
            } else if (gVar.h) {
                z3 = true;
            } else if (gVar.f) {
                z3 = false;
            } else {
                z3 = gVar.e;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i4, 70);
            int size = arrayList.size();
            int i5 = 1;
            int i6 = 70;
            while (true) {
                if (i5 < size) {
                    bp4.a aVar = (bp4.a) arrayList.get(i5);
                    str3 = str5;
                    if (!(aVar instanceof np4.e)) {
                        i2 = size;
                        this.d.a("pagingStory, storyId = " + str4 + ", " + Reflection.getOrCreateKotlinClass(aVar.getClass()).getSimpleName() + " height = " + aVar.i());
                    } else {
                        i2 = size;
                        tp4.b bVar2 = this.d;
                        StringBuilder sb = new StringBuilder();
                        sb.append("pagingStory, storyId = ");
                        sb.append(str4);
                        sb.append(", ");
                        sb.append(Reflection.getOrCreateKotlinClass(aVar.getClass()).getSimpleName());
                        sb.append(" height = ");
                        np4.e eVar2 = (np4.e) aVar;
                        sb.append(eVar2.i());
                        bVar2.a(sb.toString());
                        int i7 = eVar2.i() + i6;
                        if (i7 > coerceAtLeast) {
                            if (z3) {
                                bVar.b.h(true);
                                z = false;
                                eVar2.m(false);
                                eVar2.l(PageShadeStyle.None);
                                i = -1;
                            } else {
                                z = false;
                                i = i5 + 1;
                                bVar.b.h(false);
                                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(coerceAtLeast - i6, 70);
                                eVar2.k(coerceAtLeast2);
                                eVar2.m(true);
                                eVar2.l(PageShadeStyle.Fold);
                                this.d.a("pagingStory, storyId = " + str4 + ", truncate: page.maxHeight=" + eVar2.e());
                            }
                            z4 = false;
                        } else {
                            i6 = i7;
                        }
                    }
                    i5++;
                    str5 = str3;
                    size = i2;
                } else {
                    str3 = str5;
                    z = false;
                    z4 = true;
                    i = -1;
                    break;
                }
            }
            if (!z4) {
                bVar.b.c = true;
            }
            if (i != -1 && i < arrayList.size()) {
                arrayList.subList(i, arrayList.size()).clear();
            }
        }
        if (!bVar.b.d()) {
            boolean g = eVar.g();
            if (g) {
                np4.a aVar2 = new np4.a(str4, str2);
                aVar2.d = eVar.i;
                arrayList.add(aVar2);
            }
            Integer genreType = eVar.getGenreType();
            int value = GenreTypeEnum.NOVEL.getValue();
            if (genreType != null && genreType.intValue() == value) {
                z2 = true;
            } else {
                z2 = false;
            }
            String bookId = eVar.getBookId();
            if (bookId == null) {
                bookId = str3;
            }
            if (g && z2) {
                if (bookId.length() > 0) {
                    z = true;
                }
                if (z) {
                    np4.d dVar = new np4.d(str4, str2, bookId);
                    dVar.e = eVar.d;
                    dVar.f = eVar.m;
                    dVar.g = eVar.l;
                    dVar.h = eVar.e();
                    dVar.i = eVar.getCreationStatus();
                    dVar.j = eVar.c();
                    arrayList.add(dVar);
                }
            }
        }
        eachCount = GroupingKt__GroupingJVMKt.eachCount(new a(arrayList));
        this.d.a("pagingStory page counts: " + eachCount);
        bVar.c.clear();
        bVar.c.addAll(arrayList);
        return bVar;
    }

    public final c e(String storyId, com.dragon.read.kmp.story.impl.feeds.data.a chapterInfo, nn0.c layoutConfig, nn0.b bVar) {
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(chapterInfo, "chapterInfo");
        Intrinsics.checkNotNullParameter(layoutConfig, "layoutConfig");
        long a2 = p.a();
        if (bVar != null) {
            new nn0.e(layoutConfig).b(bVar, 0);
        } else {
            bVar = new nn0.e(layoutConfig).a(chapterInfo.d, (List) null);
        }
        long a3 = p.a() - a2;
        this.d.a("buildRichTextChapter, storyId:" + storyId + ", chapterIndex:" + chapterInfo.b + ", cost: " + a3 + "ms");
        c cVar = new c(bVar, chapterInfo);
        ArrayList arrayList = new ArrayList();
        int j = bVar.j();
        for (int i = 0; i < j; i++) {
            np4.e eVar = new np4.e(storyId, chapterInfo.a, bVar, i);
            if (i == j - 1) {
                eVar.h(true);
            }
            arrayList.add(eVar);
        }
        cVar.c.addAll(arrayList);
        return cVar;
    }

    public static /* synthetic */ com.dragon.read.kmp.story.impl.feeds.data.b b(b bVar, com.dragon.read.kmp.story.impl.feeds.data.e eVar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return bVar.a(eVar, z);
    }

    public final com.dragon.read.kmp.story.impl.feeds.data.b h(com.dragon.read.kmp.story.impl.feeds.data.e storyData, com.dragon.read.kmp.story.impl.feeds.data.d storyState, List<c> list, boolean z, boolean z2, boolean z3) {
        boolean z4;
        nn0.b bVar;
        Intrinsics.checkNotNullParameter(storyData, "storyData");
        Intrinsics.checkNotNullParameter(storyState, "storyState");
        if (!storyData.f.isEmpty()) {
            nn0.d d = d();
            if (z) {
                d.m(2);
            }
            nn0.c c = d.c();
            if (list != null && !list.isEmpty()) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                List<com.dragon.read.kmp.story.impl.feeds.data.a> list2 = storyData.f;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(f(this, storyData.a, (com.dragon.read.kmp.story.impl.feeds.data.a) it2.next(), c, null, 8, null));
                }
                list = arrayList;
            } else if (z3) {
                List<com.dragon.read.kmp.story.impl.feeds.data.a> list3 = storyData.f;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                for (com.dragon.read.kmp.story.impl.feeds.data.a aVar : list3) {
                    Iterator<c> it4 = list.iterator();
                    int i = 0;
                    while (true) {
                        if (it4.hasNext()) {
                            if (Intrinsics.areEqual(it4.next().a(), aVar.a)) {
                                break;
                            }
                            i++;
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    String str = storyData.a;
                    c cVar = (c) CollectionsKt___CollectionsKt.getOrNull(list, i);
                    if (cVar != null) {
                        bVar = cVar.a;
                    } else {
                        bVar = null;
                    }
                    arrayList2.add(e(str, aVar, c, bVar));
                }
                list = arrayList2;
            }
            g gVar = new g();
            gVar.c = true;
            gVar.d = Boolean.valueOf(storyState.e());
            gVar.f = z2;
            gVar.h = storyState.c();
            gVar.g = storyState.b;
            com.dragon.read.kmp.story.impl.feeds.data.b g = g(storyData, list, gVar);
            if (storyData.g() || z3) {
                g.d.addAll(list);
            }
            return g;
        }
        throw new Error("rePagingStoryContent,chapterInfoList is empty");
    }

    public static /* synthetic */ c f(b bVar, String str, com.dragon.read.kmp.story.impl.feeds.data.a aVar, nn0.c cVar, nn0.b bVar2, int i, Object obj) {
        if ((i & 8) != 0) {
            bVar2 = null;
        }
        return bVar.e(str, aVar, cVar, bVar2);
    }

    public static /* synthetic */ com.dragon.read.kmp.story.impl.feeds.data.b i(b bVar, com.dragon.read.kmp.story.impl.feeds.data.e eVar, com.dragon.read.kmp.story.impl.feeds.data.d dVar, List list, boolean z, boolean z2, boolean z3, int i, Object obj) {
        boolean z4;
        boolean z5;
        boolean z6;
        if ((i & 4) != 0) {
            list = null;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            z4 = false;
        } else {
            z4 = z;
        }
        if ((i & 16) != 0) {
            z5 = false;
        } else {
            z5 = z2;
        }
        if ((i & 32) != 0) {
            z6 = false;
        } else {
            z6 = z3;
        }
        return bVar.h(eVar, dVar, list2, z4, z5, z6);
    }
}
