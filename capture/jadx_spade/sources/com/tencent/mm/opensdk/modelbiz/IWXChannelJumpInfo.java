package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IWXChannelJumpInfo {
    boolean checkArgs();

    void serialize(Bundle bundle);

    int type();

    void unserialize(Bundle bundle);
}
