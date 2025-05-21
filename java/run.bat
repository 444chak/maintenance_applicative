@echo off
echo Compilation...
if not exist build mkdir build
javac -d build pixel_tracer/*.java

echo.
echo Execution...
java -cp build pixel_tracer.PixelTracerApp

pause 