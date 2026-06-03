package com.ttreader.tthighlight;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTRegexUtils {
    static {
        Covode.recordClassIndex(654708);
    }

    public static Pattern GenerateRegex(String str) {
        return Pattern.compile(str, 8);
    }

    public static int RegexMatchGroups(Pattern pattern) {
        return pattern.matcher("").groupCount();
    }

    public static byte[] Match(Pattern pattern, String str, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            Matcher matcher = pattern.matcher(str);
            boolean find = matcher.find(i);
            dataOutputStream.writeBoolean(find);
            if (find) {
                int groupCount = matcher.groupCount();
                dataOutputStream.writeInt(groupCount);
                for (int i2 = 0; i2 <= groupCount; i2++) {
                    dataOutputStream.writeInt(matcher.start(i2));
                    dataOutputStream.writeInt(matcher.end(i2));
                }
            }
        } catch (Exception e) {
            Log.d("lyw-debug", "Match异常: " + str + " " + i);
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
