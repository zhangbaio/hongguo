package com.tencent.tinker.commons.dexpatcher.util;

import com.bytedance.covode.number.Covode;
import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dx.instruction.InstructionPromoter;
import com.tencent.tinker.android.dx.instruction.InstructionReader;
import com.tencent.tinker.android.dx.instruction.InstructionVisitor;
import com.tencent.tinker.android.dx.instruction.InstructionWriter;
import com.tencent.tinker.android.dx.instruction.ShortArrayCodeInput;
import com.tencent.tinker.android.dx.instruction.ShortArrayCodeOutput;
import java.io.EOFException;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class InstructionTransformer {
    private final AbstractIndexMap indexMap;

    static {
        Covode.recordClassIndex(653675);
    }

    public InstructionTransformer(AbstractIndexMap abstractIndexMap) {
        this.indexMap = abstractIndexMap;
    }

    public short[] transform(short[] sArr) throws DexException {
        ShortArrayCodeOutput shortArrayCodeOutput = new ShortArrayCodeOutput(sArr.length);
        InstructionPromoter instructionPromoter = new InstructionPromoter();
        InstructionWriter instructionWriter = new InstructionWriter(shortArrayCodeOutput, instructionPromoter);
        InstructionReader instructionReader = new InstructionReader(new ShortArrayCodeInput(sArr));
        try {
            instructionReader.accept(new InstructionTransformVisitor(instructionPromoter));
            instructionReader.accept(new InstructionTransformVisitor(instructionWriter));
            return shortArrayCodeOutput.getArray();
        } catch (EOFException e) {
            throw new DexException(e);
        }
    }

    private final class InstructionTransformVisitor extends InstructionVisitor {
        static {
            Covode.recordClassIndex(653676);
        }

        InstructionTransformVisitor(InstructionVisitor instructionVisitor) {
            super(instructionVisitor);
        }

        private int transformIndexIfNeeded(int i, int i2) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return i;
                        }
                        return InstructionTransformer.this.indexMap.adjustFieldIdIndex(i);
                    }
                    return InstructionTransformer.this.indexMap.adjustMethodIdIndex(i);
                }
                return InstructionTransformer.this.indexMap.adjustStringIndex(i);
            }
            return InstructionTransformer.this.indexMap.adjustTypeIdIndex(i);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitZeroRegisterInsn(int i, int i2, int i3, int i4, int i5, long j) {
            super.visitZeroRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitOneRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6) {
            super.visitOneRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitRegisterRangeInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.visitRegisterRangeInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitTwoRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.visitTwoRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitThreeRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
            super.visitThreeRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7, i8);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitFourRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
            super.visitFourRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7, i8, i9);
        }

        @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
        public void visitFiveRegisterInsn(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
            super.visitFiveRegisterInsn(i, i2, transformIndexIfNeeded(i3, i4), i4, i5, j, i6, i7, i8, i9, i10);
        }
    }
}
