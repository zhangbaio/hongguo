package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ProduceTaskType {
    RecommendBook(1),
    BookForum(2),
    PraiseShare(3),
    Story(4),
    GameComic(5),
    Parent(6),
    Romance(7),
    Imagination(8),
    SuspenseAndMysterious(9),
    Image2Video(100),
    Text2Image(101),
    Text2MultiImage(102),
    Text2ImagePostCover(103),
    CommentSortEvaluationBatch(201),
    AIVideo(301);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613328);
    }

    public static ProduceTaskType findByValue(int i) {
        if (i != 201) {
            if (i != 301) {
                switch (i) {
                    case 1:
                        return RecommendBook;
                    case 2:
                        return BookForum;
                    case 3:
                        return PraiseShare;
                    case 4:
                        return Story;
                    case 5:
                        return GameComic;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        return Parent;
                    case 7:
                        return Romance;
                    case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                        return Imagination;
                    case 9:
                        return SuspenseAndMysterious;
                    default:
                        switch (i) {
                            case 100:
                                return Image2Video;
                            case 101:
                                return Text2Image;
                            case 102:
                                return Text2MultiImage;
                            case 103:
                                return Text2ImagePostCover;
                            default:
                                return null;
                        }
                }
            }
            return AIVideo;
        }
        return CommentSortEvaluationBatch;
    }

    ProduceTaskType(int i) {
        this.value = i;
    }
}
