/**
 * Copyright © YOLANDA. All Rights Reserved
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
package com.yolanda.nohttp.cache;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import org.json.JSONException;

import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.HttpHeaders;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.db.DBId;

/**
 * Created in Jan 10, 2016 12:43:10 AM
 * 
 * @author YOLANDA
 */
class CacheEntity implements DBId, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1234857234793L;

	private long id;

	private String key;
	/**
	 * Immutable response headers as received from server; must be non-null.
	 */
	private Headers responseHeaders = new HttpHeaders();

	/**
	 * The data returned from cache.
	 */
	private byte[] data = {};

	/**
	 * ETag for cache coherency.
	 */
	private String etag = "";

	/**
	 * Date of this response as reported by the server.
	 */
	private long serverDate = 0;

	/**
	 * The last modified date for the requested object.
	 */
	private long lastModified = 0;

	public CacheEntity() {
		super();
	}

	public CacheEntity(long id, String key, Headers responseHeaders, byte[] data, String etag, long serverDate, long lastModified) {
		super();
		this.id = id;
		this.key = key;
		this.responseHeaders = responseHeaders;
		this.data = data;
		this.etag = etag;
		this.serverDate = serverDate;
		this.lastModified = lastModified;
	}

	/**
	 * @return the id
	 */
	@Override
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the responseHeaders
	 */
	public Headers getResponseHeaders() {
		return responseHeaders;
	}

	/**
	 * @param responseHeaders the responseHeaders to set
	 */
	public void setResponseHeaders(Headers responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

	public void setResponseHeadersJson(String jsonString) {
		try {
			this.responseHeaders.setJSONString(jsonString);
		} catch (JSONException e) {
			Logger.e(e);
		}
	}

	public String getResponseHeadersJson() {
		return this.responseHeaders.toJSONString();
	}

	/**
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}

	public void setDataString(String dataString) {
		try {
			data = dataString.getBytes(NoHttp.CHARSET_UTF8);
		} catch (UnsupportedEncodingException e) {
			data = new byte[] {};
		}
	}

	public String getDataString() {
		try {
			return new String(data, NoHttp.CHARSET_UTF8);
		} catch (UnsupportedEncodingException e) {
			return new String(data);
		}
	}

	/**
	 * @return the etag
	 */
	public String getEtag() {
		return etag;
	}

	/**
	 * @param etag the etag to set
	 */
	public void setEtag(String etag) {
		this.etag = etag;
	}

	/**
	 * @return the serverDate
	 */
	public long getServerDate() {
		return serverDate;
	}

	/**
	 * @param serverDate the serverDate to set
	 */
	public void setServerDate(long serverDate) {
		this.serverDate = serverDate;
	}

	/**
	 * @return the lastModified
	 */
	public long getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(long lastModified) {
		this.lastModified = lastModified;
	}

}