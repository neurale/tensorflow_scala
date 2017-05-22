/* Copyright 2017, Emmanouil Antonios Platanios. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.platanios.tensorflow.api

/**
  * @author Emmanouil Antonios Platanios
  */
package object core {
  object exception {
    case class ShapeMismatchException(message: String = null, cause: Throwable = null)
        extends IllegalArgumentException(message, cause)

    case class GraphMismatchException(message: String = null, cause: Throwable = null)
        extends IllegalStateException(message, cause)

    case class IllegalNameException(message: String = null, cause: Throwable = null)
        extends IllegalArgumentException(message, cause)

    case class InvalidDeviceSpecificationException(message: String = null, cause: Throwable = null)
        extends IllegalArgumentException(message, cause)

    case class InvalidGraphElementException(message: String = null, cause: Throwable = null)
        extends IllegalArgumentException(message, cause)

    case class InvalidShapeException(message: String = null, cause: Throwable = null)
        extends IllegalArgumentException(message, cause)

    case class InvalidIndexerException(message: String = null, cause: Throwable = null)
        extends IllegalArgumentException(message, cause)

    case class InvalidDataTypeException(message: String = null, cause: Throwable = null)
        extends IllegalArgumentException(message, cause)

    case class OpBuilderUsedException(message: String = null, cause: Throwable = null)
        extends IllegalStateException(message, cause)
  }
}