# -*- coding: utf-8 -*-
import json,os,time
from Crypto.Cipher import AES
ks=json.load(open("capture/e3_ks.json"))
blkA=bytes.fromhex(ks["blkA"]); blkB=bytes.fromhex(ks["blkB"])
print(f"blkA={blkA.hex()} blkB={blkB.hex()} idx={ks.get('blkA_idx')}",flush=True)
dsz=os.path.getsize("capture/e3.bin"); print(f"e3.bin {dsz//1048576}MB",flush=True)
def brute(bits):
    klen=bits//8;t0=time.time();tested=0
    with open("capture/e3.bin","rb") as f:
        carry=b"";gpos=0
        while True:
            chunk=f.read(64<<20)
            if not chunk:break
            buf=carry+chunk;lim=len(buf)-klen
            start=(-gpos)%16
            for o in range(start,lim+1,16):
                K=buf[o:o+klen]
                try:
                    c=AES.new(K,AES.MODE_ECB)
                    if (int.from_bytes(c.decrypt(blkB),"big")-int.from_bytes(c.decrypt(blkA),"big"))%(1<<128)==1:
                        print(f"\n*** e3 KEY AES-{bits} key={K.hex()}",flush=True)
                        json.dump({"key":K.hex(),"bits":bits},open("capture/E3_KEY.json","w"))
                        return True
                except:pass
                tested+=1
            carry=buf[-16:];gpos+=len(chunk)
            print(f"  AES{bits} {gpos//1048576}/{dsz//1048576}MB {time.time()-t0:.0f}s",flush=True)
    print(f"AES-{bits} done nothing",flush=True);return False
if not brute(128): brute(256)
print("e3 brute done",flush=True)
