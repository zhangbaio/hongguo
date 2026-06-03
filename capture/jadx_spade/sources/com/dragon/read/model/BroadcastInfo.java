package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BroadcastInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("audio_url")
    public String audioUrl;

    @SerializedName("enable_vibrate")
    public boolean enableVibrate;

    @SerializedName("gold_page_only")
    public boolean goldPageOnly;

    @SerializedName("is_open")
    public boolean isOpen;

    @SerializedName("support_mute_mode")
    public boolean supportMuteMode;

    static {
        Covode.recordClassIndex(612044);
        fieldTypeClassRef = FieldType.class;
    }
}
