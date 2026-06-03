package com.tencent.tinker.commons.dexpatcher;

import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.tencent.tinker.android.dex.Annotation;
import com.tencent.tinker.android.dex.AnnotationSet;
import com.tencent.tinker.android.dex.AnnotationSetRefList;
import com.tencent.tinker.android.dex.AnnotationsDirectory;
import com.tencent.tinker.android.dex.ClassData;
import com.tencent.tinker.android.dex.ClassDef;
import com.tencent.tinker.android.dex.Code;
import com.tencent.tinker.android.dex.DebugInfoItem;
import com.tencent.tinker.android.dex.Dex;
import com.tencent.tinker.android.dex.EncodedValue;
import com.tencent.tinker.android.dex.FieldId;
import com.tencent.tinker.android.dex.MethodId;
import com.tencent.tinker.android.dex.ProtoId;
import com.tencent.tinker.android.dex.StringData;
import com.tencent.tinker.android.dex.TableOfContents;
import com.tencent.tinker.android.dex.TypeList;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.AnnotationSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.AnnotationSetRefListSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.AnnotationSetSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.AnnotationsDirectorySectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.ClassDataSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.ClassDefSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.CodeSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.DebugInfoItemSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.DexSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.FieldIdSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.MethodIdSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.ProtoIdSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.StaticValueSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.StringDataSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.TypeIdSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.algorithms.patch.TypeListSectionPatchAlgorithm;
import com.tencent.tinker.commons.dexpatcher.struct.DexPatchFile;
import com.tencent.tinker.commons.dexpatcher.util.SparseIndexMap;
import com.tencent.tinker.commons.util.IOHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class DexPatchApplier {
    private DexSectionPatchAlgorithm<Annotation> annotationSectionPatchAlg;
    private DexSectionPatchAlgorithm<AnnotationSetRefList> annotationSetRefListSectionPatchAlg;
    private DexSectionPatchAlgorithm<AnnotationSet> annotationSetSectionPatchAlg;
    private DexSectionPatchAlgorithm<AnnotationsDirectory> annotationsDirectorySectionPatchAlg;
    private DexSectionPatchAlgorithm<ClassData> classDataSectionPatchAlg;
    private DexSectionPatchAlgorithm<ClassDef> classDefSectionPatchAlg;
    private DexSectionPatchAlgorithm<Code> codeSectionPatchAlg;
    private DexSectionPatchAlgorithm<DebugInfoItem> debugInfoSectionPatchAlg;
    private DexSectionPatchAlgorithm<EncodedValue> encodedArraySectionPatchAlg;
    private DexSectionPatchAlgorithm<FieldId> fieldIdSectionPatchAlg;
    private DexSectionPatchAlgorithm<MethodId> methodIdSectionPatchAlg;
    private final Dex oldDex;
    private final SparseIndexMap oldToPatchedIndexMap;
    private final DexPatchFile patchFile;
    private final Dex patchedDex;
    private DexSectionPatchAlgorithm<ProtoId> protoIdSectionPatchAlg;
    private DexSectionPatchAlgorithm<StringData> stringDataSectionPatchAlg;
    private DexSectionPatchAlgorithm<Integer> typeIdSectionPatchAlg;
    private DexSectionPatchAlgorithm<TypeList> typeListSectionPatchAlg;

    static {
        Covode.recordClassIndex(653652);
    }

    public void executeAndSaveTo(File file) throws IOException {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(file));
            try {
                executeAndSaveTo(bufferedOutputStream2);
                IOHelper.closeQuietly(bufferedOutputStream2);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                IOHelper.closeQuietly(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void executeAndSaveTo(OutputStream outputStream) throws IOException {
        byte[] computeSignature = this.oldDex.computeSignature(false);
        if (computeSignature != null) {
            DexPatchFile dexPatchFile = this.patchFile;
            if (dexPatchFile != null) {
                byte[] oldDexSignature = dexPatchFile.getOldDexSignature();
                if (CompareUtils.uArrCompare(computeSignature, oldDexSignature) == 0) {
                    TableOfContents tableOfContents = this.patchedDex.getTableOfContents();
                    TableOfContents.Section section = tableOfContents.header;
                    section.off = 0;
                    section.size = 1;
                    tableOfContents.mapList.size = 1;
                    tableOfContents.stringIds.off = this.patchFile.getPatchedStringIdSectionOffset();
                    tableOfContents.typeIds.off = this.patchFile.getPatchedTypeIdSectionOffset();
                    tableOfContents.typeLists.off = this.patchFile.getPatchedTypeListSectionOffset();
                    tableOfContents.protoIds.off = this.patchFile.getPatchedProtoIdSectionOffset();
                    tableOfContents.fieldIds.off = this.patchFile.getPatchedFieldIdSectionOffset();
                    tableOfContents.methodIds.off = this.patchFile.getPatchedMethodIdSectionOffset();
                    tableOfContents.classDefs.off = this.patchFile.getPatchedClassDefSectionOffset();
                    tableOfContents.mapList.off = this.patchFile.getPatchedMapListSectionOffset();
                    tableOfContents.stringDatas.off = this.patchFile.getPatchedStringDataSectionOffset();
                    tableOfContents.annotations.off = this.patchFile.getPatchedAnnotationSectionOffset();
                    tableOfContents.annotationSets.off = this.patchFile.getPatchedAnnotationSetSectionOffset();
                    tableOfContents.annotationSetRefLists.off = this.patchFile.getPatchedAnnotationSetRefListSectionOffset();
                    tableOfContents.annotationsDirectories.off = this.patchFile.getPatchedAnnotationsDirectorySectionOffset();
                    tableOfContents.encodedArrays.off = this.patchFile.getPatchedEncodedArraySectionOffset();
                    tableOfContents.debugInfos.off = this.patchFile.getPatchedDebugInfoSectionOffset();
                    tableOfContents.codes.off = this.patchFile.getPatchedCodeSectionOffset();
                    tableOfContents.classDatas.off = this.patchFile.getPatchedClassDataSectionOffset();
                    tableOfContents.fileSize = this.patchFile.getPatchedDexSize();
                    Arrays.sort(tableOfContents.sections);
                    tableOfContents.computeSizesFromOffsets();
                    this.stringDataSectionPatchAlg = new StringDataSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.typeIdSectionPatchAlg = new TypeIdSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.protoIdSectionPatchAlg = new ProtoIdSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.fieldIdSectionPatchAlg = new FieldIdSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.methodIdSectionPatchAlg = new MethodIdSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.classDefSectionPatchAlg = new ClassDefSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.typeListSectionPatchAlg = new TypeListSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.annotationSetRefListSectionPatchAlg = new AnnotationSetRefListSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.annotationSetSectionPatchAlg = new AnnotationSetSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.classDataSectionPatchAlg = new ClassDataSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.codeSectionPatchAlg = new CodeSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.debugInfoSectionPatchAlg = new DebugInfoItemSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.annotationSectionPatchAlg = new AnnotationSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.encodedArraySectionPatchAlg = new StaticValueSectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.annotationsDirectorySectionPatchAlg = new AnnotationsDirectorySectionPatchAlgorithm(this.patchFile, this.oldDex, this.patchedDex, this.oldToPatchedIndexMap);
                    this.stringDataSectionPatchAlg.execute();
                    this.typeIdSectionPatchAlg.execute();
                    this.typeListSectionPatchAlg.execute();
                    this.protoIdSectionPatchAlg.execute();
                    this.fieldIdSectionPatchAlg.execute();
                    this.methodIdSectionPatchAlg.execute();
                    this.annotationSectionPatchAlg.execute();
                    this.annotationSetSectionPatchAlg.execute();
                    this.annotationSetRefListSectionPatchAlg.execute();
                    this.annotationsDirectorySectionPatchAlg.execute();
                    this.debugInfoSectionPatchAlg.execute();
                    this.codeSectionPatchAlg.execute();
                    this.classDataSectionPatchAlg.execute();
                    this.encodedArraySectionPatchAlg.execute();
                    this.classDefSectionPatchAlg.execute();
                    tableOfContents.writeHeader(this.patchedDex.openSection(tableOfContents.header.off));
                    tableOfContents.writeMap(this.patchedDex.openSection(tableOfContents.mapList.off));
                    this.patchedDex.writeHashes();
                    this.patchedDex.writeTo(outputStream);
                    return;
                }
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", Arrays.toString(computeSignature), Arrays.toString(oldDexSignature)));
            }
            throw new IllegalArgumentException("patch file is null.");
        }
        throw new IOException("failed to compute old dex's signature.");
    }

    public DexPatchApplier(File file, File file2) throws IOException {
        this(new Dex(file), new DexPatchFile(file2));
    }

    public DexPatchApplier(Dex dex, DexPatchFile dexPatchFile) {
        this.oldDex = dex;
        this.patchFile = dexPatchFile;
        this.patchedDex = new Dex(dexPatchFile.getPatchedDexSize());
        this.oldToPatchedIndexMap = new SparseIndexMap();
    }

    public DexPatchApplier(InputStream inputStream, InputStream inputStream2) throws IOException {
        this(new Dex(inputStream), new DexPatchFile(inputStream2));
    }
}
