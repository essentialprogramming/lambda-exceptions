package com.digitalworkspace.lambdaexceptions;

import com.digitalworkspace.lambdaexceptions.exceptions.ServiceException;
import com.digitalworkspace.lambdaexceptions.fortesting.SneakyFunction;
import com.digitalworkspace.lambdaexceptions.fortesting.SampleService;

import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.digitalworkspace.lambdaexceptions.fortesting.SampleException.createURL;
import static com.digitalworkspace.lambdaexceptions.helpers.ThrowingHelper.extractedMethod;
import static com.digitalworkspace.lambdaexceptions.helpers.ThrowingHelper.rethrowFunction;
import static com.digitalworkspace.lambdaexceptions.helpers.ThrowingHelper.wrapper;
import static com.rainerhahnekamp.sneakythrow.Sneaky.sneaked;

public class ChallengeAndSolutions {

	// Problem: doesn't compile
	public static void test0() {
		//Stream.of("https://www.a.com", "https://www.b.info").forEach(e -> createURL(e));
	}

	// Solution 1: Add a try/catch block to the lambda expression
	public static void test1() {
		Stream.of("https://www.a.com", "https://www.b.info", "asdasd").forEach(e -> {
			try {
				createURL(e);
			} catch (MalformedURLException e1) {
				throw new ServiceException("haha");
			}
		});
	}

	// Solution 2: Create an extracted method
	public static void test2() {
		Stream.of("https://www.a.com", "https://www.b.info", "asdasd")
				.forEach(e -> extractedMethod(e));
	}

	// Solution 3: Write a wrapper method that catches checked exceptions and rethrows them as unchecked
	public static void test3() {
		// Cast Function to SneakyFunction
		Stream.of("https://www.a.com", "https://www.b.info", "asdasd")
				.map((SneakyFunction<String, URL>) number -> createURL(number))
				.collect(Collectors.toList());
	}

	// Solution 4: Write a wrapper method that catches checked exceptions and rethrows them as unchecked
	public static void test4() {
		// Wrap (alternative) sneaky function which cannot handle alone the exception so the wrapper method handles it
		Stream.of("https://www.a.com", "https://www.b.info", "asdasd")
				.map(wrapper(number -> createURL(number)))
				.collect(Collectors.toList());
	}

	// Solution 5: Write a wrapper method that catches checked exceptions and rethrows them as unchecked
	public static void test5() {
		// Rethrow sneaky function as a function
		Stream.of("https://www.a.com", "https://www.b.info", "asdasd")
				.map(rethrowFunction(number -> createURL(number)))
				.collect(Collectors.toList());
	}

	// Solution 6: using sneakythrow library
	public static void test6() {
		Stream.of("https://www.a.com", "https://www.b.info", "asdasd")
				.map(sneaked((String url) -> createURL(url)))
				.collect(Collectors.toList());
	}

	// Solution 7: JAX-RS REST example
	public static Response test7() {
		return Optional.of(SampleService.getURLById("12"))
				.map(user -> Response.ok(user.toString()).build() )
				.orElseGet(() ->  Response.status(404).build());
	}
}
