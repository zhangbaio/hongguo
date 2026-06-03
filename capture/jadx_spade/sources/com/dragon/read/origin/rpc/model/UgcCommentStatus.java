package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCommentStatus {
    CommentStatus_Unknonw(-1),
    CommentStatus_Delete(0),
    CommentStatus_AllVisible(1),
    CommentStatus_SelfVisible(2),
    CommentStatus_FriendVisible(3),
    CommentStatus_Publish(4),
    CommentStatus_Star(5),
    CommentStatus_UnProcessed(7),
    CommentStatus_PartVisible(8),
    CommentStatus_Draft(9);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613502);
    }

    public static UgcCommentStatus findByValue(int i) {
        switch (i) {
            case -1:
                return CommentStatus_Unknonw;
            case 0:
                return CommentStatus_Delete;
            case 1:
                return CommentStatus_AllVisible;
            case 2:
                return CommentStatus_SelfVisible;
            case 3:
                return CommentStatus_FriendVisible;
            case 4:
                return CommentStatus_Publish;
            case 5:
                return CommentStatus_Star;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            default:
                return null;
            case 7:
                return CommentStatus_UnProcessed;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return CommentStatus_PartVisible;
            case 9:
                return CommentStatus_Draft;
        }
    }

    UgcCommentStatus(int i) {
        this.value = i;
    }
}
