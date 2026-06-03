package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MallTaskBar implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("all_task_done")
    public boolean allTaskDone;
    public String desc;

    @SerializedName("redpack_list")
    public List<MallTaskRedpack> redpackList;
    public Reward reward;
    public String title;

    static {
        Covode.recordClassIndex(612150);
        fieldTypeClassRef = FieldType.class;
    }
}
