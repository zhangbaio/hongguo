package ak4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.SearchTabType;
import com.bytedance.kmp.reading.model.s80;
import com.dragon.read.feed.staggeredfeed.FeedScene;
import com.dragon.read.kmp.mine.search.view.MineSearchPageViewModel;
import hn4.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k implements hn4.b {
    public static final int e;
    public final int a;
    public final int b;
    private final String c;
    private final MineSearchPageViewModel d;

    static {
        Covode.recordClassIndex(607749);
        e = 8;
    }

    @Override // hn4.b
    public String i() {
        return "mine_tab";
    }

    @Override // hn4.b
    public FeedScene b() {
        return FeedScene.MINE_SEARCH;
    }

    @Override // hn4.b
    public uh4.d a() {
        return b.a.g(this);
    }

    @Override // hn4.b
    public boolean c() {
        return b.a.c(this);
    }

    @Override // hn4.b
    public String e() {
        return b.a.a(this);
    }

    @Override // hn4.b
    public boolean l() {
        return b.a.b(this);
    }

    @Override // hn4.b
    public String h() {
        return "没有更多近期" + this.c;
    }

    @Override // hn4.b
    public int k(xs4.f fVar) {
        if (fVar != null) {
            return fVar.c;
        }
        return 3;
    }

    @Override // hn4.b
    public List<uh4.c> j(hn4.a feedTab) {
        uh4.c jVar;
        Intrinsics.checkNotNullParameter(feedTab, "feedTab");
        ArrayList arrayList = new ArrayList();
        if (this.b == SearchTabType.MyPost.getValue()) {
            jVar = new d(this.a, feedTab, this.d);
        } else {
            jVar = new j(this.a, feedTab, this.d);
        }
        arrayList.add(jVar);
        return arrayList;
    }

    @Override // hn4.b
    public List<yh4.b> m(s80 tabData, hn4.d params, boolean z) {
        List<? extends com.dragon.read.kmp.mine.data.b> list;
        Intrinsics.checkNotNullParameter(tabData, "tabData");
        Intrinsics.checkNotNullParameter(params, "params");
        MineSearchPageViewModel mineSearchPageViewModel = this.d;
        if (mineSearchPageViewModel != null) {
            list = mineSearchPageViewModel.i;
        } else {
            list = null;
        }
        return a.a.b(tabData, params, list);
    }

    public k(int i, int i2, String tabName, MineSearchPageViewModel mineSearchPageViewModel) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        this.a = i;
        this.b = i2;
        this.c = tabName;
        this.d = mineSearchPageViewModel;
    }
}
