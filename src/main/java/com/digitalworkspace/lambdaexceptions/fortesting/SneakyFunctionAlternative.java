package com.digitalworkspace.lambdaexceptions.fortesting;


@FunctionalInterface
public interface SneakyFunctionAlternative<T, R, E extends Exception> {

	R apply(T t) throws E;

}