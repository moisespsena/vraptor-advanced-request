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

import java.net.HttpURLConnection;

import com.moisespsena.vraptor.modularvalidator.CategorizedMessages;

/**
 * @author Moises P. Sena (http://moisespsena.com)
 * @since 1.0 21/09/2011
 */
public class RequestResultImpl implements RequestResult {
	private static final long serialVersionUID = 2154020766448319903L;

	public static RequestResult forward(
			final ResourceMethodRequest resourceMethodRequest,
			final CategorizedMessages flashMessages) {
		final RequestResult requestResult = new RequestResultImpl(
				resourceMethodRequest, null, null, -1, flashMessages);
		return requestResult;
	}

	public static RequestResult notFound() {
		final RequestResult requestResult = new RequestResultImpl(null, null,
				null, HttpURLConnection.HTTP_NOT_FOUND, null);
		return requestResult;
	}

	public static RequestResult permanentlyRedirect(
			final ResourceMethodRequest resourceMethodRequest,
			final CategorizedMessages flashMessages) {
		final RequestResult requestResult = new RequestResultImpl(
				resourceMethodRequest, null, null,
				HttpURLConnection.HTTP_MOVED_PERM, flashMessages);
		return requestResult;
	}

	public static RequestResult preConditionFailed(
			final CategorizedMessages flashMessages) {
		final RequestResult requestResult = new RequestResultImpl(null, null,
				null, HttpURLConnection.HTTP_PRECON_FAILED, flashMessages);
		return requestResult;
	}

	public static RequestResult redirect(
			final ResourceMethodRequest resourceMethodRequest,
			final CategorizedMessages flashMessages) {
		final RequestResult requestResult = new RequestResultImpl(
				resourceMethodRequest, null, null,
				HttpURLConnection.HTTP_MOVED_TEMP, flashMessages);
		return requestResult;
	}

	public static RequestResult result(
			final ResourceMethodResult resourceMethodResult,
			final CategorizedMessages flashMessages) {
		final RequestResult requestResult = new RequestResultImpl(null, null,
				resourceMethodResult, HttpURLConnection.HTTP_OK, flashMessages);
		return requestResult;
	}

	private CategorizedMessages flashMessages;
	private ResourceMethodRequest forward;
	private ResourceMethodRequest redirect;
	private ResourceMethodResult resourceMethodResult;
	private int statusCode;

	public RequestResultImpl() {

	}

	public RequestResultImpl(final ResourceMethodRequest forward,
			final ResourceMethodRequest redirect,
			final ResourceMethodResult resourceMethodResult,
			final int statusCode, final CategorizedMessages flashMessages) {
		super();
		this.forward = forward;
		this.redirect = redirect;
		this.resourceMethodResult = resourceMethodResult;
		this.statusCode = statusCode;
		this.flashMessages = flashMessages;
	}

	@Override
	public CategorizedMessages getFlashMessages() {
		return flashMessages;
	}

	@Override
	public ResourceMethodRequest getForward() {
		return forward;
	}

	@Override
	public ResourceMethodRequest getRedirect() {
		return redirect;
	}

	@Override
	public ResourceMethodResult getResourceMethodResult() {
		return resourceMethodResult;
	}

	@Override
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param flashMessages
	 *            the flashMessages to set
	 */
	public void setFlashMessages(final CategorizedMessages flashMessages) {
		this.flashMessages = flashMessages;
	}

	/**
	 * @param forward
	 *            the forward to set
	 */
	public void setForward(final ResourceMethodRequest forward) {
		this.forward = forward;
	}

	/**
	 * @param redirect
	 *            the redirect to set
	 */
	public void setRedirect(final ResourceMethodRequest redirect) {
		this.redirect = redirect;
	}

	/**
	 * @param resourceMethodResult
	 *            the resourceMethodResult to set
	 */
	public void setResourceMethodResult(
			final ResourceMethodResult resourceMethodResult) {
		this.resourceMethodResult = resourceMethodResult;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(final int statusCode) {
		this.statusCode = statusCode;
	}
}
