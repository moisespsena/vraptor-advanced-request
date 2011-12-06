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

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 05/08/2011
 * 
 */
@Component
@RequestScoped
public class AdvancedRequestInfo {
	public static final String CT_JAVA_OBJECT = "application/x-java-serialized-object";
	private String charset;
	private final AdvancedFormatResolver formatResolver;
	private final HttpServletRequest request;

	public AdvancedRequestInfo(final AdvancedFormatResolver formatResolver,
			final HttpServletRequest request) {
		this.formatResolver = formatResolver;
		this.request = request;
	}

	public String getCharset() {
		if (charset == null) {
			String accept = request.getHeader("Accept-Charset");
			if (accept == null) {
				accept = request.getParameter("_acceptCharset");
			}

			if (accept != null) {
				final String[] accepts = accept.split("\\s*,\\s*");

				if (accepts.length > 1) {
					if (accept.contains("utf-8") || accept.contains("UTF-8")) {
						charset = "UTF-8";
					}
				} else if (accepts.length == 1) {
					charset = accepts[0].trim();
				}
			}

			if (StringUtils.isBlank(charset)) {
				charset = request.getCharacterEncoding();

				if (charset == null) {
					charset = "UTF-8";
				}
			}
		}
		return charset;
	}

	public boolean isJavaObjectContentType() {
		final String type = formatResolver.getContentTypeFormat();
		if (type == null) {
			return false;
		} else {
			final boolean is = type.contains(CT_JAVA_OBJECT);
			return is;
		}
	}

	public boolean isJavaObjectResult() {
		return CT_JAVA_OBJECT.equals(formatResolver.getAcceptFormat());
	}

	public boolean isJSONResult() {
		return "json".equals(formatResolver.getAcceptFormat());
	}

	public boolean isSerializeResult() {
		if (isXMLResult()) {
			return true;
		} else if (isJSONResult()) {
			return true;
		} else if (isJavaObjectResult()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isXMLResult() {
		return "xml".equals(formatResolver.getAcceptFormat());
	}
}
