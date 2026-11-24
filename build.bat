@echo off
REM LarpVisuals Build Script for Windows

echo Building LarpVisuals...
call gradlew.bat clean build

if exist "build\libs\larpvisuals-1.0.0.jar" (
    echo Build successful!
    echo JAR location: build\libs\larpvisuals-1.0.0.jar
    echo.
    echo Copy to mods folder:
    echo copy build\libs\larpvisuals-1.0.0.jar %%APPDATA%%\.minecraft\mods\
) else (
    echo Build failed!
    exit /b 1
)