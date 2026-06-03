package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaasVoteData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String content;

    @SerializedName("create_time")
    public int createTime;
    public String creator;

    @SerializedName("end_time")
    public int endTime;
    public boolean ending;

    @SerializedName("join_count")
    public int joinCount;
    public List<SaasVoteOptionData> options;

    @SerializedName("push_status")
    public int pushStatus;

    @SerializedName("start_time")
    public int startTime;
    public int status;
    public String title;

    @SerializedName("user_id")
    public String userID;

    @SerializedName("vote_id")
    public String voteID;

    @SerializedName("vote_type")
    public SaasVoteType voteType;

    static {
        Covode.recordClassIndex(613385);
        fieldTypeClassRef = FieldType.class;
    }
}
