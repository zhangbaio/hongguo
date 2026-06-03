package un4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import kotlin.jvm.internal.Intrinsics;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class a extends bh1.b {
    public static final int i;
    public final yn4.b h;

    static {
        Covode.recordClassIndex(608931);
        i = 8;
    }

    public a(String scene, String entrance, String groupId, yn4.b bVar) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.h = bVar;
        e(scene);
        b(entrance);
        c(groupId);
    }
}
