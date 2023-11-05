# SUShuttleService

## API's to access :

### Services provided by Shuttle:
- /ShuttleUserEntry --> Enter the SU students into the shuttle and drop them off :: Params required to request ()
- /ShuttleLocation --> Update the current location of the shuttle :: Params required to request (Latitude, Longitude, ShuttleID)

### Services provided to the SU Users:
- /sign-in --> Resister the SU students into the database :: Params required to request (SUID, name, email, address)
- /UserPickUp --> Request a ride (SU Shuttle) for pickup, will be returned the approximate ETA :: Params required to request ()
- /Users --> Return all the list of Registered Users :: Params required to request ()
