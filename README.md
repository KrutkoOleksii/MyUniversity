# UniversitySchedule
test project

Endpoints in this project:

The main path:
 - ‘localhost:8080’

Then the path for the entities:
- ‘/audienses’
- ‘/day-schedules’
- ‘/group-schedules’
- ‘/lectures’
- ‘/people’
- ‘/professors’
- ‘/students’
- ‘/groups’
- ‘/subjects’

And in the end for each entities (CRUD)
- GET (path ’’ or ‘/‘) - for list the objects
- GET (path ‘/{id}’) - for get an object with id = {id}
- POST (path ‘’ or ‘/‘) - for save (or for update ) an object. With the JSON (object) in the request body
- DELETE (path ‘/{id}’) - for delete an object with id = {id}

Special endpoint for ‘/lectures’ :
- ‘/days/{dayOfWeekNumber}/students/{studentId}’
Where:
 {dayOfWeekNumber} - it’s a number of week day (1-MONDAY, 2-TUESDAY etc.)
 {studentId} - it’s student’s id (in test DB - from 1 to 10)
This request returns the JSON with the student schedule for the specified day
