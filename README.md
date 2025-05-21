# Pixel Tracer

Pixel Tracer is a C-based project with documentation generated using Doxygen.

## Overview

This project provides tools for pixel tracing and manipulation. The documentation is configured to be optimized for C code.

## Documentation

The project documentation is generated using Doxygen. The configuration file (`Doxyfile`) is set up to:

- Output documentation to the `doxygen` directory
- Generate documentation optimized for C code
- Use "Pixel Tracer" as the project name

## Building Documentation

To generate the documentation:

1. Make sure you have Doxygen installed on your system
2. Run the following command from the project root:

    ```bash
    doxygen Doxyfile
    ```

3. The generated documentation will be available in the `doxygen` directory

## Project Structure

The project appears to be a C-based application with:

- Core functionality for pixel tracing
- Documentation using standard Doxygen practices
- Java implementation available in the `java` directory

You can find the project detailled structure [here](./STRUCTURE.md).

## Running the Java Version

To run the Java version of Pixel Tracer:

1. Navigate to the `java` directory
2. Run the `run.bat` script:

   ```bash
   run.bat
   ```

This will compile and execute the Java application.

## Commands

The following commands are available in Pixel Tracer's vector text-based editor:

### Control Commands

- `plot` - Draw screen
- `clear` - Clear screen
- `exit` - Exit the program

### Draw Shapes

- `point px py` - Create a point at position (px, py)
- `line x1 y1 x2 y2` - Draw a line from (x1, y1) to (x2, y2)
- `square x1 y1 l` - Draw a square at (x1, y1) with length l
- `rectangle x1 y1 w h` - Draw a rectangle at (x1, y1) with width w and height h
- `circle x y r` - Draw a circle with center at (x, y) and radius r
- `polygon x1 y1 x2 y2 ...` - Draw a polygon with specified points
- `curve x1 y1 x2 y2 x3 y3 x4 y4` - Draw a Bezier curve

### Draw Manager

- `list {layers, arias, shapes}` - List elements by category
- `select {aria, layer} {id}` - Select an aria or layer by ID
- `delete {aria, layer, shape} {id}` - Delete an element by category and ID
- `new {aria, layer}` - Create a new aria or layer

### Settings

- `set char {border, background} ascii_code` - Set character properties
- `set layer {visible, unvisible} {id}` - Toggle layer visibility

## License

This project is distributed under the terms of the GNU General Public License (GPL), as indicated in the LICENSE file.
