package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AuthorSpeakVoteInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String title;

    @SerializedName("view_list")
    public List<String> viewList;

    @SerializedName("vote_id")
    public String voteID;

    @SerializedName("vote_type")
    public SpeakVoteType voteType;

    static {
        Covode.recordClassIndex(612758);
        fieldTypeClassRef = FieldType.class;
    }
}
