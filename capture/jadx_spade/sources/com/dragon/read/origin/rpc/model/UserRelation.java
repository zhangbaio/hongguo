package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserRelation implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("block_relation_type")
    public UserRelationType blockRelationType;

    @SerializedName("can_follow")
    public boolean canFollow;

    @SerializedName("fans_num")
    public int fansNum;

    @SerializedName("follow_user_num")
    public int followUserNum;

    @SerializedName("interactive_stats")
    public Map<String, String> interactiveStats;

    @SerializedName("is_top_consume")
    public boolean isTopConsume;

    @SerializedName("recv_digged_count")
    public int recvDiggedCount;

    @SerializedName("relation_type")
    public UserRelationType relationType;

    static {
        Covode.recordClassIndex(613558);
        fieldTypeClassRef = FieldType.class;
    }
}
