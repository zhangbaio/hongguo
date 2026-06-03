package com.dragon.read.kmp.profile.album;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.rxkmp.KSchedulers;
import com.dragon.read.kmp.profile.guestprofile.n;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import com.dragon.read.rpc.kmp.community.model.b6;
import com.dragon.read.rpc.kmp.community.model.d7;
import com.dragon.read.rpc.kmp.community.model.z;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final a e;
    public final String a;
    public final boolean b;
    private final boolean c;
    public final MutableState<List<Object>> d;

    public static final class a {
        static {
            Covode.recordClassIndex(608025);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608024);
        e = new a(null);
    }

    private final t j(Object obj) {
        t tVar;
        String str;
        String str2;
        if (obj instanceof b6) {
            b6 b6Var = (b6) obj;
            if (b6Var.h == null) {
                return null;
            }
            z zVar = b6Var.h;
            if (zVar != null) {
                str = zVar.b;
            } else {
                str = null;
            }
            if (zVar != null) {
                str2 = zVar.a;
            } else {
                str2 = null;
            }
            tVar = new t(new b(str, str2), null, 2, null);
        } else {
            if (!(obj instanceof z)) {
                return null;
            }
            z zVar2 = (z) obj;
            tVar = new t(new b(zVar2.b, zVar2.a), null, 2, null);
        }
        return tVar;
    }

    private final List<Object> k(List<? extends Object> list) {
        boolean z = false;
        if (list.size() > 5) {
            list = list.subList(0, 5);
            z = true;
        }
        List<Object> arrayList = new ArrayList<>();
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            t j = j(it2.next());
            if (j != null) {
                arrayList.add(j);
            }
        }
        if (z) {
            arrayList = CollectionsKt___CollectionsKt.plus((Collection<? extends t>) arrayList, new t(null, ProfileAlbumHolderType.MoreAlbum));
        }
        if (!this.b) {
            return CollectionsKt___CollectionsKt.plus((Collection) CollectionsKt__CollectionsJVMKt.listOf(new t(null, ProfileAlbumHolderType.CreateAlbum)), (Iterable) arrayList);
        }
        return arrayList;
    }

    public final void e(ProfileTab profileTab) {
        com.dragon.read.kmp.j.a.d("ProfileAlbumHeaderLayoutController", "tryFetchAlbumTabData request start. isGuestProfile=" + this.b + '.');
        Observable d = n.a.d(com.dragon.read.kmp.profile.guestprofile.n.d, this.a, profileTab, ProfileTab.Album, null, null, null, null, null, 248, null);
        KSchedulers kSchedulers = KSchedulers.INSTANCE;
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        Observable subscribeOn = d.subscribeOn(io2);
        Scheduler mainThread = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullExpressionValue(mainThread, "mainThread()");
        Observable observeOn = subscribeOn.observeOn(mainThread);
        final Function1 function1 = new Function1() { // from class: com.dragon.read.kmp.profile.album.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f;
                f = g.f(g.this, (d7) obj);
                return f;
            }
        };
        Consumer consumer = new Consumer() { // from class: com.dragon.read.kmp.profile.album.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g.g(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.dragon.read.kmp.profile.album.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit h;
                h = g.h(g.this, (Throwable) obj);
                return h;
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.dragon.read.kmp.profile.album.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g.i(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(g gVar, d7 d7Var) {
        com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
        jVar.d("ProfileAlbumHeaderLayoutController", "fetchAlbumTabData request success. data is " + d7Var);
        List<? extends Object> list = d7Var.c;
        if (list != null) {
            if (!(!list.isEmpty())) {
                list = null;
            }
            if (list != null) {
                gVar.d.setValue(gVar.k(list));
                return Unit.INSTANCE;
            }
        }
        com.dragon.read.kmp.j.c(jVar, "ProfileAlbumHeaderLayoutController", "fetchAlbumTabData empty", (Throwable) null, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(g gVar, Throwable th) {
        String stackTraceToString;
        com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
        StringBuilder sb = new StringBuilder();
        sb.append("fetchAlbumTabData ");
        sb.append(gVar.a);
        sb.append(" error ");
        Intrinsics.checkNotNull(th);
        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(th);
        sb.append(stackTraceToString);
        com.dragon.read.kmp.j.c(jVar, "ProfileAlbumHeaderLayoutController", sb.toString(), (Throwable) null, 4, (Object) null);
        return Unit.INSTANCE;
    }

    public g(String targetUserId, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        this.a = targetUserId;
        this.b = z;
        this.c = z2;
        this.d = SnapshotStateKt.mutableStateOf$default(CollectionsKt__CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ g(String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? false : z2);
    }
}
