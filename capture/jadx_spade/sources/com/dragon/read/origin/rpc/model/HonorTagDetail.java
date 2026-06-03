package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class HonorTagDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("animation_url")
    public String animationUrl;

    @SerializedName("back_ground_img_url")
    public String backGroundImgUrl;

    @SerializedName("background_color")
    public String backgroundColor;

    @SerializedName("big_type")
    public String bigType;

    @SerializedName("big_type_zh")
    public String bigTypeZh;

    @SerializedName("border_color_arr")
    public List<String> borderColorArr;

    @SerializedName("create_time")
    public long createTime;

    @SerializedName("detail_top_tag_url")
    public String detailTopTagUrl;

    @SerializedName("honor_tag_extra_info")
    public HonorTagExtraInfo honorTagExtraInfo;

    @SerializedName("img_url")
    public String imgUrl;
    public String intro;
    public String name;
    public long priority;

    @SerializedName("small_img_url")
    public String smallImgUrl;

    @SerializedName("tag_id")
    public String tagId;

    @SerializedName("update_time")
    public long updateTime;

    static {
        Covode.recordClassIndex(613187);
        fieldTypeClassRef = FieldType.class;
    }
}
