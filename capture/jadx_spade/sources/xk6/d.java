package xk6;

import com.bytedance.covode.number.Covode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    static {
        Covode.recordClassIndex(655869);
    }

    public static final float[] a(ByteBuffer byteBuffer) {
        FloatBuffer asFloatBuffer = byteBuffer.order(ByteOrder.nativeOrder()).asFloatBuffer();
        float[] fArr = new float[asFloatBuffer.capacity()];
        asFloatBuffer.get(fArr);
        return fArr;
    }

    public static final boolean b(ArrayList<float[]> arrayList, float[] fArr) {
        int size = arrayList.size();
        int length = arrayList.get(0).length;
        if (fArr.length < size * length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                fArr[(i * size) + i2] = arrayList.get(i2)[i];
            }
        }
        return true;
    }
}
