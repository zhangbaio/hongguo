package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcActionObjectType {
    User(1),
    Comment(2),
    Topic(3),
    Post(4),
    Forum(5),
    Item(6),
    DouyinVideo(7),
    Reply(8),
    DouyinUser(9),
    Book(10),
    Category(11),
    UgcVideo(12),
    Author(13),
    BookEndForum(14),
    MaterialVideo(15),
    VideoSeriesPost(16),
    AdvertiseCreative(17),
    MissingVideo(18),
    WishVideo(19),
    FamousScene(20),
    Danmaku(21),
    ItemInteraction(22);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613488);
    }

    public static UgcActionObjectType findByValue(int i) {
        switch (i) {
            case 1:
                return User;
            case 2:
                return Comment;
            case 3:
                return Topic;
            case 4:
                return Post;
            case 5:
                return Forum;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Item;
            case 7:
                return DouyinVideo;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return Reply;
            case 9:
                return DouyinUser;
            case 10:
                return Book;
            case 11:
                return Category;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return UgcVideo;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return Author;
            case 14:
                return BookEndForum;
            case 15:
                return MaterialVideo;
            case 16:
                return VideoSeriesPost;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return AdvertiseCreative;
            case 18:
                return MissingVideo;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return WishVideo;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                return FamousScene;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                return Danmaku;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                return ItemInteraction;
            default:
                return null;
        }
    }

    UgcActionObjectType(int i) {
        this.value = i;
    }
}
