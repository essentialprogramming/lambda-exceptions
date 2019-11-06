package com.digitalworkspace.lambdaexceptions.helpers;

import com.digitalworkspace.lambdaexceptions.exceptions.ServiceException;
import com.digitalworkspace.lambdaexceptions.fortesting.SneakyFunction;
import com.digitalworkspace.lambdaexceptions.fortesting.SneakyFunctionAlternative;
import com.digitalworkspace.lambdaexceptions.fortesting.SampleException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

public final class ThrowingHelper {

	private ThrowingHelper() {}

	// rethrow Sneaky function into Function
	public static <T, R> Function<T, R> rethrowFunction(final SneakyFunction<T, R> consumer) {
		return consumer;
	}

	public static <E extends Throwable> void sneakyThrow(Throwable ex) throws E {
		throw (E) ex;
	}

	// alternative sneaky function wrapper
	public static <T, R, E extends Exception> Function<T, R> wrapper(SneakyFunctionAlternative<T, R, E> fe) {
		return arg -> {
			try {
				return fe.apply(arg);
			} catch (Exception e) {
				throw new ServiceException(e);
			}
		};
	}

	// try-catch extracted into a method
	public static URL extractedMethod(String url) {
		try {
			return SampleException.createURL(url);
		} catch (MalformedURLException e1) {
			throw new ServiceException("haha");
		}
	}

}