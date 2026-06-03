package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public enum gg {
    DeviceInfo(1),
    AppInstallList(2),
    AppActiveList(3),
    Bluetooth(4),
    Location(5),
    Account(6),
    WIFI(7),
    Cellular(8),
    TopApp(9),
    BroadcastAction(10),
    BroadcastActionAdded(11),
    BroadcastActionRemoved(12),
    BroadcastActionReplaced(13),
    BroadcastActionDataCleared(14),
    BroadcastActionRestarted(15),
    BroadcastActionChanged(16),
    AppPermission(17),
    WifiDevicesMac(18),
    ActivityActiveTimeStamp(19),
    DeviceBaseInfo(20),
    DeviceInfoV2(21),
    Battery(22),
    Storage(23),
    AppIsInstalled(24);


    /* renamed from: a, reason: collision with other field name */
    private final int f496a;

    public int a() {
        return this.f496a;
    }

    static {
        Covode.recordClassIndex(655556);
    }

    public static gg a(int i) {
        switch (i) {
            case 1:
                return DeviceInfo;
            case 2:
                return AppInstallList;
            case 3:
                return AppActiveList;
            case 4:
                return Bluetooth;
            case 5:
                return Location;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return Account;
            case 7:
                return WIFI;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return Cellular;
            case 9:
                return TopApp;
            case 10:
                return BroadcastAction;
            case 11:
                return BroadcastActionAdded;
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                return BroadcastActionRemoved;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return BroadcastActionReplaced;
            case 14:
                return BroadcastActionDataCleared;
            case 15:
                return BroadcastActionRestarted;
            case 16:
                return BroadcastActionChanged;
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return AppPermission;
            case 18:
                return WifiDevicesMac;
            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                return ActivityActiveTimeStamp;
            case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                return DeviceBaseInfo;
            case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                return DeviceInfoV2;
            case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                return Battery;
            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                return Storage;
            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                return AppIsInstalled;
            default:
                return null;
        }
    }

    gg(int i) {
        this.f496a = i;
    }
}
