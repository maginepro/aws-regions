package com.magine.aws

import _root_.ciris.ConfigDecoder

package object ciris {
  implicit val regionConfigDecoder: ConfigDecoder[String, Region] =
    ConfigDecoder[String].mapOption("Region")(Region.valid(_).toOption)
}
