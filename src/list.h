/**
 * @file list.h
 * @brief This file contains the definition of the list structure and the functions to manipulate it.
 */

#ifndef _LIST_H_
#define _LIST_H_

/**
 * @brief A node of the list
 */
typedef struct lnode_
{
    void *data;
    struct lnode_ *prev;
    struct lnode_ *next;
} lnode;

/**
 * @brief The list structure
 */
typedef struct list_
{
    lnode *head;
    lnode *tail;
} list;

/**
 * @brief Create a node
 * @param dat The data of the node
 * @return The node created
 */
lnode *lst_create_lnode(void *dat);

/**
 * @brief Create a list
 * @return The list created
 */
list *lst_create_list();

/**
 * @brief Delete a list
 * @param lst The list to delete
 */
void lst_delete_list(list *lst);

/**
 * @brief Insert pnew at the head of the list
 * @param lst The list
 * @param pnew The node to insert
 */
void lst_insert_head(list *lst, lnode *pnew);

/**
 * @brief Insert pnew at the tail of the list
 * @param lst The list
 * @param pnew The node to insert
 */
void lst_insert_tail(list *lst, lnode *pnew);

/**
 * @brief Insert pnew after ptr
 * @param lst The list
 * @param pnew The node to insert
 * @param ptr The node after which to insert
 */
void lst_insert_after(list *lst, lnode *pnew, lnode *ptr);

/**
 * @brief Delete the first element of the list
 * @param lst The list
 */
void lst_delete_head(list *lst);

/**
 * @brief Delete the last element of the list
 * @param lst The list
 */
void lst_delete_tail(list *lst);

/**
 * @brief Delete a node of the list
 * @param lst The list
 * @param ptr The node to delete
 */
void lst_delete_lnode(list *lst, lnode *ptr);

/**
 * @brief Erase the list
 * @param lst The list
 */
void lst_erase(list *lst);

/**
 * @brief Get the first element
 * @param lst The list
 * @return The first element
 */
lnode *get_first_node(list *lst);

/**
 * @brief Get the last node
 * @param lst The list
 * @return The last node
 */
lnode *get_last_node(list *lst);

/**
 * @brief Get the next element
 * @param lst The list
 * @param lnode The node
 * @return The next node
 */
lnode *get_next_node(list *lst, lnode *lnode);

/**
 * @brief Get the previous element
 * @param lst The list
 * @param lnode The node
 */
void *get_previous_elem(list *lst, lnode *lnode);

#endif
