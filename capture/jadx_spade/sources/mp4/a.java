package mp4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.d6;
import com.dragon.read.kmp.service.c0;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lp4.b;
import yo4.d;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a implements lp4.b {
    public static final C0243a d;
    public static final int e;
    public final kp4.b a;
    public final d b;
    public final Set<String> c;

    /* renamed from: mp4.a$a, reason: collision with other inner class name */
    public static final class C0243a {
        static {
            Covode.recordClassIndex(609309);
        }

        private C0243a() {
        }

        public /* synthetic */ C0243a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(609308);
        d = new C0243a(null);
        e = 8;
    }

    private final void q() {
    }

    public abstract String s();

    public abstract String t();

    @Override // lp4.b
    public void j() {
        b.a.c(this, "fold_click", null, 2, null);
    }

    @Override // lp4.b
    public void h() {
        b.a.c(this, "unfold_click", null, 2, null);
    }

    @Override // lp4.b
    public void a() {
        String str = "show_book_" + this.a.a();
        if (v(str)) {
            return;
        }
        w(str);
        if (!this.a.d().c.b) {
            b.a.d(this, null, 1, null);
            q();
        }
    }

    @Override // lp4.b
    public void d() {
        String str = "fold_show_" + this.a.a();
        if (v(str)) {
            return;
        }
        w(str);
        b.a.c(this, "fold_show", null, 2, null);
    }

    @Override // lp4.b
    public void f() {
        String str = "unfold_show_" + this.a.a();
        if (v(str)) {
            return;
        }
        w(str);
        b.a.c(this, "unfold_show", null, 2, null);
    }

    public ym4.a r() {
        boolean z;
        ym4.a aVar = new ym4.a();
        aVar.h(this.b.c);
        aVar.h(this.b.m);
        aVar.g("book_id_first", this.b.b());
        aVar.g("post_id_first", this.b.c());
        String str = this.b.k;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            aVar.g("cover_id", this.b.k);
        }
        return aVar;
    }

    public ym4.a u() {
        ym4.a aVar = new ym4.a();
        aVar.j(this.a.c.g);
        aVar.g("post_id", this.a.d().getPostId());
        aVar.g("post_type", t());
        aVar.g("book_id", this.a.d().getBookId());
        aVar.g("book_type", s());
        aVar.g("genre", this.a.d().b());
        aVar.g("post_position", this.a.c.a);
        aVar.g("post_inner_rank", Integer.valueOf(this.a.c.b));
        aVar.g("recommend_info", this.a.d().j);
        return aVar;
    }

    @Override // lp4.b
    public void k(ym4.a extraArgs) {
        Intrinsics.checkNotNullParameter(extraArgs, "extraArgs");
        p(extraArgs);
    }

    public boolean v(String dataId) {
        Intrinsics.checkNotNullParameter(dataId, "dataId");
        return this.c.contains(dataId);
    }

    public void w(String dataId) {
        Intrinsics.checkNotNullParameter(dataId, "dataId");
        this.c.add(dataId);
    }

    @Override // lp4.b
    public void g(ym4.a aVar) {
        ym4.a aVar2 = new ym4.a();
        aVar2.j(r());
        aVar2.j(u());
        if (aVar != null) {
            aVar2.j(aVar);
        }
        zp4.a.b(zp4.a.a, "show_book", aVar2, false, null, 12, null);
    }

    @Override // lp4.b
    public void i(ym4.a aVar) {
        ym4.a aVar2 = new ym4.a();
        aVar2.j(r());
        aVar2.j(u());
        if (aVar != null) {
            aVar2.j(aVar);
        }
        zp4.a.b(zp4.a.a, "go_detail", aVar2, false, null, 12, null);
    }

    @Override // lp4.b
    public void p(ym4.a aVar) {
        ym4.a aVar2 = new ym4.a();
        aVar2.j(r());
        aVar2.j(u());
        if (aVar != null) {
            aVar2.j(aVar);
        }
        zp4.a.b(zp4.a.a, "click_book", aVar2, false, null, 12, null);
    }

    @Override // lp4.b
    public void e(d6 userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        String str = "show_profile_" + this.a.a();
        if (v(str)) {
            return;
        }
        w(str);
        ym4.a aVar = new ym4.a();
        aVar.j(r());
        aVar.j(u());
        aVar.g("profile_user_id", userInfo.I);
        aVar.g("follow_source", this.b.d());
        zp4.a.b(zp4.a.a, "show_profile", aVar, false, null, 12, null);
    }

    public a(kp4.b story, d clientParam) {
        Intrinsics.checkNotNullParameter(story, "story");
        Intrinsics.checkNotNullParameter(clientParam, "clientParam");
        this.a = story;
        this.b = clientParam;
        this.c = new LinkedHashSet();
    }

    @Override // lp4.b
    public void l(String eventName, ym4.a aVar) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ym4.a aVar2 = new ym4.a();
        aVar2.j(r());
        aVar2.j(u());
        if (aVar != null) {
            aVar2.j(aVar);
        }
        zp4.a.b(zp4.a.a, eventName, aVar2, false, null, 12, null);
    }

    @Override // lp4.b
    public void o(Boolean bool, d6 userInfo) {
        String str;
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            str = "click_follow_user";
        } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            str = "cancel_follow_user";
        } else {
            String str2 = "show_follow_user_" + this.a.a();
            if (v(str2)) {
                return;
            }
            w(str2);
            str = "show_follow_user";
        }
        String str3 = str;
        ym4.a aVar = new ym4.a();
        aVar.j(r());
        aVar.j(u());
        aVar.g("follow_uid", c0.a.getUserId());
        aVar.g("followed_uid", userInfo.a);
        aVar.g("follow_source", this.b.d());
        zp4.a.b(zp4.a.a, str3, aVar, false, null, 12, null);
    }
}
