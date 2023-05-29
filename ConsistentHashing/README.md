# Consistent Hashing 

It is an approach to map the users to the servers.
It is a way that minimum movement of users is performed during scaling the system or handling server failures.


Approach:

The userIDs(users that request from server) will be mapped to a circular queue.
The server keys will also be mapped to the same circular queue.
In order to find the server to serve user request we move in clockwise direction.
Adding/Removing the server in this approach is easy.
Only a fraction of user requests need to be re-mapped.
Rest all the requests are routed there original server.
