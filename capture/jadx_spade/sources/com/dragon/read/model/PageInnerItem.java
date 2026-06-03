package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PageInnerItem implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public int amount;
    public List<PageInnerBottomItem> bottom;
    public List<PageInnerItem> children;
    public String extra;
    public String title;
    public String type;
    public String unit;
    public String url;

    static {
        Covode.recordClassIndex(612178);
        fieldTypeClassRef = FieldType.class;
    }
}
