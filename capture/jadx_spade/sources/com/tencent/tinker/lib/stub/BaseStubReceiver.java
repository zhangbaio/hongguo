package com.tencent.tinker.lib.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import com.bytedance.covode.number.Covode;
import com.tencent.tinker.lib.MuteLog;
import com.tencent.tinker.lib.MuteMaxLoader;
import com.tencent.tinker.lib.am.PatchActivityManager;
import com.tencent.tinker.lib.utils.ProcessUtil;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class BaseStubReceiver extends BroadcastReceiver {

    public static final class CodeConst {
        static {
            Covode.recordClassIndex(653822);
        }
    }

    static {
        Covode.recordClassIndex(653821);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MuteLog.i("Mute.BaseStubRcv", "onReceive %s, proc[%s]", intent, ProcessUtil.getProcName(context));
        Intent intent2 = (Intent) intent.getParcelableExtra("mute_target_intent");
        ActivityInfo activityInfo = (ActivityInfo) intent.getParcelableExtra("mute_target_receiver_info");
        ActivityInfo activityInfo2 = (ActivityInfo) intent.getParcelableExtra("mute_stub_receiver_info");
        try {
            ((BroadcastReceiver) MuteMaxLoader.class.getClassLoader().loadClass(activityInfo.name).newInstance()).onReceive(context, intent2);
            PatchActivityManager.receiverFinished(activityInfo2, activityInfo);
        } catch (Exception e) {
            MuteLog.e("Mute.BaseStubRcv", "onReceive failed, %s", e);
        }
    }
}
