package com.unchesquito.utilidades;

import java.util.Base64;

import javax.crypto.Cipher;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

@Component
public class Encryption {



	// Algoritmo (AES, DES, RSA)
	private final String algorithm = "AES";
	// Tipo de cifrado, por bloques, padding etc.
	private final String encryptionType = "AES/CBC/PKCS5Padding";

	public String encryptionAES(String llave, String iv, String text) throws Exception {
        Cipher cipher = Cipher.getInstance(encryptionType);
        SecretKeySpec secretKeySpec = new SecretKeySpec(llave.getBytes(), algorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(text.getBytes());
        return new String(Base64.getEncoder().encode(encrypted));
}

	public String decryptAES(String encrypted, String key, String iv) throws Exception{

		Cipher cipher = null;

			cipher = Cipher.getInstance(encryptionType);
			SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
			byte[] enc = Base64.getDecoder().decode(encrypted);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

			byte[] decrypted = null;
			decrypted = cipher.doFinal(enc);
			return new String(decrypted);
		
	}

}
