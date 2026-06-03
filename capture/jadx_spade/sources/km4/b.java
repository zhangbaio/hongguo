package km4;

import cm4.i;
import com.bytedance.covode.number.Covode;
import ct2.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pv4.e;
import sm4.h;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements qm4.b {
    static {
        Covode.recordClassIndex(608474);
    }

    @Override // qm4.b
    public void a(i reader, List<h> list, List<String> orderList) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(orderList, "orderList");
        e.Z2.getUIService().j(reader, list);
        n.Z0.audioUiApi().j(reader, list);
        tb4.e.e3.a().j(reader, list);
        com.dragon.read.component.audio.biz.protocol.core.b bVar = com.dragon.read.component.audio.biz.protocol.core.b.a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("one_hand", "POLARIS_PROGRESS", "highlight", "intelligent_theme", "bottom_info", "bookmark", "status_bar", "auto_listen_read", "show_video_button", "motion_comic_auto_sync_setting", bVar.b(), bVar.a(), bVar.c(), "left_swipe_exit", "content_picture", "turn_page", "REWARD_TOAST", "read_progress", "lock_time", "read_status");
        orderList.clear();
        orderList.addAll(arrayListOf);
    }
}
