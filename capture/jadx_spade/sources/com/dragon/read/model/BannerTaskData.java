package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class BannerTaskData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("task_conf")
    public Map<String, BannerTaskConf> taskConf;

    @SerializedName("task_list")
    public List<TaskDetail> taskList;

    @SerializedName("task_num")
    public long taskNum;

    static {
        Covode.recordClassIndex(612019);
        fieldTypeClassRef = FieldType.class;
    }
}
