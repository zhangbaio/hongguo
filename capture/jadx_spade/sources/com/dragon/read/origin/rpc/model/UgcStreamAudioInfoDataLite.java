package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcStreamAudioInfoDataLite implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("audio_datas")
    public List<UgcStreamAudioFileDataLite> audioDatas;

    @SerializedName("is_end")
    public boolean isEnd;

    @SerializedName("predict_audio_duration_ms")
    public long predictAudioDurationMS;

    @SerializedName("req_gap_ms")
    public long reqGapMS;

    @SerializedName("task_id")
    public String taskID;

    static {
        Covode.recordClassIndex(613526);
        fieldTypeClassRef = FieldType.class;
    }
}
