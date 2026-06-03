package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PositionInfoV2 implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("end_container_index")
    public int endContainerIndex;

    @SerializedName("end_element_index")
    public int endElementIndex;

    @SerializedName("end_element_offset")
    public int endElementOffset;

    @SerializedName("order_info_v2")
    public OrderInfo orderInfoV2;

    @SerializedName("start_container_index")
    public int startContainerIndex;

    @SerializedName("start_element_index")
    public int startElementIndex;

    @SerializedName("start_element_offset")
    public int startElementOffset;

    static {
        Covode.recordClassIndex(613309);
        fieldTypeClassRef = FieldType.class;
    }
}
