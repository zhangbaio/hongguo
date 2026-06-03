package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserBaseInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("actor_id")
    public long actorID;

    @SerializedName("actor_id_str")
    public String actorIDStr;
    public String birthday;

    @SerializedName("biz_user_id")
    public String bizUserID;
    public String description;

    @SerializedName("douyin_sec_uid")
    public String douyinSecretUid;

    @SerializedName("encode_user_id")
    public String encodeUserID;

    @SerializedName("expand_user_avatar")
    public String expandUserAvatar;
    public int gender;

    @SerializedName("is_cancelled")
    public boolean isCancelled;

    @SerializedName("open_id")
    public String openID;

    @SerializedName("profile_gender")
    public int profileGender;

    @SerializedName("profile_user_type")
    public int profileUserType;
    public String region;
    public String school;

    @SerializedName("user_avatar")
    public String userAvatar;

    @SerializedName("user_id")
    public String userID;

    @SerializedName("user_name")
    public String userName;

    static {
        Covode.recordClassIndex(613552);
        fieldTypeClassRef = FieldType.class;
    }
}
