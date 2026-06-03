package com.tencent.tinker.android.dex;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.tencent.tinker.android.dex.ClassData;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.io.DexDataBuffer;
import com.tencent.tinker.android.dex.util.FileUtils;
import com.tencent.tinker.android.dx.util.Hex;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Dex {
    static final short[] EMPTY_SHORT_ARRAY;
    private final ClassDefTable classDefs;
    private ByteBuffer data;
    private final FieldIdTable fieldIds;
    private final MethodIdTable methodIds;
    private int nextSectionStart;
    private final ProtoIdTable protoIds;
    private byte[] signature;
    private final StringTable strings;
    private final TableOfContents tableOfContents;
    private final TypeIndexToDescriptorIndexTable typeIds;
    private final TypeIndexToDescriptorTable typeNames;

    public List<ClassDef> classDefs() {
        return this.classDefs;
    }

    public List<FieldId> fieldIds() {
        return this.fieldIds;
    }

    public int getNextSectionStart() {
        return this.nextSectionStart;
    }

    public TableOfContents getTableOfContents() {
        return this.tableOfContents;
    }

    public List<MethodId> methodIds() {
        return this.methodIds;
    }

    public List<ProtoId> protoIds() {
        return this.protoIds;
    }

    public List<String> strings() {
        return this.strings;
    }

    public List<Integer> typeIds() {
        return this.typeIds;
    }

    public List<String> typeNames() {
        return this.typeNames;
    }

    private final class ClassDefIterator implements Iterator<ClassDef> {
        private int count;
        private final Section in;

        static {
            Covode.recordClassIndex(653597);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.count < Dex.this.tableOfContents.classDefs.size) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ClassDef next() {
            if (hasNext()) {
                this.count++;
                return this.in.readClassDef();
            }
            throw new NoSuchElementException();
        }

        private ClassDefIterator() {
            this.in = Dex.this.openSection(Dex.this.tableOfContents.classDefs);
            this.count = 0;
        }
    }

    public Iterable<ClassDef> classDefIterable() {
        return new ClassDefIterable();
    }

    public int getLength() {
        return this.data.capacity();
    }

    private final class ClassDefTable extends AbstractList<ClassDef> implements RandomAccess {
        static {
            Covode.recordClassIndex(653598);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.classDefs.size;
        }

        private ClassDefTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public ClassDef get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.classDefs.size);
            Dex dex = Dex.this;
            return dex.openSection(dex.tableOfContents.classDefs.off + (i * 32)).readClassDef();
        }
    }

    private final class FieldIdTable extends AbstractList<FieldId> implements RandomAccess {
        static {
            Covode.recordClassIndex(653599);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.fieldIds.size;
        }

        private FieldIdTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public FieldId get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.fieldIds.size);
            Dex dex = Dex.this;
            return dex.openSection(dex.tableOfContents.fieldIds.off + (i * 8)).readFieldId();
        }
    }

    private final class MethodIdTable extends AbstractList<MethodId> implements RandomAccess {
        static {
            Covode.recordClassIndex(653600);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.methodIds.size;
        }

        private MethodIdTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public MethodId get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.methodIds.size);
            Dex dex = Dex.this;
            return dex.openSection(dex.tableOfContents.methodIds.off + (i * 8)).readMethodId();
        }
    }

    private final class ProtoIdTable extends AbstractList<ProtoId> implements RandomAccess {
        static {
            Covode.recordClassIndex(653601);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.protoIds.size;
        }

        private ProtoIdTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public ProtoId get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.protoIds.size);
            Dex dex = Dex.this;
            return dex.openSection(dex.tableOfContents.protoIds.off + (i * 12)).readProtoId();
        }
    }

    private final class StringTable extends AbstractList<String> implements RandomAccess {
        static {
            Covode.recordClassIndex(653603);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.stringIds.size;
        }

        private StringTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public String get(int i) {
            Dex.checkBounds(i, Dex.this.tableOfContents.stringIds.size);
            Dex dex = Dex.this;
            return Dex.this.openSection(dex.openSection(dex.tableOfContents.stringIds.off + (i * 4)).readInt()).readStringData().value;
        }
    }

    private final class TypeIndexToDescriptorIndexTable extends AbstractList<Integer> implements RandomAccess {
        static {
            Covode.recordClassIndex(653604);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.typeIds.size;
        }

        private TypeIndexToDescriptorIndexTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i) {
            return Integer.valueOf(Dex.this.descriptorIndexFromTypeIndex(i));
        }
    }

    private final class TypeIndexToDescriptorTable extends AbstractList<String> implements RandomAccess {
        static {
            Covode.recordClassIndex(653605);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.typeIds.size;
        }

        private TypeIndexToDescriptorTable() {
        }

        @Override // java.util.AbstractList, java.util.List
        public String get(int i) {
            return Dex.this.strings.get(Dex.this.descriptorIndexFromTypeIndex(i));
        }
    }

    static {
        Covode.recordClassIndex(653595);
        EMPTY_SHORT_ARRAY = new short[0];
    }

    private final class ClassDefIterable implements Iterable<ClassDef> {
        static {
            Covode.recordClassIndex(653596);
        }

        @Override // java.lang.Iterable
        public Iterator<ClassDef> iterator() {
            if (!Dex.this.tableOfContents.classDefs.exists()) {
                return Collections.emptySet().iterator();
            }
            return new ClassDefIterator();
        }

        private ClassDefIterable() {
        }
    }

    public final class Section extends DexDataBuffer {
        private final String name;

        static {
            Covode.recordClassIndex(653602);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public Annotation readAnnotation() {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotations, false);
            return super.readAnnotation();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public AnnotationSet readAnnotationSet() {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationSets, false);
            return super.readAnnotationSet();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public AnnotationSetRefList readAnnotationSetRefList() {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationSetRefLists, false);
            return super.readAnnotationSetRefList();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public AnnotationsDirectory readAnnotationsDirectory() {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationsDirectories, false);
            return super.readAnnotationsDirectory();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public ClassData readClassData() {
            ensureFourBytesAligned(Dex.this.tableOfContents.classDatas, false);
            return super.readClassData();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public ClassDef readClassDef() {
            ensureFourBytesAligned(Dex.this.tableOfContents.classDefs, false);
            return super.readClassDef();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public Code readCode() {
            ensureFourBytesAligned(Dex.this.tableOfContents.codes, false);
            return super.readCode();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public DebugInfoItem readDebugInfoItem() {
            ensureFourBytesAligned(Dex.this.tableOfContents.debugInfos, false);
            return super.readDebugInfoItem();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public EncodedValue readEncodedArray() {
            ensureFourBytesAligned(Dex.this.tableOfContents.encodedArrays, false);
            return super.readEncodedArray();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public FieldId readFieldId() {
            ensureFourBytesAligned(Dex.this.tableOfContents.fieldIds, false);
            return super.readFieldId();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public MethodId readMethodId() {
            ensureFourBytesAligned(Dex.this.tableOfContents.methodIds, false);
            return super.readMethodId();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public ProtoId readProtoId() {
            ensureFourBytesAligned(Dex.this.tableOfContents.protoIds, false);
            return super.readProtoId();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public StringData readStringData() {
            ensureFourBytesAligned(Dex.this.tableOfContents.stringDatas, false);
            return super.readStringData();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public TypeList readTypeList() {
            ensureFourBytesAligned(Dex.this.tableOfContents.typeLists, false);
            return super.readTypeList();
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeAnnotation(Annotation annotation) {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotations, true);
            return super.writeAnnotation(annotation);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeAnnotationSet(AnnotationSet annotationSet) {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationSets, true);
            return super.writeAnnotationSet(annotationSet);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeAnnotationSetRefList(AnnotationSetRefList annotationSetRefList) {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationSetRefLists, true);
            return super.writeAnnotationSetRefList(annotationSetRefList);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeAnnotationsDirectory(AnnotationsDirectory annotationsDirectory) {
            ensureFourBytesAligned(Dex.this.tableOfContents.annotationsDirectories, true);
            return super.writeAnnotationsDirectory(annotationsDirectory);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeClassData(ClassData classData) {
            ensureFourBytesAligned(Dex.this.tableOfContents.classDatas, true);
            return super.writeClassData(classData);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeClassDef(ClassDef classDef) {
            ensureFourBytesAligned(Dex.this.tableOfContents.classDefs, true);
            return super.writeClassDef(classDef);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeCode(Code code) {
            ensureFourBytesAligned(Dex.this.tableOfContents.codes, true);
            return super.writeCode(code);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeDebugInfoItem(DebugInfoItem debugInfoItem) {
            ensureFourBytesAligned(Dex.this.tableOfContents.debugInfos, true);
            return super.writeDebugInfoItem(debugInfoItem);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeEncodedArray(EncodedValue encodedValue) {
            ensureFourBytesAligned(Dex.this.tableOfContents.encodedArrays, true);
            return super.writeEncodedArray(encodedValue);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeFieldId(FieldId fieldId) {
            ensureFourBytesAligned(Dex.this.tableOfContents.fieldIds, true);
            return super.writeFieldId(fieldId);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeMethodId(MethodId methodId) {
            ensureFourBytesAligned(Dex.this.tableOfContents.methodIds, true);
            return super.writeMethodId(methodId);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeProtoId(ProtoId protoId) {
            ensureFourBytesAligned(Dex.this.tableOfContents.protoIds, true);
            return super.writeProtoId(protoId);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeStringData(StringData stringData) {
            ensureFourBytesAligned(Dex.this.tableOfContents.stringDatas, true);
            return super.writeStringData(stringData);
        }

        @Override // com.tencent.tinker.android.dex.io.DexDataBuffer
        public int writeTypeList(TypeList typeList) {
            ensureFourBytesAligned(Dex.this.tableOfContents.typeLists, true);
            return super.writeTypeList(typeList);
        }

        private void ensureFourBytesAligned(TableOfContents.Section section, boolean z) {
            if (section.isElementFourByteAligned) {
                if (z) {
                    alignToFourBytesWithZeroFill();
                } else {
                    alignToFourBytes();
                }
            }
        }

        private Section(String str, ByteBuffer byteBuffer) {
            super(byteBuffer);
            this.name = str;
        }
    }

    public byte[] getBytes() {
        ByteBuffer duplicate = this.data.duplicate();
        byte[] bArr = new byte[duplicate.capacity()];
        duplicate.position(0);
        duplicate.get(bArr);
        return bArr;
    }

    public void writeHashes() throws IOException {
        openSection(12).write(computeSignature(true));
        openSection(8).writeInt(computeChecksum());
    }

    public int computeChecksum() throws IOException {
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.data.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        return (int) adler32.getValue();
    }

    public Dex(byte[] bArr) throws IOException {
        this(ByteBuffer.wrap(bArr));
    }

    private void loadFrom(InputStream inputStream) throws IOException {
        loadFrom(inputStream, 0);
    }

    public int findFieldIndex(FieldId fieldId) {
        return Collections.binarySearch(this.fieldIds, fieldId);
    }

    public int findMethodIndex(MethodId methodId) {
        return Collections.binarySearch(this.methodIds, methodId);
    }

    public int findStringIndex(String str) {
        return Collections.binarySearch(this.strings, str);
    }

    public int findTypeIndex(String str) {
        return Collections.binarySearch(this.typeNames, str);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.data.array());
        outputStream.flush();
    }

    private String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length << 1);
        for (byte b : bArr) {
            sb.append(Hex.u1(b));
        }
        return sb.toString();
    }

    public int declaringClassIndexFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        return this.data.getShort(this.tableOfContents.methodIds.off + (i * 8)) & 65535;
    }

    public int descriptorIndexFromTypeIndex(int i) {
        checkBounds(i, this.tableOfContents.typeIds.size);
        return this.data.getInt(this.tableOfContents.typeIds.off + (i * 4));
    }

    public int nameIndexFromFieldIndex(int i) {
        checkBounds(i, this.tableOfContents.fieldIds.size);
        return this.data.getInt(this.tableOfContents.fieldIds.off + (i * 8) + 2 + 2);
    }

    public int nameIndexFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        return this.data.getInt(this.tableOfContents.methodIds.off + (i * 8) + 2 + 2);
    }

    public ClassData readClassData(ClassDef classDef) {
        int i = classDef.classDataOffset;
        if (i != 0) {
            return openSection(i).readClassData();
        }
        throw new IllegalArgumentException("offset == 0");
    }

    public Code readCode(ClassData.Method method) {
        int i = method.codeOffset;
        if (i != 0) {
            return openSection(i).readCode();
        }
        throw new IllegalArgumentException("offset == 0");
    }

    public int typeIndexFromClassDefIndex(int i) {
        checkBounds(i, this.tableOfContents.classDefs.size);
        return this.data.getInt(this.tableOfContents.classDefs.off + (i * 32));
    }

    public int typeIndexFromFieldIndex(int i) {
        checkBounds(i, this.tableOfContents.fieldIds.size);
        return this.data.getShort(this.tableOfContents.fieldIds.off + (i * 8) + 2) & 65535;
    }

    public int annotationDirectoryOffsetFromClassDefIndex(int i) {
        checkBounds(i, this.tableOfContents.classDefs.size);
        return this.data.getInt(this.tableOfContents.classDefs.off + (i * 32) + 4 + 4 + 4 + 4 + 4);
    }

    public int findClassDefIndexFromTypeIndex(int i) {
        checkBounds(i, this.tableOfContents.typeIds.size);
        if (!this.tableOfContents.classDefs.exists()) {
            return -1;
        }
        for (int i2 = 0; i2 < this.tableOfContents.classDefs.size; i2++) {
            if (typeIndexFromClassDefIndex(i2) == i) {
                return i2;
            }
        }
        return -1;
    }

    public int returnTypeIndexFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        int i2 = this.data.getShort(this.tableOfContents.methodIds.off + (i * 8) + 2) & 65535;
        checkBounds(i2, this.tableOfContents.protoIds.size);
        return this.data.getInt(this.tableOfContents.protoIds.off + (i2 * 12) + 4);
    }

    public void writeTo(File file) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(file));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            writeTo(bufferedOutputStream);
            try {
                bufferedOutputStream.close();
            } catch (Exception unused) {
            }
        } catch (Exception e2) {
            e = e2;
            bufferedOutputStream2 = bufferedOutputStream;
            throw new DexException(e);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public Dex(int i) {
        TableOfContents tableOfContents = new TableOfContents();
        this.tableOfContents = tableOfContents;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.classDefs = new ClassDefTable();
        this.nextSectionStart = 0;
        this.signature = null;
        ByteBuffer wrap = ByteBuffer.wrap(new byte[i]);
        this.data = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        tableOfContents.fileSize = i;
    }

    public byte[] computeSignature(boolean z) {
        byte[] bArr = this.signature;
        if (bArr != null && !z) {
            return bArr;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr2 = new byte[8192];
            ByteBuffer duplicate = this.data.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(8192, duplicate.remaining());
                duplicate.get(bArr2, 0, min);
                messageDigest.update(bArr2, 0, min);
            }
            byte[] digest = messageDigest.digest();
            this.signature = digest;
            return digest;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public short[] interfaceTypeIndicesFromClassDef(ClassDef classDef) {
        int i = this.data.getInt(classDef.off + 4 + 4 + 4);
        if (i == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        int i2 = this.data.getInt(i);
        if (i2 > 0) {
            int i3 = i + 4;
            short[] sArr = new short[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                sArr[i4] = this.data.getShort(i3);
                i3 += 2;
            }
            return sArr;
        }
        throw new AssertionError("Unexpected interfaces list size: " + i2);
    }

    public short[] interfaceTypeIndicesFromClassDefIndex(int i) {
        checkBounds(i, this.tableOfContents.classDefs.size);
        int i2 = this.data.getInt(this.tableOfContents.classDefs.off + (i * 32) + 4 + 4 + 4);
        if (i2 == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        int i3 = this.data.getInt(i2);
        if (i3 > 0) {
            int i4 = i2 + 4;
            short[] sArr = new short[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                sArr[i5] = this.data.getShort(i4);
                i4 += 2;
            }
            return sArr;
        }
        throw new AssertionError("Unexpected interfaces list size: " + i3);
    }

    public Section openSection(int i) {
        if (i >= 0 && i < this.data.capacity()) {
            ByteBuffer duplicate = this.data.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            duplicate.position(i);
            duplicate.limit(this.data.capacity());
            return new Section("temp-section", duplicate);
        }
        throw new IllegalArgumentException("position=" + i + " length=" + this.data.capacity());
    }

    public short[] parameterTypeIndicesFromMethodId(MethodId methodId) {
        int i = methodId.protoIndex & 65535;
        checkBounds(i, this.tableOfContents.protoIds.size);
        int i2 = this.data.getInt(this.tableOfContents.protoIds.off + (i * 12) + 4 + 4);
        if (i2 == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        int i3 = this.data.getInt(i2);
        if (i3 > 0) {
            int i4 = i2 + 4;
            short[] sArr = new short[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                sArr[i5] = this.data.getShort(i4);
                i4 += 2;
            }
            return sArr;
        }
        throw new AssertionError("Unexpected parameter type list size: " + i3);
    }

    public short[] parameterTypeIndicesFromMethodIndex(int i) {
        checkBounds(i, this.tableOfContents.methodIds.size);
        int i2 = this.data.getShort(this.tableOfContents.methodIds.off + (i * 8) + 2) & 65535;
        checkBounds(i2, this.tableOfContents.protoIds.size);
        int i3 = this.data.getInt(this.tableOfContents.protoIds.off + (i2 * 12) + 4 + 4);
        if (i3 == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        int i4 = this.data.getInt(i3);
        if (i4 > 0) {
            int i5 = i3 + 4;
            short[] sArr = new short[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                sArr[i6] = this.data.getShort(i5);
                i5 += 2;
            }
            return sArr;
        }
        throw new AssertionError("Unexpected parameter type list size: " + i4);
    }

    public Dex(File file) throws IOException {
        PolarisZipFileWrapper polarisZipFileWrapper;
        PolarisZipFileWrapper bufferedInputStream;
        this.tableOfContents = new TableOfContents();
        PolarisZipFileWrapper polarisZipFileWrapper2 = null;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.classDefs = new ClassDefTable();
        this.nextSectionStart = 0;
        this.signature = null;
        if (file != null) {
            try {
                if (FileUtils.hasArchiveSuffix(file.getName())) {
                    try {
                        polarisZipFileWrapper = new PolarisZipFileWrapper(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        ZipEntry entry = polarisZipFileWrapper.getEntry("classes.dex");
                        if (entry != null) {
                            try {
                                polarisZipFileWrapper2 = polarisZipFileWrapper.getInputStream(entry);
                                loadFrom(polarisZipFileWrapper2, (int) entry.getSize());
                                polarisZipFileWrapper.close();
                            } finally {
                                if (polarisZipFileWrapper2 != null) {
                                    polarisZipFileWrapper2.close();
                                }
                            }
                        } else {
                            throw new DexException("Expected classes.dex in " + file);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        polarisZipFileWrapper2 = polarisZipFileWrapper;
                        if (polarisZipFileWrapper2 != null) {
                            try {
                                polarisZipFileWrapper2.close();
                            } catch (Exception unused) {
                            }
                        }
                        throw th;
                    }
                } else if (file.getName().endsWith(".dex")) {
                    try {
                        try {
                            bufferedInputStream = new BufferedInputStream(new PolarisFileInputStreamWrapper(file));
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        loadFrom(bufferedInputStream, (int) file.length());
                        bufferedInputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        polarisZipFileWrapper2 = bufferedInputStream;
                        throw new DexException(e);
                    } catch (Throwable th4) {
                        th = th4;
                        polarisZipFileWrapper2 = bufferedInputStream;
                        if (polarisZipFileWrapper2 != null) {
                            try {
                                polarisZipFileWrapper2.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } else {
                    throw new DexException("unknown output extension: " + file);
                }
                return;
            } catch (Exception unused3) {
                return;
            }
        }
        throw new IllegalArgumentException("file is null.");
    }

    public Section openSection(TableOfContents.Section section) {
        int i = section.off;
        if (i >= 0 && i < this.data.capacity()) {
            ByteBuffer duplicate = this.data.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            duplicate.position(i);
            duplicate.limit(i + section.byteCount);
            return new Section("section", duplicate);
        }
        throw new IllegalArgumentException("position=" + i + " length=" + this.data.capacity());
    }

    public Dex(InputStream inputStream) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.classDefs = new ClassDefTable();
        this.nextSectionStart = 0;
        this.signature = null;
        loadFrom(inputStream);
    }

    private Dex(ByteBuffer byteBuffer) throws IOException {
        TableOfContents tableOfContents = new TableOfContents();
        this.tableOfContents = tableOfContents;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.classDefs = new ClassDefTable();
        this.nextSectionStart = 0;
        this.signature = null;
        this.data = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        tableOfContents.readFrom(this);
    }

    private void loadFrom(InputStream inputStream, int i) throws IOException {
        ByteBuffer wrap = ByteBuffer.wrap(FileUtils.readStream(inputStream, i));
        this.data = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.tableOfContents.readFrom(this);
    }

    public Section appendSection(int i, String str) {
        int i2 = this.nextSectionStart + i;
        ByteBuffer duplicate = this.data.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(this.nextSectionStart);
        duplicate.limit(i2);
        Section section = new Section(str, duplicate);
        this.nextSectionStart = i2;
        return section;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkBounds(int i, int i2) {
        if (i >= 0 && i < i2) {
            return;
        }
        throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
    }

    public Dex(InputStream inputStream, int i) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.classDefs = new ClassDefTable();
        this.nextSectionStart = 0;
        this.signature = null;
        loadFrom(inputStream, i);
    }
}
