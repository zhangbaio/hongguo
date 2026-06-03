package com.dragon.read.component.biz.impl;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.AppRunningMode;
import com.dragon.read.base.ssconfig.template.BsHistoryRecommendFeedConfig;
import com.dragon.read.base.ssconfig.template.MineHistoryRecommendFeedConfig;
import com.dragon.read.component.biz.api.model.HistoryScene;
import com.dragon.read.util.a0;
import com.dragon.read.util.y;
import kotlin.jvm.internal.Intrinsics;
import ob2.j;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j0 {
    static {
        Covode.recordClassIndex(588070);
    }

    public static final i0 a(HistoryScene scene) {
        boolean z;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Activity currentActivity = ActivityRecordManager.inst().getCurrentActivity();
        if (currentActivity == null) {
            return new i0(false, 0, 0, 7, null);
        }
        int columnCount = ((y) new a0().getPlacement(currentActivity)).getColumnCount();
        if (!j.a.a()) {
            AppRunningMode appRunningMode = AppRunningMode.INSTANCE;
            if (!appRunningMode.isTeenMode() && !appRunningMode.isBasicMode() && NsCommonDepend.IMPL.privacyRecommendMgr().isNovelRecommendEnabledLazily()) {
                z = false;
                if (z && scene == HistoryScene.BOOKSHELF) {
                    BsHistoryRecommendFeedConfig.a aVar = BsHistoryRecommendFeedConfig.a;
                    return new i0(aVar.a().enableRecommendFeed, aVar.a().foldSizeBox * columnCount, aVar.a().foldSizeList);
                }
                if (z && scene == HistoryScene.MINE) {
                    MineHistoryRecommendFeedConfig.a aVar2 = MineHistoryRecommendFeedConfig.a;
                    return new i0(aVar2.a().enableRecommendFeed, aVar2.a().foldSizeBox * columnCount, aVar2.a().foldSizeList);
                }
                return new i0(false, 0, 0, 7, null);
            }
        }
        z = true;
        if (z) {
        }
        if (z) {
        }
        return new i0(false, 0, 0, 7, null);
    }
}
