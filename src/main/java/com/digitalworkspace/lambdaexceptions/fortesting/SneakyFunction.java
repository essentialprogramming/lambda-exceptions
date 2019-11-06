package com.digitalworkspace.lambdaexceptions.fortesting;

import com.digitalworkspace.lambdaexceptions.helpers.ThrowingHelper;

import java.util.function.Function;

@FunctionalInterface
public interface SneakyFunction<T, R> extends Function<T, R> {

	@Override
	default R apply(final T e) {
		try {
			return apply0(e);
		} catch (Throwable ex) {
			ThrowingHelper.sneakyThrow(ex);
			return null;
		}
	}

	R apply0(T e) throws Throwable;
}