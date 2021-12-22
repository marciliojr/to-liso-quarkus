package com.gestor.util;

import com.gestor.usuario.dto.UsuarioDTO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaUtil {


    public static String criptografarSenhaUsuario(String chave) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = null;
        algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(chave.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }

}
