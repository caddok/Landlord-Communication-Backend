package com.evtimov.landlordapp.backend.utils.password;

import com.evtimov.landlordapp.backend.utils.Constants;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class PasswordAgent {

    public String generatePasswordHash(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = Constants.NUMBER_OF_HASH_ITERATIONS;
        char[] chars = password.toCharArray();
        byte[] salT = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(chars, salT, iterations, Constants.SIXTY_FOUR * Constants.EIGHT);
        SecretKeyFactory skf = SecretKeyFactory.getInstance(Constants.SECRET_KEY_FACTORY_INSTANCE);
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return toHex(salT) + Constants.COLON + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance(Constants.SECURE_RANDOM_INSTANCE);
        byte[] salt = new byte[Constants.SIXTEEN];
        sr.nextBytes(salt);
        return salt;
    }

    private String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(Constants.SIXTEEN);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }
}
