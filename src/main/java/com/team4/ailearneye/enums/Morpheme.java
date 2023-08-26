package com.team4.ailearneye.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Morpheme {
    NNG(24,"일반 명사"),
    NNP(25,"고유 명사"),
    NNB(23,"의존 명사"),
    NF(22,"명사 추정 범주"),
    NV(28,"용언 추정 범주"),
    VV(41,"동사"),
    VA(38,"형용사"),
    MMA(18,"성상 관형사"),
    MMD(19,"지시 관형사"),
    MMN(20,"수 관형사"),
    MAG(16,"일반 부사"),
    MAJ(17,"접속 부사"),
    XPN(43,"체언 접두사"),
    XSN(46,"명사 파생 접미사"),
    XSV(47,"동사 파생 접미사"),
    XSA(45,"형용사 파생 접미사"),
    XR(44,"어근");

    private int code;
    private String text;

}
