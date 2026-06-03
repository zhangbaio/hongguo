package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcTagType {
    MeaningLess(-1),
    UserProduct(1),
    UserChoose(2),
    ServiceProvide(3),
    ServiceSearch(4),
    ForumName(5),
    TagTopic(6),
    BindForumTag(7),
    UserChooseNew(20);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613530);
    }

    public static UgcTagType findByValue(int i) {
        if (i != -1) {
            if (i != 20) {
                switch (i) {
                    case 1:
                        return UserProduct;
                    case 2:
                        return UserChoose;
                    case 3:
                        return ServiceProvide;
                    case 4:
                        return ServiceSearch;
                    case 5:
                        return ForumName;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        return TagTopic;
                    case 7:
                        return BindForumTag;
                    default:
                        return null;
                }
            }
            return UserChooseNew;
        }
        return MeaningLess;
    }

    UgcTagType(int i) {
        this.value = i;
    }
}
