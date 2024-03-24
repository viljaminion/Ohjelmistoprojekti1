## REST-dokumentaatio

Endpointtien autentikointia ei ole vielä tässä vaiheessa määritelty.

Alla olevat endpointit ovat suppea versio REST-dokumentaatiosta.


**EventControllerin endpointit selaimessa:**

- Tapahtuman listanäkymä: "/eventlist"
- Tapahtuman lisäys: "/events/add"
- Tapahtuman tallennus: "/events/save"
- Tapahtuman poisto: "/events/delete/{id}"
- Tapahtuman muokkaus: "/events/edit/{id}"
- Tapahtumaan lipputyypin lisääminen: "/events/{eventId}/addTicketType"
- Tapahtuman lipputyypin tallentaminen: "/events/{eventId}/saveTicketType" <!--tarviiko nää kaks vikaa olla tässä-->

**EventRestControllerin endpointit (Postman):**

Kaikki tapahtumat JSON-muodossa: GET /events
-	URL: /events/
-	Method: GET
-	Auth required: YES
-	Permission required: None

Success Responses
-	Condition: User can see events
-	Code:  200 OK
-	Content: List of events

[ {
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

- Tietyn tapahtuman tiedot ID:n avulla: <span style="color:green">GET</span> "/event/{id}"
- Tapahtuman lisäys Postmanilla: <span style="color:yellow">POST</span> "/events"
- Tapahtuman poisto Postmanilla: <span style="color:red">DELETE</span> "/event/{id}"


**TicketTypeControllerin endpointit selaimessa:**

- Listanäkymä: "/tickettypelist"
- Lisäys: "/tickettypes/add"
- Tallennus: "/tickettypes/save"
- Poisto: "tickettypes/delete/{id}"
- Muokkaus: "/editTicketType/{id}"

**TicketTypeRestControllerin endpointit (Postman):**

- Kaikki tiedot JSON-muodossa:
<span style="color:green">GET</span> "/tickettypes"
- Tietyn lipputyypin tiedot ID:n avulla:
<span style="color:green">GET</span> "/tickettype/{id}"
- Lipputyypin lisäys Postmanilla:
<span style="color:yellow">POST</span> "/tickettypes"
- Lipputyypin poisto Postmanilla:
<span style="color:red">DELETE</span> "/tickettype/{id}"


**TransactionControllerin endpointit selaimessa:**

- Ostotapahtumalistaus: "/transactionlist"
- Ostotapahtuman lisäys: "/transactions/add"
- Ostotapahtuman tallennus: "/transactions/save"
- Ostoapahtuman poisto: "/transactions/delete/{id}"
- Ostotapahtuman muokkaus: "/editTransaction/{id}"  <!--täytyy vielä vikana tarkistaa tarviiko korjata-->

**TransactionRestControllerin endpointit (Postman)**

- Kaikki tiedot JSON-muodossa: <span style="color:green">GET</span> "/transactions"
- Tietyn ostotapahtuman tiedot ID:n avulla: <span style="color:green">GET</span> "/transaction/{id}"
- Ostoapahtuman lisäys Postmanilla: <span style="color:yellow">POST</span> "/transactions"
- Ostotapahtuman poisto Postmanilla: <span style="color:red">DELETE</span> "/transaction/{id}"

**SellerControllerin endpointit selaimessa:**

- Lista myyjistä: "/sellerlist"
- Myyjän lisäys: "/sellers/add"
- Myyjän tietojen tallennus: "/sellers/save"
- Myyjän tietojen muokkaaminen: "sellers/edit/{id}"
- Myyjän tietojen poistaminen: "sellers/delete/{id}

**SellerRestControllerin endpointit (Postman)**

- Kaikki tiedot JSON-muodossa: <span style="color:green">GET</span> "/sellers"
- Tietyn myyjän tiedot ID:n avulla: <span style="color:green">GET</span> "/seller/{id}"
- Myyjän tietojen lisääminen Postmanilla: <span style="color:yellow">POST</span> "/sellers"
- Myyjän poisto Postmanilla: <span style="color:red">DELETE</span> "/seller/{id}"

**TicketControllerin endpointit selaimessa:**

- Lista lipuista: "/ticketlist"
- Lipun lisäys: "/tickets/add"
- Lipun tietojen tallennus: "/tickets/save"
- Lipun tietojen muokkaaminen: "tickets/edit/{id}"
- Lipun tietojen poistaminen: "tickets/delete/{id}

**TicketRestControllerin endpointit (Postman)**

- Kaikki tiedot JSON-muodossa: <span style="color:green">GET</span> "/tickets"
- Tietyn myyjän tiedot ID:n avulla: <span style="color:green">GET</span> "/tickets/{id}"
- Myyjän tietojen lisääminen Postmanilla: <span style="color:yellow">POST</span> "/tickets"
- Myyjän poisto Postmanilla: <span style="color:red">DELETE</span> "/tickets/{id}"

