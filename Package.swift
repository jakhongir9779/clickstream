// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://maven.pkg.github.com/jakhongir9779/clickstream/uz/jakhongir9779/clickstream/clickstream-kmmbridge/0.1.9/clickstream-kmmbridge-0.1.9.zip"
let remoteKotlinChecksum = "e46ffe56971abbe104e2e2615ccea812163831e7fb5a1894fa91fc7f4767aefe"
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