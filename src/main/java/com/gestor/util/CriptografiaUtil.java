package com.gestor.util;

import com.gestor.usuario.dto.UsuarioDTO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaUtil {


    public static String criptografarSenhaUsuario(String chave) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = null;
        algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(chave.getBytes("UTF-8"));
        char[] hexadecimal = hexCodes(messageDigest);
        return hexadecimal.toString();
    }


    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                    hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;


    }
}
