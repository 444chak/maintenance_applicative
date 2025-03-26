/**
 * @file render.h
 * @brief This file contains the definition of the render functions.
 */

#include <stdlib.h>
#include <stdio.h>
#include "layers.h"
#include "area.h"
#include "pixel.h"

#ifndef _RENDER_H_
#define _RENDER_H_

/**
 * @brief Enum for the color of the cell
 */
typedef enum
{
    EMPTY_CELL,
    BLACK_CELL,
    RED_CELL
} color_cell;

#define EMPTY_CHAR '.'
#define FULL_CHAR '#'

/**
 * @brief Clear the area
 */
void render_area(Area *area);

/**
 * @brief Draw the area
 */
void draw_area(Area *area);

/**
 * @brief Clear the screen
 */
void clear_screen();

/**
 * @brief Draw the shapes of a layer
 */
void draw_layer_shapes(Area *area, Layer *layer);

/**
 * @brief Draw all the layers of an area
 */
void draw_all_layers(Area *area);

#endif
