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

import java.io.Serializable;

import br.com.caelum.vraptor.resource.HttpMethod;

/**
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 05/08/2011
 * 
 */
public interface ResourceMethodRequest extends Serializable {
	HttpMethod getHttpMethod();

	String getMethodName();

	Object[] getParameters();

	String getResourceName();

	void setHttpMethod(final HttpMethod httpMethod);

	void setMethodName(String methodName);

	void setParameters(final Object[] parameters);

	void setResourceName(String resourceName);
}