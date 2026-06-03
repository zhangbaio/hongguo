package com.tiktok.ttm;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class TTMOutput {
    private Object data;
    String msg;
    ReturnType type;

    public @interface Type {
    }

    static {
        Covode.recordClassIndex(653994);
    }

    public Object getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public ReturnType getType() {
        return this.type;
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ReturnType.values().length];
            a = iArr;
            try {
                iArr[ReturnType.LONG_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ReturnType.DOUBLE_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ReturnType.STRING_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ReturnType.OBJECT_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String toString() {
        String arrays;
        int i = a.a[this.type.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        Object obj = this.data;
                        if (obj != null) {
                            arrays = obj.toString();
                        } else {
                            arrays = "null";
                        }
                    } else {
                        arrays = Arrays.toString((Object[]) this.data);
                    }
                } else {
                    arrays = Arrays.toString((String[]) this.data);
                }
            } else {
                arrays = Arrays.toString((double[]) this.data);
            }
        } else {
            arrays = Arrays.toString((long[]) this.data);
        }
        return "{\n\t\"msg\": " + this.msg + ",\n\t\"data\": " + arrays + "\n}";
    }

    public enum ReturnType {
        ERROR(-1),
        BOOL(0),
        LONG(1),
        DOUBLE(2),
        STRING(3),
        LONG_ARRAY(4),
        DOUBLE_ARRAY(5),
        STRING_ARRAY(6),
        OBJECT_ARRAY(7),
        MAP(8),
        NULL(9),
        LIST(10),
        UN_SUPPORT(12);

        public int value;

        static {
            Covode.recordClassIndex(653995);
        }

        public static ReturnType parseFromIntVal(int i) {
            switch (i) {
                case 0:
                    return BOOL;
                case 1:
                    return LONG;
                case 2:
                    return DOUBLE;
                case 3:
                    return STRING;
                case 4:
                    return LONG_ARRAY;
                case 5:
                    return DOUBLE_ARRAY;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    return STRING_ARRAY;
                case 7:
                    return OBJECT_ARRAY;
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    return MAP;
                case 9:
                    return NULL;
                case 10:
                    return LIST;
                case 11:
                default:
                    return ERROR;
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    return UN_SUPPORT;
            }
        }

        ReturnType(int i) {
            this.value = i;
        }
    }

    private void setErrorMessage(String str) {
        this.msg = str;
        Log.e("TTM/OutPut", str);
    }

    private void nativeSetDoubleValue(double d) {
        this.msg = "ok";
        this.type = ReturnType.DOUBLE;
        this.data = Double.valueOf(d);
    }

    private int convertParamTypeToReturnType(int i) {
        switch (i) {
            case 0:
            case 10:
                return ReturnType.MAP.value;
            case 1:
            case 11:
                return ReturnType.LIST.value;
            case 2:
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
            default:
                return i;
            case 3:
                return ReturnType.OBJECT_ARRAY.value;
            case 4:
                return ReturnType.LONG.value;
            case 5:
                return ReturnType.DOUBLE.value;
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                return ReturnType.STRING.value;
            case 7:
                return ReturnType.LONG_ARRAY.value;
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                return ReturnType.DOUBLE_ARRAY.value;
            case 9:
                return ReturnType.STRING_ARRAY.value;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return ReturnType.NULL.value;
        }
    }

    private static void NativeSetListObjectValue(List<Object> list, Object obj) {
        list.add(obj);
    }

    private static void NativeSetListDoubleValue(List<Object> list, double d) {
        list.add(Double.valueOf(d));
    }

    private static void NativeSetListLongValue(List<Object> list, long j) {
        list.add(Long.valueOf(j));
    }

    private void nativeSetOutLongValue(int i, long j) {
        this.msg = "ok";
        boolean z = true;
        if (i != 0) {
            if (i != 1) {
                this.type = ReturnType.ERROR;
                this.data = Long.valueOf(j);
                this.msg = "error";
                return;
            } else {
                this.type = ReturnType.LONG;
                this.data = Long.valueOf(j);
                return;
            }
        }
        this.type = ReturnType.BOOL;
        if (j != 1) {
            z = false;
        }
        this.data = Boolean.valueOf(z);
    }

    private void nativeSetOutput(int i, Object obj) {
        if (i == -1) {
            this.type = ReturnType.ERROR;
            this.data = null;
            this.msg = "ttm execute failed, error_meessage: " + ((Integer) obj);
            return;
        }
        if (i == 11 && (obj instanceof TTMParamData)) {
            TTMParamData tTMParamData = (TTMParamData) obj;
            Object inputData = tTMParamData.getInputData();
            int convertParamTypeToReturnType = convertParamTypeToReturnType(tTMParamData.getType());
            obj = inputData;
            i = convertParamTypeToReturnType;
        }
        this.msg = "ok";
        this.type = ReturnType.parseFromIntVal(i);
        this.data = obj;
    }

    private static void NativeSetMapObjectValue(Map<Object, Object> map, Object obj, Object obj2) {
        map.put(obj, obj2);
    }

    private static void NativeSetMapDoubleValue(Map<Object, Object> map, Object obj, double d) {
        map.put(obj, Double.valueOf(d));
    }

    private static void NativeSetMapLongValue(Map<Object, Object> map, Object obj, long j) {
        map.put(obj, Long.valueOf(j));
    }

    private static void NativeSetObjectArrayDoubleValue(Object[] objArr, int i, double d) {
        objArr[i] = Double.valueOf(d);
    }

    private static void NativeSetObjectArrayLongValue(Object[] objArr, int i, long j) {
        objArr[i] = Long.valueOf(j);
    }
}
