package vs4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.OptionInfo;
import com.dragon.read.rpc.model.ResearchSceneType;
import com.dragon.read.rpc.model.UserResearch;
import com.dragon.read.rpc.model.UserResearchData;
import com.dragon.read.rpc.model.UserResearchOptionInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q {
    public static final q a;

    static {
        Covode.recordClassIndex(612551);
        a = new q();
    }

    private q() {
    }

    public final void a(UserResearch data, UserResearchData npsData, ResearchSceneType researchSceneType) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(npsData, "npsData");
        npsData.researchTitle = data.researchTitle;
        npsData.researchId = data.researchId;
        HashMap hashMap = new HashMap();
        Map scoreOptionInfo = data.scoreOptionInfo;
        Intrinsics.checkNotNullExpressionValue(scoreOptionInfo, "scoreOptionInfo");
        for (Map.Entry entry : scoreOptionInfo.entrySet()) {
            OptionInfo optionInfo = new OptionInfo();
            optionInfo.optionsName = ((UserResearchOptionInfo) entry.getValue()).optionsName;
            optionInfo.optionNameWithInput = ((UserResearchOptionInfo) entry.getValue()).optionNameWithInput;
            hashMap.put(entry.getKey(), optionInfo);
        }
        npsData.scoreOptionInfo = hashMap;
        npsData.scoreRemarks = data.scoreRemarks;
        npsData.sceneType = data.sceneType;
        if (researchSceneType != null) {
            npsData.scene = researchSceneType;
        }
    }

    public static /* synthetic */ void b(q qVar, UserResearch userResearch, UserResearchData userResearchData, ResearchSceneType researchSceneType, int i, Object obj) {
        if ((i & 4) != 0) {
            researchSceneType = null;
        }
        qVar.a(userResearch, userResearchData, researchSceneType);
    }
}
