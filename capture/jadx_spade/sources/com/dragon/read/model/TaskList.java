package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TaskList implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public TaskListExtra extra;

    @SerializedName("task_event_param")
    public Map<String, Map<String, String>> taskEventParam;

    @SerializedName("task_list")
    public Map<String, List<TaskDetail>> taskList;

    @SerializedName("welfare_tab_infos")
    public List<WelfareTabInfo> welfareTabInfos;

    static {
        Covode.recordClassIndex(612273);
        fieldTypeClassRef = FieldType.class;
    }
}
