package jk4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.kmp.nps.DoubleColSimilarNpsModel;
import com.dragon.read.report.ReportManager;
import com.dragon.read.rpc.model.UserResearchOptionInfo;
import com.dragon.read.util.kotlin.ContextKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y extends q1 {
    public static final int l;
    public String k;

    static {
        Covode.recordClassIndex(607876);
        l = 8;
    }

    @Override // jk4.q1
    public void R0() {
        U0(null);
        V0();
        a1("nps");
        Z0();
    }

    @Override // jk4.q1
    protected void V0() {
        new v(ContextKt.getCurrentContext(), this).show();
    }

    @Override // jk4.q1
    public void Z0() {
        ReportManager.onReport("nps_query_show", P0());
    }

    @Override // jk4.q1
    protected Args P0() {
        String str;
        Args args = new Args();
        args.put("position", "related_content");
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
        if (doubleColSimilarNpsModel != null) {
            str = doubleColSimilarNpsModel.getResearchId();
        } else {
            str = null;
        }
        args.put("research_id", str);
        args.put("research_title", ((f1) I0().getValue()).a);
        args.put("nps_type", "questionnaire_for_video_detail_page");
        args.put("src_material_id", this.k);
        return args;
    }

    @Override // jk4.q1, jk4.o1
    public UserResearchOptionInfo S() {
        Map<String, UserResearchOptionInfo> scoreOptionInfo;
        Object obj;
        int i;
        List split$default;
        Integer intOrNull;
        DoubleColSimilarNpsModel doubleColSimilarNpsModel = this.f;
        if (doubleColSimilarNpsModel == null || (scoreOptionInfo = doubleColSimilarNpsModel.getScoreOptionInfo()) == null || scoreOptionInfo.isEmpty()) {
            return null;
        }
        Iterator<T> it2 = ((f1) I0().getValue()).c.iterator();
        while (true) {
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
            i = t0Var.a;
        } else {
            i = 2;
        }
        for (Map.Entry<String, UserResearchOptionInfo> entry : scoreOptionInfo.entrySet()) {
            String key = entry.getKey();
            UserResearchOptionInfo value = entry.getValue();
            split$default = StringsKt__StringsKt.split$default((CharSequence) key, new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it4 = split$default.iterator();
            while (it4.hasNext()) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(StringsKt__StringsKt.trim((CharSequence) it4.next()).toString());
                if (intOrNull != null) {
                    arrayList.add(intOrNull);
                }
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                if (((Number) it5.next()).intValue() == i) {
                    return value;
                }
            }
        }
        return null;
    }

    @Override // jk4.q1, jk4.o1
    public void W(List<String> editContent) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(editContent, "editContent");
        g1();
        c1();
        M0();
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
        Iterator<T> it4 = editContent.iterator();
        while (it4.hasNext()) {
            P0.put("reason", (String) it4.next());
            ReportManager.onReport("nps_query_reason_result", P0);
        }
    }
}
