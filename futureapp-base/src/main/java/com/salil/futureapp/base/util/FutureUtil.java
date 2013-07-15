package com.salil.futureapp.base.util;

import java.util.List;

public class FutureUtil {

	public static boolean isEmptyOrBlank(final String str) {
		return str == null || str.trim().isEmpty();
	}

	@SuppressWarnings("rawtypes")
	public static boolean isListEmptyOrBlank(final List list) {
		return list == null || list.isEmpty();
	}

}
