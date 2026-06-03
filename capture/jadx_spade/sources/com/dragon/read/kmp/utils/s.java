package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s {
    static {
        Covode.recordClassIndex(609538);
    }

    public static final ProfileTab a(int i) {
        boolean z;
        for (ProfileTab profileTab : ProfileTab.values()) {
            if (profileTab.getValue() == i) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return profileTab;
            }
        }
        return null;
    }

    public static final VideoContentType b(int i) {
        boolean z;
        for (VideoContentType videoContentType : VideoContentType.values()) {
            if (videoContentType.getValue() == i) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return videoContentType;
            }
        }
        return null;
    }
}
