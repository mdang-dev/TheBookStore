/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.math.BigInteger;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class UUID_Test {
    public static void main(String[] args) {
//        UUID uuid = UUID.randomUUID();
        String uuid = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
        String uuid16digits = uuid.substring(uuid.length() - 16);
        System.out.println(uuid);
        System.out.println(uuid16digits);
    }
}
