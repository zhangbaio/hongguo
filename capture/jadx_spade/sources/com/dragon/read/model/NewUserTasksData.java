package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NewUserTasksData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_background_color")
    public String actionBackgroundColor;

    @SerializedName("action_desc")
    public String actionDesc;

    @SerializedName("icon_url")
    public String iconUrl;

    @SerializedName("sub_title")
    public String subTitle;

    @SerializedName("sub_title_tag")
    public String subTitleTag;

    @SerializedName("task_list")
    public List<TaskDetail> taskList;

    @SerializedName("task_show_style")
    public String taskShowStyle;
    public String title;

    @SerializedName("total_reward")
    public Reward totalReward;

    static {
        Covode.recordClassIndex(612164);
        fieldTypeClassRef = FieldType.class;
    }
}
