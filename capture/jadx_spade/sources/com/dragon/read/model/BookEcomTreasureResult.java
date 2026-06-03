package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BookEcomTreasureResult implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;

    @SerializedName("amount_type")
    public String amountType;
    public BroadcastInfo broadcast;

    @SerializedName("cur_time")
    public long curTime;

    @SerializedName("have_toast")
    public boolean haveToast;

    @SerializedName("new_excitation_ad")
    public ExcitationAd newExcitationAd;

    @SerializedName("next_time")
    public long nextTime;

    @SerializedName("treasure_detail")
    public BookEcomTreasureDetailData treasureDetail;

    static {
        Covode.recordClassIndex(612035);
        fieldTypeClassRef = FieldType.class;
    }
}
