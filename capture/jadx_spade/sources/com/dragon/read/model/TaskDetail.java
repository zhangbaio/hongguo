package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TaskDetail implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("action_background_color")
    public String actionBackgroundColor;

    @SerializedName("action_cycle")
    public int actionCycle;

    @SerializedName("action_desc")
    public String actionDesc;

    @SerializedName("action_times")
    public int actionTimes;

    @SerializedName("add_widget")
    public AddWidget addWidget;

    @SerializedName("app_id")
    public int appId;

    @SerializedName("award_info")
    public AwardInfo awardInfo;
    public boolean completed;

    @SerializedName("completed_bottom")
    public String completedBottom;

    @SerializedName("conf_extra")
    public String confExtra;

    @SerializedName("continue_comp_cnt")
    public int continueCompCnt;
    public String desc;

    @SerializedName("done_percent")
    public int donePercent;

    @SerializedName("end_show")
    public int endShow;
    public String group;
    public String icon;

    @SerializedName("icon_url")
    public String iconUrl;

    @SerializedName("icon_url_dark_mode")
    public String iconUrlDarkMode;
    public int interval;

    @SerializedName("is_forced_fold")
    public boolean isForcedFold;

    @SerializedName("is_hot")
    public boolean isHot;
    public String key;
    public String name;

    @SerializedName("name_tag")
    public String nameTag;

    @SerializedName("profit_desc")
    public String profitDesc;
    public List<Reward> reward;
    public int sort;

    @SerializedName("status_extra")
    public String statusExtra;

    @SerializedName("task_id")
    public int taskId;

    @SerializedName("task_type")
    public String taskType;

    @SerializedName("task_ui_type")
    public String taskUiType;

    @SerializedName("task_url")
    public String taskUrl;

    @SerializedName("title_second")
    public String titleSecond;

    static {
        Covode.recordClassIndex(612270);
        fieldTypeClassRef = FieldType.class;
    }
}
