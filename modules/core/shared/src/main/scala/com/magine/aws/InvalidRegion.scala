package com.magine.aws

import scala.util.control.NoStackTrace

final case class InvalidRegion(region: String) extends RuntimeException with NoStackTrace {
  override def getMessage: String =
    s"Invalid region: $region"
}
