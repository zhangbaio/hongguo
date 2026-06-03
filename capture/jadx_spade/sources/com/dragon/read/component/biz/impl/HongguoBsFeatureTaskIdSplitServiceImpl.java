package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.impl.brickservice.BsFeatureTaskIdSplitService;
import java.util.LinkedHashMap;
import java.util.Map;
import kx4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongguoBsFeatureTaskIdSplitServiceImpl implements BsFeatureTaskIdSplitService {
    public static final int $stable;
    private final Map<String, b> compatibleTasksMap;

    static {
        Covode.recordClassIndex(588076);
        $stable = 8;
    }

    public boolean supportOldUserRedPacket() {
        return true;
    }

    public Map<String, b> getCompatibleTasksMap() {
        return this.compatibleTasksMap;
    }

    public HongguoBsFeatureTaskIdSplitServiceImpl() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.compatibleTasksMap = linkedHashMap;
        linkedHashMap.put("redpack", new b("redpack", new String[]{"lost_return_redpack"}));
        linkedHashMap.put("take_cash_100", new b("take_cash_100", new String[]{"lost_return_take_cash_100"}));
        linkedHashMap.put("continue_short_video", new b("continue_short_video", new String[]{"old_user_continue_short_video"}));
        linkedHashMap.put("continue_read", new b("continue_read", new String[]{"old_user_continue_read"}));
        linkedHashMap.put("new_user_signin_v2", new b("new_user_signin_v2", new String[]{"lost_return_user_signin"}));
    }
}
