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

/**
 * @author Moises P. Sena (http://moisespsena.com)
 * @since 1.0 20/09/2011
 */
public class RequestMethodInfo {
	private final Method method;
	private final Object[] parameters;
	private final Class<?> resourceClass;
	private final boolean viewRender;

	/**
	 * @param resourceClass
	 * @param method
	 * @param parameters
	 * @param viewRender
	 */
	public RequestMethodInfo(final Class<?> resourceClass, final Method method,
			final Object[] parameters, final boolean viewRender) {
		super();
		this.resourceClass = resourceClass;
		this.method = method;
		this.parameters = parameters;
		this.viewRender = viewRender;
	}

	/**
	 * @return the method
	 */
	public Method getMethod() {
		return method;
	}

	/**
	 * @return the parameters
	 */
	public Object[] getParameters() {
		return parameters;
	}

	/**
	 * @return the resourceClass
	 */
	public Class<?> getResourceClass() {
		return resourceClass;
	}

	/**
	 * @return the viewRender
	 */
	public boolean isViewRender() {
		return viewRender;
	}
}
