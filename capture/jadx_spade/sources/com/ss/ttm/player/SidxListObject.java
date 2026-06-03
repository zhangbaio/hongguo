package com.ss.ttm.player;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SidxListObject extends NativeObject {
    private long mBitrate;
    private int mEndIndex;
    private String mFileId;
    private List<SidxItem> mItems = new ArrayList();
    private int mMediaType;
    private int mStartIndex;
    private int mTotalNum;

    static {
        Covode.recordClassIndex(652161);
    }

    public static class SidxItem {
        private long mDuration;
        private int mIndex;
        private long mOffset;
        private long mSize;
        private long mTimestamp;

        static {
            Covode.recordClassIndex(652162);
        }

        public long getDuration() {
            return this.mDuration;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public long getOffset() {
            return this.mOffset;
        }

        public long getSize() {
            return this.mSize;
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }

        public SidxItem(int i, long j, long j2, long j3, long j4) {
            this.mIndex = i;
            this.mOffset = j;
            this.mTimestamp = j2;
            this.mDuration = j3;
            this.mSize = j4;
        }
    }

    public long getBitrate() {
        return this.mBitrate;
    }

    public int getEndIndex() {
        return this.mEndIndex;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }

    public SidxItem getItem(int i) {
        if (i >= 0 && i < this.mItems.size()) {
            return this.mItems.get(i);
        }
        return null;
    }

    public void addItem(int i, long j, long j2, long j3, long j4) {
        this.mItems.add(new SidxItem(i, j, j2, j3, j4));
    }

    public SidxListObject(int i, int i2, int i3, int i4, long j, String str) {
        this.mMediaType = i;
        this.mTotalNum = i2;
        this.mStartIndex = i3;
        this.mEndIndex = i4;
        this.mBitrate = j;
        this.mFileId = str;
    }
}
