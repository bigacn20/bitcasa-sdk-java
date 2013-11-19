Bitcasa SDK for Java 6+
===============

Bitcasa SDK for Java, providing access to Bitcasa's REST API.

License: MIT

Requirements:
* Java 6+

Building
===============

### Eclipse

To build from Eclipse, simply import the project into your workspace
as an existing project.

Get A Bitcasa Developer API Key
===============
In order to access the API successfully, you need to first get an API key from Bitcasa.
* Go to: [https://developer.bitcasa.com/](https://developer.bitcasa.com/)
* Either sign up with your Bitcasa account, or log in with it
* Click "Console" on the top header, and "Create App" on the top right
* Save your Client ID and your Client Secret locally; you will use them in your code


Using The Bitcasa API
===============
In order to access a Bitcasa user's files, you'll need to do authorize your application with the user via OAuth2. Once completed, you'll gain an access token that you can utilize for API usage.

Example
===============
In the example folder is Main.java, which provides an example of getting auth code and access token then list the content of the root file system.

* Once the project is imported into your workspace
* Create a new Java Project
* Configure the build path and add the imported project
* or add all the jars in the lib folder
* Copy the Main.java file from the example folder to the new project's src folder

Authenticate
===============
```java
bitcasaClient = new BitcasaClient(CLIENT_ID, CLIENT_SECRET);
bitcasaClient.getAuthenticateUrl();
```

Go to the generated URL and sign into your Bitcasa account.  The authorization_code will be appended to the end of the redirected URL.  

```java
String accessToken = bitcasaClient.requestForAccessToken(AUTHORIZATION_TOKEN);
```

You can then save the access token for future calls.
