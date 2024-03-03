# FacultedeBoumerdesDZ Android App

FacultedeBoumerdesDZ is a mobile application developed using Android Studio. The app provides information about the faculties of the University of Boumerdès, Algeria. Each faculty is characterized by an identifier, description, phone number, email address, coordinates, etc. The information for each faculty is stored in an SQLite database.

## Features

- **Add Faculty:** Users can add a new faculty by providing details such as name, dean's name, phone/fax, email, website, and address. The information is stored in the SQLite database.

- **List Faculties:** The app allows users to view a list of all faculties with basic information. It includes options for calling, sending SMS, and sending emails.

- **Navigation Drawer:** The app features a navigation drawer with options to navigate to the list of faculties or add a new faculty.

- **Image Selection:** Users can select an image for a faculty from their device's gallery.

## Permissions

The app requires the following permissions:

- Read External Storage: To select images from the device's gallery.
- Call Phone: To initiate phone calls to the provided phone/fax number.
- Send SMS: To send SMS to the provided phone/fax number.

## Code Structure

- **AndroidManifest.xml:** Contains the app's configuration and requested permissions.

- **AddFacultyActivity.java:** Implements the functionality for adding a new faculty. Allows image selection, input validation, and database interaction.

- **DBHandler.java:** Manages the SQLite database, including creating, upgrading, adding, updating, and deleting faculty records.

- **Faculty.java:** Defines the `Faculty` class with attributes corresponding to the information stored for each faculty.

- **ListFacultyActivity.java:** Displays a list of faculties using a custom cursor adapter. Provides options for calling, sending SMS, and sending emails.

- **MainActivity.java:** The main activity that serves as the entry point. It includes a navigation drawer for easy navigation.

- **MyCursorAdapter.java:** A custom cursor adapter to bind data to the list view in `ListFacultyActivity`.

## UI Customization

- **Colors:** The app uses a color scheme that complements the University of Boumerdès brand.

- **Fonts:** Standard Android fonts are used for simplicity and readability.

Feel free to explore, contribute, and enhance the app further!
