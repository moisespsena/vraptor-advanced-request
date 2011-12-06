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

import br.com.caelum.vraptor.http.DefaultFormatResolver;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.view.AcceptHeaderToFormat;

import com.moisespsena.vraptor.flashparameters.FlashParameters;
import com.moisespsena.vraptor.flashparameters.LoadListener;

/**
 * 
 * @author Moises P. Sena &lt;moisespsena@gmail.com&gt;
 * @since 1.0 05/08/2011
 * 
 */
@Component
@RequestScoped
public class AdvancedFormatResolver extends DefaultFormatResolver {
	private static final String FLASH_PARAMETER = AdvancedFormatResolver.class
			.getName();
	private String acceptFormat;
	private final HttpServletRequest request;

	/**
	 * @param request
	 * @param acceptHeaderToFormat
	 */
	public AdvancedFormatResolver(final HttpServletRequest request,
			final AcceptHeaderToFormat acceptHeaderToFormat,
			final FlashParameters flashParameters) {
		super(request, acceptHeaderToFormat);
		this.request = request;

		if (flashParameters.isAfterLoadCalled()) {
			loadFormat(flashParameters);
		} else {
			flashParameters.addLoadListener(new LoadListener() {
				@Override
				public void afterLoad(final FlashParameters flashParameters) {
					loadFormat(flashParameters);
				}

				@Override
				public void beforeSave(final FlashParameters flashParameters) {
					flashParameters.setParameter(FLASH_PARAMETER,
							getAcceptFormat());
				}
			});
		}
	}

	@Override
	public String getAcceptFormat() {
		String format = super.getAcceptFormat();
		if (format == null) {
			format = acceptFormat;
		}
		return format;
	}

	public String getContentTypeFormat() {
		return request.getContentType();
	}

	private void loadFormat(final FlashParameters flashParameters) {
		acceptFormat = (String) flashParameters.getParameter(FLASH_PARAMETER);
	}
}
