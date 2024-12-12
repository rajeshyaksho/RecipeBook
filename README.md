Recipe Book App

Recipe Book is an application that will allow users to create a collection of recipe which they can view in detail. 
Users often forget the recipe they mastered overtime. This app identifies and solves this problem by helping user store all the recipes.
This problem made us think about the Recipe-Book app. Through various user-friendly functions, the app will implement registering and login functionalities, a record of database stored by each user. 
The main feature consists of adding personalized recipes & allowing the users to edit and delete the recipe according to their personal preferences.  
This app is targeted to general people who find it hard remembering all the recipes as they master the new one. 

Functions

Create the Recipe:
Users can create their own virtual recipe list and store it in their personal inventory. 
Simply, users can name their own creations and there are no limitations to what the user prefers their recipe to be. 
User recipe data is stored in the server using firestore API  by firebase from google.

Login/Logout Feature:
All the users have their separate personalized list of recipes stored in the authentication database. 
The login information is stored safely in google firebase authentication database enhancing the user information privacy. Additionally, users can have the logout option from their space at any time.

Create Account Feature:
All the users are required to create a personal account or login before accessing the recipe book. This creates a personalized space for each user. To create the account user needs to authenticate via their mail.

Edit / Delete Recipe Feature:
Users have the ability to edit the recipe they have created previously. They can also delete the recipe if they don't want anymore allowing them to customize their recipe book.
The edit/delete feature will take effect in the real time database giving each user the maximum customization feature.

View Recipe Feature:
Users have the ability to view the recipe they have created in an organized list.
This organized list is updated eventually in the firestore database and the timestamp is also presented to the user.

Resources:

Our app will utilize an Application Programming Interface (API) to manage the user authentication process for the Database of the Virtual Recipe application. 
Firebase Authentication by Firebase will be integrated to ensure a secure and seamless user authentication experience. 
The Firestore database will serve as the backend, storing and managing all the recipes created by users.
In addition to leveraging Firebase services, the application optimizes its performance by efficiently using system resources.
Specifically, the application employs chunks of memory from the device's system as all applications do.
This allows the application to load and run various components directly from the phone's memory in smaller, manageable chunks. Java does all the work for the integration of API and phone’s memory in the background. 
