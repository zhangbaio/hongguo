package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AwardNode implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int award;

    @SerializedName("award_type")
    public String awardType;

    @SerializedName("collect_status")
    public int collectStatus;

    @SerializedName("collected_amount")
    public int collectedAmount;

    @SerializedName("is_genre_transfer_double")
    public boolean isGenreTransferDouble;

    @SerializedName("is_gold_redpack")
    public boolean isGoldRedpack;

    @SerializedName("new_video_collected_amount")
    public int newVideoCollectedAmount;

    static {
        Covode.recordClassIndex(612016);
        fieldTypeClassRef = FieldType.class;
    }
}
