// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://maven.pkg.github.com/jakhongir9779/clickstream/uz/jakhongir9779/clickstream/clickstream-kmmbridge/0.1.12/clickstream-kmmbridge-0.1.12.zip"
let remoteKotlinChecksum = "4e959aaa35e953abccff0625e6faad99a9080ecbc3ff6062e1d44903f23228ae"
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