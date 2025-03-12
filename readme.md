# :earth_africa: aws-regions

Scala micro library for AWS regions.

## Usage

You can add the following lines to `build.sbt` to use the library.

```scala
libraryDependencies ++= Seq(
  "com.magine" %% "aws-regions" % awsRegionsVersion,
  "com.magine" %% "aws-regions-circe" % awsRegionsVersion,
  "com.magine" %% "aws-regions-ciris" % awsRegionsVersion
)
```

Make sure to replace `awsRegionsVersion` with a [release version](https://github.com/maginepro/aws-regions/releases).<br>
Replace `%%` with `%%%` if you are using [Scala.js](https://www.scala-js.org) or [Scala Native](https://scala-native.org).

## Quick Example

```scala
import com.magine.aws.Region

Region.EU_WEST_1 == Region("eu-west-1") // true
Region.EU_WEST_1 == Region("EU-WEST-1") // true
Region.valid("eu-west-1") //  Right(eu-west-1)
Region.valid("EU-WEST-1") //  Right(eu-west-1)
Region.valid("eu-west-4") //  Left(com.magine.aws.InvalidRegion: Invalid region: eu-west-4)
```
