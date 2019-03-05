package com.jeff.test;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Test {

	public static void main(String[] args) {
		/*int hashIterations = 3;// 加密的次数
		Object salt = "jeff";// 盐值
		Object credentials = "123456";// 密码
		String hashAlgorithmName = "MD5";// 加密方式
		Object simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println("加密后的值----->" + simpleHash);*/
		
		//生成盐（部分，需要存入数据库中）
		String random=new SecureRandomNumberGenerator().nextBytes().toHex();
		//将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
		String result = new Md5Hash("123456","jeff",3).toString();
		System.out.println(result);

	}
}
