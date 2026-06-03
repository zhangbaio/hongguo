package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class EditArticleRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("column_data")
    public ColumnData columnData;
    public String content;

    @SerializedName("content_mark_problem")
    public Map<Integer, ProblemMarkInfo> contentMarkProblem;

    @SerializedName("creation_status")
    public CreationStatus creationStatus;

    @SerializedName("highlight_content")
    public String highlightContent;

    @SerializedName("latest_publish_item_info")
    public ItemInfo latestPublishItemInfo;

    @SerializedName("latest_version")
    public int latestVersion;

    @SerializedName("publish_status")
    public PublishStatus publishStatus;

    @SerializedName("timer_status")
    public TimerStatus timerStatus;

    @SerializedName("timer_time")
    public String timerTime;
    public String title;

    @SerializedName("title_problem")
    public String titleProblem;

    @SerializedName("user_auth")
    public UserAuthStatus userAuth;

    @SerializedName("volume_data")
    public List<VolumeData> volumeData;

    @SerializedName("volume_id")
    public String volumeID;

    static {
        Covode.recordClassIndex(612908);
        fieldTypeClassRef = FieldType.class;
    }
}
