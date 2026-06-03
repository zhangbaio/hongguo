package com.dragon.read.kmp.vip.impl.ui.stickerManage;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.yu;
import com.dragon.read.kmp.utils.ListUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(609616);
        a = new a();
    }

    private a() {
    }

    public final yu a(List<yu> list, int i) {
        if (i != -1 && !ListUtils.INSTANCE.isEmpty(list)) {
            Intrinsics.checkNotNull(list);
            for (yu yuVar : list) {
                Integer num = yuVar.a;
                if (num != null && i == num.intValue()) {
                    return yuVar;
                }
            }
        }
        return null;
    }
}
