package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcNovelCommentType {
    UserActualComment(0),
    ColdStartComment(1),
    OperatorAddComment(2),
    AuthorSpeak(3),
    OtherCircle(4),
    InCircle(5),
    ColdStartParaComment(6),
    ColdStartUgcTopicComment(7),
    AuthorMessage(8),
    AuthorThanksMessage(9),
    MomentColdStartComment(10),
    PersuadeComment(11),
    AbuseComment(12),
    PlayTerrierComment(13),
    CommentMigration(14),
    DisLikeComment(16),
    OfficialComment(17),
    ProduceAbtestComment(18),
    CategoryProduceAbtestComment(19),
    ProduceRecommendAbtestComment(23),
    LaoBaiComment(24),
    NotSafeBookComment(25),
    ModelPersuadeComment(26),
    WanGenComment(27),
    FemaleLaoBaiComment(28),
    ReplyModelComment(30),
    RudelyModelComment(31),
    WaterArmyComment(33),
    FastComment(34),
    ProducePublishComment(35),
    ComicsComment(36),
    PublishComment(37),
    AudioComment(38),
    ConteComment(39),
    StoryComment(40),
    OutOfOrderComment(50),
    JinJiangFengComment(51);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613514);
    }

    public static UgcNovelCommentType findByValue(int i) {
        switch (i) {
            case 0:
                return UserActualComment;
            case 1:
                return ColdStartComment;
            case 2:
                return OperatorAddComment;
            case 3:
                return AuthorSpeak;
            case 4:
                return OtherCircle;
            case 5:
                return InCircle;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return ColdStartParaComment;
            case 7:
                return ColdStartUgcTopicComment;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return AuthorMessage;
            case 9:
                return AuthorThanksMessage;
            case 10:
                return MomentColdStartComment;
            case 11:
                return PersuadeComment;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return AbuseComment;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return PlayTerrierComment;
            case 14:
                return CommentMigration;
            case 15:
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
            case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
            case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            default:
                return null;
            case 16:
                return DisLikeComment;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return OfficialComment;
            case 18:
                return ProduceAbtestComment;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return CategoryProduceAbtestComment;
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                return ProduceRecommendAbtestComment;
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                return LaoBaiComment;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                return NotSafeBookComment;
            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                return ModelPersuadeComment;
            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                return WanGenComment;
            case 28:
                return FemaleLaoBaiComment;
            case 30:
                return ReplyModelComment;
            case 31:
                return RudelyModelComment;
            case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                return WaterArmyComment;
            case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                return FastComment;
            case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                return ProducePublishComment;
            case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                return ComicsComment;
            case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                return PublishComment;
            case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                return AudioComment;
            case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                return ConteComment;
            case 40:
                return StoryComment;
            case 50:
                return OutOfOrderComment;
            case IVideoEventLogger.LOGGER_OPTION_ENABLE_PLAYER_DEGRADE /* 51 */:
                return JinJiangFengComment;
        }
    }

    UgcNovelCommentType(int i) {
        this.value = i;
    }
}
