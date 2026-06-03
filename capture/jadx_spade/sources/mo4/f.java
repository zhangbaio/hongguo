package mo4;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.kotlin.StringKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public static final f a;

    static {
        Covode.recordClassIndex(609095);
        a = new f();
    }

    private f() {
    }

    public final void a(com.bytedance.router.c routeIntent) {
        Bundle extras;
        Intrinsics.checkNotNullParameter(routeIntent, "routeIntent");
        Intent intent = routeIntent.b;
        if (intent != null && (extras = intent.getExtras()) != null) {
            String string = extras.getString("selected_items", "");
            String string2 = extras.getString("stick_ids");
            String string3 = extras.getString("session_id");
            String string4 = extras.getString("sub_selected_items");
            String string5 = extras.getString("panel_selected_items");
            String string6 = extras.getString("background_selected_items");
            String string7 = extras.getString("celebrity_user_id");
            String string8 = extras.getString("rank_version");
            LogWrapper.info("KmpShortSeriesRankingPreloadHelper", "preloadRankingData selectedItems=" + string + ", subSelectedItems=" + string4 + ", panelSelectedItems=" + string5 + ", backgroundSelectedItems=" + string6 + ", stickIds=" + string2 + ", sessionId=" + string3 + ", celebrityUserId=" + string7 + ", rankVersion=" + string8, new Object[0]);
            boolean isNotNullOrEmpty = StringKt.isNotNullOrEmpty(extras.getString("interact_topic_page_entrance"));
            Intrinsics.checkNotNull(string);
            int c = gz4.a.c(new e(string, string4, string5, string6, string2, string3, isNotNullOrEmpty, string7, string8));
            Intent intent2 = routeIntent.b;
            if (intent2 != null) {
                intent2.putExtra("key_preloader_id", c);
            }
        }
    }
}
