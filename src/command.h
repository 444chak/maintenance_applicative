/**
 * @file command.h
 * @brief This file contains the definition of the command structure and the functions to manipulate it.
 */

#ifndef _COMMAND_H_
#define _COMMAND_H_

#define MAX_PARAM 30

#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#include <readline/readline.h>
#include <readline/history.h>
#include "pixel_tracer.h"

/**
 * @brief This structure represents a command.
 */
struct command
{
    char name[50];
    int int_size;
    int int_params[MAX_PARAM];
    int str_size;
    char *str_params[MAX_PARAM];
    int flt_size;
    float flt_params[MAX_PARAM];
};

/**
 * @brief This structure represents a command.
 */
typedef struct command Command;

/**
 * @brief This function creates a command.
 * @return A Command structure.
 */
Command *create_commande();

/**
 * @brief This function adds an integer parameter to a command.
 * @param cmd The command to modify.
 * @param p The integer parameter to add.
 */
void add_int_param(Command *cmd, int p);

/**
 * @brief This function adds a float parameter to a command.
 * @param cmd The command to modify.
 * @param p The float parameter to add.
 */
void add_float_param(Command *cmd, float p);

/**
 * @brief This function adds a string parameter to a command.
 * @param cmd The command to modify.
 * @param p The string parameter to add.
 */
void add_str_param(Command *cmd, char *p);

/**
 * @brief This function deletes a command.
 * @param cmd The command to delete.
 */
void free_cmd(Command *cmd);

/**
 * @brief This function reads a command from the standard input.
 * @param app The application.
 * @return 0 if the command is executed, 1 if the command is not found, 2 if the command is not valid, 3 if the command is not valid, 4 if the command is exit, 5 if the command is clear, 6 if the command is save, 7 if the command is load, 8 if the command is list.
 */
int read_exec_command(Pixel_tracer_app *app);

/**
 * @brief This function reads a command from the standard input.
 * @param cmd The command to modify.
 */
void read_from_stdin(Command *cmd);

#endif
