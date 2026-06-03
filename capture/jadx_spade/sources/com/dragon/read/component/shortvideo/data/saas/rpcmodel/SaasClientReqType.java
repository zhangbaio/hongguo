package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum SaasClientReqType {
    Unknown(0),
    Refresh(1),
    LoadMore(2),
    Open(3),
    Other(4),
    InterestCallback(5),
    GenderRecover(6),
    FirstOpen(7),
    VideoFeedPreLoad(1024),
    VideoFeedExitApp(1025),
    PullRefresh(1026),
    MonitorRefresh(1027),
    ImmersiveConsumedRefresh(1031);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(599090);
    }

    public static SaasClientReqType findByValue(int i) {
        if (i != 1031) {
            switch (i) {
                case 0:
                    return Unknown;
                case 1:
                    return Refresh;
                case 2:
                    return LoadMore;
                case 3:
                    return Open;
                case 4:
                    return Other;
                case 5:
                    return InterestCallback;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return GenderRecover;
                case 7:
                    return FirstOpen;
                default:
                    switch (i) {
                        case 1024:
                            return VideoFeedPreLoad;
                        case 1025:
                            return VideoFeedExitApp;
                        case 1026:
                            return PullRefresh;
                        case 1027:
                            return MonitorRefresh;
                        default:
                            return null;
                    }
            }
        }
        return ImmersiveConsumedRefresh;
    }

    SaasClientReqType(int i) {
        this.value = i;
    }
}
