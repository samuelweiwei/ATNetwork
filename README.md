# ATNetwork  
AT network project

## Welcome  
The AT network project is to deep dive into the possible transfering mechanism 
from Auckland Council Dataset to Graph info to GIS map. 
Its objectives are to investigate into both static schedule and dynamiclly sync
on data side to acquire proper latest graph update.

## Technology  
Backend is based on java and springboot to facilitate the dev process.

## Get Started  
### Requirements  
The jdk version should be above 17(include 17)  
The springboot version should be above 4.0.0  
Apache Http Component version is 5.2.1  
PostgreSQL should be used as database with version above 14.x  
Maven should be included as an essential  

### Project Structure
Suggested IDE is eclipse, STS or Idea. Developers could make use of import to build a new Project.  
The following steps would be referenced to Sprint Tool Suite(STS).  
1. The project should be imported from GitHub, and should be set up as an springboot project.  
2. The project sources are arranged as standard springboot formats. Folder "src" for source code,  
and folder "target" is for desination class and jar, and remember sometimes the "main" folder in   
"src" has two parts - "java" and "resources". All the configuration work is inside the "resources"  
folder.
3. Remember to configure the application.yml in "resources" folder, especially the url of the   
database. The users should set up their own PostgreSQL database and input the right url in the  
application.yml file.
4. When in STS debugging, the project will run as a springboot web application. The swagger has  
been included as the interface to call the API.  
The link is http://localhost:8080/swagger-ui/index.html  

### Building and Installation  
The Project could be compiled as an executable jar with Maven.  
Firstly, the users should use "maven clean" in the project root folder to clean all the former.  
Then, use the "maven install .", or use the maven install menu in STS by right click on the root  
of the project, to compile the project into an executable jar.  
The jar file coule be run as "java -jar XXX.jar" to start up the web, and remember, copy the  
"application.yml" and "application.properties" into the same leve of folder with the XXX.jar.

## Project APIs  
All following API could be seen from swagger page.  
Most important API is "downloadandupdate". It is the update action to get the latest GTFS data  
from the AT website and parse them, store them into the PostgreSQL database.
The API of "liveness" is to test the liveness of the server, with http 200 ok back is meaningful.  
The API of "allroutes" is used to get all the routes of the Auckland public transport.  
The API of "stopcounts" is to get the stop numbers in Auckland.  
The API of "allstops" is to get all the stops info of the Auckland public transport.
The API of "routetest" is to get the route of input routeid, with all the trips and buses in the  
trips.
The API of "graphtest" is to map all the stops and routes into vertices and edges of a graph with  
JgraphT, and run a shortest path with Dijkstra algorithm for a demo between predefined two stops.  
Also the graph will be outputed in the root of server folder with the name of "dotExp-xxx.dat",  
which could be used to visualize with an dot viewer for graph.

### API Link List  
[Auckland Transport Open GIS Data - Creative Commons Licence 4.0](https://data-atgis.opendata.arcgis.com/)  
[Auckland Bus Service GIS Data](https://data-atgis.opendata.arcgis.com/maps/busservice/about)  
[Auckland Bus Route GeoService API Access](https://services2.arcgis.com/JkPEgZJGxhSjYOo0/arcgis/rest/services/BusService/FeatureServer/2/query?outFields=*&where=1%3D1)  
[Auckland Bus Route GeoJson API Access](https://services2.arcgis.com/JkPEgZJGxhSjYOo0/arcgis/rest/services/BusService/FeatureServer/2/query?outFields=*&where=1%3D1&f=geojson)  
[Auckland Bus Stop GeoService API Access](https://services2.arcgis.com/JkPEgZJGxhSjYOo0/arcgis/rest/services/BusService/FeatureServer/0/query?outFields=*&where=1%3D1)  
[Auckland Bus Stop GeoJson API Access](https://services2.arcgis.com/JkPEgZJGxhSjYOo0/arcgis/rest/services/BusService/FeatureServer/0/query?outFields=*&where=1%3D1&f=geojson)  
[Auckland School Bus Route GeoService API Access](https://services2.arcgis.com/JkPEgZJGxhSjYOo0/arcgis/rest/services/BusService/FeatureServer/3/query?outFields=*&where=1%3D1)  
[Auckland School Bus Route GeoJson API Access](https://services2.arcgis.com/JkPEgZJGxhSjYOo0/arcgis/rest/services/BusService/FeatureServer/3/query?outFields=*&where=1%3D1&f=geojson)  
[Auckland School Bus Stop GeoService API Access](https://services2.arcgis.com/JkPEgZJGxhSjYOo0/arcgis/rest/services/BusService/FeatureServer/1/query?outFields=*&where=1%3D1)  
[Auckland School Bus Stop GeoJson API Access](https://services2.arcgis.com/JkPEgZJGxhSjYOo0/arcgis/rest/services/BusService/FeatureServer/1/query?outFields=*&where=1%3D1&f=geojson)  

### Data Entity  
Metadata of the project is acquired from [AT developer portal](https://dev-portal.at.govt.nz/)
And it is GTFS formated with periodically updates. The portal developers are required to registered into it, so that they can apply
for the subscription-key to call the API offered by AT officially. All APIs are REST styled and HTTPs available. No HTTP services are 
offered, for improved security in the cyberspace. 
The latest static GTFS are weekly updated, and it download link is: https://gtfs.at.govt.nz/gtfs.zip

