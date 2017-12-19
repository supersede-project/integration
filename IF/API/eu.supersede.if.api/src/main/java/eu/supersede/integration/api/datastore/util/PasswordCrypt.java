/*******************************************************************************
 * Copyright (c) 2017 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 * 
 * Code adapted from:
 * http://narayanatutorial.com/java-tutorial/how-to-encrypt-and-decrypt-password-in-java
 * 
 *******************************************************************************/
package eu.supersede.integration.api.datastore.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class PasswordCrypt {
	public static final String AES = "AES";

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	private static byte[] hexStringToByteArray(String s) {
		byte[] b = new byte[s.length() / 2];
		for (int i = 0; i < b.length; i++) {
			int index = i * 2;
			int v = Integer.parseInt(s.substring(index, index + 2), 16);
			b[i] = (byte) v;
		}
		return b;
	}
	
	public static String generateKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance(PasswordCrypt.AES);
		keyGen.init(128);
		SecretKey sk = keyGen.generateKey();
		String key = byteArrayToHexString(sk.getEncoded());
		return key;
	}

	public static String encryptPassword(String password, String key)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		byte[] bytekey = hexStringToByteArray(key);
		SecretKeySpec sks = new SecretKeySpec(bytekey, PasswordCrypt.AES);
		Cipher cipher = Cipher.getInstance(PasswordCrypt.AES);
		cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
		byte[] encrypted = cipher.doFinal(password.getBytes());
		String encryptedpwd = byteArrayToHexString(encrypted);
		return encryptedpwd;
	}

	public static String decryptPassword(String encryptedPassword, String key) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] bytekey = hexStringToByteArray(key);
		SecretKeySpec sks = new SecretKeySpec(bytekey, PasswordCrypt.AES);
		Cipher cipher = Cipher.getInstance(PasswordCrypt.AES);
		cipher.init(Cipher.DECRYPT_MODE, sks);
		byte[] decrypted = cipher.doFinal(hexStringToByteArray(encryptedPassword));
		String OriginalPassword = new String(decrypted);
		return OriginalPassword;
	}

//	public static void main(String args[]) throws Exception {
//		String key = generateKey();
//		System.out.println("key:" + key);
//		String password = "password";
//		String encryptedPassword = testEncriptPassword(password, key);
//		String plainPassword = testDecryptPassword(encryptedPassword, key);
//	}

	private static String testEncriptPassword(String password, String key) throws Exception {
		System.out.println("****************  Plain Password  ****************");
		System.out.println(password);
		System.out.println("****************  Plain Password  ****************");

		String encryptedpwd = encryptPassword(password, key);

		System.out.println("****************  Encrypted Password  ****************");
		System.out.println(encryptedpwd);
		System.out.println("****************  Encrypted Password  ****************");
		return encryptedpwd;
	}

	public static String testDecryptPassword(String encryptedPassword, String key) throws Exception {
        String originalPassword = decryptPassword(encryptedPassword, key);
        System.out.println("****************  Original Password  ****************");
        System.out.println(originalPassword);
        System.out.println("****************  Original Password  ****************");
        return originalPassword;
    }

}
