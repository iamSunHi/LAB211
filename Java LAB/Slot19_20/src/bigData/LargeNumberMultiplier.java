/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigData;

import java.math.BigInteger;

/**
 *
 * @author Nhật Huy
 */
public class LargeNumberMultiplier {

    private BigInteger num1;
    private BigInteger num2;

    public LargeNumberMultiplier(String num1, String num2) {
        this.num1 = new BigInteger(num1);
        this.num2 = new BigInteger(num2);
    }

    public BigInteger multiply() {
        return num1.multiply(num2);
    }
}
