/**
 * @file pixel.h
 * @brief This file contains the definition of the pixel structure and the functions to manipulate it.
 */

#ifndef _PIXEL_H_
#define _PIXEL_H_

#include <stdlib.h>
#include "shape.h"
#include "list.h"

/**
 * @brief The pixel structure
 */
struct pixel
{
    int px;
    int py;
    int color;
};

typedef struct pixel Pixel;

/**
 * @brief Create shape to pixel
 * @param shape the shape to convert
 * @return the list of pixels
 */
list *create_shape_to_pixel(Shape *shape);

/**
 * @brief Remove pixel shape
 * @param pixel_lst the list of pixels
 */
void remove_pixel_shape(list *pixel_lst);

/**
 * @brief Create a pixel
 * @param px the x position of the pixel
 * @param py the y position of the pixel
 * @param color the color of the pixel
 * @return the pixel created
 */
Pixel *create_pixel(int px, int py, int color);

/**
 * @brief Delete a pixel
 * @param pixel the pixel to delete
 */
void delete_pixel(Pixel *pixel);

/**
 * @brief Draw a point
 * @param shape the shape to draw
 * @param lst the list of pixels
 */
void pixel_point(Shape *shape, list *lst);

/**
 * @brief Draw a line
 * @param shape the shape to draw
 * @param lst the list of pixels
 */
void pixel_line(Shape *shape, list *lst);

/**
 * @brief Draw a circle
 * @param shape the shape to draw
 * @param lst the list of pixels
 */
void pixel_cercle(Shape *shape, list *lst);

/**
 * @brief Draw a rectangle
 * @param shape the shape to draw
 * @param lst the list of pixels
 */
void pixel_rectangle(Shape *shape, list *lst);

/**
 * @brief Draw a square
 * @param shape the shape to draw
 * @param lst the list of pixels
 */
void pixel_square(Shape *shape, list *lst);

/**
 * @brief Draw a polygon
 * @param shape the shape to draw
 * @param lst the list of pixels
 */
void pixel_polygon(Shape *shape, list *lst);

/**
 * @brief Draw a curve
 * @param shape the shape to draw
 * @param lst the list of pixels
 */
void pixel_curve(Shape *shape, list *lst);

#endif
