package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcCreatorType {
    Actor(1),
    Brand(2),
    Director(3),
    Writer(4),
    LeadingRole(5),
    SupportingRole(6),
    GuestAppearance(7),
    VoiceActor(8),
    ParticipateActor(9),
    Producer(10),
    Publisher(11);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613505);
    }

    public static UgcCreatorType findByValue(int i) {
        switch (i) {
            case 1:
                return Actor;
            case 2:
                return Brand;
            case 3:
                return Director;
            case 4:
                return Writer;
            case 5:
                return LeadingRole;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return SupportingRole;
            case 7:
                return GuestAppearance;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return VoiceActor;
            case 9:
                return ParticipateActor;
            case 10:
                return Producer;
            case 11:
                return Publisher;
            default:
                return null;
        }
    }

    UgcCreatorType(int i) {
        this.value = i;
    }
}
