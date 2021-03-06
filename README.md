# Spring-Twitter-Bot
Simple Java Spring based twitter bot.
### Prereqs
You need to have created a twitter developers account.
There you will be able to get the API and consumer keys that are needed.

### What to change.
`application.yml`
`twitter4j.properties`
`tweets.txt`
`pom.xml` -> <plugins>
 
 The pom.xml currently holds the configuration needed if you are using Azure to deploy your application.
 If you don't deploy you application to the cloud, you will need to run it locally meaning that you cannot turn your computer off as
 it will kill the app.
 
 a.k.a - best to deploy to a cloud provider.

##### Note: They all have been outlined within the files where to change.
### Current Status
The bot will post a tweet every `4 hours` from the `tweets.txt` file. This can easily be 
amended in the`TwitterBotReadLinesServiceImpl` by selecting from the pre-made timings, 
- five minutes
-  thirty minutes
- hourly
- every 4 hours
- daily

You can easily add your own timings by following the structure in the `application.yml`.
#### ***Note: The timings are calculated in milliseconds.***

## Starting the application
`mvn -U clean install`
`mvn spring-boot:run`
Once the application is spun up you need to hit the exposed endpoint. This will vary depending on where you are deploying.
If running locally:
`localhost:8080/startApp`
It will then start the processing.

## Common errors
`503 - Duplicate Message`
The tweet that you are trying to second already exists on twitter, this is probably because you 
re-ran the application without removing the old tweets.
#### Solutions:
- Remove the old tweets from the `tweets.txt`
- Manually delete from twitter profile.

### Things to implement
 Bot is functional but I want to expand on its functionality in the future. Feel free 
 to fork and give it a go.
 - [ ] Like tweets based in #'s.
 - [ ] Comment on tweets based on #'s.
 - [ ] Find trends
 - [ ] No manual tweet insertion:
    - [ ] Search the internet for tweets.
    - [ ] Post images from the internet.
    
###### Probably wont do all but would be pretty cool to have.

### Bugs and Issue Management
If you encounter a bug please raise on GitHub and I will try to fix ASAP.
Bug Structure:
- Is it repeatable?
- App breaking?
- Describe what you did
 
