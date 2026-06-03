package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AdjustChapter implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("can_adjust")
    public short canAdjust;

    @SerializedName("can_insert")
    public short canInsert;

    @SerializedName("correction_feedback_num")
    public int correctionFeedbackNum;

    @SerializedName("create_time")
    public String createTime;
    public int index;

    @SerializedName("item_id")
    public String itemID;
    public String title;

    @SerializedName("volume_id")
    public String volumeID;

    @SerializedName("word_number")
    public int wordNumber;

    static {
        Covode.recordClassIndex(612723);
        fieldTypeClassRef = FieldType.class;
    }
}
