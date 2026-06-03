package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class InvitePopInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("button_text")
    public String buttonText;
    public String content;

    @SerializedName("extra_content")
    public String extraContent;

    @SerializedName("friend_detail_list")
    public List<FriendDetail> friendDetailList;

    @SerializedName("invite_type")
    public String inviteType;

    @SerializedName("is_pop")
    public boolean isPop;

    @SerializedName("main_title")
    public String mainTitle;
    public Reward reward;
    public String title;

    static {
        Covode.recordClassIndex(612132);
        fieldTypeClassRef = FieldType.class;
    }
}
