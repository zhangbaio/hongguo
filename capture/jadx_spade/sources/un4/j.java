package un4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.jb0;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class j extends a {
    public static final int n;
    public final MutableStateFlow<String> j;
    public Function0<Unit> k;
    public Function0<h> l;
    public jb0 m;

    static {
        Covode.recordClassIndex(608940);
        n = 8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(String scene, String entrance, String groupId, yn4.b bVar) {
        super(scene, entrance, groupId, bVar);
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.j = StateFlowKt.MutableStateFlow("");
    }
}
