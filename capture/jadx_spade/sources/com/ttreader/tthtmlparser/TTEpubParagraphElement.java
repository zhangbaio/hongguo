package com.ttreader.tthtmlparser;

import com.bytedance.covode.number.Covode;
import com.ttreader.tthtmlparser.TTEpubDefinition;
import com.ttreader.tttext.IRunDelegate;
import com.ttreader.tttext.j;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTEpubParagraphElement {
    private final ByteArrayOutputStream array_output_stream_;
    private String class_;
    private String id_;
    private boolean is_last_;
    private final j manager_;
    private final DataOutputStream output_stream_;
    private String tag_;
    private TTEpubDefinition.TomatoTextType tomato_text_type_ = TTEpubDefinition.TomatoTextType.kUndefined;
    private List<String> media_idx_ = Collections.emptyList();
    private int p_idx_ = -1;
    private final ArrayList<ElementRange> elements_ = new ArrayList<>();
    private Map<String, String> extraAttributes = null;

    static {
        Covode.recordClassIndex(654750);
    }

    public String GetClass() {
        return this.class_;
    }

    public String GetId() {
        return this.id_;
    }

    public List<String> GetMediaIdx() {
        return this.media_idx_;
    }

    public int GetPIdx() {
        return this.p_idx_;
    }

    public String GetTag() {
        return this.tag_;
    }

    public TTEpubDefinition.TomatoTextType GetTextType() {
        return this.tomato_text_type_;
    }

    public boolean IsLast() {
        return this.is_last_;
    }

    public Map<String, String> getExtraAttributes() {
        return this.extraAttributes;
    }

    public ArrayList<ElementRange> GetElements() {
        return new ArrayList<>(this.elements_);
    }

    void reset() {
        this.array_output_stream_.reset();
    }

    byte[] toByteArray() {
        return this.array_output_stream_.toByteArray();
    }

    public void RemoveAllExtraAttachment() {
        try {
            this.output_stream_.writeInt(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ElementRange {
        public int e_idx;
        public int e_length;
        public int e_order;
        public int e_start_position;

        static {
            Covode.recordClassIndex(654751);
        }

        public String toString() {
            return "ElementRange(e_idx=" + this.e_idx + ", e_length=" + this.e_length + ", e_start_pos=" + this.e_start_position + ')';
        }
    }

    public void RemoveExtraAttachment(IRunDelegate iRunDelegate) {
        try {
            this.output_stream_.writeInt(4);
            this.output_stream_.writeInt(this.manager_.c(iRunDelegate));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TTEpubParagraphElement(j jVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.array_output_stream_ = byteArrayOutputStream;
        this.output_stream_ = new DataOutputStream(byteArrayOutputStream);
        this.manager_ = jVar;
    }

    public void ReadFromStream(com.ttreader.tttext.a aVar) throws IOException {
        boolean z;
        try {
            this.tag_ = aVar.a();
            this.class_ = aVar.a();
            this.id_ = aVar.a();
            int readInt = aVar.readInt();
            if (readInt > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.ensureCapacity(readInt);
                for (int i = 0; i < readInt; i++) {
                    String a = aVar.a();
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                this.media_idx_ = arrayList;
            } else {
                this.media_idx_ = Collections.emptyList();
            }
            boolean z2 = true;
            if (aVar.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.p_idx_ = aVar.readInt();
                int readInt2 = aVar.readInt();
                this.elements_.clear();
                this.elements_.ensureCapacity(readInt2);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    ElementRange elementRange = new ElementRange();
                    elementRange.e_idx = aVar.readInt();
                    elementRange.e_order = aVar.readInt();
                    elementRange.e_length = aVar.readInt();
                    elementRange.e_start_position = aVar.readInt();
                    if (elementRange.e_length > 0) {
                        this.elements_.add(elementRange);
                    }
                }
            } else {
                this.p_idx_ = -1;
                this.elements_.clear();
            }
            if (aVar.readInt() == 0) {
                z2 = false;
            }
            this.is_last_ = z2;
            this.tomato_text_type_ = TTEpubDefinition.GetTomatoTextType(aVar.readInt());
            int d = aVar.d();
            if (d > 0) {
                Map<String, String> map = this.extraAttributes;
                if (map == null) {
                    this.extraAttributes = new HashMap();
                } else {
                    map.clear();
                }
                for (int i3 = 0; i3 < d; i3++) {
                    this.extraAttributes.put(aVar.a(), aVar.a());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void InsertExtraAttachmentBegin(IRunDelegate iRunDelegate, boolean z) {
        try {
            this.output_stream_.writeInt(3);
            if (z) {
                this.output_stream_.writeInt(1);
            } else {
                this.output_stream_.writeInt(0);
            }
            this.output_stream_.writeInt(this.manager_.c(iRunDelegate));
            this.output_stream_.writeFloat(TTEpubUtils.Px2Dp(iRunDelegate.GetAscent()));
            this.output_stream_.writeFloat(TTEpubUtils.Px2Dp(iRunDelegate.GetDescent()));
            this.output_stream_.writeFloat(TTEpubUtils.Px2Dp(iRunDelegate.GetAdvance()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void InsertExtraAttachmentEnd(IRunDelegate iRunDelegate, boolean z) {
        try {
            this.output_stream_.writeInt(2);
            if (z) {
                this.output_stream_.writeInt(1);
            } else {
                this.output_stream_.writeInt(0);
            }
            this.output_stream_.writeInt(this.manager_.c(iRunDelegate));
            this.output_stream_.writeFloat(TTEpubUtils.Px2Dp(iRunDelegate.GetAscent()));
            this.output_stream_.writeFloat(TTEpubUtils.Px2Dp(iRunDelegate.GetDescent()));
            this.output_stream_.writeFloat(TTEpubUtils.Px2Dp(iRunDelegate.GetAdvance()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
