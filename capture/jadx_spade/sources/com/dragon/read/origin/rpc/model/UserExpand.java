package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UserExpand implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("actor_schema")
    public String actorSchema;

    @SerializedName("has_room_onlive")
    public boolean hasRoomOnLive;

    @SerializedName("is_pugc_album_author")
    public boolean isPugcAlbumAuthor;

    @SerializedName("name_option")
    public int nameOption;

    @SerializedName("pen_name")
    public String penName;

    @SerializedName("real_name")
    public String realName;

    @SerializedName("sub_title_info")
    public String subTitleInfo;

    @SerializedName("sub_title_list")
    public List<ExpandTextExt> subTitleList;
    public List<UgcVideoDetail> videos;

    static {
        Covode.recordClassIndex(613555);
        fieldTypeClassRef = FieldType.class;
    }
}
