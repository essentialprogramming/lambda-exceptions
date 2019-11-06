package com.digitalworkspace.lambdaexceptions.fortesting;

import java.net.URL;
import java.util.Optional;

import static com.digitalworkspace.lambdaexceptions.helpers.ThrowingHelper.rethrowFunction;

public class SampleService {

	public static Optional<URL> getURLById(String id) {
		return Optional.of(id)
				.map(rethrowFunction(SampleException::createURL));
	}
}
