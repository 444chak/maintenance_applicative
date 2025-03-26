/**
 * @file shape.h
 * @brief This file contains the definition of the shape structure and the functions to manipulate it.
 */
#ifndef _SHAPE_H_
#define _SHAPE_H_

/**
 * @brief This enum is used to define the different types of shapes that can be created.
 */
typedef enum shape_type
{
    POINT,
    LINE,
    SQUAR,
    RECTANGLE,
    CERCLE,
    POLYGON,
    CURVE
} Shape_type;
/**
 * @brief This enum is used to define the different colors that can be used to fill a shape.
 */
typedef enum color
{
    BLACK,
    WIGHT,
    RED,
    GREEN
} Color;

/**
 * @brief This structure represents a point in a 2D space.
 */
struct point
{
    int pos_x;
    int pos_y;
};
typedef struct point Point;

/**
 * @brief This structure represents a line in a 2D space.
 */
struct line
{
    Point *p1;
    Point *p2;
};
typedef struct line Line;

/**
 * @brief This structure represents a square in a 2D space.
 */
struct squar
{
    Point *p1;
    int length;
};
typedef struct squar Squar;

/**
 * @brief This structure represents a rectangle in a 2D space.
 */
struct rectangle
{
    Point *p1;
    int width;
    int height;
};
typedef struct rectangle Rectangle;

/**
 * @brief This structure represents a circle in a 2D space.
 */
struct cercle
{
    Point *center;
    int radus;
};
typedef struct cercle Cercle;

/**
 * @brief This structure represents a polygon in a 2D space.
 */
struct polygon
{
    int n;
    Point **points;
};
typedef struct polygon Polygon;

/**
 * @brief This structure represents a curve in a 2D space.
 */
struct curve
{
    Point *p1;
    Point *p2;
    Point *p3;
    Point *p4;
};
typedef struct curve Curve;

/**
 * @brief This structure represents a shape in a 2D space.
 */
struct shape
{
    unsigned long long int id;
    Shape_type shape_type;
    void *ptrShape;
    unsigned char fill;
    float thickness;
    Color color;
    double rotation;
};
typedef struct shape Shape;

/**
 * @brief This function creates a point in a 2D space.
 * @param px The x coordinate of the point.
 * @param py The y coordinate of the point.
 * @return A Point structure.
 */
Point *create_point(int px, int py);
/**
 * @brief This function deletes a point in a 2D space.
 * @param point The point to delete.
 */
void delete_point(Point *point);
/**
 * @brief This function creates a line in a 2D space.
 * @param p1 The first point of the line.
 * @param p2 The second point of the line.
 * @return A Line structure.
 */
Line *create_line(Point *p1, Point *p2);
/**
 * @brief This function deletes a line in a 2D space.
 * @param line The line to delete.
 */
void delete_line(Line *line);
/**
 * @brief This function creates a square in a 2D space.
 * @param point The point of the square.
 * @param legth The length of the square.
 * @return A Squar structure.
 */
Squar *create_squar(Point *point, int legth);
/**
 * @brief This function deletes a square in a 2D space.
 * @param squar The square to delete.
 */
void delete_squar(Squar *squar);
/**
 * @brief This function creates a rectangle in a 2D space.
 * @param point The point of the rectangle.
 * @param width The width of the rectangle.
 * @param height The height of the rectangle.
 * @return A Rectangle structure.
 */
Rectangle *create_rectangle(Point *point, int width, int height);
/**
 * @brief This function deletes a rectangle in a 2D space.
 * @param rectangle The rectangle to delete.
 */
void delete_rectangle(Rectangle *rectangle);
/**
 * @brief This function creates a circle in a 2D space.
 * @param center The center of the circle.
 * @param radus The radius of the circle.
 * @return A Cercle structure.
 */
Cercle *create_cercle(Point *center, int radus);
/**
 * @brief This function deletes a circle in a 2D space.
 * @param cercle The circle to delete.
 */
void delete_cercle(Cercle *cercle);
/**
 * @brief This function creates a polygon in a 2D space.
 * @param n The number of points of the polygon.
 * @return A Polygon structure.
 */
Polygon *create_polygon(int n);
/**
 * @brief This function deletes a polygon in a 2D space.
 * @param polygon The polygon to delete.
 */
void delete_polygon(Polygon *polygon);
/**
 * @brief This function creates a curve in a 2D space.
 * @param p1 The first point of the curve.
 * @param p2 The second point of the curve.
 * @param p3 The third point of the curve.
 * @param p4 The fourth point of the curve.
 * @return A Curve structure.
 */
Curve *create_curve(Point *p1, Point *p2, Point *p3, Point *p4);
/**
 * @brief This function deletes a curve in a 2D space.
 * @param curve The curve to delete.
 */
void delete_curve(Curve *curve);

/**
 * @brief This function creates an empty shape in a 2D space.
 * @param shape_type The type of the shape.
 * @return A Shape structure.
 */
Shape *create_empty_shape(Shape_type shape_type);

/**
 * @brief This function prints a point to a string.
 * @param p The point to print.
 * @param str The string to print to.
 */
void sprint_point(Point *p, char *str);
/**
 * @brief This function prints a line to a string.
 * @param line The line to print.
 * @param str The string to print to.
 */
void sprint_line(Line *line, char *str);
/**
 * @brief This function prints a square to a string.
 * @param squar The square to print.
 * @param str The string to print to.
 */
void sprint_squar(Squar *squar, char *str);
/**
 * @brief This function prints a rectangle to a string.
 * @param rectangle The rectangle to print.
 * @param str The string to print to.
 */
void sprint_rectangle(Rectangle *rectangle, char *str);
/**
 * @brief This function prints a circle to a string.
 * @param cercle The circle to print.
 * @param str The string to print to.
 */
void sprint_cercle(Cercle *cercle, char *str);
/**
 * @brief This function prints a polygon to a string.
 * @param polygon The polygon to print.
 * @param str The string to print to.
 */
void sprint_polygon(Polygon *polygon, char *str);
/**
 * @brief This function prints a curve to a string.
 * @param curve The curve to print.
 * @param str The string to print to.
 */
void sprint_curve(Curve *curve, char *str);

/**
 * @brief This function creates a point shape in a 2D space.
 * @param px The x coordinate of the point.
 * @param py The y coordinate of the point.
 * @return A Shape structure.
 */
Shape *create_point_shape(int px, int py);
/**
 * @brief This function creates a line shape in a 2D space.
 * @param px1 The x coordinate of the first point.
 * @param py1 The y coordinate of the first point.
 * @param px2 The x coordinate of the second point.
 * @param py2 The y coordinate of the second point.
 * @return A Shape structure.
 */
Shape *create_line_shape(int px1, int py1, int px2, int py2);
/**
 * @brief This function creates a square shape in a 2D space.
 * @param px The x coordinate of the point.
 * @param py The y coordinate of the point.
 * @param length The length of the square.
 * @return A Shape structure.
 */
Shape *create_square_shape(int px, int py, int length);
/**
 * @brief This function creates a rectangle shape in a 2D space.
 * @param px The x coordinate of the point.
 * @param py The y coordinate of the point.
 * @param width The width of the rectangle.
 * @param height The height of the rectangle.
 * @return A Shape structure.
 */
Shape *create_rectangle_shape(int px, int py, int width, int height);
/**
 * @brief This function creates a circle shape in a 2D space.
 * @param px The x coordinate of the center.
 * @param py The y coordinate of the center.
 * @param radus The radius of the circle.
 * @return A Shape structure.
 */
Shape *create_cercle_shape(int px, int py, int radus);
/**
 * @brief This function creates a polygon shape in a 2D space.
 * @param n The number of points of the polygon.
 * @param tab The array of points of the polygon.
 * @return A Shape structure.
 */
Shape *create_polygon_shape(int n, int *tab);
/**
 * @brief This function creates a curve shape in a 2D space.
 * @param px1 The x coordinate of the first point.
 * @param py1 The y coordinate of the first point.
 * @param px2 The x coordinate of the second point.
 * @param py2 The y coordinate of the second point.
 * @param px3 The x coordinate of the third point.
 * @param py3 The y coordinate of the third point.
 * @param px4 The x coordinate of the fourth point.
 * @param py4 The y coordinate of the fourth point.
 * @return A Shape structure.
 */
Shape *create_curve_shape(int px1, int py1, int px2, int py2, int px3,
                          int py3, int px4, int py4);

/**
 * @brief This function deletes a shape in a 2D space.
 * @param shape The shape to delete.
 */
void delete_shape(Shape *shape);
/**
 * @brief This function prints a shape to a string.
 * @param shape The shape to print.
 * @param str The string to print to.
 */
void sprint_shape(Shape *shape, char *str);

#endif
