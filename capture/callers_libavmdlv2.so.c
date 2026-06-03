// target 0x53d77c callers found
// target 0x53d8b8 callers found
// target 0x53c0a0 callers found

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



// ===== FUN_0053e1a0 @ 0053e1a0 size=380 =====

void FUN_0053e1a0(long param_1,byte *param_2,uint param_3)

{
  byte *pbVar1;
  byte *pbVar2;
  ulong uVar3;
  byte *pbVar4;
  ulong uVar5;
  byte *pbVar6;
  undefined8 uVar7;
  
  pbVar1 = (byte *)(param_1 + 0xb0);
  pbVar4 = pbVar1;
  if (param_3 != 0) {
    uVar3 = 0;
    pbVar6 = param_2;
    do {
      uVar5 = uVar3;
      pbVar2 = param_2 + uVar5;
      *pbVar2 = *pbVar2 ^ *pbVar4;
      pbVar2[1] = pbVar2[1] ^ pbVar4[1];
      pbVar2[2] = pbVar2[2] ^ pbVar4[2];
                    /* try { // try from 0053e214 to 0063e21b has its CatchHandler @ 0053e240 */
      pbVar2[3] = pbVar2[3] ^ pbVar4[3];
                    /* try { // try from 0053e21c to 0063e243 has its CatchHandler @ 0053e0cc */
      pbVar2[4] = pbVar2[4] ^ pbVar4[4];
      pbVar2[5] = pbVar2[5] ^ pbVar4[5];
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053e214 with catch @ 0053e240
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053e3b0 with catch @ 0053e244
                       catch(type#1 @ 00000000) { ... } // from try @ 0053e3fc with catch @ 0053e244
                       catch(type#1 @ 00000000) { ... } // from try @ 0053e474 with catch @ 0053e244
                        */
      pbVar2[6] = pbVar2[6] ^ pbVar4[6];
      pbVar2[7] = pbVar2[7] ^ pbVar4[7];
      pbVar2[8] = pbVar2[8] ^ pbVar4[8];
      pbVar2[9] = pbVar2[9] ^ pbVar4[9];
      pbVar2[10] = pbVar2[10] ^ pbVar4[10];
      pbVar2[0xb] = pbVar2[0xb] ^ pbVar4[0xb];
      pbVar2[0xc] = pbVar2[0xc] ^ pbVar4[0xc];
      pbVar2[0xd] = pbVar2[0xd] ^ pbVar4[0xd];
      pbVar2[0xe] = pbVar2[0xe] ^ pbVar4[0xe];
      pbVar2[0xf] = pbVar2[0xf] ^ pbVar4[0xf];
      FUN_0053d8b8(pbVar2,param_1);
      pbVar4 = pbVar6;
      uVar3 = uVar5 + 0x10;
      pbVar6 = pbVar6 + 0x10;
    } while (uVar5 + 0x10 < (ulong)param_3);
    pbVar4 = param_2 + uVar5;
  }
  uVar7 = *(undefined8 *)pbVar4;
  *(undefined8 *)(param_1 + 0xb8) = *(undefined8 *)(pbVar4 + 8);
  *(undefined8 *)pbVar1 = uVar7;
  return;
}



// ===== FUN_0053c0a0 @ 0053c0a0 size=1736 =====

/* WARNING: Type propagation algorithm not settling */

void FUN_0053c0a0(long param_1,int *param_2,undefined8 param_3,short param_4)

{
  size_t __n;
  size_t sVar1;
  char *__s1;
  ulong uVar2;
  void *__s1_00;
  byte bVar3;
  ushort uVar4;
  char cVar5;
  bool bVar6;
  long lVar7;
  int iVar8;
  int iVar9;
  undefined8 uVar10;
  long *plVar11;
  undefined8 *puVar12;
  long lVar13;
  size_t sVar14;
  long lVar15;
  char *pcVar16;
  char *__s2;
  long *plVar17;
  uint uVar18;
  long *plVar19;
  ulong local_160;
  undefined8 local_158;
  char *local_150;
  byte local_148 [16];
  void *local_138;
  ulong local_130;
  ulong local_128;
  void *local_120;
  byte local_118 [16];
  void *local_108;
  ulong local_100;
  undefined8 local_f8;
  char *local_f0;
  byte local_e8 [16];
  void *local_d8;
  ulong local_d0;
  undefined8 local_c8;
  void *local_c0;
  byte local_b8 [16];
  void *local_a8;
  ulong local_a0;
  size_t local_98;
  char *local_90;
  byte local_88 [16];
  void *local_78;
  ulong local_70;
  ulong local_68;
  void *local_60;
  long local_58;
  
  lVar7 = tpidr_el0;
  local_58 = *(long *)(lVar7 + 0x28);
  if (*(char *)(param_1 + 0x18) == '\0') goto LAB_0053c1d8;
  if (*(long *)(param_1 + 0x58) != 0) {
                    /* try { // try from 0053c0e4 to 0063c0ef has its CatchHandler @ 0053c15c */
    FUN_00490d6c();
    plVar19 = *(long **)(param_1 + 0x60);
    *(undefined8 *)(param_1 + 0x58) = 0;
    *(undefined8 *)(param_1 + 0x60) = 0;
    if (plVar19 != (long *)0x0) {
      plVar11 = plVar19 + 1;
      do {
                    /* try { // try from 0053c0f8 to 0063c0fb has its CatchHandler @ 0053c168 */
        lVar15 = *plVar11;
        cVar5 = '\x01';
        bVar6 = (bool)ExclusiveMonitorPass(plVar11,0x10);
        if (bVar6) {
          *plVar11 = lVar15 + -1;
          cVar5 = ExclusiveMonitorsStatus();
        }
      } while (cVar5 != '\0');
      if (lVar15 == 0) {
        (**(code **)(*plVar19 + 0x10))(plVar19);
        std::__ndk1::__shared_weak_count::__release_weak();
      }
    }
  }
  if (*(int *)(param_1 + 0xac) != 4) goto LAB_0053c1d8;
  if ((*param_2 == 0) && (uVar10 = FUN_00489a48(param_3), (int)uVar10 != 0)) {
    local_68 = 0;
    local_60 = (void *)0x0;
    local_70 = 0;
    FUN_0053cff4(uVar10,3,param_3,&local_70);
    uVar2 = local_70 >> 1 & 0x7f;
    if ((local_70 & 1) != 0) {
      uVar2 = local_68;
    }
    if ((uVar2 == 0) && ((param_4 == 0xce || (param_4 == 200)))) {
      uVar10 = FUN_00175474(local_88,&DAT_005e0309);
      local_98 = 0;
      local_90 = (char *)0x0;
      local_a0 = 0;
      FUN_0053a780(uVar10,param_3,local_88,&local_a0);
                    /* try { // try from 0053c334 to 0063c33b has its CatchHandler @ 0053c378 */
      uVar10 = FUN_00175474(local_b8,"//NewInternalClient");
      local_c8 = 0;
      local_c0 = (void *)0x0;
                    /* try { // try from 0053c33c to 0063c3cb has its CatchHandler @ 0053c194 */
      local_d0 = 0;
      FUN_0053a780(uVar10,param_3,local_b8,&local_d0);
      uVar2 = local_a0;
      bVar3 = *(byte *)(param_1 + 400);
      sVar14 = local_a0 >> 1 & 0x7f;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c2d4 with catch @ 0053c368
                        */
      __n = sVar14;
      if ((local_a0 & 1) != 0) {
        __n = local_98;
      }
      sVar1 = (ulong)(bVar3 >> 1);
      if ((bVar3 & 1) != 0) {
        sVar1 = *(size_t *)(param_1 + 0x198);
      }
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c334 with catch @ 0053c378
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c2a8 with catch @ 0053c37c
                        */
      if (__n == sVar1) {
        __s2 = *(char **)(param_1 + 0x1a0);
        pcVar16 = (char *)((ulong)&local_a0 | 1);
        __s1 = pcVar16;
        if ((local_a0 & 1) != 0) {
          __s1 = local_90;
        }
        if ((bVar3 & 1) == 0) {
          __s2 = (char *)(param_1 + 0x191);
        }
        sVar1 = __n;
        if ((local_a0 & 1) == 0) {
          while (sVar1 != 0) {
            if (*pcVar16 != *__s2) goto LAB_0053c3e0;
            pcVar16 = pcVar16 + 1;
            __s2 = __s2 + 1;
            sVar14 = sVar14 - 1;
            sVar1 = sVar14;
          }
        }
        else {
                    /* try { // try from 0053c3d4 to 0063c3df has its CatchHandler @ 0053c194 */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c3cc with catch @ 0053c3dc
                        */
          if ((__n != 0) && (iVar8 = memcmp(__s1,__s2,__n), iVar8 != 0)) goto LAB_0053c3e0;
        }
LAB_0053c4a0:
                    /* catch() { ... } // from try @ 0053c56c with catch @ 0053c4a0 */
        uVar10 = FUN_00175474(local_e8,"//NewExternalPort");
        local_f8 = 0;
        local_f0 = (char *)0x0;
        local_100 = 0;
        FUN_0053a780(uVar10,param_3,local_e8,&local_100);
        uVar10 = FUN_00175474(local_118,"//NewProtocol");
        local_128 = 0;
        local_120 = (void *)0x0;
        local_130 = 0;
        FUN_0053a780(uVar10,param_3,local_118,&local_130);
        uVar10 = FUN_00175474(local_148,"//NewInternalPort");
        local_158 = 0;
        local_150 = (char *)0x0;
        local_160 = 0;
        FUN_0053a780(uVar10,param_3,local_148,&local_160);
        uVar2 = local_130 >> 1 & 0x7f;
        if ((local_130 & 1) != 0) {
          uVar2 = local_128;
        }
        if (uVar2 == 3) {
          __s1_00 = (void *)((ulong)&local_130 | 1);
          if ((local_130 & 1) != 0) {
            __s1_00 = local_120;
          }
          iVar8 = memcmp(__s1_00,&DAT_005c1476,3);
                    /* try { // try from 0053c558 to 0063c56b has its CatchHandler @ 0053c5d8 */
          uVar18 = (uint)(iVar8 == 0);
        }
        else {
          uVar18 = 0;
        }
                    /* try { // try from 0053c56c to 0063c627 has its CatchHandler @ 0053c4a0 */
        pcVar16 = (char *)((ulong)&local_160 | 1);
        if ((local_160 & 1) != 0) {
          pcVar16 = local_150;
        }
        uVar2 = local_160 & 1;
        iVar8 = atoi(pcVar16);
        pcVar16 = (char *)((ulong)&local_100 | 1);
        if ((local_100 & 1) != 0) {
          pcVar16 = local_f0;
        }
        iVar9 = atoi(pcVar16);
        uVar4 = *(ushort *)(param_1 + 0x180);
        plVar19 = operator_new(0x20);
        *(short *)((long)plVar19 + 0x14) = (short)iVar8;
        *(short *)((long)plVar19 + 0x16) = (short)iVar9;
        *(undefined4 *)(plVar19 + 2) = 2;
        *(uint *)(plVar19 + 3) = uVar18 ^ 1;
        *(uint *)((long)plVar19 + 0x1c) = uVar4 - 1;
                    /* catch() { ... } // from try @ 0053c558 with catch @ 0053c5d8 */
        plVar19[1] = param_1 + 0x168;
        lVar15 = *(long *)(param_1 + 0x168);
        *plVar19 = lVar15;
        *(long **)(lVar15 + 8) = plVar19;
        *(long **)(param_1 + 0x168) = plVar19;
        *(long *)(param_1 + 0x178) = *(long *)(param_1 + 0x178) + 1;
        if (uVar2 != 0) {
          operator_delete(local_150);
                    /* try { // try from 0053c628 to 0063c70b has its CatchHandler @ 0053c628
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c628 with catch @ 0053c628
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c740 with catch @ 0053c628
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c7a0 with catch @ 0053c628
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c7d8 with catch @ 0053c628
                        */
        }
        if ((local_148[0] & 1) != 0) {
          operator_delete(local_138);
        }
        if ((local_130 & 1) != 0) {
          operator_delete(local_120);
        }
        if ((local_118[0] & 1) != 0) {
          operator_delete(local_108);
        }
        if ((local_100 & 1) != 0) {
LAB_0053c6d0:
          operator_delete(local_f0);
        }
      }
      else {
LAB_0053c3e0:
        if (__n == 6) {
          pcVar16 = (char *)((ulong)&local_a0 | 1);
          if ((uVar2 & 1) != 0) {
            pcVar16 = local_90;
          }
          iVar8 = memcmp(pcVar16,"appmap",6);
          if (iVar8 == 0) goto LAB_0053c4a0;
        }
        uVar10 = FUN_00175474(local_e8,"//NewExternalPort");
        local_f8 = 0;
        local_f0 = (char *)0x0;
        local_100 = 0;
        FUN_0053a780(uVar10,param_3,local_e8,&local_100);
        bVar3 = (byte)local_100;
        pcVar16 = (char *)((ulong)&local_100 | 1);
        if ((local_100 & 1) != 0) {
          pcVar16 = local_f0;
        }
        uVar18 = atoi(pcVar16);
        plVar19 = (long *)(param_1 + 0x158);
        plVar11 = *(long **)(param_1 + 0x158);
        if (*(long **)(param_1 + 0x158) == (long *)0x0) {
          lVar15 = *plVar19;
          plVar17 = plVar19;
        }
        else {
          do {
            while (plVar17 = plVar11, (uint)*(ushort *)((long)plVar17 + 0x1a) <= (uVar18 & 0xffff))
            {
              if ((uVar18 & 0xffff) <= (uint)*(ushort *)((long)plVar17 + 0x1a)) goto LAB_0053c678;
              plVar19 = plVar17 + 1;
              plVar11 = (long *)*plVar19;
              if ((long *)*plVar19 == (long *)0x0) goto LAB_0053c678;
            }
            plVar19 = plVar17;
            plVar11 = (long *)*plVar17;
          } while ((long *)*plVar17 != (long *)0x0);
LAB_0053c678:
          lVar15 = *plVar19;
        }
        if (lVar15 == 0) {
          puVar12 = operator_new(0x20);
          *(short *)((long)puVar12 + 0x1a) = (short)uVar18;
          *puVar12 = 0;
          puVar12[1] = 0;
          puVar12[2] = plVar17;
          *plVar19 = (long)puVar12;
          if (**(long **)(param_1 + 0x150) != 0) {
            *(long *)(param_1 + 0x150) = **(long **)(param_1 + 0x150);
            puVar12 = (undefined8 *)*plVar19;
          }
          FUN_00176d70(*(undefined8 *)(param_1 + 0x158),puVar12);
          *(long *)(param_1 + 0x160) = *(long *)(param_1 + 0x160) + 1;
          bVar3 = (byte)local_100;
        }
        if ((bVar3 & 1) != 0) goto LAB_0053c6d0;
      }
      if ((local_e8[0] & 1) != 0) {
                    /* try { // try from 0053c720 to 0063c72b has its CatchHandler @ 0053c7bc */
        operator_delete(local_d8);
      }
      if ((local_d0 & 1) != 0) {
        operator_delete(local_c0);
                    /* try { // try from 0053c738 to 0063c73f has its CatchHandler @ 0053c7b8 */
      }
      if ((local_b8[0] & 1) != 0) {
                    /* try { // try from 0053c740 to 0063c797 has its CatchHandler @ 0053c628 */
        operator_delete(local_a8);
      }
      if ((local_a0 & 1) != 0) {
        operator_delete(local_90);
      }
      if ((local_88[0] & 1) != 0) {
        operator_delete(local_78);
      }
    }
    else {
      *(undefined1 *)(param_1 + 0x148) = 1;
    }
    if ((local_70 & 1) != 0) {
      operator_delete(local_60);
    }
  }
  else {
    *(undefined1 *)(param_1 + 0x148) = 1;
  }
  plVar19 = *(long **)(param_1 + 0x70);
                    /* try { // try from 0053c148 to 0063c153 has its CatchHandler @ 0053c15c */
  lVar15 = *plVar19;
  *(long *)(lVar15 + 8) = plVar19[1];
                    /* try { // try from 0053c154 to 0063c183 has its CatchHandler @ 0053bfcc */
  *(long *)plVar19[1] = lVar15;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c040 with catch @ 0053c15c
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c0e4 with catch @ 0053c15c
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c148 with catch @ 0053c15c
                        */
  *(long *)(param_1 + 0x78) = *(long *)(param_1 + 0x78) + -1;
  operator_delete(plVar19);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c0f8 with catch @ 0053c168
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c020 with catch @ 0053c16c
                        */
  if (*(char *)(param_1 + 0x148) == '\0') {
    uVar4 = *(ushort *)(param_1 + 0x180);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c09c with catch @ 0053c178
                        */
    *(ushort *)(param_1 + 0x180) = uVar4 + 1;
    if (*(char *)(param_1 + 0x18) != '\0') {
                    /* try { // try from 0053c184 to 0063c187 has its CatchHandler @ 0053c190 */
                    /* try { // try from 0053c188 to 0063c193 has its CatchHandler @ 0053bfcc */
      plVar19 = operator_new(0x20);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053c184 with catch @ 0053c190
                        */
      *(undefined8 *)((long)plVar19 + 0x14) = 0;
                    /* try { // try from 0053c194 to 0063c2a7 has its CatchHandler @ 0053c194
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c194 with catch @ 0053c194
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c2e0 with catch @ 0053c194
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c33c with catch @ 0053c194
                       catch(type#1 @ 00000000) { ... } // from try @ 0053c3d4 with catch @ 0053c194
                        */
      *(uint *)((long)plVar19 + 0x1c) = (uint)uVar4;
      *(undefined4 *)(plVar19 + 2) = 3;
      lVar15 = *(long *)(param_1 + 0x68);
      *plVar19 = lVar15;
      plVar19[1] = param_1 + 0x68;
      *(long **)(lVar15 + 8) = plVar19;
      *(long **)(param_1 + 0x68) = plVar19;
      *(long *)(param_1 + 0x78) = *(long *)(param_1 + 0x78) + 1;
    }
  }
  *(undefined4 *)(param_1 + 0xac) = 5;
  uVar10 = FUN_00420784();
  *(undefined8 *)(param_1 + 0xb0) = uVar10;
  if (*(long *)(param_1 + 0x78) == 0) {
    if (*(long *)(param_1 + 0x178) == 0) goto LAB_0053c1d8;
    plVar17 = *(long **)(param_1 + 0x170);
    plVar19 = (long *)(param_1 + 0x168);
    plVar11 = plVar19;
    if (plVar19 != plVar17) {
      lVar15 = 1;
      do {
        plVar11 = operator_new(0x20);
        lVar13 = plVar17[2];
        plVar11[3] = plVar17[3];
        plVar11[2] = lVar13;
        lVar13 = *(long *)(param_1 + 0x68);
        *plVar11 = lVar13;
        plVar11[1] = param_1 + 0x68;
        *(long **)(lVar13 + 8) = plVar11;
        *(long **)(param_1 + 0x68) = plVar11;
        *(long *)(param_1 + 0x78) = lVar15;
        plVar17 = (long *)plVar17[1];
        lVar15 = lVar15 + 1;
      } while (plVar19 != plVar17);
      plVar11 = *(long **)(param_1 + 0x170);
                    /* try { // try from 0053c2a8 to 0063c2af has its CatchHandler @ 0053c37c */
    }
    lVar15 = *(long *)(param_1 + 0x168);
    lVar13 = *plVar11;
    *(undefined8 *)(lVar13 + 8) = *(undefined8 *)(lVar15 + 8);
    **(long **)(lVar15 + 8) = lVar13;
    *(undefined8 *)(param_1 + 0x178) = 0;
    while (plVar11 != plVar19) {
                    /* try { // try from 0053c2d4 to 0063c2df has its CatchHandler @ 0053c368 */
      plVar17 = (long *)plVar11[1];
      operator_delete(plVar11);
                    /* try { // try from 0053c2e0 to 0063c333 has its CatchHandler @ 0053c194 */
      plVar11 = plVar17;
    }
  }
  FUN_0053a8e8(param_1);
LAB_0053c1d8:
  if (*(long *)(lVar7 + 0x28) != local_58) {
                    /* WARNING: Subroutine does not return */
    __stack_chk_fail();
  }
  return;
}



// ===== FUN_0053a8e8 @ 0053a8e8 size=3220 =====

void FUN_0053a8e8(long param_1)

{
  uint uVar1;
  byte bVar2;
  ushort uVar3;
  char cVar4;
  int iVar5;
  long lVar6;
  bool bVar7;
  uint uVar8;
  int iVar9;
  size_t sVar10;
  void *pvVar11;
  ulong *puVar12;
  undefined8 uVar13;
  ulong uVar14;
  long *plVar15;
  code *pcVar16;
  long *plVar17;
  long lVar18;
  long *plVar19;
  ushort uVar20;
  void *__dest;
  int iVar21;
  undefined1 *__dest_00;
  long lVar22;
  ulong uVar23;
  undefined1 local_1270 [8];
  long *local_1268;
  undefined1 local_1260 [8];
  long *local_1258;
  undefined1 local_1250 [8];
  long *local_1248;
  undefined1 local_1240 [8];
  long *local_1238;
  undefined1 auStack_1230 [8];
  long *local_1228;
  undefined8 local_1220;
  long *local_1218;
  ulong local_1210;
  ulong uStack_1208;
  undefined1 *local_1200;
  byte local_11e8 [8];
  ulong local_11e0;
  void *local_11d8;
  ulong local_11d0;
  long *local_11c8;
  void *local_11c0;
  byte local_11b8 [8];
  long *local_11b0;
  void *local_11a8;
  ulong local_11a0;
  ulong uStack_1198;
  undefined1 *local_1190;
  ulong local_1180;
  ulong uStack_1178;
  void *local_1170;
  ulong local_1160;
  undefined8 local_1158;
  void *local_1150;
  ulong local_1148;
  ulong local_1140;
  void *local_1138;
  long alStack_1130 [4];
  long *local_1110;
  long alStack_1100 [4];
  long *local_10e0;
  long alStack_10d0 [4];
  long *local_10b0;
  long alStack_10a0 [4];
  long *local_1080;
  byte local_1068 [16];
  void *local_1058;
  char acStack_868 [2048];
  long local_68;
  
  lVar6 = tpidr_el0;
  local_68 = *(long *)(lVar6 + 0x28);
  if (((*(char *)(param_1 + 0x18) == '\0') || (*(long *)(param_1 + 0x78) == 0)) ||
     (*(long *)(param_1 + 0x58) != 0)) goto LAB_0053b4a8;
  uVar3 = *(ushort *)(*(long *)(param_1 + 0x70) + 0x16);
  iVar5 = *(int *)(*(long *)(param_1 + 0x70) + 0x10) + -1;
  local_1140 = 0;
  local_1138 = (void *)0x0;
  local_1150 = (void *)0x0;
  local_1148 = 0;
  local_1160 = 0;
  local_1158 = 0;
  switch(iVar5) {
  case 0:
    FUN_004699a4(local_1068,*(undefined4 *)(param_1 + 0xa8));
    FUN_00420afc(&local_1210,param_1 + 0x94);
    if (((byte)local_1210 & 1) == 0) {
      uStack_1208 = (ulong)((byte)local_1210 >> 1);
    }
    else {
      operator_delete(local_1200);
    }
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053ab3c with catch @ 0053abd0
                        */
    uVar13 = FUN_0041fffc();
    uVar8 = FUN_004200d4(uVar13,0);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053ab9c with catch @ 0053abe0
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053ab10 with catch @ 0053abe4
                        */
    std::__ndk1::to_string(uVar8 & 0xffff);
    puVar12 = (ulong *)FUN_001a84d0(local_11b8,0,"vod",3);
    local_1190 = (undefined1 *)puVar12[2];
    uStack_1198 = puVar12[1];
    local_11a0 = *puVar12;
    puVar12[1] = 0;
    puVar12[2] = 0;
    *puVar12 = 0;
    puVar12 = (ulong *)FUN_00183908(&local_11a0,&DAT_005cdfe6,1);
    local_1170 = (void *)puVar12[2];
    uStack_1178 = puVar12[1];
    local_1180 = *puVar12;
                    /* try { // try from 0053ac34 to 0063ac3b has its CatchHandler @ 0053ac44 */
                    /* try { // try from 0053ac3c to 0063ac47 has its CatchHandler @ 0053a9f4 */
    puVar12[1] = 0;
    puVar12[2] = 0;
    *puVar12 = 0;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053ac34 with catch @ 0053ac44
                        */
                    /* try { // try from 0053ac48 to 0063ad0b has its CatchHandler @ 0053ac48
                       catch(type#1 @ 00000000) { ... } // from try @ 0053ac48 with catch @ 0053ac48
                        */
    FUN_00420afc(local_11e8,param_1 + 0x94);
    uVar23 = (long)((uStack_1208 << 0x20) + -0x800000000) >> 0x20;
    uVar14 = (ulong)(local_11e8[0] >> 1);
    if ((local_11e8[0] & 1) != 0) {
      uVar14 = local_11e0;
    }
    plVar15 = (long *)(uVar14 - uVar23);
    local_11c8 = (long *)0x0;
    local_11c0 = (void *)0x0;
    local_11d0 = 0;
    if (uVar14 < uVar23) {
                    /* WARNING: Subroutine does not return */
      FUN_00176a64(&local_11d0);
    }
    pvVar11 = (void *)((ulong)local_11e8 | 1);
    if ((local_11e8[0] & 1) != 0) {
      pvVar11 = local_11d8;
    }
    if ((long *)0xffffffffffffffef < plVar15) {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053b540 with catch @ 0053b56c
                        */
                    /* WARNING: Subroutine does not return */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053b654 with catch @ 0053b570
                       catch(type#1 @ 00000000) { ... } // from try @ 0053b6a0 with catch @ 0053b570
                       catch(type#1 @ 00000000) { ... } // from try @ 0053b718 with catch @ 0053b570
                        */
      FUN_00174d3c(&local_11d0);
    }
    if (plVar15 < (long *)0x17) {
      __dest = (void *)((ulong)&local_11d0 | 1);
      local_11d0 = (ulong)(byte)((int)plVar15 << 1);
      if (plVar15 != (long *)0x0) goto LAB_0053acdc;
    }
    else {
      __dest = operator_new((ulong)(plVar15 + 2) & 0xfffffffffffffff0);
      local_11d0 = (ulong)(plVar15 + 2) & 0xfffffffffffffff0 | 1;
      local_11c8 = plVar15;
      local_11c0 = __dest;
LAB_0053acdc:
      memcpy(__dest,(void *)((long)pvVar11 + uVar23),(size_t)plVar15);
    }
    *(undefined1 *)((long)__dest + (long)plVar15) = 0;
    plVar15 = (long *)(local_11d0 >> 1 & 0x7f);
    pvVar11 = (void *)((ulong)&local_11d0 | 1);
    if ((local_11d0 & 1) != 0) {
      plVar15 = local_11c8;
      pvVar11 = local_11c0;
    }
                    /* try { // try from 0053ad0c to 0063ad13 has its CatchHandler @ 0053ad30 */
    puVar12 = (ulong *)FUN_00183908(&local_1180,pvVar11,plVar15);
    local_1200 = (undefined1 *)puVar12[2];
    uStack_1208 = puVar12[1];
    local_1210 = *puVar12;
                    /* try { // try from 0053ad24 to 0063ad2b has its CatchHandler @ 0053ad2c */
    puVar12[1] = 0;
    puVar12[2] = 0;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053ad24 with catch @ 0053ad2c
                        */
    *puVar12 = 0;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053ad0c with catch @ 0053ad30
                        */
    uVar8 = (uint)uVar3;
    if ((local_11d0 & 1) == 0) {
      if ((local_11e8[0] & 1) == 0) goto LAB_0053ad40;
LAB_0053adb0:
      operator_delete(local_11d8);
      if ((local_1180 & 1) != 0) goto LAB_0053adc0;
LAB_0053ad48:
      if ((local_11a0 & 1) == 0) goto LAB_0053ad50;
LAB_0053add0:
      operator_delete(local_1190);
      if ((local_11b8[0] & 1) != 0) goto LAB_0053ade0;
LAB_0053ad58:
      if (uVar8 != 0) goto LAB_0053ad5c;
LAB_0053adec:
      uVar20 = 0;
    }
    else {
      operator_delete(local_11c0);
      if ((local_11e8[0] & 1) != 0) goto LAB_0053adb0;
LAB_0053ad40:
      if ((local_1180 & 1) == 0) goto LAB_0053ad48;
LAB_0053adc0:
      operator_delete(local_1170);
      if ((local_11a0 & 1) != 0) goto LAB_0053add0;
LAB_0053ad50:
      if ((local_11b8[0] & 1) == 0) goto LAB_0053ad58;
LAB_0053ade0:
      operator_delete(local_11a8);
      if (uVar8 == 0) goto LAB_0053adec;
LAB_0053ad5c:
      plVar15 = *(long **)(param_1 + 0x158);
      uVar20 = uVar3;
      if (plVar15 != (long *)0x0) {
        plVar19 = (long *)(param_1 + 0x158);
        plVar17 = plVar19;
        do {
          bVar7 = *(ushort *)((long)plVar15 + 0x1a) < uVar8;
          if (!bVar7) {
            plVar17 = plVar15;
          }
          plVar15 = (long *)plVar15[bVar7];
        } while (plVar15 != (long *)0x0);
        if ((plVar17 != plVar19) && (*(ushort *)((long)plVar17 + 0x1a) <= uVar8)) {
          iVar21 = 0;
          while( true ) {
            iVar9 = rand();
            plVar17 = (long *)*plVar19;
            uVar1 = uVar8 + iVar9 % 500;
            uVar20 = (ushort)uVar1;
            plVar15 = plVar19;
            if (plVar17 == (long *)0x0) break;
            do {
              bVar7 = (uint)*(ushort *)((long)plVar17 + 0x1a) < (uVar1 & 0xffff);
              if (!bVar7) {
                plVar15 = plVar17;
              }
              plVar17 = (long *)plVar17[bVar7];
            } while (plVar17 != (long *)0x0);
                    /* try { // try from 0053b540 to 0063b547 has its CatchHandler @ 0053b56c */
                    /* try { // try from 0053b548 to 0063b56f has its CatchHandler @ 0053b418 */
            if (((plVar15 == plVar19) ||
                ((uVar1 & 0xffff) < (uint)*(ushort *)((long)plVar15 + 0x1a))) ||
               (iVar21 = iVar21 + 1, uVar20 = uVar3, iVar21 == 100)) break;
          }
        }
      }
    }
    *(ushort *)(param_1 + 0x182) = uVar20;
                    /* try { // try from 0053ae04 to 0063aec7 has its CatchHandler @ 0053ae04
                       catch(type#1 @ 00000000) { ... } // from try @ 0053ae04 with catch @ 0053ae04
                        */
    FUN_00174ddc(&local_1148,"AddPortMapping",0xe);
    FUN_0053ba78(acStack_868);
    if ((local_1210 & 1) != 0) {
      operator_delete(local_1200);
    }
    if ((local_1068[0] & 1) != 0) {
      operator_delete(local_1058);
    }
    goto switchD_0053a980_default;
  case 1:
    FUN_00174ddc(&local_1148,"DeletePortMapping",0x11);
    break;
  case 2:
    FUN_00174ddc(&local_1148,"GetGenericPortMappingEntry",0x1a);
    break;
  case 3:
                    /* try { // try from 0053a9f4 to 0063ab0f has its CatchHandler @ 0053a9f4
                       catch(type#1 @ 00000000) { ... } // from try @ 0053a9f4 with catch @ 0053a9f4
                       catch(type#1 @ 00000000) { ... } // from try @ 0053ab48 with catch @ 0053a9f4
                       catch(type#1 @ 00000000) { ... } // from try @ 0053aba4 with catch @ 0053a9f4
                       catch(type#1 @ 00000000) { ... } // from try @ 0053ac3c with catch @ 0053a9f4
                        */
    FUN_00174ddc(&local_1148,"GetSpecificPortMappingEntry",0x1b);
    break;
  default:
    goto switchD_0053a980_default;
  }
  FUN_0053ba78(acStack_868);
switchD_0053a980_default:
  uVar14 = local_1148 >> 1 & 0x7f;
  if ((local_1148 & 1) != 0) {
    uVar14 = local_1140;
  }
  if (uVar14 != 0) {
    sVar10 = strlen(acStack_868);
    FUN_00174ddc(&local_1160,acStack_868,sVar10);
    FUN_0053ba78(local_1068);
                    /* try { // try from 0053ab10 to 0063ab17 has its CatchHandler @ 0053abe4 */
    FUN_00175474(&local_1180,local_1068);
    FUN_001d8714(&local_11a0,(byte *)(param_1 + 0xb8),param_1 + 0xd0);
    bVar2 = *(byte *)(param_1 + 0xb8);
    if ((bVar2 & 1) == 0) {
                    /* try { // try from 0053ab3c to 0063ab47 has its CatchHandler @ 0053abd0 */
      lVar18 = param_1 + 0xb9;
      uVar14 = (ulong)(bVar2 >> 1);
                    /* try { // try from 0053ab48 to 0063ab9b has its CatchHandler @ 0053a9f4 */
    }
    else {
      uVar14 = *(ulong *)(param_1 + 0xc0);
      lVar18 = *(long *)(param_1 + 200);
    }
    if (((8 < uVar14) &&
        (pvVar11 = memchr((void *)(lVar18 + 8),0x2f,uVar14 - 8), pvVar11 != (void *)0x0)) &&
       (uVar14 = (long)pvVar11 - lVar18, uVar14 != 0xffffffffffffffff)) {
      uStack_1208 = 0;
      local_1200 = (undefined1 *)0x0;
      local_1210 = 0;
      uVar23 = *(ulong *)(param_1 + 0xc0);
      pvVar11 = *(void **)(param_1 + 200);
      if ((bVar2 & 1) == 0) {
        pvVar11 = (void *)(param_1 + 0xb9);
        uVar23 = (ulong)(bVar2 >> 1);
      }
                    /* try { // try from 0053ab9c to 0063aba3 has its CatchHandler @ 0053abe0 */
      if (uVar14 <= uVar23) {
        uVar23 = uVar14;
      }
                    /* try { // try from 0053aba4 to 0063ac33 has its CatchHandler @ 0053a9f4 */
      if (0xffffffffffffffef < uVar23) {
                    /* WARNING: Subroutine does not return */
        FUN_00174d3c(&local_1210);
      }
      if (uVar23 < 0x17) {
        __dest_00 = (undefined1 *)((ulong)&local_1210 | 1);
        local_1210 = (ulong)(byte)((int)uVar23 << 1);
        if (uVar23 != 0) goto LAB_0053aee8;
      }
      else {
                    /* try { // try from 0053aec8 to 0063aecf has its CatchHandler @ 0053aeec */
        uVar14 = uVar23 + 0x10 & 0xfffffffffffffff0;
        __dest_00 = operator_new(uVar14);
        local_1210 = uVar14 | 1;
                    /* try { // try from 0053aee0 to 0063aee7 has its CatchHandler @ 0053aee8 */
        uStack_1208 = uVar23;
        local_1200 = __dest_00;
LAB_0053aee8:
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053aee0 with catch @ 0053aee8
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053aec8 with catch @ 0053aeec
                        */
        memcpy(__dest_00,pvVar11,uVar23);
      }
      __dest_00[uVar23] = 0;
                    /* catch() { ... } // from try @ 0053afd0 with catch @ 0053af00 */
      if ((local_11a0 & 1) != 0) {
        *local_1190 = 0;
        uStack_1198 = 0;
        if ((local_11a0 & 1) != 0) {
          operator_delete(local_1190);
        }
      }
      uStack_1198 = uStack_1208;
      local_11a0 = local_1210;
      local_1190 = local_1200;
      uVar14 = *(ulong *)(param_1 + 0xd8);
      lVar18 = *(long *)(param_1 + 0xe0);
      if ((*(byte *)(param_1 + 0xd0) & 1) == 0) {
        lVar18 = param_1 + 0xd1;
        uVar14 = (ulong)(*(byte *)(param_1 + 0xd0) >> 1);
      }
      FUN_00183908(&local_11a0,lVar18,uVar14);
    }
    bVar7 = (local_1160 & 1) != 0;
    pvVar11 = (void *)((ulong)&local_1160 | 1);
    if (bVar7) {
      pvVar11 = local_1150;
    }
    uVar8 = (uint)((byte)local_1160 >> 1);
    if (bVar7) {
      uVar8 = (uint)local_1158;
    }
    local_1220 = 0;
    local_1218 = (long *)0x0;
    FUN_00489810(&local_1210,pvVar11,uVar8,0,&local_1220);
    if (local_1218 != (long *)0x0) {
      plVar15 = local_1218 + 1;
      do {
        lVar18 = *plVar15;
        cVar4 = '\x01';
        bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
        if (bVar7) {
          *plVar15 = lVar18 + -1;
          cVar4 = ExclusiveMonitorsStatus();
        }
      } while (cVar4 != '\0');
      if (lVar18 == 0) {
                    /* try { // try from 0053afc0 to 0063afcf has its CatchHandler @ 0053b03c */
        (**(code **)(*local_1218 + 0x10))(local_1218);
        std::__ndk1::__shared_weak_count::__release_weak();
      }
    }
                    /* try { // try from 0053afd0 to 0063b08b has its CatchHandler @ 0053af00 */
    FUN_0046a784(local_11b8,&local_11a0,&local_1180);
    uVar13 = FUN_0048b53c(*(undefined8 *)(param_1 + 0x30),*(undefined4 *)(param_1 + 0x40));
    FUN_0048d48c(auStack_1230);
    FUN_00490580(&local_11d0,uVar13,auStack_1230);
    plVar15 = local_11c8;
    uVar14 = local_11d0;
    local_11d0 = 0;
    local_11c8 = (long *)0x0;
    plVar19 = *(long **)(param_1 + 0x60);
    *(ulong *)(param_1 + 0x58) = uVar14;
    *(long **)(param_1 + 0x60) = plVar15;
    if (plVar19 != (long *)0x0) {
      plVar15 = plVar19 + 1;
      do {
        lVar18 = *plVar15;
        cVar4 = '\x01';
        bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
        if (bVar7) {
          *plVar15 = lVar18 + -1;
          cVar4 = ExclusiveMonitorsStatus();
        }
      } while (cVar4 != '\0');
      if (lVar18 == 0) {
                    /* catch() { ... } // from try @ 0053afc0 with catch @ 0053b03c */
        (**(code **)(*plVar19 + 0x10))(plVar19);
        std::__ndk1::__shared_weak_count::__release_weak();
      }
    }
    if (local_11c8 != (long *)0x0) {
      plVar15 = local_11c8 + 1;
      do {
        lVar18 = *plVar15;
        cVar4 = '\x01';
        bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
        if (bVar7) {
          *plVar15 = lVar18 + -1;
          cVar4 = ExclusiveMonitorsStatus();
        }
      } while (cVar4 != '\0');
      if (lVar18 == 0) {
        (**(code **)(*local_11c8 + 0x10))(local_11c8);
        std::__ndk1::__shared_weak_count::__release_weak();
      }
    }
    if (local_1228 != (long *)0x0) {
      plVar15 = local_1228 + 1;
      do {
                    /* try { // try from 0053b08c to 0063b177 has its CatchHandler @ 0053b08c
                       catch(type#1 @ 00000000) { ... } // from try @ 0053b08c with catch @ 0053b08c
                       catch(type#1 @ 00000000) { ... } // from try @ 0053b1ac with catch @ 0053b08c
                       catch(type#1 @ 00000000) { ... } // from try @ 0053b20c with catch @ 0053b08c
                       catch(type#1 @ 00000000) { ... } // from try @ 0053b244 with catch @ 0053b08c
                        */
        lVar18 = *plVar15;
        cVar4 = '\x01';
        bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
        if (bVar7) {
          *plVar15 = lVar18 + -1;
          cVar4 = ExclusiveMonitorsStatus();
        }
      } while (cVar4 != '\0');
      if (lVar18 == 0) {
        (**(code **)(*local_1228 + 0x10))(local_1228);
        std::__ndk1::__shared_weak_count::__release_weak();
      }
    }
    switch(iVar5) {
    case 0:
      uVar13 = *(undefined8 *)(param_1 + 0x58);
      local_1238 = local_11b0;
      if (local_11b0 != (long *)0x0) {
        plVar15 = local_11b0 + 1;
        do {
          cVar4 = '\x01';
          bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
          if (bVar7) {
            *plVar15 = *plVar15 + 1;
            cVar4 = ExclusiveMonitorsStatus();
          }
        } while (cVar4 != '\0');
      }
      if (*(long *)(param_1 + 0x10) == 0) {
LAB_0053b554:
                    /* WARNING: Subroutine does not return */
        FUN_001b8a44();
      }
      lVar22 = *(long *)(param_1 + 8);
      lVar18 = std::__ndk1::__shared_weak_count::lock();
      if (lVar18 == 0) goto LAB_0053b554;
      local_1080 = (long *)0x0;
      local_1080 = operator_new(0x28);
      *local_1080 = (long)&PTR_FUN_006eb328;
      local_1080[3] = lVar22;
      local_1080[4] = lVar18;
      local_1080[2] = 0;
      local_1080[1] = (long)FUN_0053bb0c;
      FUN_0049170c(uVar13,local_1240,&local_1210,alStack_10a0);
      if (alStack_10a0 == local_1080) {
        pcVar16 = *(code **)(*local_1080 + 0x20);
LAB_0053b3b0:
        (*pcVar16)();
      }
      else if (local_1080 != (long *)0x0) {
        pcVar16 = *(code **)(*local_1080 + 0x28);
                    /* try { // try from 0053b178 to 0063b183 has its CatchHandler @ 0053b24c */
        goto LAB_0053b3b0;
      }
      if (local_1238 != (long *)0x0) {
        plVar15 = local_1238 + 1;
        do {
          lVar18 = *plVar15;
                    /* catch() { ... } // from try @ 0053b354 with catch @ 0053b3c8 */
          cVar4 = '\x01';
          bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
          if (bVar7) {
            *plVar15 = lVar18 + -1;
            cVar4 = ExclusiveMonitorsStatus();
          }
          plVar19 = local_1238;
        } while (cVar4 != '\0');
LAB_0053b3fc:
        if (lVar18 == 0) {
          (**(code **)(*plVar19 + 0x10))(plVar19);
          std::__ndk1::__shared_weak_count::__release_weak();
        }
      }
      break;
    case 1:
      uVar13 = *(undefined8 *)(param_1 + 0x58);
      local_1248 = local_11b0;
      if (local_11b0 != (long *)0x0) {
        plVar15 = local_11b0 + 1;
        do {
          cVar4 = '\x01';
          bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
          if (bVar7) {
            *plVar15 = *plVar15 + 1;
            cVar4 = ExclusiveMonitorsStatus();
          }
        } while (cVar4 != '\0');
      }
      if (*(long *)(param_1 + 0x10) == 0) {
LAB_0053b560:
                    /* WARNING: Subroutine does not return */
        FUN_001b8a44();
      }
      lVar22 = *(long *)(param_1 + 8);
      lVar18 = std::__ndk1::__shared_weak_count::lock();
      if (lVar18 == 0) goto LAB_0053b560;
      local_10b0 = (long *)0x0;
      local_10b0 = operator_new(0x28);
      *local_10b0 = (long)&PTR_FUN_006eb328;
      local_10b0[3] = lVar22;
      local_10b0[4] = lVar18;
      local_10b0[2] = 0;
      local_10b0[1] = (long)FUN_0053bfbc;
      FUN_0049170c(uVar13,local_1250,&local_1210,alStack_10d0);
      if (alStack_10d0 == local_10b0) {
        pcVar16 = *(code **)(*local_10b0 + 0x20);
LAB_0053b3dc:
        (*pcVar16)();
      }
      else if (local_10b0 != (long *)0x0) {
        pcVar16 = *(code **)(*local_10b0 + 0x28);
        goto LAB_0053b3dc;
      }
      if (local_1248 != (long *)0x0) {
        plVar15 = local_1248 + 1;
        do {
          lVar18 = *plVar15;
          cVar4 = '\x01';
          bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
          if (bVar7) {
            *plVar15 = lVar18 + -1;
            cVar4 = ExclusiveMonitorsStatus();
          }
          plVar19 = local_1248;
        } while (cVar4 != '\0');
        goto LAB_0053b3fc;
      }
      break;
    case 2:
      uVar13 = *(undefined8 *)(param_1 + 0x58);
      local_1258 = local_11b0;
      if (local_11b0 != (long *)0x0) {
                    /* try { // try from 0053b18c to 0063b197 has its CatchHandler @ 0053b228 */
        plVar15 = local_11b0 + 1;
        do {
          cVar4 = '\x01';
          bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
          if (bVar7) {
            *plVar15 = *plVar15 + 1;
            cVar4 = ExclusiveMonitorsStatus();
          }
        } while (cVar4 != '\0');
      }
                    /* try { // try from 0053b1a4 to 0063b1ab has its CatchHandler @ 0053b224 */
      if (*(long *)(param_1 + 0x10) == 0) {
LAB_0053b558:
                    /* WARNING: Subroutine does not return */
        FUN_001b8a44();
      }
      lVar22 = *(long *)(param_1 + 8);
                    /* try { // try from 0053b1ac to 0063b203 has its CatchHandler @ 0053b08c */
      lVar18 = std::__ndk1::__shared_weak_count::lock();
      if (lVar18 == 0) goto LAB_0053b558;
      local_10e0 = (long *)0x0;
      local_10e0 = operator_new(0x28);
      *local_10e0 = (long)&PTR_FUN_006eb328;
      local_10e0[3] = lVar22;
      local_10e0[4] = lVar18;
      local_10e0[2] = 0;
      local_10e0[1] = (long)FUN_0053c0a0;
      FUN_0049170c(uVar13,local_1260,&local_1210,alStack_1100);
                    /* try { // try from 0053b204 to 0063b20b has its CatchHandler @ 0053b210 */
      if (alStack_1100 == local_10e0) {
                    /* try { // try from 0053b354 to 0063b363 has its CatchHandler @ 0053b3c8 */
        pcVar16 = *(code **)(*local_10e0 + 0x20);
LAB_0053b358:
        (*pcVar16)();
      }
      else if (local_10e0 != (long *)0x0) {
                    /* try { // try from 0053b20c to 0063b237 has its CatchHandler @ 0053b08c */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053b204 with catch @ 0053b210
                        */
        pcVar16 = *(code **)(*local_10e0 + 0x28);
        goto LAB_0053b358;
      }
      if (local_1258 != (long *)0x0) {
                    /* try { // try from 0053b364 to 0063b417 has its CatchHandler @ 0053b29c */
        plVar15 = local_1258 + 1;
        do {
          lVar18 = *plVar15;
          cVar4 = '\x01';
          bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
          if (bVar7) {
            *plVar15 = lVar18 + -1;
            cVar4 = ExclusiveMonitorsStatus();
          }
          plVar19 = local_1258;
        } while (cVar4 != '\0');
        goto LAB_0053b3fc;
      }
      break;
    case 3:
      uVar13 = *(undefined8 *)(param_1 + 0x58);
      local_1268 = local_11b0;
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053b1a4 with catch @ 0053b224
                        */
      if (local_11b0 != (long *)0x0) {
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053b18c with catch @ 0053b228
                        */
        plVar15 = local_11b0 + 1;
        do {
          cVar4 = '\x01';
          bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
          if (bVar7) {
            *plVar15 = *plVar15 + 1;
            cVar4 = ExclusiveMonitorsStatus();
          }
                    /* try { // try from 0053b238 to 0063b243 has its CatchHandler @ 0053b248 */
        } while (cVar4 != '\0');
      }
      if (*(long *)(param_1 + 0x10) == 0) {
LAB_0053b55c:
                    /* WARNING: Subroutine does not return */
        FUN_001b8a44();
      }
                    /* try { // try from 0053b244 to 0063b29b has its CatchHandler @ 0053b08c */
      lVar22 = *(long *)(param_1 + 8);
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053b238 with catch @ 0053b248
                        */
      lVar18 = std::__ndk1::__shared_weak_count::lock();
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053b178 with catch @ 0053b24c
                        */
      if (lVar18 == 0) goto LAB_0053b55c;
      local_1110 = (long *)0x0;
      local_1110 = operator_new(0x28);
      *local_1110 = (long)&PTR_FUN_006eb328;
      local_1110[3] = lVar22;
      local_1110[4] = lVar18;
      local_1110[2] = 0;
      local_1110[1] = (long)FUN_0053c908;
      FUN_0049170c(uVar13,local_1270,&local_1210,alStack_1130);
                    /* catch() { ... } // from try @ 0053b364 with catch @ 0053b29c */
      if (alStack_1130 == local_1110) {
        pcVar16 = *(code **)(*local_1110 + 0x20);
LAB_0053b384:
        (*pcVar16)();
      }
      else if (local_1110 != (long *)0x0) {
        pcVar16 = *(code **)(*local_1110 + 0x28);
        goto LAB_0053b384;
      }
      if (local_1268 != (long *)0x0) {
        plVar15 = local_1268 + 1;
        do {
          lVar18 = *plVar15;
          cVar4 = '\x01';
          bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
          if (bVar7) {
            *plVar15 = lVar18 + -1;
            cVar4 = ExclusiveMonitorsStatus();
          }
          plVar19 = local_1268;
        } while (cVar4 != '\0');
        goto LAB_0053b3fc;
      }
    }
                    /* try { // try from 0053b418 to 0063b53f has its CatchHandler @ 0053b418
                       catch(type#1 @ 00000000) { ... } // from try @ 0053b418 with catch @ 0053b418
                       catch(type#1 @ 00000000) { ... } // from try @ 0053b548 with catch @ 0053b418
                        */
    *(undefined4 *)(param_1 + 0xac) = 4;
    uVar13 = FUN_00420784();
    *(undefined8 *)(param_1 + 0xb0) = uVar13;
    if (local_11b0 != (long *)0x0) {
      plVar15 = local_11b0 + 1;
      do {
        lVar18 = *plVar15;
        cVar4 = '\x01';
        bVar7 = (bool)ExclusiveMonitorPass(plVar15,0x10);
        if (bVar7) {
          *plVar15 = lVar18 + -1;
          cVar4 = ExclusiveMonitorsStatus();
        }
      } while (cVar4 != '\0');
      if (lVar18 == 0) {
        (**(code **)(*local_11b0 + 0x10))(local_11b0);
        std::__ndk1::__shared_weak_count::__release_weak();
      }
    }
    FUN_0048996c(&local_1210);
    if ((local_11a0 & 1) != 0) {
      operator_delete(local_1190);
    }
    if ((local_1180 & 1) != 0) {
      operator_delete(local_1170);
    }
  }
  if ((local_1160 & 1) != 0) {
    operator_delete(local_1150);
  }
  if ((local_1148 & 1) != 0) {
    operator_delete(local_1138);
  }
LAB_0053b4a8:
  if (*(long *)(lVar6 + 0x28) == local_68) {
    return;
  }
                    /* WARNING: Subroutine does not return */
  __stack_chk_fail();
}



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



// ===== FUN_0053d8b8 @ 0053d8b8 size=972 =====

void FUN_0053d8b8(byte *param_1,byte *param_2)

{
  byte *pbVar1;
  byte bVar2;
  byte bVar3;
  byte bVar4;
  byte bVar5;
  byte bVar6;
  byte bVar7;
  byte bVar8;
  byte bVar9;
  byte bVar10;
  byte bVar11;
  byte bVar12;
  byte bVar13;
  long lVar14;
  byte bVar15;
  byte bVar16;
  byte bVar17;
  byte bVar18;
  byte bVar19;
  uint uVar20;
  
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053d8ac with catch @ 0053d8bc
                        */
  bVar12 = *param_1 ^ *param_2;
  *param_1 = bVar12;
  bVar9 = param_1[1] ^ param_2[1];
  param_1[1] = bVar9;
  bVar10 = param_1[2] ^ param_2[2];
  param_1[2] = bVar10;
  uVar20 = 1;
  bVar11 = param_1[3] ^ param_2[3];
  param_1[3] = bVar11;
  bVar16 = param_1[4] ^ param_2[4];
  param_1[4] = bVar16;
  bVar13 = param_1[5] ^ param_2[5];
  param_1[5] = bVar13;
  bVar15 = param_1[6] ^ param_2[6];
  param_1[6] = bVar15;
  bVar17 = param_1[7] ^ param_2[7];
  param_1[7] = bVar17;
  bVar19 = param_1[8] ^ param_2[8];
                    /* try { // try from 0053d980 to 0063da43 has its CatchHandler @ 0053d980
                       catch(type#1 @ 00000000) { ... } // from try @ 0053d980 with catch @ 0053d980
                        */
  param_1[8] = bVar19;
  bVar18 = param_1[9] ^ param_2[9];
  param_1[9] = bVar18;
  bVar3 = param_1[10] ^ param_2[10];
  param_1[10] = bVar3;
  bVar4 = param_1[0xb] ^ param_2[0xb];
  param_1[0xb] = bVar4;
  bVar5 = param_1[0xc] ^ param_2[0xc];
  param_1[0xc] = bVar5;
  bVar6 = param_1[0xd] ^ param_2[0xd];
  param_1[0xd] = bVar6;
  bVar7 = param_1[0xe] ^ param_2[0xe];
  param_1[0xe] = bVar7;
  bVar8 = param_1[0xf] ^ param_2[0xf];
  param_1[0xf] = bVar8;
  while( true ) {
                    /* try { // try from 0053da44 to 0063da4b has its CatchHandler @ 0053da68 */
                    /* try { // try from 0053da5c to 0063da63 has its CatchHandler @ 0053da64 */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053da5c with catch @ 0053da64
                        */
                    /* catch(type#1 @ 00000000) { ... } // from try @ 0053da44 with catch @ 0053da68
                        */
                    /* catch() { ... } // from try @ 0053db88 with catch @ 0053da7c
                       catch() { ... } // from try @ 0053dbdc with catch @ 0053da7c */
    bVar12 = (&DAT_005e081f)[bVar12];
    bVar16 = (&DAT_005e081f)[bVar16];
    bVar19 = (&DAT_005e081f)[bVar19];
    bVar5 = (&DAT_005e081f)[bVar5];
    bVar2 = (&DAT_005e081f)[bVar9];
    bVar9 = (&DAT_005e081f)[bVar13];
    bVar13 = (&DAT_005e081f)[bVar18];
    bVar18 = (&DAT_005e081f)[bVar6];
    bVar6 = (&DAT_005e081f)[bVar10];
    bVar15 = (&DAT_005e081f)[bVar15];
    bVar10 = (&DAT_005e081f)[bVar3];
    bVar3 = (&DAT_005e081f)[bVar7];
    bVar7 = (&DAT_005e081f)[bVar11];
    bVar17 = (&DAT_005e081f)[bVar17];
    bVar4 = (&DAT_005e081f)[bVar4];
    bVar11 = (&DAT_005e081f)[bVar8];
    *param_1 = bVar12;
    param_1[4] = bVar16;
    param_1[8] = bVar19;
    param_1[0xc] = bVar5;
    param_1[1] = bVar9;
    param_1[5] = bVar13;
    param_1[9] = bVar18;
    param_1[0xd] = bVar2;
    param_1[2] = bVar10;
    param_1[10] = bVar6;
    param_1[6] = bVar3;
    param_1[0xe] = bVar15;
    param_1[3] = bVar11;
    param_1[0xf] = bVar4;
    param_1[0xb] = bVar17;
    param_1[7] = bVar7;
    if ((uVar20 & 0xff) == 10) break;
    lVar14 = 0;
    while( true ) {
      bVar16 = bVar9 ^ bVar12;
      bVar13 = bVar16 ^ bVar10 ^ bVar11;
      pbVar1 = param_1 + lVar14;
      pbVar1[2] = bVar11 ^ bVar16 ^ (bVar11 ^ bVar10) << 1 ^
                  (byte)((uint)(int)(char)(bVar11 ^ bVar10) >> 7) & 0x1b;
                    /* try { // try from 0053db80 to 0063db87 has its CatchHandler @ 0053dc44 */
      *pbVar1 = bVar12 ^ bVar16 << 1 ^ (byte)((uint)(int)(char)bVar16 >> 7) & 0x1b ^ bVar13;
      pbVar1[1] = bVar9 ^ (bVar10 ^ bVar9) << 1 ^ bVar13 ^
                  (byte)((uint)(int)(char)(bVar10 ^ bVar9) >> 7) & 0x1b;
                    /* try { // try from 0053db88 to 0063dbcb has its CatchHandler @ 0053da7c */
      pbVar1[3] = bVar16 ^ bVar10 ^ (bVar11 ^ bVar12) << 1 ^
                  (byte)((uint)(int)(char)(bVar11 ^ bVar12) >> 7) & 0x1b;
      if (lVar14 == 0xc) break;
      bVar12 = pbVar1[4];
      bVar9 = pbVar1[5];
      bVar10 = pbVar1[6];
      bVar11 = pbVar1[7];
      lVar14 = lVar14 + 4;
    }
    FUN_0053e4ac(uVar20,param_1,param_2);
    bVar12 = *param_1;
    bVar16 = param_1[4];
    bVar19 = param_1[8];
    bVar5 = param_1[0xc];
    bVar9 = param_1[1];
    bVar13 = param_1[5];
    bVar18 = param_1[9];
    bVar6 = param_1[0xd];
    bVar10 = param_1[2];
    bVar15 = param_1[6];
    bVar3 = param_1[10];
    bVar7 = param_1[0xe];
    bVar11 = param_1[3];
    bVar17 = param_1[7];
    bVar4 = param_1[0xb];
    bVar8 = param_1[0xf];
    uVar20 = uVar20 + 1;
  }
  *param_1 = param_2[0xa0] ^ bVar12;
  param_1[1] = param_2[0xa1] ^ bVar9;
  param_1[2] = param_2[0xa2] ^ bVar10;
                    /* try { // try from 0053dbcc to 0063dbdb has its CatchHandler @ 0053dc44 */
  param_1[3] = param_2[0xa3] ^ bVar11;
                    /* try { // try from 0053dbdc to 0063dc93 has its CatchHandler @ 0053da7c */
  param_1[4] = param_2[0xa4] ^ bVar16;
  param_1[5] = param_2[0xa5] ^ bVar13;
  param_1[6] = param_2[0xa6] ^ bVar3;
  param_1[7] = param_2[0xa7] ^ bVar7;
  param_1[8] = param_2[0xa8] ^ bVar19;
  param_1[9] = param_2[0xa9] ^ bVar18;
  param_1[10] = param_2[0xaa] ^ bVar6;
  param_1[0xb] = param_2[0xab] ^ bVar17;
  param_1[0xc] = param_2[0xac] ^ bVar5;
                    /* catch() { ... } // from try @ 0053db80 with catch @ 0053dc44
                       catch() { ... } // from try @ 0053dbcc with catch @ 0053dc44 */
  param_1[0xd] = param_2[0xad] ^ bVar2;
  param_1[0xe] = param_2[0xae] ^ bVar15;
  param_1[0xf] = param_2[0xaf] ^ bVar4;
  return;
}


