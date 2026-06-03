package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcUserInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("base_info")
    public UserBaseInfo baseInfo;

    @SerializedName("expand_extra")
    public Map<String, String> expandExtra;

    @SerializedName("user_expand")
    public UserExpand userExpand;

    @SerializedName("user_id")
    public String userID;

    @SerializedName("user_relation")
    public UserRelation userRelation;

    @SerializedName("user_stat")
    public UserStat userStat;

    @SerializedName("user_tag")
    public UserTag userTag;

    static {
        Covode.recordClassIndex(613532);
        fieldTypeClassRef = FieldType.class;
    }
}
