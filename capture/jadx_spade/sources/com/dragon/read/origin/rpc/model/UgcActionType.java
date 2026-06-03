package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcActionType {
    Dislike(1),
    CancelDislike(2),
    Like(3),
    CancelLike(4),
    Create(5),
    Reply(6),
    Digg(7),
    Agree(8),
    CancelAgree(9),
    Disagree(10),
    CancelDisagree(11),
    Follow(12),
    Urge(13),
    UnDigg(14),
    Correct(15),
    Fold(16),
    CancelFold(17),
    Select(18),
    CancelSelect(19),
    UserUrge(20),
    CancelUserUrge(21),
    Favorite(22),
    CancelFavorite(23),
    CalcelFollow(24),
    Subscribe(25),
    CancelSubscribe(26),
    Privacy(27),
    Block(28),
    CancelBlock(29),
    Reserve(30),
    CancelReserve(31),
    AddOne(32),
    CancelAddOne(33),
    FollowUpdate(34),
    CancelFollowUpdate(35),
    ItemInteractionClick(36);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613490);
    }

    public static UgcActionType findByValue(int i) {
        switch (i) {
            case 1:
                return Dislike;
            case 2:
                return CancelDislike;
            case 3:
                return Like;
            case 4:
                return CancelLike;
            case 5:
                return Create;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Reply;
            case 7:
                return Digg;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return Agree;
            case 9:
                return CancelAgree;
            case 10:
                return Disagree;
            case 11:
                return CancelDisagree;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return Follow;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return Urge;
            case 14:
                return UnDigg;
            case 15:
                return Correct;
            case 16:
                return Fold;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return CancelFold;
            case 18:
                return Select;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return CancelSelect;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                return UserUrge;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                return CancelUserUrge;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                return Favorite;
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                return CancelFavorite;
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                return CalcelFollow;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                return Subscribe;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                return CancelSubscribe;
            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                return Privacy;
            case 28:
                return Block;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                return CancelBlock;
            case 30:
                return Reserve;
            case 31:
                return CancelReserve;
            case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                return AddOne;
            case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                return CancelAddOne;
            case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                return FollowUpdate;
            case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                return CancelFollowUpdate;
            case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                return ItemInteractionClick;
            default:
                return null;
        }
    }

    UgcActionType(int i) {
        this.value = i;
    }
}
