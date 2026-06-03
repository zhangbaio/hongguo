// target 0x53d77c callers found

// ===== FUN_0053d77c @ 0053d77c size=276 =====

void FUN_0053d77c(undefined1 *param_1,undefined1 *param_2)

{
  byte *pbVar1;
  ulong uVar2;
  byte bVar3;
  byte bVar4;
  ulong uVar5;
  byte bVar6;
  byte bVar7;
  
  uVar2 = 4;
                    /* try { // try from 0053d788 to 0063d78f has its CatchHandler @ 0053d85c */
  *param_1 = *param_2;
  param_1[1] = param_2[1];
  param_1[2] = param_2[2];
  param_1[3] = param_2[3];
  param_1[4] = param_2[4];
                    /* try { // try from 0053d7b4 to 0063d7bf has its CatchHandler @ 0053d848 */
  param_1[5] = param_2[5];
  param_1[6] = param_2[6];
                    /* try { // try from 0053d7c0 to 0063d813 has its CatchHandler @ 0053d650 */
  param_1[7] = param_2[7];
  param_1[8] = param_2[8];
  param_1[9] = param_2[9];
  param_1[10] = param_2[10];
  param_1[0xb] = param_2[0xb];
  param_1[0xc] = param_2[0xc];
  param_1[0xd] = param_2[0xd];
  param_1[0xe] = param_2[0xe];
  param_1[0xf] = param_2[0xf];
  pbVar1 = param_1 + 0x13;
                    /* try { // try from 0053d814 to 0063d81b has its CatchHandler @ 0053d858 */
  do {
    bVar3 = pbVar1[-7];
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053d814 with catch @ 0053d858
                        */
    bVar4 = pbVar1[-6];
    uVar5 = (ulong)bVar4;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053d788 with catch @ 0053d85c
                        */
    bVar6 = pbVar1[-5];
    bVar7 = pbVar1[-4];
    if ((uVar2 & 3) == 0) {
      bVar4 = (&DAT_005e081f)[bVar6];
      bVar6 = (&DAT_005e081f)[bVar7];
      bVar7 = (&DAT_005e081f)[bVar3];
      bVar3 = (&UNK_005e091f)[uVar2 >> 2 & 0x3fffffff] ^ (&DAT_005e081f)[uVar5];
    }
                    /* try { // try from 0053d81c to 0063d8ab has its CatchHandler @ 0053d650 */
    uVar2 = uVar2 + 1;
    pbVar1[-3] = pbVar1[-0x13] ^ bVar3;
    pbVar1[-2] = pbVar1[-0x12] ^ bVar4;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053d7b4 with catch @ 0053d848
                        */
    pbVar1[-1] = pbVar1[-0x11] ^ bVar6;
    *pbVar1 = pbVar1[-0x10] ^ bVar7;
    pbVar1 = pbVar1 + 4;
  } while (uVar2 != 0x2c);
  return;
}



// ===== FUN_0053d890 @ 0053d890 size=40 =====

void FUN_0053d890(long param_1,undefined8 param_2,undefined8 *param_3)

{
  undefined8 uVar1;
  
  FUN_0053d77c();
  uVar1 = *param_3;
  *(undefined8 *)(param_1 + 0xb8) = param_3[1];
  *(undefined8 *)(param_1 + 0xb0) = uVar1;
                    /* try { // try from 0053d8ac to 0063d8b3 has its CatchHandler @ 0053d8bc */
                    /* try { // try from 0053d8b4 to 0063d8bf has its CatchHandler @ 0053d650 */
  return;
}


