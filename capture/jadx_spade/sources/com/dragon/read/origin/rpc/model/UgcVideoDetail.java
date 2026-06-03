package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class UgcVideoDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("category_schema")
    public String categorySchema;
    public String cover;

    @SerializedName("dynamic_poster")
    public String dynamicCover;

    @SerializedName("episode_cnt")
    public long episodeCnt;
    public Map<String, String> extra;

    @SerializedName("first_frame_poster")
    public String firstFrameCover;
    public String intro;

    @SerializedName("is_private")
    public boolean isPrivate;

    @SerializedName("play_cnt")
    public long playCnt;

    @SerializedName("series_id")
    public String seriesID;

    @SerializedName("series_status")
    public int seriesStatus;

    @SerializedName("sub_title_list")
    public List<ExpandTextExt> subTitleList;

    @SerializedName("sub_title_list_with_position")
    public Map<SubTitlePosition, List<ExpandTextExt>> subTitleListWithPosition;
    public boolean subscribed;

    @SerializedName("tag_info")
    public List<ExpandTextExt> tagInfo;
    public String title;

    @SerializedName("poster_image_type")
    public ImageType ugcPosterImageType;

    @SerializedName("video_content_type")
    public int videoContentType;

    @SerializedName("video_height")
    public int videoHeight;

    @SerializedName("video_id")
    public String videoID;

    @SerializedName("video_is_muted")
    public int videoIsMuted;

    @SerializedName("video_model")
    public String videoModel;

    @SerializedName("video_width")
    public int videoWidth;

    static {
        Covode.recordClassIndex(613535);
        fieldTypeClassRef = FieldType.class;
    }
}
