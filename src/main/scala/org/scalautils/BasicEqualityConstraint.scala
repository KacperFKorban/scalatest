/*
 * Copyright 2001-2013 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scalautils

import annotation.implicitNotFound

/**
 * An implementation of <code>EqualityConstraint</code> for two types <code>A</code> and <code>B</code> that requires an <code>Equality[A]</code> to
 * which its <code>areEqual</code> method can delegate an equality comparison.
 *
 * @param equalityofA an <code>Equality</code> type class for <code>A</code>
 */
final class BasicEqualityConstraint[A, B](equalityOfA: Equality[A]) extends TripleEqualsConstraint[A, B] {

  /**
   * Indicates whether the objects passed as <code>a</code> and <code>b</code> are equal by returning the
   * result of invoking <code>areEqual(a, b)</code> on the passed <code>equalityOfA</code> object.
   *
   * @param a a left-hand-side object being compared with another (right-hand-side one) for equality (<em>e.g.</em>, <code>a == b</code>)
   * @param b a right-hand-side object being compared with another (left-hand-side one) for equality (<em>e.g.</em>, <code>a == b</code>)
   */
  def areEqual(a: A, b: B): Boolean = equalityOfA.areEqual(a, b)
}

