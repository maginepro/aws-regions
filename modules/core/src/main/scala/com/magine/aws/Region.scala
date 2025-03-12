package com.magine.aws

final class Region private (val id: String, val isGlobal: Boolean) {
  override final def equals(that: Any): Boolean =
    that match {
      case that: Region => this.id == that.id
      case _ => false
    }

  override final def hashCode: Int =
    id.hashCode

  override final def toString: String =
    id
}

object Region {
  val AP_SOUTH_2: Region = new Region("ap-south-2", isGlobal = false)
  val AP_SOUTH_1: Region = new Region("ap-south-1", isGlobal = false)
  val EU_SOUTH_1: Region = new Region("eu-south-1", isGlobal = false)
  val EU_SOUTH_2: Region = new Region("eu-south-2", isGlobal = false)
  val US_GOV_EAST_1: Region = new Region("us-gov-east-1", isGlobal = false)
  val ME_CENTRAL_1: Region = new Region("me-central-1", isGlobal = false)
  val IL_CENTRAL_1: Region = new Region("il-central-1", isGlobal = false)
  val CA_CENTRAL_1: Region = new Region("ca-central-1", isGlobal = false)
  val EU_CENTRAL_1: Region = new Region("eu-central-1", isGlobal = false)
  val US_ISO_WEST_1: Region = new Region("us-iso-west-1", isGlobal = false)
  val EU_CENTRAL_2: Region = new Region("eu-central-2", isGlobal = false)
  val US_WEST_1: Region = new Region("us-west-1", isGlobal = false)
  val US_WEST_2: Region = new Region("us-west-2", isGlobal = false)
  val AF_SOUTH_1: Region = new Region("af-south-1", isGlobal = false)
  val EU_NORTH_1: Region = new Region("eu-north-1", isGlobal = false)
  val EU_WEST_3: Region = new Region("eu-west-3", isGlobal = false)
  val EU_WEST_2: Region = new Region("eu-west-2", isGlobal = false)
  val EU_WEST_1: Region = new Region("eu-west-1", isGlobal = false)
  val AP_NORTHEAST_3: Region = new Region("ap-northeast-3", isGlobal = false)
  val AP_NORTHEAST_2: Region = new Region("ap-northeast-2", isGlobal = false)
  val AP_NORTHEAST_1: Region = new Region("ap-northeast-1", isGlobal = false)
  val ME_SOUTH_1: Region = new Region("me-south-1", isGlobal = false)
  val SA_EAST_1: Region = new Region("sa-east-1", isGlobal = false)
  val AP_EAST_1: Region = new Region("ap-east-1", isGlobal = false)
  val CN_NORTH_1: Region = new Region("cn-north-1", isGlobal = false)
  val US_GOV_WEST_1: Region = new Region("us-gov-west-1", isGlobal = false)
  val AP_SOUTHEAST_1: Region = new Region("ap-southeast-1", isGlobal = false)
  val AP_SOUTHEAST_2: Region = new Region("ap-southeast-2", isGlobal = false)
  val US_ISO_EAST_1: Region = new Region("us-iso-east-1", isGlobal = false)
  val AP_SOUTHEAST_3: Region = new Region("ap-southeast-3", isGlobal = false)
  val AP_SOUTHEAST_4: Region = new Region("ap-southeast-4", isGlobal = false)
  val US_EAST_1: Region = new Region("us-east-1", isGlobal = false)
  val US_EAST_2: Region = new Region("us-east-2", isGlobal = false)
  val CN_NORTHWEST_1: Region = new Region("cn-northwest-1", isGlobal = false)
  val US_ISOB_EAST_1: Region = new Region("us-isob-east-1", isGlobal = false)
  val AWS_GLOBAL: Region = new Region("aws-global", isGlobal = true)
  val AWS_CN_GLOBAL: Region = new Region("aws-cn-global", isGlobal = true)
  val AWS_US_GOV_GLOBAL: Region = new Region("aws-us-gov-global", isGlobal = true)
  val AWS_ISO_GLOBAL: Region = new Region("aws-iso-global", isGlobal = true)
  val AWS_ISO_B_GLOBAL: Region = new Region("aws-iso-b-global", isGlobal = true)

  val values: Vector[Region] =
    Vector(
      AP_SOUTH_2,
      AP_SOUTH_1,
      EU_SOUTH_1,
      EU_SOUTH_2,
      US_GOV_EAST_1,
      ME_CENTRAL_1,
      IL_CENTRAL_1,
      CA_CENTRAL_1,
      EU_CENTRAL_1,
      US_ISO_WEST_1,
      EU_CENTRAL_2,
      US_WEST_1,
      US_WEST_2,
      AF_SOUTH_1,
      EU_NORTH_1,
      EU_WEST_3,
      EU_WEST_2,
      EU_WEST_1,
      AP_NORTHEAST_3,
      AP_NORTHEAST_2,
      AP_NORTHEAST_1,
      ME_SOUTH_1,
      SA_EAST_1,
      AP_EAST_1,
      CN_NORTH_1,
      US_GOV_WEST_1,
      AP_SOUTHEAST_1,
      AP_SOUTHEAST_2,
      US_ISO_EAST_1,
      AP_SOUTHEAST_3,
      AP_SOUTHEAST_4,
      US_EAST_1,
      US_EAST_2,
      CN_NORTHWEST_1,
      US_ISOB_EAST_1,
      AWS_GLOBAL,
      AWS_CN_GLOBAL,
      AWS_US_GOV_GLOBAL,
      AWS_ISO_GLOBAL,
      AWS_ISO_B_GLOBAL
    )

  private val valuesMap: Map[String, Region] =
    values.map(region => (region.id, region)).toMap

  def apply(region: String): Region =
    apply(region, isGlobal = false)

  def apply(region: String, isGlobal: Boolean): Region =
    valuesMap
      .get(region.toLowerCase)
      .getOrElse(new Region(region, isGlobal))

  def unapply(region: Region): Some[(String, Boolean)] =
    Some((region.id, region.isGlobal))

  def valid(region: String): Either[InvalidRegion, Region] =
    valuesMap.get(region.toLowerCase).toRight(InvalidRegion(region))
}
