/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20171027;

import java.math.BigInteger;
import javafx.beans.binding.Bindings;

/**
 *
 * @author merarli
 */
public class HanoiJikan {
    public static void main(String[] args) {
        int n1 = 64; //ハノイの輪数を決める
        BigInteger n2 = new BigInteger("2");//計算に必要なので変えないでよい
        BigInteger n3 = new BigInteger("1");//計算に必要なので変えないでよい
        BigInteger n4 = new BigInteger("31536000");//一年間を秒数に直したもの
        BigInteger n5 = new BigInteger("10");//１ステップにかかる時間を秒で設定
     
        System.out.println("ハノイの塔が完了するまで");
        System.out.println("n="+ n1 + "のステップ数は " + (n2.pow(n1)).subtract(n3));
        System.out.println("n="+ n1 + "が終了する時間は " + (((n2.pow(n1)).subtract(n3)).multiply(n5)).divide(n4) + "年かかります");
        System.out.println("ただし１ステップ10秒とする");
    }
    
}
