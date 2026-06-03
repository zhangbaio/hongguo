package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SaasVoteOptionData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("option_id")
    public String optionID;

    @SerializedName("user_vote")
    public boolean userVote;

    @SerializedName("vote_count")
    public int voteCount;

    static {
        Covode.recordClassIndex(613386);
        fieldTypeClassRef = FieldType.class;
    }
}
