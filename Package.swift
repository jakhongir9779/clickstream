// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://maven.pkg.github.com/jakhongir9779/clickstream/uz/jakhongir9779/clickstream/clickstream-kmmbridge/0.1.10/clickstream-kmmbridge-0.1.10.zip"
let remoteKotlinChecksum = "ccd77aa273296025aad2cc1f3e94db001785dfc45e6b2bf316692710c86e19b6"
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