/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report02;

/**
 *
 * @author merarli
 */
public class Even {

    public static void main(String[] args) {
        int num[] = {2, 3, 4, 8, 4, 2, 6, 9, 12, 20};
        String numtext = "";
        
        for (int i = 0; i < num.length; i++) {
            numtext += String.valueOf(num[i]);
        }
        System.out.println(numtext);
    }
}

