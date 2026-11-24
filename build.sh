#!/bin/bash
# LarpVisuals Build Script

echo "Building LarpVisuals..."
./gradlew clean build

if [ -f "build/libs/larpvisuals-1.0.0.jar" ]; then
    echo "Build successful!"
    echo "JAR location: build/libs/larpvisuals-1.0.0.jar"
    echo ""
    echo "Copy to mods folder:"
    echo "cp build/libs/larpvisuals-1.0.0.jar ~/.minecraft/mods/"
else
    echo "Build failed!"
    exit 1
fi