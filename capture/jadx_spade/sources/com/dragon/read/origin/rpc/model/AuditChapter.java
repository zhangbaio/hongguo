package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AuditChapter implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("audit_failed_chapter_title")
    public String auditFailedChapterTitle;

    @SerializedName("audit_time_chapter_title")
    public String auditTimeChapterTitle;

    static {
        Covode.recordClassIndex(612746);
        fieldTypeClassRef = FieldType.class;
    }
}
