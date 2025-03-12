/*
 * Copyright 2025 Magine Pro
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

package com.magine.aws

import cats.syntax.all.*
import io.circe.Decoder
import io.circe.Encoder

package object circe {
  implicit val regionDecoder: Decoder[Region] =
    Decoder[String].emap(Region.valid(_).leftMap(_.getMessage))

  implicit val regionEncoder: Encoder[Region] =
    Encoder[String].contramap(_.id)
}
