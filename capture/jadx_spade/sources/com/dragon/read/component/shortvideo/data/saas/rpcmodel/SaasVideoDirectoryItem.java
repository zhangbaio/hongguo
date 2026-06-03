package com.dragon.read.component.shortvideo.data.saas.rpcmodel;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import seriessdk.com.dragon.read.saas.rpc.model.VideoWaitFreeConfig;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaasVideoDirectoryItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("need_unlock")
    public boolean needUnlock;

    @SerializedName("trial_duration")
    public long trialDuration;

    @SerializedName("video_id")
    public String videoId;

    @SerializedName("wait_free")
    public VideoWaitFreeConfig waitFree;

    static {
        Covode.recordClassIndex(599107);
        fieldTypeClassRef = FieldType.class;
    }
}
