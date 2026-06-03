package com.ss.ttvideoengine.configcenter;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ConfigItemFactory {
    static {
        Covode.recordClassIndex(652407);
    }

    public static boolean isCommonPlayerOption(int i) {
        return i >= 40000 && i < 50000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0cec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.ss.ttvideoengine.configcenter.ConfigItem createIntOption(int r11, int r12) {
        /*
            Method dump skipped, instructions count: 5022
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.configcenter.ConfigItemFactory.createIntOption(int, int):com.ss.ttvideoengine.configcenter.ConfigItem");
    }

    public ConfigItem createLongOption(int i, long j) {
        if (isCommonPlayerOption(i)) {
            return new PlayerConfigItem(i, Long.valueOf(j), 2);
        }
        if (i != 709) {
            TTVideoEngineLog.w("ConfigItemFactory", "unknown option key: " + i + ", value: " + j);
            return null;
        }
        return new PlayerConfigItem(668, Long.valueOf(j), 2);
    }

    public ConfigItem createStringOption(int i, String str) {
        if (isCommonPlayerOption(i)) {
            return new PlayerConfigItem(i, str, 4);
        }
        if (i != 355) {
            if (i != 531) {
                if (i != 662) {
                    if (i != 1000) {
                        if (i != 360) {
                            if (i != 361) {
                                switch (i) {
                                    case 538:
                                    case 539:
                                    case 540:
                                        break;
                                    default:
                                        switch (i) {
                                            case 545:
                                            case 546:
                                            case 547:
                                                break;
                                            default:
                                                switch (i) {
                                                    case 1410:
                                                    case 1411:
                                                    case 1412:
                                                        break;
                                                    default:
                                                        TTVideoEngineLog.w("ConfigItemFactory", "unknown option key: " + i + ", value: " + str);
                                                        return null;
                                                }
                                        }
                                }
                            } else {
                                return new PlayerConfigItem(1162, str, 4, -1);
                            }
                        } else {
                            return new PlayerConfigItem(1161, str, 4, -1);
                        }
                    }
                } else {
                    return new PlayerConfigItem(202, str, 4, -1);
                }
            }
            return new EngineConfigItem(i, str, 4);
        }
        return new PlayerConfigItem(1158, str, 4, -1);
    }

    public ConfigItem createFloatOption(int i, float f) {
        if (isCommonPlayerOption(i)) {
            return new PlayerConfigItem(i, Float.valueOf(f), 3);
        }
        switch (i) {
            case 325:
                return new PlayerConfigItem(303, Float.valueOf(f), 3, -1);
            case 326:
                return new PlayerConfigItem(304, Float.valueOf(f), 3, -1);
            case 327:
                return new PlayerConfigItem(305, Float.valueOf(f), 3, -1);
            case 328:
                return new PlayerConfigItem(306, Float.valueOf(f), 3, -1);
            default:
                switch (i) {
                    case 344:
                        return new PlayerConfigItem(645, Float.valueOf(f), 3, -1);
                    case 345:
                        return new PlayerConfigItem(644, Float.valueOf(f), 3, -1);
                    case 346:
                        return new PlayerConfigItem(646, Float.valueOf(f), 3, -1);
                    case 347:
                        break;
                    case 348:
                        return new PlayerConfigItem(1151, Float.valueOf(f), 3, -1);
                    case 349:
                        return new PlayerConfigItem(1152, Float.valueOf(f), 3, -1);
                    case 350:
                        return new PlayerConfigItem(1153, Float.valueOf(f), 3, -1);
                    case 351:
                        return new PlayerConfigItem(1154, Float.valueOf(f), 3, -1);
                    case 352:
                        return new PlayerConfigItem(1155, Float.valueOf(f), 3, -1);
                    case 353:
                        return new PlayerConfigItem(1156, Float.valueOf(f), 3, -1);
                    case 354:
                        return new PlayerConfigItem(1157, Float.valueOf(f), 3, -1);
                    default:
                        switch (i) {
                            case 527:
                            case 528:
                            case 529:
                                break;
                            default:
                                TTVideoEngineLog.w("ConfigItemFactory", "unknown option key: " + i + ", value: " + f);
                                return null;
                        }
                }
                return new EngineConfigItem(i, Float.valueOf(f), 3);
        }
    }
}
