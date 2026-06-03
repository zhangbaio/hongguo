package com.tencent.tinker.android.dex.io;

import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.tencent.tinker.android.dex.Annotation;
import com.tencent.tinker.android.dex.AnnotationSet;
import com.tencent.tinker.android.dex.AnnotationSetRefList;
import com.tencent.tinker.android.dex.AnnotationsDirectory;
import com.tencent.tinker.android.dex.ClassData;
import com.tencent.tinker.android.dex.ClassDef;
import com.tencent.tinker.android.dex.Code;
import com.tencent.tinker.android.dex.DebugInfoItem;
import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dex.EncodedValue;
import com.tencent.tinker.android.dex.EncodedValueReader;
import com.tencent.tinker.android.dex.FieldId;
import com.tencent.tinker.android.dex.Leb128;
import com.tencent.tinker.android.dex.MethodId;
import com.tencent.tinker.android.dex.Mutf8;
import com.tencent.tinker.android.dex.ProtoId;
import com.tencent.tinker.android.dex.SizeOf;
import com.tencent.tinker.android.dex.StringData;
import com.tencent.tinker.android.dex.TypeList;
import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.ByteOutput;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DexDataBuffer implements ByteInput, ByteOutput {
    private static final Code.CatchHandler[] EMPTY_CATCHHANDLER_ARRAY;
    private static final short[] EMPTY_SHORT_ARRAY;
    private static final Code.Try[] EMPTY_TRY_ARRAY;
    private ByteBuffer data;
    private int dataBound;
    private boolean isResizeAllowed;

    public int position() {
        return this.data.position();
    }

    @Override // com.tencent.tinker.android.dex.util.ByteInput
    public byte readByte() {
        return this.data.get();
    }

    public int readInt() {
        return this.data.getInt();
    }

    public short readShort() {
        return this.data.getShort();
    }

    public int readSleb128() {
        return Leb128.readSignedLeb128(this);
    }

    public int readUleb128() {
        return Leb128.readUnsignedLeb128(this);
    }

    public int readUleb128p1() {
        return Leb128.readUnsignedLeb128(this) - 1;
    }

    public int readUnsignedByte() {
        return readByte() & 255;
    }

    public void alignToFourBytes() {
        ByteBuffer byteBuffer = this.data;
        byteBuffer.position((byteBuffer.position() + 3) & (-4));
    }

    public int available() {
        return this.dataBound - this.data.position();
    }

    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    static {
        Covode.recordClassIndex(653622);
        EMPTY_SHORT_ARRAY = new short[0];
        EMPTY_TRY_ARRAY = new Code.Try[0];
        EMPTY_CATCHHANDLER_ARRAY = new Code.CatchHandler[0];
    }

    private Code.CatchHandler[] readCatchHandlers() {
        int position = this.data.position();
        int readUleb128 = readUleb128();
        Code.CatchHandler[] catchHandlerArr = new Code.CatchHandler[readUleb128];
        for (int i = 0; i < readUleb128; i++) {
            catchHandlerArr[i] = readCatchHandler(this.data.position() - position);
        }
        return catchHandlerArr;
    }

    public byte[] array() {
        byte[] bArr = new byte[this.dataBound];
        System.arraycopy(this.data.array(), 0, bArr, 0, this.dataBound);
        return bArr;
    }

    public AnnotationSet readAnnotationSet() {
        int position = this.data.position();
        int readInt = readInt();
        int[] iArr = new int[readInt];
        for (int i = 0; i < readInt; i++) {
            iArr[i] = readInt();
        }
        return new AnnotationSet(position, iArr);
    }

    public AnnotationSetRefList readAnnotationSetRefList() {
        int position = this.data.position();
        int readInt = readInt();
        int[] iArr = new int[readInt];
        for (int i = 0; i < readInt; i++) {
            iArr[i] = readInt();
        }
        return new AnnotationSetRefList(position, iArr);
    }

    public EncodedValue readEncodedArray() {
        int position = this.data.position();
        new EncodedValueReader(this, 28).skipValue();
        return new EncodedValue(position, getBytesFrom(position));
    }

    public FieldId readFieldId() {
        return new FieldId(this.data.position(), readUnsignedShort(), readUnsignedShort(), readInt());
    }

    public MethodId readMethodId() {
        return new MethodId(this.data.position(), readUnsignedShort(), readUnsignedShort(), readInt());
    }

    public ProtoId readProtoId() {
        return new ProtoId(this.data.position(), readInt(), readInt(), readInt());
    }

    public TypeList readTypeList() {
        return new TypeList(this.data.position(), readShortArray(readInt()));
    }

    public DexDataBuffer() {
        ByteBuffer allocate = ByteBuffer.allocate(MediaPlayer.MEDIA_PLAYER_OPTION_APPID);
        this.data = allocate;
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        this.dataBound = this.data.position();
        ByteBuffer byteBuffer = this.data;
        byteBuffer.limit(byteBuffer.capacity());
        this.isResizeAllowed = true;
    }

    public void alignToFourBytesWithZeroFill() {
        ensureBufferSize((SizeOf.roundToTimesOfFour(this.data.position()) - this.data.position()) * 1);
        while ((this.data.position() & 3) != 0) {
            this.data.put((byte) 0);
        }
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public Annotation readAnnotation() {
        int position = this.data.position();
        byte readByte = readByte();
        int position2 = this.data.position();
        new EncodedValueReader(this, 29).skipValue();
        return new Annotation(position, readByte, new EncodedValue(position2, getBytesFrom(position2)));
    }

    public ClassData readClassData() {
        return new ClassData(this.data.position(), readFields(readUleb128()), readFields(readUleb128()), readMethods(readUleb128()), readMethods(readUleb128()));
    }

    public ClassDef readClassDef() {
        return new ClassDef(position(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt());
    }

    public Code readCode() {
        Code.Try[] tryArr;
        Code.CatchHandler[] catchHandlerArr;
        int position = this.data.position();
        int readUnsignedShort = readUnsignedShort();
        int readUnsignedShort2 = readUnsignedShort();
        int readUnsignedShort3 = readUnsignedShort();
        int readUnsignedShort4 = readUnsignedShort();
        int readInt = readInt();
        short[] readShortArray = readShortArray(readInt());
        if (readUnsignedShort4 > 0) {
            if ((readShortArray.length & 1) == 1) {
                skip(2);
            }
            int position2 = this.data.position();
            skip(readUnsignedShort4 * 8);
            Code.CatchHandler[] readCatchHandlers = readCatchHandlers();
            int position3 = this.data.position();
            this.data.position(position2);
            Code.Try[] readTries = readTries(readUnsignedShort4, readCatchHandlers);
            this.data.position(position3);
            catchHandlerArr = readCatchHandlers;
            tryArr = readTries;
        } else {
            tryArr = EMPTY_TRY_ARRAY;
            catchHandlerArr = EMPTY_CATCHHANDLER_ARRAY;
        }
        return new Code(position, readUnsignedShort, readUnsignedShort2, readUnsignedShort3, readInt, readShortArray, tryArr, catchHandlerArr);
    }

    public StringData readStringData() {
        int position = this.data.position();
        try {
            int readUleb128 = readUleb128();
            String decode = Mutf8.decode(this, new char[readUleb128]);
            if (decode.length() == readUleb128) {
                return new StringData(position, decode);
            }
            throw new DexException("Declared length " + readUleb128 + " doesn't match decoded length of " + decode.length());
        } catch (UTFDataFormatException e) {
            throw new DexException(e);
        }
    }

    public AnnotationsDirectory readAnnotationsDirectory() {
        int position = this.data.position();
        int readInt = readInt();
        int readInt2 = readInt();
        int readInt3 = readInt();
        int readInt4 = readInt();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, readInt2, 2);
        for (int i = 0; i < readInt2; i++) {
            iArr[i][0] = readInt();
            iArr[i][1] = readInt();
        }
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, readInt3, 2);
        for (int i2 = 0; i2 < readInt3; i2++) {
            iArr2[i2][0] = readInt();
            iArr2[i2][1] = readInt();
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, readInt4, 2);
        for (int i3 = 0; i3 < readInt4; i3++) {
            iArr3[i3][0] = readInt();
            iArr3[i3][1] = readInt();
        }
        return new AnnotationsDirectory(position, readInt, iArr, iArr2, iArr3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
    
        r5 = new com.tencent.tinker.android.dex.DebugInfoItem(r0, r1, r3, r4.toByteArray());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0079, code lost:
    
        r4.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.tencent.tinker.android.dex.DebugInfoItem readDebugInfoItem() {
        /*
            r7 = this;
            java.nio.ByteBuffer r0 = r7.data
            int r0 = r0.position()
            int r1 = r7.readUleb128()
            int r2 = r7.readUleb128()
            int[] r3 = new int[r2]
            r4 = 0
        L11:
            if (r4 >= r2) goto L1c
            int r5 = r7.readUleb128p1()
            r3[r4] = r5
            int r4 = r4 + 1
            goto L11
        L1c:
            r2 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L88
            r5 = 64
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L88
            com.tencent.tinker.android.dex.io.DexDataBuffer$1 r2 = new com.tencent.tinker.android.dex.io.DexDataBuffer$1     // Catch: java.lang.Throwable -> L85
            r2.<init>()     // Catch: java.lang.Throwable -> L85
        L29:
            byte r5 = r7.readByte()     // Catch: java.lang.Throwable -> L85
            r4.write(r5)     // Catch: java.lang.Throwable -> L85
            r6 = 9
            if (r5 == r6) goto L7d
            switch(r5) {
                case 0: goto L70;
                case 1: goto L68;
                case 2: goto L60;
                case 3: goto L40;
                case 4: goto L40;
                case 5: goto L38;
                case 6: goto L38;
                default: goto L37;
            }     // Catch: java.lang.Throwable -> L85
        L37:
            goto L29
        L38:
            int r5 = r7.readUleb128()     // Catch: java.lang.Throwable -> L85
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128(r2, r5)     // Catch: java.lang.Throwable -> L85
            goto L29
        L40:
            int r6 = r7.readUleb128()     // Catch: java.lang.Throwable -> L85
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128(r2, r6)     // Catch: java.lang.Throwable -> L85
            int r6 = r7.readUleb128p1()     // Catch: java.lang.Throwable -> L85
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128p1(r2, r6)     // Catch: java.lang.Throwable -> L85
            int r6 = r7.readUleb128p1()     // Catch: java.lang.Throwable -> L85
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128p1(r2, r6)     // Catch: java.lang.Throwable -> L85
            r6 = 4
            if (r5 != r6) goto L29
            int r5 = r7.readUleb128p1()     // Catch: java.lang.Throwable -> L85
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128p1(r2, r5)     // Catch: java.lang.Throwable -> L85
            goto L29
        L60:
            int r5 = r7.readSleb128()     // Catch: java.lang.Throwable -> L85
            com.tencent.tinker.android.dex.Leb128.writeSignedLeb128(r2, r5)     // Catch: java.lang.Throwable -> L85
            goto L29
        L68:
            int r5 = r7.readUleb128()     // Catch: java.lang.Throwable -> L85
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128(r2, r5)     // Catch: java.lang.Throwable -> L85
            goto L29
        L70:
            byte[] r2 = r4.toByteArray()     // Catch: java.lang.Throwable -> L85
            com.tencent.tinker.android.dex.DebugInfoItem r5 = new com.tencent.tinker.android.dex.DebugInfoItem     // Catch: java.lang.Throwable -> L85
            r5.<init>(r0, r1, r3, r2)     // Catch: java.lang.Throwable -> L85
            r4.close()     // Catch: java.lang.Exception -> L7c
        L7c:
            return r5
        L7d:
            int r5 = r7.readUleb128p1()     // Catch: java.lang.Throwable -> L85
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128p1(r2, r5)     // Catch: java.lang.Throwable -> L85
            goto L29
        L85:
            r0 = move-exception
            r2 = r4
            goto L89
        L88:
            r0 = move-exception
        L89:
            if (r2 == 0) goto L8e
            r2.close()     // Catch: java.lang.Exception -> L8e
        L8e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.dex.io.DexDataBuffer.readDebugInfoItem():com.tencent.tinker.android.dex.DebugInfoItem");
    }

    public void writeSleb128(int i) {
        Leb128.writeSignedLeb128(this, i);
    }

    public void writeUleb128(int i) {
        Leb128.writeUnsignedLeb128(this, i);
    }

    public byte[] readByteArray(int i) {
        byte[] bArr = new byte[i];
        this.data.get(bArr);
        return bArr;
    }

    public void writeUleb128p1(int i) {
        writeUleb128(i + 1);
    }

    public void position(int i) {
        this.data.position(i);
    }

    public void skipWithAutoExpand(int i) {
        ensureBufferSize(i * 1);
        skip(i);
    }

    public int writeEncodedArray(EncodedValue encodedValue) {
        int position = this.data.position();
        write(encodedValue.data);
        return position;
    }

    public DexDataBuffer(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.dataBound = byteBuffer.limit();
        this.isResizeAllowed = false;
    }

    private byte[] getBytesFrom(int i) {
        byte[] bArr = new byte[this.data.position() - i];
        this.data.position(i);
        this.data.get(bArr);
        return bArr;
    }

    private ClassData.Field[] readFields(int i) {
        ClassData.Field[] fieldArr = new ClassData.Field[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += readUleb128();
            fieldArr[i3] = new ClassData.Field(i2, readUleb128());
        }
        return fieldArr;
    }

    private ClassData.Method[] readMethods(int i) {
        ClassData.Method[] methodArr = new ClassData.Method[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += readUleb128();
            methodArr[i3] = new ClassData.Method(i2, readUleb128(), readUleb128());
        }
        return methodArr;
    }

    private void writeFields(ClassData.Field[] fieldArr) {
        int i = 0;
        for (ClassData.Field field : fieldArr) {
            writeUleb128(field.fieldIndex - i);
            i = field.fieldIndex;
            writeUleb128(field.accessFlags);
        }
    }

    private void writeMethods(ClassData.Method[] methodArr) {
        int i = 0;
        for (ClassData.Method method : methodArr) {
            writeUleb128(method.methodIndex - i);
            i = method.methodIndex;
            writeUleb128(method.accessFlags);
            writeUleb128(method.codeOffset);
        }
    }

    public short[] readShortArray(int i) {
        if (i == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = readShort();
        }
        return sArr;
    }

    public void skip(int i) {
        if (i >= 0) {
            ByteBuffer byteBuffer = this.data;
            byteBuffer.position(byteBuffer.position() + i);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void write(byte[] bArr) {
        ensureBufferSize(bArr.length * 1);
        this.data.put(bArr);
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public int writeAnnotation(Annotation annotation) {
        int position = this.data.position();
        writeByte(annotation.visibility);
        writeEncodedArray(annotation.encodedAnnotation);
        return position;
    }

    public int writeAnnotationSet(AnnotationSet annotationSet) {
        int position = this.data.position();
        writeInt(annotationSet.annotationOffsets.length);
        for (int i : annotationSet.annotationOffsets) {
            writeInt(i);
        }
        return position;
    }

    public int writeAnnotationSetRefList(AnnotationSetRefList annotationSetRefList) {
        int position = this.data.position();
        writeInt(annotationSetRefList.annotationSetRefItems.length);
        for (int i : annotationSetRefList.annotationSetRefItems) {
            writeInt(i);
        }
        return position;
    }

    @Override // com.tencent.tinker.android.dex.util.ByteOutput
    public void writeByte(int i) {
        ensureBufferSize(1);
        this.data.put((byte) i);
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public int writeFieldId(FieldId fieldId) {
        int position = this.data.position();
        writeUnsignedShort(fieldId.declaringClassIndex);
        writeUnsignedShort(fieldId.typeIndex);
        writeInt(fieldId.nameIndex);
        return position;
    }

    public void writeInt(int i) {
        ensureBufferSize(4);
        this.data.putInt(i);
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public int writeMethodId(MethodId methodId) {
        int position = this.data.position();
        writeUnsignedShort(methodId.declaringClassIndex);
        writeUnsignedShort(methodId.protoIndex);
        writeInt(methodId.nameIndex);
        return position;
    }

    public int writeProtoId(ProtoId protoId) {
        int position = this.data.position();
        writeInt(protoId.shortyIndex);
        writeInt(protoId.returnTypeIndex);
        writeInt(protoId.parametersOffset);
        return position;
    }

    public void writeShort(short s) {
        ensureBufferSize(2);
        this.data.putShort(s);
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public int writeTypeList(TypeList typeList) {
        int position = this.data.position();
        short[] sArr = typeList.types;
        writeInt(sArr.length);
        for (short s : sArr) {
            writeShort(s);
        }
        return position;
    }

    private Code.CatchHandler readCatchHandler(int i) {
        int i2;
        int readSleb128 = readSleb128();
        int abs = Math.abs(readSleb128);
        int[] iArr = new int[abs];
        int[] iArr2 = new int[abs];
        for (int i3 = 0; i3 < abs; i3++) {
            iArr[i3] = readUleb128();
            iArr2[i3] = readUleb128();
        }
        if (readSleb128 <= 0) {
            i2 = readUleb128();
        } else {
            i2 = -1;
        }
        return new Code.CatchHandler(iArr, iArr2, i2, i);
    }

    private void writeCatchHandler(Code.CatchHandler catchHandler) {
        int i = catchHandler.catchAllAddress;
        int[] iArr = catchHandler.typeIndexes;
        int[] iArr2 = catchHandler.addresses;
        if (i != -1) {
            writeSleb128(-iArr.length);
        } else {
            writeSleb128(iArr.length);
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            writeUleb128(iArr[i2]);
            writeUleb128(iArr2[i2]);
        }
        if (i != -1) {
            writeUleb128(i);
        }
    }

    private int[] writeCatchHandlers(Code.CatchHandler[] catchHandlerArr) {
        int position = this.data.position();
        writeUleb128(catchHandlerArr.length);
        int[] iArr = new int[catchHandlerArr.length];
        for (int i = 0; i < catchHandlerArr.length; i++) {
            iArr[i] = this.data.position() - position;
            writeCatchHandler(catchHandlerArr[i]);
        }
        return iArr;
    }

    public void write(short[] sArr) {
        ensureBufferSize(sArr.length * 2);
        for (short s : sArr) {
            writeShort(s);
        }
        if (this.data.position() > this.dataBound) {
            this.dataBound = this.data.position();
        }
    }

    public int writeClassData(ClassData classData) {
        int position = this.data.position();
        writeUleb128(classData.staticFields.length);
        writeUleb128(classData.instanceFields.length);
        writeUleb128(classData.directMethods.length);
        writeUleb128(classData.virtualMethods.length);
        writeFields(classData.staticFields);
        writeFields(classData.instanceFields);
        writeMethods(classData.directMethods);
        writeMethods(classData.virtualMethods);
        return position;
    }

    public int writeClassDef(ClassDef classDef) {
        int position = this.data.position();
        writeInt(classDef.typeIndex);
        writeInt(classDef.accessFlags);
        writeInt(classDef.supertypeIndex);
        writeInt(classDef.interfacesOffset);
        writeInt(classDef.sourceFileIndex);
        writeInt(classDef.annotationsOffset);
        writeInt(classDef.classDataOffset);
        writeInt(classDef.staticValuesOffset);
        return position;
    }

    public int writeDebugInfoItem(DebugInfoItem debugInfoItem) {
        int position = this.data.position();
        writeUleb128(debugInfoItem.lineStart);
        int length = debugInfoItem.parameterNames.length;
        writeUleb128(length);
        for (int i = 0; i < length; i++) {
            writeUleb128p1(debugInfoItem.parameterNames[i]);
        }
        write(debugInfoItem.infoSTM);
        return position;
    }

    public int writeStringData(StringData stringData) {
        int position = this.data.position();
        try {
            writeUleb128(stringData.value.length());
            write(Mutf8.encode(stringData.value));
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e) {
            throw new AssertionError(e);
        }
    }

    public void writeUnsignedShort(int i) {
        short s = (short) i;
        if (i == (65535 & s)) {
            writeShort(s);
            return;
        }
        throw new IllegalArgumentException("Expected an unsigned short: " + i);
    }

    private void ensureBufferSize(int i) {
        if (this.data.position() + i > this.data.limit() && this.isResizeAllowed) {
            byte[] array = this.data.array();
            byte[] bArr = new byte[array.length + i + (array.length >> 1)];
            System.arraycopy(array, 0, bArr, 0, this.data.position());
            int position = this.data.position();
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.data = wrap;
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            this.data.position(position);
            ByteBuffer byteBuffer = this.data;
            byteBuffer.limit(byteBuffer.capacity());
        }
    }

    public int writeAnnotationsDirectory(AnnotationsDirectory annotationsDirectory) {
        int position = this.data.position();
        writeInt(annotationsDirectory.classAnnotationsOffset);
        writeInt(annotationsDirectory.fieldAnnotations.length);
        writeInt(annotationsDirectory.methodAnnotations.length);
        writeInt(annotationsDirectory.parameterAnnotations.length);
        for (int[] iArr : annotationsDirectory.fieldAnnotations) {
            writeInt(iArr[0]);
            writeInt(iArr[1]);
        }
        for (int[] iArr2 : annotationsDirectory.methodAnnotations) {
            writeInt(iArr2[0]);
            writeInt(iArr2[1]);
        }
        for (int[] iArr3 : annotationsDirectory.parameterAnnotations) {
            writeInt(iArr3[0]);
            writeInt(iArr3[1]);
        }
        return position;
    }

    public int writeCode(Code code) {
        int position = this.data.position();
        writeUnsignedShort(code.registersSize);
        writeUnsignedShort(code.insSize);
        writeUnsignedShort(code.outsSize);
        writeUnsignedShort(code.tries.length);
        writeInt(code.debugInfoOffset);
        writeInt(code.instructions.length);
        write(code.instructions);
        if (code.tries.length > 0) {
            if ((code.instructions.length & 1) == 1) {
                writeShort((short) 0);
            }
            int position2 = this.data.position();
            skipWithAutoExpand(code.tries.length * 8);
            int[] writeCatchHandlers = writeCatchHandlers(code.catchHandlers);
            int position3 = this.data.position();
            this.data.position(position2);
            writeTries(code.tries, writeCatchHandlers);
            this.data.position(position3);
        }
        return position;
    }

    private int findCatchHandlerIndex(Code.CatchHandler[] catchHandlerArr, int i) {
        for (int i2 = 0; i2 < catchHandlerArr.length; i2++) {
            if (catchHandlerArr[i2].offset == i) {
                return i2;
            }
        }
        throw new IllegalArgumentException();
    }

    private Code.Try[] readTries(int i, Code.CatchHandler[] catchHandlerArr) {
        Code.Try[] tryArr = new Code.Try[i];
        for (int i2 = 0; i2 < i; i2++) {
            tryArr[i2] = new Code.Try(readInt(), readUnsignedShort(), findCatchHandlerIndex(catchHandlerArr, readUnsignedShort()));
        }
        return tryArr;
    }

    private void writeTries(Code.Try[] tryArr, int[] iArr) {
        for (Code.Try r2 : tryArr) {
            writeInt(r2.startAddress);
            writeUnsignedShort(r2.instructionCount);
            writeUnsignedShort(iArr[r2.catchHandlerIndex]);
        }
    }

    public DexDataBuffer(ByteBuffer byteBuffer, boolean z) {
        this.data = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        this.dataBound = byteBuffer.limit();
        this.isResizeAllowed = z;
    }
}
