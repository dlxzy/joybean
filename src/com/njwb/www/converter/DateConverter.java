package com.njwb.www.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String,Date> {
	/**
	 * 通过该方法将string转换成Date
	 */
	public Date convert(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
//			e.printStackTrace();
			return null;
		}
	}

}
