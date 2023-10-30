# Code Structure  
AT network project code structure. The code is organized with Model-View-Control.  
Standard springboot structre with controller, service, and mapper.

## com.atnetwork.controller  
The package is the access point of HTTP url, and different APIs access are defined here.   

## com.atnetwork.dataset  
The package is the data analyze part of the GTFS, and it defines the interfaces and actions.  

## com.atnetwork.enetity  
The package is the POJO of java, means the java beans standards for the entities. All GTFS static  entities, realtime entities, jgrapht entities are defined in the package.  

## com.atnetwork.enetity  
The package is the mapper to the database, like ORB layer in the java framework. It defines  
the operations of the different entities with one java and one xml in pairs.  

## com.atnetwork.service  
All service actions are defined here to be called by controllers.  

## com.atnetwork.utils  
Some useful tools are defined here to be used by whole projects.  



