package jk4;

import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.Args;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.kmp.nps.DoubleColSimilarNpsModel;
import com.dragon.read.report.PageRecorderUtils;
import com.dragon.read.report.ReportManager;
import com.dragon.read.rpc.model.ResearchEvent;
import com.dragon.read.rpc.model.UserEventReportRequest;
import com.dragon.read.rpc.model.UserEventReportType;
import com.dragon.read.rpc.model.UserResearchOptionInfo;
import com.dragon.read.util.kotlin.CollectionKt;
import com.dragon.read.util.kotlin.ContextKt;
import com.ss.android.excitingvideo.utils.GsonUtilKt;
import com.ss.android.excitingvideo.utils.extensions.ExtensionsKt;
import com.ss.android.messagebus.BusProvider;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jk4.o1;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class q1 extends com.dragon.read.kmp.base.d<DoubleColSimilarNpsModel, f1> implements o1 {
    public static final int j;
    private Function0<Unit> e;
    public DoubleColSimilarNpsModel f;
    private final MutableStateFlow<m> g;
    public final StateFlow<m> h;
    private Function0<Unit> i;

    static {
        Covode.recordClassIndex(607893);
        j = 8;
    }

    @Override // jk4.o1
    public UserResearchOptionInfo S() {
        return null;
    }

    public final void S0() {
        Function0<Unit> function0 = this.e;
        if (function0 != null) {
            function0.invoke();
        }
    }

    protected void onCleared() {
        super.onCleared();
        this.e = null;
    }

    @Override // jk4.o1
    public String G() {
        return ((f1) I0().getValue()).a;
    }

    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public f1 G0() {
        return new f1("", CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList());
    }

    public void R0() {
        U0(null);
        V0();
        a1("nps");
    }

    protected void V0() {
        new l1(ContextKt.getCurrentContext(), this).show();
    }

    public q1() {
        MutableStateFlow<m> MutableStateFlow = StateFlowKt.MutableStateFlow(new m(false, 0, null, null, null, 31, null));
        this.g = MutableStateFlow;
        this.h = FlowKt.asStateFlow(MutableStateFlow);
    }

    private final Args Q0() {
        Args args = new Args();
        args.putAll(PageRecorderUtils.getCurrentPageRecorder().toArgs());
        args.putAll(H0());
        return args;
    }

    public final void M0() {
        String str;
        boolean z;
        Function0<Unit> function0;
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
        if (doubleColSimilarNpsModel != null) {
            str = doubleColSimilarNpsModel.getResearchId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z && (function0 = this.i) != null) {
            function0.invoke();
        }
    }

    protected Args P0() {
        String str;
        Args args = new Args();
        args.put("position", "c2feed_c2feed");
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
        if (doubleColSimilarNpsModel != null) {
            str = doubleColSimilarNpsModel.getResearchId();
        } else {
            str = null;
        }
        args.put("research_id", str);
        args.put("research_title", ((f1) I0().getValue()).a);
        args.put("nps_type", "similar_category_questionnaire_for_feed");
        return args;
    }

    public void Z0() {
        String str;
        Args args = new Args();
        args.put("position", "c2feed_c2feed");
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
        if (doubleColSimilarNpsModel != null) {
            str = doubleColSimilarNpsModel.getResearchId();
        } else {
            str = null;
        }
        args.put("research_id", str);
        args.put("research_title", ((f1) I0().getValue()).a);
        args.put("nps_type", "similar_category_questionnaire_for_feed");
        ReportManager.onReport("nps_query_show", args);
    }

    public final void L0() {
        String str;
        UserEventReportRequest userEventReportRequest = new UserEventReportRequest();
        ResearchEvent researchEvent = new ResearchEvent();
        userEventReportRequest.reportType = UserEventReportType.UserResearch;
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
        if (doubleColSimilarNpsModel != null) {
            str = doubleColSimilarNpsModel.getResearchId();
        } else {
            str = null;
        }
        researchEvent.researchId = str;
        researchEvent.isShown = true;
        researchEvent.isSubmitted = false;
        userEventReportRequest.researchEvent = researchEvent;
        LogWrapper.info(((com.dragon.read.kmp.base.d) this).a, "[report_card_show]:" + GsonUtilKt.toJsonString(userEventReportRequest), new Object[0]);
        g65.k.j0(userEventReportRequest).subscribeOn(Schedulers.io()).subscribe();
    }

    protected final void c1() {
        String str;
        UserEventReportRequest userEventReportRequest = new UserEventReportRequest();
        ResearchEvent researchEvent = new ResearchEvent();
        userEventReportRequest.reportType = UserEventReportType.UserResearch;
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
        if (doubleColSimilarNpsModel != null) {
            str = doubleColSimilarNpsModel.getResearchId();
        } else {
            str = null;
        }
        researchEvent.researchId = str;
        researchEvent.isShown = false;
        researchEvent.isSubmitted = true;
        userEventReportRequest.researchEvent = researchEvent;
        LogWrapper.info(((com.dragon.read.kmp.base.d) this).a, "[report_card_commit]:" + GsonUtilKt.toJsonString(userEventReportRequest), new Object[0]);
        g65.k.j0(userEventReportRequest).subscribeOn(Schedulers.io()).subscribe();
    }

    @Override // jk4.o1
    public List<s0> a0() {
        s0 s0Var;
        UserResearchOptionInfo optionInfos;
        Map map;
        String str;
        List<t0> list = ((f1) I0().getValue()).c;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            t0 t0Var = (t0) obj;
            DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
            if (doubleColSimilarNpsModel != null && (optionInfos = doubleColSimilarNpsModel.getOptionInfos()) != null && (map = optionInfos.scoreEmojiMap) != null && (str = (String) CollectionKt.getOrNull(map, Integer.valueOf(i))) != null) {
                s0Var = new s0(t0Var.a, ((Boolean) t0Var.c.getValue()).booleanValue(), str, t0Var.b, W0(t0Var));
            } else {
                s0Var = new s0(t0Var.a, ((Boolean) t0Var.c.getValue()).booleanValue(), "", t0Var.b, W0(t0Var));
            }
            arrayList.add(s0Var);
            i = i2;
        }
        return arrayList;
    }

    protected final void g1() {
        boolean z;
        Object obj;
        Object obj2;
        Object value;
        f1 f1Var;
        ArrayList arrayList;
        Object value2;
        boolean z2;
        List<t0> list = ((f1) I0().getValue()).c;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((Boolean) ((t0) it2.next()).c.getValue()).booleanValue()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            Iterator<T> it4 = ((f1) I0().getValue()).c.iterator();
            while (true) {
                obj = null;
                if (it4.hasNext()) {
                    obj2 = it4.next();
                    if (((Boolean) ((t0) obj2).c.getValue()).booleanValue()) {
                        break;
                    }
                } else {
                    obj2 = null;
                    break;
                }
            }
            t0 t0Var = (t0) obj2;
            if (t0Var == null) {
                return;
            }
            Iterator<T> it5 = ((f1) I0().getValue()).b.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((t0) next).a == t0Var.a) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    obj = next;
                    break;
                }
            }
            if (((t0) obj) == null) {
                List copy = ExtensionsKt.copy(((f1) I0().getValue()).b);
                if (copy.isEmpty()) {
                    copy.add(t0Var);
                    return;
                }
                ij4.a aVar = ij4.a.a;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(copy, 10));
                Iterator it6 = copy.iterator();
                while (it6.hasNext()) {
                    arrayList2.add(Integer.valueOf(((t0) it6.next()).a));
                }
                copy.set(aVar.a(arrayList2, t0Var.a).indexOf(Integer.valueOf(t0Var.a)), t0Var);
                MutableStateFlow I0 = I0();
                do {
                    value2 = I0.getValue();
                } while (!I0.compareAndSet(value2, f1.b((f1) value2, null, copy, null, 5, null)));
                return;
            }
            MutableStateFlow I02 = I0();
            do {
                value = I02.getValue();
                f1Var = (f1) value;
                List<t0> list2 = f1Var.b;
                arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                for (t0 t0Var2 : list2) {
                    if (t0Var2.a == t0Var.a) {
                        t0Var2.c.setValue(Boolean.TRUE);
                    } else {
                        t0Var2.c.setValue(Boolean.FALSE);
                    }
                    arrayList.add(t0Var2);
                }
            } while (!I02.compareAndSet(value, f1.b(f1Var, null, arrayList, null, 5, null)));
        }
    }

    @Override // jk4.o1
    public void W(List<String> list) {
        o1.a.a(this, list);
    }

    public final void d1(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.e = callback;
    }

    public final void e1(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.i = callback;
    }

    public final void f1(m config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.g.setValue(config);
    }

    public final void T0(t0 item) {
        Intrinsics.checkNotNullParameter(item, "item");
        U0(item);
        V0();
        a1("nps");
    }

    public void a1(String str) {
        String str2;
        if (str == null) {
            str2 = "show_unlimited_content";
        } else {
            str2 = "click_unlimited_content";
        }
        Args Q0 = Q0();
        if (str != null) {
            Q0.put("click_to", str);
        }
        ReportManager.onReport(str2, Q0);
    }

    private final String W0(t0 t0Var) {
        UserResearchOptionInfo optionInfos;
        Map map;
        String str;
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
        if (doubleColSimilarNpsModel != null && (optionInfos = doubleColSimilarNpsModel.getOptionInfos()) != null && (map = optionInfos.scoreRecTextMap) != null && (str = (String) CollectionKt.getOrNull(map, Integer.valueOf(t0Var.a))) != null) {
            return str;
        }
        String string = App.context().getString(2131106828);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // jk4.o1
    public void X(String editContent) {
        String str;
        Intrinsics.checkNotNullParameter(editContent, "editContent");
        g1();
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
        if (doubleColSimilarNpsModel == null || (str = doubleColSimilarNpsModel.getResearchId()) == null) {
            str = "";
        }
        BusProvider.post(new zy2.a(str));
        c1();
        Y0(editContent);
    }

    private final List<t0> X0(UserResearchOptionInfo userResearchOptionInfo) {
        List list;
        if (userResearchOptionInfo != null) {
            list = userResearchOptionInfo.optionsName;
        } else {
            list = null;
        }
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List optionsName = userResearchOptionInfo.optionsName;
        Intrinsics.checkNotNullExpressionValue(optionsName, "optionsName");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(optionsName, 10));
        int i = 0;
        for (Object obj : optionsName) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            Intrinsics.checkNotNull(str);
            arrayList.add(new t0(i, str, SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null)));
            i = i2;
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
    
        if (r7 == true) goto L17;
     */
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F0(com.dragon.read.kmp.nps.DoubleColSimilarNpsModel r12) {
        /*
            r11 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r11.f = r12
            kotlinx.coroutines.flow.MutableStateFlow r0 = r11.I0()
        Lb:
            java.lang.Object r1 = r0.getValue()
            r2 = r1
            jk4.f1 r2 = (jk4.f1) r2
            java.lang.String r3 = r12.getResearchTitle()
            com.dragon.read.rpc.model.UserResearchOptionInfo r4 = r12.getOptionInfos()
            java.util.List r4 = r11.X0(r4)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
            r6 = 0
            r7 = 0
        L29:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L5b
            java.lang.Object r8 = r4.next()
            int r9 = r7 + 1
            if (r7 >= 0) goto L3a
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L3a:
            r10 = r8
            jk4.t0 r10 = (jk4.t0) r10
            com.dragon.read.rpc.model.UserResearchOptionInfo r10 = r12.getOptionInfos()
            if (r10 == 0) goto L53
            java.util.List r10 = r10.outerOptionIndex
            if (r10 == 0) goto L53
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r7 = r10.contains(r7)
            r10 = 1
            if (r7 != r10) goto L53
            goto L54
        L53:
            r10 = 0
        L54:
            if (r10 == 0) goto L59
            r5.add(r8)
        L59:
            r7 = r9
            goto L29
        L5b:
            com.dragon.read.rpc.model.UserResearchOptionInfo r4 = r12.getOptionInfos()
            java.util.List r4 = r11.X0(r4)
            jk4.f1 r2 = r2.a(r3, r5, r4)
            boolean r1 = r0.compareAndSet(r1, r2)
            if (r1 == 0) goto Lb
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jk4.q1.F0(com.dragon.read.kmp.nps.DoubleColSimilarNpsModel):void");
    }

    protected void Y0(String editContent) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(editContent, "editContent");
        Args P0 = P0();
        Iterator<T> it2 = ((f1) I0().getValue()).c.iterator();
        while (true) {
            str = null;
            if (it2.hasNext()) {
                obj = it2.next();
                if (((Boolean) ((t0) obj).c.getValue()).booleanValue()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        t0 t0Var = (t0) obj;
        if (t0Var != null) {
            str = t0Var.b;
        }
        P0.put("submit_content", str);
        ReportManager.onReport("nps_query_score_result", P0);
        P0.put("reason", editContent);
        ReportManager.onReport("nps_query_reason_result", P0);
    }

    @Override // jk4.o1
    public void j(s0 data) {
        Object value;
        f1 f1Var;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(data, "data");
        MutableStateFlow I0 = I0();
        do {
            value = I0.getValue();
            f1Var = (f1) value;
            List<t0> list = f1Var.c;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (t0 t0Var : list) {
                if (t0Var.a == data.a) {
                    t0Var.c.setValue(Boolean.TRUE);
                } else {
                    t0Var.c.setValue(Boolean.FALSE);
                }
                arrayList.add(t0Var);
            }
        } while (!I0.compareAndSet(value, f1.b(f1Var, null, null, arrayList, 3, null)));
    }

    protected final void U0(t0 t0Var) {
        Object value;
        f1 f1Var;
        ArrayList arrayList;
        Object value2;
        f1 f1Var2;
        ArrayList arrayList2;
        if (t0Var == null) {
            MutableStateFlow I0 = I0();
            do {
                value2 = I0.getValue();
                f1Var2 = (f1) value2;
                List<t0> list = f1Var2.c;
                arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                for (t0 t0Var2 : list) {
                    t0Var2.c.setValue(Boolean.FALSE);
                    arrayList2.add(t0Var2);
                }
            } while (!I0.compareAndSet(value2, f1.b(f1Var2, null, null, arrayList2, 3, null)));
            return;
        }
        MutableStateFlow I02 = I0();
        do {
            value = I02.getValue();
            f1Var = (f1) value;
            List<t0> list2 = f1Var.c;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            for (t0 t0Var3 : list2) {
                if (t0Var3.a == t0Var.a) {
                    t0Var3.c.setValue(Boolean.TRUE);
                } else {
                    t0Var3.c.setValue(Boolean.FALSE);
                }
                arrayList.add(t0Var3);
            }
        } while (!I02.compareAndSet(value, f1.b(f1Var, null, null, arrayList, 3, null)));
    }

    public static /* synthetic */ void b1(q1 q1Var, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            q1Var.a1(str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportUnlimitedEvent");
    }
}
