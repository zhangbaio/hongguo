package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AddSpeakVoteRequest implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public String title;

    @SerializedName("view_list")
    @RpcField(FieldType.BODY)
    public String viewList;

    @SerializedName("vote_type")
    @RpcField(FieldType.BODY)
    public SpeakVoteType voteType;

    static {
        Covode.recordClassIndex(612711);
        fieldTypeClassRef = FieldType.class;
    }
}
