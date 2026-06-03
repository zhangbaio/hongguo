package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TaskListExtra implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("pendant_strip_conf")
    public PendantStrip pendantStripConf;

    @SerializedName("reader_bubble_configs")
    public List<BubbleConfig> readerBubbleConfigs;

    static {
        Covode.recordClassIndex(612274);
        fieldTypeClassRef = FieldType.class;
    }
}
