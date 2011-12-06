/***
 * Copyright (c) 2011 Moises P. Sena - www.moisespsena.com
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package com.moisespsena.vraptor.advancedrequest;

import java.lang.reflect.Method;
import java.util.List;

import net.vidageek.mirror.dsl.Matcher;
import net.vidageek.mirror.dsl.Mirror;

/**
 * @author Moises P. Sena (http://moisespsena.com)
 * @since 1.0 23/09/2011
 */
public class SimpleResourcesResolver implements ResourcesResolver {

	@Override
	public Class<?> resourceClassFromName(final String resourceName)
			throws ResourceNotFoundException {
		try {
			return Class.forName(resourceName);
		} catch (final ClassNotFoundException e) {
			throw new ResourceClassNotFoundException(resourceName);
		}
	}

	@Override
	public String resourceNameFromClass(final Class<?> resourceClass) {
		return resourceClass.getName();
	}

	@Override
	public Class<?>[] typesFromMethodName(final Class<?> resourceClass,
			final String methodName) throws ResourceNotFoundException {

		final List<Method> methods = new Mirror().on(resourceClass)
				.reflectAll().methodsMatching(new Matcher<Method>() {
					@Override
					public boolean accepts(final Method method) {
						return method.getName().equals(methodName);
					}
				});

		if (methods.size() == 0) {
			throw new ResourceMethodNotFoundException(methodName, resourceClass);
		} else if (methods.size() > 1) {
			throw new MultiplesResourceMethodsFoundException(methodName,
					resourceClass);
		} else {
			final Method method = methods.get(0);
			final Class<?>[] types = method.getParameterTypes();
			return types;
		}
	}

}
