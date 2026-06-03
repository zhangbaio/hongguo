package rr4;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class c {
    public String dirName;
    public final String fileName;
    public boolean useExpiredData;
    public String userId;

    static {
        Covode.recordClassIndex(611932);
    }

    public String getDirName() {
        return this.dirName;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "CacheKey{userId='" + this.userId + "', dirName='" + this.dirName + "', fileName='" + this.fileName + "', useExpiredData=" + this.useExpiredData + '}';
    }

    public c(String str) {
        this("", str);
    }

    public c(String str, String str2) {
        this.useExpiredData = false;
        this.userId = str;
        this.fileName = str2;
    }
}
