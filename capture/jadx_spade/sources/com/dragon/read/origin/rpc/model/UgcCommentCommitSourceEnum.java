package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCommentCommitSourceEnum {
    None(0),
    NovelBookCommentAdd(1),
    NovelParaCommentAdd(2),
    NovelItemCommentAdd(3),
    NovelUserSwitcher(4),
    NovlBookAdditionCommentAdd(5),
    NovelBookReplyAdd(6),
    NovelBookLevel2ReplyAdd(7),
    NovelParaReplyAdd(8),
    NovelItemReplyAdd(9),
    NovelPostCommentAdd(10),
    NovelPostReplyAdd(11),
    NovelPlayletCommentAdd(12),
    NovelPlayletReplyAdd(13),
    NovelMsgCenterReplyAdd(14),
    NovelAuthorTopicCommentAdd(15),
    NovelAuthorTopicReplyAdd(16),
    NovelStoreTopicReplyAdd(17),
    NovelStoreTopicLevel2ReplyAdd(18),
    NovelItemCommentAuthorStick(100),
    NovelAIGCParaCommentEditor(500),
    NovelAIGCPostEditor(501),
    NovelAIGCReader(502),
    NovelAIGCParaCommentReImage(503),
    NovelAIGCPostReImage(504),
    NovelAIGCTopicReImage(505),
    NovelAIGCStoryParaEditor(506),
    NovelAIGCStoryParaImage(TTVideoEngineInterface.PLAYER_OPTION_ABR_4GMAX_RESOULUTION_MODE),
    NovelAIGCStoryParaReImage(508),
    NovelAIGCParaPreProduce(509),
    NovelAIGCParaImageAndVideo(MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR),
    NovelAIGCParaVideo(MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME),
    NovelWebAIGCImage(MediaPlayer.MEDIA_PLAYER_OPTION_APPID),
    NovelAIGCActivity(MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_ID),
    NovelAIGCBookEndDoubleRow(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE),
    NovelAdvertiseCreativeItemCommentAdd(1000),
    NovelAdvertiseCreativeItemReplyAdd(1001),
    NovelItemDanmakuAdd(1500),
    NovelItemDanmakuReplyAdd(1501);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613498);
    }

    public static UgcCommentCommitSourceEnum findByValue(int i) {
        if (i != 100) {
            if (i != 1000) {
                if (i != 1001) {
                    if (i != 1500) {
                        if (i != 1501) {
                            switch (i) {
                                case 0:
                                    return None;
                                case 1:
                                    return NovelBookCommentAdd;
                                case 2:
                                    return NovelParaCommentAdd;
                                case 3:
                                    return NovelItemCommentAdd;
                                case 4:
                                    return NovelUserSwitcher;
                                case 5:
                                    return NovlBookAdditionCommentAdd;
                                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                                    return NovelBookReplyAdd;
                                case 7:
                                    return NovelBookLevel2ReplyAdd;
                                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                                    return NovelParaReplyAdd;
                                case 9:
                                    return NovelItemReplyAdd;
                                case 10:
                                    return NovelPostCommentAdd;
                                case 11:
                                    return NovelPostReplyAdd;
                                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                                    return NovelPlayletCommentAdd;
                                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                                    return NovelPlayletReplyAdd;
                                case 14:
                                    return NovelMsgCenterReplyAdd;
                                case 15:
                                    return NovelAuthorTopicCommentAdd;
                                case 16:
                                    return NovelAuthorTopicReplyAdd;
                                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                                    return NovelStoreTopicReplyAdd;
                                case 18:
                                    return NovelStoreTopicLevel2ReplyAdd;
                                default:
                                    switch (i) {
                                        case 500:
                                            return NovelAIGCParaCommentEditor;
                                        case 501:
                                            return NovelAIGCPostEditor;
                                        case 502:
                                            return NovelAIGCReader;
                                        case 503:
                                            return NovelAIGCParaCommentReImage;
                                        case 504:
                                            return NovelAIGCPostReImage;
                                        case 505:
                                            return NovelAIGCTopicReImage;
                                        case 506:
                                            return NovelAIGCStoryParaEditor;
                                        case TTVideoEngineInterface.PLAYER_OPTION_ABR_4GMAX_RESOULUTION_MODE /* 507 */:
                                            return NovelAIGCStoryParaImage;
                                        case 508:
                                            return NovelAIGCStoryParaReImage;
                                        case 509:
                                            return NovelAIGCParaPreProduce;
                                        case MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_DIR /* 510 */:
                                            return NovelAIGCParaImageAndVideo;
                                        case MediaPlayer.MEDIA_PLAYER_OPTION_LICENSE_FILENAME /* 511 */:
                                            return NovelAIGCParaVideo;
                                        case MediaPlayer.MEDIA_PLAYER_OPTION_APPID /* 512 */:
                                            return NovelWebAIGCImage;
                                        case MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_ID /* 513 */:
                                            return NovelAIGCActivity;
                                        case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE /* 514 */:
                                            return NovelAIGCBookEndDoubleRow;
                                        default:
                                            return null;
                                    }
                            }
                        }
                        return NovelItemDanmakuReplyAdd;
                    }
                    return NovelItemDanmakuAdd;
                }
                return NovelAdvertiseCreativeItemReplyAdd;
            }
            return NovelAdvertiseCreativeItemCommentAdd;
        }
        return NovelItemCommentAuthorStick;
    }

    UgcCommentCommitSourceEnum(int i) {
        this.value = i;
    }
}
