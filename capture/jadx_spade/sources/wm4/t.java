package wm4;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.App;
import com.dragon.read.base.Args;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.shortvideo.api.model.ShortSeriesLaunchArgs;
import com.dragon.read.feed.bookmall.card.model.staggered.BaseInfiniteModel;
import com.dragon.read.kmp.relatedwrok.RelatedWork2ColModel;
import com.dragon.read.pages.bookmall.model.VideoTabModel;
import com.dragon.read.reader.utils.ReaderBundleBuilder;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.report.PageRecorderUtils;
import com.dragon.read.report.ReportManager;
import com.dragon.read.report.a1;
import com.dragon.read.rpc.model.ApiBookInfo;
import com.dragon.read.rpc.model.CellViewData;
import com.dragon.read.rpc.model.SecondaryInfo;
import com.dragon.read.util.kotlin.ContextKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import pu4.e2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t extends ViewModel {
    public static final a e;
    public static final int f;
    public MutableStateFlow<o> a = StateFlowKt.MutableStateFlow(new o("", 6, "", (int) (ScreenUtils.getScreenWidthDp(App.context()) * 0.4871795f), false, CollectionsKt__CollectionsKt.emptyList(), null, null, null));
    private RelatedWork2ColModel b;
    private Function0<? extends Args> c;
    private Function0<Unit> d;

    public static final class a {
        static {
            Covode.recordClassIndex(608674);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(608673);
        e = new a(null);
        f = 8;
    }

    public final void Q0() {
        Function0<Unit> function0 = this.d;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final Args J0() {
        Function0<? extends Args> function0 = this.c;
        if (function0 != null) {
            return function0.invoke();
        }
        return null;
    }

    public final String I0() {
        String feedBackFromSrcMaterialId;
        RelatedWork2ColModel relatedWork2ColModel = this.b;
        if (relatedWork2ColModel == null || (feedBackFromSrcMaterialId = relatedWork2ColModel.getFeedBackFromSrcMaterialId()) == null) {
            return "";
        }
        return feedBackFromSrcMaterialId;
    }

    protected void onCleared() {
        super.onCleared();
        this.c = null;
        this.d = null;
    }

    private final Args O0() {
        Args args = new Args();
        args.putAll(K0().toArgs());
        args.putAll(J0());
        return args;
    }

    private final void X0() {
        Args O0 = O0();
        O0.put("related_content_list_page_entrance", "unlimited_content");
        ReportManager.onReport("enter_related_content_list_page", O0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final PageRecorder K0() {
        int i;
        PageRecorder currentPageRecorder = PageRecorderUtils.getCurrentPageRecorder();
        currentPageRecorder.addParam("unlimited_content_type", "related_content_list");
        RelatedWork2ColModel relatedWork2ColModel = this.b;
        if (relatedWork2ColModel != null) {
            i = Intrinsics.areEqual(relatedWork2ColModel.isFeedBackCard(), Boolean.TRUE);
        } else {
            i = 0;
        }
        currentPageRecorder.addParam("is_quick_respond_card", Integer.valueOf(i));
        currentPageRecorder.addParam("responded_src_material_id", I0());
        currentPageRecorder.addParam(J0());
        Intrinsics.checkNotNullExpressionValue(currentPageRecorder, "apply(...)");
        return currentPageRecorder;
    }

    public final void T0() {
        String str;
        boolean z;
        CellViewData cellViewData;
        RelatedWork2ColModel relatedWork2ColModel = this.b;
        if (relatedWork2ColModel != null && (cellViewData = ((BaseInfiniteModel) relatedWork2ColModel).originalData) != null) {
            str = cellViewData.cellUrl;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            LogWrapper.error("CategoryRank2ColViewModel", "schema is empty " + str, new Object[0]);
        }
        PageRecorder K0 = K0();
        K0.removeParam("unlimited_content_type");
        K0.addParam("related_content_list_page_entrance", "unlimited_content");
        NsCommonDepend.IMPL.appNavigator().openUrl(ContextKt.getCurrentContext(), str, K0);
        Y0("landing_page");
        X0();
    }

    public final void b1(Function0<? extends Args> argsGetter) {
        Intrinsics.checkNotNullParameter(argsGetter, "argsGetter");
        this.c = argsGetter;
    }

    public final void c1(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.d = callback;
    }

    public final void Y0(String str) {
        Args O0 = O0();
        if (str != null) {
            O0.put("click_to", str);
            ReportManager.onReport("click_unlimited_content", O0);
        } else {
            ReportManager.onReport("show_unlimited_content", O0);
        }
    }

    private final ApiBookInfo L0(u uVar) {
        List<v> rankList;
        Object obj;
        RelatedWork2ColModel relatedWork2ColModel = this.b;
        if (relatedWork2ColModel == null || (rankList = relatedWork2ColModel.getRankList()) == null) {
            return null;
        }
        Iterator<T> it2 = rankList.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((v) obj).c(), uVar.a)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        v vVar = (v) obj;
        if (vVar == null) {
            return null;
        }
        return vVar.a;
    }

    private final v M0(u uVar) {
        List<v> rankList;
        RelatedWork2ColModel relatedWork2ColModel = this.b;
        Object obj = null;
        if (relatedWork2ColModel == null || (rankList = relatedWork2ColModel.getRankList()) == null) {
            return null;
        }
        Iterator<T> it2 = rankList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (Intrinsics.areEqual(((v) next).c(), uVar.a)) {
                obj = next;
                break;
            }
        }
        return (v) obj;
    }

    private final VideoTabModel.VideoData N0(u uVar) {
        List<v> rankList;
        Object obj;
        RelatedWork2ColModel relatedWork2ColModel = this.b;
        if (relatedWork2ColModel == null || (rankList = relatedWork2ColModel.getRankList()) == null) {
            return null;
        }
        Iterator<T> it2 = rankList.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((v) obj).c(), uVar.a)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        v vVar = (v) obj;
        if (vVar == null) {
            return null;
        }
        return vVar.b;
    }

    public final void S0(u item) {
        Intrinsics.checkNotNullParameter(item, "item");
        v M0 = M0(item);
        if (M0 == null) {
            return;
        }
        if (M0.f()) {
            a1(item, M0.c, false);
            a1 F0 = F0(item, M0.c);
            if (F0 != null) {
                F0.f();
                return;
            }
            return;
        }
        W0(item, M0.c, false);
        com.dragon.read.report.d E0 = E0(item, M0.c);
        if (E0 != null) {
            E0.d();
        }
    }

    private final void U0(u uVar) {
        String str;
        v M0 = M0(uVar);
        if (M0 == null) {
            return;
        }
        Args args = new Args();
        ApiBookInfo apiBookInfo = M0.a;
        if (apiBookInfo != null) {
            args.putAll(H0(apiBookInfo, M0.c));
        }
        ReaderBundleBuilder readerBundleBuilder = new ReaderBundleBuilder(ContextKt.getCurrentContext(), uVar.a, uVar.c, uVar.b);
        PageRecorder K0 = K0();
        ApiBookInfo L0 = L0(uVar);
        if (L0 != null) {
            str = L0.recommendInfo;
        } else {
            str = null;
        }
        K0.addParam("recommend_info", str);
        K0.addParam(args);
        readerBundleBuilder.setPageRecoder(K0).openReader();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G0(com.dragon.read.kmp.relatedwrok.RelatedWork2ColModel r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            java.lang.String r2 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r0.b = r1
            kotlinx.coroutines.flow.MutableStateFlow<wm4.o> r2 = r0.a
        Ld:
            java.lang.Object r3 = r2.getValue()
            r4 = r3
            wm4.o r4 = (wm4.o) r4
            com.dragon.read.rpc.model.CellViewData r5 = r1.originalData
            if (r5 == 0) goto L1c
            java.lang.String r5 = r5.cellName
            if (r5 != 0) goto L1e
        L1c:
            java.lang.String r5 = ""
        L1e:
            java.lang.String r7 = r29.getMCardBgUrl()
            android.app.Application r6 = com.dragon.read.app.App.context()
            int r6 = com.dragon.read.base.ui.util.ScreenUtils.getScreenWidthDp(r6)
            float r6 = (float) r6
            r8 = 1056534423(0x3ef96f97, float:0.4871795)
            float r6 = r6 * r8
            int r8 = (int) r6
            com.dragon.read.rpc.model.CellViewData r6 = r1.originalData
            r9 = 1
            if (r6 == 0) goto L47
            java.lang.String r6 = r6.cellUrl
            if (r6 == 0) goto L47
            int r6 = r6.length()
            if (r6 <= 0) goto L42
            r6 = 1
            goto L43
        L42:
            r6 = 0
        L43:
            if (r6 != r9) goto L47
            r11 = 1
            goto L48
        L47:
            r11 = 0
        L48:
            java.util.List r6 = r29.getRankList()
            java.util.ArrayList r12 = new java.util.ArrayList
            r13 = 10
            int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r13)
            r12.<init>(r13)
            java.util.Iterator r6 = r6.iterator()
            r13 = 0
        L5c:
            boolean r14 = r6.hasNext()
            if (r14 == 0) goto Laf
            java.lang.Object r14 = r6.next()
            int r15 = r13 + 1
            if (r13 >= 0) goto L6d
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L6d:
            wm4.v r14 = (wm4.v) r14
            wm4.u r10 = new wm4.u
            java.lang.String r17 = r14.c()
            java.lang.String r18 = r14.a()
            java.lang.String r19 = r14.e()
            java.lang.String r20 = r14.d()
            java.lang.String r21 = r14.b()
            java.util.List r14 = r29.getRankList()
            int r14 = r14.size()
            int r14 = r14 - r9
            if (r13 != r14) goto L93
            r22 = 0
            goto L97
        L93:
            r13 = 11
            r22 = 11
        L97:
            r23 = 0
            androidx.compose.ui.graphics.l0 r24 = r29.m35getMCardMainTitleColorQN2ZGVo()
            androidx.compose.ui.graphics.l0 r25 = r29.m36getMCardSubInfoColor1QN2ZGVo()
            r26 = 64
            r27 = 0
            r16 = r10
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r12.add(r10)
            r13 = r15
            goto L5c
        Laf:
            androidx.compose.ui.graphics.l0 r13 = r29.m34getMCardBgColorQN2ZGVo()
            androidx.compose.ui.graphics.l0 r14 = r29.m35getMCardMainTitleColorQN2ZGVo()
            r6 = 8
            r9 = r11
            r10 = r12
            r11 = r13
            r12 = r14
            wm4.o r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12)
            boolean r3 = r2.compareAndSet(r3, r4)
            if (r3 == 0) goto Ld
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wm4.t.G0(com.dragon.read.kmp.relatedwrok.RelatedWork2ColModel):void");
    }

    private final com.dragon.read.report.d E0(u uVar, int i) {
        Object firstOrNull;
        ApiBookInfo L0 = L0(uVar);
        SecondaryInfo secondaryInfo = null;
        if (L0 == null) {
            return null;
        }
        com.dragon.read.report.d dVar = new com.dragon.read.report.d();
        List list = L0.recommendReasonList;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            secondaryInfo = (SecondaryInfo) firstOrNull;
        }
        return dVar.h(secondaryInfo).e(L0).g(K0()).b("inside_card_rank", Integer.valueOf(i));
    }

    private final a1 F0(u uVar, int i) {
        Object firstOrNull;
        VideoTabModel.VideoData N0 = N0(uVar);
        if (N0 == null) {
            return null;
        }
        a1 a1Var = new a1();
        List recTags = N0.getRecTags();
        Intrinsics.checkNotNullExpressionValue(recTags, "getRecTags(...)");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) recTags);
        return a1Var.p((SecondaryInfo) firstOrNull).v(N0).n(K0()).a("inside_card_rank", Integer.valueOf(i));
    }

    private final Args H0(ApiBookInfo apiBookInfo, int i) {
        Args args = new Args();
        args.putAll(K0().toArgs());
        args.putAll(J0());
        args.put("book_id", apiBookInfo.bookId);
        args.put("book_type", "novel");
        args.put("recommend_info", apiBookInfo.recommendInfo);
        args.put("inside_card_rank", Integer.valueOf(i));
        return args;
    }

    public final void R0(u item, Context context) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(context, "context");
        v M0 = M0(item);
        if (M0 == null) {
            return;
        }
        if (M0.f()) {
            V0(item, context);
            Y0("playlet");
            a1(item, M0.c, true);
        } else {
            U0(item);
            W0(item, M0.c, true);
            Y0("single_book");
        }
    }

    private final void V0(u uVar, Context context) {
        v M0 = M0(uVar);
        if (M0 == null) {
            return;
        }
        Args args = new Args();
        VideoTabModel.VideoData videoData = M0.b;
        if (videoData != null) {
            args.putAll(P0(videoData, M0.c));
        }
        ShortSeriesLaunchArgs seriesId = new ShortSeriesLaunchArgs().setContext(ContextKt.getCurrentContext()).setSeriesId(uVar.a);
        PageRecorder K0 = K0();
        K0.addParam("cover_url", uVar.b);
        K0.addParam("src_material_show_name", uVar.c);
        K0.addParam("side_title", uVar.d);
        K0.addParam(args);
        NsCommonDepend.IMPL.appNavigator().openShortSeriesActivity(seriesId.setPageRecorder(K0));
    }

    private final Args P0(VideoTabModel.VideoData videoData, int i) {
        String str;
        String str2;
        SecondaryInfo secondaryInfo;
        Args args = new Args();
        args.putAll(K0().toArgs());
        args.putAll(J0());
        args.put("src_material_id", videoData.getSeriesId());
        args.put("material_id", videoData.getVid());
        args.put("material_type", e2.d(videoData.getContentType()));
        args.put("cover_url", videoData.getCover());
        args.put("src_material_show_name", videoData.getTitle());
        List subTitleList = videoData.getSubTitleList();
        if (subTitleList == null || (secondaryInfo = (SecondaryInfo) CollectionsKt___CollectionsKt.getOrNull(subTitleList, 0)) == null || (str = secondaryInfo.content) == null) {
            str = "";
        }
        args.put("side_title", str);
        if (videoData.isVertical()) {
            str2 = "vertical";
        } else {
            str2 = "horizontal";
        }
        args.put("direction", str2);
        args.put("recommend_info", videoData.getRecommendInfo());
        args.put("recommend_group_id", videoData.getRecommendGroupId());
        args.put("inside_card_rank", Integer.valueOf(i));
        return args;
    }

    private final void W0(u uVar, int i, boolean z) {
        ApiBookInfo L0 = L0(uVar);
        if (L0 == null) {
            return;
        }
        if (z) {
            ReportManager.onReport("click_book", H0(L0, i));
        } else {
            ReportManager.onReport("show_book", H0(L0, i));
        }
    }

    private final void a1(u uVar, int i, boolean z) {
        VideoTabModel.VideoData N0 = N0(uVar);
        if (N0 == null) {
            return;
        }
        com.dragon.read.pages.video.a X0 = new com.dragon.read.pages.video.a().X0(P0(N0, i));
        if (z) {
            X0.Q();
        } else {
            X0.F();
        }
    }

    public static /* synthetic */ void Z0(t tVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        tVar.Y0(str);
    }
}
