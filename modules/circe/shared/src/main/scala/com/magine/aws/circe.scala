package com.magine.aws

import cats.syntax.all._
import io.circe.Decoder
import io.circe.Encoder

package object circe {
  implicit val regionDecoder: Decoder[Region] =
    Decoder[String].emap(Region.valid(_).leftMap(_.getMessage))

  implicit val regionEncoder: Encoder[Region] =
    Encoder[String].contramap(_.id)
}
