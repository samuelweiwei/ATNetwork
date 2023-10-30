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
###Building  
The jdk version should be above 17(include 17)  
The springboot version should be above 4.0.0  
Apache Http Component version is 5.2.1  
Maven should be included as an essential  



###Installation  

## Resources  

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

