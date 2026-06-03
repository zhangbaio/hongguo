package dl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.profile.params.a;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final a a;

    public static final class a {
        static {
            Covode.recordClassIndex(608078);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            Covode.recordClassIndex(608079);
            int[] iArr = new int[ProfileTab.values().length];
            try {
                iArr[ProfileTab.Album.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProfileTab.Talk_BookComment.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        Covode.recordClassIndex(608077);
        a = new a(null);
    }

    private static final dl4.b d(Lazy<? extends dl4.b> lazy) {
        return lazy.getValue();
    }

    public final dl4.b b(rl4.c cVar) {
        boolean z;
        Lazy lazy;
        int i;
        if (cVar == null) {
            return null;
        }
        ProfileTab profileTab = cVar.b;
        final com.dragon.read.kmp.profile.params.a aVar = cVar.p;
        final boolean z2 = cVar.s;
        ProfileTab profileTab2 = ProfileTab.Video;
        if (profileTab == profileTab2 && gl4.b.a.a()) {
            z = true;
        } else {
            z = false;
        }
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: dl4.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b c;
                c = g.c(com.dragon.read.kmp.profile.params.a.this, z2);
                return c;
            }
        });
        if (profileTab == profileTab2) {
            ProfileTab profileTab3 = cVar.f;
            if (profileTab3 == null) {
                i = -1;
            } else {
                i = b.a[profileTab3.ordinal()];
            }
            if (i != 1) {
                if (i != 2) {
                    if (z2) {
                        return d(lazy);
                    }
                    if (aVar == null) {
                        return null;
                    }
                    return aVar.r(z, new wl4.b(z, null, 2, null));
                }
                return new nl4.e(profileTab);
            }
            return new jl4.g(profileTab, cVar.u);
        }
        if (profileTab == ProfileTab.Bookshelf) {
            return new zk4.d();
        }
        if (profileTab == ProfileTab.Digg) {
            return new ul4.d();
        }
        if (profileTab == ProfileTab.PugcVideo) {
            return d(lazy);
        }
        if (profileTab == ProfileTab.Select) {
            String str = cVar.y;
            cVar.y = null;
            if (aVar == null) {
                return null;
            }
            return aVar.r(true, new pl4.a(str, cVar.x));
        }
        if (profileTab != null && ol4.a.a(profileTab)) {
            if (aVar == null) {
                return null;
            }
            return a.C0033a.a(aVar, false, new ll4.g(false, profileTab, cVar.f), 1, null);
        }
        com.dragon.read.kmp.j.f(com.dragon.read.kmp.j.a, "SeriesGuestOneTabDataSourceFactory", "getDataSourceByTabType unknown profileTab:" + profileTab, (Throwable) null, 4, (Object) null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final dl4.b c(com.dragon.read.kmp.profile.params.a aVar, boolean z) {
        if (aVar == null) {
            return null;
        }
        return a.C0033a.a(aVar, false, new vl4.b(z), 1, null);
    }
}
