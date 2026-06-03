package jl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.j;
import com.dragon.read.kmp.profile.filteroption.FilterOptionHeaderType;
import com.dragon.read.kmp.service.g0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.UgcCommentSourceEnum;
import com.dragon.read.rpc.kmp.community.model.b6;
import com.dragon.read.rpc.kmp.community.model.c7;
import com.dragon.read.rpc.kmp.community.model.d7;
import com.dragon.read.rpc.kmp.community.model.h2;
import com.dragon.read.rpc.kmp.community.model.i2;
import com.dragon.read.rpc.kmp.community.model.p2;
import com.dragon.read.rpc.kmp.community.model.v6;
import com.dragon.read.rpc.kmp.community.model.z;
import com.dragon.read.rpc.kmp.community.rpc.CommentApiService;
import dl4.b;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g implements dl4.b {
    public static final a i;
    public static final int j;
    private final ProfileTab a;
    private final String b;
    private String c;
    private boolean d;
    private String e;
    private Boolean f;
    private String g;
    private boolean h;

    public static final class a {
        static {
            Covode.recordClassIndex(608126);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608125);
        i = new a(null);
        j = 8;
    }

    public int q() {
        return 20;
    }

    @Override // dl4.b
    public Boolean d() {
        return this.f;
    }

    @Override // dl4.b
    public boolean f() {
        return this.h;
    }

    @Override // dl4.b
    public boolean k() {
        return this.d;
    }

    @Override // dl4.b
    public void onDestroy() {
        b.a.e(this);
    }

    private final int r() {
        return ProfileTab.Album.getValue();
    }

    @Override // dl4.b
    public void reset() {
        this.c = "";
        this.d = false;
        this.f = null;
    }

    @Override // dl4.b
    public void c(String str) {
        b.a.g(this, str);
    }

    @Override // dl4.b
    public void g(int i2) {
        b.a.c(this, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Throwable th) {
        j.a.e("SeriesGuestAlbumDataSource", "fetchVideoList error", th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List n(Function1 function1, Object p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (List) function1.invoke(p0);
    }

    public g(ProfileTab profileTab, String justSawAlbumId) {
        Intrinsics.checkNotNullParameter(profileTab, "profileTab");
        Intrinsics.checkNotNullParameter(justSawAlbumId, "justSawAlbumId");
        this.a = profileTab;
        this.b = justSawAlbumId;
        this.c = "";
        this.e = "";
        this.g = "";
    }

    @Override // dl4.b
    public Single<List<Object>> a(String targetUserId, FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "filterOptionHeaderType");
        return l(filterOptionHeaderType, this.g);
    }

    private final Single<List<Object>> l(FilterOptionHeaderType filterOptionHeaderType, String str) {
        boolean z;
        h2 h2Var;
        if (this.b.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int value = UgcCommentSourceEnum.VideoProfilePage.getValue();
            String str2 = this.e;
            int appId = g0.a.getAppId();
            int value2 = this.a.getValue();
            int r = r();
            String d = FilterOptionHeaderType.Companion.d(filterOptionHeaderType);
            String str3 = this.c;
            int q = q();
            h2Var = new h2(Integer.valueOf(value), (Integer) null, str2, Integer.valueOf(appId), Integer.valueOf(value2), Integer.valueOf(r), Integer.valueOf(q), str3, d, (Integer) null, str, this.b, (Map) null, (String) null, 12802, (DefaultConstructorMarker) null);
        } else {
            int value3 = UgcCommentSourceEnum.VideoProfilePage.getValue();
            String str4 = this.e;
            int appId2 = g0.a.getAppId();
            int value4 = this.a.getValue();
            int r2 = r();
            String d2 = FilterOptionHeaderType.Companion.d(filterOptionHeaderType);
            h2Var = new h2(Integer.valueOf(value3), (Integer) null, str4, Integer.valueOf(appId2), Integer.valueOf(value4), Integer.valueOf(r2), Integer.valueOf(q()), this.c, d2, (Integer) null, (String) null, (String) null, (Map) null, (String) null, 15874, (DefaultConstructorMarker) null);
        }
        Observable z2 = CommentApiService.z(CommentApiService.a, h2Var, (zn0.g) null, 2, (Object) null);
        final Function1 function1 = new Function1() { // from class: jl4.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List m;
                m = g.m(g.this, (i2) obj);
                return m;
            }
        };
        Observable map = z2.map(new Function() { // from class: jl4.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List n;
                n = g.n(Function1.this, obj);
                return n;
            }
        });
        final Function1 function12 = new Function1() { // from class: jl4.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o;
                o = g.o((Throwable) obj);
                return o;
            }
        };
        Single<List<Object>> singleOrError = map.doOnError(new Consumer() { // from class: jl4.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g.p(Function1.this, obj);
            }
        }).singleOrError();
        Intrinsics.checkNotNullExpressionValue(singleOrError, "singleOrError(...)");
        return singleOrError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m(g gVar, i2 it2) {
        List<b6> list;
        p2 p2Var;
        String str;
        Boolean bool;
        List list2;
        b bVar;
        List list3;
        List<c7> list4;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(it2, "it");
        ArrayList arrayList = new ArrayList();
        d7 d7Var = it2.a;
        Boolean bool2 = null;
        if (d7Var != null) {
            list = d7Var.c;
        } else {
            list = null;
        }
        if (d7Var != null) {
            p2Var = d7Var.d;
        } else {
            p2Var = null;
        }
        String str4 = "";
        if (list == null) {
            if (p2Var != null) {
                str3 = p2Var.c;
            } else {
                str3 = null;
            }
            if (str3 != null) {
                str4 = str3;
            }
            gVar.c = str4;
            if (p2Var != null) {
                bool2 = p2Var.b;
            }
            gVar.d = com.dragon.read.kmp.utils.g0.a(bool2);
            j.f(j.a, "SeriesGuestAlbumDataSource", "fetchVideoList fail ugcMixDataList is null", (Throwable) null, 4, (Object) null);
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (p2Var != null) {
            str = p2Var.c;
        } else {
            str = null;
        }
        if (str != null) {
            str4 = str;
        }
        gVar.c = str4;
        if (p2Var != null) {
            bool = p2Var.b;
        } else {
            bool = null;
        }
        gVar.d = com.dragon.read.kmp.utils.g0.a(bool);
        d7 d7Var2 = it2.a;
        if (d7Var2 != null && (list4 = d7Var2.a) != null) {
            for (c7 c7Var : list4) {
                Integer num = c7Var.b;
                int value = gVar.a.getValue();
                if (num != null && num.intValue() == value) {
                    Map map = c7Var.h;
                    if (map != null) {
                        str2 = (String) map.get("locate_post_exist");
                    } else {
                        str2 = null;
                    }
                    gVar.h = Intrinsics.areEqual("1", str2);
                }
            }
        }
        if (gVar.f == null) {
            gVar.f = Boolean.valueOf(!gVar.d);
        }
        ArrayList arrayList2 = new ArrayList();
        for (b6 b6Var : list) {
            z zVar = b6Var.h;
            if (zVar == null) {
                bVar = null;
            } else {
                Intrinsics.checkNotNull(zVar);
                z zVar2 = b6Var.h;
                if (zVar2 != null && (list3 = zVar2.i) != null) {
                    list2 = new ArrayList();
                    Iterator it4 = list3.iterator();
                    while (it4.hasNext()) {
                        list2.add(new jl4.a((v6) it4.next()));
                    }
                } else {
                    list2 = null;
                }
                if (list2 == null) {
                    list2 = CollectionsKt__CollectionsKt.emptyList();
                }
                bVar = new b(zVar, list2);
            }
            if (bVar != null) {
                arrayList2.add(bVar);
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @Override // dl4.b
    public Single<List<Object>> b(String targetUserId, String justSawVid, FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(justSawVid, "justSawVid");
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "filterOptionHeaderType");
        this.e = targetUserId;
        this.g = justSawVid;
        return l(filterOptionHeaderType, justSawVid);
    }
}
