# imperial_demo

Use docker-compose up to start the back end server.

The back end server will listen on port 8080 of localhost.\
The database is set up to listen on port 7132. 

## localhost:8080/task/create
Expects a POST request with a JSON body containing the 'name' parameter at the minimum.\
Returns 200 OK and the created task in the body if successful.\
Returns 400 Bad Request if the 'name' parameter is absent.

## localhost:8080/task/get/{taskID}
Expects a GET request.\
Returns 200 OK and the task identified by {taskID} in the body if successful.\
Returns 404 Not Found if the requested task ID is not in the database.

## localhost:8080/task/delete/{taskID}
Expects a PUT request.\
Returns 200 OK and the ID of the deleted task if successful.\
Returns 404 Not Found if the requested task ID is not in the database.

## localhost:8080/task/getTaskList
Expects a GET request.\
Returns 200 OK and a list of all tasks currently in the database.

## localhost:8080/updateTask/{taskID}
Expects a PUT request with a JSON body containing the parameters of the task that are to be modified. Currently, name, description and due date are the only fields that can be modified this way.\
Returns 200 OK and the updated task in the body if successful.\
Returns 404 Not Found if the requested task ID is not in the database.

## localhost:8080/markTaskComplete/{taskID}
Expects a PUT request.\
Returns 200 OK and the modified task in the body if successful.\
Returns 404 Not Found if the requested task ID is not in the database.
