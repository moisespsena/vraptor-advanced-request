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

import br.com.caelum.vraptor.resource.HttpMethod;

/**
 * @author Moises P. Sena (http://moisespsena.com)
 * @since 1.0 21/09/2011
 */
public class ResourceMethodRequestImpl implements ResourceMethodRequest {
	private static final long serialVersionUID = 8902789464120437840L;

	private HttpMethod httpMethod;
	private String methodName;
	private Object[] parameters;
	private String resourceName;

	public ResourceMethodRequestImpl() {

	}

	public ResourceMethodRequestImpl(final HttpMethod httpMethod,
			final String resourceName, final String methodName,
			final Object[] parameters) {
		super();
		this.resourceName = resourceName;
		this.parameters = parameters;
		this.httpMethod = httpMethod;
		this.methodName = methodName;
	}

	@Override
	public HttpMethod getHttpMethod() {
		return httpMethod;
	}

	@Override
	public String getMethodName() {
		return methodName;
	}

	@Override
	public Object[] getParameters() {
		return parameters;
	}

	@Override
	public String getResourceName() {
		return resourceName;
	}

	@Override
	public void setHttpMethod(final HttpMethod httpMethod) {
		this.httpMethod = httpMethod;
	}

	@Override
	public void setMethodName(final String methodName) {
		this.methodName = methodName;
	}

	@Override
	public void setParameters(final Object[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public void setResourceName(final String resourceName) {
		this.resourceName = resourceName;
	}
}
