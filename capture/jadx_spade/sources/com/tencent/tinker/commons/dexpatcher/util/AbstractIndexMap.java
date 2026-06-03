package com.tencent.tinker.commons.dexpatcher.util;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
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
import com.tencent.tinker.android.dex.EncodedValueCodec;
import com.tencent.tinker.android.dex.EncodedValueReader;
import com.tencent.tinker.android.dex.FieldId;
import com.tencent.tinker.android.dex.Leb128;
import com.tencent.tinker.android.dex.MethodId;
import com.tencent.tinker.android.dex.ProtoId;
import com.tencent.tinker.android.dex.TypeList;
import com.tencent.tinker.android.dex.util.ByteOutput;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class AbstractIndexMap {
    static {
        Covode.recordClassIndex(653673);
    }

    public abstract int adjustAnnotationOffset(int i);

    public abstract int adjustAnnotationSetOffset(int i);

    public abstract int adjustAnnotationSetRefListOffset(int i);

    public abstract int adjustAnnotationsDirectoryOffset(int i);

    public abstract int adjustClassDataOffset(int i);

    public abstract int adjustCodeOffset(int i);

    public abstract int adjustDebugInfoItemOffset(int i);

    public abstract int adjustFieldIdIndex(int i);

    public abstract int adjustMethodIdIndex(int i);

    public abstract int adjustProtoIdIndex(int i);

    public abstract int adjustStaticValuesOffset(int i);

    public abstract int adjustStringIndex(int i);

    public abstract int adjustTypeIdIndex(int i);

    public abstract int adjustTypeListOffset(int i);

    public TypeList adjust(TypeList typeList) {
        if (typeList == TypeList.EMPTY) {
            return typeList;
        }
        int length = typeList.types.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = (short) adjustTypeIdIndex(typeList.types[i]);
        }
        return new TypeList(typeList.off, sArr);
    }

    public MethodId adjust(MethodId methodId) {
        return new MethodId(methodId.off, adjustTypeIdIndex(methodId.declaringClassIndex), adjustProtoIdIndex(methodId.protoIndex), adjustStringIndex(methodId.nameIndex));
    }

    public FieldId adjust(FieldId fieldId) {
        return new FieldId(fieldId.off, adjustTypeIdIndex(fieldId.declaringClassIndex), adjustTypeIdIndex(fieldId.typeIndex), adjustStringIndex(fieldId.nameIndex));
    }

    public ProtoId adjust(ProtoId protoId) {
        return new ProtoId(protoId.off, adjustStringIndex(protoId.shortyIndex), adjustTypeIdIndex(protoId.returnTypeIndex), adjustTypeListOffset(protoId.parametersOffset));
    }

    public DebugInfoItem adjust(DebugInfoItem debugInfoItem) {
        return new DebugInfoItem(debugInfoItem.off, debugInfoItem.lineStart, adjustParameterNames(debugInfoItem.parameterNames), adjustDebugInfoItemSTM(debugInfoItem.infoSTM));
    }

    public EncodedValue adjust(EncodedValue encodedValue) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(encodedValue.data.length);
        new EncodedValueTransformer(new ByteOutput() { // from class: com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap.3
            @Override // com.tencent.tinker.android.dex.util.ByteOutput
            public void writeByte(int i) {
                byteArrayOutputStream.write(i);
            }
        }).transformArray(new EncodedValueReader(encodedValue, 28));
        return new EncodedValue(encodedValue.off, byteArrayOutputStream.toByteArray());
    }

    private short[] adjustInstructions(short[] sArr) {
        if (sArr != null && sArr.length != 0) {
            return new InstructionTransformer(this).transform(sArr);
        }
        return sArr;
    }

    private final class EncodedValueTransformer {
        private final ByteOutput out;

        static {
            Covode.recordClassIndex(653674);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformArray(EncodedValueReader encodedValueReader) {
            int readArray = encodedValueReader.readArray();
            Leb128.writeUnsignedLeb128(this.out, readArray);
            for (int i = 0; i < readArray; i++) {
                transform(encodedValueReader);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformAnnotation(EncodedValueReader encodedValueReader) {
            int readAnnotation = encodedValueReader.readAnnotation();
            Leb128.writeUnsignedLeb128(this.out, AbstractIndexMap.this.adjustTypeIdIndex(encodedValueReader.getAnnotationType()));
            Leb128.writeUnsignedLeb128(this.out, readAnnotation);
            for (int i = 0; i < readAnnotation; i++) {
                Leb128.writeUnsignedLeb128(this.out, AbstractIndexMap.this.adjustStringIndex(encodedValueReader.readAnnotationName()));
                transform(encodedValueReader);
            }
        }

        public void transform(EncodedValueReader encodedValueReader) {
            int peek = encodedValueReader.peek();
            if (peek != 0) {
                if (peek != 6) {
                    if (peek != 2) {
                        if (peek != 3) {
                            if (peek != 4) {
                                if (peek != 16) {
                                    if (peek != 17) {
                                        switch (peek) {
                                            case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 23, AbstractIndexMap.this.adjustStringIndex(encodedValueReader.readString()));
                                                return;
                                            case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 24, AbstractIndexMap.this.adjustTypeIdIndex(encodedValueReader.readType()));
                                                return;
                                            case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 25, AbstractIndexMap.this.adjustFieldIdIndex(encodedValueReader.readField()));
                                                return;
                                            case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 26, AbstractIndexMap.this.adjustMethodIdIndex(encodedValueReader.readMethod()));
                                                return;
                                            case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 27, AbstractIndexMap.this.adjustFieldIdIndex(encodedValueReader.readEnum()));
                                                return;
                                            case 28:
                                                writeTypeAndArg(28, 0);
                                                transformArray(encodedValueReader);
                                                return;
                                            case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                                                writeTypeAndArg(29, 0);
                                                transformAnnotation(encodedValueReader);
                                                return;
                                            case 30:
                                                encodedValueReader.readNull();
                                                writeTypeAndArg(30, 0);
                                                return;
                                            case 31:
                                                writeTypeAndArg(31, encodedValueReader.readBoolean() ? 1 : 0);
                                                return;
                                            default:
                                                throw new DexException("Unexpected type: " + Integer.toHexString(encodedValueReader.peek()));
                                        }
                                    }
                                    EncodedValueCodec.writeRightZeroExtendedValue(this.out, 17, Double.doubleToLongBits(encodedValueReader.readDouble()));
                                    return;
                                }
                                EncodedValueCodec.writeRightZeroExtendedValue(this.out, 16, Float.floatToIntBits(encodedValueReader.readFloat()) << 32);
                                return;
                            }
                            EncodedValueCodec.writeSignedIntegralValue(this.out, 4, encodedValueReader.readInt());
                            return;
                        }
                        EncodedValueCodec.writeUnsignedIntegralValue(this.out, 3, encodedValueReader.readChar());
                        return;
                    }
                    EncodedValueCodec.writeSignedIntegralValue(this.out, 2, encodedValueReader.readShort());
                    return;
                }
                EncodedValueCodec.writeSignedIntegralValue(this.out, 6, encodedValueReader.readLong());
                return;
            }
            EncodedValueCodec.writeSignedIntegralValue(this.out, 0, encodedValueReader.readByte());
        }

        EncodedValueTransformer(ByteOutput byteOutput) {
            this.out = byteOutput;
        }

        private void writeTypeAndArg(int i, int i2) {
            this.out.writeByte(i | (i2 << 5));
        }
    }

    private ClassData.Field[] adjustFields(ClassData.Field[] fieldArr) {
        ClassData.Field[] fieldArr2 = new ClassData.Field[fieldArr.length];
        for (int i = 0; i < fieldArr.length; i++) {
            ClassData.Field field = fieldArr[i];
            fieldArr2[i] = new ClassData.Field(adjustFieldIdIndex(field.fieldIndex), field.accessFlags);
        }
        return fieldArr2;
    }

    private int[] adjustParameterNames(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = adjustStringIndex(iArr[i]);
        }
        return iArr2;
    }

    public AnnotationSet adjust(AnnotationSet annotationSet) {
        int length = annotationSet.annotationOffsets.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = adjustAnnotationOffset(annotationSet.annotationOffsets[i]);
        }
        return new AnnotationSet(annotationSet.off, iArr);
    }

    private Code.CatchHandler[] adjustCatchHandlers(Code.CatchHandler[] catchHandlerArr) {
        if (catchHandlerArr != null && catchHandlerArr.length != 0) {
            Code.CatchHandler[] catchHandlerArr2 = new Code.CatchHandler[catchHandlerArr.length];
            for (int i = 0; i < catchHandlerArr.length; i++) {
                Code.CatchHandler catchHandler = catchHandlerArr[i];
                int length = catchHandler.typeIndexes.length;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = adjustTypeIdIndex(catchHandler.typeIndexes[i2]);
                }
                catchHandlerArr2[i] = new Code.CatchHandler(iArr, catchHandler.addresses, catchHandler.catchAllAddress, catchHandler.offset);
            }
            return catchHandlerArr2;
        }
        return catchHandlerArr;
    }

    private ClassData.Method[] adjustMethods(ClassData.Method[] methodArr) {
        ClassData.Method[] methodArr2 = new ClassData.Method[methodArr.length];
        for (int i = 0; i < methodArr.length; i++) {
            ClassData.Method method = methodArr[i];
            methodArr2[i] = new ClassData.Method(adjustMethodIdIndex(method.methodIndex), method.accessFlags, adjustCodeOffset(method.codeOffset));
        }
        return methodArr2;
    }

    public Annotation adjust(Annotation annotation) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(annotation.encodedAnnotation.data.length);
        new EncodedValueTransformer(new ByteOutput() { // from class: com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap.4
            @Override // com.tencent.tinker.android.dex.util.ByteOutput
            public void writeByte(int i) {
                byteArrayOutputStream.write(i);
            }
        }).transformAnnotation(annotation.getReader());
        return new Annotation(annotation.off, annotation.visibility, new EncodedValue(annotation.encodedAnnotation.off, byteArrayOutputStream.toByteArray()));
    }

    public AnnotationSetRefList adjust(AnnotationSetRefList annotationSetRefList) {
        int length = annotationSetRefList.annotationSetRefItems.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = adjustAnnotationSetOffset(annotationSetRefList.annotationSetRefItems[i]);
        }
        return new AnnotationSetRefList(annotationSetRefList.off, iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        return r2.toByteArray();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] adjustDebugInfoItemSTM(byte[] r6) {
        /*
            r5 = this;
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r6)
            com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap$1 r1 = new com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap$1
            r1.<init>()
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            int r6 = r6.length
            int r6 = r6 + 512
            r2.<init>(r6)
            com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap$2 r6 = new com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap$2
            r6.<init>()
        L17:
            int r3 = r0.read()
            r3 = r3 & 255(0xff, float:3.57E-43)
            r2.write(r3)
            r4 = 9
            if (r3 == r4) goto L71
            switch(r3) {
                case 0: goto L6c;
                case 1: goto L64;
                case 2: goto L5c;
                case 3: goto L30;
                case 4: goto L30;
                case 5: goto L28;
                case 6: goto L28;
                default: goto L27;
            }
        L27:
            goto L17
        L28:
            int r3 = com.tencent.tinker.android.dex.Leb128.readUnsignedLeb128(r1)
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128(r6, r3)
            goto L17
        L30:
            int r4 = com.tencent.tinker.android.dex.Leb128.readUnsignedLeb128(r1)
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128(r6, r4)
            int r4 = com.tencent.tinker.android.dex.Leb128.readUnsignedLeb128p1(r1)
            int r4 = r5.adjustStringIndex(r4)
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128p1(r6, r4)
            int r4 = com.tencent.tinker.android.dex.Leb128.readUnsignedLeb128p1(r1)
            int r4 = r5.adjustTypeIdIndex(r4)
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128p1(r6, r4)
            r4 = 4
            if (r3 != r4) goto L17
            int r3 = com.tencent.tinker.android.dex.Leb128.readUnsignedLeb128p1(r1)
            int r3 = r5.adjustStringIndex(r3)
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128p1(r6, r3)
            goto L17
        L5c:
            int r3 = com.tencent.tinker.android.dex.Leb128.readSignedLeb128(r1)
            com.tencent.tinker.android.dex.Leb128.writeSignedLeb128(r6, r3)
            goto L17
        L64:
            int r3 = com.tencent.tinker.android.dex.Leb128.readUnsignedLeb128(r1)
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128(r6, r3)
            goto L17
        L6c:
            byte[] r6 = r2.toByteArray()
            return r6
        L71:
            int r3 = com.tencent.tinker.android.dex.Leb128.readUnsignedLeb128p1(r1)
            int r3 = r5.adjustStringIndex(r3)
            com.tencent.tinker.android.dex.Leb128.writeUnsignedLeb128p1(r6, r3)
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.commons.dexpatcher.util.AbstractIndexMap.adjustDebugInfoItemSTM(byte[]):byte[]");
    }

    public AnnotationsDirectory adjust(AnnotationsDirectory annotationsDirectory) {
        int adjustAnnotationSetOffset = adjustAnnotationSetOffset(annotationsDirectory.classAnnotationsOffset);
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, annotationsDirectory.fieldAnnotations.length, 2);
        for (int i = 0; i < iArr.length; i++) {
            iArr[i][0] = adjustFieldIdIndex(annotationsDirectory.fieldAnnotations[i][0]);
            iArr[i][1] = adjustAnnotationSetOffset(annotationsDirectory.fieldAnnotations[i][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, annotationsDirectory.methodAnnotations.length, 2);
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            iArr2[i2][0] = adjustMethodIdIndex(annotationsDirectory.methodAnnotations[i2][0]);
            iArr2[i2][1] = adjustAnnotationSetOffset(annotationsDirectory.methodAnnotations[i2][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, annotationsDirectory.parameterAnnotations.length, 2);
        for (int i3 = 0; i3 < iArr3.length; i3++) {
            iArr3[i3][0] = adjustMethodIdIndex(annotationsDirectory.parameterAnnotations[i3][0]);
            iArr3[i3][1] = adjustAnnotationSetRefListOffset(annotationsDirectory.parameterAnnotations[i3][1]);
        }
        return new AnnotationsDirectory(annotationsDirectory.off, adjustAnnotationSetOffset, iArr, iArr2, iArr3);
    }

    public ClassData adjust(ClassData classData) {
        return new ClassData(classData.off, adjustFields(classData.staticFields), adjustFields(classData.instanceFields), adjustMethods(classData.directMethods), adjustMethods(classData.virtualMethods));
    }

    public ClassDef adjust(ClassDef classDef) {
        return new ClassDef(classDef.off, adjustTypeIdIndex(classDef.typeIndex), classDef.accessFlags, adjustTypeIdIndex(classDef.supertypeIndex), adjustTypeListOffset(classDef.interfacesOffset), adjustStringIndex(classDef.sourceFileIndex), adjustAnnotationsDirectoryOffset(classDef.annotationsOffset), adjustClassDataOffset(classDef.classDataOffset), adjustStaticValuesOffset(classDef.staticValuesOffset));
    }

    public Code adjust(Code code) {
        return new Code(code.off, code.registersSize, code.insSize, code.outsSize, adjustDebugInfoItemOffset(code.debugInfoOffset), adjustInstructions(code.instructions), code.tries, adjustCatchHandlers(code.catchHandlers));
    }
}
