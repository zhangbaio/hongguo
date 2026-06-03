package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AvatarDecoration implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("add_context")
    public String addContext;
    public String attr;

    @SerializedName("bg_color")
    public String bgColor;

    @SerializedName("can_worn")
    public boolean canWorn;

    @SerializedName("config_init_context")
    public String configInitContext;

    @SerializedName("decoration_type")
    public String decorationType;

    @SerializedName("end_time")
    public int endTime;

    @SerializedName("id")
    public long iD;

    @SerializedName("is_expiration")
    public boolean isExpiration;

    @SerializedName("is_worning")
    public boolean isWorning;

    @SerializedName("jump_button")
    public String jumpButton;

    @SerializedName("jump_end_time")
    public int jumpEndTime;

    @SerializedName("jump_schema")
    public String jumpSchema;

    @SerializedName("jump_start_time")
    public int jumpStartTime;
    public String name;

    @SerializedName("small_url")
    public String smallUrl;

    @SerializedName("start_time")
    public int startTime;
    public String url;

    @SerializedName("user_get_time")
    public int userGetTime;

    static {
        Covode.recordClassIndex(612761);
        fieldTypeClassRef = FieldType.class;
    }
}
