/**
 * @file area.h
 * @brief This file contains the definition of the area structure and the functions to manipulate it.
 */
#include <stdlib.h>
#include <stdio.h>
#include "layers.h"

#ifndef _AREA_H_
#define _AREA_H_

/**
 * @brief This structure represents an area in a 2D space.
 */
struct area
{
    unsigned char id;
    char name[255];
    unsigned int width;
    unsigned int height;
    char **area;
    LayersList *lst_layers;
    char empty_char;
    char full_char;
};

/**
 * @brief This structure represents a list of areas in a 2D space.
 */
typedef struct area Area;

typedef list AreaList;

/**
 * @brief This function creates an area in a 2D space.
 * @param width The width of the area.
 * @param height The height of the area.
 * @param id The id of the area.
 * @param name The name of the area.
 * @return An Area structure.
 */
Area *create_area(unsigned int width, unsigned int height,
                  unsigned char id, char *name);

/**
 * @brief This function deletes an area in a 2D space.
 * @param area The area to delete.
 */
void delete_area(Area *area);

/**
 * @brief This function clears an area in a 2D space.
 * @param area The area to clear.
 */
void clear_area(Area *area);

/**
 * @brief This function creates a list of areas in a 2D space.
 * @return An AreaList structure.
 */
AreaList *create_area_list();

/**
 * @brief This function deletes a list of areas in a 2D space.
 * @param area_list The list of areas to delete.
 */
void delete_area_list(AreaList *area_list);

/**
 * @brief This function adds an area to the list of areas.
 * @param area_list The list of areas.
 * @param area The area to be added.
 */
void add_area_to_list(AreaList *area_list, Area *area);

/**
 * @brief This function removes an area from the list of areas.
 * @param area_list The list of areas.
 * @param area The area to be removed.
 */
void remove_area_from_list(AreaList *area_list, Area *area);

#endif
