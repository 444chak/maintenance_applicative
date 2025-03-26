/**
 * @file layers.h
 * @brief This file contains the definition of the layer structure and the functions to manipulate it.
 */

#include "list.h"
#include "shape.h"
#include <stdlib.h>
#include <string.h>

#ifndef _LAYERS_H_
#define _LAYERS_H_

#define LAYER_VISIBLE 1
#define LAYER_UNVISIBLE 0

/**
 * @brief This structure represents a layer in a 2D space.
 */
struct layer
{
    unsigned int id;
    char name[255];
    unsigned char visible;
    list shapes;
};

/**
 * @brief This structure represents a list of layers in a 2D space.
 */
typedef struct layer Layer;

/**
 * @brief This structure represents a list of layers in a 2D space.
 */
typedef list LayersList;

/**
 * @brief This function creates a layer in a 2D space.
 * @param id The id of the layer.
 * @param name The name of the layer.
 * @return A Layer structure.
 */
Layer *create_layer(int id, char *name);

/**
 * @brief This function deletes a layer in a 2D space.
 * @param layer The layer to delete.
 */
void delete_layer(Layer *layer);

/**
 * @brief This function creates a list of layers in a 2D space.
 * @return A LayersList structure.
 */
LayersList *create_layers_list();

/**
 * @brief This function deletes a list of layers in a 2D space.
 * @param layer_list The list of layers to delete.
 */
void delete_layers_list(LayersList *layer_list);

/**
 * @brief This function adds a layer to a list of layers.
 * @param layer_list The list of layers to modify.
 * @param layer The layer to add.
 */
void add_layer_to_list(LayersList *layer_list, Layer *layer);

/**
 * @brief This function removes a layer from a list of layers.
 * @param layer_list The list of layers to modify.
 * @param layer The layer to remove.
 */
void remove_layer_from_list(LayersList *layer_list, Layer *layer);

/**
 * @brief This function sets a layer visible.
 * @param layer The layer to modify.
 */
void set_layer_visible(Layer *layer);

/**
 * @brief This function sets a layer unvisible.
 * @param layer The layer to modify.
 */
void set_layer_unvisible(Layer *layer);

/**
 * @brief This function adds a shape to a layer.
 * @param layer The layer to modify.
 * @param shape The shape to add.
 */
void add_shape_to_layer(Layer *layer, Shape *shape);

/**
 * @brief This function removes a shape from a layer.
 * @param layer The layer to modify.
 * @param shape The shape to remove.
 */
void remove_shape_to_from(Layer *layer, Shape *shape);

#endif
