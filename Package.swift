// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://maven.pkg.github.com/jakhongir9779/clickstream/uz/jakhongir9779/clickstream/clickstream-kmmbridge/0.1.8/clickstream-kmmbridge-0.1.8.zip"
let remoteKotlinChecksum = "ea438b723286cfa1f51598730901d217e80b5641af1999a433bf2954bf8005ce"
let packageName = "clickstream"
// END KMMBRIDGE BLOCK

let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            url: remoteKotlinUrl,
            checksum: remoteKotlinChecksum
        )
        ,
    ]
)