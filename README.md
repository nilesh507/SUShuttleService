# About 
“Shuttle Service" is a pioneering pilot program conceived to transform campus transportation, elevating the commuting experience for students. This initiative is intricately designed to optimize evening shuttle services through the integration of modern technology and data-driven solutions. The overarching goal is to enhance the efficiency and accessibility of campus transportation, setting new standards for student mobility. Campus Shuttle Connect introduces a user-friendly mobile application, empowering students to seamlessly request rides from campus to their residences. The app interfaces with a centralized server, ensuring secure identification verification by cross-referencing Student UID (SUID) against an authorized student database. The success of this pilot program holds the potential to influence the university to invest in a larger, more comprehensive transportation solution.

&nbsp;
---
&nbsp;

# SUShuttleService

## API's to access :

### Services provided by Shuttle:
- /ShuttleUserEntry --> Enter the SU students into the shuttle and drop them off :: Params required to request ()
- /ShuttleLocation --> Update the current location of the shuttle :: Params required to request (Latitude, Longitude, ShuttleID)

### Services provided to the SU Users:
- /sign-in --> Resister the SU students into the database :: Params required to request (SUID, name, email, address)
- /UserPickUp --> Request a ride (SU Shuttle) for pickup, will be returned the approximate ETA :: Params required to request ()
- /Users --> Return all the list of Registered Users :: Params required to request ()

&nbsp;
---
&nbsp;
## Database Design
<img width="605" alt="image" src="https://github.com/nilesh507/SUShuttleService/assets/56382235/65ee90c7-cf13-4b44-af29-3e78d8cdaea0">

## Design Patterns 

- MVC Pattern: Controller and Model Classes
- Repository Pattern: Abstraction for database interaction 
- Service Layer Pattern: Separation of business logic from Controller
- Singleton Pattern: Spring Autowired objects
- Data Transfer Object Pattern: Encapsulation of data between processes






