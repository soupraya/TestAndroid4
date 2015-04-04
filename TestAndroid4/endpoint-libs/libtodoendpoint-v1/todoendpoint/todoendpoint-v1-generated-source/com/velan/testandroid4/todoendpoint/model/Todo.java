/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-03-26 20:30:19 UTC)
 * on 2015-04-01 at 16:04:11 UTC 
 * Modify at your own risk.
 */

package com.velan.testandroid4.todoendpoint.model;

/**
 * Model definition for Todo.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the todoendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Todo extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double a;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String author;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double b;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double c;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean finished;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String longDescription;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String shortDescription;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String url;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getA() {
    return a;
  }

  /**
   * @param a a or {@code null} for none
   */
  public Todo setA(java.lang.Double a) {
    this.a = a;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAuthor() {
    return author;
  }

  /**
   * @param author author or {@code null} for none
   */
  public Todo setAuthor(java.lang.String author) {
    this.author = author;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getB() {
    return b;
  }

  /**
   * @param b b or {@code null} for none
   */
  public Todo setB(java.lang.Double b) {
    this.b = b;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getC() {
    return c;
  }

  /**
   * @param c c or {@code null} for none
   */
  public Todo setC(java.lang.Double c) {
    this.c = c;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getFinished() {
    return finished;
  }

  /**
   * @param finished finished or {@code null} for none
   */
  public Todo setFinished(java.lang.Boolean finished) {
    this.finished = finished;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Todo setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getLongDescription() {
    return longDescription;
  }

  /**
   * @param longDescription longDescription or {@code null} for none
   */
  public Todo setLongDescription(java.lang.String longDescription) {
    this.longDescription = longDescription;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getShortDescription() {
    return shortDescription;
  }

  /**
   * @param shortDescription shortDescription or {@code null} for none
   */
  public Todo setShortDescription(java.lang.String shortDescription) {
    this.shortDescription = shortDescription;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getUrl() {
    return url;
  }

  /**
   * @param url url or {@code null} for none
   */
  public Todo setUrl(java.lang.String url) {
    this.url = url;
    return this;
  }

  @Override
  public Todo set(String fieldName, Object value) {
    return (Todo) super.set(fieldName, value);
  }

  @Override
  public Todo clone() {
    return (Todo) super.clone();
  }

}
