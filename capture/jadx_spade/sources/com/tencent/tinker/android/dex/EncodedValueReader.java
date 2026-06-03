package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tinker.android.dex.util.ByteInput;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class EncodedValueReader {
    private int annotationType;
    private int arg;
    protected final ByteInput in;
    private int type;

    static {
        Covode.recordClassIndex(653610);
    }

    public int getAnnotationType() {
        return this.annotationType;
    }

    public int readAnnotationName() {
        return Leb128.readUnsignedLeb128(this.in);
    }

    public int readArray() {
        checkType(28);
        this.type = -1;
        return Leb128.readUnsignedLeb128(this.in);
    }

    public boolean readBoolean() {
        checkType(31);
        this.type = -1;
        if (this.arg != 0) {
            return true;
        }
        return false;
    }

    public int readInt() {
        checkType(4);
        this.type = -1;
        return EncodedValueCodec.readSignedInt(this.in, this.arg);
    }

    public long readLong() {
        checkType(6);
        this.type = -1;
        return EncodedValueCodec.readSignedLong(this.in, this.arg);
    }

    public void readNull() {
        checkType(30);
        this.type = -1;
    }

    public int peek() {
        if (this.type == -1) {
            int readByte = this.in.readByte() & 255;
            this.type = readByte & 31;
            this.arg = (readByte & 224) >> 5;
        }
        return this.type;
    }

    public int readAnnotation() {
        checkType(29);
        this.type = -1;
        this.annotationType = Leb128.readUnsignedLeb128(this.in);
        return Leb128.readUnsignedLeb128(this.in);
    }

    public byte readByte() {
        checkType(0);
        this.type = -1;
        return (byte) EncodedValueCodec.readSignedInt(this.in, this.arg);
    }

    public char readChar() {
        checkType(3);
        this.type = -1;
        return (char) EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public double readDouble() {
        checkType(17);
        this.type = -1;
        return Double.longBitsToDouble(EncodedValueCodec.readUnsignedLong(this.in, this.arg, true));
    }

    public int readEnum() {
        checkType(27);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public int readField() {
        checkType(25);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public float readFloat() {
        checkType(16);
        this.type = -1;
        return Float.intBitsToFloat(EncodedValueCodec.readUnsignedInt(this.in, this.arg, true));
    }

    public int readMethod() {
        checkType(26);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public short readShort() {
        checkType(2);
        this.type = -1;
        return (short) EncodedValueCodec.readSignedInt(this.in, this.arg);
    }

    public int readString() {
        checkType(23);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public int readType() {
        checkType(24);
        this.type = -1;
        return EncodedValueCodec.readUnsignedInt(this.in, this.arg, false);
    }

    public void skipValue() {
        int peek = peek();
        if (peek != 0) {
            if (peek != 6) {
                if (peek != 2) {
                    if (peek != 3) {
                        if (peek != 4) {
                            if (peek != 16) {
                                if (peek != 17) {
                                    int i = 0;
                                    switch (peek) {
                                        case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                            readString();
                                            return;
                                        case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                            readType();
                                            return;
                                        case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                            readField();
                                            return;
                                        case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                            readMethod();
                                            return;
                                        case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                            readEnum();
                                            return;
                                        case 28:
                                            int readArray = readArray();
                                            while (i < readArray) {
                                                skipValue();
                                                i++;
                                            }
                                            return;
                                        case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                            int readAnnotation = readAnnotation();
                                            while (i < readAnnotation) {
                                                readAnnotationName();
                                                skipValue();
                                                i++;
                                            }
                                            return;
                                        case 30:
                                            readNull();
                                            return;
                                        case 31:
                                            readBoolean();
                                            return;
                                        default:
                                            throw new DexException("Unexpected type: " + Integer.toHexString(this.type));
                                    }
                                }
                                readDouble();
                                return;
                            }
                            readFloat();
                            return;
                        }
                        readInt();
                        return;
                    }
                    readChar();
                    return;
                }
                readShort();
                return;
            }
            readLong();
            return;
        }
        readByte();
    }

    public EncodedValueReader(EncodedValue encodedValue) {
        this(encodedValue.asByteInput());
    }

    public EncodedValueReader(ByteInput byteInput) {
        this.type = -1;
        this.in = byteInput;
    }

    private void checkType(int i) {
        if (peek() == i) {
        } else {
            throw new IllegalStateException(String.format("Expected %x but was %x", Integer.valueOf(i), Integer.valueOf(peek())));
        }
    }

    public EncodedValueReader(EncodedValue encodedValue, int i) {
        this(encodedValue.asByteInput(), i);
    }

    public EncodedValueReader(ByteInput byteInput, int i) {
        this.in = byteInput;
        this.type = i;
    }
}
