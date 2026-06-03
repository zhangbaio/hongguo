package nl4;

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
import com.dragon.read.rpc.kmp.community.model.l5;
import com.dragon.read.rpc.kmp.community.model.p2;
import com.dragon.read.rpc.kmp.community.rpc.CommentApiService;
import dl4.b;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zn0.g;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements dl4.b {
    public static final a g;
    public static final int h;
    private final ProfileTab a;
    private String b;
    private boolean c;
    private String d;
    private Boolean e;
    private boolean f;

    public static final class a {
        static {
            Covode.recordClassIndex(608141);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608140);
        g = new a(null);
        h = 8;
    }

    public int q() {
        return 20;
    }

    @Override // dl4.b
    public Boolean d() {
        return this.e;
    }

    @Override // dl4.b
    public boolean f() {
        return this.f;
    }

    @Override // dl4.b
    public boolean k() {
        return this.c;
    }

    @Override // dl4.b
    public void onDestroy() {
        b.a.e(this);
    }

    @Override // dl4.b
    public void reset() {
        this.b = "";
        this.c = false;
        this.e = null;
    }

    @Override // dl4.b
    public void c(String str) {
        b.a.g(this, str);
    }

    @Override // dl4.b
    public void g(int i) {
        b.a.c(this, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Throwable th) {
        j.a.e("SeriesGuestPlayletCommentDataSource", "fetchVideoList error", th);
        return Unit.INSTANCE;
    }

    public e(ProfileTab profileTab) {
        Intrinsics.checkNotNullParameter(profileTab, "profileTab");
        this.a = profileTab;
        this.b = "";
        this.d = "";
    }

    private final Single<List<Object>> l(FilterOptionHeaderType filterOptionHeaderType) {
        int value = UgcCommentSourceEnum.VideoProfilePage.getValue();
        String str = this.d;
        int appId = g0.a.getAppId();
        int value2 = this.a.getValue();
        int value3 = ProfileTab.Talk_BookComment.getValue();
        String d = FilterOptionHeaderType.Companion.d(filterOptionHeaderType);
        Observable z = CommentApiService.z(CommentApiService.a, new h2(Integer.valueOf(value), (Integer) null, str, Integer.valueOf(appId), Integer.valueOf(value2), Integer.valueOf(value3), Integer.valueOf(q()), this.b, d, (Integer) null, (String) null, (String) null, (Map) null, (String) null, 15874, (DefaultConstructorMarker) null), (g) null, 2, (Object) null);
        final Function1 function1 = new Function1() { // from class: nl4.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                List m;
                m = e.m(e.this, (i2) obj);
                return m;
            }
        };
        Observable map = z.map(new Function() { // from class: nl4.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List n;
                n = e.n(Function1.this, obj);
                return n;
            }
        });
        final Function1 function12 = new Function1() { // from class: nl4.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o;
                o = e.o((Throwable) obj);
                return o;
            }
        };
        Single<List<Object>> singleOrError = map.doOnError(new Consumer() { // from class: nl4.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                e.p(Function1.this, obj);
            }
        }).singleOrError();
        Intrinsics.checkNotNullExpressionValue(singleOrError, "singleOrError(...)");
        return singleOrError;
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

    @Override // dl4.b
    public Single<List<Object>> a(String targetUserId, FilterOptionHeaderType filterOptionHeaderType) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(filterOptionHeaderType, "filterOptionHeaderType");
        return l(filterOptionHeaderType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List m(e eVar, i2 it2) {
        List<b6> list;
        p2 p2Var;
        String str;
        Boolean bool;
        t72.j jVar;
        List<c7> list2;
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
            eVar.b = str4;
            if (p2Var != null) {
                bool2 = p2Var.b;
            }
            eVar.c = com.dragon.read.kmp.utils.g0.a(bool2);
            j.f(j.a, "SeriesGuestPlayletCommentDataSource", "fetchVideoList fail ugcMixDataList is null", (Throwable) null, 4, (Object) null);
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
        eVar.b = str4;
        if (p2Var != null) {
            bool = p2Var.b;
        } else {
            bool = null;
        }
        eVar.c = com.dragon.read.kmp.utils.g0.a(bool);
        d7 d7Var2 = it2.a;
        if (d7Var2 != null && (list2 = d7Var2.a) != null) {
            for (c7 c7Var : list2) {
                Integer num = c7Var.b;
                int value = eVar.a.getValue();
                if (num != null && num.intValue() == value) {
                    Map map = c7Var.h;
                    if (map != null) {
                        str2 = (String) map.get("locate_post_exist");
                    } else {
                        str2 = null;
                    }
                    eVar.f = Intrinsics.areEqual("1", str2);
                }
            }
        }
        if (eVar.e == null) {
            eVar.e = Boolean.valueOf(!eVar.c);
        }
        ArrayList arrayList2 = new ArrayList();
        for (b6 b6Var : list) {
            if (b6Var.b == null) {
                jVar = null;
            } else {
                l5 l5Var = b6Var.b;
                Intrinsics.checkNotNull(l5Var);
                jVar = new t72.j(l5Var);
            }
            if (jVar != null) {
                arrayList2.add(jVar);
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
        this.d = targetUserId;
        return l(filterOptionHeaderType);
    }
}
