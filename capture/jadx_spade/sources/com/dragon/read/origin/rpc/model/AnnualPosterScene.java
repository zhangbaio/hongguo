package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum AnnualPosterScene {
    Scene1_1_0(1100),
    Scene1_1_1(1101),
    Scene1_1_2(1102),
    Scene1_1_3(1103),
    Scene1_1_4(1104),
    Scene1_1_5(1105),
    Scene1_1_6(1106),
    Scene1_1_7(1107),
    Scene1_1_8(1108),
    Scene1_1_9(1109),
    Scene1_1_10(1110),
    Scene1_1_11(1111),
    Scene1_2_0(1200),
    Scene1_3_0(1300),
    Scene2_1_0(2100),
    Scene2_2_0(2200),
    Scene2_3_0(2300),
    Scene3_1_0(3100),
    Scene3_2_0(3200),
    Scene4_2_0(4200),
    Scene4_2_1(4201),
    Scene4_2_2(4202),
    Scene4_2_3(4203),
    Scene4_2_4(4204),
    Scene4_2_5(4205),
    Scene4_2_6(4206),
    Scene0_1_0(100),
    Scene0_2_0(200);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612731);
    }

    public static AnnualPosterScene findByValue(int i) {
        if (i != 100) {
            if (i != 200) {
                if (i != 1200) {
                    if (i != 1300) {
                        if (i != 2100) {
                            if (i != 2200) {
                                if (i != 2300) {
                                    if (i != 3100) {
                                        if (i != 3200) {
                                            switch (i) {
                                                case 1100:
                                                    return Scene1_1_0;
                                                case 1101:
                                                    return Scene1_1_1;
                                                case 1102:
                                                    return Scene1_1_2;
                                                case 1103:
                                                    return Scene1_1_3;
                                                case 1104:
                                                    return Scene1_1_4;
                                                case 1105:
                                                    return Scene1_1_5;
                                                case 1106:
                                                    return Scene1_1_6;
                                                case 1107:
                                                    return Scene1_1_7;
                                                case 1108:
                                                    return Scene1_1_8;
                                                case 1109:
                                                    return Scene1_1_9;
                                                case 1110:
                                                    return Scene1_1_10;
                                                case 1111:
                                                    return Scene1_1_11;
                                                default:
                                                    switch (i) {
                                                        case 4200:
                                                            return Scene4_2_0;
                                                        case 4201:
                                                            return Scene4_2_1;
                                                        case 4202:
                                                            return Scene4_2_2;
                                                        case 4203:
                                                            return Scene4_2_3;
                                                        case 4204:
                                                            return Scene4_2_4;
                                                        case 4205:
                                                            return Scene4_2_5;
                                                        case 4206:
                                                            return Scene4_2_6;
                                                        default:
                                                            return null;
                                                    }
                                            }
                                        }
                                        return Scene3_2_0;
                                    }
                                    return Scene3_1_0;
                                }
                                return Scene2_3_0;
                            }
                            return Scene2_2_0;
                        }
                        return Scene2_1_0;
                    }
                    return Scene1_3_0;
                }
                return Scene1_2_0;
            }
            return Scene0_2_0;
        }
        return Scene0_1_0;
    }

    AnnualPosterScene(int i) {
        this.value = i;
    }
}
