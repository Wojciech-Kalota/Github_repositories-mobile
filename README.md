# Github repositories:

Mobile application displaying a list of repositories, languages used, and amount of bites codded in each language for a specified user.

# How to start:

In order to run the application one must download file Github_repositories.apk

# Specification:

The application requires an Android version no lower than 7.0 (API 24)
As of writing this description, 89% of all Android devices fit the requirement, which means that almost every device should be able to run the application.
The project has been created with JDK 11, as it's been the newest LTS before the release of still quite new JDK 17.

# Algorithm safety:

The algorithm can handle these exceptions:
-invalid username
-many pages of repositories on the user's profile
-lack of repositories on the user's profile

# Bonus features:

The application contains some features to make usage more comfortable:
-hint what to write in the search view
-after the search is done, searched username is displayed at the top of the screen
-color pallet resembling that of a Github

# Ideas for future development:

Some ideas I got for project development in future iterations:
-adding the descriptions and creation dates for repositories
-adding a profile picture of searched user
-user authorization in order to allow a view of private repositories 
-adding colors for each language as on Github to make the application more visually appealing
-adding a possibility of going to the Github website to inspect the repository thoroughly
-search of repositories for a given user
-hints during the search

# Problems to solve:

Inaccessibility of java.net.http. and another post-Java 8 external, non-language features
