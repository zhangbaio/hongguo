package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AuthorSpeak implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("can_delete")
    public boolean canDelete;

    @SerializedName("can_modify")
    public boolean canModify;
    public String content;

    @SerializedName("refuse_reason")
    public List<AuthorSpeakRefuseType> refuseReason;

    @SerializedName("speak_id")
    public String speakID;

    @SerializedName("speak_status")
    public SpeakStatus speakStatus;

    @SerializedName("speak_type")
    public SpeakType speakType;

    @SerializedName("vote_info")
    public AuthorSpeakVoteInfo voteInfo;

    static {
        Covode.recordClassIndex(612756);
        fieldTypeClassRef = FieldType.class;
    }
}
