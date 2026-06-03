package com.tencent.tinker.lib.signature;

import android.util.ArrayMap;
import android.util.Pair;
import com.bytedance.covode.number.Covode;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
final class ApkSigningBlockUtils {
    private static final int[] V4_CONTENT_DIGEST_ALGORITHMS;

    private ApkSigningBlockUtils() {
    }

    static {
        Covode.recordClassIndex(653797);
        V4_CONTENT_DIGEST_ALGORITHMS = new int[]{2, 3, 1};
    }

    private static class MultipleDigestDataDigester implements DataDigester {
        private final MessageDigest[] mMds;

        static {
            Covode.recordClassIndex(653798);
        }

        MultipleDigestDataDigester(MessageDigest[] messageDigestArr) {
            this.mMds = messageDigestArr;
        }

        @Override // com.tencent.tinker.lib.signature.DataDigester
        public void consume(ByteBuffer byteBuffer) {
            ByteBuffer slice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.mMds) {
                slice.position(0);
                messageDigest.update(slice);
            }
        }
    }

    private static long getChunkCount(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    static Pair<ByteBuffer, Long> getEocd(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord = ZipUtils.findZipEndOfCentralDirectoryRecord(randomAccessFile);
        if (findZipEndOfCentralDirectoryRecord != null) {
            return findZipEndOfCentralDirectoryRecord;
        }
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static void checkByteOrderLittleEndian(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
        } else {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    static String getContentDigestAlgorithmJcaDigestAlgorithm(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
                }
                return "SHA-256";
            }
            return "SHA-512";
        }
        return "SHA-256";
    }

    private static int getContentDigestAlgorithmOutputSizeBytes(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalArgumentException("Unknown content digest algorthm: " + i);
                }
                return 32;
            }
            return 64;
        }
        return 32;
    }

    static byte[] pickBestDigestForV4(Map<Integer, byte[]> map) {
        for (int i : V4_CONTENT_DIGEST_ALGORITHMS) {
            if (map.containsKey(Integer.valueOf(i))) {
                return map.get(Integer.valueOf(i));
            }
        }
        return null;
    }

    static byte[] readLengthPrefixedByteArray(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    static ByteBuffer getLengthPrefixedSlice(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return getByteBuffer(byteBuffer, i);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    static int getSignatureAlgorithmContentDigestAlgorithm(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i == 1057 || i == 1059 || i == 1061) {
                        return 3;
                    }
                    switch (i) {
                        case 257:
                        case 259:
                            return 1;
                        case 258:
                        case 260:
                            return 2;
                        default:
                            throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                    }
                }
                return 1;
            }
            return 2;
        }
        return 1;
    }

    static String getSignatureAlgorithmJcaKeyAlgorithm(int i) {
        if (i != 513 && i != 514) {
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                case 258:
                                case 259:
                                case 260:
                                    return "RSA";
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                            }
                        }
                        return "DSA";
                    }
                    return "EC";
                }
                return "RSA";
            }
            return "DSA";
        }
        return "EC";
    }

    static Pair<String, ? extends AlgorithmParameterSpec> getSignatureAlgorithmJcaSignatureAlgorithm(int i) {
        if (i != 513) {
            if (i != 514) {
                if (i != 769) {
                    if (i != 1057) {
                        if (i != 1059) {
                            if (i != 1061) {
                                switch (i) {
                                    case 257:
                                        return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                    case 258:
                                        return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                    case 259:
                                        break;
                                    case 260:
                                        return Pair.create("SHA512withRSA", null);
                                    default:
                                        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
                                }
                            }
                        }
                    }
                    return Pair.create("SHA256withRSA", null);
                }
                return Pair.create("SHA256withDSA", null);
            }
            return Pair.create("SHA512withECDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    static int compareSignatureAlgorithm(int i, int i2) {
        return compareContentDigestAlgorithm(getSignatureAlgorithmContentDigestAlgorithm(i), getSignatureAlgorithmContentDigestAlgorithm(i2));
    }

    static SignatureInfo findSignature(RandomAccessFile randomAccessFile, int i) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> eocd = getEocd(randomAccessFile);
        ByteBuffer byteBuffer = (ByteBuffer) eocd.first;
        long longValue = ((Long) eocd.second).longValue();
        if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
            long centralDirOffset = getCentralDirOffset(byteBuffer, longValue);
            Pair<ByteBuffer, Long> findApkSigningBlock = findApkSigningBlock(randomAccessFile, centralDirOffset);
            ByteBuffer byteBuffer2 = (ByteBuffer) findApkSigningBlock.first;
            return new SignatureInfo(findApkSignatureSchemeBlock(byteBuffer2, i), ((Long) findApkSigningBlock.second).longValue(), centralDirOffset, longValue, byteBuffer);
        }
        throw new SignatureNotFoundException("ZIP64 APK not supported");
    }

    static long getCentralDirOffset(ByteBuffer byteBuffer, long j) throws SignatureNotFoundException {
        long zipEocdCentralDirectoryOffset = ZipUtils.getZipEocdCentralDirectoryOffset(byteBuffer);
        if (zipEocdCentralDirectoryOffset <= j) {
            if (ZipUtils.getZipEocdCentralDirectorySizeBytes(byteBuffer) + zipEocdCentralDirectoryOffset == j) {
                return zipEocdCentralDirectoryOffset;
            }
            throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + zipEocdCentralDirectoryOffset + ". ZIP End of Central Directory offset: " + j);
    }

    private static int compareContentDigestAlgorithm(int i, int i2) {
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (i2 == 1) {
                        return 1;
                    }
                    if (i2 == 2) {
                        return -1;
                    }
                    if (i2 == 3) {
                        return 0;
                    }
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
                }
                throw new IllegalArgumentException("Unknown digestAlgorithm1: " + i);
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    return 0;
                }
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
                }
            }
            return 1;
        }
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2 || i2 == 3) {
            return -1;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + i2);
    }

    static ByteBuffer getByteBuffer(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i2 = i + position;
            if (i2 >= position && i2 <= limit) {
                byteBuffer.limit(i2);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i2);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: " + i);
    }

    static ByteBuffer findApkSignatureSchemeBlock(ByteBuffer byteBuffer, int i) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (sliceFromTo.hasRemaining()) {
            i2++;
            if (sliceFromTo.remaining() >= 8) {
                long j = sliceFromTo.getLong();
                if (j >= 4 && j <= 2147483647L) {
                    int i3 = (int) j;
                    int position = sliceFromTo.position() + i3;
                    if (i3 <= sliceFromTo.remaining()) {
                        if (sliceFromTo.getInt() == i) {
                            return getByteBuffer(sliceFromTo, i3 - 4);
                        }
                        sliceFromTo.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + j);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
        }
        throw new SignatureNotFoundException("No block with ID " + i + " in APK Signing Block.");
    }

    static Pair<ByteBuffer, Long> findApkSigningBlock(RandomAccessFile randomAccessFile, long j) throws IOException, SignatureNotFoundException {
        if (j >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            randomAccessFile.seek(j - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                long j2 = allocate.getLong(0);
                if (j2 >= allocate.capacity() && j2 <= 2147483639) {
                    int i = (int) (8 + j2);
                    long j3 = j - i;
                    if (j3 >= 0) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(i);
                        allocate2.order(byteOrder);
                        randomAccessFile.seek(j3);
                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                        long j4 = allocate2.getLong(0);
                        if (j4 == j2) {
                            return Pair.create(allocate2, Long.valueOf(j3));
                        }
                        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                    }
                    throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j3);
                }
                throw new SignatureNotFoundException("APK Signing Block size out of range: " + j2);
            }
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
    }

    private static byte[][] computeContentDigestsPer1MbChunk(int[] iArr, DataSource[] dataSourceArr) throws DigestException {
        String str;
        DataSource[] dataSourceArr2 = dataSourceArr;
        long j = 0;
        int i = 0;
        long j2 = 0;
        for (DataSource dataSource : dataSourceArr2) {
            j2 += getChunkCount(dataSource.size());
        }
        if (j2 < 2097151) {
            int i2 = (int) j2;
            byte[][] bArr = new byte[iArr.length][];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                byte[] bArr2 = new byte[(getContentDigestAlgorithmOutputSizeBytes(iArr[i3]) * i2) + 5];
                bArr2[0] = 90;
                setUnsignedInt32LittleEndian(i2, bArr2, 1);
                bArr[i3] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            int length = iArr.length;
            MessageDigest[] messageDigestArr = new MessageDigest[length];
            int i4 = 0;
            while (true) {
                str = " digest not supported";
                if (i4 >= iArr.length) {
                    break;
                }
                String contentDigestAlgorithmJcaDigestAlgorithm = getContentDigestAlgorithmJcaDigestAlgorithm(iArr[i4]);
                try {
                    messageDigestArr[i4] = MessageDigest.getInstance(contentDigestAlgorithmJcaDigestAlgorithm);
                    i4++;
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(contentDigestAlgorithmJcaDigestAlgorithm + " digest not supported", e);
                }
            }
            MultipleDigestDataDigester multipleDigestDataDigester = new MultipleDigestDataDigester(messageDigestArr);
            int length2 = dataSourceArr2.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length2) {
                DataSource dataSource2 = dataSourceArr2[i5];
                int i7 = length2;
                String str2 = str;
                long j3 = j;
                MultipleDigestDataDigester multipleDigestDataDigester2 = multipleDigestDataDigester;
                long size = dataSource2.size();
                while (size > j) {
                    int min = (int) Math.min(size, 1048576L);
                    setUnsignedInt32LittleEndian(min, bArr3, 1);
                    for (int i8 = 0; i8 < length; i8++) {
                        messageDigestArr[i8].update(bArr3);
                    }
                    MultipleDigestDataDigester multipleDigestDataDigester3 = multipleDigestDataDigester2;
                    try {
                        dataSource2.feedIntoDataDigester(multipleDigestDataDigester3, j3, min);
                        multipleDigestDataDigester2 = multipleDigestDataDigester3;
                        int i9 = 0;
                        while (i9 < iArr.length) {
                            int i10 = iArr[i9];
                            byte[] bArr4 = bArr3;
                            byte[] bArr5 = bArr[i9];
                            int contentDigestAlgorithmOutputSizeBytes = getContentDigestAlgorithmOutputSizeBytes(i10);
                            int i11 = length;
                            MessageDigest messageDigest = messageDigestArr[i9];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int digest = messageDigest.digest(bArr5, (i6 * contentDigestAlgorithmOutputSizeBytes) + 5, contentDigestAlgorithmOutputSizeBytes);
                            if (digest == contentDigestAlgorithmOutputSizeBytes) {
                                i9++;
                                bArr3 = bArr4;
                                length = i11;
                                messageDigestArr = messageDigestArr2;
                            } else {
                                throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + digest);
                            }
                        }
                        long j4 = min;
                        j3 += j4;
                        size -= j4;
                        i6++;
                        bArr3 = bArr3;
                        j = 0;
                    } catch (IOException e2) {
                        throw new DigestException("Failed to digest chunk #" + i6 + " of section #" + i, e2);
                    }
                }
                i++;
                i5++;
                dataSourceArr2 = dataSourceArr;
                multipleDigestDataDigester = multipleDigestDataDigester2;
                str = str2;
                length2 = i7;
                j = 0;
            }
            String str3 = str;
            byte[][] bArr6 = new byte[iArr.length][];
            for (int i12 = 0; i12 < iArr.length; i12++) {
                int i13 = iArr[i12];
                byte[] bArr7 = bArr[i12];
                String contentDigestAlgorithmJcaDigestAlgorithm2 = getContentDigestAlgorithmJcaDigestAlgorithm(i13);
                try {
                    bArr6[i12] = MessageDigest.getInstance(contentDigestAlgorithmJcaDigestAlgorithm2).digest(bArr7);
                } catch (NoSuchAlgorithmException e3) {
                    throw new RuntimeException(contentDigestAlgorithmJcaDigestAlgorithm2 + str3, e3);
                }
            }
            return bArr6;
        }
        throw new DigestException("Too many chunks: " + j2);
    }

    public static byte[] generateApkVerity(String str, ByteBufferFactory byteBufferFactory, SignatureInfo signatureInfo) throws IOException, SignatureNotFoundException, SecurityException, DigestException, NoSuchAlgorithmException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            byte[] bArr = ApkVerityBuilder.generateApkVerity(randomAccessFile, signatureInfo, byteBufferFactory).rootHash;
            randomAccessFile.close();
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    static void setUnsignedInt32LittleEndian(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    private static void verifyIntegrityForVerityBasedAlgorithm(byte[] bArr, RandomAccessFile randomAccessFile, SignatureInfo signatureInfo) throws SecurityException {
        try {
            if (Arrays.equals(parseVerityDigestAndVerifySourceLength(bArr, randomAccessFile.length(), signatureInfo), ApkVerityBuilder.generateApkVerity(randomAccessFile, signatureInfo, new ByteBufferFactory() { // from class: com.tencent.tinker.lib.signature.ApkSigningBlockUtils.1
                @Override // com.tencent.tinker.lib.signature.ByteBufferFactory
                public ByteBuffer create(int i) {
                    return ByteBuffer.allocate(i);
                }
            }).rootHash)) {
            } else {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e) {
            throw new SecurityException("Error during verification", e);
        }
    }

    static byte[] parseVerityDigestAndVerifySourceLength(byte[] bArr, long j, SignatureInfo signatureInfo) throws SecurityException {
        if (bArr.length == 40) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.position(32);
            if (order.getLong() == j - (signatureInfo.centralDirOffset - signatureInfo.apkSigningBlockOffset)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    static ByteBuffer sliceFromTo(ByteBuffer byteBuffer, int i, int i2) {
        if (i >= 0) {
            if (i2 >= i) {
                int capacity = byteBuffer.capacity();
                if (i2 <= byteBuffer.capacity()) {
                    int limit = byteBuffer.limit();
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(0);
                        byteBuffer.limit(i2);
                        byteBuffer.position(i);
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        return slice;
                    } finally {
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                    }
                }
                throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
            }
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        throw new IllegalArgumentException("start: " + i);
    }

    static void verifyIntegrity(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, SignatureInfo signatureInfo) throws SecurityException {
        if (!map.isEmpty()) {
            ArrayMap arrayMap = new ArrayMap();
            boolean z = true;
            if (map.containsKey(1)) {
                arrayMap.put(1, map.get(1));
            }
            if (map.containsKey(2)) {
                arrayMap.put(2, map.get(2));
            }
            boolean z2 = false;
            if (!arrayMap.isEmpty()) {
                try {
                    verifyIntegrityFor1MbChunkBasedAlgorithm(arrayMap, randomAccessFile.getFD(), signatureInfo);
                    z = false;
                } catch (IOException e) {
                    throw new SecurityException("Cannot get FD", e);
                }
            }
            if (map.containsKey(3)) {
                verifyIntegrityForVerityBasedAlgorithm(map.get(3), randomAccessFile, signatureInfo);
            } else {
                z2 = z;
            }
            if (!z2) {
                return;
            } else {
                throw new SecurityException("No known digest exists for integrity check");
            }
        }
        throw new SecurityException("No digests provided");
    }

    private static void verifyIntegrityFor1MbChunkBasedAlgorithm(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, SignatureInfo signatureInfo) throws SecurityException {
        MemoryMappedFileDataSource memoryMappedFileDataSource = new MemoryMappedFileDataSource(fileDescriptor, 0L, signatureInfo.apkSigningBlockOffset);
        long j = signatureInfo.centralDirOffset;
        MemoryMappedFileDataSource memoryMappedFileDataSource2 = new MemoryMappedFileDataSource(fileDescriptor, j, signatureInfo.eocdOffset - j);
        ByteBuffer duplicate = signatureInfo.eocd.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        ZipUtils.setZipEocdCentralDirectoryOffset(duplicate, signatureInfo.apkSigningBlockOffset);
        ByteBufferDataSource byteBufferDataSource = new ByteBufferDataSource(duplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it2 = map.keySet().iterator();
        int i = 0;
        while (it2.hasNext()) {
            iArr[i] = it2.next().intValue();
            i++;
        }
        try {
            byte[][] computeContentDigestsPer1MbChunk = computeContentDigestsPer1MbChunk(iArr, new DataSource[]{memoryMappedFileDataSource, memoryMappedFileDataSource2, byteBufferDataSource});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), computeContentDigestsPer1MbChunk[i2])) {
                    throw new SecurityException(getContentDigestAlgorithmJcaDigestAlgorithm(i3) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }
}
