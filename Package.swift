// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://maven.pkg.github.com/jakhongir9779/clickstream/uz/jakhongir9779/clickstream/clickstream-kmmbridge/0.1.5/clickstream-kmmbridge-0.1.5.zip"
let remoteKotlinChecksum = "16739d1e75b4b99cc7120faf88ca620cc1fa9a207a31611c6805e94301625943"
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