// swift-tools-version:5.3
import PackageDescription

// BEGIN KMMBRIDGE VARIABLES BLOCK (do not edit)
let remoteKotlinUrl = "https://nexus.infra.cluster.daymarket.uz/repository/market-mobile//uz/uzum/mobile/analytics/sdk/clickstream-kmmbridge/1.6/clickstream-kmmbridge-1.6.zip"
let remoteKotlinChecksum = "2fc7b1ef01f910a2beb2bb9291749d0ef07e7769d633a8ec4b43b198495dde24"
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