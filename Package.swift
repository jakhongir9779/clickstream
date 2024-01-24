// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "clickstream",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "clickstream",
            targets: ["clickstream"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "clickstream",
            path: "./clickstream.xcframework"
        ),
    ]
)
