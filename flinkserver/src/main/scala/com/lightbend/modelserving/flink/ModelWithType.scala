/*
 * Copyright (C) 2019  Lightbend
 *
 * This file is part of ModelServing-tutorial
 *
 * ModelServing-tutorial is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.lightbend.modelserving.flink

import com.lightbend.modelserving.model.Model

// Used for Flink checkpointing
class ModelWithType(current : Boolean, dType: String, model: (String,Model)) {

  val isCurrent = current
  val dataType = dType
  val modelWithName = model

  override def equals(obj: Any): Boolean = {
    obj match {
      case modelWithType: ModelWithType =>
          modelWithType.isCurrent == isCurrent &&
          modelWithType.dataType == dataType &&
          modelWithType.modelWithName._1 == modelWithName._1 &&
          modelWithType.modelWithName._2 == modelWithName._2
      case _ => false
    }
  }
}
