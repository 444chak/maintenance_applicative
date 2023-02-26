#ifndef _PIXEL_TRACER_H_
#define _PIXEL_TRACER_H_


#include "area.h"
#include "shape.h"
#include "parser.h"
#include "render.h"
#include "layers.h"
#include "id.h"


struct pixel_tracer{
  AreaList* list_area;
  Area* current_area;
  Layer* current_layer;
  Shape* current_shape;
};

typedef struct pixel_tracer Pixel_tracer_app ;


/**
 * Créer une area par defaut 
 */
void init_app(Pixel_tracer_app* app);

void destry_app(Pixel_tracer_app* app);


#endif
