package com.tencent.tinker.android.dx.instruction;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.tinker.android.dex.DexException;
import com.tencent.tinker.android.dex.util.CompareUtils;
import com.tencent.tinker.android.dx.util.Hex;
import java.io.EOFException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class InstructionComparator {
    private final InstructionHolder[] insnHolders1;
    private final InstructionHolder[] insnHolders2;
    private final short[] insns1;
    private final short[] insns2;
    private final Set<String> visitedInsnAddrPairs;

    static {
        Covode.recordClassIndex(653630);
    }

    protected abstract boolean compareField(int i, int i2);

    protected abstract boolean compareMethod(int i, int i2);

    protected abstract boolean compareString(int i, int i2);

    protected abstract boolean compareType(int i, int i2);

    private static class FillArrayDataPayloadInstructionHolder extends InstructionHolder {
        Object data;
        int elementWidth;
        int size;

        static {
            Covode.recordClassIndex(653631);
        }

        private FillArrayDataPayloadInstructionHolder() {
            super();
            this.data = null;
            this.size = 0;
            this.elementWidth = 0;
        }
    }

    private static class PackedSwitchPayloadInsntructionHolder extends InstructionHolder {
        int firstKey;
        int[] targets;

        static {
            Covode.recordClassIndex(653633);
        }

        private PackedSwitchPayloadInsntructionHolder() {
            super();
            this.firstKey = 0;
            this.targets = null;
        }
    }

    private static class SparseSwitchPayloadInsntructionHolder extends InstructionHolder {
        int[] keys;
        int[] targets;

        static {
            Covode.recordClassIndex(653634);
        }

        private SparseSwitchPayloadInsntructionHolder() {
            super();
            this.keys = null;
            this.targets = null;
        }
    }

    private static class InstructionHolder {
        int a;
        int address;
        int b;
        int c;
        int d;
        int e;
        int index;
        int insnFormat;
        long literal;
        int opcode;
        int registerCount;
        int target;

        static {
            Covode.recordClassIndex(653632);
        }

        private InstructionHolder() {
            this.insnFormat = 0;
            this.address = -1;
            this.opcode = -1;
            this.index = 0;
            this.target = 0;
            this.literal = 0L;
            this.registerCount = 0;
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
        }
    }

    public final boolean compare() {
        this.visitedInsnAddrPairs.clear();
        InstructionHolder[] instructionHolderArr = this.insnHolders1;
        if (instructionHolderArr == null && this.insnHolders2 == null) {
            return true;
        }
        if (instructionHolderArr == null || this.insnHolders2 == null) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < this.insnHolders1.length && i2 < this.insnHolders2.length) {
            InstructionHolder instructionHolder = null;
            InstructionHolder instructionHolder2 = null;
            while (true) {
                InstructionHolder[] instructionHolderArr2 = this.insnHolders1;
                if (i >= instructionHolderArr2.length || instructionHolder2 != null) {
                    break;
                }
                instructionHolder2 = instructionHolderArr2[i];
                i++;
            }
            if (instructionHolder2 == null) {
                break;
            }
            i3++;
            while (true) {
                InstructionHolder[] instructionHolderArr3 = this.insnHolders2;
                if (i2 >= instructionHolderArr3.length || instructionHolder != null) {
                    break;
                }
                instructionHolder = instructionHolderArr3[i2];
                i2++;
            }
            if (instructionHolder == null) {
                break;
            }
            i4++;
            if (!isSameInstruction(instructionHolder2, instructionHolder)) {
                return false;
            }
        }
        while (true) {
            InstructionHolder[] instructionHolderArr4 = this.insnHolders1;
            if (i < instructionHolderArr4.length) {
                int i5 = i + 1;
                if (instructionHolderArr4[i] != null) {
                    return false;
                }
                i = i5;
            } else {
                while (true) {
                    InstructionHolder[] instructionHolderArr5 = this.insnHolders2;
                    if (i2 < instructionHolderArr5.length) {
                        int i6 = i2 + 1;
                        if (instructionHolderArr5[i2] != null) {
                            return false;
                        }
                        i2 = i6;
                    } else {
                        if (i3 == i4) {
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
    }

    private int getPromotedOpCodeOnDemand(InstructionHolder instructionHolder) {
        int i = instructionHolder.opcode;
        int i2 = 27;
        if (i != 26 && i != 27) {
            i2 = 42;
            if (i != 40 && i != 41 && i != 42) {
                return i;
            }
        }
        return i2;
    }

    public boolean isSameInstruction(int i, int i2) {
        return isSameInstruction(this.insnHolders1[i], this.insnHolders2[i2]);
    }

    private InstructionHolder[] readInstructionsIntoHolders(ShortArrayCodeInput shortArrayCodeInput, int i) {
        shortArrayCodeInput.reset();
        final InstructionHolder[] instructionHolderArr = new InstructionHolder[i];
        try {
            new InstructionReader(shortArrayCodeInput).accept(new InstructionVisitor(null) { // from class: com.tencent.tinker.android.dx.instruction.InstructionComparator.1
                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitPackedSwitchPayloadInsn(int i2, int i3, int i4, int[] iArr) {
                    PackedSwitchPayloadInsntructionHolder packedSwitchPayloadInsntructionHolder = new PackedSwitchPayloadInsntructionHolder();
                    packedSwitchPayloadInsntructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    packedSwitchPayloadInsntructionHolder.address = i2;
                    packedSwitchPayloadInsntructionHolder.opcode = i3;
                    packedSwitchPayloadInsntructionHolder.firstKey = i4;
                    packedSwitchPayloadInsntructionHolder.targets = iArr;
                    instructionHolderArr[i2] = packedSwitchPayloadInsntructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitSparseSwitchPayloadInsn(int i2, int i3, int[] iArr, int[] iArr2) {
                    SparseSwitchPayloadInsntructionHolder sparseSwitchPayloadInsntructionHolder = new SparseSwitchPayloadInsntructionHolder();
                    sparseSwitchPayloadInsntructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    sparseSwitchPayloadInsntructionHolder.address = i2;
                    sparseSwitchPayloadInsntructionHolder.opcode = i3;
                    sparseSwitchPayloadInsntructionHolder.keys = iArr;
                    sparseSwitchPayloadInsntructionHolder.targets = iArr2;
                    instructionHolderArr[i2] = sparseSwitchPayloadInsntructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitFillArrayDataPayloadInsn(int i2, int i3, Object obj, int i4, int i5) {
                    FillArrayDataPayloadInstructionHolder fillArrayDataPayloadInstructionHolder = new FillArrayDataPayloadInstructionHolder();
                    fillArrayDataPayloadInstructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    fillArrayDataPayloadInstructionHolder.address = i2;
                    fillArrayDataPayloadInstructionHolder.opcode = i3;
                    fillArrayDataPayloadInstructionHolder.data = obj;
                    fillArrayDataPayloadInstructionHolder.size = i4;
                    fillArrayDataPayloadInstructionHolder.elementWidth = i5;
                    instructionHolderArr[i2] = fillArrayDataPayloadInstructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitZeroRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j) {
                    if (i3 != 0) {
                        InstructionHolder instructionHolder = new InstructionHolder();
                        instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                        instructionHolder.address = i2;
                        instructionHolder.opcode = i3;
                        instructionHolder.index = i4;
                        instructionHolder.target = i6;
                        instructionHolder.literal = j;
                        instructionHolderArr[i2] = instructionHolder;
                    }
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitOneRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 1;
                    instructionHolder.a = i7;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitRegisterRangeInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = i8;
                    instructionHolder.a = i7;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitTwoRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 2;
                    instructionHolder.a = i7;
                    instructionHolder.b = i8;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitThreeRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, int i9) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 3;
                    instructionHolder.a = i7;
                    instructionHolder.b = i8;
                    instructionHolder.c = i9;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitFourRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, int i9, int i10) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 4;
                    instructionHolder.a = i7;
                    instructionHolder.b = i8;
                    instructionHolder.c = i9;
                    instructionHolder.d = i10;
                    instructionHolderArr[i2] = instructionHolder;
                }

                @Override // com.tencent.tinker.android.dx.instruction.InstructionVisitor
                public void visitFiveRegisterInsn(int i2, int i3, int i4, int i5, int i6, long j, int i7, int i8, int i9, int i10, int i11) {
                    InstructionHolder instructionHolder = new InstructionHolder();
                    instructionHolder.insnFormat = InstructionCodec.getInstructionFormat(i3);
                    instructionHolder.address = i2;
                    instructionHolder.opcode = i3;
                    instructionHolder.index = i4;
                    instructionHolder.target = i6;
                    instructionHolder.literal = j;
                    instructionHolder.registerCount = 5;
                    instructionHolder.a = i7;
                    instructionHolder.b = i8;
                    instructionHolder.c = i9;
                    instructionHolder.d = i10;
                    instructionHolder.e = i11;
                    instructionHolderArr[i2] = instructionHolder;
                }
            });
            return instructionHolderArr;
        } catch (EOFException e) {
            throw new RuntimeException(e);
        }
    }

    public InstructionComparator(short[] sArr, short[] sArr2) {
        this.insns1 = sArr;
        this.insns2 = sArr2;
        if (sArr != null) {
            this.insnHolders1 = readInstructionsIntoHolders(new ShortArrayCodeInput(sArr), sArr.length);
        } else {
            this.insnHolders1 = null;
        }
        if (sArr2 != null) {
            this.insnHolders2 = readInstructionsIntoHolders(new ShortArrayCodeInput(sArr2), sArr2.length);
        } else {
            this.insnHolders2 = null;
        }
        this.visitedInsnAddrPairs = new HashSet();
    }

    public boolean isSameInstructionForDebugInfo(int i, int i2) {
        InstructionHolder[] instructionHolderArr = this.insnHolders1;
        if ((i >= instructionHolderArr.length && i2 < this.insnHolders2.length) || (i < instructionHolderArr.length && i2 >= this.insnHolders2.length)) {
            return false;
        }
        if (i >= instructionHolderArr.length) {
            InstructionHolder[] instructionHolderArr2 = this.insnHolders2;
            if (i2 >= instructionHolderArr2.length) {
                if (instructionHolderArr.length != instructionHolderArr2.length || i != i2) {
                    return false;
                }
                return true;
            }
        }
        return isSameInstruction(instructionHolderArr[i], this.insnHolders2[i2]);
    }

    public boolean isSameInstruction(InstructionHolder instructionHolder, InstructionHolder instructionHolder2) {
        if (instructionHolder == null && instructionHolder2 == null) {
            return true;
        }
        if (instructionHolder == null || instructionHolder2 == null || getPromotedOpCodeOnDemand(instructionHolder) != getPromotedOpCodeOnDemand(instructionHolder2)) {
            return false;
        }
        int i = instructionHolder.opcode;
        int i2 = instructionHolder.insnFormat;
        if (i2 != 2 && i2 != 11) {
            if (i2 != 13) {
                if (i2 != 15 && i2 != 21 && i2 != 7) {
                    if (i2 != 8) {
                        if (i2 != 18) {
                            if (i2 != 19 && i2 != 23 && i2 != 24) {
                                switch (i2) {
                                    case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                                        FillArrayDataPayloadInstructionHolder fillArrayDataPayloadInstructionHolder = (FillArrayDataPayloadInstructionHolder) instructionHolder;
                                        FillArrayDataPayloadInstructionHolder fillArrayDataPayloadInstructionHolder2 = (FillArrayDataPayloadInstructionHolder) instructionHolder2;
                                        int i3 = fillArrayDataPayloadInstructionHolder.elementWidth;
                                        if (i3 != fillArrayDataPayloadInstructionHolder2.elementWidth || fillArrayDataPayloadInstructionHolder.size != fillArrayDataPayloadInstructionHolder2.size) {
                                            return false;
                                        }
                                        if (i3 != 1) {
                                            if (i3 != 2) {
                                                if (i3 != 4) {
                                                    if (i3 == 8) {
                                                        if (CompareUtils.sArrCompare((long[]) fillArrayDataPayloadInstructionHolder.data, (long[]) fillArrayDataPayloadInstructionHolder2.data) == 0) {
                                                            return true;
                                                        }
                                                        return false;
                                                    }
                                                    throw new DexException("bogus element_width: " + Hex.u2(i3));
                                                }
                                                if (CompareUtils.uArrCompare((int[]) fillArrayDataPayloadInstructionHolder.data, (int[]) fillArrayDataPayloadInstructionHolder2.data) == 0) {
                                                    return true;
                                                }
                                                return false;
                                            }
                                            if (CompareUtils.uArrCompare((short[]) fillArrayDataPayloadInstructionHolder.data, (short[]) fillArrayDataPayloadInstructionHolder2.data) == 0) {
                                                return true;
                                            }
                                            return false;
                                        }
                                        if (CompareUtils.uArrCompare((byte[]) fillArrayDataPayloadInstructionHolder.data, (byte[]) fillArrayDataPayloadInstructionHolder2.data) == 0) {
                                            return true;
                                        }
                                        return false;
                                    case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                                        PackedSwitchPayloadInsntructionHolder packedSwitchPayloadInsntructionHolder = (PackedSwitchPayloadInsntructionHolder) instructionHolder;
                                        PackedSwitchPayloadInsntructionHolder packedSwitchPayloadInsntructionHolder2 = (PackedSwitchPayloadInsntructionHolder) instructionHolder2;
                                        if (packedSwitchPayloadInsntructionHolder.firstKey != packedSwitchPayloadInsntructionHolder2.firstKey) {
                                            return false;
                                        }
                                        int[] iArr = packedSwitchPayloadInsntructionHolder.targets;
                                        if (iArr.length != packedSwitchPayloadInsntructionHolder2.targets.length) {
                                            return false;
                                        }
                                        int length = iArr.length;
                                        for (int i4 = 0; i4 < length; i4++) {
                                            if (!isSameInstruction(packedSwitchPayloadInsntructionHolder.targets[i4], packedSwitchPayloadInsntructionHolder2.targets[i4])) {
                                                return false;
                                            }
                                        }
                                        return true;
                                    case 28:
                                        SparseSwitchPayloadInsntructionHolder sparseSwitchPayloadInsntructionHolder = (SparseSwitchPayloadInsntructionHolder) instructionHolder;
                                        SparseSwitchPayloadInsntructionHolder sparseSwitchPayloadInsntructionHolder2 = (SparseSwitchPayloadInsntructionHolder) instructionHolder2;
                                        if (CompareUtils.uArrCompare(sparseSwitchPayloadInsntructionHolder.keys, sparseSwitchPayloadInsntructionHolder2.keys) != 0) {
                                            return false;
                                        }
                                        int[] iArr2 = sparseSwitchPayloadInsntructionHolder.targets;
                                        if (iArr2.length != sparseSwitchPayloadInsntructionHolder2.targets.length) {
                                            return false;
                                        }
                                        int length2 = iArr2.length;
                                        for (int i5 = 0; i5 < length2; i5++) {
                                            if (!isSameInstruction(sparseSwitchPayloadInsntructionHolder.targets[i5], sparseSwitchPayloadInsntructionHolder2.targets[i5])) {
                                                return false;
                                            }
                                        }
                                        return true;
                                    default:
                                        if (instructionHolder.literal == instructionHolder2.literal && instructionHolder.registerCount == instructionHolder2.registerCount && instructionHolder.a == instructionHolder2.a && instructionHolder.b == instructionHolder2.b && instructionHolder.c == instructionHolder2.c && instructionHolder.d == instructionHolder2.d && instructionHolder.e == instructionHolder2.e) {
                                            return true;
                                        }
                                        return false;
                                }
                            }
                        }
                    }
                }
            }
            return compareIndex(i, instructionHolder.index, instructionHolder2.index);
        }
        if (!this.visitedInsnAddrPairs.add(instructionHolder.address + "-" + instructionHolder2.address)) {
            return true;
        }
        return isSameInstruction(instructionHolder.target, instructionHolder2.target);
    }

    private boolean compareIndex(int i, int i2, int i3) {
        int instructionIndexType = InstructionCodec.getInstructionIndexType(i);
        if (instructionIndexType != 2) {
            if (instructionIndexType != 3) {
                if (instructionIndexType != 4) {
                    if (instructionIndexType != 5) {
                        if (i2 == i3) {
                            return true;
                        }
                        return false;
                    }
                    return compareField(i2, i3);
                }
                return compareMethod(i2, i3);
            }
            return compareString(i2, i3);
        }
        return compareType(i2, i3);
    }
}
