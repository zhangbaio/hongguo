package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum GoldBoxPageType {
    Online(0),
    NewUserSignIn(1),
    NewUserTasks(2),
    RegularUser(3),
    Reader(4),
    NewUserLow(5),
    NewUserHigh(6),
    Comic(7),
    Listen(8),
    Video(9),
    NewTaskModule(10);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612117);
    }

    public static GoldBoxPageType findByValue(int i) {
        switch (i) {
            case 0:
                return Online;
            case 1:
                return NewUserSignIn;
            case 2:
                return NewUserTasks;
            case 3:
                return RegularUser;
            case 4:
                return Reader;
            case 5:
                return NewUserLow;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return NewUserHigh;
            case 7:
                return Comic;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return Listen;
            case 9:
                return Video;
            case 10:
                return NewTaskModule;
            default:
                return null;
        }
    }

    GoldBoxPageType(int i) {
        this.value = i;
    }
}
