package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserTag implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("actor_type")
    public UgcActorType actorType;

    @SerializedName("avatar_decoration_list")
    public List<AvatarDecoration> avatarDecorationList;

    @SerializedName("brand_type")
    public UgcActorType brandType;

    @SerializedName("creator_type")
    public UgcCreatorType creatorType;

    @SerializedName("creator_types_full")
    public List<UgcCreatorType> creatorTypesFull;

    @SerializedName("fan_rank_num")
    public int fanRankNum;

    @SerializedName("fan_ranklist_title")
    public String fanRanklistTitle;

    @SerializedName("honor_tag_brief_info")
    public HonorTagBriefInfo honorTagBriefInfo;

    @SerializedName("is_ad_free_vip")
    public boolean isAdFreeVip;

    @SerializedName("is_author")
    public boolean isAuthor;

    @SerializedName("is_blue_vip")
    public boolean isBlueVip;

    @SerializedName("is_cp")
    public boolean isCp;

    @SerializedName("is_official_cert")
    public boolean isOfficialCert;

    @SerializedName("is_pub_vip")
    public boolean isPubVip;

    @SerializedName("is_story_vip")
    public boolean isStoryVip;

    @SerializedName("is_vip")
    public boolean isVip;

    @SerializedName("owner_type")
    public short ownerType;

    @SerializedName("registered_creator_type_list")
    public List<UgcCreatorType> registeredCreatorTypeList;
    public UgcUserSticker sticker;

    @SerializedName("sub_title_list")
    public List<ExpandTextExt> subTitleList;

    @SerializedName("user_title_info")
    public List<UserTitleV2> userTitleInfo;

    static {
        Covode.recordClassIndex(613561);
        fieldTypeClassRef = FieldType.class;
    }
}
