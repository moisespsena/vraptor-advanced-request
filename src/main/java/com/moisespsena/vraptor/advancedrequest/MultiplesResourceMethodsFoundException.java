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

/**
 * @author Moises P. Sena (http://moisespsena.com)
 * @since 1.0 23/09/2011
 */
public class MultiplesResourceMethodsFoundException extends
		ResourceNotFoundException {
	private static final long serialVersionUID = 6006979164619979259L;
	private final String methodName;

	/**
	 * 
	 */
	public MultiplesResourceMethodsFoundException(final String methodName,
			final Class<?> resourceClass) {
		super("Multiples methods exists with '" + methodName + "' in '"
				+ resourceClass.getName() + "' resource class");
		this.methodName = methodName;
	}

	/**
	 * @return the resourceName
	 */
	public String getMethodName() {
		return methodName;
	}
}
