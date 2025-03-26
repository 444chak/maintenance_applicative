/**
 * @file id.h
 * @brief This file contains the definition of the id functions.
 */

#ifndef _ID_H_
#define _ID_H_

#define ID_FILE "id.txt"

/**
 * @brief Get the next id
 * @return The next id
 */
unsigned long long int get_next_id();

/**
 * @brief Set the id
 * @param id The id to set
 */
void set_id(unsigned long long int id);

/**
 * @brief Save the id
 */
void save_id();

/**
 * @brief Load the id
 */
void load_id();

#endif
