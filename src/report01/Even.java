/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report01;

/**
 *
 * @author merarli
 */
public class Even {

    public static void main(String[] args) {
        int num[] = {2, 3, 4, 8, 4, 2, 6, 9, 12, 20};
        
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= 8 && num[i] % 2 == 0) {
                System.out.println(num[i]);
            }
        }
    }
    
}
