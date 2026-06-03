package cj6;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c implements b {
    private ArrayList<HashMap<String, String>> a = new ArrayList<>();
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    static {
        Covode.recordClassIndex(653034);
    }

    public String f() {
        String str;
        if (this.a.isEmpty()) {
            return "none";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.a.size(); i++) {
                HashMap<String, String> hashMap = this.a.get(i);
                if (hashMap.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str2 : hashMap.keySet()) {
                        jSONObject.put(str2, hashMap.get(str2));
                    }
                    jSONArray.put(jSONObject);
                }
            }
            str = jSONArray.toString();
        } catch (Exception unused) {
            com.ss.videoarch.liveplayer.log.a.b("getSeiReportStr", "parseSEI err");
            str = "none";
        }
        this.a.clear();
        if (TextUtils.isEmpty(str)) {
            return "none";
        }
        return str;
    }

    private void c(Object obj) {
        try {
            if (this.a.size() >= 10 || !(obj instanceof ByteBuffer)) {
                return;
            }
            h((ByteBuffer) obj);
        } catch (Exception unused) {
            com.ss.videoarch.liveplayer.log.a.b("SEIReportMgr", "parseSEI err");
        }
    }

    private HashMap<String, String> b(HashMap<String, String> hashMap) {
        if (!hashMap.containsKey(String.valueOf(6)) && this.d == 1) {
            hashMap.put(String.valueOf(6), "1");
        }
        if (!hashMap.containsKey(String.valueOf(5)) && this.c == 1) {
            hashMap.put(String.valueOf(5), "1");
        }
        if (!hashMap.containsKey(String.valueOf(10)) && this.b == 1) {
            hashMap.put(String.valueOf(10), "1");
        }
        if (!hashMap.containsKey(String.valueOf(11)) && this.f == 1) {
            hashMap.put(String.valueOf(11), "1");
        }
        return hashMap;
    }

    private void h(ByteBuffer byteBuffer) {
        ArrayList<HashMap<String, String>> arrayList;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        byteBuffer.limit(limit);
        byte[] bArr2 = new byte[remaining];
        g(bArr, bArr2);
        int i = 10;
        if (remaining < 10) {
            return;
        }
        if (e(bArr2, 9) == 0 && (arrayList = this.a) != null && arrayList.size() > 0) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        int e = (e(bArr2, 7) << 8) + e(bArr2, 6);
        if (e > 65280) {
            e = 65280;
        }
        for (int i2 = 0; i2 < e; i2++) {
            int i3 = i + 5;
            if (i3 >= remaining) {
                break;
            }
            int e2 = (e(bArr2, i + 1) << 8) + e(bArr2, i);
            if (e2 <= 0) {
                break;
            }
            int e3 = (e(bArr2, i + 3) << 8) + e(bArr2, i + 2);
            hashMap.put(String.valueOf(e3), d((e(bArr2, i3) << 8) + e(bArr2, i + 4), e3));
            i = i + e2 + 6;
        }
        this.a.add(b(hashMap));
    }

    private int e(byte[] bArr, int i) {
        if (bArr.length > i) {
            byte b = bArr[i];
            if (b < 0) {
                return b + 256;
            }
            return b;
        }
        return 0;
    }

    private String d(int i, int i2) {
        if (i2 == 6 && this.d == 1) {
            return String.valueOf(i + 1);
        }
        if (i2 == 5 && this.c == 1) {
            return String.valueOf(i + 1);
        }
        if (i2 == 10 && this.b == 1) {
            return String.valueOf(i + 1);
        }
        if (i2 == 11 && this.f == 1) {
            return String.valueOf(i + 1);
        }
        return String.valueOf(i);
    }

    private int g(byte[] bArr, byte[] bArr2) {
        byte b;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 3;
            if (i3 < length && bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3 && ((b = bArr[i3]) == 0 || b == 1 || b == 2 || b == 3)) {
                int i4 = i2 + 1;
                bArr2[i2] = 0;
                int i5 = i4 + 1;
                bArr2[i4] = 0;
                bArr2[i5] = bArr[i3];
                i2 = i5 + 1;
                i = i3;
            } else {
                bArr2[i2] = bArr[i];
                i2++;
            }
            i++;
        }
        return i2;
    }

    @Override // cj6.b
    public void a(int i, int i2, String str, Object obj) {
        if (i == 111) {
            this.b = i2;
            return;
        }
        if (i == 110) {
            this.f = i2;
            return;
        }
        if (i == 108) {
            this.c = i2;
            return;
        }
        if (i == 107) {
            this.d = i2;
            return;
        }
        if (i == 109) {
            this.e = i2;
        } else if (i == 105 && obj != null) {
            c(obj);
        }
    }
}
