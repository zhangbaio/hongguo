package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AdminPermission {
    DELETE(1),
    SET_FEATURED(2),
    ADD_ORDINARY_IDEA_TO_OUTSHOW_CANDIDATE(3),
    KICK_OUTSHOW_IDEA(4),
    MUTE(5),
    STATUS_BE_MUTED(50),
    UGC_EditReport(100),
    UGC_ProduceTask(101),
    UGC_ProduceBookForumVideo(102),
    UGC_ProduceBookstoreVideo(103),
    UGC_AddBooklistPicture(104);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612724);
    }

    public static AdminPermission findByValue(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i != 50) {
                                switch (i) {
                                    case 100:
                                        return UGC_EditReport;
                                    case 101:
                                        return UGC_ProduceTask;
                                    case 102:
                                        return UGC_ProduceBookForumVideo;
                                    case 103:
                                        return UGC_ProduceBookstoreVideo;
                                    case 104:
                                        return UGC_AddBooklistPicture;
                                    default:
                                        return null;
                                }
                            }
                            return STATUS_BE_MUTED;
                        }
                        return MUTE;
                    }
                    return KICK_OUTSHOW_IDEA;
                }
                return ADD_ORDINARY_IDEA_TO_OUTSHOW_CANDIDATE;
            }
            return SET_FEATURED;
        }
        return DELETE;
    }

    AdminPermission(int i) {
        this.value = i;
    }
}
