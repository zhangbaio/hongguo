package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.TTVideoEngineInterface;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ProduceTaskStatus {
    Pending(0),
    Runing(1),
    Stop(2),
    WaitingSettle(3),
    Fail(4),
    Deleted(5),
    AIGCVideoStoryboardFinish(100),
    AIGCAudioGenFinish(101),
    AIGCLiveImageGenFinish(102),
    AIGCVideoGenBeforeReady(103),
    AIGCVideoGenFinish(104),
    AIGCVideoFrameExtractFinish(105),
    AIGCVideoGenSucc(106),
    AIGCImageGenSucc(107),
    AIGCGenShotsSucc(108),
    AIGCGenCharactersDescSucc(109),
    AIGCText2ImageGenSucc(110),
    AIGCMultiImageGenSucc(TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE),
    CommentSortEvaluationSuccess(201),
    AIVideoGenSucc(301),
    AIVideoScriptGenSucc(302),
    AIVideoGenSuccPublished(303);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613327);
    }

    public static ProduceTaskStatus findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 201) {
                                    switch (i) {
                                        case 100:
                                            return AIGCVideoStoryboardFinish;
                                        case 101:
                                            return AIGCAudioGenFinish;
                                        case 102:
                                            return AIGCLiveImageGenFinish;
                                        case 103:
                                            return AIGCVideoGenBeforeReady;
                                        case 104:
                                            return AIGCVideoGenFinish;
                                        case 105:
                                            return AIGCVideoFrameExtractFinish;
                                        case 106:
                                            return AIGCVideoGenSucc;
                                        case 107:
                                            return AIGCImageGenSucc;
                                        case 108:
                                            return AIGCGenShotsSucc;
                                        case 109:
                                            return AIGCGenCharactersDescSucc;
                                        case 110:
                                            return AIGCText2ImageGenSucc;
                                        case TTVideoEngineInterface.PLAYER_OPTION_USE_PLAYER_SPADE /* 111 */:
                                            return AIGCMultiImageGenSucc;
                                        default:
                                            switch (i) {
                                                case 301:
                                                    return AIVideoGenSucc;
                                                case 302:
                                                    return AIVideoScriptGenSucc;
                                                case 303:
                                                    return AIVideoGenSuccPublished;
                                                default:
                                                    return null;
                                            }
                                    }
                                }
                                return CommentSortEvaluationSuccess;
                            }
                            return Deleted;
                        }
                        return Fail;
                    }
                    return WaitingSettle;
                }
                return Stop;
            }
            return Runing;
        }
        return Pending;
    }

    ProduceTaskStatus(int i) {
        this.value = i;
    }
}
