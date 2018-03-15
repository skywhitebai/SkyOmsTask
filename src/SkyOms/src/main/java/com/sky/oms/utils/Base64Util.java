package com.sky.oms.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class Base64Util {

	static Logger logger = LoggerFactory.getLogger(Base64Util.class);
	static Base64.Decoder decoder = Base64.getDecoder();
	static Base64.Encoder encoder = Base64.getEncoder();

	// 编码
	public static String base64Encode(String text) {
		if (StringUtils.isEmpty(text)) {
			return text;
		}
		byte[] textByte;
		try {
			textByte = text.getBytes("UTF-8");
			String encodedText = encoder.encodeToString(textByte);
			return encodedText;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("base64Encode erro:{}", JSONObject.fromObject(e));
			return null;
		}
	}

	// 解码
	public static String base64Decode(String text) {
		if (StringUtils.isEmpty(text)) {
			return text;
		}
		try {
			String decodedText = new String(decoder.decode(text), "UTF-8");
			return decodedText;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("base64Decode erro:{}", JSONObject.fromObject(e));
			return null;
		}
	}
}
