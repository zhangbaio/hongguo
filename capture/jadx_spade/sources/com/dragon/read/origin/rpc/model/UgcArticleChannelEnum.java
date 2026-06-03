package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcArticleChannelEnum {
    None(0),
    DiggActionChannel(1),
    CollectActionChannel(2),
    AllActionChannel(3),
    DiggAdvertiseCreativeActionChannel(4),
    ReserveMissDocAction(5),
    ReserveWishDocAction(6),
    ItemMixedChannel(7),
    PublishedMissDocChannel(8),
    FollowedUpdateChannel(9);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613492);
    }

    public static UgcArticleChannelEnum findByValue(int i) {
        switch (i) {
            case 0:
                return None;
            case 1:
                return DiggActionChannel;
            case 2:
                return CollectActionChannel;
            case 3:
                return AllActionChannel;
            case 4:
                return DiggAdvertiseCreativeActionChannel;
            case 5:
                return ReserveMissDocAction;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return ReserveWishDocAction;
            case 7:
                return ItemMixedChannel;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return PublishedMissDocChannel;
            case 9:
                return FollowedUpdateChannel;
            default:
                return null;
        }
    }

    UgcArticleChannelEnum(int i) {
        this.value = i;
    }
}
