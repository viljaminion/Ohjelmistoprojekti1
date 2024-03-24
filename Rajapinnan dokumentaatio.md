# REST-dokumentaatio

Endpointtien autentikointia ei ole vielä tässä vaiheessa määritelty.

Alla olevat endpointit ovat suppea versio REST-dokumentaatiosta.


## EventControllerin endpointit selaimessa:

- Tapahtuman listanäkymä: "/eventlist"
- Tapahtuman lisäys: "/events/add"
- Tapahtuman tallennus: "/events/save"
- Tapahtuman poisto: "/events/delete/{id}"
- Tapahtuman muokkaus: "/events/edit/{id}"
- Tapahtumaan lipputyypin lisääminen: "/events/{eventId}/addTicketType"
- Tapahtuman lipputyypin tallentaminen: "/events/{eventId}/saveTicketType" <!--tarviiko nää kaks vikaa olla tässä-->

## EventRestControllerin endpointit (Postman):

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
        "maxTickets": 111,
        "duration": 11,
        "ticketTypes": [],
        "id": 1
    },
    {
        "eventname": "Ruisrock",
        "address": "Rokkikatu 1",
        "showtime": "2024-10-11T18:11:00",
        "description": "upea juttu",
        "maxTickets": 567,
        "duration": 123,
        "ticketTypes": [],
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
    "eventname": "Ruisrock",
    "address": "Rokkikatu 1",
    "showtime": "2024-10-11T18:11:00",
    "description": "upea juttu",
    "maxTickets": 567,
    "duration": 123,
    "ticketTypes": [],
    "id": 4
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
    "eventname": "Ilosaarirock",
    "address": "Rokkikatu 9",
    "showtime": "2024-11-11T18:11:00",
    "description": "upeampi juttu",
    "maxTickets": 568,
    "duration": 126,
    "ticketTypes": null,
    "id": 6
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

## TicketTypeControllerin endpointit selaimessa:

- Listanäkymä: "/tickettypelist"
- Lisäys: "/tickettypes/add"
- Tallennus: "/tickettypes/save"
- Poisto: "tickettypes/delete/{id}"
- Muokkaus: "/editTicketType/{id}"

## TicketTypeRestControllerin endpointit (Postman):

- Kaikki tiedot JSON-muodossa:
<span style="color:green">GET</span> "/tickettypes"
- Tietyn lipputyypin tiedot ID:n avulla:
<span style="color:green">GET</span> "/tickettype/{id}"
- Lipputyypin lisäys Postmanilla:
<span style="color:yellow">POST</span> "/tickettypes"
- Lipputyypin poisto Postmanilla:
<span style="color:red">DELETE</span> "/tickettype/{id}"


## TransactionControllerin endpointit selaimessa:

- Ostotapahtumalistaus: "/transactionlist"
- Ostotapahtuman lisäys: "/transactions/add"
- Ostotapahtuman tallennus: "/transactions/save"
- Ostoapahtuman poisto: "/transactions/delete/{id}"
- Ostotapahtuman muokkaus: "/editTransaction/{id}"  <!--täytyy vielä vikana tarkistaa tarviiko korjata-->

## TransactionRestControllerin endpointit (Postman)

- Kaikki tiedot JSON-muodossa: <span style="color:green">GET</span> "/transactions"
- Tietyn ostotapahtuman tiedot ID:n avulla: <span style="color:green">GET</span> "/transaction/{id}"
- Ostoapahtuman lisäys Postmanilla: <span style="color:yellow">POST</span> "/transactions"
- Ostotapahtuman poisto Postmanilla: <span style="color:red">DELETE</span> "/transaction/{id}"

## SellerControllerin endpointit selaimessa:

- Lista myyjistä: "/sellerlist"
- Myyjän lisäys: "/sellers/add"
- Myyjän tietojen tallennus: "/sellers/save"
- Myyjän tietojen muokkaaminen: "sellers/edit/{id}"
- Myyjän tietojen poistaminen: "sellers/delete/{id}

## SellerRestControllerin endpointit (Postman)

**Kaikki tiedot JSON-muodossa: GET /sellers**
-	URL: /sellers
-	Method: GET
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can see all the sellers
-	Code:  200 OK
-	Content: List of sellers

```
[
    {
        "sellerfirstname": "Marja",
        "sellersurname": "Mäki",
        "selleraddress": "Mäkikatu 7",
        "sellerphone": "05098764",
        "selleremail": "marja@maki.fi",
        "transactions": [],
        "id": 1
    },
    {
        "sellerfirstname": "Heikki",
        "sellersurname": "Mäki",
        "selleraddress": "Mäkikatu 8",
        "sellerphone": "05098799",
        "selleremail": "heikki@maki.fi",
        "transactions": [],
        "id": 2
    }
]
```

**Tietyn myyjän tiedot ID:n avulla: GET /seller/{id}**
-	URL:/seller/{id}
-	Method: GET
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can see seller by id number
-	Code:  200 OK
-	Content: Shows a seller by id number 

```
{
    "sellerfirstname": "Heikki",
    "sellersurname": "Mäki",
    "selleraddress": "Mäkikatu 8",
    "sellerphone": "05098799",
    "selleremail": "heikki@maki.fi",
    "transactions": [],
    "id": 2
}
```

**Myyjän tietojen lisääminen Postmanilla: POST /sellers**
-	URL:/sellers
-	Method: POST
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can add a new seller
-	Code:  200 OK
-	Content: Adds a new seller 

```
{
    "sellerfirstname": "Marja",
    "sellersurname": "Mäki",
    "selleraddress": "Mäkikatu 7",
    "sellerphone": "05098764",
    "selleremail": "marja@maki.fi",
    "transactions": [],
    "id": 1
}
```

**Myyjän poisto Postmanilla: DELETE /seller/{id}**
-	URL:/seller/{id}
-	Method: DELETE
-	Auth required: YES
-	Permission required: YES

Success Responses
-	Condition: Admin can delete a seller by id number
-	Code:  200 OK
-	Content: Deletes a seller by id number 

```
Seller with ID Optional[Seller [sellerid=2, sellerfirstname=Heikki, sellersurname=Mäki, selleraddress=Mäkikatu 8, sellerphone=05098799, selleremail=heikki@maki.fi, transactions=[]]] has been deleted.
```

## TicketControllerin endpointit selaimessa:

- Lista lipuista: "/ticketlist"
- Lipun lisäys: "/tickets/add"
- Lipun tietojen tallennus: "/tickets/save"
- Lipun tietojen muokkaaminen: "tickets/edit/{id}"
- Lipun tietojen poistaminen: "tickets/delete/{id}

## TicketRestControllerin endpointit (Postman)



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
        "ticketnumber": "123",
        "transaction": null,
        "ticketType": null,
        "id": 1
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
    "ticketnumber": "123",
    "transaction": null,
    "ticketType": null,
    "id": 1
}
```

**Lipun tietojen lisääminen Postmanilla: <span style="color:yellow">POST</span> /tickets**
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
    "ticketnumber": "123",
    "transaction": null,
    "ticketType": null
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
Ticket with ID Optional[Ticket [ticketid=1,  ticketnumber=123, transaction=null, ticketType=null]] has been deleted.
```

