# REST-dokumentaatio

## Tapahtumien endpointit (Postman):

**Kaikki tapahtumat JSON-muodossa: GET /events**
-	URL: /events/
-	Method: GET
-	Auth required: YES
-	Permission required: None

Success Responses
-	Condition: User can see events
-	Code:  200 OK
-	Content: List of events

```
[
    {
        "eventname": "Ankkarock",
        "address": "Lintukatu 1",
        "showtime": "2024-03-11T18:11:00",
        "description": "upea tilaisuus",
        "maxtickets": 111,
        "duration": 11,
        "id": 1
    },
    {
        "eventname": "Ruisrock",
        "address": "Rokkikatu 1",
        "showtime": "2024-10-11T18:11:00",
        "description": "upea juttu",
        "maxtickets": 567,
        "duration": 123,
        "id": 2
    }
]
```

**Tietyn tapahtuman tiedot ID:n avulla: GET /event/{id}**
-	URL:/event/{id}
-	Method: GET
-	Auth required: YES
-	Permission required: None

Success Responses
-	Condition: User can see event by id number
-	Code:  200 OK
-	Content: Shows event based on id number

```
{
    "eventname": "Ankkarock",
    "address": "Lintukatu 1",
    "showtime": "2024-03-11T18:11:00",
    "description": "upea tilaisuus",
    "maxtickets": 111,
    "duration": 11,
    "id": 1
}
```

**Tapahtuman lisäys Postmanilla: POST /events**
-	URL:/event/{id}
-	Method: POST
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can add an event
-	Code:  200 OK
-	Content: Adds an new event

```
{
    "eventname": "Sorsarock",
    "address": "Lintukatu 6",
    "showtime": "2024-03-11T18:12:00",
    "description": "siisti tilaisuus",
    "maxtickets": 200,
    "duration": 120
}
```

**Tapahtuman poisto Postmanilla: DELETE /event/{id}**
-	URL:/event/{id}
-	Method: DELETE
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can delete an event by id number
-	Code:  200 OK
-	Content: Deletes an event

```
Event with ID Optional[Event [eventId=6, eventname=Ilosaarirock, address=Rokkikatu 9, showtime=2024-11-11T18:11, description=upeampi juttu, maxTickets=568, duration=126]] has been deleted.
```

## Lipputyyppien endpointit (Postman):

**Kaikki lipputyypit JSON-muodossa: GET /tickettypes**

-	URL: /tickettypes/
-	Method: GET
-	Auth required: YES
-	Permission required: None

Success Responses
-	Condition: User can see ticket types
-	Code:  200 OK
-	Content: List of ticket types

```
[
    {
        "tickettypename": "aikuisten lippu",
        "price": 20.0,
        "event": {
            "eventname": "Ankkarock",
            "address": "Lintukatu 1",
            "showtime": "2024-03-11T18:11:00",
            "description": "upea tilaisuus",
            "maxtickets": 111,
            "duration": 11,
            "id": 1
        },
        "id": 1
    },
    {
        "tickettypename": "lasten lippu",
        "price": 10.0,
        "event": {
            "eventname": "Ankkarock",
            "address": "Lintukatu 1",
            "showtime": "2024-03-11T18:11:00",
            "description": "upea tilaisuus",
            "maxtickets": 111,
            "duration": 11,
            "id": 1
        },
        "id": 2
    }
]
```

**Tietyn lipputyypin tiedot ID:n avulla: GET /tickettype/{id}**
-	URL:/tickettype/{id}
-	Method: GET
-	Auth required: YES
-	Permission required: None

Success Responses
-	Condition: User can see ticket type by id number
-	Code:  200 OK
-	Content: Shows ticket type based on id number

```
{
    "tickettypename": "aikuisten lippu",
    "price": 20.0,
    "event": {
        "eventname": "Ankkarock",
        "address": "Lintukatu 1",
        "showtime": "2024-03-11T18:11:00",
        "description": "upea tilaisuus",
        "maxtickets": 111,
        "duration": 11,
        "id": 1
        },
    "id": 1
}
```

**Lipputyypin lisäys Postmanilla: POST /tickettypes**

-	URL:/tickettypes/
-	Method: POST
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can add ticket types
-	Code:  200 OK
-	Content: Adds an new ticket type

```
{
    "tickettypename": "lasten lippu",
    "price": 20.0,
    "event": {
        "id": 1
    }
}
```

**Lipputyypin poisto Postmanilla: DELETE /tickettype/{id}**
-	URL:/tickettype/{id}
-	Method: DELETE
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can delete a ticket type by id number
-	Code:  200 OK
-	Content: Deletes a ticket type

```
Ticket type with ID Optional[TicketType [ticketTypeId=4, ticketTypeName=eläkeläislippu, price=15.0]] has been deleted.
```

## Ostotapahtuman endpointit (Postman)

**Kaikki tiedot JSON-muodossa: GET /transactions**

-	URL: /transactions
-	Method: GET
-	Auth required: YES
-	Permission required: NO

Success Responses
-	Condition: User can see all the transactions
-	Code:  200 OK
-	Content: List of transactions

```
[
    {
        "transactiondate": "2024-03-08",
        "ticketsum": 99.0,
        "tickets": [
            {
                "ticketnumber": "907",
                "ticketType": {
                    "tickettypename": "aikuisten lippu",
                    "price": 20.0,
                    "event": {
                        "eventname": "Ankkarock",
                        "address": "Lintukatu 1",
                        "showtime": "2024-03-11T18:11:00",
                        "description": "upea tilaisuus",
                        "maxtickets": 111,
                        "duration": 11,
                        "id": 1
                    },
                    "id": 1
                },
                "id": 1
            },
            {
                "ticketnumber": "587",
                "ticketType": {
                    "tickettypename": "lasten lippu",
                    "price": 10.0,
                    "event": {
                        "eventname": "Ankkarock",
                        "address": "Lintukatu 1",
                        "showtime": "2024-03-11T18:11:00",
                        "description": "upea tilaisuus",
                        "maxtickets": 111,
                        "duration": 11,
                        "id": 1
                    },
                    "id": 2
                },
                "id": 2
            }
        ],
        "id": 1
    }
]
```

**Tietyn ostotapahtuman tiedot ID:n avulla: GET /transaction/{id}**

-	URL: /transaction/{id}
-	Method: GET
-	Auth required: YES
-	Permission required: NO

Success Responses
-	Condition: User can see transaction by id number
-	Code:  200 OK
-	Content: Shows transaction based on id number

```
{
    "transactiondate": "2024-03-08",
    "ticketsum": 99.0,
    "tickets": [
        {
            "ticketnumber": "907",
            "ticketType": {
                "tickettypename": "aikuisten lippu",
                "price": 20.0,
                "event": {
                    "eventname": "Ankkarock",
                    "address": "Lintukatu 1",
                    "showtime": "2024-03-11T18:11:00",
                    "description": "upea tilaisuus",
                    "maxtickets": 111,
                    "duration": 11,
                    "id": 1
                },
                "id": 1
            },
            "id": 1
        },
        {
            "ticketnumber": "587",
            "ticketType": {
                "tickettypename": "lasten lippu",
                "price": 10.0,
                "event": {
                    "eventname": "Ankkarock",
                    "address": "Lintukatu 1",
                    "showtime": "2024-03-11T18:11:00",
                    "description": "upea tilaisuus",
                    "maxtickets": 111,
                    "duration": 11,
                    "id": 1
                },
                "id": 2
            },
            "id": 2
        }
    ],
    "id": 1
}
```

**Ostotapahtuman lisäys Postmanilla: POST /transactions**

-	URL:/transactions
-	Method: POST
-	Auth required: YES
-	Permission required: NO

Success Responses
-	Condition: User can add a new transaction
-	Code:  200 OK
-	Content: Adds a new transaction

```
{
  "transactiondate": "2024-03-08",
  "ticketsum": 99.00,
  "tickets": [
    { "id": 1 },
    { "id": 2 }
  ]
}

```

**Ostotapahtuman poisto Postmanilla: DELETE /transaction/{id}**

-	URL:/transaction/{id}
-	Method: DELETE
-	Auth required: YES
-	Permission required: NO

Success Responses
-	Condition: User can delete a transaction by id number
-	Code:  200 OK
-	Content: Deletes a transaction by id number 

```
Transaction with ID Optional[Transaction [transactionid=6, transactiondate=2024-03-03, ticketSum=55.0, seller=null, ticket=null]] has been deleted.
```

## Käyttäjän endpointit (Postman)

**Kaikki tiedot JSON-muodossa: GET /users**
-	URL: /users
-	Method: GET
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can see all the users
-	Code:  200 OK
-	Content: List of users

```
[
    {
        "username": "maija",
        "passwordhash": "$2a$10$6KFw5bwNuXu1Mr80yXcglOCEI9cmSlQlSRJK.D6.XvKbaos5LC7By",
        "role": "USER",
        "firstname": "Maija",
        "surname": "Meikäläinen",
        "address": "Postiosoite 1A",
        "phone": "0441234567",
        "email": "maijameikalainen@gmail.com"
    },
    {
        "username": "mikko",
        "passwordhash": "$2a$10$/U9C/cQ7sudkeFkJS7OUwOfbIoWEzQPLeMd7cI8RgSfxChyKkNeVu",
        "role": "ADMIN",
        "firstname": "Mikko",
        "surname": "Meikäläinen",
        "address": "Postiosoite 1A",
        "phone": "0447654321",
        "email": "mikkomeikalainen@gmail.com"
    }
]
```

**Tietyn käyttäjän tiedot ID:n avulla: GET /user/{id}**
-	URL:/user/{id}
-	Method: GET
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can see user by id number
-	Code:  200 OK
-	Content: Shows a user by id number 

```
{
    "username": "maija",
    "passwordhash": "$2a$10$6KFw5bwNuXu1Mr80yXcglOCEI9cmSlQlSRJK.D6.XvKbaos5LC7By",
    "role": "USER",
    "firstname": "Maija",
    "surname": "Meikäläinen",
    "address": "Postiosoite 1A",
    "phone": "0441234567",
    "email": "maijameikalainen@gmail.com"
}
```

**Käyttäjän tietojen lisääminen Postmanilla: POST /users**
-	URL:/users
-	Method: POST
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can add a new user
-	Code:  200 OK
-	Content: Adds a new user 

```
{
    "username": "maija",
    "passwordhash": "$2a$10$6KFw5bwNuXu1Mr80yXcglOCEI9cmSlQlSRJK.D6.XvKbaos5LC7By",
    "role": "USER",
    "firstname": "Maija",
    "surname": "Meikäläinen",
    "address": "Postiosoite 1A",
    "phone": "0441234567",
    "email": "maijameikalainen@gmail.com"
}
```

**Myyjän poisto Postmanilla: DELETE /user/{id}**
-	URL:/user/{id}
-	Method: DELETE
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can delete a user by id number
-	Code:  200 OK
-	Content: Deletes a user by id number 

```
User with ID Optional[User [id=3, username=maiju, passwordhash=$2a$10$6KFw5bwNuXu1Mr80yXcglOCEI9cmSlQlSRJK.D6.XvKbaos5LC7By, role=USER, firstname=Maija, surname=Meikäläinen, useraddress=Postiosoite 1A, userphone=0441234567, useremail=maijameikalainen@gmail.com, transactions=[]]] has been deleted.
```

## Lippujen endpointit (Postman)

**Kaikki tiedot JSON-muodossa: <span style="color:green">GET</span> /tickets**
-	URL: /tickets
-	Method: GET
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can see all the tickets
-	Code:  200 OK
-	Content: List of tickets

```
[
    {
        "ticketcode": "64613232-6530-3462-2d66-6266662d3131",
        "used": null,
        "transaction": {
            "transactiondate": "2024-03-08",
            "ticketsum": 50.0,
            "id": 1
        },
        "ticketType": {
            "tickettypename": "aikuisten lippu",
            "price": 20.0,
            "event": {
                "eventname": "Ankkarock",
                "address": "Lintukatu 1",
                "showtime": "2024-03-11T18:11:00",
                "description": "upea tilaisuus",
                "maxtickets": 111,
                "duration": 11,
                "id": 1
            },
            "id": 1
        },
        "id": 1
    },
    {
        "ticketcode": "e2809ec3-b3c3-867d-c3b4-7e44c3b3c2b0",
        "used": null,
        "transaction": {
            "transactiondate": "2024-03-08",
            "ticketsum": 50.0,
            "id": 1
        },
        "ticketType": {
            "tickettypename": "lasten lippu",
            "price": 10.0,
            "event": {
                "eventname": "Ankkarock",
                "address": "Lintukatu 1",
                "showtime": "2024-03-11T18:11:00",
                "description": "upea tilaisuus",
                "maxtickets": 111,
                "duration": 11,
                "id": 1
            },
            "id": 2
        },
        "id": 2
    }
]
```

**Tietyn lipun tiedot ID:n avulla: <span style="color:green">GET</span> /tickets/{id}**
-	URL:/tickets/{id}
-	Method: GET
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can see ticket by id number
-	Code:  200 OK
-	Content: Shows a ticket by id number 

```
{
    "ticketcode": "64613232-6530-3462-2d66-6266662d3131",
    "used": "2023-11-07T07:03:46",
    "transaction": {
        "transactiondate": "2024-03-08",
        "ticketsum": 50.0,
        "id": 1
    },
    "ticketType": {
        "tickettypename": "aikuisten lippu",
        "price": 20.0,
        "event": {
            "eventname": "Ankkarock",
            "address": "Lintukatu 1",
            "showtime": "2024-03-11T18:11:00",
            "description": "upea tilaisuus",
            "maxtickets": 111,
            "duration": 11,
            "id": 1
        },
        "id": 1
    },
    "id": 1
}
```

**Lipun tietojen päivittäminen Postmanilla: <span style="color:purple">PATCH</span> /tickets/{id}**
-	URL:/tickets/{id}
-	Method: PATCH
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can update a ticket
-	Code:  200 OK
-	Content: Adds a new ticket

```
{ 
    "used": "2023-11-07T07:03:46"
}
```
```
Ticket with ID 2 has been updated.
```

**Lipun lisääminen Postmanilla: <span style="color:yellow">POST</span> /tickets**
-	URL:/tickets
-	Method: POST
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can add a new ticket
-	Code:  200 OK
-	Content: Adds a new ticket

```
{
   "transaction": { "id": 1 },
   "ticketType": { "id": 1 }
}
```

**Lipun poisto Postmanilla: <span style="color:red">DELETE</span> /ticket/{id}**
-	URL:/ticket/{id}
-	Method: DELETE
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can delete a ticket by id number
-	Code:  200 OK
-	Content: Deletes a ticket by id number 

```
Ticket with ID Optional[Seller [ticketid=3,  ticketnumber=3333, transaction=null, ticketType=null]] has been deleted.
```

