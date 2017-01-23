## A Code challenge Android App for Interview process
#Summary:
Create an Android application that displays information received over the network.
#Details:
The server at the following url responds with JSON formatted data:
(GET) https://api.github.com/users/ocramius/repos
The response represents a list of objects:
~~~~
{
 "id": 20219396,
"name": "AdminLTE",
"full_name": "Ocramius/AdminLTE", "owner": {
"login": "Ocramius", "id": 154256,


"avatar_url": "https://avatars.githubusercontent.com/u/154256?v=3"
... <more objects> }
~~~~

##Response will include:

1. Use Retrofit to retrieve the data from the url above.
2. Parse the data retrieved from the server into a list of Java objects
3. Create a header view above a RecyclerView and give it a Title and short
description including the url used.
4. Display your objects in the RecyclerView
  - Should display the name, id, owner login, language, and updated_at.
  - Display the image located at each object’s avatar_url.
  - Displaying other fields is optional
  - Clicking an item should open a browser to the item’s clone_url
5. Material Design touches a plus.
6. Review your build.gradle and manifest file.
