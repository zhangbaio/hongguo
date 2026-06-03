package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SaasUgcOriginType {
    BookForum(1),
    CategoryForum(2),
    BookStore(3),
    TagForum(4),
    UgcBottomTab(5),
    BookShelfCategoryForum(6),
    UgcStory(7),
    OpUgcBookList(8),
    OpActivityTopic(9),
    Unknown(999);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613383);
    }

    public static SaasUgcOriginType findByValue(int i) {
        if (i != 999) {
            switch (i) {
                case 1:
                    return BookForum;
                case 2:
                    return CategoryForum;
                case 3:
                    return BookStore;
                case 4:
                    return TagForum;
                case 5:
                    return UgcBottomTab;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return BookShelfCategoryForum;
                case 7:
                    return UgcStory;
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    return OpUgcBookList;
                case 9:
                    return OpActivityTopic;
                default:
                    return null;
            }
        }
        return Unknown;
    }

    SaasUgcOriginType(int i) {
        this.value = i;
    }
}
