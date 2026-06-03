package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MultipleNameExperimentInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("condition_list")
    public List<MultipleNameExperimentCondition> conditionList;

    @SerializedName("confirm_type")
    public short confirmType;

    @SerializedName("end_time")
    public String endTime;

    @SerializedName("group_amount")
    public int groupAmount;

    @SerializedName("record_detail")
    public RecordDetail recordDetail;
    public String result;

    @SerializedName("result_produce_time")
    public String resultProduceTime;

    @SerializedName("start_word_number")
    public String startWordNumber;
    public short status;
    public short type;

    static {
        Covode.recordClassIndex(613245);
        fieldTypeClassRef = FieldType.class;
    }
}
